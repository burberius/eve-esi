package net.troja.eve.esi.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.troja.eve.esi.ApiClient;
import net.troja.eve.esi.ApiException;
import net.troja.eve.esi.ApiResponse;
import net.troja.eve.esi.Pair;
import net.troja.eve.esi.ProgressRequestBody;
import net.troja.eve.esi.ProgressResponseBody;
import net.troja.eve.esi.auth.OAuth;
import net.troja.eve.esi.model.VerifyResponse;

/**
 * Api to retrieve the character information from the sso.
 */
public class SsoApi {
    private static final String URI_REVOKE = "https://login.eveonline.com";
    private static final String ACCESS_TOKEN = "access_token";
    private static final String REFRESH_TOKEN = "refresh_token";
    protected static final String DATE_FORMAT = "yyyy-MM-dd'T'hh:mm:ss";
    private final ApiClient revokeApiClient = new ApiClient();
    private ApiClient apiClient;
    private MetaApi metaApi;

    public SsoApi() {
        this(new ApiClient());
    }

    public SsoApi(final ApiClient apiClient) {
        this.apiClient = apiClient;
        this.metaApi = new MetaApi(apiClient);
        revokeApiClient.setBasePath(URI_REVOKE); // Set new basepath
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
        this.metaApi.setApiClient(apiClient);
    }

    /**
     * Deprecated use net.troja.eve.esi.api.MetaApi.getVerify() instead
     * 
     * @return
     * @throws ApiException
     */
    @Deprecated
    public VerifyResponse getCharacterInfo() throws ApiException {
        return metaApi.getVerify();
    }

    public void revokeRefreshToken(String refreshToken) throws ApiException {
        postRevokeToken(refreshToken, REFRESH_TOKEN);
    }

    public void revokeAccessToken(String accessToken) throws ApiException {
        postRevokeToken(accessToken, ACCESS_TOKEN);
    }

    private com.squareup.okhttp.Call postRevokeTokenCall(String token, String tokenTypeHint, final ProgressResponseBody.ProgressListener progressListener,
            final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        final OAuth auth = (OAuth) apiClient.getAuthentication("evesso");
        // create path and map variables
        String localVarPath = "/v2/oauth/revoke";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        localVarHeaderParams.put("Content-Type",
                "application/x-www-form-urlencoded");
        localVarHeaderParams.put("Host", "login.eveonline.com");

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        localVarFormParams.put("token_type_hint", tokenTypeHint);
        localVarFormParams.put("client_id", auth.getClientId());
        localVarFormParams.put("token", token);

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = revokeApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null)
            localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {"application/x-www-form-urlencoded"};
        
        final String localVarContentType = revokeApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);
        

        if (progressListener != null) {
            revokeApiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain)
                        throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                            .body(new ProgressResponseBody(originalResponse.body(), progressListener)).build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {};
        return revokeApiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams,
                localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call postRevokeTokenValidateBeforeCall(
            final String token, final String tokenTypeHint,
            final ProgressResponseBody.ProgressListener progressListener,
            final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {

        com.squareup.okhttp.Call call = postRevokeTokenCall(token, tokenTypeHint, progressListener, progressRequestListener);
        return call;

    }

    private void postRevokeToken(String token, String tokenTypeHint)throws ApiException {
        postRevokeTokenWithHttpInfo(token, tokenTypeHint);
    }

    private ApiResponse<Void> postRevokeTokenWithHttpInfo(String token, String tokenTypeHint) throws ApiException {
        com.squareup.okhttp.Call call = postRevokeTokenValidateBeforeCall(token, tokenTypeHint, null, null);
        return revokeApiClient.execute(call);
    }
}
