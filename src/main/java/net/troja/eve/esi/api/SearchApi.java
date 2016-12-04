package net.troja.eve.esi.api;

import net.troja.eve.esi.ApiException;
import net.troja.eve.esi.ApiClient;
import net.troja.eve.esi.Configuration;
import net.troja.eve.esi.Pair;

import javax.ws.rs.core.GenericType;

import net.troja.eve.esi.model.CharacterSearchResponse;
import net.troja.eve.esi.model.SearchResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchApi {
    private ApiClient apiClient;

    public SearchApi() {
        this(Configuration.getDefaultApiClient());
    }

    public SearchApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Search on a string Search for entities that match a given sub-string. ---
     * Alternate route: &#x60;/v2/characters/{character_id}/search/&#x60;
     * Alternate route: &#x60;/dev/characters/{character_id}/search/&#x60; ---
     * This route is cached for up to 3600 seconds
     * 
     * @param characterId
     *            An EVE character ID (required)
     * @param search
     *            The string to search on (required)
     * @param categories
     *            Type of entities to search for (required)
     * @param language
     *            Search locale (optional, default to en-us)
     * @param strict
     *            Whether the search should be a strict match (optional, default
     *            to false)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @return CharacterSearchResponse
     * @throws ApiException
     *             if fails to make API call
     */
    public CharacterSearchResponse getCharactersCharacterIdSearch(Integer characterId, String search,
            List<String> categories, String language, Boolean strict, String datasource) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'characterId' is set
        if (characterId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'characterId' when calling getCharactersCharacterIdSearch");
        }

        // verify the required parameter 'search' is set
        if (search == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'search' when calling getCharactersCharacterIdSearch");
        }

        // verify the required parameter 'categories' is set
        if (categories == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'categories' when calling getCharactersCharacterIdSearch");
        }

        // create path and map variables
        String localVarPath = "/characters/{character_id}/search/".replaceAll("\\{format\\}", "json").replaceAll(
                "\\{" + "character_id" + "\\}", apiClient.escapeString(characterId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "search", search));
        localVarQueryParams.addAll(apiClient.parameterToPairs("csv", "categories", categories));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "language", language));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "strict", strict));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "evesso" };

        GenericType<CharacterSearchResponse> localVarReturnType = new GenericType<CharacterSearchResponse>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Search on a string Search for entities that match a given sub-string. ---
     * Alternate route: &#x60;/v1/search/&#x60; Alternate route:
     * &#x60;/legacy/search/&#x60; Alternate route: &#x60;/dev/search/&#x60; ---
     * This route is cached for up to 3600 seconds
     * 
     * @param search
     *            The string to search on (required)
     * @param categories
     *            Type of entities to search for (required)
     * @param language
     *            Search locale (optional, default to en-us)
     * @param strict
     *            Whether the search should be a strict match (optional, default
     *            to false)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @return SearchResponse
     * @throws ApiException
     *             if fails to make API call
     */
    public SearchResponse getSearch(String search, List<String> categories, String language, Boolean strict,
            String datasource) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'search' is set
        if (search == null) {
            throw new ApiException(400, "Missing the required parameter 'search' when calling getSearch");
        }

        // verify the required parameter 'categories' is set
        if (categories == null) {
            throw new ApiException(400, "Missing the required parameter 'categories' when calling getSearch");
        }

        // create path and map variables
        String localVarPath = "/search/".replaceAll("\\{format\\}", "json");

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "search", search));
        localVarQueryParams.addAll(apiClient.parameterToPairs("csv", "categories", categories));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "language", language));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "strict", strict));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {};

        GenericType<SearchResponse> localVarReturnType = new GenericType<SearchResponse>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }
}
