package net.troja.eve.esi.api;

import net.troja.eve.esi.ApiException;
import net.troja.eve.esi.ApiClient;
import net.troja.eve.esi.Configuration;
import net.troja.eve.esi.Pair;

import javax.ws.rs.core.GenericType;

import net.troja.eve.esi.model.WarResponse;
import net.troja.eve.esi.model.WarKillmailsResponse;

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
     * List wars Return a list of wars --- Alternate route:
     * &#x60;/v1/wars/&#x60; Alternate route: &#x60;/legacy/wars/&#x60;
     * Alternate route: &#x60;/dev/wars/&#x60; --- This route is cached for up
     * to 3600 seconds
     * 
     * @param page
     *            Which page to query, starting at 1, 2000 wars per page.
     *            (optional, default to 1)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @return List<Integer>
     * @throws ApiException
     *             if fails to make API call
     */
    public List<Integer> getWars(Integer page, String datasource) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/wars/".replaceAll("\\{format\\}", "json");

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "page", page));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));

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
     * Get war information Return details about a war --- Alternate route:
     * &#x60;/v1/wars/{war_id}/&#x60; Alternate route:
     * &#x60;/legacy/wars/{war_id}/&#x60; Alternate route:
     * &#x60;/dev/wars/{war_id}/&#x60; --- This route is cached for up to 3600
     * seconds
     * 
     * @param warId
     *            ID for a war (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @return WarResponse
     * @throws ApiException
     *             if fails to make API call
     */
    public WarResponse getWarsWarId(Integer warId, String datasource) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'warId' is set
        if (warId == null) {
            throw new ApiException(400, "Missing the required parameter 'warId' when calling getWarsWarId");
        }

        // create path and map variables
        String localVarPath = "/wars/{war_id}/".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "war_id" + "\\}",
                apiClient.escapeString(warId.toString()));

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

        GenericType<WarResponse> localVarReturnType = new GenericType<WarResponse>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * List kills for a war Return a list of kills related to a war ---
     * Alternate route: &#x60;/v1/wars/{war_id}/killmails/&#x60; Alternate
     * route: &#x60;/legacy/wars/{war_id}/killmails/&#x60; Alternate route:
     * &#x60;/dev/wars/{war_id}/killmails/&#x60; --- This route is cached for up
     * to 3600 seconds
     * 
     * @param warId
     *            A valid war ID (required)
     * @param page
     *            Which page to query, starting at 1, 2000 killmails per page.
     *            (optional, default to 1)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @return List<WarKillmailsResponse>
     * @throws ApiException
     *             if fails to make API call
     */
    public List<WarKillmailsResponse> getWarsWarIdKillmails(Integer warId, Integer page, String datasource)
            throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'warId' is set
        if (warId == null) {
            throw new ApiException(400, "Missing the required parameter 'warId' when calling getWarsWarIdKillmails");
        }

        // create path and map variables
        String localVarPath = "/wars/{war_id}/killmails/".replaceAll("\\{format\\}", "json").replaceAll(
                "\\{" + "war_id" + "\\}", apiClient.escapeString(warId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "page", page));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));

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
