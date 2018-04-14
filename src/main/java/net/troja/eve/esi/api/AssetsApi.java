package net.troja.eve.esi.api;

import net.troja.eve.esi.ApiException;
import net.troja.eve.esi.ApiClient;
import net.troja.eve.esi.Configuration;
import net.troja.eve.esi.Pair;

import javax.ws.rs.core.GenericType;

import net.troja.eve.esi.model.CharacterAssetsLocationsResponse;
import net.troja.eve.esi.model.CharacterAssetsNamesResponse;
import net.troja.eve.esi.model.CharacterAssetsResponse;
import net.troja.eve.esi.model.CorporationAssetsLocationsResponse;
import net.troja.eve.esi.model.CorporationAssetsNamesResponse;
import net.troja.eve.esi.model.CorporationAssetsResponse;
import net.troja.eve.esi.model.Forbidden;
import net.troja.eve.esi.model.InternalServerError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AssetsApi {
    private ApiClient apiClient;

    public AssetsApi() {
        this(Configuration.getDefaultApiClient());
    }

    public AssetsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Get character assets Return a list of the characters assets --- This
     * route is cached for up to 3600 seconds SSO Scope:
     * esi-assets.read_assets.v1
     * 
     * @param characterId
     *            An EVE character ID (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param page
     *            Which page of results to return (optional, default to 1)
     * @param token
     *            Access token to use if unable to set a header (optional)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return List&lt;CharacterAssetsResponse&gt;
     * @throws ApiException
     *             if fails to make API call
     */
    public List<CharacterAssetsResponse> getCharactersCharacterIdAssets(Integer characterId, String datasource,
            Integer page, String token, String userAgent, String xUserAgent) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'characterId' is set
        if (characterId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'characterId' when calling getCharactersCharacterIdAssets");
        }

        // create path and map variables
        String localVarPath = "/v3/characters/{character_id}/assets/".replaceAll("\\{format\\}", "json").replaceAll(
                "\\{" + "character_id" + "\\}", apiClient.escapeString(characterId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "page", page));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "token", token));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "user_agent", userAgent));

        if (xUserAgent != null)
            localVarHeaderParams.put("X-User-Agent", apiClient.parameterToString(xUserAgent));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "evesso" };

        GenericType<List<CharacterAssetsResponse>> localVarReturnType = new GenericType<List<CharacterAssetsResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get corporation assets Return a list of the corporation assets --- This
     * route is cached for up to 3600 seconds --- Requires one of the following
     * EVE corporation role(s): Director SSO Scope:
     * esi-assets.read_corporation_assets.v1
     * 
     * @param corporationId
     *            An EVE corporation ID (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param page
     *            Which page of results to return (optional, default to 1)
     * @param token
     *            Access token to use if unable to set a header (optional)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return List&lt;CorporationAssetsResponse&gt;
     * @throws ApiException
     *             if fails to make API call
     */
    public List<CorporationAssetsResponse> getCorporationsCorporationIdAssets(Integer corporationId, String datasource,
            Integer page, String token, String userAgent, String xUserAgent) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'corporationId' is set
        if (corporationId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'corporationId' when calling getCorporationsCorporationIdAssets");
        }

        // create path and map variables
        String localVarPath = "/v3/corporations/{corporation_id}/assets/".replaceAll("\\{format\\}", "json")
                .replaceAll("\\{" + "corporation_id" + "\\}", apiClient.escapeString(corporationId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "page", page));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "token", token));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "user_agent", userAgent));

        if (xUserAgent != null)
            localVarHeaderParams.put("X-User-Agent", apiClient.parameterToString(xUserAgent));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "evesso" };

        GenericType<List<CorporationAssetsResponse>> localVarReturnType = new GenericType<List<CorporationAssetsResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get character asset locations Return locations for a set of item ids,
     * which you can get from character assets endpoint. Coordinates for items
     * in hangars or stations are set to (0,0,0) --- SSO Scope:
     * esi-assets.read_assets.v1
     * 
     * @param characterId
     *            An EVE character ID (required)
     * @param itemIds
     *            A list of item ids (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param token
     *            Access token to use if unable to set a header (optional)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return List&lt;CharacterAssetsLocationsResponse&gt;
     * @throws ApiException
     *             if fails to make API call
     */
    public List<CharacterAssetsLocationsResponse> postCharactersCharacterIdAssetsLocations(Integer characterId,
            List<Long> itemIds, String datasource, String token, String userAgent, String xUserAgent)
            throws ApiException {
        Object localVarPostBody = itemIds;

        // verify the required parameter 'characterId' is set
        if (characterId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'characterId' when calling postCharactersCharacterIdAssetsLocations");
        }

        // verify the required parameter 'itemIds' is set
        if (itemIds == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'itemIds' when calling postCharactersCharacterIdAssetsLocations");
        }

        // create path and map variables
        String localVarPath = "/v2/characters/{character_id}/assets/locations/".replaceAll("\\{format\\}", "json")
                .replaceAll("\\{" + "character_id" + "\\}", apiClient.escapeString(characterId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "token", token));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "user_agent", userAgent));

        if (xUserAgent != null)
            localVarHeaderParams.put("X-User-Agent", apiClient.parameterToString(xUserAgent));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "evesso" };

        GenericType<List<CharacterAssetsLocationsResponse>> localVarReturnType = new GenericType<List<CharacterAssetsLocationsResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get character asset names Return names for a set of item ids, which you
     * can get from character assets endpoint. Typically used for items that can
     * customize names, like containers or ships. --- SSO Scope:
     * esi-assets.read_assets.v1
     * 
     * @param characterId
     *            An EVE character ID (required)
     * @param itemIds
     *            A list of item ids (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param token
     *            Access token to use if unable to set a header (optional)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return List&lt;CharacterAssetsNamesResponse&gt;
     * @throws ApiException
     *             if fails to make API call
     */
    public List<CharacterAssetsNamesResponse> postCharactersCharacterIdAssetsNames(Integer characterId,
            List<Long> itemIds, String datasource, String token, String userAgent, String xUserAgent)
            throws ApiException {
        Object localVarPostBody = itemIds;

        // verify the required parameter 'characterId' is set
        if (characterId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'characterId' when calling postCharactersCharacterIdAssetsNames");
        }

        // verify the required parameter 'itemIds' is set
        if (itemIds == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'itemIds' when calling postCharactersCharacterIdAssetsNames");
        }

        // create path and map variables
        String localVarPath = "/v1/characters/{character_id}/assets/names/".replaceAll("\\{format\\}", "json")
                .replaceAll("\\{" + "character_id" + "\\}", apiClient.escapeString(characterId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "token", token));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "user_agent", userAgent));

        if (xUserAgent != null)
            localVarHeaderParams.put("X-User-Agent", apiClient.parameterToString(xUserAgent));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "evesso" };

        GenericType<List<CharacterAssetsNamesResponse>> localVarReturnType = new GenericType<List<CharacterAssetsNamesResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get corporation asset locations Return locations for a set of item ids,
     * which you can get from corporation assets endpoint. Coordinates for items
     * in hangars or stations are set to (0,0,0) --- Requires one of the
     * following EVE corporation role(s): Director SSO Scope:
     * esi-assets.read_corporation_assets.v1
     * 
     * @param corporationId
     *            An EVE corporation ID (required)
     * @param itemIds
     *            A list of item ids (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param token
     *            Access token to use if unable to set a header (optional)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return List&lt;CorporationAssetsLocationsResponse&gt;
     * @throws ApiException
     *             if fails to make API call
     */
    public List<CorporationAssetsLocationsResponse> postCorporationsCorporationIdAssetsLocations(Integer corporationId,
            List<Long> itemIds, String datasource, String token, String userAgent, String xUserAgent)
            throws ApiException {
        Object localVarPostBody = itemIds;

        // verify the required parameter 'corporationId' is set
        if (corporationId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'corporationId' when calling postCorporationsCorporationIdAssetsLocations");
        }

        // verify the required parameter 'itemIds' is set
        if (itemIds == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'itemIds' when calling postCorporationsCorporationIdAssetsLocations");
        }

        // create path and map variables
        String localVarPath = "/v2/corporations/{corporation_id}/assets/locations/".replaceAll("\\{format\\}", "json")
                .replaceAll("\\{" + "corporation_id" + "\\}", apiClient.escapeString(corporationId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "token", token));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "user_agent", userAgent));

        if (xUserAgent != null)
            localVarHeaderParams.put("X-User-Agent", apiClient.parameterToString(xUserAgent));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "evesso" };

        GenericType<List<CorporationAssetsLocationsResponse>> localVarReturnType = new GenericType<List<CorporationAssetsLocationsResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get coporation asset names Return names for a set of item ids, which you
     * can get from corporation assets endpoint. Only valid for items that can
     * customize names, like containers or ships. --- Requires one of the
     * following EVE corporation role(s): Director SSO Scope:
     * esi-assets.read_corporation_assets.v1
     * 
     * @param corporationId
     *            An EVE corporation ID (required)
     * @param itemIds
     *            A list of item ids (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param token
     *            Access token to use if unable to set a header (optional)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return List&lt;CorporationAssetsNamesResponse&gt;
     * @throws ApiException
     *             if fails to make API call
     */
    public List<CorporationAssetsNamesResponse> postCorporationsCorporationIdAssetsNames(Integer corporationId,
            List<Long> itemIds, String datasource, String token, String userAgent, String xUserAgent)
            throws ApiException {
        Object localVarPostBody = itemIds;

        // verify the required parameter 'corporationId' is set
        if (corporationId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'corporationId' when calling postCorporationsCorporationIdAssetsNames");
        }

        // verify the required parameter 'itemIds' is set
        if (itemIds == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'itemIds' when calling postCorporationsCorporationIdAssetsNames");
        }

        // create path and map variables
        String localVarPath = "/v1/corporations/{corporation_id}/assets/names/".replaceAll("\\{format\\}", "json")
                .replaceAll("\\{" + "corporation_id" + "\\}", apiClient.escapeString(corporationId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "token", token));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "user_agent", userAgent));

        if (xUserAgent != null)
            localVarHeaderParams.put("X-User-Agent", apiClient.parameterToString(xUserAgent));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "evesso" };

        GenericType<List<CorporationAssetsNamesResponse>> localVarReturnType = new GenericType<List<CorporationAssetsNamesResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }
}
