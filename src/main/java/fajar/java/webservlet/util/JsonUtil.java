package fajar.java.webservlet.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {


    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static ObjectMapper getObjectMapper() {
        return objectMapper;
    }
}
