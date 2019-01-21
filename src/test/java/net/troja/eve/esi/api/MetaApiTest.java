package net.troja.eve.esi.api;

import java.util.Map;
import net.troja.eve.esi.ApiException;
import org.hamcrest.Matchers;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import org.junit.Test;
import static org.junit.Assert.*;


public class MetaApiTest extends GeneralApiTest {

    @Test
    public void getHeadersTest() throws ApiException {
        final MetaApi api = new MetaApi();
        Map<String, String> headers = api.getHeaders();
        assertThat(headers, notNullValue());
        assertThat(headers.size(), Matchers.greaterThan(0));
        assertThat(headers.get("Accept"), equalTo("application/json"));
        assertThat(headers.get("User-Agent"), equalTo("eve-esi/slack:@goldengnu"));
    }
}
