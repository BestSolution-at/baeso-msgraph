package at.bestsolution.baeso.msgraph.impl.model;

import at.bestsolution.baeso.msgraph.base.ID;
import at.bestsolution.baeso.msgraph.impl.utils.JsonUtils;
import at.bestsolution.baeso.msgraph.model.ConversationThread;
import jakarta.json.JsonObject;

public class ConversationThreadImpl extends BaseImpl implements ConversationThread {

    public ConversationThreadImpl(JsonObject object) {
        super(object);
    }

    @Override
    public ID<ConversationThread> id() {
        return ID.of(object.getString("id"));
    }

    @Override
    public String toString() {
        return JsonUtils.stringify(object, true);
    }

}
