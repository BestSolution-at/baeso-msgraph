package at.bestsolution.baeso.msgraph;

import at.bestsolution.baeso.msgraph.base.Query;
import at.bestsolution.baeso.msgraph.model.ConversationThread;

public interface ConversationsResource {
    public interface ConversationQuery extends Query<ConversationThread> {
		
	}

    public ConversationQuery query();
}
