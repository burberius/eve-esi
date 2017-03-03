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

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import net.troja.eve.esi.ApiException;
import net.troja.eve.esi.model.CharacterSkillqueueResponse;
import net.troja.eve.esi.model.CharacterSkillsResponse;

/**
 * API tests for SkillsApi
 */
public class SkillsApiTest extends GeneralApiTest {

    private final SkillsApi api = new SkillsApi();

    @Before
    public void setUp() {
        api.setApiClient(apiClient);
    }

    /**
     * Get character&#39;s skill queue
     *
     * List the configured skill queue for the given character --- Alternate
     * route: &#x60;/v2/characters/{character_id}/skillqueue/&#x60; Alternate
     * route: &#x60;/legacy/characters/{character_id}/skillqueue/&#x60;
     * Alternate route: &#x60;/dev/characters/{character_id}/skillqueue/&#x60;
     * --- This route is cached for up to 120 seconds SSO Scope:
     * esi-skills.read_skillqueue.v1
     *
     * @throws ApiException
     *             if the Api call fails
     */
    @Test
    public void getCharactersCharacterIdSkillqueueTest() throws ApiException {
        final String token = null;
        final String userAgent = null;
        final String xUserAgent = null;
        final List<CharacterSkillqueueResponse> response = api.getCharactersCharacterIdSkillqueue(characterId,
                DATASOURCE, token, userAgent, xUserAgent);

        assertThat(response.size(), greaterThan(0));
        final CharacterSkillqueueResponse skillqueue = response.get(0);
        assertThat(skillqueue.getSkillId(), greaterThan(0));
    }

    /**
     * Get character skills
     *
     * List all trained skills for the given character --- Alternate route:
     * &#x60;/v3/characters/{character_id}/skills/&#x60; Alternate route:
     * &#x60;/dev/characters/{character_id}/skills/&#x60; --- This route is
     * cached for up to 120 seconds SSO Scope: esi-skills.read_skills.v1
     *
     * @throws ApiException
     *             if the Api call fails
     */
    @Test
    public void getCharactersCharacterIdSkillsTest() throws ApiException {
        final String token = null;
        final String userAgent = null;
        final String xUserAgent = null;

        final CharacterSkillsResponse response = api.getCharactersCharacterIdSkills(characterId, DATASOURCE, token,
                userAgent, xUserAgent);

        assertThat(response.getTotalSp(), greaterThan(0l));
        assertThat(response.getSkills().size(), greaterThan(0));
    }

}