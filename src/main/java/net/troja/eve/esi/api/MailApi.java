package net.troja.eve.esi.api;

import net.troja.eve.esi.ApiException;
import net.troja.eve.esi.ApiClient;
import net.troja.eve.esi.Configuration;
import net.troja.eve.esi.Pair;

import javax.ws.rs.core.GenericType;

import net.troja.eve.esi.model.MailHeadersResponse;
import net.troja.eve.esi.model.MailLabelsResponse;
import net.troja.eve.esi.model.CharacterMailinglistsResponse;
import net.troja.eve.esi.model.MailResponse;
import net.troja.eve.esi.model.BadRequest;
import net.troja.eve.esi.model.Mail;
import net.troja.eve.esi.model.MailLabel;
import net.troja.eve.esi.model.MailMetaData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MailApi {
    private ApiClient apiClient;

    public MailApi() {
        this(Configuration.getDefaultApiClient());
    }

    public MailApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Delete a mail Delete a mail --- Alternate route:
     * &#x60;/v1/characters/{character_id}/mail/{mail_id}/&#x60; Alternate
     * route: &#x60;/legacy/characters/{character_id}/mail/{mail_id}/&#x60;
     * Alternate route:
     * &#x60;/dev/characters/{character_id}/mail/{mail_id}/&#x60;
     * 
     * @param characterId
     *            An EVE character ID (required)
     * @param mailId
     *            An EVE mail ID (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @throws ApiException
     *             if fails to make API call
     */
    public void deleteCharactersCharacterIdMailMailId(Integer characterId, Integer mailId, String datasource)
            throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'characterId' is set
        if (characterId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'characterId' when calling deleteCharactersCharacterIdMailMailId");
        }

        // verify the required parameter 'mailId' is set
        if (mailId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'mailId' when calling deleteCharactersCharacterIdMailMailId");
        }

        // create path and map variables
        String localVarPath = "/characters/{character_id}/mail/{mail_id}/".replaceAll("\\{format\\}", "json")
                .replaceAll("\\{" + "character_id" + "\\}", apiClient.escapeString(characterId.toString()))
                .replaceAll("\\{" + "mail_id" + "\\}", apiClient.escapeString(mailId.toString()));

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
     * Return mail headers Return the 50 most recent mail headers belonging to
     * the character that match the query criteria. Queries can be filtered by
     * label, and last_mail_id can be used to paginate backwards. --- Alternate
     * route: &#x60;/v1/characters/{character_id}/mail/&#x60; Alternate route:
     * &#x60;/legacy/characters/{character_id}/mail/&#x60; Alternate route:
     * &#x60;/dev/characters/{character_id}/mail/&#x60; --- This route is cached
     * for up to 30 seconds
     * 
     * @param characterId
     *            An EVE character ID (required)
     * @param labels
     *            Fetch only mails that match one or more of the given labels
     *            (optional)
     * @param lastMailId
     *            List only mail with an ID lower than the given ID, if present
     *            (optional)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @return List<MailHeadersResponse>
     * @throws ApiException
     *             if fails to make API call
     */
    public List<MailHeadersResponse> getCharactersCharacterIdMail(Integer characterId, List<Long> labels,
            Integer lastMailId, String datasource) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'characterId' is set
        if (characterId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'characterId' when calling getCharactersCharacterIdMail");
        }

        // create path and map variables
        String localVarPath = "/characters/{character_id}/mail/".replaceAll("\\{format\\}", "json").replaceAll(
                "\\{" + "character_id" + "\\}", apiClient.escapeString(characterId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("csv", "labels", labels));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "last_mail_id", lastMailId));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "evesso" };

        GenericType<List<MailHeadersResponse>> localVarReturnType = new GenericType<List<MailHeadersResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get mail labels and unread counts Return a list of the users mail labels,
     * unread counts for each label and a total unread count. --- Alternate
     * route: &#x60;/v3/characters/{character_id}/mail/labels/&#x60; Alternate
     * route: &#x60;/dev/characters/{character_id}/mail/labels/&#x60; --- This
     * route is cached for up to 30 seconds
     * 
     * @param characterId
     *            An EVE character ID (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @return MailLabelsResponse
     * @throws ApiException
     *             if fails to make API call
     */
    public MailLabelsResponse getCharactersCharacterIdMailLabels(Integer characterId, String datasource)
            throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'characterId' is set
        if (characterId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'characterId' when calling getCharactersCharacterIdMailLabels");
        }

        // create path and map variables
        String localVarPath = "/characters/{character_id}/mail/labels/".replaceAll("\\{format\\}", "json").replaceAll(
                "\\{" + "character_id" + "\\}", apiClient.escapeString(characterId.toString()));

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

        GenericType<MailLabelsResponse> localVarReturnType = new GenericType<MailLabelsResponse>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Return mailing list subscriptions Return all mailing lists that the
     * character is subscribed to --- Alternate route:
     * &#x60;/v1/characters/{character_id}/mail/lists/&#x60; Alternate route:
     * &#x60;/legacy/characters/{character_id}/mail/lists/&#x60; Alternate
     * route: &#x60;/dev/characters/{character_id}/mail/lists/&#x60; --- This
     * route is cached for up to 120 seconds
     * 
     * @param characterId
     *            An EVE character ID (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @return List<CharacterMailinglistsResponse>
     * @throws ApiException
     *             if fails to make API call
     */
    public List<CharacterMailinglistsResponse> getCharactersCharacterIdMailLists(Integer characterId, String datasource)
            throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'characterId' is set
        if (characterId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'characterId' when calling getCharactersCharacterIdMailLists");
        }

        // create path and map variables
        String localVarPath = "/characters/{character_id}/mail/lists/".replaceAll("\\{format\\}", "json").replaceAll(
                "\\{" + "character_id" + "\\}", apiClient.escapeString(characterId.toString()));

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

        GenericType<List<CharacterMailinglistsResponse>> localVarReturnType = new GenericType<List<CharacterMailinglistsResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Return a mail Return the contents of an EVE mail --- Alternate route:
     * &#x60;/v1/characters/{character_id}/mail/{mail_id}/&#x60; Alternate
     * route: &#x60;/legacy/characters/{character_id}/mail/{mail_id}/&#x60;
     * Alternate route:
     * &#x60;/dev/characters/{character_id}/mail/{mail_id}/&#x60; --- This route
     * is cached for up to 30 seconds
     * 
     * @param characterId
     *            An EVE character ID (required)
     * @param mailId
     *            An EVE mail ID (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @return MailResponse
     * @throws ApiException
     *             if fails to make API call
     */
    public MailResponse getCharactersCharacterIdMailMailId(Integer characterId, Integer mailId, String datasource)
            throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'characterId' is set
        if (characterId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'characterId' when calling getCharactersCharacterIdMailMailId");
        }

        // verify the required parameter 'mailId' is set
        if (mailId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'mailId' when calling getCharactersCharacterIdMailMailId");
        }

        // create path and map variables
        String localVarPath = "/characters/{character_id}/mail/{mail_id}/".replaceAll("\\{format\\}", "json")
                .replaceAll("\\{" + "character_id" + "\\}", apiClient.escapeString(characterId.toString()))
                .replaceAll("\\{" + "mail_id" + "\\}", apiClient.escapeString(mailId.toString()));

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

        GenericType<MailResponse> localVarReturnType = new GenericType<MailResponse>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Send a new mail Create and send a new mail --- Alternate route:
     * &#x60;/v1/characters/{character_id}/mail/&#x60; Alternate route:
     * &#x60;/legacy/characters/{character_id}/mail/&#x60; Alternate route:
     * &#x60;/dev/characters/{character_id}/mail/&#x60;
     * 
     * @param characterId
     *            The sender&#39;s character ID (required)
     * @param mail
     *            The mail to send (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @return Integer
     * @throws ApiException
     *             if fails to make API call
     */
    public Integer postCharactersCharacterIdMail(Integer characterId, Mail mail, String datasource) throws ApiException {
        Object localVarPostBody = mail;

        // verify the required parameter 'characterId' is set
        if (characterId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'characterId' when calling postCharactersCharacterIdMail");
        }

        // verify the required parameter 'mail' is set
        if (mail == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'mail' when calling postCharactersCharacterIdMail");
        }

        // create path and map variables
        String localVarPath = "/characters/{character_id}/mail/".replaceAll("\\{format\\}", "json").replaceAll(
                "\\{" + "character_id" + "\\}", apiClient.escapeString(characterId.toString()));

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

        GenericType<Integer> localVarReturnType = new GenericType<Integer>() {
        };
        return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Create a mail label Create a mail label --- Alternate route:
     * &#x60;/v2/characters/{character_id}/mail/labels/&#x60; Alternate route:
     * &#x60;/legacy/characters/{character_id}/mail/labels/&#x60; Alternate
     * route: &#x60;/dev/characters/{character_id}/mail/labels/&#x60;
     * 
     * @param characterId
     *            An EVE character ID (required)
     * @param label
     *            Label to create (optional)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @return Long
     * @throws ApiException
     *             if fails to make API call
     */
    public Long postCharactersCharacterIdMailLabels(Integer characterId, MailLabel label, String datasource)
            throws ApiException {
        Object localVarPostBody = label;

        // verify the required parameter 'characterId' is set
        if (characterId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'characterId' when calling postCharactersCharacterIdMailLabels");
        }

        // create path and map variables
        String localVarPath = "/characters/{character_id}/mail/labels/".replaceAll("\\{format\\}", "json").replaceAll(
                "\\{" + "character_id" + "\\}", apiClient.escapeString(characterId.toString()));

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

        GenericType<Long> localVarReturnType = new GenericType<Long>() {
        };
        return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Update metadata about a mail Update metadata about a mail --- Alternate
     * route: &#x60;/v1/characters/{character_id}/mail/{mail_id}/&#x60;
     * Alternate route:
     * &#x60;/legacy/characters/{character_id}/mail/{mail_id}/&#x60; Alternate
     * route: &#x60;/dev/characters/{character_id}/mail/{mail_id}/&#x60;
     * 
     * @param characterId
     *            An EVE character ID (required)
     * @param mailId
     *            An EVE mail ID (required)
     * @param contents
     *            Data used to update the mail (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @throws ApiException
     *             if fails to make API call
     */
    public void putCharactersCharacterIdMailMailId(Integer characterId, Integer mailId, MailMetaData contents,
            String datasource) throws ApiException {
        Object localVarPostBody = contents;

        // verify the required parameter 'characterId' is set
        if (characterId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'characterId' when calling putCharactersCharacterIdMailMailId");
        }

        // verify the required parameter 'mailId' is set
        if (mailId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'mailId' when calling putCharactersCharacterIdMailMailId");
        }

        // verify the required parameter 'contents' is set
        if (contents == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'contents' when calling putCharactersCharacterIdMailMailId");
        }

        // create path and map variables
        String localVarPath = "/characters/{character_id}/mail/{mail_id}/".replaceAll("\\{format\\}", "json")
                .replaceAll("\\{" + "character_id" + "\\}", apiClient.escapeString(characterId.toString()))
                .replaceAll("\\{" + "mail_id" + "\\}", apiClient.escapeString(mailId.toString()));

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
