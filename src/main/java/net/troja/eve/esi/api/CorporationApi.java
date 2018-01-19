package net.troja.eve.esi.api;

import net.troja.eve.esi.ApiException;
import net.troja.eve.esi.ApiClient;
import net.troja.eve.esi.Configuration;
import net.troja.eve.esi.Pair;

import javax.ws.rs.core.GenericType;

import net.troja.eve.esi.model.CorporationAlliancesHistoryResponse;
import net.troja.eve.esi.model.CorporationBlueprintsResponse;
import net.troja.eve.esi.model.CorporationContainersLogsResponse;
import net.troja.eve.esi.model.CorporationDivisionsResponse;
import net.troja.eve.esi.model.CorporationFacilitiesResponse;
import net.troja.eve.esi.model.CorporationIconsResponse;
import net.troja.eve.esi.model.CorporationMedalsIssuedResponse;
import net.troja.eve.esi.model.CorporationMedalsResponse;
import net.troja.eve.esi.model.CorporationMemberTrackingResponse;
import net.troja.eve.esi.model.CorporationMembersTitlesResponse;
import net.troja.eve.esi.model.CorporationNamesResponse;
import net.troja.eve.esi.model.CorporationOutpostResponse;
import net.troja.eve.esi.model.CorporationResponse;
import net.troja.eve.esi.model.CorporationRolesHistoryResponse;
import net.troja.eve.esi.model.CorporationRolesResponse;
import net.troja.eve.esi.model.CorporationShareholdersResponse;
import net.troja.eve.esi.model.CorporationStandingsResponse;
import net.troja.eve.esi.model.CorporationStarbaseResponse;
import net.troja.eve.esi.model.CorporationStarbasesResponse;
import net.troja.eve.esi.model.CorporationStructuresResponse;
import net.troja.eve.esi.model.CorporationTitlesResponse;
import net.troja.eve.esi.model.Forbidden;
import net.troja.eve.esi.model.InternalServerError;
import net.troja.eve.esi.model.VulnerabilityWindow;

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
     * This route is cached for up to 3600 seconds
     * 
     * @param corporationId
     *            An EVE corporation ID (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return CorporationResponse
     * @throws ApiException
     *             if fails to make API call
     */
    public CorporationResponse getCorporationsCorporationId(Integer corporationId, String datasource, String userAgent,
            String xUserAgent) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'corporationId' is set
        if (corporationId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'corporationId' when calling getCorporationsCorporationId");
        }

        // create path and map variables
        String localVarPath = "/v4/corporations/{corporation_id}/".replaceAll("\\{format\\}", "json").replaceAll(
                "\\{" + "corporation_id" + "\\}", apiClient.escapeString(corporationId.toString()));

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

        GenericType<CorporationResponse> localVarReturnType = new GenericType<CorporationResponse>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get alliance history Get a list of all the alliances a corporation has
     * been a member of --- This route is cached for up to 3600 seconds
     * 
     * @param corporationId
     *            An EVE corporation ID (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return List&lt;CorporationAlliancesHistoryResponse&gt;
     * @throws ApiException
     *             if fails to make API call
     */
    public List<CorporationAlliancesHistoryResponse> getCorporationsCorporationIdAlliancehistory(Integer corporationId,
            String datasource, String userAgent, String xUserAgent) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'corporationId' is set
        if (corporationId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'corporationId' when calling getCorporationsCorporationIdAlliancehistory");
        }

        // create path and map variables
        String localVarPath = "/v2/corporations/{corporation_id}/alliancehistory/".replaceAll("\\{format\\}", "json")
                .replaceAll("\\{" + "corporation_id" + "\\}", apiClient.escapeString(corporationId.toString()));

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

        GenericType<List<CorporationAlliancesHistoryResponse>> localVarReturnType = new GenericType<List<CorporationAlliancesHistoryResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get corporation blueprints Returns a list of blueprints the corporation
     * owns --- This route is cached for up to 3600 seconds --- Requires one of
     * the following EVE corporation role(s): Director SSO Scope:
     * esi-corporations.read_blueprints.v1
     * 
     * @param corporationId
     *            An EVE corporation ID (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param page
     *            Which page of results to return (optional, default to 1)
     * @param token
     *            Access token to use if unable to set a header (optional)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return List&lt;CorporationBlueprintsResponse&gt;
     * @throws ApiException
     *             if fails to make API call
     */
    public List<CorporationBlueprintsResponse> getCorporationsCorporationIdBlueprints(Integer corporationId,
            String datasource, Integer page, String token, String userAgent, String xUserAgent) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'corporationId' is set
        if (corporationId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'corporationId' when calling getCorporationsCorporationIdBlueprints");
        }

        // create path and map variables
        String localVarPath = "/v1/corporations/{corporation_id}/blueprints/".replaceAll("\\{format\\}", "json")
                .replaceAll("\\{" + "corporation_id" + "\\}", apiClient.escapeString(corporationId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "page", page));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "token", token));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "user_agent", userAgent));

        if (xUserAgent != null)
            localVarHeaderParams.put("X-User-Agent", apiClient.parameterToString(xUserAgent));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "evesso" };

        GenericType<List<CorporationBlueprintsResponse>> localVarReturnType = new GenericType<List<CorporationBlueprintsResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get all corporation ALSC logs Returns logs recorded in the past seven
     * days from all audit log secure containers (ALSC) owned by a given
     * corporation --- This route is cached for up to 600 seconds --- Requires
     * one of the following EVE corporation role(s): Director SSO Scope:
     * esi-corporations.read_container_logs.v1
     * 
     * @param corporationId
     *            An EVE corporation ID (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param page
     *            Which page of results to return (optional, default to 1)
     * @param token
     *            Access token to use if unable to set a header (optional)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return List&lt;CorporationContainersLogsResponse&gt;
     * @throws ApiException
     *             if fails to make API call
     */
    public List<CorporationContainersLogsResponse> getCorporationsCorporationIdContainersLogs(Integer corporationId,
            String datasource, Integer page, String token, String userAgent, String xUserAgent) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'corporationId' is set
        if (corporationId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'corporationId' when calling getCorporationsCorporationIdContainersLogs");
        }

        // create path and map variables
        String localVarPath = "/v1/corporations/{corporation_id}/containers/logs/".replaceAll("\\{format\\}", "json")
                .replaceAll("\\{" + "corporation_id" + "\\}", apiClient.escapeString(corporationId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "page", page));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "token", token));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "user_agent", userAgent));

        if (xUserAgent != null)
            localVarHeaderParams.put("X-User-Agent", apiClient.parameterToString(xUserAgent));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "evesso" };

        GenericType<List<CorporationContainersLogsResponse>> localVarReturnType = new GenericType<List<CorporationContainersLogsResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get corporation divisions Return corporation hangar and wallet division
     * names, only show if a division is not using the default name --- This
     * route is cached for up to 3600 seconds --- Requires one of the following
     * EVE corporation role(s): Director SSO Scope:
     * esi-corporations.read_divisions.v1
     * 
     * @param corporationId
     *            An EVE corporation ID (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param token
     *            Access token to use if unable to set a header (optional)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return CorporationDivisionsResponse
     * @throws ApiException
     *             if fails to make API call
     */
    public CorporationDivisionsResponse getCorporationsCorporationIdDivisions(Integer corporationId, String datasource,
            String token, String userAgent, String xUserAgent) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'corporationId' is set
        if (corporationId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'corporationId' when calling getCorporationsCorporationIdDivisions");
        }

        // create path and map variables
        String localVarPath = "/v1/corporations/{corporation_id}/divisions/".replaceAll("\\{format\\}", "json")
                .replaceAll("\\{" + "corporation_id" + "\\}", apiClient.escapeString(corporationId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "token", token));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "user_agent", userAgent));

        if (xUserAgent != null)
            localVarHeaderParams.put("X-User-Agent", apiClient.parameterToString(xUserAgent));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "evesso" };

        GenericType<CorporationDivisionsResponse> localVarReturnType = new GenericType<CorporationDivisionsResponse>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get corporation facilities Return a corporation&#39;s facilities --- This
     * route is cached for up to 3600 seconds --- Requires one of the following
     * EVE corporation role(s): Factory_Manager SSO Scope:
     * esi-corporations.read_facilities.v1
     * 
     * @param corporationId
     *            An EVE corporation ID (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param token
     *            Access token to use if unable to set a header (optional)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return List&lt;CorporationFacilitiesResponse&gt;
     * @throws ApiException
     *             if fails to make API call
     */
    public List<CorporationFacilitiesResponse> getCorporationsCorporationIdFacilities(Integer corporationId,
            String datasource, String token, String userAgent, String xUserAgent) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'corporationId' is set
        if (corporationId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'corporationId' when calling getCorporationsCorporationIdFacilities");
        }

        // create path and map variables
        String localVarPath = "/v1/corporations/{corporation_id}/facilities/".replaceAll("\\{format\\}", "json")
                .replaceAll("\\{" + "corporation_id" + "\\}", apiClient.escapeString(corporationId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "token", token));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "user_agent", userAgent));

        if (xUserAgent != null)
            localVarHeaderParams.put("X-User-Agent", apiClient.parameterToString(xUserAgent));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "evesso" };

        GenericType<List<CorporationFacilitiesResponse>> localVarReturnType = new GenericType<List<CorporationFacilitiesResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get corporation icon Get the icon urls for a corporation --- This route
     * is cached for up to 3600 seconds
     * 
     * @param corporationId
     *            An EVE corporation ID (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return CorporationIconsResponse
     * @throws ApiException
     *             if fails to make API call
     */
    public CorporationIconsResponse getCorporationsCorporationIdIcons(Integer corporationId, String datasource,
            String userAgent, String xUserAgent) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'corporationId' is set
        if (corporationId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'corporationId' when calling getCorporationsCorporationIdIcons");
        }

        // create path and map variables
        String localVarPath = "/v1/corporations/{corporation_id}/icons/".replaceAll("\\{format\\}", "json").replaceAll(
                "\\{" + "corporation_id" + "\\}", apiClient.escapeString(corporationId.toString()));

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

        GenericType<CorporationIconsResponse> localVarReturnType = new GenericType<CorporationIconsResponse>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get corporation medals Returns a corporation&#39;s medals --- This route
     * is cached for up to 3600 seconds SSO Scope:
     * esi-corporations.read_medals.v1
     * 
     * @param corporationId
     *            An EVE corporation ID (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param page
     *            Which page of results to return (optional, default to 1)
     * @param token
     *            Access token to use if unable to set a header (optional)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return List&lt;CorporationMedalsResponse&gt;
     * @throws ApiException
     *             if fails to make API call
     */
    public List<CorporationMedalsResponse> getCorporationsCorporationIdMedals(Integer corporationId, String datasource,
            Integer page, String token, String userAgent, String xUserAgent) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'corporationId' is set
        if (corporationId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'corporationId' when calling getCorporationsCorporationIdMedals");
        }

        // create path and map variables
        String localVarPath = "/v1/corporations/{corporation_id}/medals/".replaceAll("\\{format\\}", "json")
                .replaceAll("\\{" + "corporation_id" + "\\}", apiClient.escapeString(corporationId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "page", page));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "token", token));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "user_agent", userAgent));

        if (xUserAgent != null)
            localVarHeaderParams.put("X-User-Agent", apiClient.parameterToString(xUserAgent));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "evesso" };

        GenericType<List<CorporationMedalsResponse>> localVarReturnType = new GenericType<List<CorporationMedalsResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get corporation issued medals Returns medals issued by a corporation ---
     * This route is cached for up to 3600 seconds --- Requires one of the
     * following EVE corporation role(s): Director SSO Scope:
     * esi-corporations.read_medals.v1
     * 
     * @param corporationId
     *            An EVE corporation ID (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param page
     *            Which page of results to return (optional, default to 1)
     * @param token
     *            Access token to use if unable to set a header (optional)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return List&lt;CorporationMedalsIssuedResponse&gt;
     * @throws ApiException
     *             if fails to make API call
     */
    public List<CorporationMedalsIssuedResponse> getCorporationsCorporationIdMedalsIssued(Integer corporationId,
            String datasource, Integer page, String token, String userAgent, String xUserAgent) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'corporationId' is set
        if (corporationId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'corporationId' when calling getCorporationsCorporationIdMedalsIssued");
        }

        // create path and map variables
        String localVarPath = "/v1/corporations/{corporation_id}/medals/issued/".replaceAll("\\{format\\}", "json")
                .replaceAll("\\{" + "corporation_id" + "\\}", apiClient.escapeString(corporationId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "page", page));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "token", token));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "user_agent", userAgent));

        if (xUserAgent != null)
            localVarHeaderParams.put("X-User-Agent", apiClient.parameterToString(xUserAgent));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "evesso" };

        GenericType<List<CorporationMedalsIssuedResponse>> localVarReturnType = new GenericType<List<CorporationMedalsIssuedResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get corporation members Return the current member list of a corporation,
     * the token&#39;s character need to be a member of the corporation. ---
     * This route is cached for up to 3600 seconds SSO Scope:
     * esi-wallet.read_corporation_wallets.v1 SSO Scope:
     * esi-corporations.read_corporation_membership.v1
     * 
     * @param corporationId
     *            An EVE corporation ID (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param token
     *            Access token to use if unable to set a header (optional)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return List&lt;Integer&gt;
     * @throws ApiException
     *             if fails to make API call
     */
    public List<Integer> getCorporationsCorporationIdMembers(Integer corporationId, String datasource, String token,
            String userAgent, String xUserAgent) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'corporationId' is set
        if (corporationId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'corporationId' when calling getCorporationsCorporationIdMembers");
        }

        // create path and map variables
        String localVarPath = "/v3/corporations/{corporation_id}/members/".replaceAll("\\{format\\}", "json")
                .replaceAll("\\{" + "corporation_id" + "\\}", apiClient.escapeString(corporationId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "token", token));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "user_agent", userAgent));

        if (xUserAgent != null)
            localVarHeaderParams.put("X-User-Agent", apiClient.parameterToString(xUserAgent));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "evesso" };

        GenericType<List<Integer>> localVarReturnType = new GenericType<List<Integer>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get corporation member limit Return a corporation&#39;s member limit, not
     * including CEO himself --- This route is cached for up to 3600 seconds ---
     * Requires one of the following EVE corporation role(s): Director SSO
     * Scope: esi-corporations.track_members.v1
     * 
     * @param corporationId
     *            An EVE corporation ID (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param token
     *            Access token to use if unable to set a header (optional)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return Integer
     * @throws ApiException
     *             if fails to make API call
     */
    public Integer getCorporationsCorporationIdMembersLimit(Integer corporationId, String datasource, String token,
            String userAgent, String xUserAgent) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'corporationId' is set
        if (corporationId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'corporationId' when calling getCorporationsCorporationIdMembersLimit");
        }

        // create path and map variables
        String localVarPath = "/v1/corporations/{corporation_id}/members/limit/".replaceAll("\\{format\\}", "json")
                .replaceAll("\\{" + "corporation_id" + "\\}", apiClient.escapeString(corporationId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "token", token));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "user_agent", userAgent));

        if (xUserAgent != null)
            localVarHeaderParams.put("X-User-Agent", apiClient.parameterToString(xUserAgent));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "evesso" };

        GenericType<Integer> localVarReturnType = new GenericType<Integer>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get corporation&#39;s members&#39; titles Returns a corporation&#39;s
     * members&#39; titles --- This route is cached for up to 3600 seconds ---
     * Requires one of the following EVE corporation role(s): Director SSO
     * Scope: esi-corporations.read_titles.v1
     * 
     * @param corporationId
     *            An EVE corporation ID (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param token
     *            Access token to use if unable to set a header (optional)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return List&lt;CorporationMembersTitlesResponse&gt;
     * @throws ApiException
     *             if fails to make API call
     */
    public List<CorporationMembersTitlesResponse> getCorporationsCorporationIdMembersTitles(Integer corporationId,
            String datasource, String token, String userAgent, String xUserAgent) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'corporationId' is set
        if (corporationId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'corporationId' when calling getCorporationsCorporationIdMembersTitles");
        }

        // create path and map variables
        String localVarPath = "/v1/corporations/{corporation_id}/members/titles/".replaceAll("\\{format\\}", "json")
                .replaceAll("\\{" + "corporation_id" + "\\}", apiClient.escapeString(corporationId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "token", token));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "user_agent", userAgent));

        if (xUserAgent != null)
            localVarHeaderParams.put("X-User-Agent", apiClient.parameterToString(xUserAgent));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "evesso" };

        GenericType<List<CorporationMembersTitlesResponse>> localVarReturnType = new GenericType<List<CorporationMembersTitlesResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Track corporation members Returns additional information about a
     * corporation&#39;s members which helps tracking their activities --- This
     * route is cached for up to 3600 seconds --- Requires one of the following
     * EVE corporation role(s): Director SSO Scope:
     * esi-corporations.track_members.v1
     * 
     * @param corporationId
     *            An EVE corporation ID (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param token
     *            Access token to use if unable to set a header (optional)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return List&lt;CorporationMemberTrackingResponse&gt;
     * @throws ApiException
     *             if fails to make API call
     */
    public List<CorporationMemberTrackingResponse> getCorporationsCorporationIdMembertracking(Integer corporationId,
            String datasource, String token, String userAgent, String xUserAgent) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'corporationId' is set
        if (corporationId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'corporationId' when calling getCorporationsCorporationIdMembertracking");
        }

        // create path and map variables
        String localVarPath = "/v1/corporations/{corporation_id}/membertracking/".replaceAll("\\{format\\}", "json")
                .replaceAll("\\{" + "corporation_id" + "\\}", apiClient.escapeString(corporationId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "token", token));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "user_agent", userAgent));

        if (xUserAgent != null)
            localVarHeaderParams.put("X-User-Agent", apiClient.parameterToString(xUserAgent));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "evesso" };

        GenericType<List<CorporationMemberTrackingResponse>> localVarReturnType = new GenericType<List<CorporationMemberTrackingResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get corporation outposts Get a list of corporation outpost IDs Note: This
     * endpoint will be removed once outposts are migrated to Citadels as talked
     * about in this blog:
     * https://community.eveonline.com/news/dev-blogs/the-next
     * -steps-in-structure-transition/ --- This route is cached for up to 3600
     * seconds --- Requires one of the following EVE corporation role(s):
     * Director SSO Scope: esi-corporations.read_outposts.v1
     * 
     * @param corporationId
     *            An EVE corporation ID (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param page
     *            Which page of results to return (optional, default to 1)
     * @param token
     *            Access token to use if unable to set a header (optional)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return List&lt;Integer&gt;
     * @throws ApiException
     *             if fails to make API call
     */
    public List<Integer> getCorporationsCorporationIdOutposts(Integer corporationId, String datasource, Integer page,
            String token, String userAgent, String xUserAgent) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'corporationId' is set
        if (corporationId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'corporationId' when calling getCorporationsCorporationIdOutposts");
        }

        // create path and map variables
        String localVarPath = "/v1/corporations/{corporation_id}/outposts/".replaceAll("\\{format\\}", "json")
                .replaceAll("\\{" + "corporation_id" + "\\}", apiClient.escapeString(corporationId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "page", page));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "token", token));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "user_agent", userAgent));

        if (xUserAgent != null)
            localVarHeaderParams.put("X-User-Agent", apiClient.parameterToString(xUserAgent));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "evesso" };

        GenericType<List<Integer>> localVarReturnType = new GenericType<List<Integer>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get corporation outpost details Get details about a given outpost. Note:
     * This endpoint will be removed once outposts are migrated to Citadels as
     * talked about in this blog:
     * https://community.eveonline.com/news/dev-blogs/
     * the-next-steps-in-structure-transition/ --- This route is cached for up
     * to 3600 seconds --- Requires one of the following EVE corporation
     * role(s): Director SSO Scope: esi-corporations.read_outposts.v1
     * 
     * @param corporationId
     *            An EVE corporation ID (required)
     * @param outpostId
     *            A station (outpost) ID (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param token
     *            Access token to use if unable to set a header (optional)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return CorporationOutpostResponse
     * @throws ApiException
     *             if fails to make API call
     */
    public CorporationOutpostResponse getCorporationsCorporationIdOutpostsOutpostId(Integer corporationId,
            Integer outpostId, String datasource, String token, String userAgent, String xUserAgent)
            throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'corporationId' is set
        if (corporationId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'corporationId' when calling getCorporationsCorporationIdOutpostsOutpostId");
        }

        // verify the required parameter 'outpostId' is set
        if (outpostId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'outpostId' when calling getCorporationsCorporationIdOutpostsOutpostId");
        }

        // create path and map variables
        String localVarPath = "/v1/corporations/{corporation_id}/outposts/{outpost_id}/"
                .replaceAll("\\{format\\}", "json")
                .replaceAll("\\{" + "corporation_id" + "\\}", apiClient.escapeString(corporationId.toString()))
                .replaceAll("\\{" + "outpost_id" + "\\}", apiClient.escapeString(outpostId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "token", token));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "user_agent", userAgent));

        if (xUserAgent != null)
            localVarHeaderParams.put("X-User-Agent", apiClient.parameterToString(xUserAgent));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "evesso" };

        GenericType<CorporationOutpostResponse> localVarReturnType = new GenericType<CorporationOutpostResponse>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get corporation member roles Return the roles of all members if the
     * character has the personnel manager role or any grantable role. --- This
     * route is cached for up to 3600 seconds SSO Scope:
     * esi-corporations.read_corporation_membership.v1
     * 
     * @param corporationId
     *            An EVE corporation ID (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param token
     *            Access token to use if unable to set a header (optional)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return List&lt;CorporationRolesResponse&gt;
     * @throws ApiException
     *             if fails to make API call
     */
    public List<CorporationRolesResponse> getCorporationsCorporationIdRoles(Integer corporationId, String datasource,
            String token, String userAgent, String xUserAgent) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'corporationId' is set
        if (corporationId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'corporationId' when calling getCorporationsCorporationIdRoles");
        }

        // create path and map variables
        String localVarPath = "/v1/corporations/{corporation_id}/roles/".replaceAll("\\{format\\}", "json").replaceAll(
                "\\{" + "corporation_id" + "\\}", apiClient.escapeString(corporationId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "token", token));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "user_agent", userAgent));

        if (xUserAgent != null)
            localVarHeaderParams.put("X-User-Agent", apiClient.parameterToString(xUserAgent));

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
     * Get corporation member roles history Return how roles have changed for a
     * coporation&#39;s members, up to a month --- This route is cached for up
     * to 3600 seconds --- Requires one of the following EVE corporation
     * role(s): Director SSO Scope:
     * esi-corporations.read_corporation_membership.v1
     * 
     * @param corporationId
     *            An EVE corporation ID (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param page
     *            Which page of results to return (optional, default to 1)
     * @param token
     *            Access token to use if unable to set a header (optional)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return List&lt;CorporationRolesHistoryResponse&gt;
     * @throws ApiException
     *             if fails to make API call
     */
    public List<CorporationRolesHistoryResponse> getCorporationsCorporationIdRolesHistory(Integer corporationId,
            String datasource, Integer page, String token, String userAgent, String xUserAgent) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'corporationId' is set
        if (corporationId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'corporationId' when calling getCorporationsCorporationIdRolesHistory");
        }

        // create path and map variables
        String localVarPath = "/v1/corporations/{corporation_id}/roles/history/".replaceAll("\\{format\\}", "json")
                .replaceAll("\\{" + "corporation_id" + "\\}", apiClient.escapeString(corporationId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "page", page));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "token", token));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "user_agent", userAgent));

        if (xUserAgent != null)
            localVarHeaderParams.put("X-User-Agent", apiClient.parameterToString(xUserAgent));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "evesso" };

        GenericType<List<CorporationRolesHistoryResponse>> localVarReturnType = new GenericType<List<CorporationRolesHistoryResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get corporation members Return the current member list of a corporation,
     * the token&#39;s character need to be a member of the corporation. ---
     * This route is cached for up to 3600 seconds SSO Scope:
     * esi-wallet.read_corporation_wallets.v1 SSO Scope:
     * esi-corporations.read_corporation_membership.v1
     * 
     * @param corporationId
     *            An EVE corporation ID (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param page
     *            Which page of results to return (optional, default to 1)
     * @param token
     *            Access token to use if unable to set a header (optional)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return List&lt;CorporationShareholdersResponse&gt;
     * @throws ApiException
     *             if fails to make API call
     */
    public List<CorporationShareholdersResponse> getCorporationsCorporationIdShareholders(Integer corporationId,
            String datasource, Integer page, String token, String userAgent, String xUserAgent) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'corporationId' is set
        if (corporationId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'corporationId' when calling getCorporationsCorporationIdShareholders");
        }

        // create path and map variables
        String localVarPath = "/v1/corporations/{corporation_id}/shareholders/".replaceAll("\\{format\\}", "json")
                .replaceAll("\\{" + "corporation_id" + "\\}", apiClient.escapeString(corporationId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "page", page));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "token", token));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "user_agent", userAgent));

        if (xUserAgent != null)
            localVarHeaderParams.put("X-User-Agent", apiClient.parameterToString(xUserAgent));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "evesso" };

        GenericType<List<CorporationShareholdersResponse>> localVarReturnType = new GenericType<List<CorporationShareholdersResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get corporation standings Return corporation standings from agents, NPC
     * corporations, and factions --- This route is cached for up to 3600
     * seconds SSO Scope: esi-corporations.read_standings.v1
     * 
     * @param corporationId
     *            An EVE corporation ID (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param page
     *            Which page of results to return (optional, default to 1)
     * @param token
     *            Access token to use if unable to set a header (optional)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return List&lt;CorporationStandingsResponse&gt;
     * @throws ApiException
     *             if fails to make API call
     */
    public List<CorporationStandingsResponse> getCorporationsCorporationIdStandings(Integer corporationId,
            String datasource, Integer page, String token, String userAgent, String xUserAgent) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'corporationId' is set
        if (corporationId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'corporationId' when calling getCorporationsCorporationIdStandings");
        }

        // create path and map variables
        String localVarPath = "/v1/corporations/{corporation_id}/standings/".replaceAll("\\{format\\}", "json")
                .replaceAll("\\{" + "corporation_id" + "\\}", apiClient.escapeString(corporationId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "page", page));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "token", token));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "user_agent", userAgent));

        if (xUserAgent != null)
            localVarHeaderParams.put("X-User-Agent", apiClient.parameterToString(xUserAgent));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "evesso" };

        GenericType<List<CorporationStandingsResponse>> localVarReturnType = new GenericType<List<CorporationStandingsResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get corporation starbases (POSes) Returns list of corporation starbases
     * (POSes) --- This route is cached for up to 3600 seconds --- Requires one
     * of the following EVE corporation role(s): Director SSO Scope:
     * esi-corporations.read_starbases.v1
     * 
     * @param corporationId
     *            An EVE corporation ID (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param page
     *            Which page of results to return (optional, default to 1)
     * @param token
     *            Access token to use if unable to set a header (optional)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return List&lt;CorporationStarbasesResponse&gt;
     * @throws ApiException
     *             if fails to make API call
     */
    public List<CorporationStarbasesResponse> getCorporationsCorporationIdStarbases(Integer corporationId,
            String datasource, Integer page, String token, String userAgent, String xUserAgent) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'corporationId' is set
        if (corporationId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'corporationId' when calling getCorporationsCorporationIdStarbases");
        }

        // create path and map variables
        String localVarPath = "/v1/corporations/{corporation_id}/starbases/".replaceAll("\\{format\\}", "json")
                .replaceAll("\\{" + "corporation_id" + "\\}", apiClient.escapeString(corporationId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "page", page));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "token", token));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "user_agent", userAgent));

        if (xUserAgent != null)
            localVarHeaderParams.put("X-User-Agent", apiClient.parameterToString(xUserAgent));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "evesso" };

        GenericType<List<CorporationStarbasesResponse>> localVarReturnType = new GenericType<List<CorporationStarbasesResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get starbase (POS) detail Returns various settings and fuels of a
     * starbase (POS) --- This route is cached for up to 3600 seconds ---
     * Requires one of the following EVE corporation role(s): Director SSO
     * Scope: esi-corporations.read_starbases.v1
     * 
     * @param corporationId
     *            An EVE corporation ID (required)
     * @param starbaseId
     *            An EVE starbase (POS) ID (required)
     * @param systemId
     *            The solar system this starbase (POS) is located in, (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param token
     *            Access token to use if unable to set a header (optional)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return CorporationStarbaseResponse
     * @throws ApiException
     *             if fails to make API call
     */
    public CorporationStarbaseResponse getCorporationsCorporationIdStarbasesStarbaseId(Integer corporationId,
            Long starbaseId, Integer systemId, String datasource, String token, String userAgent, String xUserAgent)
            throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'corporationId' is set
        if (corporationId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'corporationId' when calling getCorporationsCorporationIdStarbasesStarbaseId");
        }

        // verify the required parameter 'starbaseId' is set
        if (starbaseId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'starbaseId' when calling getCorporationsCorporationIdStarbasesStarbaseId");
        }

        // verify the required parameter 'systemId' is set
        if (systemId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'systemId' when calling getCorporationsCorporationIdStarbasesStarbaseId");
        }

        // create path and map variables
        String localVarPath = "/v1/corporations/{corporation_id}/starbases/{starbase_id}/"
                .replaceAll("\\{format\\}", "json")
                .replaceAll("\\{" + "corporation_id" + "\\}", apiClient.escapeString(corporationId.toString()))
                .replaceAll("\\{" + "starbase_id" + "\\}", apiClient.escapeString(starbaseId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "system_id", systemId));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "token", token));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "user_agent", userAgent));

        if (xUserAgent != null)
            localVarHeaderParams.put("X-User-Agent", apiClient.parameterToString(xUserAgent));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "evesso" };

        GenericType<CorporationStarbaseResponse> localVarReturnType = new GenericType<CorporationStarbaseResponse>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get corporation structures Get a list of corporation structures --- This
     * route is cached for up to 3600 seconds --- Requires one of the following
     * EVE corporation role(s): StationManager SSO Scope:
     * esi-corporations.read_structures.v1
     * 
     * @param corporationId
     *            An EVE corporation ID (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param language
     *            Language to use in the response (optional, default to en-us)
     * @param page
     *            Which page of results to return (optional, default to 1)
     * @param token
     *            Access token to use if unable to set a header (optional)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return List&lt;CorporationStructuresResponse&gt;
     * @throws ApiException
     *             if fails to make API call
     */
    public List<CorporationStructuresResponse> getCorporationsCorporationIdStructures(Integer corporationId,
            String datasource, String language, Integer page, String token, String userAgent, String xUserAgent)
            throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'corporationId' is set
        if (corporationId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'corporationId' when calling getCorporationsCorporationIdStructures");
        }

        // create path and map variables
        String localVarPath = "/v1/corporations/{corporation_id}/structures/".replaceAll("\\{format\\}", "json")
                .replaceAll("\\{" + "corporation_id" + "\\}", apiClient.escapeString(corporationId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "language", language));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "page", page));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "token", token));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "user_agent", userAgent));

        if (xUserAgent != null)
            localVarHeaderParams.put("X-User-Agent", apiClient.parameterToString(xUserAgent));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "evesso" };

        GenericType<List<CorporationStructuresResponse>> localVarReturnType = new GenericType<List<CorporationStructuresResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get corporation titles Returns a corporation&#39;s titles --- This route
     * is cached for up to 3600 seconds --- Requires one of the following EVE
     * corporation role(s): Director SSO Scope: esi-corporations.read_titles.v1
     * 
     * @param corporationId
     *            An EVE corporation ID (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param token
     *            Access token to use if unable to set a header (optional)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return List&lt;CorporationTitlesResponse&gt;
     * @throws ApiException
     *             if fails to make API call
     */
    public List<CorporationTitlesResponse> getCorporationsCorporationIdTitles(Integer corporationId, String datasource,
            String token, String userAgent, String xUserAgent) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'corporationId' is set
        if (corporationId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'corporationId' when calling getCorporationsCorporationIdTitles");
        }

        // create path and map variables
        String localVarPath = "/v1/corporations/{corporation_id}/titles/".replaceAll("\\{format\\}", "json")
                .replaceAll("\\{" + "corporation_id" + "\\}", apiClient.escapeString(corporationId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "token", token));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "user_agent", userAgent));

        if (xUserAgent != null)
            localVarHeaderParams.put("X-User-Agent", apiClient.parameterToString(xUserAgent));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "evesso" };

        GenericType<List<CorporationTitlesResponse>> localVarReturnType = new GenericType<List<CorporationTitlesResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get corporation names Resolve a set of corporation IDs to corporation
     * names --- This route is cached for up to 3600 seconds
     * 
     * @param corporationIds
     *            A comma separated list of corporation IDs (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return List&lt;CorporationNamesResponse&gt;
     * @throws ApiException
     *             if fails to make API call
     */
    public List<CorporationNamesResponse> getCorporationsNames(List<Integer> corporationIds, String datasource,
            String userAgent, String xUserAgent) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'corporationIds' is set
        if (corporationIds == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'corporationIds' when calling getCorporationsNames");
        }

        // create path and map variables
        String localVarPath = "/v2/corporations/names/".replaceAll("\\{format\\}", "json");

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("csv", "corporation_ids", corporationIds));
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

        GenericType<List<CorporationNamesResponse>> localVarReturnType = new GenericType<List<CorporationNamesResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get npc corporations Get a list of npc corporations --- This route
     * expires daily at 11:05
     * 
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return List&lt;Integer&gt;
     * @throws ApiException
     *             if fails to make API call
     */
    public List<Integer> getCorporationsNpccorps(String datasource, String userAgent, String xUserAgent)
            throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/v1/corporations/npccorps/".replaceAll("\\{format\\}", "json");

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

        GenericType<List<Integer>> localVarReturnType = new GenericType<List<Integer>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Update structure vulnerability schedule Update the vulnerability window
     * schedule of a corporation structure --- SSO Scope:
     * esi-corporations.write_structures.v1
     * 
     * @param corporationId
     *            An EVE corporation ID (required)
     * @param newSchedule
     *            New vulnerability window schedule for the structure (required)
     * @param structureId
     *            A structure ID (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param token
     *            Access token to use if unable to set a header (optional)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @throws ApiException
     *             if fails to make API call
     */
    public void putCorporationsCorporationIdStructuresStructureId(Integer corporationId,
            List<VulnerabilityWindow> newSchedule, Long structureId, String datasource, String token, String userAgent,
            String xUserAgent) throws ApiException {
        Object localVarPostBody = newSchedule;

        // verify the required parameter 'corporationId' is set
        if (corporationId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'corporationId' when calling putCorporationsCorporationIdStructuresStructureId");
        }

        // verify the required parameter 'newSchedule' is set
        if (newSchedule == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'newSchedule' when calling putCorporationsCorporationIdStructuresStructureId");
        }

        // verify the required parameter 'structureId' is set
        if (structureId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'structureId' when calling putCorporationsCorporationIdStructuresStructureId");
        }

        // create path and map variables
        String localVarPath = "/v1/corporations/{corporation_id}/structures/{structure_id}/"
                .replaceAll("\\{format\\}", "json")
                .replaceAll("\\{" + "corporation_id" + "\\}", apiClient.escapeString(corporationId.toString()))
                .replaceAll("\\{" + "structure_id" + "\\}", apiClient.escapeString(structureId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "token", token));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "user_agent", userAgent));

        if (xUserAgent != null)
            localVarHeaderParams.put("X-User-Agent", apiClient.parameterToString(xUserAgent));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "evesso" };

        apiClient.invokeAPI(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
    }
}
