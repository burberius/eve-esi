package net.troja.eve.esi;

import net.troja.eve.esi.auth.OAuth;
import okhttp3.OkHttpClient;

public class ApiClientBuilder {

    private String clientID = null;
    private String clientSecret = null;
    private String refreshToken = null;
    private String accessToken;
    private String userAgent;
    private OkHttpClient okHttpClient;

    public ApiClient build() {
        ApiClient client = new ApiClient();

        // Set default User-Agent.
        String systemUserAgent = System.getProperty("http.agent");
        if (userAgent != null && !userAgent.isEmpty()) {
            client.setUserAgent(userAgent);
        } else if (systemUserAgent != null && !systemUserAgent.isEmpty()) {
            client.setUserAgent(systemUserAgent);
        } else {
            client.setUserAgent("eve-esi/slack:@goldengnu");
        }
        // Set auth
        final OAuth auth = (OAuth) client.getAuthentication("evesso");
        auth.setAuthWeb(clientID, clientSecret, refreshToken); //Some of the values may be null, that is okay and by design
        if (accessToken != null) {
            auth.setAccessToken(accessToken);
        }
        if (okHttpClient != null) {
            client.setHttpClient(okHttpClient);
        }
        return client;
    }

    /**
     * Desktop/Mobile flow (No client secret/PKCE).
     * @see <a href="https://docs.esi.evetech.net/docs/sso/native_sso_flow.html">Native SSO Flow</a>
     *
     * @param clientID
     * @return 
     */
    public ApiClientBuilder authDesktop(String clientID) {
        this.clientID = clientID;
        return this;
    }

    /**
     * Web flow (with client secret).
     * @see <a href="https://docs.esi.evetech.net/docs/sso/web_based_sso_flow.html">Web base SSO Flow</a>
     *
     * @param clientID
     * @param clientSecret
     * @return 
     */
    public ApiClientBuilder authWeb(String clientID, String clientSecret) {
        this.clientID = clientID;
        this.clientSecret = clientSecret;
        return this;
    }

    /**
     * @deprecated Please use @see #authDesktop(String) or @see #authWeb(String, String) instead!
     *
     * @param clientID
     * @return
     */
    @Deprecated
    public ApiClientBuilder clientID(String clientID) {
        throw new IllegalStateException("clientID() method has been replaced by authDesktop() or authWeb()");
    }

    public ApiClientBuilder refreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
        return this;
    }

    public ApiClientBuilder accessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    public ApiClientBuilder userAgent(String userAgent) {
        this.userAgent = userAgent;
        return this;
    }

    public ApiClientBuilder okHttpClient(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
        return this;
    }

}
