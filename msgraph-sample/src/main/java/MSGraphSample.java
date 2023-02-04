
import at.bestsolution.baeso.msgraph.GraphClient;
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
    }
}
