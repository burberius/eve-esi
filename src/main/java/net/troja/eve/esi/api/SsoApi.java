package net.troja.eve.esi.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.troja.eve.esi.ApiCallback;
import net.troja.eve.esi.ApiClient;
import net.troja.eve.esi.ApiClientBuilder;
import net.troja.eve.esi.ApiException;
import net.troja.eve.esi.ApiResponse;
import net.troja.eve.esi.Configuration;
import net.troja.eve.esi.Pair;
import net.troja.eve.esi.auth.OAuth;

/**
 * Api to revoke tokens.
 */
@Deprecated
public class SsoApi {
    private static final String URI_REVOKE = "https://login.eveonline.com";
    private static final String ACCESS_TOKEN = "access_token";
    private static final String REFRESH_TOKEN = "refresh_token";
    private static final String DATASOURCE = "tranquility";
    protected static final String DATE_FORMAT = "yyyy-MM-dd'T'hh:mm:ss";
    private final ApiClient revokeApiClient = new ApiClientBuilder().build();
    private ApiClient apiClient;

    public SsoApi() {
        this(Configuration.getDefaultApiClient());
    }

    public SsoApi(final ApiClient apiClient) {
        this.apiClient = apiClient;
        revokeApiClient.setBasePath(URI_REVOKE); // Set new basepath
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * @deprecated Use OAuth.getJWT().getPayload() to get most of the information stored in CharacterInfo before!
     * @see <a href="https://github.com/burberius/eve-esi/blob/master/README.md#version-500-changes">Readme.md</a>
     * @throws ApiException
     */
    @Deprecated
    public void getCharacterInfo() throws ApiException {
        throw new IllegalStateException("SsoApi.getCharacterInfo() has been replaced by OAuth.getJWT(). See https://github.com/burberius/eve-esi/blob/master/README.md#version-500-changes for details");
    }

    public void revokeRefreshToken(String refreshToken) throws ApiException {
        postRevokeToken(refreshToken, REFRESH_TOKEN);
    }

    public void revokeAccessToken(String accessToken) throws ApiException {
        postRevokeToken(accessToken, ACCESS_TOKEN);
    }

    private okhttp3.Call postRevokeTokenCall(final String token, final String tokenTypeHint, final ApiCallback _callback)
            throws ApiException {
        Object localVarPostBody = new Object();

        final OAuth auth = (OAuth) apiClient.getAuthentication("evesso");
        // create path and map variables
        String localVarPath = "/v2/oauth/revoke";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        localVarHeaderParams.put("Content-Type", "application/x-www-form-urlencoded");
        localVarHeaderParams.put("Host", "login.eveonline.com");

        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        localVarFormParams.put("token_type_hint", tokenTypeHint);
        localVarFormParams.put("client_id", auth.getClientId());
        localVarFormParams.put("token", token);

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = revokeApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = { "application/x-www-form-urlencoded" };

        final String localVarContentType = revokeApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] {};
        return revokeApiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams,
                localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames,
                _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call postRevokeTokenValidateBeforeCall(final String token, final String tokenTypeHint,
            final ApiCallback callback) throws ApiException {
        return postRevokeTokenCall(token, tokenTypeHint, callback);

    }

    private void postRevokeToken(final String token, final String tokenTypeHint) throws ApiException {
        postRevokeTokenWithHttpInfo(token, tokenTypeHint);
    }

    private ApiResponse<Void> postRevokeTokenWithHttpInfo(final String token, final String tokenTypeHint)
            throws ApiException {
        okhttp3.Call call = postRevokeTokenValidateBeforeCall(token, tokenTypeHint, null);
        return revokeApiClient.execute(call);
    }
}
