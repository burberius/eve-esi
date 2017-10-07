/**
 * EVE Swagger Interface
 * An OpenAPI for EVE Online
 */

package net.troja.eve.esi.auth;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.ws.rs.ProcessingException;

import org.apache.commons.lang3.StringUtils;
import org.glassfish.jersey.client.oauth2.ClientIdentifier;
import org.glassfish.jersey.client.oauth2.OAuth2ClientSupport;
import org.glassfish.jersey.client.oauth2.OAuth2CodeGrantFlow;
import org.glassfish.jersey.client.oauth2.TokenResult;

import net.troja.eve.esi.ApiException;
import net.troja.eve.esi.Pair;

public class OAuth implements Authentication {
    public static final String URI_OAUTH = "https://login.eveonline.com/oauth";
    private static final String URI_AUTHENTICATION = URI_OAUTH + "/authorize";
    private static final String URI_ACCESS_TOKEN = URI_OAUTH + "/token";

    private String refreshToken;
    private String clientId;
    private String clientSecret;
    private OAuth2CodeGrantFlow oAuthFlow;
    private static final Map<String, AccessTokenData> ACCESS_TOKEN_CACHE = new ConcurrentHashMap<>();

    @Override
    public void applyToParams(final List<Pair> queryParams, final Map<String, String> headerParams) {
        // Check if we need a new access token
        synchronized (OAuth.class) { // This block is synchronized across all
                                     // threads - so we don't update the access
                                     // token more than once
            AccessTokenData accessTokenData = ACCESS_TOKEN_CACHE.get(getAuthKey());
            if (refreshToken != null
                    && (accessTokenData == null || accessTokenData.getValidUntil() < System.currentTimeMillis())) {
                try {
                    refreshToken();
                } catch (final ProcessingException ex) {
                    // This error will be handled by ESI once the request is
                    // made
                }
            }
        }
        // Add auth
        AccessTokenData accessTokenData = ACCESS_TOKEN_CACHE.get(getAuthKey());
        if (accessTokenData != null) {
            headerParams.put("Authorization", "Bearer " + accessTokenData.getAccessToken());
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
        if (oAuthFlow == null) {
            createFlow(redirectUri, scopes, state);
        }
        return oAuthFlow.start();
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
            updateTokens(getFlow().finish(code, state));
        } catch (final ProcessingException ex) {
            throw new ApiException(ex);
        }
    }

    private void refreshToken() {
        updateTokens(getFlow().refreshAccessToken(refreshToken));
    }

    private OAuth2CodeGrantFlow getFlow() {
        if (oAuthFlow == null) {
            createFlow(null, null, null);
        }
        return oAuthFlow;
    }

    private void updateTokens(final TokenResult result) {
        refreshToken = result.getRefreshToken();
        String accessToken = result.getAccessToken();
        long validUntil = System.currentTimeMillis() + result.getExpiresIn() * 1000 - 5000;
        ACCESS_TOKEN_CACHE.put(getAuthKey(), new AccessTokenData(accessToken, validUntil));
    }

    private void createFlow(final String redirectUri, final Set<String> scopes, final String state) {
        final String scopesString = getScopesString(scopes);
        final ClientIdentifier clientIdentifier = new ClientIdentifier(clientId, clientSecret);
        @SuppressWarnings("rawtypes")
        final OAuth2CodeGrantFlow.Builder builder = OAuth2ClientSupport.authorizationCodeGrantFlowBuilder(
                clientIdentifier, URI_AUTHENTICATION, URI_ACCESS_TOKEN);
        if (StringUtils.isNotBlank(redirectUri)) {
            builder.redirectUri(redirectUri);
        }
        if (StringUtils.isNotBlank(state)) {
            builder.property(OAuth2CodeGrantFlow.Phase.AUTHORIZATION, "state", state);
        }
        if (StringUtils.isNotBlank(scopesString)) {
            builder.scope(scopesString);
        }
        oAuthFlow = builder.build();
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

    public void setAccessToken(final String accessToken) {
        ACCESS_TOKEN_CACHE.put(getAuthKey(), new AccessTokenData(accessToken, 0));
    }

    public void setRefreshToken(final String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public void setClientId(final String clientId) {
        this.clientId = clientId;
    }

    public void setClientSecret(final String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    private String getAuthKey() {
        return clientId + clientSecret + refreshToken;
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
}
