package net.troja.eve.esi.api;

import net.troja.eve.esi.ApiException;
import net.troja.eve.esi.ApiClient;
import net.troja.eve.esi.Configuration;
import net.troja.eve.esi.Pair;

import javax.ws.rs.core.GenericType;

import net.troja.eve.esi.model.CorporationAlliancesHistoryResponse;
import net.troja.eve.esi.model.CorporationIconsResponse;
import net.troja.eve.esi.model.CorporationMembersResponse;
import net.troja.eve.esi.model.CorporationNamesResponse;
import net.troja.eve.esi.model.CorporationResponse;
import net.troja.eve.esi.model.CorporationRolesResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CorporationApi {
    private ApiClient apiClient;

    public CorporationApi() {
        this(Configuration.getDefaultApiClient());
    }

    public CorporationApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Get corporation information Public information about a corporation ---
     * Alternate route: &#x60;/v2/corporations/{corporation_id}/&#x60; --- This
     * route is cached for up to 3600 seconds
     * 
     * @param corporationId
     *            An Eve corporation ID (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @return CorporationResponse
     * @throws ApiException
     *             if fails to make API call
     */
    public CorporationResponse getCorporationsCorporationId(Integer corporationId, String datasource)
            throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'corporationId' is set
        if (corporationId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'corporationId' when calling getCorporationsCorporationId");
        }

        // create path and map variables
        String localVarPath = "/corporations/{corporation_id}/".replaceAll("\\{format\\}", "json").replaceAll(
                "\\{" + "corporation_id" + "\\}", apiClient.escapeString(corporationId.toString()));

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

        GenericType<CorporationResponse> localVarReturnType = new GenericType<CorporationResponse>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get alliance history Get a list of all the alliances a corporation has
     * been a member of --- Alternate route:
     * &#x60;/v1/corporations/{corporation_id}/alliancehistory/&#x60; Alternate
     * route: &#x60;/legacy/corporations/{corporation_id}/alliancehistory/&#x60;
     * Alternate route:
     * &#x60;/dev/corporations/{corporation_id}/alliancehistory/&#x60; --- This
     * route is cached for up to 3600 seconds
     * 
     * @param corporationId
     *            An EVE corporation ID (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @return List<CorporationAlliancesHistoryResponse>
     * @throws ApiException
     *             if fails to make API call
     */
    public List<CorporationAlliancesHistoryResponse> getCorporationsCorporationIdAlliancehistory(Integer corporationId,
            String datasource) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'corporationId' is set
        if (corporationId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'corporationId' when calling getCorporationsCorporationIdAlliancehistory");
        }

        // create path and map variables
        String localVarPath = "/corporations/{corporation_id}/alliancehistory/".replaceAll("\\{format\\}", "json")
                .replaceAll("\\{" + "corporation_id" + "\\}", apiClient.escapeString(corporationId.toString()));

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

        GenericType<List<CorporationAlliancesHistoryResponse>> localVarReturnType = new GenericType<List<CorporationAlliancesHistoryResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get corporation icon Get the icon urls for a corporation --- Alternate
     * route: &#x60;/v1/corporations/{corporation_id}/icons/&#x60; Alternate
     * route: &#x60;/legacy/corporations/{corporation_id}/icons/&#x60; Alternate
     * route: &#x60;/dev/corporations/{corporation_id}/icons/&#x60; --- This
     * route is cached for up to 3600 seconds
     * 
     * @param corporationId
     *            An EVE corporation ID (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @return CorporationIconsResponse
     * @throws ApiException
     *             if fails to make API call
     */
    public CorporationIconsResponse getCorporationsCorporationIdIcons(Integer corporationId, String datasource)
            throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'corporationId' is set
        if (corporationId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'corporationId' when calling getCorporationsCorporationIdIcons");
        }

        // create path and map variables
        String localVarPath = "/corporations/{corporation_id}/icons/".replaceAll("\\{format\\}", "json").replaceAll(
                "\\{" + "corporation_id" + "\\}", apiClient.escapeString(corporationId.toString()));

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

        GenericType<CorporationIconsResponse> localVarReturnType = new GenericType<CorporationIconsResponse>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get corporation members Read the current list of members if the calling
     * character is a member. --- Alternate route:
     * &#x60;/v2/corporations/{corporation_id}/members/&#x60; Alternate route:
     * &#x60;/legacy/corporations/{corporation_id}/members/&#x60; Alternate
     * route: &#x60;/dev/corporations/{corporation_id}/members/&#x60; --- This
     * route is cached for up to 3600 seconds SSO Scope:
     * esi-corporations.read_corporation_membership.v1
     * 
     * @param corporationId
     *            A corporation ID (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @return List<CorporationMembersResponse>
     * @throws ApiException
     *             if fails to make API call
     */
    public List<CorporationMembersResponse> getCorporationsCorporationIdMembers(Integer corporationId, String datasource)
            throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'corporationId' is set
        if (corporationId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'corporationId' when calling getCorporationsCorporationIdMembers");
        }

        // create path and map variables
        String localVarPath = "/corporations/{corporation_id}/members/".replaceAll("\\{format\\}", "json").replaceAll(
                "\\{" + "corporation_id" + "\\}", apiClient.escapeString(corporationId.toString()));

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

        GenericType<List<CorporationMembersResponse>> localVarReturnType = new GenericType<List<CorporationMembersResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get corporation member roles Return the roles of all members if the
     * character has the personnel manager role or any grantable role. ---
     * Alternate route: &#x60;/v1/corporations/{corporation_id}/roles/&#x60;
     * Alternate route: &#x60;/legacy/corporations/{corporation_id}/roles/&#x60;
     * Alternate route: &#x60;/dev/corporations/{corporation_id}/roles/&#x60;
     * --- This route is cached for up to 3600 seconds SSO Scope:
     * esi-corporations.read_corporation_membership.v1
     * 
     * @param corporationId
     *            A corporation ID (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @return List<CorporationRolesResponse>
     * @throws ApiException
     *             if fails to make API call
     */
    public List<CorporationRolesResponse> getCorporationsCorporationIdRoles(Integer corporationId, String datasource)
            throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'corporationId' is set
        if (corporationId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'corporationId' when calling getCorporationsCorporationIdRoles");
        }

        // create path and map variables
        String localVarPath = "/corporations/{corporation_id}/roles/".replaceAll("\\{format\\}", "json").replaceAll(
                "\\{" + "corporation_id" + "\\}", apiClient.escapeString(corporationId.toString()));

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

        GenericType<List<CorporationRolesResponse>> localVarReturnType = new GenericType<List<CorporationRolesResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get corporation names Resolve a set of corporation IDs to corporation
     * names --- Alternate route: &#x60;/v1/corporations/names/&#x60; Alternate
     * route: &#x60;/legacy/corporations/names/&#x60; Alternate route:
     * &#x60;/dev/corporations/names/&#x60; --- This route is cached for up to
     * 3600 seconds
     * 
     * @param corporationIds
     *            A comma separated list of corporation IDs (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @return List<CorporationNamesResponse>
     * @throws ApiException
     *             if fails to make API call
     */
    public List<CorporationNamesResponse> getCorporationsNames(List<Long> corporationIds, String datasource)
            throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'corporationIds' is set
        if (corporationIds == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'corporationIds' when calling getCorporationsNames");
        }

        // create path and map variables
        String localVarPath = "/corporations/names/".replaceAll("\\{format\\}", "json");

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("csv", "corporation_ids", corporationIds));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {};

        GenericType<List<CorporationNamesResponse>> localVarReturnType = new GenericType<List<CorporationNamesResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }
}
