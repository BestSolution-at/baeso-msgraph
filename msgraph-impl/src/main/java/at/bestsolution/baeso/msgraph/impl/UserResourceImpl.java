package at.bestsolution.baeso.msgraph.impl;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import at.bestsolution.baeso.msgraph.CalendarGroupResource;
import at.bestsolution.baeso.msgraph.CalendarResource;
import at.bestsolution.baeso.msgraph.UserResource;
import at.bestsolution.baeso.msgraph.base.ID;
import at.bestsolution.baeso.msgraph.impl.model.UserImpl;
import at.bestsolution.baeso.msgraph.impl.utils.PagingSpliterator;
import at.bestsolution.baeso.msgraph.impl.utils.QueryImpl;
import at.bestsolution.baeso.msgraph.impl.utils.QueryParam;
import at.bestsolution.baeso.msgraph.model.User;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.stream.JsonGenerator;

public class UserResourceImpl implements UserResource {
	private final GraphClientImpl client;
	private final String baseUrl;
	
	public UserResourceImpl(GraphClientImpl client, String baseUrl) {
		this.client = client;
		this.baseUrl = baseUrl;
	}

	@Override
	public CalendarResource calendars() {
		return new CalendarResourceImpl(this.client, this.baseUrl + "/calendars");
	}
	
	@Override
	public CalendarGroupResource calendarGroups() {
		return new CalendarGroupResourceImpl(this.client, this.baseUrl + "/calendarGroups");
	}
}
