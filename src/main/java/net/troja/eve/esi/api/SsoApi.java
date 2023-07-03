package net.troja.eve.esi.api;

import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
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
import net.troja.eve.esi.model.CharacterInfo;

/**
 * Api to retrieve the character information from the sso.
 */
public class SsoApi {
    private static final String URI_REVOKE = "https://login.eveonline.com";
    private static final String ACCESS_TOKEN = "access_token";
    private static final String REFRESH_TOKEN = "refresh_token";
    private static final String DATASOURCE = "tranquility";
    protected static final String DATE_FORMAT = "yyyy-MM-dd'T'hh:mm:ss";
    private final ApiClient localVarApiClient = new ApiClientBuilder().build();
    private ApiClient apiClient;
    private MetaApi metaApi;

    public SsoApi() {
        this(Configuration.getDefaultApiClient());
    }

    public SsoApi(final ApiClient apiClient) {
        this.apiClient = apiClient;
        this.metaApi = new MetaApi(apiClient);
        localVarApiClient.setBasePath(URI_REVOKE); // Set new basepath
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
        this.metaApi.setApiClient(apiClient);
    }

    /**
     * Alias for net.troja.eve.esi.api.MetaApi.getVerify() Return CharacterInfo
     * that have helper methods: CharacterInfo.getScopes() : Set<String>
     * CharacterInfo.getExpireOn() : OffsetDateTime
     * 
     * @return
     * @throws ApiException
     */
    public CharacterInfo getCharacterInfo() throws ApiException {
        return new CharacterInfo(metaApi.getVerify(null, null, DATASOURCE, null, null));
    }

    public void revokeRefreshToken(String refreshToken) throws ApiException {
        postRevokeToken(refreshToken, REFRESH_TOKEN);
    }

    public void revokeAccessToken(String accessToken) throws ApiException {
        postRevokeToken(accessToken, ACCESS_TOKEN);
    }

    public okhttp3.Call postRevokeTokenCall(final String token, final String tokenTypeHint, final ApiCallback _callback)
            throws ApiException {
        String basePath = null;
        // Operation Servers
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
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = { "application/x-www-form-urlencoded" };

        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        basePath = URI_REVOKE;

        String[] localVarAuthNames = new String[] {};
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams,
                localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams,
                localVarFormParams, localVarAuthNames, _callback);
    }

    public void postRevokeToken(final String token, final String tokenTypeHint) throws ApiException {
        postRevokeTokenWithHttpInfo(token, tokenTypeHint);
    }

    public ApiResponse<Void> postRevokeTokenWithHttpInfo(final String token, final String tokenTypeHint)
            throws ApiException {
        okhttp3.Call localVarCall = postRevokeTokenCall(token, tokenTypeHint, null);
        Type localVarReturnType = new TypeToken<Void>() {
        }.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    public okhttp3.Call postRevokeTokenAsync(final String token, final String tokenTypeHint,
            final ApiCallback<Void> _callback) throws ApiException {

        okhttp3.Call localVarCall = postRevokeTokenCall(token, tokenTypeHint, _callback);
        Type localVarReturnType = new TypeToken<Void>() {
        }.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}
