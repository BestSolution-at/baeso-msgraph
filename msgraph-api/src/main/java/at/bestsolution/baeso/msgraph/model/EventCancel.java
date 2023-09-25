package at.bestsolution.baeso.msgraph.model;

import at.bestsolution.baeso.msgraph.base.MsGraphData;

public interface EventCancel extends MsGraphData {
    /**
     * A comment about the cancellation sent to all the attendees. Optional.
     * @return value
     */
    String comment();

    public interface Builder {
        public EventCancel build();
        Builder comment(String comment);
    }
}
