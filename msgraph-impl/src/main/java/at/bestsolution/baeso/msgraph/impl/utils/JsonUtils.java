package at.bestsolution.baeso.msgraph.impl.utils;

import java.io.StringWriter;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.JsonString;
import jakarta.json.JsonValue;
import jakarta.json.JsonValue.ValueType;
import jakarta.json.stream.JsonGenerator;

public class JsonUtils {
    public static <T> T mapString(JsonObject object, String property, Function<String, T> mapper, T defaultValue) {
        if( object.containsKey(property) && ! object.isNull(property) ) {
            return mapper.apply(object.getString(property));
        }
        return defaultValue;
    }

    public static <T> T mapString(JsonObject object, String property, Function<String, T> mapper) {
        return mapString(object, property, mapper, null);
    }

    public static <T> T mapObject(JsonObject object, String property, Function<JsonObject, T> mapper) {
        if( object.containsKey(property) ) {
            return mapper.apply(object.getJsonObject(property));
        }
        return null;
    }

    public static double mapDouble(JsonObject object, String property) {
        if( object.containsKey(property) ) {
            return object.getJsonNumber(property).doubleValue();
        }
        return 0;
    }

    public static <T> List<T> mapObjects(JsonObject object, String property, Function<JsonObject, T> mapper) {
        if( object.containsKey(property) ) {
            return object.getJsonArray(property).stream()
                .map(JsonValue::asJsonObject)
                .map(mapper)
                .collect(Collectors.toUnmodifiableList());
        }
        return List.of();
    }

    public static <T> List<T> mapStrings(JsonObject object, String property, Function<String, T> mapper) {
        if( object.containsKey(property) ) {
            return object.getJsonArray(property)
                .getValuesAs(JsonString.class)
                .stream()
                .map(JsonString::getString)
                .map(mapper)
                .collect(Collectors.toUnmodifiableList());
        }
        return List.of();
    }

    public static List<String> mapStrings(JsonObject object, String property) {
        if( object.containsKey(property) ) {
            return object.getJsonArray(property)
                .getValuesAs(JsonString.class)
                .stream()
                .map(JsonString::getString)
                .collect(Collectors.toUnmodifiableList());
        }
        return List.of();
    }

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
