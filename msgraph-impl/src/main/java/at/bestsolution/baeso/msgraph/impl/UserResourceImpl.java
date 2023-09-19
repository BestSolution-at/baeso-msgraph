package at.bestsolution.baeso.msgraph.impl;

import at.bestsolution.baeso.msgraph.CalendarGroupResource;
import at.bestsolution.baeso.msgraph.CalendarResource;
import at.bestsolution.baeso.msgraph.CalendarsResource;
import at.bestsolution.baeso.msgraph.UserResource;
import at.bestsolution.baeso.msgraph.base.ID;
import at.bestsolution.baeso.msgraph.model.Calendar;

public class UserResourceImpl implements UserResource {
	private final GraphClientImpl client;
	private final String baseUrl;
	
	public UserResourceImpl(GraphClientImpl client, String baseUrl) {
		this.client = client;
		this.baseUrl = baseUrl;
	}

	@Override
	public CalendarsResource calendars() {
		return new CalendarsResourceImpl(this.client, this.baseUrl + "/calendars");
	}
	
	@Override
	public CalendarGroupResource calendarGroups() {
		return new CalendarGroupResourceImpl(this.client, this.baseUrl + "/calendarGroups");
	}
}
