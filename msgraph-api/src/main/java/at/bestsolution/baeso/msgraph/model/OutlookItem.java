package at.bestsolution.baeso.msgraph.model;

import java.time.ZonedDateTime;
import java.util.List;

public interface OutlookItem {
    /**
     * The categories associated with the item
     * 
     * @return value
     */
    List<String> categories();

    /**
     * Identifies the version of the item. Every time the item is changed, changeKey
     * changes as well. This allows Exchange to apply changes to the correct version
     * of the object. Read-only.
     * 
     * @return value
     */
    String changeKey();

    /**
     * The Timestamp type represents date and time information using ISO 8601 format
     * and is always in UTC time. For example, midnight UTC on Jan 1, 2014 is
     * <code>2014-01-01T00:00:00Z</code>
     * 
     * @return value
     */
    ZonedDateTime createdDateTime();

    /**
     * Read-only.
     * 
     * @return value
     */
    String id();

    /**
     * The Timestamp type represents date and time information using ISO 8601 format
     * and is always in UTC time. For example, midnight UTC on Jan 1, 2014 is
     * <code>2014-01-01T00:00:00Z</code>
     * 
     * @return value
     */
    ZonedDateTime lastModifiedDateTime();
}