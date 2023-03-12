package at.bestsolution.baeso.msgraph.impl.model;

import at.bestsolution.baeso.msgraph.base.ID;
import at.bestsolution.baeso.msgraph.model.User;
import javax.json.JsonObject;

public class UserImpl implements User {
	private JsonObject object;
	
	public UserImpl(JsonObject object) {
		this.object = object;
	}
	
	@Override
	public ID<User> id() {
		return ID.of(object.getString("id"));
	}

	@Override
	public String userPrincipalName() {
		return object.getString("userPrincipalName");
	}

}
