package at.bestsolution.baeso.msgraph;

import at.bestsolution.baeso.msgraph.model.Group;

public interface GroupResource {
    public ThreadsResource threads();
    public ConversationsResource conversations();

    public Group get();

}
