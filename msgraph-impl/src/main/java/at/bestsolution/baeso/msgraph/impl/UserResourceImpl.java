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
	private final String baseUrl = "https://graph.microsoft.com/v1.0/users";

	private final GraphClientImpl client;
	
	public UserResourceImpl(GraphClientImpl client) {
		this.client = client;
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

	@Override
	public CalendarResource calendars(ID<User> user) {
		return new CalendarResourceImpl(this.client, user.id);
	}
	
	@Override
	public CalendarResource calendars(String userPrincipalName) {
		return new CalendarResourceImpl(this.client, userPrincipalName);
	}

	@Override
	public CalendarGroupResource calendarGroups(ID<User> user) {
		return new CalendarGroupResourceImpl(this.client, user.id);
	}

	@Override
	public CalendarGroupResource calendarsGroups(String userPrincipalName) {
		return new CalendarGroupResourceImpl(this.client, userPrincipalName);
	}
}
