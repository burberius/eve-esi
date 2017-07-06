package net.troja.eve.esi.api;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    private static final String DATE_FORMAT = "yyyy-MM-dd'T'hh:mm:ss.sss";
    private final ApiClient apiClient;

    public SsoApi() {
        this(new ApiClient());
    }

    public SsoApi(final ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public CharacterInfo getCharacterInfo() throws ApiException {
        apiClient.setBasePath(OAuth.URI_OAUTH); //Set new basepath
        apiClient.setDateFormat(new SimpleDateFormat(DATE_FORMAT)); //Set new date format
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
            return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                    localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
        } finally {
            apiClient.setBasePath(basePath); //load old basepath
            apiClient.setDateFormat(dateFormat); //load old date format
        }
    }
}
