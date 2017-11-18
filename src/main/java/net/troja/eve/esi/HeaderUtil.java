package net.troja.eve.esi;

import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class HeaderUtil {

    public static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern(
            "[EEE, ]dd MMM yyyy HH:mm[:ss][ zzz][ xxxx]", Locale.ENGLISH);
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
    public static OffsetDateTime getExpires(Map<String, List<String>> responseHeaders) {
        // Get header
        String header = getHeader(responseHeaders, EXPIRES);
        if (header == null) {
            return null;
        }

        // Convert
        try {
            return ZonedDateTime.parse(header, DATE_FORMAT).toOffsetDateTime();
        } catch (DateTimeParseException ex) {
            return null;
        }
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
