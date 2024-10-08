package at.bestsolution.baeso.msgraph.impl;

import at.bestsolution.baeso.msgraph.GroupResource;
import at.bestsolution.baeso.msgraph.GroupsResource;
import at.bestsolution.baeso.msgraph.base.ID;
import at.bestsolution.baeso.msgraph.impl.model.GroupImpl;
import at.bestsolution.baeso.msgraph.impl.utils.QueryImpl;
import at.bestsolution.baeso.msgraph.model.Group;

public class GroupsResourceImpl implements GroupsResource {
    private final String baseUrl = "https://graph.microsoft.com/v1.0/groups";
    private final GraphClientImpl client;

    public GroupsResourceImpl(GraphClientImpl client) {
        this.client = client;
    }

    @Override
    public GroupResource group(ID<Group> group) {
        return new GroupResourceImpl(client, baseUrl + "/" + group.id);
    }

    @Override
    public GroupQuery query() {
        return new GroupQueryImpl(baseUrl, client);
    }

    static class GroupQueryImpl extends QueryImpl<Group> implements GroupQuery {

        public GroupQueryImpl(String baseUrl, GraphClientImpl client) {
            super(baseUrl, client, GroupImpl::new);
        }
    }
}
