package net.troja.eve.esi.api;

import net.troja.eve.esi.ApiException;
import net.troja.eve.esi.ApiClient;
import net.troja.eve.esi.Configuration;
import net.troja.eve.esi.Pair;

import javax.ws.rs.core.GenericType;

import net.troja.eve.esi.model.AllianceContactsResponse;
import net.troja.eve.esi.model.ContactLabelsResponse;
import net.troja.eve.esi.model.ContactsResponse;
import net.troja.eve.esi.model.CorporationContactsResponse;
import net.troja.eve.esi.model.Forbidden;
import net.troja.eve.esi.model.InternalServerError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactsApi {
    private ApiClient apiClient;

    public ContactsApi() {
        this(Configuration.getDefaultApiClient());
    }

    public ContactsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Delete contacts Bulk delete contacts --- [This route has an available
     * update](https://esi.tech.ccp.is/diff/latest/dev/#DELETE-/characters/{
     * character_id}/contacts/) SSO Scope: esi-characters.write_contacts.v1
     * 
     * @param characterId
     *            An EVE character ID (required)
     * @param contactIds
     *            A list of contacts to delete (required)
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
    public void deleteCharactersCharacterIdContacts(Integer characterId, List<Integer> contactIds, String datasource,
            String token, String userAgent, String xUserAgent) throws ApiException {
        Object localVarPostBody = contactIds;

        // verify the required parameter 'characterId' is set
        if (characterId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'characterId' when calling deleteCharactersCharacterIdContacts");
        }

        // verify the required parameter 'contactIds' is set
        if (contactIds == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'contactIds' when calling deleteCharactersCharacterIdContacts");
        }

        // create path and map variables
        String localVarPath = "/v1/characters/{character_id}/contacts/".replaceAll("\\{format\\}", "json").replaceAll(
                "\\{" + "character_id" + "\\}", apiClient.escapeString(characterId.toString()));

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

        apiClient.invokeAPI(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
    }

    /**
     * Get alliance contacts Return contacts of an alliance --- This route is
     * cached for up to 300 seconds SSO Scope: esi-alliances.read_contacts.v1
     * 
     * @param allianceId
     *            An EVE alliance ID (required)
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
     * @return List&lt;AllianceContactsResponse&gt;
     * @throws ApiException
     *             if fails to make API call
     */
    public List<AllianceContactsResponse> getAlliancesAllianceIdContacts(Integer allianceId, String datasource,
            Integer page, String token, String userAgent, String xUserAgent) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'allianceId' is set
        if (allianceId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'allianceId' when calling getAlliancesAllianceIdContacts");
        }

        // create path and map variables
        String localVarPath = "/v1/alliances/{alliance_id}/contacts/".replaceAll("\\{format\\}", "json").replaceAll(
                "\\{" + "alliance_id" + "\\}", apiClient.escapeString(allianceId.toString()));

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

        GenericType<List<AllianceContactsResponse>> localVarReturnType = new GenericType<List<AllianceContactsResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get contacts Return contacts of a character --- This route is cached for
     * up to 300 seconds SSO Scope: esi-characters.read_contacts.v1
     * 
     * @param characterId
     *            An EVE character ID (required)
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
     * @return List&lt;ContactsResponse&gt;
     * @throws ApiException
     *             if fails to make API call
     */
    public List<ContactsResponse> getCharactersCharacterIdContacts(Integer characterId, String datasource,
            Integer page, String token, String userAgent, String xUserAgent) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'characterId' is set
        if (characterId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'characterId' when calling getCharactersCharacterIdContacts");
        }

        // create path and map variables
        String localVarPath = "/v1/characters/{character_id}/contacts/".replaceAll("\\{format\\}", "json").replaceAll(
                "\\{" + "character_id" + "\\}", apiClient.escapeString(characterId.toString()));

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

        GenericType<List<ContactsResponse>> localVarReturnType = new GenericType<List<ContactsResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get contact labels Return custom labels for contacts the character
     * defined --- This route is cached for up to 300 seconds SSO Scope:
     * esi-characters.read_contacts.v1
     * 
     * @param characterId
     *            An EVE character ID (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param token
     *            Access token to use if unable to set a header (optional)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return List&lt;ContactLabelsResponse&gt;
     * @throws ApiException
     *             if fails to make API call
     */
    public List<ContactLabelsResponse> getCharactersCharacterIdContactsLabels(Integer characterId, String datasource,
            String token, String userAgent, String xUserAgent) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'characterId' is set
        if (characterId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'characterId' when calling getCharactersCharacterIdContactsLabels");
        }

        // create path and map variables
        String localVarPath = "/v1/characters/{character_id}/contacts/labels/".replaceAll("\\{format\\}", "json")
                .replaceAll("\\{" + "character_id" + "\\}", apiClient.escapeString(characterId.toString()));

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

        GenericType<List<ContactLabelsResponse>> localVarReturnType = new GenericType<List<ContactLabelsResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get corporation contacts Return contacts of a corporation --- This route
     * is cached for up to 300 seconds SSO Scope:
     * esi-corporations.read_contacts.v1
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
     * @return List&lt;CorporationContactsResponse&gt;
     * @throws ApiException
     *             if fails to make API call
     */
    public List<CorporationContactsResponse> getCorporationsCorporationIdContacts(Integer corporationId,
            String datasource, Integer page, String token, String userAgent, String xUserAgent) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'corporationId' is set
        if (corporationId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'corporationId' when calling getCorporationsCorporationIdContacts");
        }

        // create path and map variables
        String localVarPath = "/v1/corporations/{corporation_id}/contacts/".replaceAll("\\{format\\}", "json")
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

        GenericType<List<CorporationContactsResponse>> localVarReturnType = new GenericType<List<CorporationContactsResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Add contacts Bulk add contacts with same settings --- SSO Scope:
     * esi-characters.write_contacts.v1
     * 
     * @param characterId
     *            An EVE character ID (required)
     * @param contactIds
     *            A list of contacts to add (required)
     * @param standing
     *            Standing for the new contact (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param labelId
     *            Add a custom label to the new contact (optional, default to 0)
     * @param token
     *            Access token to use if unable to set a header (optional)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param watched
     *            Whether the new contact should be watched, note this is only
     *            effective on characters (optional, default to false)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return List&lt;Integer&gt;
     * @throws ApiException
     *             if fails to make API call
     */
    public List<Integer> postCharactersCharacterIdContacts(Integer characterId, List<Integer> contactIds,
            Float standing, String datasource, Long labelId, String token, String userAgent, Boolean watched,
            String xUserAgent) throws ApiException {
        Object localVarPostBody = contactIds;

        // verify the required parameter 'characterId' is set
        if (characterId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'characterId' when calling postCharactersCharacterIdContacts");
        }

        // verify the required parameter 'contactIds' is set
        if (contactIds == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'contactIds' when calling postCharactersCharacterIdContacts");
        }

        // verify the required parameter 'standing' is set
        if (standing == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'standing' when calling postCharactersCharacterIdContacts");
        }

        // create path and map variables
        String localVarPath = "/v1/characters/{character_id}/contacts/".replaceAll("\\{format\\}", "json").replaceAll(
                "\\{" + "character_id" + "\\}", apiClient.escapeString(characterId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "label_id", labelId));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "standing", standing));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "token", token));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "user_agent", userAgent));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "watched", watched));

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
        return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Edit contacts Bulk edit contacts with same settings --- SSO Scope:
     * esi-characters.write_contacts.v1
     * 
     * @param characterId
     *            An EVE character ID (required)
     * @param contactIds
     *            A list of contacts to edit (required)
     * @param standing
     *            Standing for the contact (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param labelId
     *            Add a custom label to the contact, use 0 for clearing label
     *            (optional, default to 0)
     * @param token
     *            Access token to use if unable to set a header (optional)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param watched
     *            Whether the contact should be watched, note this is only
     *            effective on characters (optional, default to false)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @throws ApiException
     *             if fails to make API call
     */
    public void putCharactersCharacterIdContacts(Integer characterId, List<Integer> contactIds, Float standing,
            String datasource, Long labelId, String token, String userAgent, Boolean watched, String xUserAgent)
            throws ApiException {
        Object localVarPostBody = contactIds;

        // verify the required parameter 'characterId' is set
        if (characterId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'characterId' when calling putCharactersCharacterIdContacts");
        }

        // verify the required parameter 'contactIds' is set
        if (contactIds == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'contactIds' when calling putCharactersCharacterIdContacts");
        }

        // verify the required parameter 'standing' is set
        if (standing == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'standing' when calling putCharactersCharacterIdContacts");
        }

        // create path and map variables
        String localVarPath = "/v1/characters/{character_id}/contacts/".replaceAll("\\{format\\}", "json").replaceAll(
                "\\{" + "character_id" + "\\}", apiClient.escapeString(characterId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "label_id", labelId));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "standing", standing));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "token", token));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "user_agent", userAgent));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "watched", watched));

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
