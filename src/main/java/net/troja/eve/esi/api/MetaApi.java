package net.troja.eve.esi.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import net.troja.eve.esi.ApiClient;
import net.troja.eve.esi.ApiException;
import net.troja.eve.esi.Pair;

/**
 * Api to retrieve the meta information about esi
 */
public class MetaApi {

    private ApiClient apiClient;

    public MetaApi() {
        this(new ApiClient());
    }

    public MetaApi(final ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public Map<String, String> getHeaders() throws ApiException {
        final Object localVarPostBody = null;

        final String localVarPath = "/headers/";

        final List<Pair> localVarQueryParams = new ArrayList<>();
        final Map<String, String> localVarHeaderParams = new HashMap<>();
        final Map<String, Object> localVarFormParams = new HashMap<>();

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {};
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        final String[] localVarAuthNames = new String[] { "evesso" };

        final GenericType<Map<String, String>> localVarReturnType = new GenericType<Map<String, String>>() {
        };

        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }
}
