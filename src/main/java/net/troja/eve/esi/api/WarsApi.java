package net.troja.eve.esi.api;

import net.troja.eve.esi.ApiException;
import net.troja.eve.esi.ApiClient;
import net.troja.eve.esi.Configuration;
import net.troja.eve.esi.Pair;

import javax.ws.rs.core.GenericType;

import net.troja.eve.esi.model.InternalServerError;
import net.troja.eve.esi.model.WarKillmailsResponse;
import net.troja.eve.esi.model.WarResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WarsApi {
    private ApiClient apiClient;

    public WarsApi() {
        this(Configuration.getDefaultApiClient());
    }

    public WarsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * List wars Return a list of wars --- This route is cached for up to 3600
     * seconds
     * 
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param maxWarId
     *            Only return wars with ID smaller than this. (optional)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return List&lt;Integer&gt;
     * @throws ApiException
     *             if fails to make API call
     */
    public List<Integer> getWars(String datasource, Integer maxWarId, String userAgent, String xUserAgent)
            throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/v1/wars/".replaceAll("\\{format\\}", "json");

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "max_war_id", maxWarId));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "user_agent", userAgent));

        if (xUserAgent != null)
            localVarHeaderParams.put("X-User-Agent", apiClient.parameterToString(xUserAgent));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {};

        GenericType<List<Integer>> localVarReturnType = new GenericType<List<Integer>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get war information Return details about a war --- This route is cached
     * for up to 3600 seconds
     * 
     * @param warId
     *            ID for a war (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return WarResponse
     * @throws ApiException
     *             if fails to make API call
     */
    public WarResponse getWarsWarId(Integer warId, String datasource, String userAgent, String xUserAgent)
            throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'warId' is set
        if (warId == null) {
            throw new ApiException(400, "Missing the required parameter 'warId' when calling getWarsWarId");
        }

        // create path and map variables
        String localVarPath = "/v1/wars/{war_id}/".replaceAll("\\{format\\}", "json").replaceAll(
                "\\{" + "war_id" + "\\}", apiClient.escapeString(warId.toString()));

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

        GenericType<WarResponse> localVarReturnType = new GenericType<WarResponse>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * List kills for a war Return a list of kills related to a war --- This
     * route is cached for up to 3600 seconds
     * 
     * @param warId
     *            A valid war ID (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param page
     *            Which page of results to return (optional, default to 1)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return List&lt;WarKillmailsResponse&gt;
     * @throws ApiException
     *             if fails to make API call
     */
    public List<WarKillmailsResponse> getWarsWarIdKillmails(Integer warId, String datasource, Integer page,
            String userAgent, String xUserAgent) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'warId' is set
        if (warId == null) {
            throw new ApiException(400, "Missing the required parameter 'warId' when calling getWarsWarIdKillmails");
        }

        // create path and map variables
        String localVarPath = "/v1/wars/{war_id}/killmails/".replaceAll("\\{format\\}", "json").replaceAll(
                "\\{" + "war_id" + "\\}", apiClient.escapeString(warId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "page", page));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "user_agent", userAgent));

        if (xUserAgent != null)
            localVarHeaderParams.put("X-User-Agent", apiClient.parameterToString(xUserAgent));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {};

        GenericType<List<WarKillmailsResponse>> localVarReturnType = new GenericType<List<WarKillmailsResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }
}
