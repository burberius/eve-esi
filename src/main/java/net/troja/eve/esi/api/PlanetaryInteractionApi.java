package net.troja.eve.esi.api;

import net.troja.eve.esi.ApiException;
import net.troja.eve.esi.ApiClient;
import net.troja.eve.esi.Configuration;
import net.troja.eve.esi.Pair;

import javax.ws.rs.core.GenericType;

import net.troja.eve.esi.model.CharacterPlanetResponse;
import net.troja.eve.esi.model.CharacterPlanetsResponse;
import net.troja.eve.esi.model.CorporationCustomsOfficesResponse;
import net.troja.eve.esi.model.PlanetFactorySchematicResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlanetaryInteractionApi {
    private ApiClient apiClient;

    public PlanetaryInteractionApi() {
        this(Configuration.getDefaultApiClient());
    }

    public PlanetaryInteractionApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Get colonies Returns a list of all planetary colonies owned by a
     * character. --- This route is cached for up to 600 seconds SSO Scope:
     * esi-planets.manage_planets.v1
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
     * @return List&lt;CharacterPlanetsResponse&gt;
     * @throws ApiException
     *             if fails to make API call
     */
    public List<CharacterPlanetsResponse> getCharactersCharacterIdPlanets(Integer characterId, String datasource,
            String ifNoneMatch, String token) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'characterId' is set
        if (characterId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'characterId' when calling getCharactersCharacterIdPlanets");
        }

        // create path and map variables
        String localVarPath = "/v1/characters/{character_id}/planets/".replaceAll("\\{format\\}", "json").replaceAll(
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

        GenericType<List<CharacterPlanetsResponse>> localVarReturnType = new GenericType<List<CharacterPlanetsResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get colony layout Returns full details on the layout of a single
     * planetary colony, including links, pins and routes. Note: Planetary
     * information is only recalculated when the colony is viewed through the
     * client. Information will not update until this criteria is met. --- This
     * route is cached for up to 600 seconds SSO Scope:
     * esi-planets.manage_planets.v1
     * 
     * @param characterId
     *            An EVE character ID (required)
     * @param planetId
     *            Planet id of the target planet (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param ifNoneMatch
     *            ETag from a previous request. A 304 will be returned if this
     *            matches the current ETag (optional)
     * @param token
     *            Access token to use if unable to set a header (optional)
     * @return CharacterPlanetResponse
     * @throws ApiException
     *             if fails to make API call
     */
    public CharacterPlanetResponse getCharactersCharacterIdPlanetsPlanetId(Integer characterId, Integer planetId,
            String datasource, String ifNoneMatch, String token) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'characterId' is set
        if (characterId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'characterId' when calling getCharactersCharacterIdPlanetsPlanetId");
        }

        // verify the required parameter 'planetId' is set
        if (planetId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'planetId' when calling getCharactersCharacterIdPlanetsPlanetId");
        }

        // create path and map variables
        String localVarPath = "/v3/characters/{character_id}/planets/{planet_id}/".replaceAll("\\{format\\}", "json")
                .replaceAll("\\{" + "character_id" + "\\}", apiClient.escapeString(characterId.toString()))
                .replaceAll("\\{" + "planet_id" + "\\}", apiClient.escapeString(planetId.toString()));

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

        GenericType<CharacterPlanetResponse> localVarReturnType = new GenericType<CharacterPlanetResponse>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * List corporation customs offices List customs offices owned by a
     * corporation --- This route is cached for up to 3600 seconds --- Requires
     * one of the following EVE corporation role(s): Director SSO Scope:
     * esi-planets.read_customs_offices.v1
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
     * @return List&lt;CorporationCustomsOfficesResponse&gt;
     * @throws ApiException
     *             if fails to make API call
     */
    public List<CorporationCustomsOfficesResponse> getCorporationsCorporationIdCustomsOffices(Integer corporationId,
            String datasource, String ifNoneMatch, Integer page, String token) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'corporationId' is set
        if (corporationId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'corporationId' when calling getCorporationsCorporationIdCustomsOffices");
        }

        // create path and map variables
        String localVarPath = "/v1/corporations/{corporation_id}/customs_offices/".replaceAll("\\{format\\}", "json")
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

        GenericType<List<CorporationCustomsOfficesResponse>> localVarReturnType = new GenericType<List<CorporationCustomsOfficesResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get schematic information Get information on a planetary factory
     * schematic --- This route is cached for up to 3600 seconds
     * 
     * @param schematicId
     *            A PI schematic ID (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param ifNoneMatch
     *            ETag from a previous request. A 304 will be returned if this
     *            matches the current ETag (optional)
     * @return PlanetFactorySchematicResponse
     * @throws ApiException
     *             if fails to make API call
     */
    public PlanetFactorySchematicResponse getUniverseSchematicsSchematicId(Integer schematicId, String datasource,
            String ifNoneMatch) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'schematicId' is set
        if (schematicId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'schematicId' when calling getUniverseSchematicsSchematicId");
        }

        // create path and map variables
        String localVarPath = "/v1/universe/schematics/{schematic_id}/".replaceAll("\\{format\\}", "json").replaceAll(
                "\\{" + "schematic_id" + "\\}", apiClient.escapeString(schematicId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));

        if (ifNoneMatch != null)
            localVarHeaderParams.put("If-None-Match", apiClient.parameterToString(ifNoneMatch));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = { "application/json" };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {};

        GenericType<PlanetFactorySchematicResponse> localVarReturnType = new GenericType<PlanetFactorySchematicResponse>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }
}
