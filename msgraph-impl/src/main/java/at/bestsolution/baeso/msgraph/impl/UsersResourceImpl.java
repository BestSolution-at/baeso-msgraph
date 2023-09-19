package at.bestsolution.baeso.msgraph.impl;

import at.bestsolution.baeso.msgraph.UserResource;
import at.bestsolution.baeso.msgraph.UsersResource;
import at.bestsolution.baeso.msgraph.base.ID;
import at.bestsolution.baeso.msgraph.impl.model.UserImpl;
import at.bestsolution.baeso.msgraph.impl.utils.QueryImpl;
import at.bestsolution.baeso.msgraph.model.User;

public class UsersResourceImpl implements UsersResource {
    private final String baseUrl = "https://graph.microsoft.com/v1.0/users";
    private final GraphClientImpl client;

    public UsersResourceImpl(GraphClientImpl client) {
        this.client = client;
    }

    @Override
    public UserResource user(ID<User> user) {
        return new UserResourceImpl(client, baseUrl + "/" + user.id);
    }

    @Override
    public UserResource user(String userPrincipalName) {
        return new UserResourceImpl(client, baseUrl + "/" + userPrincipalName);
    }

    @Override
    public UserQuery query() {
        return new UserQueryImpl(baseUrl, client);
    }

    static class UserQueryImpl extends QueryImpl<User> implements UserQuery {

        public UserQueryImpl(String baseUrl, GraphClientImpl client) {
            super(baseUrl, client, UserImpl::new);
        }
    }

}
