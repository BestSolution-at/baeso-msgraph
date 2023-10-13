package at.bestsolution.baeso.msgraph.model;

/**
 * Base class for attendees
 */
public interface AttendeeBase extends Recipient {
    /**
     * The type of attendee.
     */
    public enum Type {
        /**
         * Required
         */
        REQUIRED("required"),
        /**
         * Optional
         */
        OPTIONAL("optional"),
        /**
         * Resource
         */
        RESOURCE("resource");

        private final String value;

        Type(String value) {
            this.value = value;
        }

        /**
         * @return source value in REST-API
         */
        public String value() {
            return this.value;
        }

        /**
         * Convert from value in REST-API
         * 
         * @param value the value
         * @return the type
         * @throws IllegalArgumentException if value is not known
         */
        public static Type of(String value) {
            return switch (value) {
                case "required" -> REQUIRED;
                case "optional" -> OPTIONAL;
                case "resource" -> RESOURCE;
                default -> throw new IllegalArgumentException(String.format("Unknown value '%s'", value));
            };
        }
    }

    /**
     * The type of attendee. The possible values are: <code>required</code>,
     * <code>optional</code>, <code>resource</code>. Currently if the attendee is a
     * person, <a href=
     * "https://learn.microsoft.com/en-us/graph/api/user-findmeetingtimes?view=graph-rest-1.0">findMeetingTimes</a>
     * always considers the person is of the Required type.
     * 
     * @return the value
     */
    Type type();

    /**
     * Includes the name and SMTP address of the attendee.
     * 
     * @return the value
     */
    EmailAddress emailAddress();

}
