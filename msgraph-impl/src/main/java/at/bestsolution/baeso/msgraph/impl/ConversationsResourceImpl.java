package at.bestsolution.baeso.msgraph.impl;

import at.bestsolution.baeso.msgraph.ConversationsResource;
import at.bestsolution.baeso.msgraph.impl.model.ConversationThreadImpl;
import at.bestsolution.baeso.msgraph.impl.utils.QueryImpl;
import at.bestsolution.baeso.msgraph.model.ConversationThread;

public class ConversationsResourceImpl implements ConversationsResource {
    private final GraphClientImpl client;
	private final String baseUrl;

    public ConversationsResourceImpl(GraphClientImpl client, String baseUrl) {
        this.client = client;
        this.baseUrl = baseUrl;
    }

    @Override
    public ConversationQuery query() {
        return new ConversationQueryImpl(this.baseUrl, this.client);
    }

    static class ConversationQueryImpl extends QueryImpl<ConversationThread> implements ConversationQuery {

        public ConversationQueryImpl(String baseUrl, GraphClientImpl client) {
            super(baseUrl, client, ConversationThreadImpl::new);
        }
    }
}
