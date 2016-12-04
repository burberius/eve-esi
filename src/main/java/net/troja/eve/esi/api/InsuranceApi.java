package net.troja.eve.esi.api;

import net.troja.eve.esi.ApiException;
import net.troja.eve.esi.ApiClient;
import net.troja.eve.esi.Configuration;
import net.troja.eve.esi.Pair;

import javax.ws.rs.core.GenericType;

import net.troja.eve.esi.model.InsurancePricesResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InsuranceApi {
    private ApiClient apiClient;

    public InsuranceApi() {
        this(Configuration.getDefaultApiClient());
    }

    public InsuranceApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * List insurance levels Return available insurance levels for all ship
     * types --- Alternate route: &#x60;/v1/insurance/prices/&#x60; Alternate
     * route: &#x60;/legacy/insurance/prices/&#x60; Alternate route:
     * &#x60;/dev/insurance/prices/&#x60; --- This route is cached for up to
     * 3600 seconds
     * 
     * @param acceptLanguage
     *            Language to use in the response (optional, default to en)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @return List<InsurancePricesResponse>
     * @throws ApiException
     *             if fails to make API call
     */
    public List<InsurancePricesResponse> getInsurancePrices(String acceptLanguage, String datasource)
            throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/insurance/prices/".replaceAll("\\{format\\}", "json");

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));

        if (acceptLanguage != null)
            localVarHeaderParams.put("Accept-Language", apiClient.parameterToString(acceptLanguage));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {};

        GenericType<List<InsurancePricesResponse>> localVarReturnType = new GenericType<List<InsurancePricesResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }
}
