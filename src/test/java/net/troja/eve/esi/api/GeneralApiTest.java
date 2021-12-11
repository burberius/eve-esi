package net.troja.eve.esi.api;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import org.junit.AfterClass;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import net.troja.eve.esi.ApiCallback;
import net.troja.eve.esi.ApiClient;
import net.troja.eve.esi.ApiClientBuilder;
import net.troja.eve.esi.ApiException;
import net.troja.eve.esi.ApiResponse;
import net.troja.eve.esi.auth.JWT;
import net.troja.eve.esi.auth.OAuth;
import okhttp3.Call;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeFalse;
import org.junit.BeforeClass;

public class GeneralApiTest {
    protected static final boolean IGNORE_WARNING_HEADER_199 = false;
    protected static final String DATASOURCE = "tranquility";
    protected static final String LANGUAGE = "en-us";
    protected static final String SSO_CLIENT_ID = "SSO_CLIENT_ID";
    protected static final String SSO_CLIENT_SECRET = "SSO_CLIENT_SECRET";
    protected static final String SSO_REFRESH_TOKEN_NATIVE = "SSO_REFRESH_TOKEN_NATIVE";
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

    private static final int MAX_RETRIES = 3;

    private static Properties testConfig;

    protected static String clientId;
    protected static int characterId;
    protected static String characterName;

    protected static ApiClient apiClient;
    protected static ApiClient apiClientWeb;
    protected static ApiClient apiClientPublicData;

    @BeforeClass
    public static void initClass() throws ApiException {
        final Map<String, String> env = System.getenv();
        clientId = env.get(SSO_CLIENT_ID);
        final String clientSecret = env.get(SSO_CLIENT_SECRET);

        load();
        String nativeRefreshToken = testConfig.getProperty(SSO_REFRESH_TOKEN_NATIVE);
        String webRefreshToken = testConfig.getProperty(SSO_REFRESH_TOKEN_WEB);
        String refreshTokenPublicData = testConfig.getProperty(SSO_REFRESH_TOKEN_PUBLIC_DATA);

        //Need to have access to the clients so we can save the updated refresh token
        apiClient = new ApiClientBuilder().client(new ValidatingApiClient()).authNative(clientId).refreshToken(nativeRefreshToken).build();
        apiClientWeb = new ApiClientBuilder().client(new ValidatingApiClient()).authWeb(clientId, clientSecret).refreshToken(webRefreshToken).build();
        apiClientPublicData = new ApiClientBuilder().client(new ValidatingApiClient()).authNative(clientId).refreshToken(refreshTokenPublicData).build();

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
            testConfig.setProperty(SSO_REFRESH_TOKEN_NATIVE, getRefreshToken(apiClient));
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
        load();
        return testConfig;
    }

    private static void load() throws ApiException {
        if (testConfig != null) { //Only load once...
            return;
        }
        testConfig = new Properties(); //init
        try (InputStream input = new FileInputStream(CONFIC_FILENAME)) {
            testConfig.load(input); //Load from file
        } catch (IOException ex) {
            throw new ApiException(ex);
        }
    }

    protected void ignoreTestFails() {
        assumeFalse("Ignore test fails", true); //true = ignore tests :: false = run all tests
    }

    private static class ValidatingApiClient extends ApiClient {
        @Override
        public <T> void executeAsync(Call call, Type returnType, ApiCallback<T> callback) {
            executeAsyncRetry(call, returnType, callback, 0);
        }

        public <T> void executeAsyncRetry(Call call, Type returnType, ApiCallback<T> callback, final int retry) {
            super.executeAsync(call.clone(), returnType, new ApiCallback<T>() {
                @Override
                public void onFailure(ApiException e, int statusCode, Map<String, List<String>> responseHeaders) {
                    if (retry < MAX_RETRIES) {
                        executeAsyncRetry(call, returnType, callback, retry + 1);
                    } else {
                        callback.onFailure(e, statusCode, responseHeaders);
                    }
                }

                @Override
                public void onSuccess(T result, int statusCode, Map<String, List<String>> responseHeaders) {
                    validate(responseHeaders);
                    callback.onSuccess(result, statusCode, responseHeaders);
                }

                @Override
                public void onUploadProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }

                @Override
                public void onDownloadProgress(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            });
        }

        @Override
        public <T> ApiResponse<T> execute(Call call, Type returnType) throws ApiException {
            return executeRetry(call, returnType, 0);
        }

        private <T> ApiResponse<T> executeRetry(Call call, Type returnType, final int retry) throws ApiException {
            try {
                ApiResponse<T> apiResponse = super.execute(call.clone(), returnType);
                validate(apiResponse.getHeaders());
                return apiResponse;
            } catch (ApiException ex) {
                if (retry < MAX_RETRIES) {
                    return executeRetry(call, returnType, retry + 1);
                } else {
                    throw ex;
                }
            }
        }

        private void validate(Map<String, List<String>> responseHeaders) {
            if (responseHeaders != null) {
                for (Map.Entry<String, List<String>> entry : responseHeaders.entrySet()) {
                    if (entry.getKey().toLowerCase().equals("warning")) {
                        if (entry.getValue().get(0).startsWith("199") && IGNORE_WARNING_HEADER_199) {
                            assumeFalse(entry.getValue().get(0), true);
                        } else {
                            fail(entry.getValue().get(0));
                        }
                    }
                }
            } else {
                fail("No headers");
            }
        }
    }
}
