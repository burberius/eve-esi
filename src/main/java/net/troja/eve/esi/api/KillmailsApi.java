package net.troja.eve.esi.api;

import net.troja.eve.esi.ApiException;
import net.troja.eve.esi.ApiClient;
import net.troja.eve.esi.Configuration;
import net.troja.eve.esi.Pair;

import javax.ws.rs.core.GenericType;

import net.troja.eve.esi.model.CharacterKillmailsResponse;
import net.troja.eve.esi.model.CorporationKillmailsResponse;
import net.troja.eve.esi.model.KillmailResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KillmailsApi {
    private ApiClient apiClient;

    public KillmailsApi() {
        this(Configuration.getDefaultApiClient());
    }

    public KillmailsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Get a character&#39;s recent kills and losses Return a list of a
     * character&#39;s kills and losses going back 90 days --- This route is
     * cached for up to 300 seconds SSO Scope: esi-killmails.read_killmails.v1
     * 
     * @param characterId
     *            An EVE character ID (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param ifNoneMatch
     *            ETag from a previous request. A 304 will be returned if this
     *            matches the current ETag (optional)
     * @param page
     *            Which page of results to return (optional, default to 1)
     * @param token
     *            Access token to use if unable to set a header (optional)
     * @return List&lt;CharacterKillmailsResponse&gt;
     * @throws ApiException
     *             if fails to make API call
     */
    public List<CharacterKillmailsResponse> getCharactersCharacterIdKillmailsRecent(Integer characterId,
            String datasource, String ifNoneMatch, Integer page, String token) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'characterId' is set
        if (characterId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'characterId' when calling getCharactersCharacterIdKillmailsRecent");
        }

        // create path and map variables
        String localVarPath = "/v1/characters/{character_id}/killmails/recent/".replaceAll("\\{format\\}", "json")
                .replaceAll("\\{" + "character_id" + "\\}", apiClient.escapeString(characterId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "page", page));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "token", token));

        if (ifNoneMatch != null)
            localVarHeaderParams.put("If-None-Match", apiClient.parameterToString(ifNoneMatch));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = { "application/json" };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "evesso" };

        GenericType<List<CharacterKillmailsResponse>> localVarReturnType = new GenericType<List<CharacterKillmailsResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get a corporation&#39;s recent kills and losses Get a list of a
     * corporation&#39;s kills and losses going back 90 days --- This route is
     * cached for up to 300 seconds --- Requires one of the following EVE
     * corporation role(s): Director SSO Scope:
     * esi-killmails.read_corporation_killmails.v1
     * 
     * @param corporationId
     *            An EVE corporation ID (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param ifNoneMatch
     *            ETag from a previous request. A 304 will be returned if this
     *            matches the current ETag (optional)
     * @param page
     *            Which page of results to return (optional, default to 1)
     * @param token
     *            Access token to use if unable to set a header (optional)
     * @return List&lt;CorporationKillmailsResponse&gt;
     * @throws ApiException
     *             if fails to make API call
     */
    public List<CorporationKillmailsResponse> getCorporationsCorporationIdKillmailsRecent(Integer corporationId,
            String datasource, String ifNoneMatch, Integer page, String token) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'corporationId' is set
        if (corporationId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'corporationId' when calling getCorporationsCorporationIdKillmailsRecent");
        }

        // create path and map variables
        String localVarPath = "/v1/corporations/{corporation_id}/killmails/recent/".replaceAll("\\{format\\}", "json")
                .replaceAll("\\{" + "corporation_id" + "\\}", apiClient.escapeString(corporationId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "page", page));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "token", token));

        if (ifNoneMatch != null)
            localVarHeaderParams.put("If-None-Match", apiClient.parameterToString(ifNoneMatch));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = { "application/json" };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "evesso" };

        GenericType<List<CorporationKillmailsResponse>> localVarReturnType = new GenericType<List<CorporationKillmailsResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get a single killmail Return a single killmail from its ID and hash ---
     * This route is cached for up to 1209600 seconds
     * 
     * @param killmailHash
     *            The killmail hash for verification (required)
     * @param killmailId
     *            The killmail ID to be queried (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param ifNoneMatch
     *            ETag from a previous request. A 304 will be returned if this
     *            matches the current ETag (optional)
     * @return KillmailResponse
     * @throws ApiException
     *             if fails to make API call
     */
    public KillmailResponse getKillmailsKillmailIdKillmailHash(String killmailHash, Integer killmailId,
            String datasource, String ifNoneMatch) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'killmailHash' is set
        if (killmailHash == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'killmailHash' when calling getKillmailsKillmailIdKillmailHash");
        }

        // verify the required parameter 'killmailId' is set
        if (killmailId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'killmailId' when calling getKillmailsKillmailIdKillmailHash");
        }

        // create path and map variables
        String localVarPath = "/v1/killmails/{killmail_id}/{killmail_hash}/".replaceAll("\\{format\\}", "json")
                .replaceAll("\\{" + "killmail_hash" + "\\}", apiClient.escapeString(killmailHash.toString()))
                .replaceAll("\\{" + "killmail_id" + "\\}", apiClient.escapeString(killmailId.toString()));

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

        GenericType<KillmailResponse> localVarReturnType = new GenericType<KillmailResponse>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }
}
