package at.bestsolution.baeso.msgraph.impl;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.Map;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import at.bestsolution.baeso.msgraph.CalendarResource;
import at.bestsolution.baeso.msgraph.UserResource;
import at.bestsolution.baeso.msgraph.base.ID;
import at.bestsolution.baeso.msgraph.impl.model.UserImpl;
import at.bestsolution.baeso.msgraph.impl.utils.PagingSpliterator;
import at.bestsolution.baeso.msgraph.model.User;
import jakarta.json.Json;
import jakarta.json.stream.JsonGenerator;

public class UserResourceImpl implements UserResource {
	private final GraphClientImpl client;
	
	public UserResourceImpl(GraphClientImpl client) {
		this.client = client;
	}

	@Override
	public Q query() {
		return new QImpl();
	}

	class QImpl implements Q {
		
		@Override
		public Stream<User> stream() {
			return stream(20);
		}
		
		@Override
		public Stream<User> stream(int pageSize) {
			HttpRequest request = HttpRequest.newBuilder()
					  .uri(URI.create(String.format("https://graph.microsoft.com/v1.0/users?$top=%s&$count=true", pageSize)))
					  .header("Authorization", "Bearer " + client.provider.getAccessToken(null).join())
					  .GET()
					  .build();
			var result = client.sendRequest(request);
			var array = result.getJsonArray("value");
			
			Json.createWriterFactory(Map.of(JsonGenerator.PRETTY_PRINTING, true)).createWriter(System.err).write(result);
			
			if( array.size() == 0 ) {
				return Stream.empty();
			}
			
			return StreamSupport.stream(new PagingSpliterator<>(client, result, UserImpl::new), false);
		}
	}

	@Override
	public CalendarResource calendars(ID<User> user) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
