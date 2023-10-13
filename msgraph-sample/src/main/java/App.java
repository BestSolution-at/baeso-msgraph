import at.bestsolution.baeso.msgraph.GraphClient;
import at.bestsolution.baeso.msgraph.msal4j.MSALClientCredentialAuthenticator;

public class App {
    public static void main(String[] args) {
        var auth = new MSALClientCredentialAuthenticator();
        var client = GraphClient.create(auth);

        /*client.users().query().stream()
            .map( user -> user.)
            .forEach( user -> );*/
    }
}
