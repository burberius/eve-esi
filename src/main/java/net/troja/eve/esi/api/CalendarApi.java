package net.troja.eve.esi.api;

import net.troja.eve.esi.ApiException;
import net.troja.eve.esi.ApiClient;
import net.troja.eve.esi.Configuration;
import net.troja.eve.esi.Pair;

import javax.ws.rs.core.GenericType;

import net.troja.eve.esi.model.CharacterCalendarAttendeesResponse;
import net.troja.eve.esi.model.CharacterCalendarEvent;
import net.troja.eve.esi.model.CharacterCalendarEventResponse;
import net.troja.eve.esi.model.CharacterCalendarResponse;
import net.troja.eve.esi.model.Forbidden;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalendarApi {
    private ApiClient apiClient;

    public CalendarApi() {
        this(Configuration.getDefaultApiClient());
    }

    public CalendarApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * List calendar event summaries Get 50 event summaries from the calendar.
     * If no from_event ID is given, the resource will return the next 50
     * chronological event summaries from now. If a from_event ID is specified,
     * it will return the next 50 chronological event summaries from after that
     * event. --- This route is cached for up to 5 seconds SSO Scope:
     * esi-calendar.read_calendar_events.v1
     * 
     * @param characterId
     *            An EVE character ID (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param fromEvent
     *            The event ID to retrieve events from (optional)
     * @param ifNoneMatch
     *            ETag from a previous request. A 304 will be returned if this
     *            matches the current ETag (optional)
     * @param token
     *            Access token to use if unable to set a header (optional)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return List&lt;CharacterCalendarResponse&gt;
     * @throws ApiException
     *             if fails to make API call
     */
    public List<CharacterCalendarResponse> getCharactersCharacterIdCalendar(Integer characterId, String datasource,
            Integer fromEvent, String ifNoneMatch, String token, String userAgent, String xUserAgent)
            throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'characterId' is set
        if (characterId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'characterId' when calling getCharactersCharacterIdCalendar");
        }

        // create path and map variables
        String localVarPath = "/v1/characters/{character_id}/calendar/".replaceAll("\\{format\\}", "json").replaceAll(
                "\\{" + "character_id" + "\\}", apiClient.escapeString(characterId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "from_event", fromEvent));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "token", token));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "user_agent", userAgent));

        if (ifNoneMatch != null)
            localVarHeaderParams.put("If-None-Match", apiClient.parameterToString(ifNoneMatch));
        if (xUserAgent != null)
            localVarHeaderParams.put("X-User-Agent", apiClient.parameterToString(xUserAgent));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = { "application/json" };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "evesso" };

        GenericType<List<CharacterCalendarResponse>> localVarReturnType = new GenericType<List<CharacterCalendarResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get an event Get all the information for a specific event --- This route
     * is cached for up to 5 seconds SSO Scope:
     * esi-calendar.read_calendar_events.v1
     * 
     * @param characterId
     *            An EVE character ID (required)
     * @param eventId
     *            The id of the event requested (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param ifNoneMatch
     *            ETag from a previous request. A 304 will be returned if this
     *            matches the current ETag (optional)
     * @param token
     *            Access token to use if unable to set a header (optional)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return CharacterCalendarEventResponse
     * @throws ApiException
     *             if fails to make API call
     */
    public CharacterCalendarEventResponse getCharactersCharacterIdCalendarEventId(Integer characterId, Integer eventId,
            String datasource, String ifNoneMatch, String token, String userAgent, String xUserAgent)
            throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'characterId' is set
        if (characterId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'characterId' when calling getCharactersCharacterIdCalendarEventId");
        }

        // verify the required parameter 'eventId' is set
        if (eventId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'eventId' when calling getCharactersCharacterIdCalendarEventId");
        }

        // create path and map variables
        String localVarPath = "/v3/characters/{character_id}/calendar/{event_id}/".replaceAll("\\{format\\}", "json")
                .replaceAll("\\{" + "character_id" + "\\}", apiClient.escapeString(characterId.toString()))
                .replaceAll("\\{" + "event_id" + "\\}", apiClient.escapeString(eventId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "token", token));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "user_agent", userAgent));

        if (ifNoneMatch != null)
            localVarHeaderParams.put("If-None-Match", apiClient.parameterToString(ifNoneMatch));
        if (xUserAgent != null)
            localVarHeaderParams.put("X-User-Agent", apiClient.parameterToString(xUserAgent));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = { "application/json" };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "evesso" };

        GenericType<CharacterCalendarEventResponse> localVarReturnType = new GenericType<CharacterCalendarEventResponse>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get attendees Get all invited attendees for a given event --- This route
     * is cached for up to 600 seconds SSO Scope:
     * esi-calendar.read_calendar_events.v1
     * 
     * @param characterId
     *            An EVE character ID (required)
     * @param eventId
     *            The id of the event requested (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param ifNoneMatch
     *            ETag from a previous request. A 304 will be returned if this
     *            matches the current ETag (optional)
     * @param token
     *            Access token to use if unable to set a header (optional)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return List&lt;CharacterCalendarAttendeesResponse&gt;
     * @throws ApiException
     *             if fails to make API call
     */
    public List<CharacterCalendarAttendeesResponse> getCharactersCharacterIdCalendarEventIdAttendees(
            Integer characterId, Integer eventId, String datasource, String ifNoneMatch, String token,
            String userAgent, String xUserAgent) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'characterId' is set
        if (characterId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'characterId' when calling getCharactersCharacterIdCalendarEventIdAttendees");
        }

        // verify the required parameter 'eventId' is set
        if (eventId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'eventId' when calling getCharactersCharacterIdCalendarEventIdAttendees");
        }

        // create path and map variables
        String localVarPath = "/v1/characters/{character_id}/calendar/{event_id}/attendees/"
                .replaceAll("\\{format\\}", "json")
                .replaceAll("\\{" + "character_id" + "\\}", apiClient.escapeString(characterId.toString()))
                .replaceAll("\\{" + "event_id" + "\\}", apiClient.escapeString(eventId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "token", token));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "user_agent", userAgent));

        if (ifNoneMatch != null)
            localVarHeaderParams.put("If-None-Match", apiClient.parameterToString(ifNoneMatch));
        if (xUserAgent != null)
            localVarHeaderParams.put("X-User-Agent", apiClient.parameterToString(xUserAgent));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = { "application/json" };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "evesso" };

        GenericType<List<CharacterCalendarAttendeesResponse>> localVarReturnType = new GenericType<List<CharacterCalendarAttendeesResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Respond to an event Set your response status to an event --- SSO Scope:
     * esi-calendar.respond_calendar_events.v1
     * 
     * @param characterId
     *            An EVE character ID (required)
     * @param eventId
     *            The ID of the event requested (required)
     * @param response
     *            The response value to set, overriding current value.
     *            (required)
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
    public void putCharactersCharacterIdCalendarEventId(Integer characterId, Integer eventId,
            CharacterCalendarEvent response, String datasource, String token, String userAgent, String xUserAgent)
            throws ApiException {
        Object localVarPostBody = response;

        // verify the required parameter 'characterId' is set
        if (characterId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'characterId' when calling putCharactersCharacterIdCalendarEventId");
        }

        // verify the required parameter 'eventId' is set
        if (eventId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'eventId' when calling putCharactersCharacterIdCalendarEventId");
        }

        // verify the required parameter 'response' is set
        if (response == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'response' when calling putCharactersCharacterIdCalendarEventId");
        }

        // create path and map variables
        String localVarPath = "/v3/characters/{character_id}/calendar/{event_id}/".replaceAll("\\{format\\}", "json")
                .replaceAll("\\{" + "character_id" + "\\}", apiClient.escapeString(characterId.toString()))
                .replaceAll("\\{" + "event_id" + "\\}", apiClient.escapeString(eventId.toString()));

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

        apiClient.invokeAPI(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
    }
}
