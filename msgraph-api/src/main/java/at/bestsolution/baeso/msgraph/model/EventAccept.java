package at.bestsolution.baeso.msgraph.model;

import at.bestsolution.baeso.msgraph.base.MsGraphData;

/**
 * Accept the specified <a href=
 * "https://learn.microsoft.com/en-us/graph/api/resources/event?view=graph-rest-1.0">event</a>
 * in a user <a href=
 * "https://learn.microsoft.com/en-us/graph/api/resources/calendar?view=graph-rest-1.0">calendar</a>.
 */
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
