package at.bestsolution.baeso.msgraph.model;

import at.bestsolution.baeso.msgraph.base.ID;

public interface User {
	public ID<User> id();
	public String userPrincipalName();
}
