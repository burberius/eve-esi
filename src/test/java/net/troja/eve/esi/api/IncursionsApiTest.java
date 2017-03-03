/*
 * EVE Swagger Interface
 * An OpenAPI for EVE Online
 *
 *
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package net.troja.eve.esi.api;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

import net.troja.eve.esi.ApiException;
import net.troja.eve.esi.model.IncursionsResponse;

/**
 * API tests for IncursionsApi
 */
public class IncursionsApiTest extends GeneralApiTest {

    private final IncursionsApi api = new IncursionsApi();

    /**
     * List incursions
     *
     * Return a list of current incursions --- Alternate route:
     * &#x60;/v1/incursions/&#x60; Alternate route:
     * &#x60;/legacy/incursions/&#x60; Alternate route:
     * &#x60;/dev/incursions/&#x60; --- This route is cached for up to 300
     * seconds
     *
     * @throws ApiException
     *             if the Api call fails
     */
    @Test
    public void getIncursionsTest() throws ApiException {
        final List<IncursionsResponse> response = api.getIncursions(DATASOURCE, null, null);

        assertThat(response.size(), greaterThan(0));
        final IncursionsResponse incursionsResponse = response.get(0);
        assertThat(incursionsResponse.getConstellationId(), greaterThan(0));
    }

}