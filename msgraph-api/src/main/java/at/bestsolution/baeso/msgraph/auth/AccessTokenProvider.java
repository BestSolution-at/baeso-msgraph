package at.bestsolution.baeso.msgraph.auth;

import java.util.concurrent.CompletableFuture;

public interface AccessTokenProvider {
	public CompletableFuture<String> getAccessToken(String url);
}
