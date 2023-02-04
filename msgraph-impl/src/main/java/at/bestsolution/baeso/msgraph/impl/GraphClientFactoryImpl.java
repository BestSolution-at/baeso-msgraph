package at.bestsolution.baeso.msgraph.impl;

import at.bestsolution.baeso.msgraph.GraphClient;
import at.bestsolution.baeso.msgraph.auth.AccessTokenProvider;
import at.bestsolution.baeso.msgraph.spi.GraphClientFactory;

public class GraphClientFactoryImpl implements GraphClientFactory {

    @Override
    public GraphClient createClient(AccessTokenProvider accessTokenProvider) {
        return new GraphClientImpl(accessTokenProvider);
    }
    
}
