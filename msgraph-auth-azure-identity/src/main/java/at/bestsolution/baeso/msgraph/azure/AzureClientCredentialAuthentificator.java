package at.bestsolution.baeso.msgraph.azure;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.azure.core.credential.TokenRequestContext;
import com.azure.identity.ClientSecretCredential;
import com.azure.identity.ClientSecretCredentialBuilder;

import at.bestsolution.baeso.msgraph.auth.AccessTokenProvider;


public class AzureClientCredentialAuthentificator implements AccessTokenProvider {
	private final ClientSecretCredential clientCredentials;
	private final TokenRequestContext context;
	
	public AzureClientCredentialAuthentificator(String clientId, String tenantId, String clientSecret) {
		this.clientCredentials = new ClientSecretCredentialBuilder()
				.clientId(clientId)
				.tenantId(tenantId)
				.clientSecret(clientSecret)
				.build();
		this.context = new TokenRequestContext();
        this.context.setScopes(List.of("https://graph.microsoft.com/.default"));
	}

	@Override
	public CompletableFuture<String> getAccessToken(String url) {
		return CompletableFuture.supplyAsync( () -> clientCredentials.getTokenSync(context).getToken());
	}
}
