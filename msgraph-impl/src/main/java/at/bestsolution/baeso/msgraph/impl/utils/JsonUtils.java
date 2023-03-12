package at.bestsolution.baeso.msgraph.impl.utils;

import java.io.StringWriter;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.stream.JsonGenerator;

public class JsonUtils {
    public static String stringify(JsonObject object, boolean pretty) {
        var writer = new StringWriter();
        var generator = Json.createGeneratorFactory(Map.of(JsonGenerator.PRETTY_PRINTING, Boolean.TRUE)).createGenerator(writer);
        generator.write(object);
        generator.close();
        return writer.toString();
    }
}
