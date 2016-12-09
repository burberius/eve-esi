package net.troja.eve.esi.api;

import net.troja.eve.esi.ApiException;
import net.troja.eve.esi.ApiClient;
import net.troja.eve.esi.Configuration;
import net.troja.eve.esi.Pair;

import javax.ws.rs.core.GenericType;

import net.troja.eve.esi.model.GetFleetsFleetIdMembers200Ok;
import net.troja.eve.esi.model.GetFleetsFleetIdOk;
import net.troja.eve.esi.model.GetFleetsFleetIdWings200Ok;
import net.troja.eve.esi.model.PostFleetsFleetIdMembersInvitation;
import net.troja.eve.esi.model.PostFleetsFleetIdWingsCreated;
import net.troja.eve.esi.model.PostFleetsFleetIdWingsWingIdSquadsCreated;
import net.troja.eve.esi.model.PutFleetsFleetIdMembersMemberIdMovement;
import net.troja.eve.esi.model.PutFleetsFleetIdNewSettings;
import net.troja.eve.esi.model.PutFleetsFleetIdSquadsSquadIdNaming;
import net.troja.eve.esi.model.PutFleetsFleetIdWingsWingIdNaming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FleetsApi {
    private ApiClient apiClient;

    public FleetsApi() {
        this(Configuration.getDefaultApiClient());
    }

    public FleetsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Kick fleet member Kick a fleet member --- Alternate route:
     * &#x60;/v1/fleets/{fleet_id}/members/{member_id}/&#x60; Alternate route:
     * &#x60;/legacy/fleets/{fleet_id}/members/{member_id}/&#x60; Alternate
     * route: &#x60;/dev/fleets/{fleet_id}/members/{member_id}/&#x60;
     * 
     * @param fleetId
     *            ID for a fleet (required)
     * @param memberId
     *            The character ID of a member in this fleet (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @throws ApiException
     *             if fails to make API call
     */
    public void deleteFleetsFleetIdMembersMemberId(Long fleetId, Integer memberId, String datasource)
            throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'fleetId' is set
        if (fleetId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'fleetId' when calling deleteFleetsFleetIdMembersMemberId");
        }

        // verify the required parameter 'memberId' is set
        if (memberId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'memberId' when calling deleteFleetsFleetIdMembersMemberId");
        }

        // create path and map variables
        String localVarPath = "/fleets/{fleet_id}/members/{member_id}/".replaceAll("\\{format\\}", "json")
                .replaceAll("\\{" + "fleet_id" + "\\}", apiClient.escapeString(fleetId.toString()))
                .replaceAll("\\{" + "member_id" + "\\}", apiClient.escapeString(memberId.toString()));

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

        apiClient.invokeAPI(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
    }

    /**
     * Delete fleet squad Delete a fleet squad, only empty squads can be deleted
     * --- Alternate route: &#x60;/v1/fleets/{fleet_id}/squads/{squad_id}/&#x60;
     * Alternate route: &#x60;/legacy/fleets/{fleet_id}/squads/{squad_id}/&#x60;
     * Alternate route: &#x60;/dev/fleets/{fleet_id}/squads/{squad_id}/&#x60;
     * 
     * @param fleetId
     *            ID for a fleet (required)
     * @param squadId
     *            The squad to delete (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @throws ApiException
     *             if fails to make API call
     */
    public void deleteFleetsFleetIdSquadsSquadId(Long fleetId, Long squadId, String datasource) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'fleetId' is set
        if (fleetId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'fleetId' when calling deleteFleetsFleetIdSquadsSquadId");
        }

        // verify the required parameter 'squadId' is set
        if (squadId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'squadId' when calling deleteFleetsFleetIdSquadsSquadId");
        }

        // create path and map variables
        String localVarPath = "/fleets/{fleet_id}/squads/{squad_id}/".replaceAll("\\{format\\}", "json")
                .replaceAll("\\{" + "fleet_id" + "\\}", apiClient.escapeString(fleetId.toString()))
                .replaceAll("\\{" + "squad_id" + "\\}", apiClient.escapeString(squadId.toString()));

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

        apiClient.invokeAPI(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
    }

    /**
     * Delete fleet wing Delete a fleet wing, only empty wings can be deleted.
     * The wing may contain squads, but the squads must be empty --- Alternate
     * route: &#x60;/v1/fleets/{fleet_id}/wings/{wing_id}/&#x60; Alternate
     * route: &#x60;/legacy/fleets/{fleet_id}/wings/{wing_id}/&#x60; Alternate
     * route: &#x60;/dev/fleets/{fleet_id}/wings/{wing_id}/&#x60;
     * 
     * @param fleetId
     *            ID for a fleet (required)
     * @param wingId
     *            The wing to delete (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @throws ApiException
     *             if fails to make API call
     */
    public void deleteFleetsFleetIdWingsWingId(Long fleetId, Long wingId, String datasource) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'fleetId' is set
        if (fleetId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'fleetId' when calling deleteFleetsFleetIdWingsWingId");
        }

        // verify the required parameter 'wingId' is set
        if (wingId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'wingId' when calling deleteFleetsFleetIdWingsWingId");
        }

        // create path and map variables
        String localVarPath = "/fleets/{fleet_id}/wings/{wing_id}/".replaceAll("\\{format\\}", "json")
                .replaceAll("\\{" + "fleet_id" + "\\}", apiClient.escapeString(fleetId.toString()))
                .replaceAll("\\{" + "wing_id" + "\\}", apiClient.escapeString(wingId.toString()));

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

        apiClient.invokeAPI(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
    }

    /**
     * Get fleet information Return details about a fleet --- Alternate route:
     * &#x60;/v1/fleets/{fleet_id}/&#x60; Alternate route:
     * &#x60;/legacy/fleets/{fleet_id}/&#x60; Alternate route:
     * &#x60;/dev/fleets/{fleet_id}/&#x60; --- This route is cached for up to 5
     * seconds
     * 
     * @param fleetId
     *            ID for a fleet (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @return GetFleetsFleetIdOk
     * @throws ApiException
     *             if fails to make API call
     */
    public GetFleetsFleetIdOk getFleetsFleetId(Long fleetId, String datasource) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'fleetId' is set
        if (fleetId == null) {
            throw new ApiException(400, "Missing the required parameter 'fleetId' when calling getFleetsFleetId");
        }

        // create path and map variables
        String localVarPath = "/fleets/{fleet_id}/".replaceAll("\\{format\\}", "json").replaceAll(
                "\\{" + "fleet_id" + "\\}", apiClient.escapeString(fleetId.toString()));

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

        GenericType<GetFleetsFleetIdOk> localVarReturnType = new GenericType<GetFleetsFleetIdOk>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get fleet members Return information about fleet members --- Alternate
     * route: &#x60;/v1/fleets/{fleet_id}/members/&#x60; Alternate route:
     * &#x60;/legacy/fleets/{fleet_id}/members/&#x60; Alternate route:
     * &#x60;/dev/fleets/{fleet_id}/members/&#x60; --- This route is cached for
     * up to 5 seconds
     * 
     * @param fleetId
     *            ID for a fleet (required)
     * @param acceptLanguage
     *            Language to use in the response (optional, default to en)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @return List<GetFleetsFleetIdMembers200Ok>
     * @throws ApiException
     *             if fails to make API call
     */
    public List<GetFleetsFleetIdMembers200Ok> getFleetsFleetIdMembers(Long fleetId, String acceptLanguage,
            String datasource) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'fleetId' is set
        if (fleetId == null) {
            throw new ApiException(400, "Missing the required parameter 'fleetId' when calling getFleetsFleetIdMembers");
        }

        // create path and map variables
        String localVarPath = "/fleets/{fleet_id}/members/".replaceAll("\\{format\\}", "json").replaceAll(
                "\\{" + "fleet_id" + "\\}", apiClient.escapeString(fleetId.toString()));

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

        String[] localVarAuthNames = new String[] { "evesso" };

        GenericType<List<GetFleetsFleetIdMembers200Ok>> localVarReturnType = new GenericType<List<GetFleetsFleetIdMembers200Ok>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get fleet wings Return information about wings in a fleet --- Alternate
     * route: &#x60;/v1/fleets/{fleet_id}/wings/&#x60; Alternate route:
     * &#x60;/legacy/fleets/{fleet_id}/wings/&#x60; Alternate route:
     * &#x60;/dev/fleets/{fleet_id}/wings/&#x60; --- This route is cached for up
     * to 5 seconds
     * 
     * @param fleetId
     *            ID for a fleet (required)
     * @param acceptLanguage
     *            Language to use in the response (optional, default to en)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @return List<GetFleetsFleetIdWings200Ok>
     * @throws ApiException
     *             if fails to make API call
     */
    public List<GetFleetsFleetIdWings200Ok> getFleetsFleetIdWings(Long fleetId, String acceptLanguage, String datasource)
            throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'fleetId' is set
        if (fleetId == null) {
            throw new ApiException(400, "Missing the required parameter 'fleetId' when calling getFleetsFleetIdWings");
        }

        // create path and map variables
        String localVarPath = "/fleets/{fleet_id}/wings/".replaceAll("\\{format\\}", "json").replaceAll(
                "\\{" + "fleet_id" + "\\}", apiClient.escapeString(fleetId.toString()));

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

        String[] localVarAuthNames = new String[] { "evesso" };

        GenericType<List<GetFleetsFleetIdWings200Ok>> localVarReturnType = new GenericType<List<GetFleetsFleetIdWings200Ok>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Create fleet invitation Invite a character into the fleet, if a character
     * has a CSPA charge set, it is not possible to invite them to the fleet
     * using ESI --- Alternate route: &#x60;/v1/fleets/{fleet_id}/members/&#x60;
     * Alternate route: &#x60;/legacy/fleets/{fleet_id}/members/&#x60; Alternate
     * route: &#x60;/dev/fleets/{fleet_id}/members/&#x60;
     * 
     * @param fleetId
     *            ID for a fleet (required)
     * @param invitation
     *            Details of the invitation (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @throws ApiException
     *             if fails to make API call
     */
    public void postFleetsFleetIdMembers(Long fleetId, PostFleetsFleetIdMembersInvitation invitation, String datasource)
            throws ApiException {
        Object localVarPostBody = invitation;

        // verify the required parameter 'fleetId' is set
        if (fleetId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'fleetId' when calling postFleetsFleetIdMembers");
        }

        // verify the required parameter 'invitation' is set
        if (invitation == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'invitation' when calling postFleetsFleetIdMembers");
        }

        // create path and map variables
        String localVarPath = "/fleets/{fleet_id}/members/".replaceAll("\\{format\\}", "json").replaceAll(
                "\\{" + "fleet_id" + "\\}", apiClient.escapeString(fleetId.toString()));

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

        apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
    }

    /**
     * Create fleet wing Create a new wing in a fleet --- Alternate route:
     * &#x60;/v1/fleets/{fleet_id}/wings/&#x60; Alternate route:
     * &#x60;/legacy/fleets/{fleet_id}/wings/&#x60; Alternate route:
     * &#x60;/dev/fleets/{fleet_id}/wings/&#x60;
     * 
     * @param fleetId
     *            ID for a fleet (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @return PostFleetsFleetIdWingsCreated
     * @throws ApiException
     *             if fails to make API call
     */
    public PostFleetsFleetIdWingsCreated postFleetsFleetIdWings(Long fleetId, String datasource) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'fleetId' is set
        if (fleetId == null) {
            throw new ApiException(400, "Missing the required parameter 'fleetId' when calling postFleetsFleetIdWings");
        }

        // create path and map variables
        String localVarPath = "/fleets/{fleet_id}/wings/".replaceAll("\\{format\\}", "json").replaceAll(
                "\\{" + "fleet_id" + "\\}", apiClient.escapeString(fleetId.toString()));

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

        GenericType<PostFleetsFleetIdWingsCreated> localVarReturnType = new GenericType<PostFleetsFleetIdWingsCreated>() {
        };
        return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Create fleet squad Create a new squad in a fleet --- Alternate route:
     * &#x60;/v1/fleets/{fleet_id}/wings/{wing_id}/squads/&#x60; Alternate
     * route: &#x60;/legacy/fleets/{fleet_id}/wings/{wing_id}/squads/&#x60;
     * Alternate route:
     * &#x60;/dev/fleets/{fleet_id}/wings/{wing_id}/squads/&#x60;
     * 
     * @param fleetId
     *            ID for a fleet (required)
     * @param wingId
     *            The wing_id to create squad in (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @return PostFleetsFleetIdWingsWingIdSquadsCreated
     * @throws ApiException
     *             if fails to make API call
     */
    public PostFleetsFleetIdWingsWingIdSquadsCreated postFleetsFleetIdWingsWingIdSquads(Long fleetId, Long wingId,
            String datasource) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'fleetId' is set
        if (fleetId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'fleetId' when calling postFleetsFleetIdWingsWingIdSquads");
        }

        // verify the required parameter 'wingId' is set
        if (wingId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'wingId' when calling postFleetsFleetIdWingsWingIdSquads");
        }

        // create path and map variables
        String localVarPath = "/fleets/{fleet_id}/wings/{wing_id}/squads/".replaceAll("\\{format\\}", "json")
                .replaceAll("\\{" + "fleet_id" + "\\}", apiClient.escapeString(fleetId.toString()))
                .replaceAll("\\{" + "wing_id" + "\\}", apiClient.escapeString(wingId.toString()));

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

        GenericType<PostFleetsFleetIdWingsWingIdSquadsCreated> localVarReturnType = new GenericType<PostFleetsFleetIdWingsWingIdSquadsCreated>() {
        };
        return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Update fleet Update settings about a fleet --- Alternate route:
     * &#x60;/v1/fleets/{fleet_id}/&#x60; Alternate route:
     * &#x60;/legacy/fleets/{fleet_id}/&#x60; Alternate route:
     * &#x60;/dev/fleets/{fleet_id}/&#x60;
     * 
     * @param fleetId
     *            ID for a fleet (required)
     * @param newSettings
     *            What to update for this fleet (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @throws ApiException
     *             if fails to make API call
     */
    public void putFleetsFleetId(Long fleetId, PutFleetsFleetIdNewSettings newSettings, String datasource)
            throws ApiException {
        Object localVarPostBody = newSettings;

        // verify the required parameter 'fleetId' is set
        if (fleetId == null) {
            throw new ApiException(400, "Missing the required parameter 'fleetId' when calling putFleetsFleetId");
        }

        // verify the required parameter 'newSettings' is set
        if (newSettings == null) {
            throw new ApiException(400, "Missing the required parameter 'newSettings' when calling putFleetsFleetId");
        }

        // create path and map variables
        String localVarPath = "/fleets/{fleet_id}/".replaceAll("\\{format\\}", "json").replaceAll(
                "\\{" + "fleet_id" + "\\}", apiClient.escapeString(fleetId.toString()));

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

        apiClient.invokeAPI(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
    }

    /**
     * Move fleet member Move a fleet member around --- Alternate route:
     * &#x60;/v1/fleets/{fleet_id}/members/{member_id}/&#x60; Alternate route:
     * &#x60;/legacy/fleets/{fleet_id}/members/{member_id}/&#x60; Alternate
     * route: &#x60;/dev/fleets/{fleet_id}/members/{member_id}/&#x60;
     * 
     * @param fleetId
     *            ID for a fleet (required)
     * @param memberId
     *            The character ID of a member in this fleet (required)
     * @param movement
     *            Details of the invitation (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @throws ApiException
     *             if fails to make API call
     */
    public void putFleetsFleetIdMembersMemberId(Long fleetId, Integer memberId,
            PutFleetsFleetIdMembersMemberIdMovement movement, String datasource) throws ApiException {
        Object localVarPostBody = movement;

        // verify the required parameter 'fleetId' is set
        if (fleetId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'fleetId' when calling putFleetsFleetIdMembersMemberId");
        }

        // verify the required parameter 'memberId' is set
        if (memberId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'memberId' when calling putFleetsFleetIdMembersMemberId");
        }

        // verify the required parameter 'movement' is set
        if (movement == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'movement' when calling putFleetsFleetIdMembersMemberId");
        }

        // create path and map variables
        String localVarPath = "/fleets/{fleet_id}/members/{member_id}/".replaceAll("\\{format\\}", "json")
                .replaceAll("\\{" + "fleet_id" + "\\}", apiClient.escapeString(fleetId.toString()))
                .replaceAll("\\{" + "member_id" + "\\}", apiClient.escapeString(memberId.toString()));

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

        apiClient.invokeAPI(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
    }

    /**
     * Rename fleet squad Rename a fleet squad --- Alternate route:
     * &#x60;/v1/fleets/{fleet_id}/squads/{squad_id}/&#x60; Alternate route:
     * &#x60;/legacy/fleets/{fleet_id}/squads/{squad_id}/&#x60; Alternate route:
     * &#x60;/dev/fleets/{fleet_id}/squads/{squad_id}/&#x60;
     * 
     * @param fleetId
     *            ID for a fleet (required)
     * @param squadId
     *            The squad to rename (required)
     * @param naming
     *            New name of the squad (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @throws ApiException
     *             if fails to make API call
     */
    public void putFleetsFleetIdSquadsSquadId(Long fleetId, Long squadId, PutFleetsFleetIdSquadsSquadIdNaming naming,
            String datasource) throws ApiException {
        Object localVarPostBody = naming;

        // verify the required parameter 'fleetId' is set
        if (fleetId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'fleetId' when calling putFleetsFleetIdSquadsSquadId");
        }

        // verify the required parameter 'squadId' is set
        if (squadId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'squadId' when calling putFleetsFleetIdSquadsSquadId");
        }

        // verify the required parameter 'naming' is set
        if (naming == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'naming' when calling putFleetsFleetIdSquadsSquadId");
        }

        // create path and map variables
        String localVarPath = "/fleets/{fleet_id}/squads/{squad_id}/".replaceAll("\\{format\\}", "json")
                .replaceAll("\\{" + "fleet_id" + "\\}", apiClient.escapeString(fleetId.toString()))
                .replaceAll("\\{" + "squad_id" + "\\}", apiClient.escapeString(squadId.toString()));

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

        apiClient.invokeAPI(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
    }

    /**
     * Rename fleet wing Rename a fleet wing --- Alternate route:
     * &#x60;/v1/fleets/{fleet_id}/wings/{wing_id}/&#x60; Alternate route:
     * &#x60;/legacy/fleets/{fleet_id}/wings/{wing_id}/&#x60; Alternate route:
     * &#x60;/dev/fleets/{fleet_id}/wings/{wing_id}/&#x60;
     * 
     * @param fleetId
     *            ID for a fleet (required)
     * @param wingId
     *            The wing to rename (required)
     * @param naming
     *            New name of the wing (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @throws ApiException
     *             if fails to make API call
     */
    public void putFleetsFleetIdWingsWingId(Long fleetId, Long wingId, PutFleetsFleetIdWingsWingIdNaming naming,
            String datasource) throws ApiException {
        Object localVarPostBody = naming;

        // verify the required parameter 'fleetId' is set
        if (fleetId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'fleetId' when calling putFleetsFleetIdWingsWingId");
        }

        // verify the required parameter 'wingId' is set
        if (wingId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'wingId' when calling putFleetsFleetIdWingsWingId");
        }

        // verify the required parameter 'naming' is set
        if (naming == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'naming' when calling putFleetsFleetIdWingsWingId");
        }

        // create path and map variables
        String localVarPath = "/fleets/{fleet_id}/wings/{wing_id}/".replaceAll("\\{format\\}", "json")
                .replaceAll("\\{" + "fleet_id" + "\\}", apiClient.escapeString(fleetId.toString()))
                .replaceAll("\\{" + "wing_id" + "\\}", apiClient.escapeString(wingId.toString()));

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

        apiClient.invokeAPI(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
    }
}
