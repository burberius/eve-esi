package net.troja.eve.esi.api;

import net.troja.eve.esi.ApiException;
import net.troja.eve.esi.ApiClient;
import net.troja.eve.esi.Configuration;
import net.troja.eve.esi.Pair;

import javax.ws.rs.core.GenericType;

import net.troja.eve.esi.model.SovereigntyCampaignsResponse;
import net.troja.eve.esi.model.SovereigntyStructuresResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SovereigntyApi {
    private ApiClient apiClient;

    public SovereigntyApi() {
        this(Configuration.getDefaultApiClient());
    }

    public SovereigntyApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * List sovereignty campaigns Shows sovereignty data for campaigns. ---
     * Alternate route: &#x60;/v1/sovereignty/campaigns/&#x60; Alternate route:
     * &#x60;/legacy/sovereignty/campaigns/&#x60; Alternate route:
     * &#x60;/dev/sovereignty/campaigns/&#x60; --- This route is cached for up
     * to 5 seconds
     * 
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return List<SovereigntyCampaignsResponse>
     * @throws ApiException
     *             if fails to make API call
     */
    public List<SovereigntyCampaignsResponse> getSovereigntyCampaigns(String datasource, String userAgent,
            String xUserAgent) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/sovereignty/campaigns/".replaceAll("\\{format\\}", "json");

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

        GenericType<List<SovereigntyCampaignsResponse>> localVarReturnType = new GenericType<List<SovereigntyCampaignsResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * List sovereignty structures Shows sovereignty data for structures. ---
     * Alternate route: &#x60;/v1/sovereignty/structures/&#x60; Alternate route:
     * &#x60;/legacy/sovereignty/structures/&#x60; Alternate route:
     * &#x60;/dev/sovereignty/structures/&#x60; --- This route is cached for up
     * to 120 seconds
     * 
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return List<SovereigntyStructuresResponse>
     * @throws ApiException
     *             if fails to make API call
     */
    public List<SovereigntyStructuresResponse> getSovereigntyStructures(String datasource, String userAgent,
            String xUserAgent) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/sovereignty/structures/".replaceAll("\\{format\\}", "json");

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

        GenericType<List<SovereigntyStructuresResponse>> localVarReturnType = new GenericType<List<SovereigntyStructuresResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }
}
