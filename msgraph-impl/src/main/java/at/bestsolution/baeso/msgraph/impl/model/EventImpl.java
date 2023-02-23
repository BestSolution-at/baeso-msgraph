package at.bestsolution.baeso.msgraph.impl.model;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import at.bestsolution.baeso.msgraph.base.ID;
import at.bestsolution.baeso.msgraph.impl.utils.DateUtils;
import at.bestsolution.baeso.msgraph.model.Event;
import at.bestsolution.baeso.msgraph.model.ItemBody;
import jakarta.json.JsonObject;

public class EventImpl implements Event {
    private final JsonObject object;

    public EventImpl(JsonObject object) {
        this.object = object;
    }

    @Override
    public ID<String> id() {
        return ID.of(object.getString("id"));
    }

    @Override
    public String subject() {
        return object.getString("subject");
    }

    @Override
    public ZonedDateTime start() {
        return DateUtils.toZonedDateTime(object.getJsonObject("start")).withZoneSameInstant(ZoneId.systemDefault());
    }

    @Override
    public ZonedDateTime end() {
        return DateUtils.toZonedDateTime(object.getJsonObject("end")).withZoneSameInstant(ZoneId.systemDefault());
    }

    @Override
    public boolean allowNewTimeProposals() {
        if( ! object.containsKey("allowNewTimeProposals") ) {
            return true;
        }
        return object.getBoolean("allowNewTimeProposals");
    }

    @Override
    public ItemBody body() {
        return new ItemBodyImpl(object.getJsonObject("body"));
    }

    
}
