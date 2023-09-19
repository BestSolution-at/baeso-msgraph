package at.bestsolution.baeso.msgraph.impl.model;

import java.time.ZonedDateTime;
import java.util.List;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

import at.bestsolution.baeso.msgraph.impl.utils.DateUtils;
import at.bestsolution.baeso.msgraph.impl.utils.JsonUtils;
import at.bestsolution.baeso.msgraph.model.Attendee;
import at.bestsolution.baeso.msgraph.model.Event.OnlineMeetingProviderType;
import at.bestsolution.baeso.msgraph.model.Event.Sensitivity;
import at.bestsolution.baeso.msgraph.model.Event.ShowAs;
import at.bestsolution.baeso.msgraph.model.EventUpdate;
import at.bestsolution.baeso.msgraph.model.ItemBody;
import at.bestsolution.baeso.msgraph.model.Location;
import at.bestsolution.baeso.msgraph.model.PatternedRecurrence;

public class EventUpdateImpl implements EventUpdate {
    public final JsonObject object;

    public EventUpdateImpl(JsonObject object) {
        this.object = object;
    }

    @Override
    public List<Attendee> attendees() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'attendees'");
    }

    @Override
    public ItemBody body() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'body'");
    }

    @Override
    public List<String> categories() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'categories'");
    }

    @Override
    public ZonedDateTime end() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'end'");
    }

    @Override
    public boolean hideAttendees() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hideAttendees'");
    }

    @Override
    public boolean importance() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'importance'");
    }

    @Override
    public boolean isAllDay() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isAllDay'");
    }

    @Override
    public boolean isOnlineMeeting() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isOnlineMeeting'");
    }

    @Override
    public boolean isReminderOn() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isReminderOn'");
    }

    @Override
    public Location location() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'location'");
    }

    @Override
    public List<Location> locations() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'locations'");
    }

    @Override
    public OnlineMeetingProviderType onlineMeetingProvider() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onlineMeetingProvider'");
    }

    @Override
    public PatternedRecurrence recurrence() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'recurrence'");
    }

    @Override
    public int reminderMinutesBeforeStart() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reminderMinutesBeforeStart'");
    }

    @Override
    public boolean responseRequested() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'responseRequested'");
    }

    @Override
    public Sensitivity sensitivity() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sensitivity'");
    }

    @Override
    public ShowAs showAs() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'showAs'");
    }

    @Override
    public ZonedDateTime start() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'start'");
    }

    @Override
    public String subject() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'subject'");
    }
    
    public static class EventUpdateBuilderImpl implements EventUpdate.Builder {
        private final JsonObjectBuilder builder = Json.createObjectBuilder();

        @Override
        public EventUpdate build() {
            return new EventUpdateImpl(builder.build());
        }

        @Override
        public Builder attendees(List<Attendee> attendees) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'attendees'");
        }

        @Override
        public Builder body(ItemBody body) {
            builder.add("body", ((ItemBodyImpl)body).object);
            return this;
        }

        @Override
        public Builder categories(List<String> categories) {
            builder.add("categories", categories.stream().collect(JsonUtils.toStringArray()));
            return this;
        }

        @Override
        public Builder end(ZonedDateTime end) {
            builder.add("end", DateUtils.toDateTimeTimeZone(end));
            return this;
        }

        @Override
        public Builder hideAttendees(boolean hideAttendees) {
            builder.add("hideAttendees", hideAttendees);
            return this;
        }

        @Override
        public Builder importance(boolean importance) {
            builder.add("importance", importance);
            return this;
        }

        @Override
        public Builder isAllDay(boolean isAllDay) {
            builder.add("isAllDay", isAllDay);
            return this;
        }

        @Override
        public Builder isOnlineMeeting(boolean isOnlineMeeting) {
            builder.add("isOnlineMeeting", isOnlineMeeting);
            return this;
        }

        @Override
        public Builder isReminderOn(boolean isReminderOn) {
            builder.add("isReminderOn", isReminderOn);
            return this;
        }

        @Override
        public Builder location(Location location) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'location'");
        }

        @Override
        public Builder locations(List<Location> locations) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'locations'");
        }

        @Override
        public Builder onlineMeetingProvider(OnlineMeetingProviderType onlineMeetingProvider) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'onlineMeetingProvider'");
        }

        @Override
        public Builder recurrence(PatternedRecurrence recurrence) {
            builder.add("recurrence", ((PatternedRecurrenceImpl)recurrence).object);
            return this;
        }

        @Override
        public Builder reminderMinutesBeforeStart(int reminderMinutesBeforeStart) {
            builder.add("reminderMinutesBeforeStart", reminderMinutesBeforeStart);
            return this;
        }

        @Override
        public Builder responseRequested(boolean responseRequested) {
            builder.add("responseRequested", responseRequested);
            return this;
        }

        @Override
        public Builder sensitivity(Sensitivity sensitivity) {
            builder.add("sensitivity", sensitivity.value());
            return this;
        }

        @Override
        public Builder showAs(ShowAs showAs) {
            builder.add("showAs", showAs.value());
            return this;
        }

        @Override
        public Builder start(ZonedDateTime start) {
            builder.add("start", DateUtils.toDateTimeTimeZone(start));
            return this;
        }

        @Override
        public Builder subject(String subject) {
            builder.add("subject", subject);
            return this;
        }
    }
}
