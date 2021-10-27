package net.troja.eve.esi.api;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
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
        final SsoApi api = new SsoApi(apiClient);
        try {
            CharacterInfo info = api.getCharacterInfo();
            fail("CharacterInfo is Deprecated!");
        } catch (IllegalStateException ex) {
            //OK
        }
    }

    @Test
    public void revokeRefreshToken() throws ApiException {
        final ApiClient client = new ApiClientBuilder().authDesktop(clientId).build();

        final SsoApi api = new SsoApi(client);
        api.revokeRefreshToken("GSRfoI0co6wu7nSa0hS-xkgJs1FL8e9q5u6HPegjZIw1"); //Revoked Refresh Tokens (Already Invalid)
    }

    @Test
    public void revokeAccessToken() throws ApiException {
        final ApiClient client = new ApiClientBuilder().authDesktop(clientId).build();

        final SsoApi api = new SsoApi(client);
        api.revokeAccessToken("WOjpIU1jS6mkgAqXhxu5K4kuNa-b7QLN8kL-_Lizd6MSsLwRSBBB8Xgd0UNFOFaEMDKix3J4uUfgfrIkBYUDuQ2"); //Revoked Access Tokens (Already Invalid)
    }
}
