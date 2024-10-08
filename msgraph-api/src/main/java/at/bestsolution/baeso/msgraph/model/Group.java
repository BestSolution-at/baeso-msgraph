package at.bestsolution.baeso.msgraph.model;

import at.bestsolution.baeso.msgraph.base.ID;

/**
 * Represents a Microsoft Entra group, a Microsoft 365 group, or a security group. 
 * This resource is an open type that allows other properties to be passed in.
 */
public interface Group {
    // allowExternalSenders
    // assignedLabels
    // assignedLicenses
    // autoSubscribeNewMembers
    // classification
    // createdDateTime
    // deletedDateTime
    /**
     * <p>
     * An optional description for the group. 
     * </p>
     * <p>
     * Returned by default. Supports <code>$filter</code> (<code>eq</code>, <code>ne</code>, <code>not</code>, <code>ge</code>, <code>le</code>, <code>startsWith</code>) and <code>$search</code>.
     * </p>
     * @return the value
     */
    String description();

    /**
     * <p>
     * The display name for the group. This property is required when a group is created and 
     * can't be cleared during updates. Maximum length is 256 characters. 
     * </p>
     * <p>
     * Returned by default. Supports <code>$filter</code> (<code>eq</code>, <code>ne</code>, 
     * <code>not</code>, <code>ge</code>, <code>le</code>, <code>startsWith</code>), <code>$search</code> and <code>$orderby</code>.
     * </p>
     * @return the value
     */
    String displayName();
    
    // expirationDateTime
    // groupTypes
    // hasMembersWithLicenseErrors

    /**
     * The unique identifier for the group. 
     * 
     * @return the value
     */
    ID<Group> id();
}
