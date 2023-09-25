package at.bestsolution.baeso.msgraph.model;

import at.bestsolution.baeso.msgraph.base.ID;
import at.bestsolution.baeso.msgraph.base.MsGraphData;

public interface Place extends MsGraphData {
    // address
    String displayName();
    // geoCoordinates
    ID<Place> id();
    String phone();
}
