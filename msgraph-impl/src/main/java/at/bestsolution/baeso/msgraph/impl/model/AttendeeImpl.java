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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'proposedNewTime'");
    }

    @Override
    public ResponseStatus status() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'status'");
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
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'proposedNewTime'");
        }

        @Override
        public Builder withProposedNewTime(
                Function<at.bestsolution.baeso.msgraph.model.TimeSlot.Builder, TimeSlot> builder) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'withProposedNewTime'");
        }

        @Override
        public Builder status(ResponseStatus status) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'status'");
        }

        @Override
        public Builder withStatus(
                Function<at.bestsolution.baeso.msgraph.model.ResponseStatus.Builder, ResponseStatus> builder) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'withStatus'");
        }
    }

}
