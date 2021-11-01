package net.troja.eve.esi.api;

import net.troja.eve.esi.ApiClient;
import net.troja.eve.esi.ApiClientBuilder;
import net.troja.eve.esi.ApiException;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

import static org.junit.Assert.fail;


public class SsoApiTest extends GeneralApiTest {

    @Test
    public void dateFormatTest() {
        try {
            LocalDateTime.parse("2017-10-07T17:37:43.120");
            LocalDateTime.parse("2017-10-07T17:37:43");
        } catch (DateTimeParseException ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void revokeRefreshToken() throws ApiException {
        final ApiClient client = new ApiClientBuilder().authNative(clientId).build();

        final SsoApi api = new SsoApi(client);
        api.revokeRefreshToken("GSRfoI0co6wu7nSa0hS-xkgJs1FL8e9q5u6HPegjZIw1"); //Revoked Refresh Tokens (Already Invalid)
    }

    @Test
    public void revokeAccessToken() throws ApiException {
        final ApiClient client = new ApiClientBuilder().authNative(clientId).build();

        final SsoApi api = new SsoApi(client);
        api.revokeAccessToken("WOjpIU1jS6mkgAqXhxu5K4kuNa-b7QLN8kL-_Lizd6MSsLwRSBBB8Xgd0UNFOFaEMDKix3J4uUfgfrIkBYUDuQ2"); //Revoked Access Tokens (Already Invalid)
    }
}
