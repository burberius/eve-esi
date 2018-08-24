/**
 * EVE Swagger Interface
 * An OpenAPI for EVE Online
 */

package net.troja.eve.esi.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import javax.net.ssl.HttpsURLConnection;
import net.troja.eve.esi.ApiException;
import net.troja.eve.esi.Pair;


public class OAuth implements Authentication {
    private static final String URI_OAUTH = "https://login.eveonline.com/v2/oauth";
    private static final String URI_AUTHENTICATION = URI_OAUTH + "/authorize";
    private static final String URI_ACCESS_TOKEN = URI_OAUTH + "/token";
    private static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz-._~";
    private static final SecureRandom RND = new SecureRandom();
    private static final int LEN = 128;

    private String refreshToken;
    private String clientId;
    private String codeVerifier;
    private static final Map<String, AccessTokenData> ACCESS_TOKEN_CACHE = new ConcurrentHashMap<>();

    @Override
    public void applyToParams(final List<Pair> queryParams, final Map<String, String> headerParams) {
        // Add auth
        AccessTokenData accessTokenData = getAccessTokenData();
        if (accessTokenData != null) {
            headerParams.put("Authorization", "Bearer " + accessTokenData.getAccessToken());
        }
    }

    public void setAccessToken(final String accessToken) {
        ACCESS_TOKEN_CACHE.put(getAuthKey(), new AccessTokenData(accessToken, 0));
    }

    public void setRefreshToken(final String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public void setClientId(final String clientId) {
        this.clientId = clientId;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public String getClientId() {
        return clientId;
    }

    public String getAccessToken() {
        AccessTokenData accessTokenData = getAccessTokenData();
        if (accessTokenData != null) {
            return accessTokenData.getAccessToken();
        } else {
            return null;
        }
    }

    /**
     * Get JWT (JSON Web Token)
     * WARNING: The JWT is unverified.
     * Verifying the JWT is beyond the scope of this library.
     * As ESI will verify the token when used.
     * @return Unverified JWT or null
     */
    public JWT getJWT() {
        AccessTokenData accessTokenData = getAccessTokenData(); //Update access token if needed;
        if (accessTokenData == null) {
            return null;
        }
        try {
            String accessToken = accessTokenData.getAccessToken();
            String[] parts = accessToken.split("\\.");
            if (parts.length != 3) {
                return null;
            }
            ObjectMapper objectMapper = new ObjectMapper();
            JWT.Header header  = objectMapper.readValue(new String(Base64.getUrlDecoder().decode(parts[0])), JWT.Header.class);
            JWT.Payload payload = objectMapper.readValue(new String(Base64.getUrlDecoder().decode(parts[1])), JWT.Payload.class);
            String signature = parts[2];
            return new JWT(header, payload, signature);
        } catch (IOException ex) {
            return null;
        }
    }

    private AccessTokenData getAccessTokenData() {
        // Check if we need a new access token
        synchronized (OAuth.class) { // This block is synchronized across all
                                     // threads - so we don't update the access
                                     // token more than once
            AccessTokenData accessTokenData = ACCESS_TOKEN_CACHE.get(getAuthKey());
            if (refreshToken != null
                    && (accessTokenData == null || accessTokenData.getValidUntil() < System.currentTimeMillis())) {
                try {
                    refreshToken();
                } catch (final ApiException ex) {
                    // This error will be handled by ESI once the request is
                    // made
                }
            }
        }
        return ACCESS_TOKEN_CACHE.get(getAuthKey());
    }

    /**
     * Get the authorization uri, where the user logs in.
     *
     * @param redirectUri
     *            Uri the user is redirected to, after successful authorization.
     *            This must be the same as specified at the Eve Online developer
     *            page.
     * @param scopes
     *            Scopes of the Eve Online SSO.
     * @param state
     *            This should be some secret to prevent XRSF, please read:
     *            http://www.thread-safe.com/2014/05/the-correct-use-of-state-
     *            parameter-in.html
     * @return
     */
    public String getAuthorizationUri(final String redirectUri, final Set<String> scopes, final String state) {
        StringBuilder builder = new StringBuilder();
        builder.append(URI_AUTHENTICATION);
        builder.append("?");
        builder.append("response_type=code");
        builder.append("&redirect_uri=");
        builder.append(redirectUri);
        builder.append("&client_id=");
        builder.append(clientId);
        builder.append("&scope=");
        builder.append(getScopesString(scopes));
        builder.append("&state=");
        builder.append(state);
        builder.append("&code_challenge");
        builder.append(getCodeChallenge());
        builder.append("&code_challenge_method=S256");
        return builder.toString();
    }

    /**
     * Finish the oauth flow after the user was redirected back.
     *
     * @param code
     *            Code returned by the Eve Online SSO
     * @param state
     *            This should be some secret to prevent XRSF see
     *            getAuthorizationUri
     * @throws net.troja.eve.esi.ApiException
     */
    public void finishFlow(final String code, final String state) throws ApiException {
        try {
            StringBuilder builder = new StringBuilder();
            builder.append("grant_type=authorization_code");
            builder.append("&client_id=");
            builder.append(URLEncoder.encode(clientId, "UTF-8"));
            builder.append("&code=");
            builder.append(code);
            builder.append("&code_verifier=");
            builder.append(codeVerifier);
            update(builder.toString(), false);
        } catch (UnsupportedEncodingException ex) {
            throw new ApiException(ex);
        }
    }

    private void refreshToken() throws ApiException {
        try {
            StringBuilder builder = new StringBuilder();
            builder.append("grant_type=refresh_token");
            builder.append("&client_id=");
            builder.append(URLEncoder.encode(clientId, "UTF-8"));
            builder.append("&refresh_token=");
            builder.append(URLEncoder.encode(refreshToken, "UTF-8"));
            update(builder.toString(), false);
        } catch (UnsupportedEncodingException ex) {
            throw new ApiException(ex);
        }
    }

    /**
     * 
     * @param urlParameters
     * @param basic Temporary workaround for having to send basic auth when refreshing access tokens
     * @throws ApiException 
     */
    private void update(String urlParameters, boolean basic) throws ApiException {
        try {
            URL obj = new URL(URI_ACCESS_TOKEN);
            HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

            // add request header
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            con.setRequestProperty("Host", "login.eveonline.com");

            // Send post request
            con.setDoOutput(true);
            try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
                wr.writeBytes(urlParameters);
                wr.flush();
            }

            StringBuilder response;
            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()))) {
                String inputLine;
                response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
            }
            // read json
            ObjectMapper objectMapper = new ObjectMapper();
            Result result = objectMapper.readValue(response.toString(), Result.class);  

            //set data
            refreshToken = result.getRefreshToken();
            String accessToken = result.getAccessToken();
            long validUntil = System.currentTimeMillis() + result.getExpiresIn() * 1000 - 5000;
            ACCESS_TOKEN_CACHE.put(getAuthKey(), new AccessTokenData(accessToken, validUntil));
        } catch (MalformedURLException ex) {
            throw new ApiException(ex);
        } catch (IOException ex) {
            throw new ApiException(ex);
        }
    }

    private String getScopesString(final Set<String> scopes) {
        final StringBuilder scopesString = new StringBuilder();
        if (scopes != null) {
            for (final String scope : scopes) {
                if (scopesString.length() > 0) {
                    scopesString.append(' ');
                }
                scopesString.append(scope);
            }
        }
        try {
            return URLEncoder.encode(scopesString.toString(), "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            return null;
        }
    }

    private String getAuthKey() {
        return clientId + refreshToken;
    }

    private static class AccessTokenData {
        private final String accessToken;
        private final long validUntil;

        public AccessTokenData(final String accessToken, final long validUntil) {
            this.accessToken = accessToken;
            this.validUntil = validUntil;
        }

        public String getAccessToken() {
            return accessToken;
        }

        public long getValidUntil() {
            return validUntil;
        }
    }

    private String getCodeChallenge() {
        try {
            StringBuilder sb = new StringBuilder(LEN);
            for (int i = 0; i < LEN; i++) {
                sb.append(AB.charAt(RND.nextInt(AB.length())));
            }
            codeVerifier = sb.toString();
            byte[] ascii = codeVerifier.getBytes(StandardCharsets.US_ASCII);
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] sha = digest.digest(ascii);
            return Base64.getUrlEncoder().encodeToString(sha);
        } catch (NoSuchAlgorithmException ex) {
            return null;
        }
    }

    private static class Result {

        @JsonProperty("access_token")
        private String accessToken;
        @JsonProperty("expires_in")
        private Long expiresIn;
        @JsonProperty("token_type")
        private String tokenType;
        @JsonProperty("refresh_token")
        private String refreshToken;

        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        public Long getExpiresIn() {
            return expiresIn;
        }

        public void setExpiresIn(Long expiresIn) {
            this.expiresIn = expiresIn;
        }

        public String getTokenType() {
            return tokenType;
        }

        public void setTokenType(String tokenType) {
            this.tokenType = tokenType;
        }

        public String getRefreshToken() {
            return refreshToken;
        }

        public void setRefreshToken(String refreshToken) {
            this.refreshToken = refreshToken;
        }
    }
}
