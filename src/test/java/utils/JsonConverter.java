package utils;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.util.Map;

public class JsonConverter {
    public static <T> T deserializeToCustomClass(String json, Class<T> type) throws IOException {
        return new ObjectMapper().readValue(json, type);
    }

    public static <T> String serializeToJson(T type) throws IOException {
        return  new ObjectMapper().writeValueAsString(type);
    }

    public static <T> T deserializeToMap(String json) throws IOException {
        return new ObjectMapper().readValue(json, new TypeReference<Map<String, String>>(){});
    }
}
