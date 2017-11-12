package net.troja.eve.esi;

import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import org.junit.Test;


public class HeaderUtilTest {
    
    @Test
    public void testDefault() {
        test("Sun, 12 Nov 2017 12:02:44 GMT");
    }

    @Test
    public void testFull() {
        test("Sat, 13 Mar 2010 11:29:05 -0800");
    }

    @Test
    public void testNoSec() {
        test("Sat, 13 Mar 2010 11:29 -0800");
    }

    @Test
    public void testNoDay() {
        test("13 Mar 2010 11:29:05 -0800");
    }

    @Test
    public void testNoDayNoSec() {
        test("13 Mar 2010 11:29 -0800");
    }

    private void test(String testValue) {
        Map<String, List<String>> responseHeaders = Collections.singletonMap("Expires", Collections.singletonList(testValue));
        OffsetDateTime expires = HeaderUtil.getExpires(responseHeaders);
        assertThat(expires, notNullValue());
    }
    
}
