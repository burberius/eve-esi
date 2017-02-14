package net.troja.eve.esi.api;

import net.troja.eve.esi.ApiException;
import net.troja.eve.esi.ApiClient;
import net.troja.eve.esi.Configuration;
import net.troja.eve.esi.Pair;

import javax.ws.rs.core.GenericType;

import net.troja.eve.esi.model.CharacterCorporationHistoryResponse;
import net.troja.eve.esi.model.CharacterNamesResponse;
import net.troja.eve.esi.model.CharacterPortraitResponse;
import net.troja.eve.esi.model.CharacterResponse;
import net.troja.eve.esi.model.CspaCharacters;
import net.troja.eve.esi.model.CspaCostResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CharacterApi {
    private ApiClient apiClient;

    public CharacterApi() {
        this(Configuration.getDefaultApiClient());
    }

    public CharacterApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Get character&#39;s public information Public information about a
     * character --- Alternate route: &#x60;/v4/characters/{character_id}/&#x60;
     * Alternate route: &#x60;/dev/characters/{character_id}/&#x60; --- This
     * route is cached for up to 3600 seconds
     * 
     * @param characterId
     *            An EVE character ID (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @return CharacterResponse
     * @throws ApiException
     *             if fails to make API call
     */
    public CharacterResponse getCharactersCharacterId(Integer characterId, String datasource) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'characterId' is set
        if (characterId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'characterId' when calling getCharactersCharacterId");
        }

        // create path and map variables
        String localVarPath = "/characters/{character_id}/".replaceAll("\\{format\\}", "json").replaceAll(
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

        String[] localVarAuthNames = new String[] {};

        GenericType<CharacterResponse> localVarReturnType = new GenericType<CharacterResponse>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get corporation history Get a list of all the corporations a character
     * has been a member of --- Alternate route:
     * &#x60;/v1/characters/{character_id}/corporationhistory/&#x60; Alternate
     * route: &#x60;/legacy/characters/{character_id}/corporationhistory/&#x60;
     * Alternate route:
     * &#x60;/dev/characters/{character_id}/corporationhistory/&#x60; --- This
     * route is cached for up to 3600 seconds
     * 
     * @param characterId
     *            An EVE character ID (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @return List<CharacterCorporationHistoryResponse>
     * @throws ApiException
     *             if fails to make API call
     */
    public List<CharacterCorporationHistoryResponse> getCharactersCharacterIdCorporationhistory(Integer characterId,
            String datasource) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'characterId' is set
        if (characterId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'characterId' when calling getCharactersCharacterIdCorporationhistory");
        }

        // create path and map variables
        String localVarPath = "/characters/{character_id}/corporationhistory/".replaceAll("\\{format\\}", "json")
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

        String[] localVarAuthNames = new String[] {};

        GenericType<List<CharacterCorporationHistoryResponse>> localVarReturnType = new GenericType<List<CharacterCorporationHistoryResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get character portraits Get portrait urls for a character --- Alternate
     * route: &#x60;/v2/characters/{character_id}/portrait/&#x60; Alternate
     * route: &#x60;/dev/characters/{character_id}/portrait/&#x60; --- This
     * route is cached for up to 3600 seconds
     * 
     * @param characterId
     *            An EVE character ID (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @return CharacterPortraitResponse
     * @throws ApiException
     *             if fails to make API call
     */
    public CharacterPortraitResponse getCharactersCharacterIdPortrait(Integer characterId, String datasource)
            throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'characterId' is set
        if (characterId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'characterId' when calling getCharactersCharacterIdPortrait");
        }

        // create path and map variables
        String localVarPath = "/characters/{character_id}/portrait/".replaceAll("\\{format\\}", "json").replaceAll(
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

        String[] localVarAuthNames = new String[] {};

        GenericType<CharacterPortraitResponse> localVarReturnType = new GenericType<CharacterPortraitResponse>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get character names Resolve a set of character IDs to character names ---
     * Alternate route: &#x60;/v1/characters/names/&#x60; Alternate route:
     * &#x60;/legacy/characters/names/&#x60; Alternate route:
     * &#x60;/dev/characters/names/&#x60; --- This route is cached for up to
     * 3600 seconds
     * 
     * @param characterIds
     *            A comma separated list of character IDs (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @return List<CharacterNamesResponse>
     * @throws ApiException
     *             if fails to make API call
     */
    public List<CharacterNamesResponse> getCharactersNames(List<Long> characterIds, String datasource)
            throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'characterIds' is set
        if (characterIds == null) {
            throw new ApiException(400, "Missing the required parameter 'characterIds' when calling getCharactersNames");
        }

        // create path and map variables
        String localVarPath = "/characters/names/".replaceAll("\\{format\\}", "json");

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("csv", "character_ids", characterIds));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {};

        GenericType<List<CharacterNamesResponse>> localVarReturnType = new GenericType<List<CharacterNamesResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Calculate a CSPA charge cost Takes a source character ID in the url and a
     * set of target character ID&#39;s in the body, returns a CSPA charge cost
     * --- Alternate route: &#x60;/v3/characters/{character_id}/cspa/&#x60;
     * Alternate route: &#x60;/legacy/characters/{character_id}/cspa/&#x60;
     * Alternate route: &#x60;/dev/characters/{character_id}/cspa/&#x60; SSO
     * Scope: esi-characters.read_contacts.v1
     * 
     * @param characterId
     *            An EVE character ID (required)
     * @param characters
     *            The target characters to calculate the charge for (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @return CspaCostResponse
     * @throws ApiException
     *             if fails to make API call
     */
    public CspaCostResponse postCharactersCharacterIdCspa(Integer characterId, CspaCharacters characters,
            String datasource) throws ApiException {
        Object localVarPostBody = characters;

        // verify the required parameter 'characterId' is set
        if (characterId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'characterId' when calling postCharactersCharacterIdCspa");
        }

        // verify the required parameter 'characters' is set
        if (characters == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'characters' when calling postCharactersCharacterIdCspa");
        }

        // create path and map variables
        String localVarPath = "/characters/{character_id}/cspa/".replaceAll("\\{format\\}", "json").replaceAll(
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

        GenericType<CspaCostResponse> localVarReturnType = new GenericType<CspaCostResponse>() {
        };
        return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }
}
