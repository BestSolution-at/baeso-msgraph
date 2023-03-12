package at.bestsolution.baeso.msgraph.impl.model;

import java.io.StringWriter;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Map;

import at.bestsolution.baeso.msgraph.base.ID;
import at.bestsolution.baeso.msgraph.impl.utils.DateUtils;
import at.bestsolution.baeso.msgraph.impl.utils.JsonUtils;
import at.bestsolution.baeso.msgraph.model.Event;
import at.bestsolution.baeso.msgraph.model.ItemBody;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.stream.JsonGenerator;

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
    public String toString() {
        return JsonUtils.stringify(object, true);
    }

    public static class EventBuilderImpl implements Builder {
        private ZonedDateTime start;
        private ZonedDateTime end;
        private String subject;
        private boolean allowNewTimeProposals;

        @Override
        public Builder start(ZonedDateTime start) {
            this.start = start;
            return this;
        }

        @Override
        public Builder end(ZonedDateTime end) {
            this.end = end;
            return this;
        }

        @Override
        public Builder subject(String subject) {
            this.subject = subject;
            return this;
        }

        @Override
        public Builder allowNewTimeProposals(boolean allowNewTimeProposals) {
            this.allowNewTimeProposals = allowNewTimeProposals;
            return this;
        }

        public Event build() {
            var builder = Json.createObjectBuilder();
            builder.add("start", DateUtils.toDateTimeTimeZone(start));
            builder.add("end", DateUtils.toDateTimeTimeZone(end));
            builder.add("subject", subject);
            builder.add("allowNewTimeProposals", allowNewTimeProposals);
            return new EventImpl(builder.build());
        }
    }
}
