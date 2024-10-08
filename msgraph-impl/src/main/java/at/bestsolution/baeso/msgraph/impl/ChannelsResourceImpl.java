package at.bestsolution.baeso.msgraph.impl;

import at.bestsolution.baeso.msgraph.ChannelResource;
import at.bestsolution.baeso.msgraph.ChannelsResource;
import at.bestsolution.baeso.msgraph.base.ID;
import at.bestsolution.baeso.msgraph.impl.model.ChannelImpl;
import at.bestsolution.baeso.msgraph.impl.utils.QueryImpl;
import at.bestsolution.baeso.msgraph.model.Channel;

public class ChannelsResourceImpl implements ChannelsResource {
    private final GraphClientImpl client;
	private final String baseUrl;

    public ChannelsResourceImpl(GraphClientImpl client, String baseUrl) {
        this.client = client;
        this.baseUrl = baseUrl;
    }

    @Override
    public ChannelQuery query() {
        return new ChannelQueryImpl(baseUrl, client);
    }

    @Override
    public ChannelResource channel(ID<Channel> channel) {
        return new ChannelResourceImpl(client, baseUrl + "/" + channel.id);
    }

    static class ChannelQueryImpl extends QueryImpl<Channel> implements ChannelQuery {

        public ChannelQueryImpl(String baseUrl, GraphClientImpl client) {
            super(baseUrl, client, ChannelImpl::new, false);
        }
    }
}
