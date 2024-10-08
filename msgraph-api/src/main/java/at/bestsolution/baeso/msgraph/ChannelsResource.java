package at.bestsolution.baeso.msgraph;

import at.bestsolution.baeso.msgraph.base.ID;
import at.bestsolution.baeso.msgraph.base.Query;
import at.bestsolution.baeso.msgraph.model.Channel;

public interface ChannelsResource {
    public interface ChannelQuery extends Query<Channel> {
		
	}

    public ChannelResource channel(ID<Channel> channel);

    public ChannelQuery query();
}
