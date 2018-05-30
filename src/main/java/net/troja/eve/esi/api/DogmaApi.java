package net.troja.eve.esi.api;

import net.troja.eve.esi.ApiException;
import net.troja.eve.esi.ApiClient;
import net.troja.eve.esi.Configuration;
import net.troja.eve.esi.Pair;

import javax.ws.rs.core.GenericType;

import net.troja.eve.esi.model.DogmaAttributeResponse;
import net.troja.eve.esi.model.DogmaDynamicItemsResponse;
import net.troja.eve.esi.model.DogmaEffectResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DogmaApi {
    private ApiClient apiClient;

    public DogmaApi() {
        this(Configuration.getDefaultApiClient());
    }

    public DogmaApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Get attributes Get a list of dogma attribute ids --- This route expires
     * daily at 11:05
     * 
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param ifNoneMatch
     *            ETag from a previous request. A 304 will be returned if this
     *            matches the current ETag (optional)
     * @return List&lt;Integer&gt;
     * @throws ApiException
     *             if fails to make API call
     */
    public List<Integer> getDogmaAttributes(String datasource, String ifNoneMatch) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/v1/dogma/attributes/".replaceAll("\\{format\\}", "json");

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

        GenericType<List<Integer>> localVarReturnType = new GenericType<List<Integer>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get attribute information Get information on a dogma attribute --- This
     * route expires daily at 11:05
     * 
     * @param attributeId
     *            A dogma attribute ID (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param ifNoneMatch
     *            ETag from a previous request. A 304 will be returned if this
     *            matches the current ETag (optional)
     * @return DogmaAttributeResponse
     * @throws ApiException
     *             if fails to make API call
     */
    public DogmaAttributeResponse getDogmaAttributesAttributeId(Integer attributeId, String datasource,
            String ifNoneMatch) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'attributeId' is set
        if (attributeId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'attributeId' when calling getDogmaAttributesAttributeId");
        }

        // create path and map variables
        String localVarPath = "/v1/dogma/attributes/{attribute_id}/".replaceAll("\\{format\\}", "json").replaceAll(
                "\\{" + "attribute_id" + "\\}", apiClient.escapeString(attributeId.toString()));

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

        GenericType<DogmaAttributeResponse> localVarReturnType = new GenericType<DogmaAttributeResponse>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get dynamic item information Returns info about a dynamic item resulting
     * from mutation with a mutaplasmid. --- This route expires daily at 11:05
     * 
     * @param itemId
     *            item_id integer (required)
     * @param typeId
     *            type_id integer (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param ifNoneMatch
     *            ETag from a previous request. A 304 will be returned if this
     *            matches the current ETag (optional)
     * @return DogmaDynamicItemsResponse
     * @throws ApiException
     *             if fails to make API call
     */
    public DogmaDynamicItemsResponse getDogmaDynamicItemsTypeIdItemId(Long itemId, Integer typeId, String datasource,
            String ifNoneMatch) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'itemId' is set
        if (itemId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'itemId' when calling getDogmaDynamicItemsTypeIdItemId");
        }

        // verify the required parameter 'typeId' is set
        if (typeId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'typeId' when calling getDogmaDynamicItemsTypeIdItemId");
        }

        // create path and map variables
        String localVarPath = "/v1/dogma/dynamic/items/{type_id}/{item_id}/".replaceAll("\\{format\\}", "json")
                .replaceAll("\\{" + "item_id" + "\\}", apiClient.escapeString(itemId.toString()))
                .replaceAll("\\{" + "type_id" + "\\}", apiClient.escapeString(typeId.toString()));

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

        GenericType<DogmaDynamicItemsResponse> localVarReturnType = new GenericType<DogmaDynamicItemsResponse>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get effects Get a list of dogma effect ids --- This route expires daily
     * at 11:05
     * 
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param ifNoneMatch
     *            ETag from a previous request. A 304 will be returned if this
     *            matches the current ETag (optional)
     * @return List&lt;Integer&gt;
     * @throws ApiException
     *             if fails to make API call
     */
    public List<Integer> getDogmaEffects(String datasource, String ifNoneMatch) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/v1/dogma/effects/".replaceAll("\\{format\\}", "json");

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

        GenericType<List<Integer>> localVarReturnType = new GenericType<List<Integer>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get effect information Get information on a dogma effect --- This route
     * expires daily at 11:05
     * 
     * @param effectId
     *            A dogma effect ID (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param ifNoneMatch
     *            ETag from a previous request. A 304 will be returned if this
     *            matches the current ETag (optional)
     * @return DogmaEffectResponse
     * @throws ApiException
     *             if fails to make API call
     */
    public DogmaEffectResponse getDogmaEffectsEffectId(Integer effectId, String datasource, String ifNoneMatch)
            throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'effectId' is set
        if (effectId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'effectId' when calling getDogmaEffectsEffectId");
        }

        // create path and map variables
        String localVarPath = "/v2/dogma/effects/{effect_id}/".replaceAll("\\{format\\}", "json").replaceAll(
                "\\{" + "effect_id" + "\\}", apiClient.escapeString(effectId.toString()));

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

        GenericType<DogmaEffectResponse> localVarReturnType = new GenericType<DogmaEffectResponse>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }
}
