/*
 * EVE Swagger Interface
 * An OpenAPI for EVE Online
 *
 *
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package net.troja.eve.esi.api;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import net.troja.eve.esi.ApiException;
import net.troja.eve.esi.model.CharacterSearchResponse;
import net.troja.eve.esi.model.SearchResponse;

/**
 * API tests for SearchApi
 */
public class SearchApiTest extends GeneralApiTest {

    private final SearchApi api = new SearchApi();

    @Before
    public void setUp() {
        api.setApiClient(apiClient);
    }

    /**
     * Search on a string
     *
     * Search for entities that match a given sub-string. --- Alternate route:
     * &#x60;/v2/characters/{character_id}/search/&#x60; --- This route is
     * cached for up to 3600 seconds SSO Scope: esi-search.search_structures.v1
     *
     * @throws ApiException
     *             if the Api call fails
     */
    @Test
    public void getCharactersCharacterIdSearchTest() throws ApiException {
        final List<String> categories = new ArrayList<>();
        categories.add("character");
        final String search = "Chribba";
        final String language = "en-us";
        final Boolean strict = true;
        final String token = null;
        final String userAgent = null;
        final String xUserAgent = null;
        final CharacterSearchResponse response = api.getCharactersCharacterIdSearch(categories, characterId, search,
                DATASOURCE, language, strict, token, userAgent, xUserAgent);

        assertThat(response.getCharacter().size(), equalTo(1));
        assertThat(response.getCharacter().get(0), equalTo(CHARACTER_ID_CHRIBBA));
    }

    /**
     * Search on a string
     *
     * Search for entities that match a given sub-string. --- Alternate route:
     * &#x60;/v1/search/&#x60; Alternate route: &#x60;/legacy/search/&#x60; ---
     * This route is cached for up to 3600 seconds
     *
     * @throws ApiException
     *             if the Api call fails
     */
    @Test
    public void getSearchTest() throws ApiException {
        final List<String> categories = new ArrayList<>();
        categories.add("solarsystem");
        final String search = "Jita";
        final String language = "en-us";
        final Boolean strict = null;
        final String userAgent = null;
        final String xUserAgent = null;
        final SearchResponse response = api.getSearch(categories, search, DATASOURCE, language, strict, userAgent,
                xUserAgent);

        assertThat(response.getSolarsystem().size(), equalTo(1));
        assertThat(response.getSolarsystem().get(0), equalTo(30000142));
    }

}