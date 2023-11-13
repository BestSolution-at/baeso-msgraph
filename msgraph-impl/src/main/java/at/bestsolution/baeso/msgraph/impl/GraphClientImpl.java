package at.bestsolution.baeso.msgraph.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

import jakarta.json.Json;
import jakarta.json.JsonObject;

import at.bestsolution.baeso.msgraph.GraphClient;
import at.bestsolution.baeso.msgraph.UsersResource;
import at.bestsolution.baeso.msgraph.auth.AccessTokenProvider;
import at.bestsolution.baeso.msgraph.base.ID;
import at.bestsolution.baeso.msgraph.impl.model.AttendeeImpl;
import at.bestsolution.baeso.msgraph.impl.model.CalendarGroupImpl;
import at.bestsolution.baeso.msgraph.impl.model.CalendarImpl;
import at.bestsolution.baeso.msgraph.impl.model.EmailAddressImpl;
import at.bestsolution.baeso.msgraph.impl.model.EventAcceptImpl;
import at.bestsolution.baeso.msgraph.impl.model.EventCancelImpl;
import at.bestsolution.baeso.msgraph.impl.model.EventForwardImpl;
import at.bestsolution.baeso.msgraph.impl.model.EventImpl;
import at.bestsolution.baeso.msgraph.impl.model.EventUpdateImpl;
import at.bestsolution.baeso.msgraph.impl.model.ItemBodyImpl;
import at.bestsolution.baeso.msgraph.impl.model.JSONSerializable;
import at.bestsolution.baeso.msgraph.impl.model.PatternedRecurrenceImpl;
import at.bestsolution.baeso.msgraph.impl.model.PlaceImpl;
import at.bestsolution.baeso.msgraph.impl.model.RecipientImpl;
import at.bestsolution.baeso.msgraph.impl.model.RecurrencePatternImpl;
import at.bestsolution.baeso.msgraph.impl.model.RecurrenceRangeImpl;
import at.bestsolution.baeso.msgraph.impl.model.UserImpl;
import at.bestsolution.baeso.msgraph.impl.utils.JsonUtils;
import at.bestsolution.baeso.msgraph.model.Attendee;
import at.bestsolution.baeso.msgraph.model.Calendar;
import at.bestsolution.baeso.msgraph.model.EmailAddress;
import at.bestsolution.baeso.msgraph.model.Event;
import at.bestsolution.baeso.msgraph.model.EventUpdate;
import at.bestsolution.baeso.msgraph.model.PatternedRecurrence;

public class GraphClientImpl implements GraphClient {
	final AccessTokenProvider provider;
	private final HttpClient client;

	private static Map<String,Function<JsonObject, Object>> OBJECT_CREATOR_MAP = new HashMap<>();

	static {
		registerObjectCreator(AttendeeImpl.class, AttendeeImpl::new);
		registerObjectCreator(CalendarGroupImpl.class, CalendarGroupImpl::new);
		registerObjectCreator(CalendarImpl.class, CalendarImpl::new);
		registerObjectCreator(EmailAddressImpl.class, EmailAddressImpl::new);
		registerObjectCreator(EventAcceptImpl.class, EventAcceptImpl::new);
		registerObjectCreator(EventCancelImpl.class, EventCancelImpl::new);
		registerObjectCreator(EventForwardImpl.class, EventForwardImpl::new);
		registerObjectCreator(EventImpl.class, EventImpl::new);
		registerObjectCreator(EventUpdateImpl.class, EventUpdateImpl::new);
		registerObjectCreator(ItemBodyImpl.class, ItemBodyImpl::new);
		registerObjectCreator(PatternedRecurrenceImpl.class, PatternedRecurrenceImpl::new);
		registerObjectCreator(PlaceImpl.class, PlaceImpl::new);
		registerObjectCreator(RecipientImpl.class, RecipientImpl::new);
		registerObjectCreator(RecurrencePatternImpl.class, RecurrencePatternImpl::new);
		registerObjectCreator(RecurrenceRangeImpl.class, RecurrenceRangeImpl::new);
		registerObjectCreator(UserImpl.class, UserImpl::new);
	}

	private static Map<Class<?>,Supplier<Object>> BUILDER_CREATOR_MAP = new HashMap<>();

	static {
		registerBuilderCreator(Event.Builder.class, EventImpl.EventBuilderImpl::new);
		registerBuilderCreator(Calendar.Builder.class, CalendarImpl.CalendarBuilderImpl::new);
		registerBuilderCreator(EmailAddress.Builder.class, EmailAddressImpl.EmailAddressBuilderImpl::new);
		registerBuilderCreator(Attendee.Builder.class, AttendeeImpl.AttendeeBuilderImpl::new);
		registerBuilderCreator(EventUpdate.Builder.class, EventUpdateImpl.EventUpdateBuilderImpl::new);
		registerBuilderCreator(PatternedRecurrence.Builder.class, PatternedRecurrenceImpl.PatternedRecurrenceBuilderImpl::new);
	}

	private static void registerObjectCreator(Class<?> clazz, Function<JsonObject, Object> constructor) {
		OBJECT_CREATOR_MAP.put(String.format("msgraph.%s", clazz.getSimpleName()), constructor);
	}

	private static void registerBuilderCreator(Class<?> clazz, Supplier<Object> constructor) {
		BUILDER_CREATOR_MAP.put(clazz, constructor);
	}


	public GraphClientImpl(AccessTokenProvider provider) {
		this.provider = provider;
		this.client = HttpClient.newHttpClient();
	}

	@Override
	public UsersResource users() {
		return new UsersResourceImpl(this);
	}

	@Override
	public void serialize(Object value, OutputStream stream) throws IOException {
		if( value instanceof ID ) {
			stream.write("msgraph.ID\n".getBytes(StandardCharsets.UTF_8));
			stream.write(((ID<?>)value).id.getBytes(StandardCharsets.UTF_8));
		} else if( value instanceof JSONSerializable ) {
			stream.write(String.format("msgraph.%s\n"+value.getClass().getSimpleName()).getBytes(StandardCharsets.UTF_8));
			stream.write(((JSONSerializable)value).toJson().getBytes(StandardCharsets.UTF_8));
		}
		throw new IllegalArgumentException(String.format("Unable to serialize '%s'", value.getClass().getName()));
	}

	@Override
	public <T> T deserialize(InputStream stream) throws IOException {
		var r = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8));
		var type = r.readLine();
		var constructor = OBJECT_CREATOR_MAP.get(type);
		if( constructor != null ) {
			return (T)constructor.apply(Json.createReader(r).readObject());
		}

		throw new IllegalArgumentException(String.format("Unable to deserialize '%s'", type));
	}

	public <T> T createBuilder(Class<T> clazz) {
		var builderConstructor = BUILDER_CREATOR_MAP.get(clazz);
		if( builderConstructor != null ) {
			return (T)builderConstructor.get();
		}
		throw new IllegalArgumentException(String.format("Unsupported build '%s'", clazz));
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

	public void POST_VOID(String url, JsonObject payload) {
		HttpRequest request = HttpRequest.newBuilder()
			.uri(URI.create(url))
			.header("Authorization", "Bearer " + provider.getAccessToken(url).join())
			.header("Content-Type", "application/json")
			.POST(BodyPublishers.ofString(JsonUtils.stringify(payload, false)))
			.build();
		sendVoidRequest(request);
	}

	public void POST_VOID(String url) {
		HttpRequest request = HttpRequest.newBuilder()
			.uri(URI.create(url))
			.header("Authorization", "Bearer " + provider.getAccessToken(url).join())
			.header("Content-Type", "application/json")
			.build();
		sendVoidRequest(request);
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
		System.err.println("GET: " + url);
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
			if( response.statusCode() >= 300 ) {
				System.err.println(responseBody); // Sample {"error":{"code":"ErrorInvalidRequest","message":"Your request can't be completed. The duration of an event marked as All day must be at least 24 hours."}}
			}
		} catch (IOException | InterruptedException e) {
			throw new IllegalStateException(e);
		}
	}
	
	public JsonObject sendRequest(HttpRequest request) {
		try {
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			var responseBody = response.body();
			if( response.statusCode() >= 300 ) {
				System.err.println(responseBody);
			}
			
			var reader = Json.createReader(new StringReader(responseBody));
			return reader.readObject();
		} catch (IOException | InterruptedException e) {
			throw new IllegalStateException(e);
		}
	}
}
