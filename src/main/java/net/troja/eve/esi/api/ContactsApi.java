package net.troja.eve.esi.api;

import net.troja.eve.esi.ApiException;
import net.troja.eve.esi.ApiClient;
import net.troja.eve.esi.Configuration;
import net.troja.eve.esi.Pair;

import javax.ws.rs.core.GenericType;

import net.troja.eve.esi.model.AllianceContactsLabelsResponse;
import net.troja.eve.esi.model.AllianceContactsResponse;
import net.troja.eve.esi.model.ContactLabelsResponse;
import net.troja.eve.esi.model.ContactsResponse;
import net.troja.eve.esi.model.CorporationContactsLabelsResponse;
import net.troja.eve.esi.model.CorporationContactsResponse;

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
     * Delete contacts Bulk delete contacts --- SSO Scope:
     * esi-characters.write_contacts.v1
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
     * @throws ApiException
     *             if fails to make API call
     */
    public void deleteCharactersCharacterIdContacts(Integer characterId, List<Integer> contactIds, String datasource,
            String token) throws ApiException {
        Object localVarPostBody = null;

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
        String localVarPath = "/v2/characters/{character_id}/contacts/".replaceAll("\\{format\\}", "json").replaceAll(
                "\\{" + "character_id" + "\\}", apiClient.escapeString(characterId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("csv", "contact_ids", contactIds));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "token", token));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = { "application/json" };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "evesso" };

        apiClient.invokeAPI(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
    }

    /**
     * Get alliance contacts Return contacts of an alliance --- This route is
     * cached for up to 300 seconds --- Warning: This route has an upgrade
     * available. --- [Diff of the upcoming
     * changes](https://esi.evetech.net/diff
     * /latest/dev/#GET-/alliances/{alliance_id}/contacts/) SSO Scope:
     * esi-alliances.read_contacts.v1
     * 
     * @param allianceId
     *            An EVE alliance ID (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param ifNoneMatch
     *            ETag from a previous request. A 304 will be returned if this
     *            matches the current ETag (optional)
     * @param page
     *            Which page of results to return (optional, default to 1)
     * @param token
     *            Access token to use if unable to set a header (optional)
     * @return List&lt;AllianceContactsResponse&gt;
     * @throws ApiException
     *             if fails to make API call
     */
    public List<AllianceContactsResponse> getAlliancesAllianceIdContacts(Integer allianceId, String datasource,
            String ifNoneMatch, Integer page, String token) throws ApiException {
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

        if (ifNoneMatch != null)
            localVarHeaderParams.put("If-None-Match", apiClient.parameterToString(ifNoneMatch));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = { "application/json" };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "evesso" };

        GenericType<List<AllianceContactsResponse>> localVarReturnType = new GenericType<List<AllianceContactsResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get alliance contact labels Return custom labels for an alliance&#39;s
     * contacts --- This route is cached for up to 300 seconds SSO Scope:
     * esi-alliances.read_contacts.v1
     * 
     * @param allianceId
     *            An EVE alliance ID (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param ifNoneMatch
     *            ETag from a previous request. A 304 will be returned if this
     *            matches the current ETag (optional)
     * @param token
     *            Access token to use if unable to set a header (optional)
     * @return List&lt;AllianceContactsLabelsResponse&gt;
     * @throws ApiException
     *             if fails to make API call
     */
    public List<AllianceContactsLabelsResponse> getAlliancesAllianceIdContactsLabels(Integer allianceId,
            String datasource, String ifNoneMatch, String token) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'allianceId' is set
        if (allianceId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'allianceId' when calling getAlliancesAllianceIdContactsLabels");
        }

        // create path and map variables
        String localVarPath = "/v1/alliances/{alliance_id}/contacts/labels/".replaceAll("\\{format\\}", "json")
                .replaceAll("\\{" + "alliance_id" + "\\}", apiClient.escapeString(allianceId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "token", token));

        if (ifNoneMatch != null)
            localVarHeaderParams.put("If-None-Match", apiClient.parameterToString(ifNoneMatch));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = { "application/json" };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "evesso" };

        GenericType<List<AllianceContactsLabelsResponse>> localVarReturnType = new GenericType<List<AllianceContactsLabelsResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get contacts Return contacts of a character --- This route is cached for
     * up to 300 seconds --- Warning: This route has an upgrade available. ---
     * [Diff of the upcoming
     * changes](https://esi.evetech.net/diff/latest/dev/#GET
     * -/characters/{character_id}/contacts/) SSO Scope:
     * esi-characters.read_contacts.v1
     * 
     * @param characterId
     *            An EVE character ID (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param ifNoneMatch
     *            ETag from a previous request. A 304 will be returned if this
     *            matches the current ETag (optional)
     * @param page
     *            Which page of results to return (optional, default to 1)
     * @param token
     *            Access token to use if unable to set a header (optional)
     * @return List&lt;ContactsResponse&gt;
     * @throws ApiException
     *             if fails to make API call
     */
    public List<ContactsResponse> getCharactersCharacterIdContacts(Integer characterId, String datasource,
            String ifNoneMatch, Integer page, String token) throws ApiException {
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

        if (ifNoneMatch != null)
            localVarHeaderParams.put("If-None-Match", apiClient.parameterToString(ifNoneMatch));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = { "application/json" };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "evesso" };

        GenericType<List<ContactsResponse>> localVarReturnType = new GenericType<List<ContactsResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get contact labels Return custom labels for a character&#39;s contacts
     * --- This route is cached for up to 300 seconds SSO Scope:
     * esi-characters.read_contacts.v1
     * 
     * @param characterId
     *            An EVE character ID (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param ifNoneMatch
     *            ETag from a previous request. A 304 will be returned if this
     *            matches the current ETag (optional)
     * @param token
     *            Access token to use if unable to set a header (optional)
     * @return List&lt;ContactLabelsResponse&gt;
     * @throws ApiException
     *             if fails to make API call
     */
    public List<ContactLabelsResponse> getCharactersCharacterIdContactsLabels(Integer characterId, String datasource,
            String ifNoneMatch, String token) throws ApiException {
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

        if (ifNoneMatch != null)
            localVarHeaderParams.put("If-None-Match", apiClient.parameterToString(ifNoneMatch));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = { "application/json" };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "evesso" };

        GenericType<List<ContactLabelsResponse>> localVarReturnType = new GenericType<List<ContactLabelsResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get corporation contacts Return contacts of a corporation --- This route
     * is cached for up to 300 seconds --- Warning: This route has an upgrade
     * available. --- [Diff of the upcoming
     * changes](https://esi.evetech.net/diff
     * /latest/dev/#GET-/corporations/{corporation_id}/contacts/) SSO Scope:
     * esi-corporations.read_contacts.v1
     * 
     * @param corporationId
     *            An EVE corporation ID (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param ifNoneMatch
     *            ETag from a previous request. A 304 will be returned if this
     *            matches the current ETag (optional)
     * @param page
     *            Which page of results to return (optional, default to 1)
     * @param token
     *            Access token to use if unable to set a header (optional)
     * @return List&lt;CorporationContactsResponse&gt;
     * @throws ApiException
     *             if fails to make API call
     */
    public List<CorporationContactsResponse> getCorporationsCorporationIdContacts(Integer corporationId,
            String datasource, String ifNoneMatch, Integer page, String token) throws ApiException {
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

        if (ifNoneMatch != null)
            localVarHeaderParams.put("If-None-Match", apiClient.parameterToString(ifNoneMatch));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = { "application/json" };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "evesso" };

        GenericType<List<CorporationContactsResponse>> localVarReturnType = new GenericType<List<CorporationContactsResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get corporation contact labels Return custom labels for a
     * corporation&#39;s contacts --- This route is cached for up to 300 seconds
     * SSO Scope: esi-corporations.read_contacts.v1
     * 
     * @param corporationId
     *            An EVE corporation ID (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param ifNoneMatch
     *            ETag from a previous request. A 304 will be returned if this
     *            matches the current ETag (optional)
     * @param token
     *            Access token to use if unable to set a header (optional)
     * @return List&lt;CorporationContactsLabelsResponse&gt;
     * @throws ApiException
     *             if fails to make API call
     */
    public List<CorporationContactsLabelsResponse> getCorporationsCorporationIdContactsLabels(Integer corporationId,
            String datasource, String ifNoneMatch, String token) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'corporationId' is set
        if (corporationId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'corporationId' when calling getCorporationsCorporationIdContactsLabels");
        }

        // create path and map variables
        String localVarPath = "/v1/corporations/{corporation_id}/contacts/labels/".replaceAll("\\{format\\}", "json")
                .replaceAll("\\{" + "corporation_id" + "\\}", apiClient.escapeString(corporationId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "token", token));

        if (ifNoneMatch != null)
            localVarHeaderParams.put("If-None-Match", apiClient.parameterToString(ifNoneMatch));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = { "application/json" };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "evesso" };

        GenericType<List<CorporationContactsLabelsResponse>> localVarReturnType = new GenericType<List<CorporationContactsLabelsResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Add contacts Bulk add contacts with same settings --- Warning: This route
     * has an upgrade available. --- [Diff of the upcoming
     * changes](https://esi.evetech
     * .net/diff/latest/dev/#POST-/characters/{character_id}/contacts/) SSO
     * Scope: esi-characters.write_contacts.v1
     * 
     * @param characterId
     *            An EVE character ID (required)
     * @param contactIds
     *            A list of contacts (required)
     * @param standing
     *            Standing for the contact (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param labelId
     *            Add a custom label to the new contact (optional, default to 0)
     * @param token
     *            Access token to use if unable to set a header (optional)
     * @param watched
     *            Whether the contact should be watched, note this is only
     *            effective on characters (optional, default to false)
     * @return List&lt;Integer&gt;
     * @throws ApiException
     *             if fails to make API call
     */
    public List<Integer> postCharactersCharacterIdContacts(Integer characterId, List<Integer> contactIds,
            Float standing, String datasource, Long labelId, String token, Boolean watched) throws ApiException {
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
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "watched", watched));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = { "application/json" };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "evesso" };

        GenericType<List<Integer>> localVarReturnType = new GenericType<List<Integer>>() {
        };
        return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Edit contacts Bulk edit contacts with same settings --- Warning: This
     * route has an upgrade available. --- [Diff of the upcoming
     * changes](https:/
     * /esi.evetech.net/diff/latest/dev/#PUT-/characters/{character_id
     * }/contacts/) SSO Scope: esi-characters.write_contacts.v1
     * 
     * @param characterId
     *            An EVE character ID (required)
     * @param contactIds
     *            A list of contacts (required)
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
     * @param watched
     *            Whether the contact should be watched, note this is only
     *            effective on characters (optional, default to false)
     * @throws ApiException
     *             if fails to make API call
     */
    public void putCharactersCharacterIdContacts(Integer characterId, List<Integer> contactIds, Float standing,
            String datasource, Long labelId, String token, Boolean watched) throws ApiException {
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
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "watched", watched));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = { "application/json" };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "evesso" };

        apiClient.invokeAPI(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
    }
}
