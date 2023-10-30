package at.bestsolution.baeso.msgraph.impl.model;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

import at.bestsolution.baeso.msgraph.base.ID;
import at.bestsolution.baeso.msgraph.base.IndexBuilderFunction;
import at.bestsolution.baeso.msgraph.impl.utils.BuilderUtils;
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

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;

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
        return DateUtils.toZonedDateTime(object.getJsonObject("start"));
    }

    @Override
    public ZonedDateTime end() {
        return DateUtils.toZonedDateTime(object.getJsonObject("end"));
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
        return new RecipientImpl(object.getJsonObject("organizer"));
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
        if( ! object.containsKey("responseStatus") ) {
            return null;
        }
        return new ResponseStatusImpl(object.getJsonObject("responseStatus"));
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
                IndexBuilderFunction<Attendee.Builder, Attendee> builder) {
            return attendees(BuilderUtils.createList(count, AttendeeImpl.AttendeeBuilderImpl::new, builder));
        }

        @Override
        public Builder withAttendeesSingle(
                Function<Attendee.Builder, Attendee> builder) {
            return attendees(List.of(builder.apply(new AttendeeImpl.AttendeeBuilderImpl())));
        }

        @Override
        public <T> Builder withAttendees(List<T> input,
                BiFunction<Attendee.Builder, T, Attendee> builder) {
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

        @Override
        public Builder isAllDay(boolean isAllDay) {
            builder.add("isAllDay", isAllDay);
            return this;
        }

        public Event build() {
            return new EventImpl(builder.build());
        }

        @Override
        public Builder body(ItemBody body) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'body'");
        }

        @Override
        public Builder withBody(Function<at.bestsolution.baeso.msgraph.model.ItemBody.Builder, ItemBody> builder) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'withBody'");
        }

        @Override
        public Builder bodyPreview(String bodyPreview) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'bodyPreview'");
        }

        @Override
        public Builder categories(List<String> categories) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'categories'");
        }

        @Override
        public Builder hideAttendees(boolean hideAttendees) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'hideAttendees'");
        }

        @Override
        public Builder importance(Importance importance) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'importance'");
        }

        @Override
        public Builder location(Location location) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'location'");
        }

        @Override
        public Builder withLocation(Function<at.bestsolution.baeso.msgraph.model.Location.Builder, Location> builder) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'withLocation'");
        }

        @Override
        public Builder onlineMeeting(OnlineMeetingInfo onlineMeeting) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'onlineMeeting'");
        }

        @Override
        public Builder withOnlineMeeting(
                Function<at.bestsolution.baeso.msgraph.model.OnlineMeetingInfo.Builder, OnlineMeetingInfo> builder) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'withOnlineMeeting'");
        }

        @Override
        public OnlineMeetingProviderType onlineMeetingProvider(OnlineMeetingProviderType onlineMeetingProvider) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'onlineMeetingProvider'");
        }

        @Override
        public String onlineMeetingUrl(String onlineMeetingUrl) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'onlineMeetingUrl'");
        }

        @Override
        public String originalEndTimeZone(String originalEndTimeZone) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'originalEndTimeZone'");
        }

        @Override
        public ZonedDateTime originalStart(ZonedDateTime originalStart) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'originalStart'");
        }

        @Override
        public String originalStartTimeZone(String originalStartTimeZone) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'originalStartTimeZone'");
        }

        @Override
        public int reminderMinutesBeforeStart(int reminderMinutesBeforeStart) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'reminderMinutesBeforeStart'");
        }

        @Override
        public Sensitivity sensitivity(Sensitivity sensitivity) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'sensitivity'");
        }

        @Override
        public ShowAs showAs(ShowAs showAs) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'showAs'");
        }

        @Override
        public String transactionId(String transactionId) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'transactionId'");
        }

        @Override
        public Type type(Type type) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'type'");
        }

        @Override
        public String webLink(String webLink) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'webLink'");
        }
        
    }
}
