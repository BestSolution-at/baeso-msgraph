package at.bestsolution.baeso.msgraph.impl.model;

import java.time.ZonedDateTime;

import at.bestsolution.baeso.msgraph.model.TimeSlot;
import jakarta.json.JsonObject;

public class TimeSlotImpl extends BaseImpl implements TimeSlot {

    public TimeSlotImpl(JsonObject object) {
        super(object);
    }

    @Override
    public ZonedDateTime end() {
        return ZonedDateTime.parse(object.getString("end"));
    }

    @Override
    public ZonedDateTime start() {
        return ZonedDateTime.parse(object.getString("start"));
    }
    
}
