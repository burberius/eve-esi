package net.troja.eve.esi.api;

import net.troja.eve.esi.ApiException;
import net.troja.eve.esi.ApiClient;
import net.troja.eve.esi.Configuration;
import net.troja.eve.esi.Pair;

import javax.ws.rs.core.GenericType;

import net.troja.eve.esi.model.GetCharactersCharacterIdPlanets200Ok;
import net.troja.eve.esi.model.GetCharactersCharacterIdPlanetsPlanetIdOk;
import net.troja.eve.esi.model.GetUniverseSchematicsSchematicIdOk;

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
     * character. --- Alternate route:
     * &#x60;/v1/characters/{character_id}/planets/&#x60; Alternate route:
     * &#x60;/legacy/characters/{character_id}/planets/&#x60; Alternate route:
     * &#x60;/dev/characters/{character_id}/planets/&#x60; --- This route is
     * cached for up to 600 seconds
     * 
     * @param characterId
     *            Character id of the target character (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @return List<GetCharactersCharacterIdPlanets200Ok>
     * @throws ApiException
     *             if fails to make API call
     */
    public List<GetCharactersCharacterIdPlanets200Ok> getCharactersCharacterIdPlanets(Integer characterId,
            String datasource) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'characterId' is set
        if (characterId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'characterId' when calling getCharactersCharacterIdPlanets");
        }

        // create path and map variables
        String localVarPath = "/characters/{character_id}/planets/".replaceAll("\\{format\\}", "json").replaceAll(
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

        GenericType<List<GetCharactersCharacterIdPlanets200Ok>> localVarReturnType = new GenericType<List<GetCharactersCharacterIdPlanets200Ok>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get colony layout Returns full details on the layout of a single
     * planetary colony, including links, pins and routes. Note: Planetary
     * information is only recalculated when the colony is viewed through the
     * client. Information on this endpoint will not update until this criteria
     * is met. --- Alternate route:
     * &#x60;/v1/characters/{character_id}/planets/{planet_id}/&#x60; Alternate
     * route: &#x60;/legacy/characters/{character_id}/planets/{planet_id}/&#x60;
     * Alternate route:
     * &#x60;/dev/characters/{character_id}/planets/{planet_id}/&#x60; --- This
     * route is cached for up to 600 seconds
     * 
     * @param characterId
     *            Character id of the target character (required)
     * @param planetId
     *            Planet id of the target planet (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @return GetCharactersCharacterIdPlanetsPlanetIdOk
     * @throws ApiException
     *             if fails to make API call
     */
    public GetCharactersCharacterIdPlanetsPlanetIdOk getCharactersCharacterIdPlanetsPlanetId(Integer characterId,
            Integer planetId, String datasource) throws ApiException {
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
        String localVarPath = "/characters/{character_id}/planets/{planet_id}/".replaceAll("\\{format\\}", "json")
                .replaceAll("\\{" + "character_id" + "\\}", apiClient.escapeString(characterId.toString()))
                .replaceAll("\\{" + "planet_id" + "\\}", apiClient.escapeString(planetId.toString()));

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

        GenericType<GetCharactersCharacterIdPlanetsPlanetIdOk> localVarReturnType = new GenericType<GetCharactersCharacterIdPlanetsPlanetIdOk>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get schematic information Get information on a planetary factory
     * schematic --- Alternate route:
     * &#x60;/v1/universe/schematics/{schematic_id}/&#x60; Alternate route:
     * &#x60;/legacy/universe/schematics/{schematic_id}/&#x60; Alternate route:
     * &#x60;/dev/universe/schematics/{schematic_id}/&#x60; --- This route is
     * cached for up to 3600 seconds
     * 
     * @param schematicId
     *            A PI schematic ID (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @return GetUniverseSchematicsSchematicIdOk
     * @throws ApiException
     *             if fails to make API call
     */
    public GetUniverseSchematicsSchematicIdOk getUniverseSchematicsSchematicId(Integer schematicId, String datasource)
            throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'schematicId' is set
        if (schematicId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'schematicId' when calling getUniverseSchematicsSchematicId");
        }

        // create path and map variables
        String localVarPath = "/universe/schematics/{schematic_id}/".replaceAll("\\{format\\}", "json").replaceAll(
                "\\{" + "schematic_id" + "\\}", apiClient.escapeString(schematicId.toString()));

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

        String[] localVarAuthNames = new String[] {};

        GenericType<GetUniverseSchematicsSchematicIdOk> localVarReturnType = new GenericType<GetUniverseSchematicsSchematicIdOk>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }
}
