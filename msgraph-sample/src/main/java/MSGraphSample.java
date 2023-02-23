
import java.time.LocalDate;

import at.bestsolution.baeso.msgraph.GraphClient;
import at.bestsolution.baeso.msgraph.base.ID;
import at.bestsolution.baeso.msgraph.model.Calendar;
import at.bestsolution.baeso.msgraph.model.User;
import at.bestsolution.baeso.msgraph.msal4j.MSALClientCredentialAuthenticator;

public class MSGraphSample {
    public static void main(String[] args) {
        var auth = new MSALClientCredentialAuthenticator();
        var client = GraphClient.create(auth);
        client.users()
            .query()
            .stream()
            .map(User::userPrincipalName)
            .forEach(System.err::println);
        
        /*client.users()
            .calendars(args[0])
            .query()
            .stream()
            .map(c -> c.name() + " - " + c.id().id)
            .forEach(System.err::println);*/
        /*client.users()
            .calendars(args[0])
            .view(ID.of(args[1]), LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 31))
            .map( e -> e.subject() + " / " + e.start().toLocalDateTime() + " - " + e.end().toLocalDateTime() )
            .findFirst()
            .ifPresent(System.err::println)*/;
    }
}
