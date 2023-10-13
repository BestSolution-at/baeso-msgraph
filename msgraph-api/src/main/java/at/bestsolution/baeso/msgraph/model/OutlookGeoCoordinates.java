package at.bestsolution.baeso.msgraph.model;

import at.bestsolution.baeso.msgraph.base.MsGraphData;

/**
 * The geographic coordinates, elevation, and their degree of accuracy for a physical location.
 */
public interface OutlookGeoCoordinates extends MsGraphData {
    /**
     * The accuracy of the latitude and longitude. As an example, the accuracy can be measured in meters, 
     * such as the latitude and longitude are accurate to within 50 meters.
     * @return value
     */
    double accuracy();
    /**
     * The altitude of the location.
     * @return value
     */
    double altitude();
    /**
     * The accuracy of the altitude.
     * @return value
     */
    double altitudeAccuracy();
    /**
     * The latitude of the location.
     * @return value
     */
    double latitude();
    /**
     * The longitude of the location.
     * @return value
     */
    double longitude();

    public interface Builder {
        Builder accuracy(double accuracy);
        Builder altitude(double altitude);
        Builder altitudeAccuracy(double altitudeAccuracy);
        Builder latitude(double latitude);
        Builder longitude(double longitude);
    }
}
