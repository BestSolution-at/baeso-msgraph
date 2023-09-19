package at.bestsolution.baeso.msgraph.impl.model;

import javax.json.JsonObject;

import at.bestsolution.baeso.msgraph.model.EmailAddress;
import at.bestsolution.baeso.msgraph.model.Recipient;

public class RecipientImpl implements Recipient {
    public final JsonObject object;

    public RecipientImpl(JsonObject object) {
        this.object = object;
    }

    @Override
    public EmailAddress emailAddress() {
        return new EmailAddressImpl(object.getJsonObject("emailAddress"));
    }
    
}
