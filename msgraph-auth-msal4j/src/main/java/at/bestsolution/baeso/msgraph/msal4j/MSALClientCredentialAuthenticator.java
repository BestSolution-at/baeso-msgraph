package at.bestsolution.baeso.msgraph.msal4j;

import java.net.MalformedURLException;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

import com.microsoft.aad.msal4j.ClientCredentialFactory;
import com.microsoft.aad.msal4j.ClientCredentialParameters;
import com.microsoft.aad.msal4j.ConfidentialClientApplication;
import com.microsoft.aad.msal4j.IAuthenticationResult;
import com.microsoft.aad.msal4j.IClientCredential;
import com.microsoft.aad.msal4j.ITokenCacheAccessAspect;
import com.microsoft.aad.msal4j.MsalException;
import com.microsoft.aad.msal4j.SilentParameters;

import at.bestsolution.baeso.msgraph.auth.AccessTokenProvider;

public class MSALClientCredentialAuthenticator implements AccessTokenProvider {
	private final static Set<String> SCOPE = Collections.singleton( "https://graph.microsoft.com/.default" );
	
	private final static String AUTHORITY_BASE = "https://login.microsoftonline.com/";
	
	private final String clientId;
	private final String clientSecret;
	private final String authority;
	
	private final ITokenCacheAccessAspect tokenCache;
	
	public MSALClientCredentialAuthenticator() {
		this(System.getProperty("msal4j.clientId"), System.getProperty("msal4j.tenantId"), System.getProperty("msal4j.clientSecret"));
	}
	
	public MSALClientCredentialAuthenticator(String clientId, String tenantId, String clientSecret) {
		this.clientId = clientId;
		this.clientSecret = clientSecret;
		this.authority = AUTHORITY_BASE + tenantId + "/";
		
		tokenCache = new MemoryTokenStorage();
	}

	protected IAuthenticationResult acquireToken() throws MalformedURLException {
		IClientCredential credential = ClientCredentialFactory.createFromSecret( clientSecret );
		ConfidentialClientApplication cca = ConfidentialClientApplication
				.builder( clientId, credential )
				.authority( authority )
				.setTokenCacheAccessAspect( tokenCache )
				.build();

		IAuthenticationResult result;
		try {
			SilentParameters silentParameters = SilentParameters.builder( SCOPE ).build();

			// try to acquire token silently. This call may fail when the
			// token cache does not have a token for the application you are 
			// requesting an access token for
			result = cca.acquireTokenSilently( silentParameters ).join();
		}
		catch ( CompletionException ex ) {
			if ( ex.getCause() instanceof MsalException ) {
				ClientCredentialParameters parameters = ClientCredentialParameters.builder( SCOPE ).build();

				// try to acquire a new token from the authority
				result = cca.acquireToken( parameters ).join();
			}
			else {
				// Handle other exceptions accordingly
				throw ex;
			}
		}
		return result;
	}

	@Override
	public CompletableFuture<String> getAccessToken(String requestUrl) {
		return CompletableFuture.supplyAsync( () -> {
			try {
				return acquireToken().accessToken();
			} catch (MalformedURLException e) {
				throw new RuntimeException(e);
			}			
		});
	}
}
