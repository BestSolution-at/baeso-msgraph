package at.bestsolution.baeso.msgraph.msal4j;

import com.microsoft.aad.msal4j.ITokenCacheAccessAspect;
import com.microsoft.aad.msal4j.ITokenCacheAccessContext;

public class MemoryTokenStorage implements ITokenCacheAccessAspect {

	private String data;
	
	public MemoryTokenStorage() {
		data = "{}";
	}

	@Override
	public void beforeCacheAccess( ITokenCacheAccessContext context ) {
		context.tokenCache().deserialize( data );
	}

	@Override
	public void afterCacheAccess( ITokenCacheAccessContext context ) {
		if ( context.hasCacheChanged() ) {
			data = context.tokenCache().serialize();
		}
	}

}
