package net.troja.eve.esi.api.auth;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import net.troja.eve.esi.ApiClient;
import net.troja.eve.esi.api.GeneralApiTest;
import net.troja.eve.esi.auth.OAuth;

public class SsoAuthTest extends GeneralApiTest {
    @Test
    public void refreshToken() {
        final ApiClient client = new ApiClient();
        final OAuth auth = (OAuth) client.getAuthentication("evesso");
        auth.setClientId(clientId);
        auth.setClientSecret(clientSecret);

        auth.setRefreshToken(refreshToken);

        final Map<String, String> headerParams = new HashMap<>();
        auth.applyToParams(null, headerParams);

        assertThat(headerParams.size(), equalTo(1));
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
     */
    public static void main(final String... args) throws IOException {
        final String state = "somesecret";
        if (args.length != 2) {
            System.err.println("ClientId and ClientSecret missing");
            System.exit(-1);
        }
        final ApiClient client = new ApiClient();
        final OAuth auth = (OAuth) client.getAuthentication("evesso");
        auth.setClientId(args[0]);
        auth.setClientSecret(args[1]);

        final Set<String> scopes = new HashSet<>();
        scopes.add("esi-clones.read_clones.v1");
        System.out.println("Authorization URL: " + auth.getAuthorizationUri("http://localhost", scopes, state));

        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Code from Answer: ");
        final String code = br.readLine();
        auth.finishFlow(code, state);
        System.out.println("Refresh Token: " + auth.getRefreshToken());
    }
}
