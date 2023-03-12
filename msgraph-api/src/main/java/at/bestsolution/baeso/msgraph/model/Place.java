package at.bestsolution.baeso.msgraph.model;

import at.bestsolution.baeso.msgraph.base.ID;

public interface Place {
    // address
    String displayName();
    // geoCoordinates
    ID<Place> id();
    String phone();
}
