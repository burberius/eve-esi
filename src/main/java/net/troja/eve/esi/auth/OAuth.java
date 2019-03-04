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

    private String codeVerifier;
    private AccountData account;
    private static final Map<String, AccountData> ACCOUNTS = new ConcurrentHashMap<>();

    @Override
    public void applyToParams(final List<Pair> queryParams, final Map<String, String> headerParams) {
        // Add auth
        AccountData accountData = getAccountData();
        if (accountData != null) {
            headerParams.put("Authorization", "Bearer " + accountData.getAccessToken());
        }
    }

    public void setAccessToken(final String accessToken) {
        if (account == null) {
            account = new AccountData("", "");
        }
        account.setAccessToken(accessToken);
    }

    public String getRefreshToken() {
        if (account != null) {
            return account.getRefreshToken();
        } else {
            return null;
        }
    }

    public String getClientId() {
        if (account != null) {
            return account.getClientId();
        } else {
            return null;
        }
    }

    public void setAuth(final String clientId, final String refreshToken) {
        final String authKey = clientId + refreshToken;
        AccountData accountData = ACCOUNTS.get(authKey);
        if (accountData == null) {
            accountData = new AccountData(clientId, refreshToken);
            ACCOUNTS.put(authKey, accountData);
        }
        if (account != null) {
            accountData.setAccessToken(account.getAccessToken());
        }
        account = accountData;
    }

    public void setClientId(final String clientId) {
        setAuth(clientId, null);
    }

    public String getAccessToken() {
        AccountData accessTokenData = getAccountData();
        if (accessTokenData != null) {
            return accessTokenData.getAccessToken();
        } else {
            return null;
        }
    }

    /**
     * Get JWT (JSON Web Token) WARNING: The JWT is unverified. Verifying the
     * JWT is beyond the scope of this library. As ESI will verify the token
     * when used. See the SSO documentation for JWT Token validation for
     * details:
     * https://github.com/ccpgames/eveonline-third-party-documentation/blob/master/docs/sso/jwt-validation.md
     * 
     * @return Unverified JWT or null
     */
    public JWT getJWT() {
        AccountData accountData = getAccountData(); // Update access token if needed;
        if (accountData == null) {
            return null;
        }
        try {
            String accessToken = accountData.getAccessToken();
            String[] parts = accessToken.split("\\.");
            if (parts.length != 3) {
                return null;
            }
            ObjectMapper objectMapper = new ObjectMapper();
            JWT.Header header = objectMapper.readValue(new String(Base64.getUrlDecoder().decode(parts[0])),
                    JWT.Header.class);
            JWT.Payload payload = objectMapper.readValue(new String(Base64.getUrlDecoder().decode(parts[1])),
                    JWT.Payload.class);
            String signature = parts[2];
            return new JWT(header, payload, signature);
        } catch (IOException ex) {
            return null;
        }
    }

    private AccountData getAccountData() {
        if (account == null) {
            return null;
        } else {
            account.update();
            return account;
        }
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
        if (account == null) throw new IllegalArgumentException("Auth is not set");
        StringBuilder builder = new StringBuilder();
        builder.append(URI_AUTHENTICATION);
        builder.append("?");
        builder.append("response_type=");
        builder.append(encode("code"));
        builder.append("&redirect_uri=");
        builder.append(encode(redirectUri));
        builder.append("&client_id=");
        builder.append(encode(account.getClientId()));
        builder.append("&scope=");
        builder.append(encode(getScopesString(scopes)));
        builder.append("&state=");
        builder.append(encode(state));
        builder.append("&code_challenge");
        builder.append(getCodeChallenge()); // Already url encoded
        builder.append("&code_challenge_method=");
        builder.append(encode("S256"));
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
        if (account == null) throw new IllegalArgumentException("ClientID/Refresh Token is not set");
        StringBuilder builder = new StringBuilder();
        builder.append("grant_type=");
        builder.append(encode("authorization_code"));
        builder.append("&client_id=");
        builder.append(encode(account.getClientId()));
        builder.append("&code=");
        builder.append(encode(code));
        builder.append("&code_verifier=");
        builder.append(encode(codeVerifier));
        update(account, builder.toString());
    }

    private static void refreshToken(AccountData accountData) throws ApiException {
        StringBuilder builder = new StringBuilder();
        builder.append("grant_type=");
        builder.append(encode("refresh_token"));
        builder.append("&client_id=");
        builder.append(encode(accountData.getClientId()));
        builder.append("&refresh_token=");
        builder.append(encode(accountData.getRefreshToken()));
        update(accountData, builder.toString());
    }

    private static void update(AccountData accountData, String urlParameters) throws ApiException {
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
            try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                String inputLine;
                response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
            }
            // read json
            ObjectMapper objectMapper = new ObjectMapper();
            Result result = objectMapper.readValue(response.toString(), Result.class);

            // set data
            String accessToken = result.getAccessToken();
            long validUntil = System.currentTimeMillis() + result.getExpiresIn() * 1000 - 5000;
            accountData.setAccessToken(accessToken);
            accountData.setValidUntil(validUntil);
            accountData.setRefreshToken(result.getRefreshToken());
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
        return scopesString.toString();
    }

    private static class AccountData {
        private final String clientId;
        private String refreshToken;
        private String accessToken;
        private long validUntil;

        public AccountData(String clientId, String refreshToken) {
            this.clientId = clientId;
            this.refreshToken = refreshToken;
        }

        public String getClientId() {
            return clientId;
        }

        public String getRefreshToken() {
            return refreshToken;
        }

        public String getAccessToken() {
            return accessToken;
        }

        public long getValidUntil() {
            return validUntil;
        }

        public void setRefreshToken(String refreshToken) {
            this.refreshToken = refreshToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        public void setValidUntil(long validUntil) {
            this.validUntil = validUntil;
        }

        private synchronized void update() {
            if (refreshToken != null && (accessToken == null || getValidUntil() < System.currentTimeMillis())) {
                try {
                    OAuth.refreshToken(this);
                } catch (final ApiException ex) {
                   // This error will be handled by ESI once the request is made
                }
            }
        }

        public String getKey() {
            return clientId + refreshToken;
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

    private static String encode(String parameter) {
        try {
            return URLEncoder.encode(parameter, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
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
