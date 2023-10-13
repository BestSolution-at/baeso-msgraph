package at.bestsolution.baeso.msgraph.model;

import java.util.function.Function;

import at.bestsolution.baeso.msgraph.base.MsGraphData;

/**
 * The recurrence pattern and range. This shared object is used to define the
 * recurrence of the following objects:
 * <ul>
 * <li><a href=
 * "https://learn.microsoft.com/en-us/graph/api/resources/accessreviewscheduledefinition?view=graph-rest-1.0">accessReviewScheduleDefinition</a>
 * objects in Azure AD access reviews APIs</li>
 * <li><a href=
 * "https://learn.microsoft.com/en-us/graph/api/resources/event?view=graph-rest-1.0">event</a>
 * objects in the calendar API</li>
 * <li><a href=
 * "https://learn.microsoft.com/en-us/graph/api/resources/unifiedroleassignmentschedulerequest?view=graph-rest-1.0">unifiedRoleAssignmentScheduleRequest</a>
 * and <a href=
 * "https://learn.microsoft.com/en-us/graph/api/resources/unifiedroleeligibilityschedulerequest?view=graph-rest-1.0">unifiedRoleEligibilityScheduleRequest</a>
 * objects in PIM</li>
 * <li><a href=
 * "https://learn.microsoft.com/en-us/graph/api/resources/accesspackageassignment?view=graph-rest-1.0">accessPackageAssignment</a>
 * objects in Azure AD entitlement management.</li>
 * </ul>
 */
public interface PatternedRecurrence extends MsGraphData {
    /**
     * <p>
     * The frequency of an event.
     * </p>
     * For access reviews:
     * <ul>
     * <li>Do not specify this property for a one-time access review.</li>
     * <li>Only <strong>interval</strong>, <strong>dayOfMonth</strong>, and
     * <strong>type</strong> (<code>weekly</code>, <code>absoluteMonthly</code>)
     * properties of recurrencePattern are supported.</li>
     * </ul>
     * 
     * @return the value
     */
    public RecurrencePattern pattern();

    /**
     * The duration of an event.
     * 
     * @return the value
     */
    public RecurrenceRange range();

    public interface Builder {
        public PatternedRecurrence build();

        public Builder pattern(RecurrencePattern pattern);

        public Builder withPattern(Function<RecurrencePattern.Builder, RecurrencePattern> builder);

        public Builder range(RecurrenceRange range);

        public Builder withRange(Function<RecurrenceRange.Builder, RecurrenceRange> builder);
    }
}
