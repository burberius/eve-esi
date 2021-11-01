/**
 * EVE Swagger Interface
 * An OpenAPI for EVE Online
 */

package net.troja.eve.esi.auth;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.SerializedName;
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
    public void applyToParams(List<Pair> queryParams, Map<String, String> headerParams, Map<String, String> cookieParams) {
        // Add auth
        AccountData accountData = getAccountData();
        if (accountData != null) {
            headerParams.put("Authorization", "Bearer " + accountData.getAccessToken());
        }
    }

    public void setAccessToken(final String accessToken) {
        if (account == null) {
            account = new AccountData(null, null, null);
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

    public String getClientSecret() {
        if (account != null) {
            return account.getClientSecret();
        } else {
            return null;
        }
    }

    private boolean isNativeFlow() {
        if (account != null) {
            return account.isNativeFlow();
        } else {
            return true;
        }
    }

    /**
     * Native flow (No client secret/PKCE).
     * Note: You should use the ApiClientBuilder class instead of setting the auth here
     * Docs: https://docs.esi.evetech.net/docs/sso/native_sso_flow.html
     * @param clientId
     * @param refreshToken
     */
    public void setAuthNative(final String clientId, final String refreshToken) {
        setAuthInner(clientId, null, refreshToken);
    }

    /**
     * Web flow (with client secret).
     * Note: You should use the ApiClientBuilder class instead of setting the auth here
     * Docs: https://docs.esi.evetech.net/docs/sso/web_based_sso_flow.html
     * @param clientId
     * @param clientSecret
     * @param refreshToken
     */
    public void setAuthWeb(final String clientId, String clientSecret, final String refreshToken) {
        setAuthInner(clientId, clientSecret, refreshToken);
    }

    /**
     * setAuth() method has been replaced by setAuthNative() and setAuthWeb().
     * Note: You should use the ApiClientBuilder class instead of setting the auth here
     * @param clientId
     * @param clientSecret
     * @param refreshToken
     */
    @Deprecated
    public void setAuth(final String clientId, String clientSecret, final String refreshToken) {
        throw new IllegalStateException("setAuth() method has been replaced by by setAuthNative() and setAuthWeb(). Using the ApiClientBuilder class is recommended.");
    }

    /**
     * setClientId() method has been replaced by setAuthNative() and setAuthWeb().
     * Note: You should use the ApiClientBuilder class instead of setting the auth here
     * @param clientId 
     */
    @Deprecated
    public void setClientId(final String clientId) {
        throw new IllegalStateException("setClientId() method has been replaced by setAuthNative() and setAuthWeb(). Using the ApiClientBuilder class is recommended.");
    }

    private void setAuthInner(final String clientId, String clientSecret, final String refreshToken) {
        AccountData accountData = new AccountData(clientId, clientSecret, refreshToken);
        AccountData old = ACCOUNTS.putIfAbsent(accountData.getKey(), accountData);
        if (old != null) {
            accountData = old;
        }
        if (account != null) {
            accountData.setAccessToken(account.getAccessToken());
        }
        account = accountData;
    }

    public String getAccessToken() {
        AccountData accessTokenData = getAccountData(); // Update access token
                                                        // if needed
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
     * https://github.com/esi/esi-docs/blob/master/docs/sso/validating_eve_jwt
     * .md
     * 
     * @return Unverified JWT or null
     */
    public JWT getJWT() {
        AccountData accountData = getAccountData(); // Update access token if
                                                    // needed
        if (accountData == null) {
            return null;
        }
        try {
            String accessToken = accountData.getAccessToken();
            if (accessToken == null) {
                return null;
            }
            String[] parts = accessToken.split("\\.");
            if (parts.length != 3) {
                return null;
            }
            Gson gson = new GsonBuilder().registerTypeAdapter(JWT.Payload.class, new JWT.PayloadDeserializer())
                    .create();
            JWT.Header header = gson.fromJson(new String(Base64.getUrlDecoder().decode(parts[0])), JWT.Header.class);
            JWT.Payload payload = gson.fromJson(new String(Base64.getUrlDecoder().decode(parts[1])), JWT.Payload.class);
            String signature = parts[2];
            return new JWT(header, payload, signature);
        } catch (JsonSyntaxException ex) {
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
        if (account == null)
            throw new IllegalArgumentException("Auth is not set");
        if (account.getClientId() == null)
            throw new IllegalArgumentException("client_id is not set");
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
        if (isNativeFlow()) { //Native flow (No client secret/PKCE)
            builder.append("&code_challenge");
            builder.append(getCodeChallenge()); // Already url encoded
            builder.append("&code_challenge_method=");
            builder.append(encode("S256"));
        }
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
        if (account == null)
            throw new IllegalArgumentException("Auth is not set");
        if (codeVerifier == null && account.isNativeFlow())
            throw new IllegalArgumentException("code_verifier is not set");
        if (account.getClientId() == null)
            throw new IllegalArgumentException("client_id is not set");
        StringBuilder builder = new StringBuilder();
        builder.append("grant_type=");
        builder.append(encode("authorization_code"));
        builder.append("&code=");
        builder.append(encode(code));
        if (isNativeFlow()) { //Native flow (No client secret/PKCE)
            builder.append("&client_id=");
            builder.append(encode(account.getClientId()));
            builder.append("&code_verifier=");
            builder.append(encode(codeVerifier));
        }
        update(account, builder.toString());
    }

    private static void refreshToken(AccountData accountData) throws ApiException {
        StringBuilder builder = new StringBuilder();
        builder.append("grant_type=");
        builder.append(encode("refresh_token"));
        builder.append("&refresh_token=");
        builder.append(encode(accountData.getRefreshToken()));
        if (accountData.isNativeFlow()) { //Native flow (No client secret/PKCE)
            builder.append("&client_id=");
            builder.append(encode(accountData.getClientId()));
        }
        update(accountData, builder.toString());
    }

    private static void update(AccountData accountData, String urlParameters) throws ApiException {
        try {
            URL obj = new URL(URI_ACCESS_TOKEN);
            HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

            // add request header
            con.setRequestMethod("POST");
            if (accountData.isWebFlow()) { //Web flow (with client secret)
                con.setRequestProperty("Authorization", accountData.getAuthHeader()); 
            }
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            con.setRequestProperty("Host", "login.eveonline.com");
            con.setConnectTimeout(10000);
            con.setReadTimeout(10000);

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
            Gson gson = new GsonBuilder().create();
            Result result = gson.fromJson(response.toString(), Result.class);

            // set data
            long validUntil = System.currentTimeMillis() + result.getExpiresIn() * 1000 - 5000;
            ACCOUNTS.remove(accountData.getKey()); // Remove old value - or we
                                                   // can match a random refresh
                                                   // token with just the
                                                   // clientID
            accountData.setAccessToken(result.getAccessToken());
            accountData.setValidUntil(validUntil);
            accountData.setRefreshToken(result.getRefreshToken());
            ACCOUNTS.put(accountData.getKey(), accountData); // Update map in
                                                             // case the Refresh
                                                             // Token (AKA Key)
                                                             // have been
                                                             // changed
        } catch (JsonSyntaxException ex) {
            throw new ApiException(ex);
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
        private final String clientSecret;
        private final String authHeader;
        private String refreshToken;
        private String accessToken;
        private long validUntil = 0;

        public AccountData(String clientId, String clientSecret, String refreshToken) {
            this.clientId = clientId;
            this.clientSecret = clientSecret;
            this.refreshToken = refreshToken;
            if (clientSecret != null) {
                String credentials = clientId + ":" + clientSecret;
                authHeader =  "Basic " + Base64.getUrlEncoder().encodeToString(credentials.getBytes());
            } else {
                authHeader = null;
            }
        }

        public String getClientId() {
            return clientId;
        }

        public String getClientSecret() {
            return clientSecret;
        }

        public synchronized String getRefreshToken() { //Synchronized with update()
            return refreshToken;
        }

        public synchronized String getAccessToken() { //Synchronized with update()
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

        public String getAuthHeader() {
           return authHeader;
        }

        private synchronized void update() {
            if (refreshToken != null && (accessToken == null || getValidUntil() < System.currentTimeMillis())) {
                try {
                    OAuth.refreshToken(this);
                } catch (final ApiException ex) {
                    // This error will be handled by ESI once the request is
                    // made
                }
            }
        }

        private boolean isNativeFlow() {
            return clientSecret == null; //Native flow (No client secret/PKCE)
        }

        private boolean isWebFlow() { 
            return clientSecret != null; //Web flow (with client secret)
        }

        public String getKey() {
            if (clientSecret != null) {
                return clientId + clientSecret + refreshToken;
            } else {
                return clientId + refreshToken;
            }
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

        @SerializedName("access_token")
        private String accessToken;
        @SerializedName("expires_in")
        private Long expiresIn;
        @SerializedName("token_type")
        private String tokenType;
        @SerializedName("refresh_token")
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
