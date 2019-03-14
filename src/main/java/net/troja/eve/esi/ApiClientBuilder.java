package net.troja.eve.esi;

import com.squareup.okhttp.OkHttpClient;
import net.troja.eve.esi.auth.OAuth;

public class ApiClientBuilder {

    private String clientID;
    private String refreshToken;
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
        if (clientID != null) {
            if (refreshToken != null) {
                auth.setAuth(clientID, refreshToken);
            } else {
                auth.setClientId(clientID);
            }
        }
        if (accessToken != null) {
            auth.setAccessToken(accessToken);
        }
        if (okHttpClient != null) {
            client.setHttpClient(okHttpClient);
        }
        return client;
    }

    public ApiClientBuilder clientID(String clientID) {
        this.clientID = clientID;
        return this;
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
