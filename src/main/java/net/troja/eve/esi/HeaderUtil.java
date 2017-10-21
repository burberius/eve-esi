package net.troja.eve.esi;

import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class HeaderUtil {

    private static final ISO8601DateFormat DATE_FORMAT = new ISO8601DateFormat();
    private static final String X_PAGES = "X-Pages";
    private static final String EXPIRES = "Expires";

    private HeaderUtil() {
    }

    /**
     * 
     * @param responseHeaders
     *            ApiClient.getResponseHeaders()
     * @return
     */
    public static Integer getXPages(Map<String, List<String>> responseHeaders) {
        // Get header
        String header = getHeader(responseHeaders, X_PAGES);
        if (header == null) {
            return null;
        }
        // Convert
        Integer xPages;
        try {
            xPages = Integer.valueOf(header);
        } catch (NumberFormatException ex) {
            xPages = null;
        }
        return xPages;
    }

    /**
     * 
     * @param responseHeaders
     *            ApiClient.getResponseHeaders()
     * @return
     */
    public static Date getExpires(Map<String, List<String>> responseHeaders) {
        // Get header
        String header = getHeader(responseHeaders, EXPIRES);
        if (header == null) {
            return null;
        }

        // Convert
        Date expires = null;
        try {
            expires = DATE_FORMAT.parse(header);
        } catch (ParseException ex) {

        }
        return expires;
    }

    /***
     * 
     * @param responseHeaders
     *            ApiClient.getResponseHeaders()
     * @param header
     * @return
     */
    public static String getHeader(Map<String, List<String>> responseHeaders, String header) {
        if (responseHeaders == null) {
            return null;
        }
        // Search the headers case insensitive (headers should be evaluated as
        // case insensitive, but, the Swagger implementation uses HashMap that
        // is case sensitive)
        for (Map.Entry<String, List<String>> entry : responseHeaders.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(header)) {
                List<String> headersList = entry.getValue();
                if (headersList != null && !headersList.isEmpty()) { // Better
                                                                     // safe
                                                                     // than
                                                                     // sorry
                    return headersList.get(0);
                }
                break; // Header found, but, was null or empty
            }
        }
        return null;
    }

}
