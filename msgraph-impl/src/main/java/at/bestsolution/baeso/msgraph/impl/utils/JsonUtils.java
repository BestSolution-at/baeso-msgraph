package at.bestsolution.baeso.msgraph.impl.utils;

import java.io.StringWriter;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collector.Characteristics;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.json.JsonValue.ValueType;
import javax.json.stream.JsonGenerator;

public class JsonUtils {
    public static String stringify(JsonObject object, boolean pretty) {
        var writer = new StringWriter();
        var generator = Json.createGeneratorFactory(Map.of(JsonGenerator.PRETTY_PRINTING, Boolean.TRUE)).createGenerator(writer);
        generator.write(object);
        generator.close();
        return writer.toString();
    }

    public static Collector<String,?, JsonArray> toStringArray() {
        return Collector.of(Json::createArrayBuilder, JsonArrayBuilder::add, JsonArrayBuilder::add, JsonArrayBuilder::build);
    }

    public static Collector<JsonValue,?, JsonArray> toArray() {
        return Collector.of(Json::createArrayBuilder, JsonArrayBuilder::add, JsonArrayBuilder::add, JsonArrayBuilder::build);
    }

    public static <T> Collector<T,?, JsonArray> toArray(Function<T, JsonValue> jsonValueConverter) {
        return Collector.of(Json::createArrayBuilder, (b, v) -> jsonValueConverter.apply(v), JsonArrayBuilder::add, JsonArrayBuilder::build);
    }

    public static JsonArray deepClone(JsonArray value) {
        return value.stream().map( e -> {
            if( e.getValueType() == ValueType.OBJECT ) {
                return deepClone(e.asJsonObject());
            } else if( e.getValueType() == ValueType.ARRAY ) {
                return deepClone(e.asJsonArray());
            } else {
                return e;
            }
        }).collect(toArray());
    }

    public static JsonObject deepClone(JsonObject value) {
        var builder = Json.createObjectBuilder();
        for( var entry : value.entrySet() ) {
            if( entry.getValue().getValueType() == ValueType.OBJECT ) {
                builder.add(entry.getKey(), deepClone(entry.getValue().asJsonObject()));
            } else if( entry.getValue().getValueType() == ValueType.ARRAY ) {
                builder.add(entry.getKey(), deepClone(entry.getValue().asJsonArray()));
            } else {
                builder.add(entry.getKey(), entry.getValue());
            }
        }

        return builder.build();
    }
}
