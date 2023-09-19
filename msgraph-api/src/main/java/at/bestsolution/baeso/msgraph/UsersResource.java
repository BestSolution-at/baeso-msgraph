package at.bestsolution.baeso.msgraph;

import at.bestsolution.baeso.msgraph.base.ID;
import at.bestsolution.baeso.msgraph.base.Query;
import at.bestsolution.baeso.msgraph.model.User;

public interface UsersResource {
    public interface UserQuery extends Query<User> {
		
	}

    public UserResource user(ID<User> user);
    public UserResource user(String userPrincipalName);

    public UserQuery query();
}
