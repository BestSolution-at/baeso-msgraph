package at.bestsolution.baeso.msgraph.impl;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;

import at.bestsolution.baeso.msgraph.GraphClient;
import at.bestsolution.baeso.msgraph.UserResource;
import at.bestsolution.baeso.msgraph.UsersResource;
import at.bestsolution.baeso.msgraph.auth.AccessTokenProvider;
import at.bestsolution.baeso.msgraph.impl.model.AttendeeImpl;
import at.bestsolution.baeso.msgraph.impl.model.CalendarImpl;
import at.bestsolution.baeso.msgraph.impl.model.EmailAddressImpl;
import at.bestsolution.baeso.msgraph.impl.model.EventImpl;
import at.bestsolution.baeso.msgraph.impl.model.EventUpdateImpl;
import at.bestsolution.baeso.msgraph.impl.utils.JsonUtils;
import at.bestsolution.baeso.msgraph.model.Attendee;
import at.bestsolution.baeso.msgraph.model.Calendar;
import at.bestsolution.baeso.msgraph.model.EmailAddress;
import at.bestsolution.baeso.msgraph.model.Event;
import at.bestsolution.baeso.msgraph.model.EventUpdate;

import javax.json.Json;
import javax.json.JsonObject;

public class GraphClientImpl implements GraphClient {
	final AccessTokenProvider provider;
	private final HttpClient client;
	
	public GraphClientImpl(AccessTokenProvider provider) {
		this.provider = provider;
		this.client = HttpClient.newHttpClient();
	}

	@Override
	public UsersResource users() {
		return new UsersResourceImpl(this);
	}

	public <T> T createBuilder(Class<T> clazz) {
		if( clazz == Event.Builder.class ) {
			return (T) new EventImpl.EventBuilderImpl();
		} else if( clazz == Calendar.Builder.class ) {
			return (T)new CalendarImpl.CalendarBuilderImpl();
		} else if( clazz == EmailAddress.Builder.class ) {
			return (T) new EmailAddressImpl.EmailAddressBuilderImpl();
		} else if( clazz == Attendee.Builder.class ) {
			return (T) new AttendeeImpl.AttendeeBuilderImpl();
		} else if( clazz == EventUpdate.Builder.class ) {
			return (T) new EventUpdateImpl.EventUpdateBuilderImpl();
		}
		throw new IllegalArgumentException(String.format("Unsupported build %s", clazz));
	}

	public JsonObject POST(String url, JsonObject payload) {
		HttpRequest request = HttpRequest.newBuilder()
			.uri(URI.create(url))
			.header("Authorization", "Bearer " + provider.getAccessToken(url).join())
			.header("Content-Type", "application/json")
			.POST(BodyPublishers.ofString(JsonUtils.stringify(payload, false)))
			.build();
		return sendRequest(request);
	}

	public JsonObject PATCH(String url, JsonObject payload) {
		HttpRequest request = HttpRequest.newBuilder()
			.uri(URI.create(url))
			.header("Authorization", "Bearer " + provider.getAccessToken(url).join())
			.header("Content-Type", "application/json")
			.method("PATCH", BodyPublishers.ofString(JsonUtils.stringify(payload, false)))
			.build();
		return sendRequest(request);
	}

	public JsonObject GET(String url) {
		HttpRequest request = HttpRequest.newBuilder()
			.uri(URI.create(url))
			.header("Authorization", "Bearer " + provider.getAccessToken(url).join())
			.GET()
			.build();
		return sendRequest(request);
	}

	public void DELETE(String url) {
		HttpRequest request = HttpRequest.newBuilder()
			.uri(URI.create(url))
			.header("Authorization", "Bearer " + provider.getAccessToken(url).join())
			.DELETE()
			.build();
		sendVoidRequest(request);
	}

	public void sendVoidRequest(HttpRequest request) {
		try {
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			var responseBody = response.body();
		} catch (IOException | InterruptedException e) {
			throw new IllegalStateException(e);
		}
	}
	
	public JsonObject sendRequest(HttpRequest request) {
		try {
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			var responseBody = response.body();
			// System.err.println(responseBody);
			var reader = Json.createReader(new StringReader(responseBody));
			return reader.readObject();
		} catch (IOException | InterruptedException e) {
			throw new IllegalStateException(e);
		}
	}
}
