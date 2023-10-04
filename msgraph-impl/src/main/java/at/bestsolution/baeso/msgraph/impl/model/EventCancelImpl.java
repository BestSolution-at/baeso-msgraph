package at.bestsolution.baeso.msgraph.impl.model;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;

import at.bestsolution.baeso.msgraph.model.EventCancel;

public class EventCancelImpl implements EventCancel {
    public JsonObject object;

    public EventCancelImpl(JsonObject object) {
        this.object = object;
    }

    @Override
    public String comment() {
        return object.getString("comment");
    }
    
    public static class EventCancelBuilderImpl implements EventCancel.Builder {
        private final JsonObjectBuilder builder = Json.createObjectBuilder();

        @Override
        public EventCancel build() {
            return new EventCancelImpl(builder.build());
        }

        @Override
        public Builder comment(String comment) {
            builder.add("comment", comment);
            return this;
        }

    }
}
