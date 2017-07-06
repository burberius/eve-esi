package net.troja.eve.esi.api;

import net.troja.eve.esi.ApiException;
import net.troja.eve.esi.ApiClient;
import net.troja.eve.esi.Configuration;
import net.troja.eve.esi.Pair;

import javax.ws.rs.core.GenericType;

import net.troja.eve.esi.model.CharacterKillmailsResponse;
import net.troja.eve.esi.model.Forbidden;
import net.troja.eve.esi.model.InternalServerError;
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
     * List kills and losses Return a list of character&#39;s recent kills and
     * losses --- This route is cached for up to 120 seconds SSO Scope:
     * esi-killmails.read_killmails.v1
     * 
     * @param characterId
     *            An EVE character ID (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param maxCount
     *            How many killmails to return at maximum (optional, default to
     *            50)
     * @param maxKillId
     *            Only return killmails with ID smaller than this. (optional)
     * @param token
     *            Access token to use if unable to set a header (optional)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return List&lt;CharacterKillmailsResponse&gt;
     * @throws ApiException
     *             if fails to make API call
     */
    public List<CharacterKillmailsResponse> getCharactersCharacterIdKillmailsRecent(Integer characterId,
            String datasource, Integer maxCount, Integer maxKillId, String token, String userAgent, String xUserAgent)
            throws ApiException {
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
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "max_count", maxCount));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "max_kill_id", maxKillId));
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

        GenericType<List<CharacterKillmailsResponse>> localVarReturnType = new GenericType<List<CharacterKillmailsResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get a single killmail Return a single killmail from its ID and hash ---
     * This route is cached for up to 3600 seconds
     * 
     * @param killmailHash
     *            The killmail hash for verification (required)
     * @param killmailId
     *            The killmail ID to be queried (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return KillmailResponse
     * @throws ApiException
     *             if fails to make API call
     */
    public KillmailResponse getKillmailsKillmailIdKillmailHash(String killmailHash, Integer killmailId,
            String datasource, String userAgent, String xUserAgent) throws ApiException {
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
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "user_agent", userAgent));

        if (xUserAgent != null)
            localVarHeaderParams.put("X-User-Agent", apiClient.parameterToString(xUserAgent));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {};

        GenericType<KillmailResponse> localVarReturnType = new GenericType<KillmailResponse>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }
}
