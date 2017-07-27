package net.troja.eve.esi.api.auth;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import net.troja.eve.esi.ApiClient;
import net.troja.eve.esi.ApiException;
import net.troja.eve.esi.api.GeneralApiTest;
import net.troja.eve.esi.api.SsoApi;
import net.troja.eve.esi.auth.CharacterInfo;
import net.troja.eve.esi.auth.OAuth;
import net.troja.eve.esi.auth.SsoScopes;
import static org.junit.Assert.fail;

public class SsoAuthTest extends GeneralApiTest {
    @Test
    public void refreshToken() throws ApiException {
        final ApiClient client = new ApiClient();
        final OAuth auth = (OAuth) client.getAuthentication("evesso");
        auth.setClientId(clientId);
        auth.setClientSecret(clientSecret);

        auth.setRefreshToken(refreshToken);

        final Map<String, String> headerParams = new HashMap<>();
        auth.applyToParams(null, headerParams);

        assertThat(headerParams.size(), equalTo(1));
    }

    @Test
    public void getCharacterInfo() throws ApiException {
        final ApiClient client = new ApiClient();
        final OAuth auth = (OAuth) client.getAuthentication("evesso");
        auth.setClientId(clientId);
        auth.setClientSecret(clientSecret);
        auth.setRefreshToken(refreshToken);

        final SsoApi api = new SsoApi(client);
        final CharacterInfo info = api.getCharacterInfo();

        assertThat(info, notNullValue());
        assertThat(info.getCharacterId(), greaterThan(100000));
        assertThat(StringUtils.isBlank(info.getCharacterName()), equalTo(false));
        assertThat(info.getExpiresOn(), notNullValue());
        assertThat(StringUtils.isBlank(info.getCharacterName()), equalTo(false));
        assertThat(info.getTokenType(), equalTo("Character"));
        assertThat(StringUtils.isBlank(info.getCharacterOwnerHash()), equalTo(false));
        assertThat(info.getIntellectualProperty(), equalTo("EVE"));
    }

    @Test
    public void getCharacterInfoFail() {
        final SsoApi api = new SsoApi();
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
        oAuth.setClientSecret("");
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
        if (args.length != 2) {
            System.err.println("ClientId and ClientSecret missing");
            System.exit(-1);
        }
        final ApiClient client = new ApiClient();
        final OAuth auth = (OAuth) client.getAuthentication("evesso");
        auth.setClientId(args[0]);
        auth.setClientSecret(args[1]);

        final Set<String> scopes = new HashSet<>(Arrays.asList(SsoScopes.ALL));
        final String authorizationUri = auth.getAuthorizationUri("http://localhost", scopes, state);
        System.out.println("Authorization URL: " + authorizationUri);
        Desktop.getDesktop().browse(new URI(authorizationUri));

        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Code from Answer: ");
        final String code = br.readLine();
        auth.finishFlow(code, state);
        System.out.println("Refresh Token: " + auth.getRefreshToken());
    }
}
