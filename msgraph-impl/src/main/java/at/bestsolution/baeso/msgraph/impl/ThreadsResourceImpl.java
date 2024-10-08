package at.bestsolution.baeso.msgraph.impl;

import at.bestsolution.baeso.msgraph.ThreadsResource;
import at.bestsolution.baeso.msgraph.impl.model.ConversationThreadImpl;
import at.bestsolution.baeso.msgraph.impl.utils.QueryImpl;
import at.bestsolution.baeso.msgraph.model.ConversationThread;

public class ThreadsResourceImpl implements ThreadsResource {
    private final GraphClientImpl client;
	private final String baseUrl;

    public ThreadsResourceImpl(GraphClientImpl client, String baseUrl) {
        this.client = client;
        this.baseUrl = baseUrl;
    }

    @Override
    public ThreadQuery query() {
        return new ThreadQueryImpl(baseUrl, client);
    }

    static class ThreadQueryImpl extends QueryImpl<ConversationThread> implements ThreadQuery {

        public ThreadQueryImpl(String baseUrl, GraphClientImpl client) {
            super(baseUrl, client, ConversationThreadImpl::new);
        }
    }
}
