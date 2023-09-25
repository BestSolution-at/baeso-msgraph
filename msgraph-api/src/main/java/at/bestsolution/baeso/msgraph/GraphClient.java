package at.bestsolution.baeso.msgraph;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ServiceLoader;

import at.bestsolution.baeso.msgraph.auth.AccessTokenProvider;
import at.bestsolution.baeso.msgraph.base.ID;
import at.bestsolution.baeso.msgraph.model.User;
import at.bestsolution.baeso.msgraph.spi.GraphClientFactory;

public interface GraphClient {
	public UsersResource users();
	public default UserResource user(ID<User> id) {
		return users().user(id);
	}
	public default UserResource user(String userPrincipalName) {
		return users().user(userPrincipalName);
	}
	
	public <T> T createBuilder(Class<T> clazz);

	public void serialize(Object value, OutputStream stream) throws IOException;

	public <T> T deserialize(InputStream stream) throws IOException;

	public static GraphClient create(AccessTokenProvider accessTokenProvider) {
		return ServiceLoader.load(GraphClientFactory.class)
			.findFirst()
			.orElseThrow( () -> new IllegalStateException("No factory available"))
			.createClient(accessTokenProvider);
	}
}
