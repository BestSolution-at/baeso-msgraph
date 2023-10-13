package at.bestsolution.baeso.msgraph.impl.model;

import at.bestsolution.baeso.msgraph.model.EventTentativelyAccept;
import at.bestsolution.baeso.msgraph.model.TimeSlot;
import jakarta.json.JsonObject;

public class EventTentativelyAcceptImpl extends BaseImpl implements EventTentativelyAccept {

    public EventTentativelyAcceptImpl(JsonObject object) {
        super(object);
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
    
    public static class EventTentativelyAcceptBuilderImpl extends BaseBuilderImpl implements EventTentativelyAccept.Builder {

        @Override
        public EventTentativelyAccept build() {
            return new EventTentativelyAcceptImpl(builder.build());
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
