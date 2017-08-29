package net.troja.eve.esi.api;

import net.troja.eve.esi.ApiException;
import net.troja.eve.esi.ApiClient;
import net.troja.eve.esi.Configuration;
import net.troja.eve.esi.Pair;

import javax.ws.rs.core.GenericType;

import net.troja.eve.esi.model.FactionWarfareLeaderboardCharactersResponse;
import net.troja.eve.esi.model.FactionWarfareLeaderboardCorporationsResponse;
import net.troja.eve.esi.model.FactionWarfareLeaderboardResponse;
import net.troja.eve.esi.model.FactionWarfareStatsResponse;
import net.troja.eve.esi.model.FactionWarfareSystemsResponse;
import net.troja.eve.esi.model.FactionWarfareWarsResponse;
import net.troja.eve.esi.model.InternalServerError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FactionWarfareApi {
    private ApiClient apiClient;

    public FactionWarfareApi() {
        this(Configuration.getDefaultApiClient());
    }

    public FactionWarfareApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * List of the top factions in faction warfare Top 4 leaderboard of factions
     * for kills and victory points separated by total, last week and yesterday.
     * --- This route expires daily at 11:05
     * 
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return FactionWarfareLeaderboardResponse
     * @throws ApiException
     *             if fails to make API call
     */
    public FactionWarfareLeaderboardResponse getFwLeaderboards(String datasource, String userAgent, String xUserAgent)
            throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/v1/fw/leaderboards/".replaceAll("\\{format\\}", "json");

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

        GenericType<FactionWarfareLeaderboardResponse> localVarReturnType = new GenericType<FactionWarfareLeaderboardResponse>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * List of the top pilots in faction warfare Top 100 leaderboard of pilots
     * for kills and victory points separated by total, last week and yesterday.
     * --- This route expires daily at 11:05
     * 
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return FactionWarfareLeaderboardCharactersResponse
     * @throws ApiException
     *             if fails to make API call
     */
    public FactionWarfareLeaderboardCharactersResponse getFwLeaderboardsCharacters(String datasource, String userAgent,
            String xUserAgent) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/v1/fw/leaderboards/characters/".replaceAll("\\{format\\}", "json");

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

        GenericType<FactionWarfareLeaderboardCharactersResponse> localVarReturnType = new GenericType<FactionWarfareLeaderboardCharactersResponse>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * List of the top corporations in faction warfare Top 10 leaderboard of
     * corporations for kills and victory points separated by total, last week
     * and yesterday. --- This route expires daily at 11:05
     * 
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return FactionWarfareLeaderboardCorporationsResponse
     * @throws ApiException
     *             if fails to make API call
     */
    public FactionWarfareLeaderboardCorporationsResponse getFwLeaderboardsCorporations(String datasource,
            String userAgent, String xUserAgent) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/v1/fw/leaderboards/corporations/".replaceAll("\\{format\\}", "json");

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

        GenericType<FactionWarfareLeaderboardCorporationsResponse> localVarReturnType = new GenericType<FactionWarfareLeaderboardCorporationsResponse>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * An overview of statistics about factions involved in faction warfare
     * Statistical overviews of factions involved in faction warfare --- This
     * route expires daily at 11:05
     * 
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return List&lt;FactionWarfareStatsResponse&gt;
     * @throws ApiException
     *             if fails to make API call
     */
    public List<FactionWarfareStatsResponse> getFwStats(String datasource, String userAgent, String xUserAgent)
            throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/v1/fw/stats/".replaceAll("\\{format\\}", "json");

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

        GenericType<List<FactionWarfareStatsResponse>> localVarReturnType = new GenericType<List<FactionWarfareStatsResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Ownership of faction warfare systems An overview of the current ownership
     * of faction warfare solar systems --- This route is cached for up to 1800
     * seconds
     * 
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return List&lt;FactionWarfareSystemsResponse&gt;
     * @throws ApiException
     *             if fails to make API call
     */
    public List<FactionWarfareSystemsResponse> getFwSystems(String datasource, String userAgent, String xUserAgent)
            throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/v1/fw/systems/".replaceAll("\\{format\\}", "json");

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

        GenericType<List<FactionWarfareSystemsResponse>> localVarReturnType = new GenericType<List<FactionWarfareSystemsResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Data about which NPC factions are at war Data about which NPC factions
     * are at war --- This route expires daily at 11:05
     * 
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return List&lt;FactionWarfareWarsResponse&gt;
     * @throws ApiException
     *             if fails to make API call
     */
    public List<FactionWarfareWarsResponse> getFwWars(String datasource, String userAgent, String xUserAgent)
            throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/v1/fw/wars/".replaceAll("\\{format\\}", "json");

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

        GenericType<List<FactionWarfareWarsResponse>> localVarReturnType = new GenericType<List<FactionWarfareWarsResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }
}
