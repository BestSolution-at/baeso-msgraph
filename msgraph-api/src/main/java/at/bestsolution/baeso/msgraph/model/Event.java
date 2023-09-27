package at.bestsolution.baeso.msgraph.model;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import at.bestsolution.baeso.msgraph.base.ID;
import at.bestsolution.baeso.msgraph.base.IndexBuilderFunction;
import at.bestsolution.baeso.msgraph.base.MsGraphData;

/**
 * <p>
 * An event in a <a href=
 * "https://learn.microsoft.com/en-us/graph/api/resources/user?view=graph-rest-1.0">user</a>
 * calendar, or the default calendar of a Microsoft 365 group.
 * </p>
 * <p>
 * The maximum number of attendees included in an <strong>event</strong>, and
 * the maximum number of recipients in an
 * <a href=
 * "https://learn.microsoft.com/en-us/graph/api/resources/eventmessage?view=graph-rest-1.0">eventMessage</a>
 * sent from an Exchange Online mailbox is 500. For more information,
 * see <a href=
 * "https://learn.microsoft.com/en-us/office365/servicedescriptions/exchange-online-service-description/exchange-online-limits#sending-limits">sending
 * limits</a>.
 * </p>
 */
public interface Event extends MsGraphData {
    public enum Importance {
        LOW("low"),
        NORMAL("normal"),
        HIGH("high");

        private final String value;

        Importance(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }

        public static Importance of(String value) {
            return switch (value) {
                case "low" -> LOW;
                case "normal" -> NORMAL;
                case "high" -> HIGH;
                default -> throw new IllegalArgumentException(String.format("Unknown value '%s'", value));
            };
        }
    }

    public enum OnlineMeetingProviderType {
        UNKNOWN("unknown"),
        TEAMS_FOR_BUSINESS("teamsForBusiness"),
        SKYPE_FOR_BUSINESS("skypeForBusiness"),
        SKYPE_FOR_CONSUMER("skypeForConsumer");

        private final String value;

        OnlineMeetingProviderType(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }

        public static OnlineMeetingProviderType of(String value) {
            return switch (value) {
                case "unknown" -> UNKNOWN;
                case "teamsForBusiness" -> TEAMS_FOR_BUSINESS;
                case "skypeForBusiness" -> SKYPE_FOR_BUSINESS;
                case "skypeForConsumer" -> SKYPE_FOR_CONSUMER;
                default -> throw new IllegalArgumentException(String.format("Unknown value '%s'", value));
            };
        }
    }

    public enum Sensitivity {
        NORMAL("normal"),
        PERSONAL("personal"),
        PRIVATE("private"),
        CONFIDENTIAL("confidential");

        private final String value;

        Sensitivity(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }

        public static Sensitivity of(String value) {
            return switch (value) {
                case "normal" -> NORMAL;
                case "personal" -> PERSONAL;
                case "private" -> PRIVATE;
                case "confidential" -> CONFIDENTIAL;
                default -> throw new IllegalArgumentException(String.format("Unknown value '%s'", value));
            };
        }
    }

    public enum ShowAs {
        FREE("free"),
        TENTATIVE("tentative"),
        BUSY("busy"),
        OOF("oof"),
        WORKING_ELSEWHERE("workingElsewhere"),
        UNKNOWN("unknown");

        private final String value;

        ShowAs(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }

        public static ShowAs of(String value) {
            return switch (value) {
                case "free" -> FREE;
                case "tentative" -> TENTATIVE;
                case "busy" -> BUSY;
                case "oof" -> OOF;
                case "workingElsewhere" -> WORKING_ELSEWHERE;
                case "unknown" -> UNKNOWN;
                default -> throw new IllegalArgumentException(String.format("Unknown value '%s'", value));
            };
        }
    }

    public enum Type {
        SINGLEINSTANCE("singleInstance"),
        OCCURRENCE("occurrence"),
        EXCEPTION("exception"),
        SERIESMASTER("seriesMaster");

        private final String value;

        Type(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }

        public static Type of(String value) {
            return switch (value) {
                case "singleInstance" -> SINGLEINSTANCE;
                case "occurrence" -> OCCURRENCE;
                case "exception" -> EXCEPTION;
                case "seriesMaster" -> SERIESMASTER;
                default -> throw new IllegalArgumentException(String.format("Unknown value '%s'", value));
            };
        }
    }

    /**
     * <p>
     * Unique identifier for the event. By default, this value changes when the item
     * is moved from one container (such as a folder or calendar) to another.
     * </p>
     * <p>
     * To change this behavior, use the <code>Prefer: IdType="ImmutableId"</code>
     * header.
     * See Get immutable identifiers for Outlook resources for more information.
     * Case-sensitive and read-only.
     * </p>
     * 
     * @return value
     */
    ID<Event> id();

    /**
     * The start date, time in the local time zone
     * 
     * @return value
     */
    ZonedDateTime start();

    /**
     * the end date, time in the local time zone
     * 
     * @return value
     */
    ZonedDateTime end();

    /**
     * The text of the event's subject line.
     * 
     * @return value
     */
    String subject();

    /**
     * <code>true</code> if the meeting organizer allows invitees to propose a new
     * time
     * when responding; otherwise, <code>false</code>
     * 
     * @return value
     */
    boolean allowNewTimeProposals();

    /**
     * The collection of attendees for the event.
     * 
     * @return value
     */
    List<Attendee> attendees();

    /**
     * The body of the message associated with the event. It can be in HTML or text
     * format.
     * 
     * @return value
     */
    ItemBody body();

    /**
     * The preview of the message associated with the event. It is in text format.
     * 
     * @return value
     */
    String bodyPreview();

    /**
     * The categories associated with the event. Each category corresponds to the
     * <strong>displayName</strong> property of an <a href=
     * "https://learn.microsoft.com/en-us/graph/api/resources/outlookcategory?view=graph-rest-1.0">outlookCategory</a>
     * defined for the user.
     * 
     * @return value
     */
    List<String> categories();

    /**
     * Identifies the version of the event object. Every time the event is changed,
     * ChangeKey changes as well. This allows Exchange to apply changes to the
     * correct
     * version of the object.
     * 
     * @return value
     */
    String changeKey();

    /**
     * The Timestamp type represents date and time information using ISO 8601
     * format and is always in UTC time. For example, midnight UTC on
     * Jan 1, 2014 is <code>2014-01-01T00:00:00Z</code>
     * 
     * @return value
     */
    ZonedDateTime createdDateTime();

    /**
     * Set to true if the event has attachments.
     * 
     * @return value
     */
    boolean hasAttachments();

    /**
     * When set to true, each attendee only sees themselves in the meeting
     * request and meeting Tracking list. Default is <code>false</code>.
     */
    boolean hideAttendees();

    /**
     * A unique identifier for an event across calendars.
     * This ID is different for each occurrence in a recurring series. Read-only.
     * 
     * @return value
     */
    String iCalUId();

    /**
     * The importance of the event. The possible values are:
     * <code>low</code>, <code>normal</code>, <code>high</code>.
     * 
     * @return value
     */
    Importance importance();

    /**
     * Set to true if the event lasts all day. If true, regardless of whether
     * it's a single-day or multi-day event, start and end time must be
     * set to midnight and be in the same time zone.
     * 
     * @return value
     */
    boolean isAllDay();

    /**
     * Set to true if the event has been canceled.
     * 
     * @return value
     */
    boolean isCancelled();

    /**
     * Set to true if the user has updated the meeting in Outlook but has not sent
     * the updates
     * to attendees. Set to false if all changes have been sent, or if the event is
     * an
     * appointment without any attendees.
     * 
     * @return value
     */
    boolean isDraft();

    /**
     * <p>
     * <code>True</code> if this event has online meeting information (that is,
     * <strong>onlineMeeting</strong> points to an
     * <a href=
     * "https://learn.microsoft.com/en-us/graph/api/resources/onlinemeetinginfo?view=graph-rest-1.0">onlineMeetingInfo</a>
     * resource),
     * <code>false</code> otherwise. Default is <code>false</code>
     * (<strong>onlineMeeting</strong> is <code>null</code>). Optional.
     * </p>
     * <p>
     * After you set <strong>isOnlineMeeting</strong> to <code>true</code>,
     * Microsoft Graph initializes <strong>onlineMeeting</strong>.
     * Subsequently Outlook ignores any further changes to
     * <strong>isOnlineMeeting</strong>, and the meeting remains available online.
     * </p>
     * 
     * @return value
     */
    boolean isOnlineMeeting();

    /**
     * Set to true if the calendar owner (specified by the <strong>owner</strong>
     * property of the
     * <a href=
     * "https://learn.microsoft.com/en-us/graph/api/resources/calendar?view=graph-rest-1.0">calendar</a>)
     * is the organizer of
     * the event (specified by the <strong>organizer</strong> property of the
     * <strong>event</strong>).
     * This also applies if a delegate organized the event on behalf of the owner.
     * 
     * @return value
     */
    boolean isOrganizer();

    /**
     * Set to true if an alert is set to remind the user of the event.
     * 
     * @return value
     */
    boolean isReminderOn();

    /**
     * The Timestamp type represents date and time information using ISO 8601 format
     * and is always in UTC time.
     * For example, midnight UTC on Jan 1, 2014 is <code>2014-01-01T00:00:00Z</code>
     * 
     * @return value
     */
    ZonedDateTime lastModifiedDateTime();

    /**
     * The location of the event.
     * 
     * @return value
     */
    Location location();

    /**
     * The locations where the event is held or attended from. The
     * <strong>location</strong> and <strong>locations</strong>
     * properties always correspond with each other. If you update the
     * <strong>location</strong> property, any prior locations
     * in the <strong>locations</strong> collection would be removed and replaced by
     * the new <strong>location</strong> value.
     * 
     * @return value
     */
    List<Location> locations();

    /**
     * <p>
     * Details for an attendee to join the meeting online. Default is null.
     * Read-only.
     * </p>
     * <p>
     * After you set the <strong>isOnlineMeeting</strong> and
     * <strong>onlineMeetingProvider</strong> properties to enable a meeting online,
     * Microsoft Graph initializes <strong>onlineMeeting</strong>. When set, the
     * meeting remains available online, and
     * you cannot change the <strong>isOnlineMeeting</strong>,
     * <strong>onlineMeetingProvider</strong>,
     * and <strong>onlineMeeting</strong> properties again.
     * </p>
     * 
     * @return value
     */
    OnlineMeetingInfo onlineMeeting();

    /**
     * <p>
     * Represents the online meeting service provider. By default,
     * <strong>onlineMeetingProvider</strong> is <code>unknown</code>.
     * The possible values are <code>unknown</code>, <code>teamsForBusiness</code>,
     * <code>skypeForBusiness</code>,
     * and <code>skypeForConsumer</code>. Optional.
     * </p>
     * <p>
     * After you set <strong>onlineMeetingProvider</strong>, Microsoft Graph
     * initializes <strong>onlineMeeting</strong>.
     * Subsequently you cannot change <strong>onlineMeetingProvider</strong> again,
     * and the meeting remains available online.
     * </p>
     * 
     * @return value
     */
    OnlineMeetingProviderType onlineMeetingProvider();

    /**
     * <p>
     * A URL for an online meeting. The property is set only when an organizer
     * specifies in Outlook
     * that an event is an online meeting such as Skype. Read-only.
     * </p>
     * <p>
     * To access the URL to join an online meeting, use <strong>joinUrl</strong>
     * which is exposed via
     * the <strong>onlineMeeting</strong> property of the event. The
     * <strong>onlineMeetingUrl</strong> property will
     * be deprecated in the future.
     * </p>
     * 
     * @return value
     */
    String onlineMeetingUrl();

    /**
     * The organizer of the event.
     * 
     * @return value
     */
    Recipient organizer();

    /**
     * The end time zone that was set when the event was created. A value of
     * <code>tzone://Microsoft/Custom</code> indicates that a legacy custom time
     * zone was set in desktop Outlook.
     * 
     * @return value
     */
    String originalEndTimeZone();

    /**
     * Represents the start time of an event when it is initially created as an
     * occurrence or exception in a recurring series. This property is not returned
     * for events that are single instances. Its date and time information is
     * expressed in ISO 8601 format and is always in UTC. For example, midnight UTC
     * on Jan 1, 2014 is <code>2014-01-01T00:00:00Z</code>
     * 
     * @return value
     */
    ZonedDateTime originalStart();

    /**
     * The start time zone that was set when the event was created. A value of
     * <code>tzone://Microsoft/Custom</code> indicates that a legacy custom time
     * zone was set in desktop Outlook.
     * 
     * @return value
     */
    String originalStartTimeZone();

    /**
     * The recurrence pattern for the event.
     * 
     * @return value
     */
    public PatternedRecurrence recurrence();

    /**
     * The number of minutes before the event start time that the reminder alert
     * occurs.
     * 
     * @return value
     */
    int reminderMinutesBeforeStart();

    /**
     * Default is <code>true</code>, which represents the organizer would like an
     * invitee to send a response to the event.
     */
    public boolean responseRequested();

    /**
     * Indicates the type of response sent in response to an event message.
     * 
     * @return value
     */
    ResponseStatus responseStatus();

    /**
     * Possible values are: <code>normal</code>, <code>personal</code>,
     * <code>private</code>, <code>confidential</code>.
     * 
     * @return value
     */
    Sensitivity sensitivity();

    /**
     * The ID for the recurring series master item, if this event is part of a
     * recurring series.
     * 
     * @return value
     */
    ID<Event> seriesMasterId();

    /**
     * The status to show. Possible values are: <code>free</code>,
     * <code>tentative</code>, <code>busy</code>, <code>oof</code>,
     * <code>workingElsewhere</code>,<code>unknown</code>.
     * 
     * @return value
     */
    ShowAs showAs();

    /**
     * A custom identifier specified by a client app for the server to avoid
     * redundant <a href=
     * "https://learn.microsoft.com/en-us/graph/api/calendar-post-events?view=graph-rest-1.0">POST</a>
     * operations in case of client retries to create the same event. This is useful
     * when low network connectivity causes the client to time out before receiving
     * a response from the server for the client's prior create-event request. After
     * you set <strong>transactionId</strong> when creating an event, you cannot
     * change <strong>transactionId</strong> in a subsequent update. This property
     * is only returned in a response payload if an app has set it. Optional.
     * 
     * @return
     */
    String transactionId();

    /**
     * The event type. Possible values are: <code>singleInstance</code>,
     * <code>occurrence</code>, <code>exception</code>, <code>seriesMaster</code>.
     * Read-only
     * 
     * @return value
     */
    Type type();

    /**
     * <p>
     * The URL to open the event in Outlook on the web.
     * </p>
     * <p>
     * Outlook on the web opens the event in the browser if you are signed in to
     * your mailbox. Otherwise, Outlook on the web prompts you to sign in.
     * </p>
     * <p>
     * This URL cannot be accessed from within an iFrame.
     * </p>
     * 
     * @return value
     */
    String webLink();

    // List<Attachment> attachments();
    // Calendar calendar();
    // extensions
    // instances
    // multiValueExtendedProperties
    // singleValueExtendedProperties

    public interface Builder {
        public Event build();

        public Builder start(ZonedDateTime start);

        public Builder end(ZonedDateTime end);

        public Builder subject(String subject);

        public Builder attendees(List<Attendee> attendees);

        public Builder withAttendees(int count, IndexBuilderFunction<Attendee.Builder, Attendee> builder);

        public <T> Builder withAttendees(List<T> input, BiFunction<Attendee.Builder, T, Attendee> builder);

        public Builder allowNewTimeProposals(boolean allowNewTimeProposals);

        public Builder responseRequested(boolean responseRequested);

        public Builder recurrence(PatternedRecurrence recurrence);

        public Builder withRecurrence(Function<PatternedRecurrence.Builder, PatternedRecurrence> builder);
        // public Builder body();
    }
}
