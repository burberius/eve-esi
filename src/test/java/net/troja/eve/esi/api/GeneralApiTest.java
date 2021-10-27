package net.troja.eve.esi.api;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import net.troja.eve.esi.ApiClient;
import net.troja.eve.esi.ApiClientBuilder;
import net.troja.eve.esi.ApiException;
import net.troja.eve.esi.auth.JWT;
import net.troja.eve.esi.auth.OAuth;
import org.junit.AfterClass;
import static org.junit.Assume.assumeFalse;
import org.junit.BeforeClass;

public class GeneralApiTest {
    protected static final String DATASOURCE = "tranquility";
    protected static final String LANGUAGE = "en-us";
    protected static final String SSO_CLIENT_ID = "SSO_CLIENT_ID";
    protected static final String SSO_CLIENT_SECRET = "SSO_CLIENT_SECRET";
    protected static final String SSO_REFRESH_TOKEN_DESKTOP = "SSO_REFRESH_TOKEN_DESKTOP";
    protected static final String SSO_REFRESH_TOKEN_WEB = "SSO_REFRESH_TOKEN_WEB";
    protected static final String SSO_REFRESH_TOKEN_PUBLIC_DATA = "SSO_REFRESH_TOKEN_PUBLIC_DATA";
    protected static final int CHARACTER_ID_CHRIBBA = 196379789;
    protected static final String CHARACTER_NAME_CHRIBBA = "Chribba";
    protected static final int CORPORATION_ID_TBD = 98435559;
    protected static final String CORPORATION_NAME_TBD = "The Blue Donut";
    protected static final int ALLIANCE_ID_TRI = 933731581;
    protected static final String ALLIANCE_NAME_TRI = "Triumvirate.";
    protected static final int REGION_ID_THE_FORGE = 10000002;
    protected static final int TYPE_ID_VELDSPAR = 1230;
    protected static final String NAME_VELDSPAR = "Veldspar";
    protected static final int SOLARSYSTEM_ID_JITA = 30000142;
    protected static final int SOLARSYSTEM_ID_ALIKARA = 30002754;

    private static final String CONFIC_FILENAME = "test_config.properties";

    private final int MAX_RETRIES = 3;

    private static Properties testConfig;

    protected static String clientId;
    protected static int characterId;
    protected static String characterName;

    protected static ApiClient apiClient;
    protected static ApiClient apiClientWeb;
    protected static ApiClient apiClientPublicData;

    @BeforeClass
    public static void initClass() throws ApiException {
        load();
        clientId = testConfig.getProperty(SSO_CLIENT_ID);
        String ssoClientSecret = testConfig.getProperty(SSO_CLIENT_SECRET);
        String desktopRefreshToken = testConfig.getProperty(SSO_REFRESH_TOKEN_DESKTOP);
        String webRefreshToken = testConfig.getProperty(SSO_REFRESH_TOKEN_WEB);
        String refreshTokenPublicData = testConfig.getProperty(SSO_REFRESH_TOKEN_PUBLIC_DATA);

        apiClient = new ApiClientBuilder().authDesktop(clientId).refreshToken(desktopRefreshToken).build();
        apiClientWeb = new ApiClientBuilder().authWeb(clientId, ssoClientSecret).refreshToken(webRefreshToken).build();
        apiClientPublicData = new ApiClientBuilder().authDesktop(clientId).refreshToken(refreshTokenPublicData).build();

        final OAuth auth = (OAuth) apiClient.getAuthentication("evesso");
        JWT jwt = auth.getJWT();
        JWT.Payload payload = jwt.getPayload();
        characterId = payload.getCharacterID();
        characterName = payload.getName();
    }

    @AfterClass
    public static void save() throws ApiException {
        load();
        try (OutputStream output = new FileOutputStream(CONFIC_FILENAME)) {
            //Update refresh token values
            testConfig.setProperty(SSO_REFRESH_TOKEN_DESKTOP, getRefreshToken(apiClient));
            testConfig.setProperty(SSO_REFRESH_TOKEN_WEB, getRefreshToken(apiClientWeb));
            testConfig.setProperty(SSO_REFRESH_TOKEN_PUBLIC_DATA, getRefreshToken(apiClientPublicData));
            //Save file
            testConfig.store(output, null);
        } catch (IOException ex) {
            throw new ApiException(ex);
        }
    }

    private static String getRefreshToken(ApiClient client) {
        final OAuth auth = (OAuth) client.getAuthentication("evesso");
        return auth.getRefreshToken();
    }

    public static Properties getTestConfig() throws ApiException {
        if (testConfig == null) {
            load();
        }
        return testConfig;
    }

    private static void load() throws ApiException {
        try (InputStream input = new FileInputStream(CONFIC_FILENAME)) {
            testConfig = new Properties();
            testConfig.load(input);
        } catch (IOException ex) {
            throw new ApiException(ex);
        }
    }

    protected void ignoreTestFails() {
        assumeFalse("Ignore test fails", true); //true = ignore tests :: false = run all tests
    }

    protected <T> T update(Update<T> update) throws ApiException {
        return update(update, 0);
    }

    private <T> T update(Update<T> update, int retry) throws ApiException {
        try {
            return update.update();
        } catch (ApiException ex) {
            if (retry < MAX_RETRIES) {
                retry++;
                return update(update, retry);
            } else {
                throw ex;
            }
        }
    }

    protected interface Update<T> {
        public T update() throws ApiException;
    }
}
