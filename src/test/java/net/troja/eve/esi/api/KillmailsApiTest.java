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

import java.util.List;
import net.troja.eve.esi.ApiException;
import net.troja.eve.esi.model.CharacterKillmailsResponse;
import net.troja.eve.esi.model.KillmailResponse;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import static org.hamcrest.Matchers.notNullValue;

/**
 * API tests for KillmailsApi
 */
public class KillmailsApiTest extends GeneralApiTest {

    private final KillmailsApi api = new KillmailsApi();

    @Before
    public void setUp() {
        api.setApiClient(apiClient);
    }

    /**
     * Get a character&#39;s recent kills and losses
     *
     * Return a list of a character&#39;s kills and losses going back 90 days  ---  This route is cached for up to 300 seconds  SSO Scope: esi-killmails.read_killmails.v1
     *
     * @throws ApiException
     *             if the Api call fails
     */
    @Test
    public void getCharactersCharacterIdKillmailsRecentTest() throws ApiException {
        final Integer page = null;
        final List<CharacterKillmailsResponse> response = api.getCharactersCharacterIdKillmailsRecent(characterId, DATASOURCE, null, page, null);

        assertThat(response, notNullValue());
    }

    /**
     * Get a corporation&#39;s recent kills and losses
     *
     * Get a list of a corporation&#39;s kills and losses going back 90 days  ---  This route is cached for up to 300 seconds  --- Requires one of the following EVE corporation role(s): Director  SSO Scope: esi-killmails.read_corporation_killmails.v1
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    @Ignore("Needs corporation with read access")
    public void getCorporationsCorporationIdKillmailsRecentTest() throws ApiException {
    }

    /**
     * Get a single killmail
     *
     * Return a single killmail from its ID and hash  ---  This route is cached for up to 1209600 seconds
     *
     * @throws ApiException
     *             if the Api call fails
     */
    @Test
    @Ignore("Needs killmails to test")
    public void getKillmailsKillmailIdKillmailHashTest() throws ApiException {
        final Integer page = null;
        final CharacterKillmailsResponse killmail = api
                .getCharactersCharacterIdKillmailsRecent(characterId, DATASOURCE, null, page, null).get(0);
        final Integer killmailId = killmail.getKillmailId();
        final String killmailHash = killmail.getKillmailHash();

        final KillmailResponse response = api.getKillmailsKillmailIdKillmailHash(killmailHash, killmailId, DATASOURCE, null);

        assertThat(response.getAttackers().size(), greaterThan(0));
        assertThat(response.getVictim().getCharacterId(), greaterThan(0));
    }
}
