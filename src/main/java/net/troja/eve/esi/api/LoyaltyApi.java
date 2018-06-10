package net.troja.eve.esi.api;

import net.troja.eve.esi.ApiException;
import net.troja.eve.esi.ApiClient;
import net.troja.eve.esi.Configuration;
import net.troja.eve.esi.Pair;

import javax.ws.rs.core.GenericType;

import net.troja.eve.esi.model.CharacterLoyaltyPointsResponse;
import net.troja.eve.esi.model.LoyaltyStoreOffersResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoyaltyApi {
    private ApiClient apiClient;

    public LoyaltyApi() {
        this(Configuration.getDefaultApiClient());
    }

    public LoyaltyApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Get loyalty points Return a list of loyalty points for all corporations
     * the character has worked for --- This route is cached for up to 3600
     * seconds SSO Scope: esi-characters.read_loyalty.v1
     * 
     * @param characterId
     *            An EVE character ID (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param ifNoneMatch
     *            ETag from a previous request. A 304 will be returned if this
     *            matches the current ETag (optional)
     * @param token
     *            Access token to use if unable to set a header (optional)
     * @return List&lt;CharacterLoyaltyPointsResponse&gt;
     * @throws ApiException
     *             if fails to make API call
     */
    public List<CharacterLoyaltyPointsResponse> getCharactersCharacterIdLoyaltyPoints(Integer characterId,
            String datasource, String ifNoneMatch, String token) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'characterId' is set
        if (characterId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'characterId' when calling getCharactersCharacterIdLoyaltyPoints");
        }

        // create path and map variables
        String localVarPath = "/v1/characters/{character_id}/loyalty/points/".replaceAll("\\{format\\}", "json")
                .replaceAll("\\{" + "character_id" + "\\}", apiClient.escapeString(characterId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "token", token));

        if (ifNoneMatch != null)
            localVarHeaderParams.put("If-None-Match", apiClient.parameterToString(ifNoneMatch));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = { "application/json" };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "evesso" };

        GenericType<List<CharacterLoyaltyPointsResponse>> localVarReturnType = new GenericType<List<CharacterLoyaltyPointsResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * List loyalty store offers Return a list of offers from a specific
     * corporation&#39;s loyalty store --- This route expires daily at 11:05
     * 
     * @param corporationId
     *            An EVE corporation ID (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param ifNoneMatch
     *            ETag from a previous request. A 304 will be returned if this
     *            matches the current ETag (optional)
     * @return List&lt;LoyaltyStoreOffersResponse&gt;
     * @throws ApiException
     *             if fails to make API call
     */
    public List<LoyaltyStoreOffersResponse> getLoyaltyStoresCorporationIdOffers(Integer corporationId,
            String datasource, String ifNoneMatch) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'corporationId' is set
        if (corporationId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'corporationId' when calling getLoyaltyStoresCorporationIdOffers");
        }

        // create path and map variables
        String localVarPath = "/v1/loyalty/stores/{corporation_id}/offers/".replaceAll("\\{format\\}", "json")
                .replaceAll("\\{" + "corporation_id" + "\\}", apiClient.escapeString(corporationId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));

        if (ifNoneMatch != null)
            localVarHeaderParams.put("If-None-Match", apiClient.parameterToString(ifNoneMatch));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = { "application/json" };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {};

        GenericType<List<LoyaltyStoreOffersResponse>> localVarReturnType = new GenericType<List<LoyaltyStoreOffersResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }
}
