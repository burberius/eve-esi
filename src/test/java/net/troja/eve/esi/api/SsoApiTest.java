package net.troja.eve.esi.api;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import net.troja.eve.esi.ApiClient;
import net.troja.eve.esi.ApiException;
import net.troja.eve.esi.auth.CharacterInfo;
import net.troja.eve.esi.auth.OAuth;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;


public class SsoApiTest extends GeneralApiTest {

    @Test
    public void dateFormatTest() {
        DateFormat simpleDateFormat = new SimpleDateFormat(SsoApi.DATE_FORMAT);
        try {
            simpleDateFormat.parse("2017-10-07T17:37:43.120");
            simpleDateFormat.parse("2017-10-07T17:37:43");
        } catch (ParseException ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void getCharacterInfoTest() throws ApiException {
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
        assertThat(info.getScopes().size(), greaterThan(10));
    }

    @Test
    public void revokeRefreshToken() throws ApiException {
        final ApiClient client = new ApiClient();
        final OAuth auth = (OAuth) client.getAuthentication("evesso");
        auth.setClientId(clientId);
        auth.setClientSecret(clientSecret);

        final SsoApi api = new SsoApi(client);
        api.revokeRefreshToken("GSRfoI0co6wu7nSa0hS-xkgJs1FL8e9q5u6HPegjZIw1"); //Revoked Refresh Tokens (Already Invalid)
    }

    @Test
    public void revokeAccessToken() throws ApiException {
        final ApiClient client = new ApiClient();
        final OAuth auth = (OAuth) client.getAuthentication("evesso");
        auth.setClientId(clientId);
        auth.setClientSecret(clientSecret);

        final SsoApi api = new SsoApi(client);
        api.revokeAccessToken("WOjpIU1jS6mkgAqXhxu5K4kuNa-b7QLN8kL-_Lizd6MSsLwRSBBB8Xgd0UNFOFaEMDKix3J4uUfgfrIkBYUDuQ2"); //Revoked Access Tokens (Already Invalid)
    }
}
