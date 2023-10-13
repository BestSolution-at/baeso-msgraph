package at.bestsolution.baeso.msgraph.impl.model;

import java.time.ZonedDateTime;

import at.bestsolution.baeso.msgraph.model.EventSnoozeReminder;
import jakarta.json.JsonObject;

public class EventSnoozeReminderImpl extends BaseImpl implements EventSnoozeReminder {

    public EventSnoozeReminderImpl(JsonObject object) {
        super(object);
    }

    @Override
    public ZonedDateTime newReminderTime() {
        return ZonedDateTime.parse(object.getString("newReminderTime"));
    }
    
    public static class EventSnoozeReminderBuilderImpl extends BaseImpl.BaseBuilderImpl implements EventSnoozeReminder.Builder {

        @Override
        public EventSnoozeReminder build() {
            return new EventSnoozeReminderImpl(builder.build());
        }

        @Override
        public Builder newReminderTime(ZonedDateTime newReminderTime) {
            builder.add("newReminderTime", newReminderTime.toString());
            return this;
        }

    }
}
