package net.troja.eve.esi.api;

import java.util.List;
import java.util.Map;
import static net.troja.eve.esi.api.GeneralApiTest.apiClient;
import net.troja.eve.esi.model.EsiStatusResponse;
import net.troja.eve.esi.model.VerifyResponse;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.notNullValue;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assume.assumeFalse;
import org.junit.Before;


public class MetaApiTest extends GeneralApiTest {

    private final MetaApi api = new MetaApi();

    @Before
    public void setUp() {
        api.setApiClient(apiClient);
    }


    @Test
    public void testGetHeaders() throws Exception {
        Map<String, String> headers = api.getHeaders();
        assertThat(headers, notNullValue());
        assertThat(headers.size(), greaterThan(0));
        assertThat(headers.get("Accept"), equalTo("application/json"));
        assertThat(headers.get("User-Agent"), equalTo("eve-esi/slack:@goldengnu"));
    }

    
    @Test
    public void testGetPing() throws Exception {
        String ping = api.getPing();
        assertThat(ping, notNullValue());
        assertThat(ping, equalTo("ok"));
    }


    @Test
    public void testGetStatus() throws Exception {
        List<EsiStatusResponse> status = api.getStatus("latest");
        assertThat(status, notNullValue());
        assertThat(status.size(), greaterThan(0));
        assumeFalse(status.isEmpty());
        EsiStatusResponse esiStatus = status.get(0);
        assertThat(esiStatus.getEndpoint(), notNullValue());
        assertThat(esiStatus.getMethod(), notNullValue());
        assertThat(esiStatus.getRoute(), notNullValue());
        assertThat(esiStatus.getStatus(), notNullValue());
        assertThat(esiStatus.getTags(), notNullValue());
        assertThat(esiStatus.getTags().size(), greaterThan(0));
    }


    @Test
    public void testGetVerify() throws Exception {
        VerifyResponse verify = api.getVerify();
        assertThat(verify, notNullValue());
        assertThat(verify.getCharacterID(), notNullValue());
        assertThat(verify.getCharacterID(), equalTo(characterId));
        assertThat(verify.getCharacterName(), notNullValue());
        assertThat(verify.getCharacterName(), equalTo(characterName));
        assertThat(verify.getCharacterOwnerHash(), notNullValue());
        assertThat(verify.getExpiresOn(), notNullValue());
        //assertThat(verify.getIntellectualProperty(), notNullValue());
        assertThat(verify.getScopes(), notNullValue());
        assertThat(verify.getScopes().size(), greaterThan(0));
        assertThat(verify.getTokenType(), notNullValue());
        
    }

    @Test
    public void testGetVersions() throws Exception {
        List<String> versions = api.getVersions(null, null);
        assertThat(versions, notNullValue());
        assertThat(versions.size(), greaterThan(0));
    }

}
