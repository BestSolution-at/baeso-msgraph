package at.bestsolution.baeso.msgraph.impl.model;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

import at.bestsolution.baeso.msgraph.model.EmailAddress;

public class EmailAddressImpl implements EmailAddress {
    public final JsonObject object;

    public EmailAddressImpl(JsonObject object) {
        this.object = object;
    }

    @Override
    public String address() {
        return object.getString("address");
    }

    @Override
    public String name() {
        return object.getString("name");
    }
    
    public static class EmailAddressBuilderImpl implements EmailAddress.Builder {
        private JsonObjectBuilder builder = Json.createObjectBuilder();

        @Override
        public Builder address(String address) {
            builder.add("address", address);
            return this;
        }

        @Override
        public Builder name(String name) {
            builder.add("name", name);
            return this;
        }

        @Override
        public EmailAddress build() {
            return new EmailAddressImpl(builder.build());
        }
    }
}
