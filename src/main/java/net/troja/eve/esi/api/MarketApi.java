package net.troja.eve.esi.api;

import net.troja.eve.esi.ApiException;
import net.troja.eve.esi.ApiClient;
import net.troja.eve.esi.Configuration;
import net.troja.eve.esi.Pair;

import javax.ws.rs.core.GenericType;

import net.troja.eve.esi.model.MarketPricesResponse;
import net.troja.eve.esi.model.MarketHistoryResponse;
import net.troja.eve.esi.model.MarketOrdersResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MarketApi {
    private ApiClient apiClient;

    public MarketApi() {
        this(Configuration.getDefaultApiClient());
    }

    public MarketApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * List market prices Return a list of prices --- Alternate route:
     * &#x60;/v1/markets/prices/&#x60; Alternate route:
     * &#x60;/legacy/markets/prices/&#x60; Alternate route:
     * &#x60;/dev/markets/prices/&#x60; --- This route is cached for up to 3600
     * seconds
     * 
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @return List<MarketPricesResponse>
     * @throws ApiException
     *             if fails to make API call
     */
    public List<MarketPricesResponse> getMarketsPrices(String datasource) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/markets/prices/".replaceAll("\\{format\\}", "json");

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

        GenericType<List<MarketPricesResponse>> localVarReturnType = new GenericType<List<MarketPricesResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * List historical market statistics in a region Return a list of historical
     * market statistics for the specified type in a region --- Alternate route:
     * &#x60;/v1/markets/{region_id}/history/&#x60; Alternate route:
     * &#x60;/legacy/markets/{region_id}/history/&#x60; Alternate route:
     * &#x60;/dev/markets/{region_id}/history/&#x60; --- This route is cached
     * for up to 300 seconds
     * 
     * @param regionId
     *            Return statistics in this region (required)
     * @param typeId
     *            Return statistics for this type (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @return List<MarketHistoryResponse>
     * @throws ApiException
     *             if fails to make API call
     */
    public List<MarketHistoryResponse> getMarketsRegionIdHistory(Long regionId, Long typeId, String datasource)
            throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'regionId' is set
        if (regionId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'regionId' when calling getMarketsRegionIdHistory");
        }

        // verify the required parameter 'typeId' is set
        if (typeId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'typeId' when calling getMarketsRegionIdHistory");
        }

        // create path and map variables
        String localVarPath = "/markets/{region_id}/history/".replaceAll("\\{format\\}", "json").replaceAll(
                "\\{" + "region_id" + "\\}", apiClient.escapeString(regionId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "type_id", typeId));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {};

        GenericType<List<MarketHistoryResponse>> localVarReturnType = new GenericType<List<MarketHistoryResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * List orders in a region Return a list of orders in a region --- Alternate
     * route: &#x60;/v1/markets/{region_id}/orders/&#x60; Alternate route:
     * &#x60;/legacy/markets/{region_id}/orders/&#x60; Alternate route:
     * &#x60;/dev/markets/{region_id}/orders/&#x60; --- This route is cached for
     * up to 300 seconds
     * 
     * @param regionId
     *            Return orders in this region (required)
     * @param orderType
     *            Filter buy/sell orders, return all orders by default. If you
     *            query without type_id, we always return both buy and sell
     *            orders. (required)
     * @param typeId
     *            Return orders only for this type (optional)
     * @param page
     *            Which page to query, only used for querying without type_id.
     *            Starting at 1 (optional, default to 1)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @return List<MarketOrdersResponse>
     * @throws ApiException
     *             if fails to make API call
     */
    public List<MarketOrdersResponse> getMarketsRegionIdOrders(Long regionId, String orderType, Long typeId,
            Integer page, String datasource) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'regionId' is set
        if (regionId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'regionId' when calling getMarketsRegionIdOrders");
        }

        // verify the required parameter 'orderType' is set
        if (orderType == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'orderType' when calling getMarketsRegionIdOrders");
        }

        // create path and map variables
        String localVarPath = "/markets/{region_id}/orders/".replaceAll("\\{format\\}", "json").replaceAll(
                "\\{" + "region_id" + "\\}", apiClient.escapeString(regionId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "type_id", typeId));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "order_type", orderType));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "page", page));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {};

        GenericType<List<MarketOrdersResponse>> localVarReturnType = new GenericType<List<MarketOrdersResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }
}
