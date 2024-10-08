package at.bestsolution.baeso.msgraph.impl.model;

import at.bestsolution.baeso.msgraph.base.ID;
import at.bestsolution.baeso.msgraph.impl.utils.JsonUtils;
import at.bestsolution.baeso.msgraph.model.Channel;
import jakarta.json.JsonObject;

public class ChannelImpl extends BaseImpl implements Channel {

    public ChannelImpl(JsonObject object) {
        super(object);
    }

    @Override
    public ID<Channel> id() {
        return ID.of(object.getString("id"));
    }

    @Override
    public String toString() {
        return JsonUtils.stringify(object, true);
    }
}
