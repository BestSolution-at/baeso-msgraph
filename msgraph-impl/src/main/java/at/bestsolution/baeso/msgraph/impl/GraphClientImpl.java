package at.bestsolution.baeso.msgraph.impl;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import at.bestsolution.baeso.msgraph.GraphClient;
import at.bestsolution.baeso.msgraph.UserResource;
import at.bestsolution.baeso.msgraph.auth.AccessTokenProvider;
import jakarta.json.Json;
import jakarta.json.JsonObject;

public class GraphClientImpl implements GraphClient {
	final AccessTokenProvider provider;
	private final HttpClient client;
	
	public GraphClientImpl(AccessTokenProvider provider) {
		this.provider = provider;
		this.client = HttpClient.newHttpClient();
	}

	@Override
	public UserResource users() {
		return new UserResourceImpl(this);
	}

	public JsonObject GET(String url) {
		// System.err.println(provider.getAccessToken(url).join());
		HttpRequest request = HttpRequest.newBuilder()
				  .uri(URI.create(url))
				  .header("Authorization", "Bearer " + provider.getAccessToken(url).join())
				  .GET()
				  .build();
		return sendRequest(request);
	}
	
	public JsonObject sendRequest(HttpRequest request) {
		try {
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			var responseBody = response.body();
			System.err.println(responseBody);
			var reader = Json.createReader(new StringReader(responseBody));
			return reader.readObject();
		} catch (IOException | InterruptedException e) {
			throw new IllegalStateException(e);
		}
	}
}
