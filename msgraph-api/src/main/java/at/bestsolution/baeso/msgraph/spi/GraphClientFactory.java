package at.bestsolution.baeso.msgraph.spi;

import at.bestsolution.baeso.msgraph.GraphClient;
import at.bestsolution.baeso.msgraph.auth.AccessTokenProvider;

public interface GraphClientFactory {
    public GraphClient createClient(AccessTokenProvider accessTokenProvider);
}
