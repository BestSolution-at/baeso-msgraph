package at.bestsolution.baeso.msgraph.msal4j;

import java.net.MalformedURLException;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

import com.microsoft.aad.msal4j.IAccount;
import com.microsoft.aad.msal4j.IAuthenticationResult;
import com.microsoft.aad.msal4j.ITokenCacheAccessAspect;
import com.microsoft.aad.msal4j.MsalException;
import com.microsoft.aad.msal4j.PublicClientApplication;
import com.microsoft.aad.msal4j.SilentParameters;
import com.microsoft.aad.msal4j.UserNamePasswordParameters;

import at.bestsolution.baeso.msgraph.auth.AccessTokenProvider;

public class MSALClientUserCredentialAuthenticator implements AccessTokenProvider {
private final static Set<String> SCOPE = Collections.singleton( "https://graph.microsoft.com/.default" );
	
	private final static String AUTHORITY_BASE = "https://login.microsoftonline.com/organizations/";
	
	private final String clientId;
	private final String username;
	private final String password;
	private final String authority;
	
	private final ITokenCacheAccessAspect tokenCache;
	
	public MSALClientUserCredentialAuthenticator() {
		this(System.getProperty("msal4j.clientId"), System.getProperty("msal4j.username"), System.getProperty("msal4j.password"));
	}
	
	public MSALClientUserCredentialAuthenticator(String clientId, String username, String password) {
		this.clientId = clientId;
		this.username = username;
		this.password = password;
		this.authority = AUTHORITY_BASE;
		
		tokenCache = new MemoryTokenStorage();
	}

	protected IAuthenticationResult acquireToken() throws MalformedURLException {
		PublicClientApplication pca = PublicClientApplication
				.builder( clientId )
				.authority( authority )
				.setTokenCacheAccessAspect( tokenCache )
				.build();
		Set<IAccount> accountsInCache = pca.getAccounts().join();
		IAccount account = getAccountByUsername(accountsInCache, username);
		IAuthenticationResult result;
		try {
			SilentParameters silentParameters = SilentParameters.builder( SCOPE ).account(account).build();

			// try to acquire token silently. This call may fail when the
			// token cache does not have a token for the application you are 
			// requesting an access token for
			result = pca.acquireTokenSilently( silentParameters ).join();
		}
		catch ( CompletionException ex ) {
			if ( ex.getCause() instanceof MsalException ) {
				UserNamePasswordParameters parameters = UserNamePasswordParameters
                    .builder( SCOPE, username, password.toCharArray() )
                    .build();

				// try to acquire a new token from the authority
				result = pca.acquireToken( parameters ).join();
			}
			else {
				// Handle other exceptions accordingly
				throw ex;
			}
		}
		return result;
	}

	private static IAccount getAccountByUsername(Set<IAccount> accounts, String username) {
        if (!accounts.isEmpty()) {
            for (IAccount account : accounts) {
                if (account.username().equals(username)) {
                    return account;
                }
            }
        }
        return null;
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
