package at.bestsolution.baeso.msgraph.impl.model;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.json.JsonValue;

import at.bestsolution.baeso.msgraph.impl.utils.JsonUtils;
import at.bestsolution.baeso.msgraph.model.EventForward;
import at.bestsolution.baeso.msgraph.model.Recipient;

public class EventForwardImpl implements EventForward {
    public final JsonObject object;

    public EventForwardImpl(JsonObject object) {
        this.object = object;
    }

    @Override
    public String comment() {
        return object.getString("Comment");
    }

    @Override
    public List<Recipient> toRecipients() {
        return object.getJsonArray("ToRecipients").stream()
            .map(JsonValue::asJsonObject)
            .map(RecipientImpl::new)
            .collect(Collectors.toUnmodifiableList());
    }
    
    public static class EventForwardBuilderImpl implements EventForward.Builder {
        private JsonObjectBuilder builder = Json.createObjectBuilder();

        @Override
        public EventForward build() {
            return new EventForwardImpl(builder.build());
        }

        @Override
        public Builder comment(String comment) {
            builder.add("Comment", comment);
            return this;
        }

        @Override
        public Builder toRecipients(List<Recipient> toRecipients) {
            var array = toRecipients.stream()
                .map(RecipientImpl.class::cast)
                .map( e -> e.object)
                .collect(JsonUtils.toArray());
            builder.add("ToRecipients", array);
            return this;
        }

    }
}
