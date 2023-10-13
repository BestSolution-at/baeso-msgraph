package at.bestsolution.baeso.msgraph.model;

import java.time.ZonedDateTime;

import at.bestsolution.baeso.msgraph.base.MsGraphData;

/**
 * <p>
 * Represents the response status of an attendee or organizer for a meeting
 * request.
 * </p>
 * <p>
 * You can get the response status of an attendee or organizer through the
 * <strong>responseStatus</strong> property of an <a href=
 * "https://learn.microsoft.com/en-us/graph/api/resources/event?view=graph-rest-1.0">event</a>
 * or the <strong>status</strong> property of an <a href=
 * "https://learn.microsoft.com/en-us/graph/api/resources/attendee?view=graph-rest-1.0">attendee</a>.
 * </p>
 */
public interface ResponseStatus extends MsGraphData {
    /**
     * State of response
     */
    public enum Response {
        NONE("none"),
        ORGANIZER("organizer"),
        TENTATIVELY_ACCEPTED("tentativelyAccepted"),
        ACCEPTED("accepted"),
        DECLINED("declined"),
        NOT_RESPONDED("notResponded");

        private final String value;

        Response(String value) {
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
        public static Response of(String value) {
            return switch (value) {
                case "none" -> NONE;
                case "organizer" -> ORGANIZER;
                case "tentativelyAccepted" -> TENTATIVELY_ACCEPTED;
                case "accepted" -> ACCEPTED;
                case "declined" -> DECLINED;
                case "notResponded" -> NOT_RESPONDED;
                default -> throw new IllegalArgumentException(String.format("Unknown value '%s'", value));
            };
        }
    }

    /**
     * <p>
     * The response type. Possible values are: <code>none</code>,
     * <code>organizer</code>, <code>tentativelyAccepted</code>,
     * <code>accepted</code>, <code>declined</code>, <code>notResponded</code>.
     * </p>
     * <p>
     * To differentiate between none and notResponded:
     * </p>
     * <ul>
     * <li><code>none</code> – from organizer's perspective. This value is used when
     * the status of an attendee/participant is reported to the organizer of a
     * meeting.</li>
     * <li><code>notResponded</code> – from attendee's perspective. Indicates the
     * attendee has not responded to the meeting request.</li>
     * </ul>
     * <p>
     * Clients can treat <code>notResponded</code> == <code>none</code>.
     * </p>
     * <p>
     * As an example, if attendee Alex hasn't responded to a meeting request,
     * getting Alex' response status for that event in Alex' calendar returns
     * <code>notResponded</code>. Getting Alex' response from the calendar of any
     * other attendee
     * or the organizer's returns <code>none</code>. Getting the organizer's
     * response for the
     * event in anybody's calendar also returns <code>none</code>.
     * </p>
     * 
     * @return the value
     */
    public Response response();

    /**
     * The date and time when the response was returned. It uses ISO 8601 format and
     * is always in UTC time. For example, midnight UTC on Jan 1, 2014 is
     * <code>2014-01-01T00:00:00Z</code>
     * 
     * @return the value
     */
    public ZonedDateTime time();

    public interface Builder {
        ResponseStatus build();
        Builder response(Response response);
        Builder time(ZonedDateTime time);
    }
}
