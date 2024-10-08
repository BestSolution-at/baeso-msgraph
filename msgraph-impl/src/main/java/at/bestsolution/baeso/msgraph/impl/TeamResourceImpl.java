package at.bestsolution.baeso.msgraph.impl;

import at.bestsolution.baeso.msgraph.ChannelsResource;
import at.bestsolution.baeso.msgraph.TeamResource;

public class TeamResourceImpl implements TeamResource {
    private final GraphClientImpl client;
	private final String baseUrl;

    public TeamResourceImpl(GraphClientImpl client, String baseUrl) {
        this.client = client;
        this.baseUrl = baseUrl;
    }

    @Override
    public ChannelsResource channels() {
        return new ChannelsResourceImpl(client, baseUrl + "/channels");
    }

}
