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
    
    public static class TimeSlotBuilderImpl extends BaseBuilderImpl implements TimeSlot.Builder {

        @Override
        public TimeSlot build() {
            return new TimeSlotImpl(builder.build());
        }

        @Override
        public Builder end(ZonedDateTime end) {
            builder.add("end", end.toString());
            return this;
        }

        @Override
        public Builder start(ZonedDateTime start) {
            builder.add("start", start.toString());
            return this;
        }

    }
}
