package net.troja.eve.esi.api;

import net.troja.eve.esi.ApiClient;
import net.troja.eve.esi.ApiException;
import net.troja.eve.esi.model.CharacterInfo;

/**
 * Api to retrieve the character information from the sso.
 */
public class SsoApi {
    private static final String URI_REVOKE = "https://login.eveonline.com";
    private static final String ACCESS_TOKEN = "access_token";
    private static final String REFRESH_TOKEN = "refresh_token";
    protected static final String DATE_FORMAT = "yyyy-MM-dd'T'hh:mm:ss";
    private ApiClient apiClient;
    private MetaApi metaApi;

    public SsoApi() {
        this(new ApiClient());
    }

    public SsoApi(final ApiClient apiClient) {
        this.apiClient = apiClient;
        this.metaApi = new MetaApi(apiClient);
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
    public CharacterInfo getCharacterInfo() throws ApiException {
        return metaApi.getVerify();
    }

    public void revokeRefreshToken(String refreshToken) throws ApiException {
        revokeToken(refreshToken, REFRESH_TOKEN);
    }

    public void revokeAccessToken(String accessToken) throws ApiException {
        revokeToken(accessToken, ACCESS_TOKEN);
    }

    private void revokeToken(String token, String tokenTypeHint) throws ApiException {
        /*
         * final String basePath = apiClient.getBasePath(); // Save old basepath
         * apiClient.setBasePath(URI_REVOKE); // Set new basepath
         * 
         * final String localVarPath = "/v2/oauth/revoke";
         * 
         * final List<Pair> localVarQueryParams = new ArrayList<>();
         * 
         * final Map<String, String> localVarHeaderParams = new HashMap<>();
         * final OAuth auth = (OAuth) apiClient.getAuthentication("evesso");
         * localVarHeaderParams.put("Content-Type",
         * "application/x-www-form-urlencoded");
         * localVarHeaderParams.put("Host", "login.eveonline.com");
         * 
         * final Map<String, Object> localVarFormParams = new HashMap<>();
         * localVarFormParams.put("token_type_hint", tokenTypeHint);
         * localVarFormParams.put("client_id", auth.getClientId());
         * localVarFormParams.put("token", token);
         * 
         * final String[] localVarAccepts = { "application/json" }; final String
         * localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
         * 
         * final String[] localVarContentTypes = {
         * "application/x-www-form-urlencoded" }; final String
         * localVarContentType =
         * apiClient.selectHeaderContentType(localVarContentTypes);
         * 
         * final String[] localVarAuthNames = new String[0];
         * 
         * try { apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams,
         * null, localVarHeaderParams, localVarFormParams, localVarAccept,
         * localVarContentType, localVarAuthNames, null); } finally {
         * apiClient.setBasePath(basePath); // load old basepath }
         */
    }

}
