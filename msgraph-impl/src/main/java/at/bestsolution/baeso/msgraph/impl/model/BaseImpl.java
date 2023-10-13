package at.bestsolution.baeso.msgraph.impl.model;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;

public class BaseImpl {
    public final JsonObject object;

    public BaseImpl(JsonObject object) {
        this.object = object;
    }

    public static class BaseBuilderImpl {
        protected final JsonObjectBuilder builder = Json.createObjectBuilder();
    }
}
