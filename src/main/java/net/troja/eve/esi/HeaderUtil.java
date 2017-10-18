package net.troja.eve.esi;

import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class HeaderUtil {

    private static final ISO8601DateFormat DATE_FORMAT = new ISO8601DateFormat();

    private HeaderUtil() { }

    /**
     * 
     * @param responseHeaders ApiClient.getResponseHeaders()
     * @return 
     */
    public static Integer getXPages(Map<String, List<String>> responseHeaders) {
        //Get header
        String header = getHeader(responseHeaders, "X-Pages");
        if (header == null) {
            return null;
        }
        //Convert
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
     * @param responseHeaders ApiClient.getResponseHeaders()
     * @return 
     */
    public static Date getExpires(Map<String, List<String>> responseHeaders) {
        //Get header
        String header = getHeader(responseHeaders, "Expires");
        if (header == null) {
            return null;
        }

        //Convert
        Date xPages = null;
        try {
            xPages = DATE_FORMAT.parse(header);
        } catch (ParseException ex) {
            
        }
        return xPages;
    }

    /***
     * 
     * @param responseHeaders ApiClient.getResponseHeaders()
     * @param header
     * @return 
     */
    public static String getHeader(Map<String, List<String>> responseHeaders, String header) {
        if (responseHeaders == null) {
            return null;
        }
        //Search the headers case insensitive (headers should be evaluated as case insensitive, but, the Swagger implementation uses HashMap that is case sensitive)
        List<String> headersList = null;
        for (Map.Entry<String, List<String>> entry : responseHeaders.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(header)) {
                headersList = entry.getValue();
                break;
            }
        }
        if (headersList == null || headersList.isEmpty()) { //Better safe than sorry
            return null;
        }
        return headersList.get(0);
    }
    
}
