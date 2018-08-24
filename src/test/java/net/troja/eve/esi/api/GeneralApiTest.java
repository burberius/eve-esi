package net.troja.eve.esi.api;

import java.util.Map;
import net.troja.eve.esi.ApiClient;
import net.troja.eve.esi.ApiException;
import net.troja.eve.esi.auth.CharacterInfo;
import net.troja.eve.esi.auth.OAuth;
import static org.junit.Assume.assumeFalse;
import org.junit.BeforeClass;

public class GeneralApiTest {
    protected static final String DATASOURCE = "tranquility";
    protected static final String LANGUAGE = "en-us";
    protected static final String SSO_CLIENT_ID = "SSO_CLIENT_ID";
    protected static final String SSO_CLIENT_SECRET = "SSO_CLIENT_SECRET";
    protected static final String SSO_REFRESH_TOKEN = "SSO_REFRESH_TOKEN";
    protected static final int CHARACTER_ID_CHRIBBA = 196379789;
    protected static final String CHARACTER_NAME_CHRIBBA = "Chribba";
    protected static final int CORPORATION_ID_TBD = 98435559;
    protected static final String CORPORATION_NAME_TBD = "The Blue Donut";
    protected static final int ALLIANCE_ID_TRI = 933731581;
    protected static final String ALLIANCE_NAME_TRI = "Triumvirate.";
    protected final static int REGION_ID_THE_FORGE = 10000002;
    protected final static int TYPE_ID_VELDSPAR = 1230;
    protected static final String NAME_VELDSPAR = "Veldspar";
    protected final static int SOLARSYSTEM_ID_JITA = 30000142;
    protected final static int SOLARSYSTEM_ID_ALIKARA = 30002754;

    protected static String clientId;
    protected static String clientSecret;
    protected static String refreshToken;
    protected static int characterId;
    protected static String characterName;

    protected static ApiClient apiClient;

    @BeforeClass
    public static void initClass() throws ApiException {
        initData();
        getCharacterId();
    }

	public static void initData() {
		final Map<String, String> env = System.getenv();

        clientId = env.get(SSO_CLIENT_ID);
        clientSecret = env.get(SSO_CLIENT_SECRET);
        refreshToken = env.get(SSO_REFRESH_TOKEN);

        apiClient = new ApiClient();
        final OAuth auth = (OAuth) apiClient.getAuthentication("evesso");
        auth.setClientId(clientId);
        auth.setClientSecret(clientSecret);
        auth.setRefreshToken(refreshToken);
	}

    private static void getCharacterId() throws ApiException {
        final ApiClient client = new ApiClient();
        final OAuth auth = (OAuth) client.getAuthentication("evesso");
        auth.setClientId(clientId);
        auth.setClientSecret(clientSecret);
        auth.setRefreshToken(refreshToken);

        final SsoApi api = new SsoApi(client);
        final CharacterInfo info = api.getCharacterInfo();

        characterName = info.getCharacterName();
        characterId = info.getCharacterId();
    }

    protected void ignoreTestFails() {
        assumeFalse("Ignore test fails", true); //true = ignore tests :: false = run all tests
    }
}
