package at.bestsolution.baeso.msgraph.impl;

import at.bestsolution.baeso.msgraph.ChatMessagesResource;
import at.bestsolution.baeso.msgraph.ConversationsResource.ConversationQuery;
import at.bestsolution.baeso.msgraph.impl.model.ChatMessageImpl;
import at.bestsolution.baeso.msgraph.impl.model.ConversationThreadImpl;
import at.bestsolution.baeso.msgraph.impl.model.EventImpl;
import at.bestsolution.baeso.msgraph.impl.utils.QueryImpl;
import at.bestsolution.baeso.msgraph.model.ChatMessage;
import at.bestsolution.baeso.msgraph.model.ConversationThread;
import at.bestsolution.baeso.msgraph.model.Event;

public class ChatMessagesResourceImpl implements ChatMessagesResource {
    private final GraphClientImpl client;
	private final String baseUrl;

    public ChatMessagesResourceImpl(GraphClientImpl client, String baseUrl) {
        this.client = client;
        this.baseUrl = baseUrl;
    }

    @Override
    public ChatMessageQuery query() {
        return new ChatMessageQueryImpl(baseUrl, client);
    }

    @Override
    public ChatMessage create(ChatMessage event) {
        var result = this.client.POST(this.baseUrl, ((ChatMessageImpl)event).object);
        return new ChatMessageImpl(result);
    }

    static class ChatMessageQueryImpl extends QueryImpl<ChatMessage> implements ChatMessageQuery {

        public ChatMessageQueryImpl(String baseUrl, GraphClientImpl client) {
            super(baseUrl, client, ChatMessageImpl::new);
        }
    }
}
