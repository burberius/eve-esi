package net.troja.eve.esi.api;

import net.troja.eve.esi.ApiException;
import net.troja.eve.esi.ApiClient;
import net.troja.eve.esi.Configuration;
import net.troja.eve.esi.Pair;

import javax.ws.rs.core.GenericType;

import net.troja.eve.esi.model.CharacterCalendarEventResponse;
import net.troja.eve.esi.model.CharacterCalendarResponse;
import net.troja.eve.esi.model.EventResponseStatus;

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
     * If no event ID is given, the resource will return the next 50
     * chronological event summaries from now. If an event ID is specified, it
     * will return the next 50 chronological event summaries from after that
     * event. --- Alternate route:
     * &#x60;/v1/characters/{character_id}/calendar/&#x60; Alternate route:
     * &#x60;/legacy/characters/{character_id}/calendar/&#x60; Alternate route:
     * &#x60;/dev/characters/{character_id}/calendar/&#x60; --- This route is
     * cached for up to 5 seconds SSO Scope:
     * esi-calendar.read_calendar_events.v1
     * 
     * @param characterId
     *            The character to retrieve events from (required)
     * @param fromEvent
     *            The event ID to retrieve events from (optional)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @return List<CharacterCalendarResponse>
     * @throws ApiException
     *             if fails to make API call
     */
    public List<CharacterCalendarResponse> getCharactersCharacterIdCalendar(Long characterId, Integer fromEvent,
            String datasource) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'characterId' is set
        if (characterId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'characterId' when calling getCharactersCharacterIdCalendar");
        }

        // create path and map variables
        String localVarPath = "/characters/{character_id}/calendar/".replaceAll("\\{format\\}", "json").replaceAll(
                "\\{" + "character_id" + "\\}", apiClient.escapeString(characterId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "from_event", fromEvent));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "evesso" };

        GenericType<List<CharacterCalendarResponse>> localVarReturnType = new GenericType<List<CharacterCalendarResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get an event Get all the information for a specific event --- Alternate
     * route: &#x60;/v3/characters/{character_id}/calendar/{event_id}/&#x60;
     * Alternate route:
     * &#x60;/dev/characters/{character_id}/calendar/{event_id}/&#x60; --- This
     * route is cached for up to 5 seconds SSO Scope:
     * esi-calendar.read_calendar_events.v1
     * 
     * @param characterId
     *            The character id requesting the event (required)
     * @param eventId
     *            The id of the event requested (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @return CharacterCalendarEventResponse
     * @throws ApiException
     *             if fails to make API call
     */
    public CharacterCalendarEventResponse getCharactersCharacterIdCalendarEventId(Long characterId, Integer eventId,
            String datasource) throws ApiException {
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
        String localVarPath = "/characters/{character_id}/calendar/{event_id}/".replaceAll("\\{format\\}", "json")
                .replaceAll("\\{" + "character_id" + "\\}", apiClient.escapeString(characterId.toString()))
                .replaceAll("\\{" + "event_id" + "\\}", apiClient.escapeString(eventId.toString()));

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

        GenericType<CharacterCalendarEventResponse> localVarReturnType = new GenericType<CharacterCalendarEventResponse>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Respond to an event Set your response status to an event --- Alternate
     * route: &#x60;/v3/characters/{character_id}/calendar/{event_id}/&#x60;
     * Alternate route:
     * &#x60;/dev/characters/{character_id}/calendar/{event_id}/&#x60; SSO
     * Scope: esi-calendar.respond_calendar_events.v1
     * 
     * @param characterId
     *            The character ID requesting the event (required)
     * @param eventId
     *            The ID of the event requested (required)
     * @param response
     *            The response value to set, overriding current value.
     *            (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @throws ApiException
     *             if fails to make API call
     */
    public void putCharactersCharacterIdCalendarEventId(Integer characterId, Integer eventId,
            EventResponseStatus response, String datasource) throws ApiException {
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
        String localVarPath = "/characters/{character_id}/calendar/{event_id}/".replaceAll("\\{format\\}", "json")
                .replaceAll("\\{" + "character_id" + "\\}", apiClient.escapeString(characterId.toString()))
                .replaceAll("\\{" + "event_id" + "\\}", apiClient.escapeString(eventId.toString()));

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
