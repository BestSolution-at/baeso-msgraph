package at.bestsolution.baeso.msgraph.impl.model;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import at.bestsolution.baeso.msgraph.base.ID;
import at.bestsolution.baeso.msgraph.impl.utils.DateUtils;
import at.bestsolution.baeso.msgraph.impl.utils.JsonUtils;
import at.bestsolution.baeso.msgraph.model.Attendee;
import at.bestsolution.baeso.msgraph.model.Event;
import at.bestsolution.baeso.msgraph.model.ItemBody;
import at.bestsolution.baeso.msgraph.model.Location;
import at.bestsolution.baeso.msgraph.model.OnlineMeetingInfo;
import at.bestsolution.baeso.msgraph.model.PatternedRecurrence;
import at.bestsolution.baeso.msgraph.model.Recipient;
import at.bestsolution.baeso.msgraph.model.ResponseStatus;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

public class EventImpl implements Event {
    public final JsonObject object;

    public EventImpl(JsonObject object) {
        this.object = object;
    }

    @Override
    public ID<Event> id() {
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

    @Override
    public String bodyPreview() {
        return object.getString("bodyPreview");
    }

    @Override
    public String changeKey() {
        return object.getString("changeKey");
    }

    @Override
    public ZonedDateTime createdDateTime() {
        return ZonedDateTime.parse(object.getString("createdDateTime"));
    }

    @Override
    public boolean hasAttachments() {
        return object.getBoolean("hasAttachments");
    }

    @Override
    public boolean hideAttendees() {
        return object.getBoolean("hideAttendees");
    }

    @Override
    public String iCalUId() {
        return object.getString("iCalUId");
    }

    @Override
    public Importance importance() {
        return Importance.of(object.getString("importance"));
    }

    @Override
    public boolean isAllDay() {
        return object.getBoolean("isAllDay");
    }

    @Override
    public boolean isCancelled() {
        return object.getBoolean("isCancelled");
    }

    @Override
    public boolean isDraft() {
        return object.getBoolean("isDraft");
    }

    @Override
    public boolean isOnlineMeeting() {
        return object.getBoolean("isOnlineMeeting");
    }

    @Override
    public boolean isOrganizer() {
        return object.getBoolean("isOrganizer");
    }

    @Override
    public boolean isReminderOn() {
        return object.getBoolean("isReminderOn");
    }

    @Override
    public ZonedDateTime lastModifiedDateTime() {
        return ZonedDateTime.parse(object.getString("lastModifiedDateTime"));
    }

    @Override
    public List<Attendee> attendees() {
        var attendees = object.getJsonArray("attendees");
        return attendees.stream()
            .map(JsonObject.class::cast)
            .map(AttendeeImpl::new)
            .map(Attendee.class::cast)
            .toList();
    }

    @Override
    public boolean responseRequested() {
        return object.getBoolean("responseRequested", false);
    }

    @Override
    public PatternedRecurrence recurrence() {
        return new PatternedRecurrenceImpl(object.getJsonObject("recurrence"));
    }

    @Override
    public Location location() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'locations'");
    }

    @Override
    public List<Location> locations() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'locations'");
    }

    @Override
    public OnlineMeetingInfo onlineMeeting() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onlineMeeting'");
    }

    @Override
    public OnlineMeetingProviderType onlineMeetingProvider() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onlineMeetingProvider'");
    }

    @Override
    public String onlineMeetingUrl() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onlineMeetingUrl'");
    }

    @Override
    public Recipient organizer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'organizer'");
    }

    @Override
    public String originalEndTimeZone() {
        return object.getString("originalEndTimeZone");
    }

    @Override
    public ZonedDateTime originalStart() {
        return ZonedDateTime.parse(object.getString("originalStart"));
    }

    @Override
    public String originalStartTimeZone() {
        return object.getString("originalStartTimeZone");
    }

    @Override
    public int reminderMinutesBeforeStart() {
        return object.getInt("reminderMinutesBeforeStart");
    }

    @Override
    public ResponseStatus responseStatus() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'responseStatus'");
    }

    @Override
    public Sensitivity sensitivity() {
        return Sensitivity.of(object.getString("sensitivity"));
    }

    @Override
    public ID<Event> seriesMasterId() {
        if( object.isNull("seriesMasterId") ){
            return null;
        }
        return ID.of(object.getString("seriesMasterId"));
    }

    @Override
    public ShowAs showAs() {
        return ShowAs.of(object.getString("showAs"));
    }

    @Override
    public String transactionId() {
        return object.getString("transactionId");
    }

    @Override
    public Type type() {
        return Type.of(object.getString("type"));
    }

    @Override
    public String webLink() {
        return object.getString("webLink");
    }

    @Override
    public List<String> categories() {
        return object.getJsonArray("categories").stream()
            .map(e -> e.toString())
            .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public String toString() {
        return JsonUtils.stringify(object, true);
    }

    public static class EventBuilderImpl implements Builder {
        private JsonObjectBuilder builder = Json.createObjectBuilder();

        @Override
        public Builder start(ZonedDateTime start) {
            builder.add("start", DateUtils.toDateTimeTimeZone(start));
            return this;
        }

        @Override
        public Builder end(ZonedDateTime end) {
            builder.add("end", DateUtils.toDateTimeTimeZone(end));
            return this;
        }

        @Override
        public Builder subject(String subject) {
            builder.add("subject", subject);
            return this;
        }

        @Override
        public Builder allowNewTimeProposals(boolean allowNewTimeProposals) {
            builder.add("allowNewTimeProposals", allowNewTimeProposals);
            return this;
        }

        @Override
        public Builder attendees(List<Attendee> attendees) {
            var array = attendees.stream()
                .map(AttendeeImpl.class::cast)
                .map(e -> e.object)
                .collect(JsonUtils.toArray());
            builder.add("attendees", array);
            return this;
        }

        @Override
        public Builder withAttendees(int count,
                Function<at.bestsolution.baeso.msgraph.model.Attendee.Builder, Attendee> builder) {
            return attendees(IntStream.of(count).mapToObj( v -> builder.apply(new AttendeeImpl.AttendeeBuilderImpl()) ).collect(Collectors.toList()));
        }

        @Override
        public <T> Builder withAttendees(List<T> input,
                BiFunction<at.bestsolution.baeso.msgraph.model.Attendee.Builder, T, Attendee> builder) {
            return attendees(input.stream().map( v -> builder.apply(new AttendeeImpl.AttendeeBuilderImpl(), v)).collect(Collectors.toList()));
        }

        @Override
        public Builder responseRequested(boolean responseRequested) {
            builder.add("responseRequested", responseRequested);
            return this;
        }

        @Override
        public Builder recurrence(PatternedRecurrence recurrence) {
            builder.add("recurrence", ((PatternedRecurrenceImpl)recurrence).object);
            return this;
        }

        @Override
        public Builder withRecurrence(Function<PatternedRecurrence.Builder, PatternedRecurrence> builder) {
            return recurrence(builder.apply(new PatternedRecurrenceImpl.PatternedRecurrenceBuilderImpl()));
        }

        public Event build() {
            return new EventImpl(builder.build());
        }
    }
}
