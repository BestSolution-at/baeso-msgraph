package at.bestsolution.baeso.msgraph;

import at.bestsolution.baeso.msgraph.base.ID;
import at.bestsolution.baeso.msgraph.base.Query;
import at.bestsolution.baeso.msgraph.model.Group;

public interface GroupsResource {
    public interface GroupQuery extends Query<Group> {
    }

    public GroupResource group(ID<Group> group);
    public GroupQuery query();
}
