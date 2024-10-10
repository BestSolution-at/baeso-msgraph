package at.bestsolution.baeso.msgraph.impl.model;

import at.bestsolution.baeso.msgraph.model.ItemBody;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;

public class ItemBodyImpl implements ItemBody {
    public final JsonObject object;

    public ItemBodyImpl(JsonObject object) {
        this.object = object;
    }

    @Override
    public String content() {
        return object.getString("content");
    }

    @Override
    public String contentType() {
        return object.getString("contentType");
    }

    public static class ItemBodyBuilderImpl implements Builder {
        private JsonObjectBuilder builder = Json.createObjectBuilder();

        @Override
        public Builder content(String content) {
            builder.add("content", content);
            return this;
        }

        @Override
        public Builder contentType(String contentType) {
            builder.add("contentType", contentType);
            return this;
        }

        @Override
        public ItemBody build() {
            return new ItemBodyImpl(builder.build());
        }
    }
}
