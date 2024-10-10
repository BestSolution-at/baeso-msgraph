package at.bestsolution.baeso.msgraph.impl.model;

import java.util.function.Function;

import at.bestsolution.baeso.msgraph.base.ID;
import at.bestsolution.baeso.msgraph.impl.utils.JsonUtils;
import at.bestsolution.baeso.msgraph.model.ChatMessage;
import at.bestsolution.baeso.msgraph.model.ItemBody;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;

public class ChatMessageImpl extends BaseImpl implements ChatMessage {

    public ChatMessageImpl(JsonObject object) {
        super(object);
    }

    @Override
    public ID<ChatMessage> id() {
        return ID.of(object.getString("id"));
    }

    @Override
    public ItemBody body() {
        return new ItemBodyImpl(object.getJsonObject("body"));
    }

    @Override
    public String subject() {
        return object.getString("subject");
    }

    @Override
    public String toString() {
        return JsonUtils.stringify(object, true);
    }

    public static class ChatMessageBuilderImpl implements Builder {
        private JsonObjectBuilder builder = Json.createObjectBuilder();

        @Override
        public Builder body(ItemBody body) {
            builder.add("body", ((ItemBodyImpl)body).object);
            return this;
        }

        @Override
        public Builder withBody(Function<at.bestsolution.baeso.msgraph.model.ItemBody.Builder, ItemBody> builder) {
            return body(builder.apply(new ItemBodyImpl.ItemBodyBuilderImpl()));
        }

        @Override
        public Builder subject(String subject) {
            builder.add("subject", subject);
            return this;
        }

        @Override
        public ChatMessage build() {
            return new ChatMessageImpl(builder.build());
        }
    }
}
