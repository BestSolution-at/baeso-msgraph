package at.bestsolution.baeso.msgraph;

import at.bestsolution.baeso.msgraph.base.ID;
import at.bestsolution.baeso.msgraph.model.Calendar;
import at.bestsolution.baeso.msgraph.model.User;

public interface UserResource {	
	public CalendarsResource calendars();
	public default CalendarResource calendar(ID<Calendar> id) {
		return calendars().calendar(id);
	}
	
	public CalendarGroupResource calendarGroups();

	public User get();
}
