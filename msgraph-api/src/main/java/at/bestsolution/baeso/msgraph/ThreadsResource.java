package at.bestsolution.baeso.msgraph;

import at.bestsolution.baeso.msgraph.base.Query;
import at.bestsolution.baeso.msgraph.model.ConversationThread;

public interface ThreadsResource {
    public interface ThreadQuery extends Query<ConversationThread> {
		
	}

    public ThreadQuery query();
}
