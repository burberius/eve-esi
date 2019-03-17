package net.troja.eve.esi.api;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeParseException;
import java.util.HashSet;
import java.util.Set;
import net.troja.eve.esi.ApiClient;
import net.troja.eve.esi.ApiClientBuilder;
import net.troja.eve.esi.ApiException;
import net.troja.eve.esi.model.CharacterInfo;
import net.troja.eve.esi.model.EsiVerifyResponse;
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

    private void compareMethods(Class<?> c1, Class<?> c2) {
		Set<String> methods1 = new HashSet<>();
        for (Method method : c1.getMethods()) {
            methods1.add(method.getName());
        }
		Set<String> methods2 = new HashSet<>();
        for (Method method : c2.getMethods()) {
            methods2.add(method.getName());
        }
        for (String methodName : methods1) {
            assertThat(methodName + "not found", methods2.contains(methodName), equalTo(true));
        }
        for (String methodName : methods2) {
            assertThat(methodName + "not found", methods1.contains(methodName), equalTo(true));
        }
	}
	
	@Test
	public void testOverwrite() {
		compareMethods(CharacterInfo.class, EsiVerifyResponse.class);
	}

    @Test
    public void getCharacterInfoTest() throws ApiException {
        final ApiClient client = new ApiClientBuilder().clientID(clientId).refreshToken(refreshToken).build();

        final SsoApi api = new SsoApi(client);
        CharacterInfo info = api.getCharacterInfo();

        assertThat(info, notNullValue());
        assertThat(info.getCharacterID(), greaterThan(100000));
        assertThat(info.getCharacterName().isEmpty(), equalTo(false));
        assertThat(info.getExpiresOn(), notNullValue());
        assertThat(info.getExpiresOn(), notNullValue());
        assertThat(info.getExpiresOn().isAfter(OffsetDateTime.now()), equalTo(true));
        assertThat(info.getTokenType(), equalTo("JWT"));
        assertThat(info.getCharacterOwnerHash().isEmpty(), equalTo(false));
        assertThat(info.getScopes().size(), greaterThan(10));
    }

    @Test
    public void revokeRefreshToken() throws ApiException {
        final ApiClient client = new ApiClientBuilder().clientID(clientId).build();

        final SsoApi api = new SsoApi(client);
        api.revokeRefreshToken("GSRfoI0co6wu7nSa0hS-xkgJs1FL8e9q5u6HPegjZIw1"); //Revoked Refresh Tokens (Already Invalid)
    }

    @Test
    public void revokeAccessToken() throws ApiException {
        final ApiClient client = new ApiClientBuilder().clientID(clientId).build();

        final SsoApi api = new SsoApi(client);
        api.revokeAccessToken("WOjpIU1jS6mkgAqXhxu5K4kuNa-b7QLN8kL-_Lizd6MSsLwRSBBB8Xgd0UNFOFaEMDKix3J4uUfgfrIkBYUDuQ2"); //Revoked Access Tokens (Already Invalid)
    }
}
