package at.bestsolution.baeso.msgraph;

import at.bestsolution.baeso.msgraph.base.ID;
import at.bestsolution.baeso.msgraph.base.Query;
import at.bestsolution.baeso.msgraph.model.User;

public interface UserResource {
	public interface Q extends Query<User> {
		
	}
	
	public CalendarResource calendars(ID<User> user);
	
	public Q query();
}
