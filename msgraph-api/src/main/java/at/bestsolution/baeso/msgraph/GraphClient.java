package at.bestsolution.baeso.msgraph;

import java.util.ServiceLoader;

import at.bestsolution.baeso.msgraph.auth.AccessTokenProvider;
import at.bestsolution.baeso.msgraph.spi.GraphClientFactory;

public interface GraphClient {
	public UsersResource users();
	public <T> T createBuilder(Class<T> clazz);

	public static GraphClient create(AccessTokenProvider accessTokenProvider) {
		return ServiceLoader.load(GraphClientFactory.class)
			.findFirst()
			.orElseThrow( () -> new IllegalStateException("No factory available"))
			.createClient(accessTokenProvider);
	}
}
