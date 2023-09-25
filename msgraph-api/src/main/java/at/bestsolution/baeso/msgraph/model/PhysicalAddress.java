package at.bestsolution.baeso.msgraph.model;

import at.bestsolution.baeso.msgraph.base.MsGraphData;

/**
 * Represents the street address of a resource such as a contact or event.
 */
public interface PhysicalAddress extends MsGraphData {
    /**
     * The city.
     * @return value
     */
    String city();
    /**
     * The country or region. It's a free-format string value, for example, "United States".
     * @return value
     */
    String countryOrRegion();
    /**
     * The postal code.
     * @return value
     */
    String postalCode();
    /**
     * The state.
     * @return value
     */
    String state();
    /**
     * The street.
     * @return value
     */
    String street();

}
