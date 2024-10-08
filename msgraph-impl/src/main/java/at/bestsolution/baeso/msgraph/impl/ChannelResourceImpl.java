package at.bestsolution.baeso.msgraph.impl;

import at.bestsolution.baeso.msgraph.ChannelResource;
import at.bestsolution.baeso.msgraph.ChatMessagesResource;

public class ChannelResourceImpl implements ChannelResource {
    private final GraphClientImpl client;
	private final String baseUrl;

    public ChannelResourceImpl(GraphClientImpl client, String baseUrl) {
        this.client = client;
        this.baseUrl = baseUrl;
    }

    @Override
    public ChatMessagesResource messages() {
        return new ChatMessagesResourceImpl(client, baseUrl + "/messages");
    }

}
