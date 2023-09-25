package at.bestsolution.baeso.msgraph.model;

import at.bestsolution.baeso.msgraph.base.MsGraphData;

public interface EventAccept extends MsGraphData {
    /**
     * Text included in the response. Optional.
     * 
     * @return value
     */
    String comment();

    /**
     * <code>true</code> if a response is to be sent to the organizer; otherwise,
     * <code>false</code>. Optional. Default is <code>true</code>.
     * 
     * @return value
     */
    boolean sendResponse();

    public interface Builder {
        EventAccept build();
        Builder comment(String comment);
        Builder sendResponse(boolean sendResponse);
    }
}
