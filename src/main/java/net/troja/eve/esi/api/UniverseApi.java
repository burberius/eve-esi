package net.troja.eve.esi.api;

import net.troja.eve.esi.ApiException;
import net.troja.eve.esi.ApiClient;
import net.troja.eve.esi.Configuration;
import net.troja.eve.esi.Pair;

import javax.ws.rs.core.GenericType;

import net.troja.eve.esi.model.StationResponse;
import net.troja.eve.esi.model.StructureResponse;
import net.troja.eve.esi.model.SystemResponse;
import net.troja.eve.esi.model.TypeResponse;
import net.troja.eve.esi.model.UniverseNamesResponse;
import net.troja.eve.esi.model.EntityIds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniverseApi {
    private ApiClient apiClient;

    public UniverseApi() {
        this(Configuration.getDefaultApiClient());
    }

    public UniverseApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Get station information Public information on stations --- Alternate
     * route: &#x60;/v1/universe/stations/{station_id}/&#x60; Alternate route:
     * &#x60;/legacy/universe/stations/{station_id}/&#x60; Alternate route:
     * &#x60;/dev/universe/stations/{station_id}/&#x60; --- This route is cached
     * for up to 3600 seconds
     * 
     * @param stationId
     *            An Eve station ID (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @return StationResponse
     * @throws ApiException
     *             if fails to make API call
     */
    public StationResponse getUniverseStationsStationId(Integer stationId, String datasource) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'stationId' is set
        if (stationId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'stationId' when calling getUniverseStationsStationId");
        }

        // create path and map variables
        String localVarPath = "/universe/stations/{station_id}/".replaceAll("\\{format\\}", "json").replaceAll(
                "\\{" + "station_id" + "\\}", apiClient.escapeString(stationId.toString()));

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

        GenericType<StationResponse> localVarReturnType = new GenericType<StationResponse>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * List all public structures List all public structures --- Alternate
     * route: &#x60;/v1/universe/structures/&#x60; Alternate route:
     * &#x60;/legacy/universe/structures/&#x60; Alternate route:
     * &#x60;/dev/universe/structures/&#x60; --- This route is cached for up to
     * 3600 seconds
     * 
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @return List<Long>
     * @throws ApiException
     *             if fails to make API call
     */
    public List<Long> getUniverseStructures(String datasource) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/universe/structures/".replaceAll("\\{format\\}", "json");

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

        GenericType<List<Long>> localVarReturnType = new GenericType<List<Long>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get structure information Returns information on requested structure, if
     * you are on the ACL. Otherwise, returns \&quot;Forbidden\&quot; for all
     * inputs. --- Alternate route:
     * &#x60;/v1/universe/structures/{structure_id}/&#x60; Alternate route:
     * &#x60;/legacy/universe/structures/{structure_id}/&#x60; Alternate route:
     * &#x60;/dev/universe/structures/{structure_id}/&#x60;
     * 
     * @param structureId
     *            An Eve structure ID (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @return StructureResponse
     * @throws ApiException
     *             if fails to make API call
     */
    public StructureResponse getUniverseStructuresStructureId(Long structureId, String datasource) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'structureId' is set
        if (structureId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'structureId' when calling getUniverseStructuresStructureId");
        }

        // create path and map variables
        String localVarPath = "/universe/structures/{structure_id}/".replaceAll("\\{format\\}", "json").replaceAll(
                "\\{" + "structure_id" + "\\}", apiClient.escapeString(structureId.toString()));

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

        String[] localVarAuthNames = new String[] { "evesso" };

        GenericType<StructureResponse> localVarReturnType = new GenericType<StructureResponse>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get solar system information Information on solar systems --- Alternate
     * route: &#x60;/v1/universe/systems/{system_id}/&#x60; Alternate route:
     * &#x60;/legacy/universe/systems/{system_id}/&#x60; Alternate route:
     * &#x60;/dev/universe/systems/{system_id}/&#x60; --- This route is cached
     * for up to 3600 seconds
     * 
     * @param systemId
     *            An Eve solar system ID (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @return SystemResponse
     * @throws ApiException
     *             if fails to make API call
     */
    public SystemResponse getUniverseSystemsSystemId(Integer systemId, String datasource) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'systemId' is set
        if (systemId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'systemId' when calling getUniverseSystemsSystemId");
        }

        // create path and map variables
        String localVarPath = "/universe/systems/{system_id}/".replaceAll("\\{format\\}", "json").replaceAll(
                "\\{" + "system_id" + "\\}", apiClient.escapeString(systemId.toString()));

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

        GenericType<SystemResponse> localVarReturnType = new GenericType<SystemResponse>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get type information Get information on a type --- Alternate route:
     * &#x60;/v1/universe/types/{type_id}/&#x60; Alternate route:
     * &#x60;/legacy/universe/types/{type_id}/&#x60; Alternate route:
     * &#x60;/dev/universe/types/{type_id}/&#x60; --- This route is cached for
     * up to 3600 seconds
     * 
     * @param typeId
     *            An Eve item type ID (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @return TypeResponse
     * @throws ApiException
     *             if fails to make API call
     */
    public TypeResponse getUniverseTypesTypeId(Integer typeId, String datasource) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'typeId' is set
        if (typeId == null) {
            throw new ApiException(400, "Missing the required parameter 'typeId' when calling getUniverseTypesTypeId");
        }

        // create path and map variables
        String localVarPath = "/universe/types/{type_id}/".replaceAll("\\{format\\}", "json").replaceAll(
                "\\{" + "type_id" + "\\}", apiClient.escapeString(typeId.toString()));

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

        GenericType<TypeResponse> localVarReturnType = new GenericType<TypeResponse>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get names and categories for a set of ID&#39;s Resolve a set of IDs to
     * names and categories. Supported ID&#39;s for resolving are: Characters,
     * Corporations, Alliances, Stations, Solar Systems, Constellations,
     * Regions, Types. --- Alternate route: &#x60;/v1/universe/names/&#x60;
     * Alternate route: &#x60;/legacy/universe/names/&#x60;
     * 
     * @param ids
     *            The ids to resolve (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @return List<UniverseNamesResponse>
     * @throws ApiException
     *             if fails to make API call
     */
    public List<UniverseNamesResponse> postUniverseNames(EntityIds ids, String datasource) throws ApiException {
        Object localVarPostBody = ids;

        // verify the required parameter 'ids' is set
        if (ids == null) {
            throw new ApiException(400, "Missing the required parameter 'ids' when calling postUniverseNames");
        }

        // create path and map variables
        String localVarPath = "/universe/names/".replaceAll("\\{format\\}", "json");

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

        GenericType<List<UniverseNamesResponse>> localVarReturnType = new GenericType<List<UniverseNamesResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }
}
