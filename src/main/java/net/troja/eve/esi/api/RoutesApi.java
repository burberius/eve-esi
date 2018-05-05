package net.troja.eve.esi.api;

import net.troja.eve.esi.ApiException;
import net.troja.eve.esi.ApiClient;
import net.troja.eve.esi.Configuration;
import net.troja.eve.esi.Pair;

import javax.ws.rs.core.GenericType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoutesApi {
    private ApiClient apiClient;

    public RoutesApi() {
        this(Configuration.getDefaultApiClient());
    }

    public RoutesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Get route Get the systems between origin and destination --- This route
     * is cached for up to 86400 seconds
     * 
     * @param destination
     *            destination solar system ID (required)
     * @param origin
     *            origin solar system ID (required)
     * @param avoid
     *            avoid solar system ID(s) (optional)
     * @param connections
     *            connected solar system pairs (optional)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param flag
     *            route security preference (optional, default to shortest)
     * @param ifNoneMatch
     *            ETag from a previous request. A 304 will be returned if this
     *            matches the current ETag (optional)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return List&lt;Integer&gt;
     * @throws ApiException
     *             if fails to make API call
     */
    public List<Integer> getRouteOriginDestination(Integer destination, Integer origin, List<Integer> avoid,
            List<List<Integer>> connections, String datasource, String flag, String ifNoneMatch, String userAgent,
            String xUserAgent) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'destination' is set
        if (destination == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'destination' when calling getRouteOriginDestination");
        }

        // verify the required parameter 'origin' is set
        if (origin == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'origin' when calling getRouteOriginDestination");
        }

        // create path and map variables
        String localVarPath = "/v1/route/{origin}/{destination}/".replaceAll("\\{format\\}", "json")
                .replaceAll("\\{" + "destination" + "\\}", apiClient.escapeString(destination.toString()))
                .replaceAll("\\{" + "origin" + "\\}", apiClient.escapeString(origin.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("csv", "avoid", avoid));
        localVarQueryParams.addAll(apiClient.parameterToPairs("csv", "connections", connections));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "flag", flag));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "user_agent", userAgent));

        if (ifNoneMatch != null)
            localVarHeaderParams.put("If-None-Match", apiClient.parameterToString(ifNoneMatch));
        if (xUserAgent != null)
            localVarHeaderParams.put("X-User-Agent", apiClient.parameterToString(xUserAgent));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = { "application/json" };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {};

        GenericType<List<Integer>> localVarReturnType = new GenericType<List<Integer>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }
}
