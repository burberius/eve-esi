package net.troja.eve.esi.api;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeParseException;
import net.troja.eve.esi.ApiClient;
import net.troja.eve.esi.ApiException;
import net.troja.eve.esi.auth.OAuth;
import net.troja.eve.esi.model.CharacterInfo;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
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

    private void test(Class<?> c) {
		Method methods[] = c.getMethods();
		for (Method method : methods) {
			if (method.getDeclaringClass() != c
					&& method.getDeclaringClass() != Object.class
					&& ((method.getModifiers() & Modifier.STATIC) != Modifier.STATIC)
					&& ((method.getModifiers() & Modifier.FINAL) != Modifier.FINAL)) {
				fail(c.getSimpleName()+" - overwrite method: "+method.toString());
			}
		}
	}
	
	@Test
	public void testOverwrite() {
		test(CharacterInfo.class);
	}

    @Test
    public void getCharacterInfoTest() throws ApiException {
        final ApiClient client = new ApiClient();
        final OAuth auth = (OAuth) client.getAuthentication("evesso");
        auth.setAuth(clientId, refreshToken);

        final SsoApi api = new SsoApi(client);
        CharacterInfo info = api.getCharacterInfo();

        assertThat(info, notNullValue());
        assertThat(info.getCharacterID(), greaterThan(100000));
        assertThat(info.getCharacterName().isEmpty(), equalTo(false));
        assertThat(info.getExpiresOn(), notNullValue());
        assertThat(info.getExpiresOnDate(), notNullValue());
        assertThat(info.getExpiresOnDate().isAfter(OffsetDateTime.now()), equalTo(true));
        assertThat(info.getTokenType(), equalTo("JWT"));
        assertThat(info.getCharacterOwnerHash().isEmpty(), equalTo(false));
        assertThat(info.getScopesSet().size(), greaterThan(10));
    }

    @Test
    public void revokeRefreshToken() throws ApiException {
        final ApiClient client = new ApiClient();
        final OAuth auth = (OAuth) client.getAuthentication("evesso");
        auth.setClientId(clientId);

        final SsoApi api = new SsoApi(client);
        api.revokeRefreshToken("GSRfoI0co6wu7nSa0hS-xkgJs1FL8e9q5u6HPegjZIw1"); //Revoked Refresh Tokens (Already Invalid)
    }

    @Test
    public void revokeAccessToken() throws ApiException {
        final ApiClient client = new ApiClient();
        final OAuth auth = (OAuth) client.getAuthentication("evesso");
        auth.setClientId(clientId);

        final SsoApi api = new SsoApi(client);
        api.revokeAccessToken("WOjpIU1jS6mkgAqXhxu5K4kuNa-b7QLN8kL-_Lizd6MSsLwRSBBB8Xgd0UNFOFaEMDKix3J4uUfgfrIkBYUDuQ2"); //Revoked Access Tokens (Already Invalid)
    }
}
