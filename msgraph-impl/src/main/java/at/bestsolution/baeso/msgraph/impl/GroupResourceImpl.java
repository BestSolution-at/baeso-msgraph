package at.bestsolution.baeso.msgraph.impl;

import at.bestsolution.baeso.msgraph.ConversationsResource;
import at.bestsolution.baeso.msgraph.GroupResource;
import at.bestsolution.baeso.msgraph.ThreadsResource;
import at.bestsolution.baeso.msgraph.impl.model.GroupImpl;
import at.bestsolution.baeso.msgraph.model.Group;

public class GroupResourceImpl implements GroupResource {
	private final GraphClientImpl client;
	private final String baseUrl;

	public GroupResourceImpl(GraphClientImpl client, String baseUrl) {
		this.client = client;
		this.baseUrl = baseUrl;
	}

    @Override
    public ThreadsResource threads() {
        return new ThreadsResourceImpl(client, baseUrl + "/threads");
    }

    @Override
    public ConversationsResource conversations() {
        return new ConversationsResourceImpl(client, baseUrl + "/conversations");
    }

    @Override
    public Group get() {
        return new GroupImpl(client.GET(baseUrl));
    }

    
}
