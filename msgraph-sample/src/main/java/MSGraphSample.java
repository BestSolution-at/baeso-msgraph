
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import at.bestsolution.baeso.msgraph.GraphClient;
import at.bestsolution.baeso.msgraph.base.ID;
import at.bestsolution.baeso.msgraph.model.Calendar;
import at.bestsolution.baeso.msgraph.model.Event;
import at.bestsolution.baeso.msgraph.model.User;
import at.bestsolution.baeso.msgraph.msal4j.MSALClientCredentialAuthenticator;

public class MSGraphSample {
    public static void main(String[] args) {
        var auth = new MSALClientCredentialAuthenticator();
        var client = GraphClient.create(auth);

        //client.users().calendars(args[0]);

        /*var event = client.createBuilder(Event.Builder.class)
            .subject("Hello World")
            .start(ZonedDateTime.of(LocalDate.now(), LocalTime.of(10, 0, 0), ZoneId.systemDefault()))
            .end(ZonedDateTime.of(LocalDate.now(), LocalTime.of(10, 0, 0), ZoneId.systemDefault()).plusHours(1))
            .build();

        client.users().calendars(args[0]).create(ID.of(args[1]), event);*/

/*        client.users()
            .query()
            .stream()
            .map(User::userPrincipalName)
            .filter( n -> args[0].equals(n))
            .forEach(System.err::println);
        
        client.users()
            .calendars(args[0])
            .query()
            .stream()
            .map(c -> "KALENDAR: " +  c.name() + " - " + c.id().id)
            .forEach(System.err::println);
        System.err.println("-----------");*/
        /*var groupResource = client.users().calendarsGroups(args[0]);

        groupResource
            .query()
            .stream()
            .forEach( cg -> {
                System.err.println("----------------------");
                System.err.println(cg.name());
                System.err.println("----------------------");
                groupResource.calendars(cg.id())
                    .map(c -> "KALENDAR: " +  c.name() + " - " + c.id().id)
                    .forEach(System.err::println);
            });
        */

        client.users()
            .calendars(args[0])
            .view(ID.of(args[1]), LocalDate.of(2023, 3, 1), LocalDate.of(2023, 3, 31))
            .map( e -> e.subject() + " / " + e.start().toLocalDateTime() + " - " + e.end().toLocalDateTime() )
            .forEach(System.err::println);
    }
}
