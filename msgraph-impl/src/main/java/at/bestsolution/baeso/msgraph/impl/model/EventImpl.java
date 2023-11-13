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
        return object.getString("bodyPreview", null);
    }

    @Override
    public String changeKey() {
        return object.getString("changeKey", null);
    }

    @Override
    public ZonedDateTime createdDateTime() {
        return ZonedDateTime.parse(object.getString("createdDateTime"));
    }

    @Override
    public boolean hasAttachments() {
        return object.getBoolean("hasAttachments", false);
    }

    @Override
    public boolean hideAttendees() {
        return object.getBoolean("hideAttendees", false);
    }

    @Override
    public String iCalUId() {
        return object.getString("iCalUId", null);
    }

    @Override
    public Importance importance() {
        return JsonUtils.mapString(object, "importance", Importance::of, Importance.NORMAL);
    }

    @Override
    public boolean isAllDay() {
        return object.getBoolean("isAllDay", false);
    }

    @Override
    public boolean isCancelled() {
        return object.getBoolean("isCancelled", false);
    }

    @Override
    public boolean isDraft() {
        return object.getBoolean("isDraft", false);
    }

    @Override
    public boolean isOnlineMeeting() {
        return object.getBoolean("isOnlineMeeting", false);
    }

    @Override
    public boolean isOrganizer() {
        return object.getBoolean("isOrganizer", false);
    }

    @Override
    public boolean isReminderOn() {
        return object.getBoolean("isReminderOn", false);
    }

    @Override
    public ZonedDateTime lastModifiedDateTime() {
        return JsonUtils.mapString(object, "lastModifiedDateTime", ZonedDateTime::parse);
    }

    @Override
    public List<Attendee> attendees() {
        return JsonUtils.mapObjects(object, "attendees", AttendeeImpl::new);
    }

    @Override
    public boolean responseRequested() {
        return object.getBoolean("responseRequested", false);
    }

    @Override
    public PatternedRecurrence recurrence() {
        return JsonUtils.mapObject(object, "recurrence", PatternedRecurrenceImpl::new);
    }

    @Override
    public Location location() {
        return JsonUtils.mapObject(object, "location", LocationImpl::new);
    }

    @Override
    public List<Location> locations() {
        return JsonUtils.mapObjects(object, "locations", LocationImpl::new);
    }

    @Override
    public OnlineMeetingInfo onlineMeeting() {
        return JsonUtils.mapObject(object, "onlineMeeting", OnlineMeetingInfoImpl::new);
    }

    @Override
    public OnlineMeetingProviderType onlineMeetingProvider() {
        return JsonUtils.mapString(object, "onlineMeetingProvider", OnlineMeetingProviderType::of, OnlineMeetingProviderType.UNKNOWN);
    }

    @Override
    public String onlineMeetingUrl() {
        return object.getString("onlineMeetingUrl", null);
    }

    @Override
    public Recipient organizer() {
        return JsonUtils.mapObject(object, "organizer", RecipientImpl::new);
    }

    @Override
    public String originalEndTimeZone() {
        return object.getString("originalEndTimeZone", null);
    }

    @Override
    public ZonedDateTime originalStart() {
        return JsonUtils.mapString(object, "originalStart", ZonedDateTime::parse);
    }

    @Override
    public String originalStartTimeZone() {
        return object.getString("originalStartTimeZone", null);
    }

    @Override
    public int reminderMinutesBeforeStart() {
        return object.getInt("reminderMinutesBeforeStart");
    }

    @Override
    public ResponseStatus responseStatus() {
        return JsonUtils.mapObject(object, "responseStatus", ResponseStatusImpl::new);
    }

    @Override
    public Sensitivity sensitivity() {
        return JsonUtils.mapString(object, "sensitivity", Sensitivity::of, Sensitivity.NORMAL);
    }

    @Override
    public ID<Event> seriesMasterId() {
        return JsonUtils.mapString(object, "seriesMasterId", ID::of);
    }

    @Override
    public ShowAs showAs() {
        return JsonUtils.mapString(object, "showAs", ShowAs::of, ShowAs.UNKNOWN);
    }

    @Override
    public String transactionId() {
        return object.getString("transactionId", null);
    }

    @Override
    public Type type() {
        return JsonUtils.mapString(object, "type", Type::of, null);
    }

    @Override
    public String webLink() {
        return object.getString("webLink", null);
    }

    @Override
    public List<String> categories() {
        return JsonUtils.mapStrings(object, "categories");
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
