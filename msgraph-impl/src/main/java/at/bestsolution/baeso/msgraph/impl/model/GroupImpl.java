package at.bestsolution.baeso.msgraph.impl.model;

import at.bestsolution.baeso.msgraph.base.ID;
import at.bestsolution.baeso.msgraph.impl.utils.JsonUtils;
import at.bestsolution.baeso.msgraph.model.Group;
import jakarta.json.JsonObject;

public class GroupImpl implements Group {

    private JsonObject object;

    public GroupImpl(JsonObject object) {
        this.object = object;
    }

    @Override
    public String description() {
        return object.getString("description");
    }

    @Override
    public String displayName() {
        return object.getString("displayName");
    }

    @Override
    public ID<Group> id() {
        return ID.of(object.getString("id"));
    }

    @Override
    public String toString() {
        return JsonUtils.stringify(object, true);
    }
}
