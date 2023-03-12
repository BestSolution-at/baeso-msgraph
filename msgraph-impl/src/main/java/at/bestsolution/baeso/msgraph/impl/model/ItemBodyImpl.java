package at.bestsolution.baeso.msgraph.impl.model;

import at.bestsolution.baeso.msgraph.model.ItemBody;
import javax.json.JsonObject;

public class ItemBodyImpl implements ItemBody {
    private final JsonObject object;

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
}
