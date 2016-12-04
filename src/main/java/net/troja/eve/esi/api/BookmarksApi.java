package net.troja.eve.esi.api;

import net.troja.eve.esi.ApiException;
import net.troja.eve.esi.ApiClient;
import net.troja.eve.esi.Configuration;
import net.troja.eve.esi.Pair;

import javax.ws.rs.core.GenericType;

import net.troja.eve.esi.model.CharacterBookmarksResponse;
import net.troja.eve.esi.model.CharacterBookmarkFoldersResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookmarksApi {
    private ApiClient apiClient;

    public BookmarksApi() {
        this(Configuration.getDefaultApiClient());
    }

    public BookmarksApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * List bookmarks List your character&#39;s personal bookmarks --- Alternate
     * route: &#x60;/v1/characters/{character_id}/bookmarks/&#x60; Alternate
     * route: &#x60;/legacy/characters/{character_id}/bookmarks/&#x60; Alternate
     * route: &#x60;/dev/characters/{character_id}/bookmarks/&#x60; --- This
     * route is cached for up to 3600 seconds
     * 
     * @param characterId
     *            An EVE character ID (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @return List<CharacterBookmarksResponse>
     * @throws ApiException
     *             if fails to make API call
     */
    public List<CharacterBookmarksResponse> getCharactersCharacterIdBookmarks(Integer characterId, String datasource)
            throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'characterId' is set
        if (characterId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'characterId' when calling getCharactersCharacterIdBookmarks");
        }

        // create path and map variables
        String localVarPath = "/characters/{character_id}/bookmarks/".replaceAll("\\{format\\}", "json").replaceAll(
                "\\{" + "character_id" + "\\}", apiClient.escapeString(characterId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "evesso" };

        GenericType<List<CharacterBookmarksResponse>> localVarReturnType = new GenericType<List<CharacterBookmarksResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * List bookmark folders List your character&#39;s personal bookmark folders
     * --- Alternate route:
     * &#x60;/v1/characters/{character_id}/bookmarks/folders/&#x60; Alternate
     * route: &#x60;/legacy/characters/{character_id}/bookmarks/folders/&#x60;
     * Alternate route:
     * &#x60;/dev/characters/{character_id}/bookmarks/folders/&#x60; --- This
     * route is cached for up to 3600 seconds
     * 
     * @param characterId
     *            An EVE character ID (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @return List<CharacterBookmarkFoldersResponse>
     * @throws ApiException
     *             if fails to make API call
     */
    public List<CharacterBookmarkFoldersResponse> getCharactersCharacterIdBookmarksFolders(Integer characterId,
            String datasource) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'characterId' is set
        if (characterId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'characterId' when calling getCharactersCharacterIdBookmarksFolders");
        }

        // create path and map variables
        String localVarPath = "/characters/{character_id}/bookmarks/folders/".replaceAll("\\{format\\}", "json")
                .replaceAll("\\{" + "character_id" + "\\}", apiClient.escapeString(characterId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "evesso" };

        GenericType<List<CharacterBookmarkFoldersResponse>> localVarReturnType = new GenericType<List<CharacterBookmarkFoldersResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }
}
