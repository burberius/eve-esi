package net.troja.eve.esi.api;

import net.troja.eve.esi.ApiException;
import net.troja.eve.esi.ApiClient;
import net.troja.eve.esi.Configuration;
import net.troja.eve.esi.Pair;

import javax.ws.rs.core.GenericType;

import net.troja.eve.esi.model.IndustryFacilitiesResponse;
import net.troja.eve.esi.model.IndustrySystemsResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IndustryApi {
    private ApiClient apiClient;

    public IndustryApi() {
        this(Configuration.getDefaultApiClient());
    }

    public IndustryApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * List industry facilities Return a list of industry facilities ---
     * Alternate route: &#x60;/v1/industry/facilities/&#x60; Alternate route:
     * &#x60;/legacy/industry/facilities/&#x60; Alternate route:
     * &#x60;/dev/industry/facilities/&#x60; --- This route is cached for up to
     * 3600 seconds
     * 
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @return List<IndustryFacilitiesResponse>
     * @throws ApiException
     *             if fails to make API call
     */
    public List<IndustryFacilitiesResponse> getIndustryFacilities(String datasource) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/industry/facilities/".replaceAll("\\{format\\}", "json");

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

        GenericType<List<IndustryFacilitiesResponse>> localVarReturnType = new GenericType<List<IndustryFacilitiesResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * List solar system cost indices Return cost indices for solar systems ---
     * Alternate route: &#x60;/v1/industry/systems/&#x60; Alternate route:
     * &#x60;/legacy/industry/systems/&#x60; Alternate route:
     * &#x60;/dev/industry/systems/&#x60; --- This route is cached for up to
     * 3600 seconds
     * 
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @return List<IndustrySystemsResponse>
     * @throws ApiException
     *             if fails to make API call
     */
    public List<IndustrySystemsResponse> getIndustrySystems(String datasource) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/industry/systems/".replaceAll("\\{format\\}", "json");

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

        GenericType<List<IndustrySystemsResponse>> localVarReturnType = new GenericType<List<IndustrySystemsResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }
}
