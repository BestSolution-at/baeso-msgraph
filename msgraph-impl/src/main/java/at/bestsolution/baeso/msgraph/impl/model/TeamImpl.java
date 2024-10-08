package at.bestsolution.baeso.msgraph.impl.model;

import at.bestsolution.baeso.msgraph.base.ID;
import at.bestsolution.baeso.msgraph.impl.utils.JsonUtils;
import at.bestsolution.baeso.msgraph.model.Team;
import jakarta.json.JsonObject;

public class TeamImpl extends BaseImpl implements Team {

    public TeamImpl(JsonObject object) {
        super(object);
    }

    @Override
    public ID<Team> id() {
        return ID.of(object.getString("id"));
    }

    @Override
    public String displayName() {
        return object.getString("displayName");
    }

    @Override
    public String toString() {
        return JsonUtils.stringify(object, true);
    }
}
