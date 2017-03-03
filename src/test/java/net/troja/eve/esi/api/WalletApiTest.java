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
import net.troja.eve.esi.model.CharacterWalletsResponse;

/**
 * API tests for WalletApi
 */
public class WalletApiTest extends GeneralApiTest {

    private final WalletApi api = new WalletApi();

    @Before
    public void setUp() {
        api.setApiClient(apiClient);
    }

    /**
     * List wallets and balances
     *
     * List your wallets and their balances. Characters typically have only one
     * wallet, with wallet_id 1000 being the master wallet. --- Alternate route:
     * &#x60;/v1/characters/{character_id}/wallets/&#x60; Alternate route:
     * &#x60;/legacy/characters/{character_id}/wallets/&#x60; Alternate route:
     * &#x60;/dev/characters/{character_id}/wallets/&#x60; --- This route is
     * cached for up to 120 seconds SSO Scope:
     * esi-wallet.read_character_wallet.v1
     *
     * @throws ApiException
     *             if the Api call fails
     */
    @Test
    public void getCharactersCharacterIdWalletsTest() throws ApiException {
        final String token = null;
        final String userAgent = null;
        final String xUserAgent = null;
        final List<CharacterWalletsResponse> response = api.getCharactersCharacterIdWallets(characterId, DATASOURCE,
                token, userAgent, xUserAgent);

        assertThat(response.size(), greaterThan(0));
        final CharacterWalletsResponse characterWalletsResponse = response.get(0);
        assertThat(characterWalletsResponse.getBalance(), greaterThan(0l));
    }

}