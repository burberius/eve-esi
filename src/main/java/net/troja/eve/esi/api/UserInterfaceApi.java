package net.troja.eve.esi.api;

import net.troja.eve.esi.ApiException;
import net.troja.eve.esi.ApiClient;
import net.troja.eve.esi.Configuration;
import net.troja.eve.esi.Pair;

import javax.ws.rs.core.GenericType;

import net.troja.eve.esi.model.Forbidden;
import net.troja.eve.esi.model.UiNewMail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserInterfaceApi {
    private ApiClient apiClient;

    public UserInterfaceApi() {
        this(Configuration.getDefaultApiClient());
    }

    public UserInterfaceApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Set Autopilot Waypoint Set a solar system as autopilot waypoint --- SSO
     * Scope: esi-ui.write_waypoint.v1
     * 
     * @param addToBeginning
     *            Whether this solar system should be added to the beginning of
     *            all waypoints (required)
     * @param clearOtherWaypoints
     *            Whether clean other waypoints beforing adding this one
     *            (required)
     * @param destinationId
     *            The destination to travel to, can be solar system, station or
     *            structure&#39;s id (required)
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
    public void postUiAutopilotWaypoint(Boolean addToBeginning, Boolean clearOtherWaypoints, Long destinationId,
            String datasource, String token, String userAgent, String xUserAgent) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'addToBeginning' is set
        if (addToBeginning == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'addToBeginning' when calling postUiAutopilotWaypoint");
        }

        // verify the required parameter 'clearOtherWaypoints' is set
        if (clearOtherWaypoints == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'clearOtherWaypoints' when calling postUiAutopilotWaypoint");
        }

        // verify the required parameter 'destinationId' is set
        if (destinationId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'destinationId' when calling postUiAutopilotWaypoint");
        }

        // create path and map variables
        String localVarPath = "/v2/ui/autopilot/waypoint/".replaceAll("\\{format\\}", "json");

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "add_to_beginning", addToBeginning));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "clear_other_waypoints", clearOtherWaypoints));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "destination_id", destinationId));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "token", token));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "user_agent", userAgent));

        if (xUserAgent != null)
            localVarHeaderParams.put("X-User-Agent", apiClient.parameterToString(xUserAgent));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = { "application/json" };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "evesso" };

        apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
    }

    /**
     * Open Contract Window Open the contract window inside the client --- SSO
     * Scope: esi-ui.open_window.v1
     * 
     * @param contractId
     *            The contract to open (required)
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
    public void postUiOpenwindowContract(Integer contractId, String datasource, String token, String userAgent,
            String xUserAgent) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'contractId' is set
        if (contractId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'contractId' when calling postUiOpenwindowContract");
        }

        // create path and map variables
        String localVarPath = "/v1/ui/openwindow/contract/".replaceAll("\\{format\\}", "json");

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "contract_id", contractId));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "token", token));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "user_agent", userAgent));

        if (xUserAgent != null)
            localVarHeaderParams.put("X-User-Agent", apiClient.parameterToString(xUserAgent));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = { "application/json" };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "evesso" };

        apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
    }

    /**
     * Open Information Window Open the information window for a character,
     * corporation or alliance inside the client --- SSO Scope:
     * esi-ui.open_window.v1
     * 
     * @param targetId
     *            The target to open (required)
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
    public void postUiOpenwindowInformation(Integer targetId, String datasource, String token, String userAgent,
            String xUserAgent) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'targetId' is set
        if (targetId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'targetId' when calling postUiOpenwindowInformation");
        }

        // create path and map variables
        String localVarPath = "/v1/ui/openwindow/information/".replaceAll("\\{format\\}", "json");

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "target_id", targetId));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "token", token));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "user_agent", userAgent));

        if (xUserAgent != null)
            localVarHeaderParams.put("X-User-Agent", apiClient.parameterToString(xUserAgent));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = { "application/json" };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "evesso" };

        apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
    }

    /**
     * Open Market Details Open the market details window for a specific typeID
     * inside the client --- SSO Scope: esi-ui.open_window.v1
     * 
     * @param typeId
     *            The item type to open in market window (required)
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
    public void postUiOpenwindowMarketdetails(Integer typeId, String datasource, String token, String userAgent,
            String xUserAgent) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'typeId' is set
        if (typeId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'typeId' when calling postUiOpenwindowMarketdetails");
        }

        // create path and map variables
        String localVarPath = "/v1/ui/openwindow/marketdetails/".replaceAll("\\{format\\}", "json");

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "token", token));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "type_id", typeId));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "user_agent", userAgent));

        if (xUserAgent != null)
            localVarHeaderParams.put("X-User-Agent", apiClient.parameterToString(xUserAgent));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = { "application/json" };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "evesso" };

        apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
    }

    /**
     * Open New Mail Window Open the New Mail window, according to settings from
     * the request if applicable --- SSO Scope: esi-ui.open_window.v1
     * 
     * @param newMail
     *            The details of mail to create (required)
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
    public void postUiOpenwindowNewmail(UiNewMail newMail, String datasource, String token, String userAgent,
            String xUserAgent) throws ApiException {
        Object localVarPostBody = newMail;

        // verify the required parameter 'newMail' is set
        if (newMail == null) {
            throw new ApiException(400, "Missing the required parameter 'newMail' when calling postUiOpenwindowNewmail");
        }

        // create path and map variables
        String localVarPath = "/v1/ui/openwindow/newmail/".replaceAll("\\{format\\}", "json");

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

        final String[] localVarContentTypes = { "application/json" };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "evesso" };

        apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
    }
}
