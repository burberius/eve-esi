package net.troja.eve.esi;

import net.troja.eve.esi.auth.OAuth;
import okhttp3.OkHttpClient;

public class ApiClientBuilder {

    private String clientID;
    private String refreshToken;
    private String accessToken;
    private String userAgent;
    private OkHttpClient okHttpClient;
    private ApiClient client;

    public ApiClient build() {
        if (client == null) {
            client = new ApiClient();
        }
        // Set default User-Agent.
        if (userAgent != null && !userAgent.isEmpty()) {
            client.setUserAgent(userAgent);
        } else  {
            client.setUserAgent(Configuration.getUseragent());
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

    public ApiClientBuilder client(ApiClient client) {
        this.client = client;
        return this;
    }
}
