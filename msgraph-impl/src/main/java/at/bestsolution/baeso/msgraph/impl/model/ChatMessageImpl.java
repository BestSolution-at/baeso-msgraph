package at.bestsolution.baeso.msgraph.impl.model;

import at.bestsolution.baeso.msgraph.base.ID;
import at.bestsolution.baeso.msgraph.impl.utils.JsonUtils;
import at.bestsolution.baeso.msgraph.model.ChatMessage;
import jakarta.json.JsonObject;

public class ChatMessageImpl extends BaseImpl implements ChatMessage {

    public ChatMessageImpl(JsonObject object) {
        super(object);
    }

    @Override
    public ID<ChatMessage> id() {
        return ID.of(object.getString("id"));
    }

    @Override
    public String toString() {
        return JsonUtils.stringify(object, true);
    }
}
