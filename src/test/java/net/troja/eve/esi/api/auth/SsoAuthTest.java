package net.troja.eve.esi.api.auth;


import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

import net.troja.eve.esi.ApiClient;
import net.troja.eve.esi.ApiException;
import net.troja.eve.esi.api.AssetsApi;
import net.troja.eve.esi.api.GeneralApiTest;
import net.troja.eve.esi.api.SsoApi;
import net.troja.eve.esi.auth.JWT;
import net.troja.eve.esi.auth.OAuth;
import net.troja.eve.esi.auth.SsoScopes;
import net.troja.eve.esi.model.CharacterAssetsResponse;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeTrue;

public class SsoAuthTest extends GeneralApiTest {

    @Test
    public void threads() throws ApiException {
        final int threads = 10;
        List<Callable<Void>> runnables = new ArrayList<>();
        for (int i = 0; i < threads; i++) {
            runnables.add(new UpdateThread());
        }
        ExecutorService threadPool = Executors.newFixedThreadPool(threads);
        try {
            threadPool.invokeAll(runnables);
        } catch (InterruptedException ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void refreshToken() throws ApiException {
        final ApiClient client = new ApiClient();
        final OAuth auth = (OAuth) client.getAuthentication("evesso");
        auth.setClientId(clientId);
        auth.setRefreshToken(refreshToken);

        final Map<String, String> headerParams = new HashMap<>();
        auth.applyToParams(null, headerParams);

        assertThat(headerParams.size(), equalTo(1));
    }

    @Test
    public void expiredAccessTokenAssets() {
        final ApiClient client = new ApiClient();
        final OAuth auth = (OAuth) client.getAuthentication("evesso");
        auth.setClientId(clientId);
        auth.setRefreshToken(null);
        auth.setAccessToken("WOjpIU1jS6mkgAqXhxu5K4kuNa-b7QLN8kL-_Lizd6MSsLwRSBBB8Xgd0UNFOFaEMDKix3J4uUfgfrIkBYUDuQ2");
        AssetsApi api = new AssetsApi(client);
        try {
            api.getCharactersCharacterIdAssets(characterId, DATASOURCE, null, null, null);
            fail("Must fail with ApiException");
        } catch (ApiException ex) {
            assertThat(ex, notNullValue());
            assertThat(ex.getCode(), notNullValue());
        }
    }

    @Test
    public void singleScopeJWT() {
        assumeTrue(refreshTokenPublicData != null);
        final ApiClient client = new ApiClient();
        final OAuth auth = (OAuth) client.getAuthentication("evesso");
        auth.setClientId(clientId);
        auth.setRefreshToken(refreshTokenPublicData); //Public Scope
        JWT jwt = auth.getJWT();
        assertThat(jwt, notNullValue());
        JWT.Header header = jwt.getHeader();
        assertThat(header, notNullValue());
        assertThat(header.getAlg(), notNullValue());
        assertThat(header.getTyp(), notNullValue());
        JWT.Payload payload = jwt.getPayload();
        assertThat(payload, notNullValue());
        assertThat(payload.getAzp(), notNullValue());
        assertThat(payload.getExp(), notNullValue());
        assertThat(payload.getIss(), notNullValue());
        assertThat(payload.getJti(), notNullValue());
        assertThat(payload.getKid(), notNullValue());
        assertThat(payload.getName(), notNullValue());
        assertThat(payload.getOwner(), notNullValue());
        assertThat(payload.getSub(), notNullValue());
        assertThat(payload.getScopes(), notNullValue());
        assertThat(payload.getScopes().size(), equalTo(1));
        assertThat(payload.getScopes().iterator().next(), equalTo("publicData"));
        assertThat(payload.getCharacterID(), notNullValue());
        assertThat(payload.getCharacterID(), equalTo(characterId));
    }

    @Test
    public void getJwtTest() {
        final OAuth auth = (OAuth) apiClient.getAuthentication("evesso");
        JWT jwt = auth.getJWT();
        assertThat(jwt, notNullValue());
        JWT.Header header = jwt.getHeader();
        assertThat(header, notNullValue());
        assertThat(header.getAlg(), notNullValue());
        assertThat(header.getTyp(), notNullValue());
        JWT.Payload payload = jwt.getPayload();
        assertThat(payload, notNullValue());
        assertThat(payload.getAzp(), notNullValue());
        assertThat(payload.getExp(), notNullValue());
        assertThat(payload.getIss(), notNullValue());
        assertThat(payload.getJti(), notNullValue());
        assertThat(payload.getKid(), notNullValue());
        assertThat(payload.getName(), notNullValue());
        assertThat(payload.getOwner(), notNullValue());
        assertThat(payload.getSub(), notNullValue());
        assertThat(payload.getScopes(), notNullValue());
        assertThat(payload.getScopes().size(), equalTo(SsoScopes.ALL.size()));
        assertThat(payload.getCharacterID(), notNullValue());
        assertThat(payload.getCharacterID(), equalTo(characterId));
    }

    @Test
    public void expiredAccessTokenSso() {
        final ApiClient client = new ApiClient();
        final OAuth auth = (OAuth) client.getAuthentication("evesso");
        auth.setClientId(clientId);
        auth.setRefreshToken(null);
        auth.setAccessToken("WOjpIU1jS6mkgAqXhxu5K4kuNa-b7QLN8kL-_Lizd6MSsLwRSBBB8Xgd0UNFOFaEMDKix3J4uUfgfrIkBYUDuQ2");
        final SsoApi api = new SsoApi(client);
        try {
            api.getCharacterInfo();
            fail("Must fail with ApiException");
        } catch (ApiException ex) {
            assertThat(ex, notNullValue());
            assertThat(ex.getCode(), notNullValue());
        }
    }

    @Test
    public void finishFlowFail() {
        OAuth oAuth = new OAuth();
        oAuth.setClientId("");
        final String state = "TESTING";
        oAuth.getAuthorizationUri("", Collections.singleton(""), state);
        try {
            oAuth.finishFlow("", state);
            fail("Must fail with ApiException");
        } catch (ApiException ex) {
            assertThat(ex, notNullValue());
            assertThat(ex.getCode(), notNullValue());
        }
    }

    /**
     * This main method can be used to generate a refresh token to run the unit
     * tests that need authentication. It is also an example how to use SSO in
     * an implementation.
     *
     * More description is in the README.md
     *
     * @param args
     *            The client id and client secret.
     * @throws IOException
     * @throws URISyntaxException
     * @throws net.troja.eve.esi.ApiException
     */
    public static void main(final String... args) throws IOException, URISyntaxException, ApiException {
        final String state = "somesecret";
        final ApiClient client = new ApiClient();
        final OAuth auth = (OAuth) client.getAuthentication("evesso");
        if (args.length == 2) {
            auth.setClientId(args[0]);
        } else {
            initData();
            if (clientId != null) {
                auth.setClientId(clientId);
            } else {
                System.err.println("ClientId and ClientSecret missing");
                System.exit(-1);
            }
        }

        final Set<String> scopes = SsoScopes.ALL;
        String redirectUri;
        if (System.getenv().get("SSO_CALLBACK_URL") != null) {
            redirectUri = System.getenv().get("SSO_CALLBACK_URL");
        } else {
            redirectUri = "http://localhost";
        }
        final String authorizationUri = auth.getAuthorizationUri(redirectUri, scopes, state);
        System.out.println("Authorization URL: " + authorizationUri);
        Desktop.getDesktop().browse(new URI(authorizationUri));

        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Code from Answer: ");
        final String code = br.readLine();
        auth.finishFlow(code, state);
        System.out.println("Refresh Token: " + auth.getRefreshToken());
    }

    private static class UpdateThread implements Callable<Void> {

        @Override
        public Void call() throws Exception {
            try {
                AssetsApi api = new AssetsApi();
                Integer page = null;
                final List<CharacterAssetsResponse> response = api.getCharactersCharacterIdAssets(characterId, DATASOURCE, null, page, null);
                assertThat(response, notNullValue());
                assertThat(response.size(), greaterThan(0));
            } catch (ApiException ex) {
                fail(ex.getMessage());
            }
            return null;
        }
    }
}
