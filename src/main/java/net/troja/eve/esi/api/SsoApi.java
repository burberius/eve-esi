package net.troja.eve.esi.api;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import net.troja.eve.esi.ApiClient;
import net.troja.eve.esi.ApiException;
import net.troja.eve.esi.Pair;
import net.troja.eve.esi.auth.CharacterInfo;
import net.troja.eve.esi.auth.OAuth;

/**
 * Api to retrieve the character information from the sso.
 */
public class SsoApi {
    private static final String URI_REVOKE = "https://login.eveonline.com";
    private static final String ACCESS_TOKEN = "access_token";
    private static final String REFRESH_TOKEN = "refresh_token";
    protected static final String DATE_FORMAT = "yyyy-MM-dd'T'hh:mm:ss";
    private ApiClient apiClient;

    public SsoApi() {
        this(new ApiClient());
    }

    public SsoApi(final ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public CharacterInfo getCharacterInfo() throws ApiException {
        final DateFormat dateFormat = apiClient.getDateFormat(); // Save old
                                                                 // date format
        apiClient.setDateFormat(new SimpleDateFormat(DATE_FORMAT)); // Set new
                                                                    // date
                                                                    // format
        final Object localVarPostBody = null;

        final String localVarPath = "/verify";

        final List<Pair> localVarQueryParams = new ArrayList<>();
        final Map<String, String> localVarHeaderParams = new HashMap<>();
        final Map<String, Object> localVarFormParams = new HashMap<>();

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {};
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        final String[] localVarAuthNames = new String[] { "evesso" };

        final GenericType<CharacterInfo> localVarReturnType = new GenericType<CharacterInfo>() {
        };

        try {
            return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody,
                    localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames,
                    localVarReturnType);
        } finally {
            apiClient.setDateFormat(dateFormat); // load old date format
        }
    }

    public void revokeRefreshToken(String refreshToken) throws ApiException {
        revokeToken(refreshToken, REFRESH_TOKEN);
    }

    public void revokeAccessToken(String accessToken) throws ApiException {
        revokeToken(accessToken, ACCESS_TOKEN);
    }

    private void revokeToken(String token, String tokenTypeHint) throws ApiException {
        final String basePath = apiClient.getBasePath(); // Save old basepath
        apiClient.setBasePath(URI_REVOKE); // Set new basepath

        final String localVarPath = "/oauth/revoke";

        final List<Pair> localVarQueryParams = new ArrayList<>();
        
        final Map<String, String> localVarHeaderParams = new HashMap<>();
        final OAuth auth = (OAuth) apiClient.getAuthentication("evesso");
        String clientPair =  auth.getClientId() + ":" + auth.getClientSecret();
        String encoded;
        try {
            encoded = new String(Base64.getUrlEncoder().encode(clientPair.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException ex) {
            throw new ApiException(ex);
        }
        localVarHeaderParams.put("Authorization", "Basic " + encoded);
        localVarHeaderParams.put("Content-Type", "application/x-www-form-urlencoded");
        localVarHeaderParams.put("Host", "login.eveonline.com");

        final Map<String, Object> localVarFormParams = new HashMap<>();
        localVarFormParams.put("token_type_hint", tokenTypeHint);
        localVarFormParams.put("token", token);

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = { "application/x-www-form-urlencoded" };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        final String[] localVarAuthNames = new String[0];

        try {
            apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, null,
                    localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames,
                    null);
        } finally {
            apiClient.setBasePath(basePath); // load old basepath
        }
    }
}
