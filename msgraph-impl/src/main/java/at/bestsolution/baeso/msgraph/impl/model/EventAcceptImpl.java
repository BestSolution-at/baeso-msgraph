package at.bestsolution.baeso.msgraph.impl.model;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

import at.bestsolution.baeso.msgraph.model.EventAccept;

public class EventAcceptImpl implements EventAccept {
    public final JsonObject object;

    public EventAcceptImpl(JsonObject object) {
        this.object = object;
    }

    @Override
    public String comment() {
        return this.object.getString("comment");
    }

    @Override
    public boolean sendResponse() {
        return this.object.getBoolean("sendResponse");
    }
    
    public static class EventAcceptBuilderImpl implements EventAccept.Builder {
        private final JsonObjectBuilder builder = Json.createObjectBuilder();

        @Override
        public EventAccept build() {
            return new EventAcceptImpl(builder.build());
        }

        @Override
        public Builder comment(String comment) {
            builder.add("comment", comment);
            return this;
        }

        @Override
        public Builder sendResponse(boolean sendResponse) {
            builder.add("sendResponse", sendResponse);
            return this;
        }

    }
}
