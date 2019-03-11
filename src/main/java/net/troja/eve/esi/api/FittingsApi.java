package net.troja.eve.esi.api;

import net.troja.eve.esi.ApiException;
import net.troja.eve.esi.ApiClient;
import net.troja.eve.esi.Configuration;
import net.troja.eve.esi.Pair;

import javax.ws.rs.core.GenericType;

import net.troja.eve.esi.model.CharacterFitting;
import net.troja.eve.esi.model.CharacterFittingResponse;
import net.troja.eve.esi.model.CharacterFittingsResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FittingsApi {
    private ApiClient apiClient;

    public FittingsApi() {
        this(Configuration.getDefaultApiClient());
    }

    public FittingsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Delete fitting Delete a fitting from a character --- SSO Scope:
     * esi-fittings.write_fittings.v1
     * 
     * @param characterId
     *            An EVE character ID (required)
     * @param fittingId
     *            ID for a fitting of this character (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param token
     *            Access token to use if unable to set a header (optional)
     * @throws ApiException
     *             if fails to make API call
     */
    public void deleteCharactersCharacterIdFittingsFittingId(Integer characterId, Integer fittingId, String datasource,
            String token) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'characterId' is set
        if (characterId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'characterId' when calling deleteCharactersCharacterIdFittingsFittingId");
        }

        // verify the required parameter 'fittingId' is set
        if (fittingId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'fittingId' when calling deleteCharactersCharacterIdFittingsFittingId");
        }

        // create path and map variables
        String localVarPath = "/v1/characters/{character_id}/fittings/{fitting_id}/".replaceAll("\\{format\\}", "json")
                .replaceAll("\\{" + "character_id" + "\\}", apiClient.escapeString(characterId.toString()))
                .replaceAll("\\{" + "fitting_id" + "\\}", apiClient.escapeString(fittingId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

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
     * Get fittings Return fittings of a character --- This route is cached for
     * up to 300 seconds --- Warning: This route has an upgrade available ---
     * [Diff of the upcoming
     * changes](https://esi.evetech.net/diff/latest/dev/#GET
     * -/characters/{character_id}/fittings/) SSO Scope:
     * esi-fittings.read_fittings.v1
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
     * @return List&lt;CharacterFittingsResponse&gt;
     * @throws ApiException
     *             if fails to make API call
     */
    public List<CharacterFittingsResponse> getCharactersCharacterIdFittings(Integer characterId, String datasource,
            String ifNoneMatch, String token) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'characterId' is set
        if (characterId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'characterId' when calling getCharactersCharacterIdFittings");
        }

        // create path and map variables
        String localVarPath = "/v1/characters/{character_id}/fittings/".replaceAll("\\{format\\}", "json").replaceAll(
                "\\{" + "character_id" + "\\}", apiClient.escapeString(characterId.toString()));

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

        GenericType<List<CharacterFittingsResponse>> localVarReturnType = new GenericType<List<CharacterFittingsResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Create fitting Save a new fitting for a character --- Warning: This route
     * has an upgrade available --- [Diff of the upcoming
     * changes](https://esi.evetech
     * .net/diff/latest/dev/#POST-/characters/{character_id}/fittings/) SSO
     * Scope: esi-fittings.write_fittings.v1
     * 
     * @param characterId
     *            An EVE character ID (required)
     * @param fitting
     *            Details about the new fitting (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param token
     *            Access token to use if unable to set a header (optional)
     * @return CharacterFittingResponse
     * @throws ApiException
     *             if fails to make API call
     */
    public CharacterFittingResponse postCharactersCharacterIdFittings(Integer characterId, CharacterFitting fitting,
            String datasource, String token) throws ApiException {
        Object localVarPostBody = fitting;

        // verify the required parameter 'characterId' is set
        if (characterId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'characterId' when calling postCharactersCharacterIdFittings");
        }

        // verify the required parameter 'fitting' is set
        if (fitting == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'fitting' when calling postCharactersCharacterIdFittings");
        }

        // create path and map variables
        String localVarPath = "/v1/characters/{character_id}/fittings/".replaceAll("\\{format\\}", "json").replaceAll(
                "\\{" + "character_id" + "\\}", apiClient.escapeString(characterId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "token", token));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = { "application/json" };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "evesso" };

        GenericType<CharacterFittingResponse> localVarReturnType = new GenericType<CharacterFittingResponse>() {
        };
        return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }
}
