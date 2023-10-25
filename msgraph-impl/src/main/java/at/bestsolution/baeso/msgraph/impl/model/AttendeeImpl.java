package at.bestsolution.baeso.msgraph.impl.model;

import java.util.function.Function;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;

import at.bestsolution.baeso.msgraph.impl.utils.JsonUtils;
import at.bestsolution.baeso.msgraph.model.Attendee;
import at.bestsolution.baeso.msgraph.model.EmailAddress;
import at.bestsolution.baeso.msgraph.model.ResponseStatus;
import at.bestsolution.baeso.msgraph.model.TimeSlot;

public class AttendeeImpl implements Attendee {
    public final JsonObject object;

    public AttendeeImpl(JsonObject object) {
        this.object = object;
    }

    @Override
    public EmailAddress emailAddress() {
        return new EmailAddressImpl(object.getJsonObject("emailAddress"));
    }

    @Override
    public Type type() {
        return Type.of(object.getString("type"));
    }

    @Override
    public String toString() {
        return JsonUtils.stringify(object, true);
    }

    @Override
    public TimeSlot proposedNewTime() {
        if( ! object.containsKey("proposedNewTime") ) {
            return null;
        }
        return new TimeSlotImpl(object.getJsonObject("proposedNewTime"));
    }

    @Override
    public ResponseStatus status() {
        if( ! object.containsKey("status") ) {
            return null;
        }
        return new ResponseStatusImpl(object.getJsonObject("status"));
    }

    public static class AttendeeBuilderImpl implements Attendee.Builder {
        private JsonObjectBuilder builder = Json.createObjectBuilder();

        @Override
        public Builder emailAddress(EmailAddress emailAddress) {
            builder.add("emailAddress", ((EmailAddressImpl)emailAddress).object);
            return this;
        }

        @Override
        public Builder withEmailAddress(Function<at.bestsolution.baeso.msgraph.model.EmailAddress.Builder, EmailAddress> builder) {
            return emailAddress(builder.apply(new EmailAddressImpl.EmailAddressBuilderImpl()));
        }

        @Override
        public Builder type(Type type) {
            builder.add("type", type.value());
            return this;
        }

        @Override
        public Attendee build() {
            return new AttendeeImpl(builder.build());
        }

        @Override
        public Builder proposedNewTime(TimeSlot proposedNewTime) {
            builder.add("proposedNewTime", ((TimeSlotImpl)proposedNewTime).object);
            return this;
        }

        @Override
        public Builder withProposedNewTime(
                Function<at.bestsolution.baeso.msgraph.model.TimeSlot.Builder, TimeSlot> builder) {
            return proposedNewTime(builder.apply(new TimeSlotImpl.TimeSlotBuilderImpl()));
        }

        @Override
        public Builder status(ResponseStatus status) {
            builder.add("status", ((ResponseStatusImpl)status).object);
            return this;
        }

        @Override
        public Builder withStatus(
                Function<at.bestsolution.baeso.msgraph.model.ResponseStatus.Builder, ResponseStatus> builder) {
            return status(builder.apply(new ResponseStatusImpl.ResponseStatusBuilderImpl()));
        }
    }

}
