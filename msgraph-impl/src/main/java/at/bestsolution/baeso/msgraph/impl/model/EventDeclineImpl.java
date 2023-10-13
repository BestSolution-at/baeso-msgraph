package at.bestsolution.baeso.msgraph.impl.model;

import at.bestsolution.baeso.msgraph.model.EventDecline;
import at.bestsolution.baeso.msgraph.model.TimeSlot;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;

public class EventDeclineImpl implements EventDecline {
    public JsonObject object;

    public EventDeclineImpl(JsonObject object) {
        this.object = object;
    }

    @Override
    public String comment() {
        return object.getString("comment");
    }

    @Override
    public TimeSlot proposedNewTime() {
        return new TimeSlotImpl(object.getJsonObject("proposedNewTime"));
    }

    @Override
    public boolean sendResponse() {
        return object.getBoolean("sendResponse");
    }
    
    public static class EventDeclineBuilderImpl implements EventDecline.Builder {
        private JsonObjectBuilder builder = Json.createObjectBuilder();

        @Override
        public EventDecline build() {
            return new EventDeclineImpl(builder.build());
        }

        @Override
        public Builder comment(String comment) {
            builder.add("comment", comment);
            return this;
        }

        @Override
        public Builder proposedNewTime(TimeSlot proposedNewTime) {
            builder.add("proposedNewTime", ((TimeSlotImpl)proposedNewTime).object);
            return this;
        }

        @Override
        public Builder sendResponse(boolean sendResponse) {
            builder.add("sendResponse", sendResponse);
            return this;
        }

    }
}
