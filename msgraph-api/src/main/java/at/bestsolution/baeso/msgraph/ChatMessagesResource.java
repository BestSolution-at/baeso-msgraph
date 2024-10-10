package at.bestsolution.baeso.msgraph;

import at.bestsolution.baeso.msgraph.base.Query;
import at.bestsolution.baeso.msgraph.model.ChatMessage;

public interface ChatMessagesResource {
    public interface ChatMessageQuery extends Query<ChatMessage> {
		
	}

    public ChatMessageQuery query();
    public ChatMessage create(ChatMessage event);
}
