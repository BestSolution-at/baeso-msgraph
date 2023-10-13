package at.bestsolution.baeso.msgraph.model;

import java.util.function.Function;

import at.bestsolution.baeso.msgraph.base.MsGraphData;

public interface Location extends MsGraphData {
    public enum LocationType {
        DEFAULT("default"), 
        CONFERENCEROOM("conferenceRoom"),
        HOME_ADDRESS("homeAddress"),
        BUSINESS_ADDRESS("businessAddress"),
        GEO_COORDINATES("geoCoordinates"),
        STREET_ADDRESS("streetAddress"),
        HOTEL("hotel"),
        RESTAURANT("restaurant"), 
        LOCAL_BUSINESS("localBusiness"),
        POSTAL_ADDRESS("postalAddress");

        private final String value;

        LocationType(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }

        public static LocationType of(String value) {
            return switch(value) {
                case "default" -> DEFAULT;
                case "conferenceRoom" -> CONFERENCEROOM;
                case "homeAddress" -> HOME_ADDRESS;
                case "businessAddress" -> BUSINESS_ADDRESS;
                case "geoCoordinates" -> GEO_COORDINATES;
                case "streetAddress" -> STREET_ADDRESS;
                case "hotel" -> HOTEL;
                case "restaurant" -> RESTAURANT;
                case "localBusiness" -> LOCAL_BUSINESS;
                case "postalAddress" -> POSTAL_ADDRESS;
                default -> throw new IllegalArgumentException(String.format("Unknown value '%s'", value));
            };
        }
    }
    /**
     * The street address of the location.
     * @return value
     */
    PhysicalAddress address();
    /**
     * The geographic coordinates and elevation of the location.
     * @return value
     */
    OutlookGeoCoordinates coordinates();
    /**
     * The name associated with the location.
     * @return value
     */
    String displayName();
    /**
     * Optional email address of the location.
     * @return value
     */
    String locationEmailAddress();
    /**
     * Optional URI representing the location.
     * @return value
     */
    String locationUri();
    /**
     * The type of location. The possible values are: <code>default</code>, <code>conferenceRoom</code>, 
     * <code>homeAddress</code>, <code>businessAddress</code>, <code>geoCoordinates</code>, 
     * <code>streetAddress</code>, <code>hotel</code>, <code>restaurant</code>, <code>localBusiness</code>, 
     * <code>postalAddress</code>. Read-only.
     * @return value
     */
    LocationType locationType();
    /**
     * For internal use only.
     * @return value
     */
    String uniqueId();
    /**
     * For internal use only.
     * @return value
     */
    String uniqueIdType();

    public interface Builder {
        Builder address(PhysicalAddress address);
        Builder withAddress(Function<PhysicalAddress.Builder, PhysicalAddress> builder);

        Builder coordinates(OutlookGeoCoordinates coordinates);
        Builder withCoordinates(Function<OutlookGeoCoordinates.Builder, OutlookGeoCoordinates> coordinates);

        Builder displayName(String displayName);
        Builder locationEmailAddress(String locationEmailAddress);
        Builder locationUri(String locationUri);
        Builder locationType(LocationType locationType);
        // String uniqueId();
        // String uniqueIdType();
    }
}
