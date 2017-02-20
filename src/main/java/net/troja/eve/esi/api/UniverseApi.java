package net.troja.eve.esi.api;

import net.troja.eve.esi.ApiException;
import net.troja.eve.esi.ApiClient;
import net.troja.eve.esi.Configuration;
import net.troja.eve.esi.Pair;

import javax.ws.rs.core.GenericType;

import net.troja.eve.esi.model.BloodlinesResponse;
import net.troja.eve.esi.model.CategoryResponse;
import net.troja.eve.esi.model.ConstellationResponse;
import net.troja.eve.esi.model.FactionsResponse;
import net.troja.eve.esi.model.GroupResponse;
import net.troja.eve.esi.model.MoonResponse;
import net.troja.eve.esi.model.PlanetResponse;
import net.troja.eve.esi.model.RacesResponse;
import net.troja.eve.esi.model.RegionResponse;
import net.troja.eve.esi.model.StargateResponse;
import net.troja.eve.esi.model.StationResponse;
import net.troja.eve.esi.model.StructureResponse;
import net.troja.eve.esi.model.SystemResponse;
import net.troja.eve.esi.model.TypeResponse;
import net.troja.eve.esi.model.UniverseNamesResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniverseApi {
    private ApiClient apiClient;

    public UniverseApi() {
        this(Configuration.getDefaultApiClient());
    }

    public UniverseApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Get bloodlines Get a list of bloodlines --- Alternate route:
     * &#x60;/v1/universe/bloodlines/&#x60; Alternate route:
     * &#x60;/legacy/universe/bloodlines/&#x60; Alternate route:
     * &#x60;/dev/universe/bloodlines/&#x60; --- This route is cached for up to
     * 3600 seconds
     * 
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param language
     *            Language to use in the response (optional, default to en-us)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return List<BloodlinesResponse>
     * @throws ApiException
     *             if fails to make API call
     */
    public List<BloodlinesResponse> getUniverseBloodlines(String datasource, String language, String userAgent,
            String xUserAgent) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/v1/universe/bloodlines/".replaceAll("\\{format\\}", "json");

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "language", language));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "user_agent", userAgent));

        if (xUserAgent != null)
            localVarHeaderParams.put("X-User-Agent", apiClient.parameterToString(xUserAgent));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {};

        GenericType<List<BloodlinesResponse>> localVarReturnType = new GenericType<List<BloodlinesResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get item categories Get a list of item categories --- Alternate route:
     * &#x60;/v1/universe/categories/&#x60; Alternate route:
     * &#x60;/legacy/universe/categories/&#x60; Alternate route:
     * &#x60;/dev/universe/categories/&#x60; --- This route is cached for up to
     * 3600 seconds
     * 
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return List<Integer>
     * @throws ApiException
     *             if fails to make API call
     */
    public List<Integer> getUniverseCategories(String datasource, String userAgent, String xUserAgent)
            throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/v1/universe/categories/".replaceAll("\\{format\\}", "json");

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "user_agent", userAgent));

        if (xUserAgent != null)
            localVarHeaderParams.put("X-User-Agent", apiClient.parameterToString(xUserAgent));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {};

        GenericType<List<Integer>> localVarReturnType = new GenericType<List<Integer>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get item category information Get information of an item category ---
     * Alternate route: &#x60;/v1/universe/categories/{category_id}/&#x60;
     * Alternate route: &#x60;/legacy/universe/categories/{category_id}/&#x60;
     * Alternate route: &#x60;/dev/universe/categories/{category_id}/&#x60; ---
     * This route is cached for up to 3600 seconds
     * 
     * @param categoryId
     *            An Eve item category ID (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param language
     *            Language to use in the response (optional, default to en-us)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return CategoryResponse
     * @throws ApiException
     *             if fails to make API call
     */
    public CategoryResponse getUniverseCategoriesCategoryId(Integer categoryId, String datasource, String language,
            String userAgent, String xUserAgent) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'categoryId' is set
        if (categoryId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'categoryId' when calling getUniverseCategoriesCategoryId");
        }

        // create path and map variables
        String localVarPath = "/v1/universe/categories/{category_id}/".replaceAll("\\{format\\}", "json").replaceAll(
                "\\{" + "category_id" + "\\}", apiClient.escapeString(categoryId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "language", language));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "user_agent", userAgent));

        if (xUserAgent != null)
            localVarHeaderParams.put("X-User-Agent", apiClient.parameterToString(xUserAgent));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {};

        GenericType<CategoryResponse> localVarReturnType = new GenericType<CategoryResponse>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get constellations Get a list of constellations --- Alternate route:
     * &#x60;/v1/universe/constellations/&#x60; Alternate route:
     * &#x60;/legacy/universe/constellations/&#x60; Alternate route:
     * &#x60;/dev/universe/constellations/&#x60; --- This route is cached for up
     * to 3600 seconds
     * 
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return List<Integer>
     * @throws ApiException
     *             if fails to make API call
     */
    public List<Integer> getUniverseConstellations(String datasource, String userAgent, String xUserAgent)
            throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/v1/universe/constellations/".replaceAll("\\{format\\}", "json");

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "user_agent", userAgent));

        if (xUserAgent != null)
            localVarHeaderParams.put("X-User-Agent", apiClient.parameterToString(xUserAgent));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {};

        GenericType<List<Integer>> localVarReturnType = new GenericType<List<Integer>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get constellation information Get information on a constellation ---
     * Alternate route:
     * &#x60;/v1/universe/constellations/{constellation_id}/&#x60; Alternate
     * route: &#x60;/legacy/universe/constellations/{constellation_id}/&#x60;
     * Alternate route:
     * &#x60;/dev/universe/constellations/{constellation_id}/&#x60; --- This
     * route is cached for up to 3600 seconds
     * 
     * @param constellationId
     *            constellation_id integer (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param language
     *            Language to use in the response (optional, default to en-us)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return ConstellationResponse
     * @throws ApiException
     *             if fails to make API call
     */
    public ConstellationResponse getUniverseConstellationsConstellationId(Integer constellationId, String datasource,
            String language, String userAgent, String xUserAgent) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'constellationId' is set
        if (constellationId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'constellationId' when calling getUniverseConstellationsConstellationId");
        }

        // create path and map variables
        String localVarPath = "/v1/universe/constellations/{constellation_id}/".replaceAll("\\{format\\}", "json")
                .replaceAll("\\{" + "constellation_id" + "\\}", apiClient.escapeString(constellationId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "language", language));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "user_agent", userAgent));

        if (xUserAgent != null)
            localVarHeaderParams.put("X-User-Agent", apiClient.parameterToString(xUserAgent));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {};

        GenericType<ConstellationResponse> localVarReturnType = new GenericType<ConstellationResponse>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get factions Get a list of factions --- Alternate route:
     * &#x60;/v1/universe/factions/&#x60; Alternate route:
     * &#x60;/legacy/universe/factions/&#x60; Alternate route:
     * &#x60;/dev/universe/factions/&#x60; --- This route is cached for up to
     * 3600 seconds
     * 
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param language
     *            Language to use in the response (optional, default to en-us)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return List<FactionsResponse>
     * @throws ApiException
     *             if fails to make API call
     */
    public List<FactionsResponse> getUniverseFactions(String datasource, String language, String userAgent,
            String xUserAgent) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/v1/universe/factions/".replaceAll("\\{format\\}", "json");

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "language", language));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "user_agent", userAgent));

        if (xUserAgent != null)
            localVarHeaderParams.put("X-User-Agent", apiClient.parameterToString(xUserAgent));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {};

        GenericType<List<FactionsResponse>> localVarReturnType = new GenericType<List<FactionsResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get item groups Get a list of item groups --- Alternate route:
     * &#x60;/v1/universe/groups/&#x60; Alternate route:
     * &#x60;/legacy/universe/groups/&#x60; Alternate route:
     * &#x60;/dev/universe/groups/&#x60; --- This route is cached for up to 3600
     * seconds
     * 
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param page
     *            Which page to query (optional)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return List<Integer>
     * @throws ApiException
     *             if fails to make API call
     */
    public List<Integer> getUniverseGroups(String datasource, Integer page, String userAgent, String xUserAgent)
            throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/v1/universe/groups/".replaceAll("\\{format\\}", "json");

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "page", page));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "user_agent", userAgent));

        if (xUserAgent != null)
            localVarHeaderParams.put("X-User-Agent", apiClient.parameterToString(xUserAgent));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {};

        GenericType<List<Integer>> localVarReturnType = new GenericType<List<Integer>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get item group information Get information on an item group --- Alternate
     * route: &#x60;/v1/universe/groups/{group_id}/&#x60; Alternate route:
     * &#x60;/legacy/universe/groups/{group_id}/&#x60; Alternate route:
     * &#x60;/dev/universe/groups/{group_id}/&#x60; --- This route is cached for
     * up to 3600 seconds
     * 
     * @param groupId
     *            An Eve item group ID (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param language
     *            Language to use in the response (optional, default to en-us)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return GroupResponse
     * @throws ApiException
     *             if fails to make API call
     */
    public GroupResponse getUniverseGroupsGroupId(Integer groupId, String datasource, String language,
            String userAgent, String xUserAgent) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'groupId' when calling getUniverseGroupsGroupId");
        }

        // create path and map variables
        String localVarPath = "/v1/universe/groups/{group_id}/".replaceAll("\\{format\\}", "json").replaceAll(
                "\\{" + "group_id" + "\\}", apiClient.escapeString(groupId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "language", language));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "user_agent", userAgent));

        if (xUserAgent != null)
            localVarHeaderParams.put("X-User-Agent", apiClient.parameterToString(xUserAgent));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {};

        GenericType<GroupResponse> localVarReturnType = new GenericType<GroupResponse>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get moon information Get information on a moon --- Alternate route:
     * &#x60;/v1/universe/moons/{moon_id}/&#x60; Alternate route:
     * &#x60;/legacy/universe/moons/{moon_id}/&#x60; Alternate route:
     * &#x60;/dev/universe/moons/{moon_id}/&#x60; --- This route is cached for
     * up to 3600 seconds
     * 
     * @param moonId
     *            moon_id integer (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return MoonResponse
     * @throws ApiException
     *             if fails to make API call
     */
    public MoonResponse getUniverseMoonsMoonId(Integer moonId, String datasource, String userAgent, String xUserAgent)
            throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'moonId' is set
        if (moonId == null) {
            throw new ApiException(400, "Missing the required parameter 'moonId' when calling getUniverseMoonsMoonId");
        }

        // create path and map variables
        String localVarPath = "/v1/universe/moons/{moon_id}/".replaceAll("\\{format\\}", "json").replaceAll(
                "\\{" + "moon_id" + "\\}", apiClient.escapeString(moonId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "user_agent", userAgent));

        if (xUserAgent != null)
            localVarHeaderParams.put("X-User-Agent", apiClient.parameterToString(xUserAgent));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {};

        GenericType<MoonResponse> localVarReturnType = new GenericType<MoonResponse>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get planet information Get information on a planet --- Alternate route:
     * &#x60;/v1/universe/planets/{planet_id}/&#x60; Alternate route:
     * &#x60;/legacy/universe/planets/{planet_id}/&#x60; Alternate route:
     * &#x60;/dev/universe/planets/{planet_id}/&#x60; --- This route is cached
     * for up to 3600 seconds
     * 
     * @param planetId
     *            planet_id integer (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return PlanetResponse
     * @throws ApiException
     *             if fails to make API call
     */
    public PlanetResponse getUniversePlanetsPlanetId(Integer planetId, String datasource, String userAgent,
            String xUserAgent) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'planetId' is set
        if (planetId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'planetId' when calling getUniversePlanetsPlanetId");
        }

        // create path and map variables
        String localVarPath = "/v1/universe/planets/{planet_id}/".replaceAll("\\{format\\}", "json").replaceAll(
                "\\{" + "planet_id" + "\\}", apiClient.escapeString(planetId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "user_agent", userAgent));

        if (xUserAgent != null)
            localVarHeaderParams.put("X-User-Agent", apiClient.parameterToString(xUserAgent));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {};

        GenericType<PlanetResponse> localVarReturnType = new GenericType<PlanetResponse>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get character races Get a list of character races --- Alternate route:
     * &#x60;/v1/universe/races/&#x60; Alternate route:
     * &#x60;/legacy/universe/races/&#x60; Alternate route:
     * &#x60;/dev/universe/races/&#x60; --- This route is cached for up to 3600
     * seconds
     * 
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param language
     *            Language to use in the response (optional, default to en-us)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return List<RacesResponse>
     * @throws ApiException
     *             if fails to make API call
     */
    public List<RacesResponse> getUniverseRaces(String datasource, String language, String userAgent, String xUserAgent)
            throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/v1/universe/races/".replaceAll("\\{format\\}", "json");

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "language", language));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "user_agent", userAgent));

        if (xUserAgent != null)
            localVarHeaderParams.put("X-User-Agent", apiClient.parameterToString(xUserAgent));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {};

        GenericType<List<RacesResponse>> localVarReturnType = new GenericType<List<RacesResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get regions Get a list of regions --- Alternate route:
     * &#x60;/v1/universe/regions/&#x60; Alternate route:
     * &#x60;/legacy/universe/regions/&#x60; Alternate route:
     * &#x60;/dev/universe/regions/&#x60; --- This route is cached for up to
     * 3600 seconds
     * 
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return List<Integer>
     * @throws ApiException
     *             if fails to make API call
     */
    public List<Integer> getUniverseRegions(String datasource, String userAgent, String xUserAgent) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/v1/universe/regions/".replaceAll("\\{format\\}", "json");

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "user_agent", userAgent));

        if (xUserAgent != null)
            localVarHeaderParams.put("X-User-Agent", apiClient.parameterToString(xUserAgent));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {};

        GenericType<List<Integer>> localVarReturnType = new GenericType<List<Integer>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get region information Get information on a region --- Alternate route:
     * &#x60;/v1/universe/regions/{region_id}/&#x60; Alternate route:
     * &#x60;/legacy/universe/regions/{region_id}/&#x60; Alternate route:
     * &#x60;/dev/universe/regions/{region_id}/&#x60; --- This route is cached
     * for up to 3600 seconds
     * 
     * @param regionId
     *            region_id integer (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param language
     *            Language to use in the response (optional, default to en-us)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return RegionResponse
     * @throws ApiException
     *             if fails to make API call
     */
    public RegionResponse getUniverseRegionsRegionId(Integer regionId, String datasource, String language,
            String userAgent, String xUserAgent) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'regionId' is set
        if (regionId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'regionId' when calling getUniverseRegionsRegionId");
        }

        // create path and map variables
        String localVarPath = "/v1/universe/regions/{region_id}/".replaceAll("\\{format\\}", "json").replaceAll(
                "\\{" + "region_id" + "\\}", apiClient.escapeString(regionId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "language", language));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "user_agent", userAgent));

        if (xUserAgent != null)
            localVarHeaderParams.put("X-User-Agent", apiClient.parameterToString(xUserAgent));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {};

        GenericType<RegionResponse> localVarReturnType = new GenericType<RegionResponse>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get stargate information Get information on a stargate --- Alternate
     * route: &#x60;/v1/universe/stargates/{stargate_id}/&#x60; Alternate route:
     * &#x60;/legacy/universe/stargates/{stargate_id}/&#x60; Alternate route:
     * &#x60;/dev/universe/stargates/{stargate_id}/&#x60; --- This route is
     * cached for up to 3600 seconds
     * 
     * @param stargateId
     *            stargate_id integer (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return StargateResponse
     * @throws ApiException
     *             if fails to make API call
     */
    public StargateResponse getUniverseStargatesStargateId(Integer stargateId, String datasource, String userAgent,
            String xUserAgent) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'stargateId' is set
        if (stargateId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'stargateId' when calling getUniverseStargatesStargateId");
        }

        // create path and map variables
        String localVarPath = "/v1/universe/stargates/{stargate_id}/".replaceAll("\\{format\\}", "json").replaceAll(
                "\\{" + "stargate_id" + "\\}", apiClient.escapeString(stargateId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "user_agent", userAgent));

        if (xUserAgent != null)
            localVarHeaderParams.put("X-User-Agent", apiClient.parameterToString(xUserAgent));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {};

        GenericType<StargateResponse> localVarReturnType = new GenericType<StargateResponse>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get station information Get information on a station --- Alternate route:
     * &#x60;/v2/universe/stations/{station_id}/&#x60; Alternate route:
     * &#x60;/dev/universe/stations/{station_id}/&#x60; --- This route is cached
     * for up to 300 seconds
     * 
     * @param stationId
     *            station_id integer (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return StationResponse
     * @throws ApiException
     *             if fails to make API call
     */
    public StationResponse getUniverseStationsStationId(Integer stationId, String datasource, String userAgent,
            String xUserAgent) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'stationId' is set
        if (stationId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'stationId' when calling getUniverseStationsStationId");
        }

        // create path and map variables
        String localVarPath = "/v2/universe/stations/{station_id}/".replaceAll("\\{format\\}", "json").replaceAll(
                "\\{" + "station_id" + "\\}", apiClient.escapeString(stationId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "user_agent", userAgent));

        if (xUserAgent != null)
            localVarHeaderParams.put("X-User-Agent", apiClient.parameterToString(xUserAgent));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {};

        GenericType<StationResponse> localVarReturnType = new GenericType<StationResponse>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * List all public structures List all public structures --- Alternate
     * route: &#x60;/v1/universe/structures/&#x60; Alternate route:
     * &#x60;/legacy/universe/structures/&#x60; Alternate route:
     * &#x60;/dev/universe/structures/&#x60; --- This route is cached for up to
     * 3600 seconds
     * 
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return List<Long>
     * @throws ApiException
     *             if fails to make API call
     */
    public List<Long> getUniverseStructures(String datasource, String userAgent, String xUserAgent) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/v1/universe/structures/".replaceAll("\\{format\\}", "json");

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "user_agent", userAgent));

        if (xUserAgent != null)
            localVarHeaderParams.put("X-User-Agent", apiClient.parameterToString(xUserAgent));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {};

        GenericType<List<Long>> localVarReturnType = new GenericType<List<Long>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get structure information Returns information on requested structure, if
     * you are on the ACL. Otherwise, returns \&quot;Forbidden\&quot; for all
     * inputs. --- Alternate route:
     * &#x60;/v1/universe/structures/{structure_id}/&#x60; Alternate route:
     * &#x60;/legacy/universe/structures/{structure_id}/&#x60; Alternate route:
     * &#x60;/dev/universe/structures/{structure_id}/&#x60;
     * 
     * @param structureId
     *            An Eve structure ID (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param token
     *            Access token to use, if preferred over a header (optional)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return StructureResponse
     * @throws ApiException
     *             if fails to make API call
     */
    public StructureResponse getUniverseStructuresStructureId(Long structureId, String datasource, String token,
            String userAgent, String xUserAgent) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'structureId' is set
        if (structureId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'structureId' when calling getUniverseStructuresStructureId");
        }

        // create path and map variables
        String localVarPath = "/v1/universe/structures/{structure_id}/".replaceAll("\\{format\\}", "json").replaceAll(
                "\\{" + "structure_id" + "\\}", apiClient.escapeString(structureId.toString()));

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

        GenericType<StructureResponse> localVarReturnType = new GenericType<StructureResponse>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get solar systems Get a list of solar systems --- Alternate route:
     * &#x60;/v1/universe/systems/&#x60; Alternate route:
     * &#x60;/legacy/universe/systems/&#x60; Alternate route:
     * &#x60;/dev/universe/systems/&#x60; --- This route is cached for up to
     * 3600 seconds
     * 
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return List<Integer>
     * @throws ApiException
     *             if fails to make API call
     */
    public List<Integer> getUniverseSystems(String datasource, String userAgent, String xUserAgent) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/v1/universe/systems/".replaceAll("\\{format\\}", "json");

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "user_agent", userAgent));

        if (xUserAgent != null)
            localVarHeaderParams.put("X-User-Agent", apiClient.parameterToString(xUserAgent));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {};

        GenericType<List<Integer>> localVarReturnType = new GenericType<List<Integer>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get solar system information Get information on a solar system ---
     * Alternate route: &#x60;/v2/universe/systems/{system_id}/&#x60; Alternate
     * route: &#x60;/dev/universe/systems/{system_id}/&#x60; --- This route is
     * cached for up to 3600 seconds
     * 
     * @param systemId
     *            system_id integer (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param language
     *            Language to use in the response (optional, default to en-us)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return SystemResponse
     * @throws ApiException
     *             if fails to make API call
     */
    public SystemResponse getUniverseSystemsSystemId(Integer systemId, String datasource, String language,
            String userAgent, String xUserAgent) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'systemId' is set
        if (systemId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'systemId' when calling getUniverseSystemsSystemId");
        }

        // create path and map variables
        String localVarPath = "/v2/universe/systems/{system_id}/".replaceAll("\\{format\\}", "json").replaceAll(
                "\\{" + "system_id" + "\\}", apiClient.escapeString(systemId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "language", language));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "user_agent", userAgent));

        if (xUserAgent != null)
            localVarHeaderParams.put("X-User-Agent", apiClient.parameterToString(xUserAgent));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {};

        GenericType<SystemResponse> localVarReturnType = new GenericType<SystemResponse>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get types Get a list of type ids --- Alternate route:
     * &#x60;/v1/universe/types/&#x60; Alternate route:
     * &#x60;/legacy/universe/types/&#x60; Alternate route:
     * &#x60;/dev/universe/types/&#x60; --- This route is cached for up to 3600
     * seconds
     * 
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param page
     *            Which page to query (optional)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return List<Integer>
     * @throws ApiException
     *             if fails to make API call
     */
    public List<Integer> getUniverseTypes(String datasource, Integer page, String userAgent, String xUserAgent)
            throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/v1/universe/types/".replaceAll("\\{format\\}", "json");

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "page", page));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "user_agent", userAgent));

        if (xUserAgent != null)
            localVarHeaderParams.put("X-User-Agent", apiClient.parameterToString(xUserAgent));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {};

        GenericType<List<Integer>> localVarReturnType = new GenericType<List<Integer>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get type information Get information on a type --- Alternate route:
     * &#x60;/v2/universe/types/{type_id}/&#x60; Alternate route:
     * &#x60;/dev/universe/types/{type_id}/&#x60; --- This route is cached for
     * up to 3600 seconds
     * 
     * @param typeId
     *            An Eve item type ID (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param language
     *            Language to use in the response (optional, default to en-us)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return TypeResponse
     * @throws ApiException
     *             if fails to make API call
     */
    public TypeResponse getUniverseTypesTypeId(Integer typeId, String datasource, String language, String userAgent,
            String xUserAgent) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'typeId' is set
        if (typeId == null) {
            throw new ApiException(400, "Missing the required parameter 'typeId' when calling getUniverseTypesTypeId");
        }

        // create path and map variables
        String localVarPath = "/v2/universe/types/{type_id}/".replaceAll("\\{format\\}", "json").replaceAll(
                "\\{" + "type_id" + "\\}", apiClient.escapeString(typeId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "language", language));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "user_agent", userAgent));

        if (xUserAgent != null)
            localVarHeaderParams.put("X-User-Agent", apiClient.parameterToString(xUserAgent));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {};

        GenericType<TypeResponse> localVarReturnType = new GenericType<TypeResponse>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get names and categories for a set of ID&#39;s Resolve a set of IDs to
     * names and categories. Supported ID&#39;s for resolving are: Characters,
     * Corporations, Alliances, Stations, Solar Systems, Constellations,
     * Regions, Types. --- Alternate route: &#x60;/v2/universe/names/&#x60;
     * Alternate route: &#x60;/dev/universe/names/&#x60;
     * 
     * @param ids
     *            The ids to resolve (required)
     * @param datasource
     *            The server name you would like data from (optional, default to
     *            tranquility)
     * @param userAgent
     *            Client identifier, takes precedence over headers (optional)
     * @param xUserAgent
     *            Client identifier, takes precedence over User-Agent (optional)
     * @return List<UniverseNamesResponse>
     * @throws ApiException
     *             if fails to make API call
     */
    public List<UniverseNamesResponse> postUniverseNames(List<Integer> ids, String datasource, String userAgent,
            String xUserAgent) throws ApiException {
        Object localVarPostBody = ids;

        // verify the required parameter 'ids' is set
        if (ids == null) {
            throw new ApiException(400, "Missing the required parameter 'ids' when calling postUniverseNames");
        }

        // create path and map variables
        String localVarPath = "/v2/universe/names/".replaceAll("\\{format\\}", "json");

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "datasource", datasource));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "user_agent", userAgent));

        if (xUserAgent != null)
            localVarHeaderParams.put("X-User-Agent", apiClient.parameterToString(xUserAgent));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {};

        GenericType<List<UniverseNamesResponse>> localVarReturnType = new GenericType<List<UniverseNamesResponse>>() {
        };
        return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }
}
