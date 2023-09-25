package at.bestsolution.baeso.msgraph.model;

import java.time.ZonedDateTime;

import at.bestsolution.baeso.msgraph.base.MsGraphData;

public interface ResponseStatus extends MsGraphData {
    
    // public Response response();
    public ZonedDateTime time();
}
