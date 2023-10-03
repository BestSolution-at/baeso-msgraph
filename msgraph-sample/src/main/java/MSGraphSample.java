
import java.sql.Date;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import at.bestsolution.baeso.msgraph.GraphClient;
import at.bestsolution.baeso.msgraph.base.ID;
import at.bestsolution.baeso.msgraph.model.Attendee;
import at.bestsolution.baeso.msgraph.model.Calendar;
import at.bestsolution.baeso.msgraph.model.Event;
import at.bestsolution.baeso.msgraph.model.EventUpdate;
import at.bestsolution.baeso.msgraph.model.User;
import at.bestsolution.baeso.msgraph.model.AttendeeBase.Type;
import at.bestsolution.baeso.msgraph.model.RecurrencePattern.RecurrencePatternType;
import at.bestsolution.baeso.msgraph.model.RecurrenceRange.RecurrenceRangeType;
import at.bestsolution.baeso.msgraph.msal4j.MSALClientCredentialAuthenticator;

public class MSGraphSample {
    public static void main(String[] args) {
        var auth = new MSALClientCredentialAuthenticator();
        var client = GraphClient.create(auth);


    }
}
