package at.bestsolution.baeso.msgraph.impl.model;

import at.bestsolution.baeso.msgraph.base.ID;
import at.bestsolution.baeso.msgraph.impl.utils.JsonUtils;
import at.bestsolution.baeso.msgraph.model.User;

import java.time.ZonedDateTime;
import java.util.List;

import jakarta.json.JsonObject;

public class UserImpl implements User {
	private JsonObject object;
	
	public UserImpl(JsonObject object) {
		this.object = object;
	}
	
	@Override
	public ID<User> id() {
		return ID.of(object.getString("id"));
	}

	@Override
	public String userPrincipalName() {
		return object.getString("userPrincipalName");
	}

	@Override
	public String aboutMe() {
		return object.getString("aboutMe");
	}

	@Override
	public boolean accountEnabled() {
		return object.getBoolean("accountEnabled");
	}

	@Override
	public AgeGroup ageGroup() {
		return AgeGroup.of(object.getString("ageGroup"));
	}

	@Override
	public ZonedDateTime birthday() {
		return ZonedDateTime.parse(object.getString("birthday"));
	}

	@Override
	public List<String> businessPhones() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'businessPhones'");
	}

	@Override
	public String city() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'city'");
	}

	@Override
	public String companyName() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'companyName'");
	}

	@Override
	public ConsentProvidedForMinor consentProvidedForMinor() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'consentProvidedForMinor'");
	}

	@Override
	public String country() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'country'");
	}

	@Override
	public ZonedDateTime createdDateTime() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'createdDateTime'");
	}

	@Override
	public String creationType() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'creationType'");
	}

	@Override
	public ZonedDateTime deletedDateTime() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'deletedDateTime'");
	}

	@Override
	public String department() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'department'");
	}

	@Override
	public String displayName() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'displayName'");
	}

	@Override
	public ZonedDateTime employeeHireDate() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'employeeHireDate'");
	}

	@Override
	public ZonedDateTime employeeLeaveDateTime() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'employeeLeaveDateTime'");
	}

	@Override
	public String employeeId() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'employeeId'");
	}

	@Override
	public String employeeType() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'employeeType'");
	}

	@Override
	public String externalUserState() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'externalUserState'");
	}

	@Override
	public ZonedDateTime externalUserStateChangeDateTime() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'externalUserStateChangeDateTime'");
	}

	@Override
	public String faxNumber() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'faxNumber'");
	}

	@Override
	public String givenName() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'givenName'");
	}

	@Override
	public String hireDate() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'hireDate'");
	}

	@Override
	public List<String> imAddresses() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'imAddresses'");
	}

	@Override
	public List<String> interests() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'interests'");
	}

	@Override
	public String jobTitle() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'jobTitle'");
	}

	@Override
	public ZonedDateTime lastPasswordChangeDateTime() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'lastPasswordChangeDateTime'");
	}

	@Override
	public LegalAgeGroupClassification legalAgeGroupClassification() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'legalAgeGroupClassification'");
	}

	@Override
	public String mail() {
		return object.getString("mail");
	}

	@Override
	public String mailNickname() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'mailNickname'");
	}

	@Override
	public String mobilePhone() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'mobilePhone'");
	}

	@Override
	public String mySite() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'mySite'");
	}

	@Override
	public String officeLocation() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'officeLocation'");
	}

	@Override
	public String onPremisesDistinguishedName() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'onPremisesDistinguishedName'");
	}

	@Override
	public String onPremisesDomainName() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'onPremisesDomainName'");
	}

	@Override
	public String onPremisesImmutableId() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'onPremisesImmutableId'");
	}

	@Override
	public ZonedDateTime onPremisesLastSyncDateTime() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'onPremisesLastSyncDateTime'");
	}

	@Override
	public String onPremisesSamAccountName() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'onPremisesSamAccountName'");
	}

	@Override
	public String onPremisesSecurityIdentifier() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'onPremisesSecurityIdentifier'");
	}

	@Override
	public boolean onPremisesSyncEnabled() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'onPremisesSyncEnabled'");
	}

	@Override
	public String onPremisesUserPrincipalName() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'onPremisesUserPrincipalName'");
	}

	@Override
	public List<String> otherMails() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'otherMails'");
	}

	@Override
	public String passwordPolicies() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'passwordPolicies'");
	}

	@Override
	public List<String> pastProjects() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'pastProjects'");
	}

	@Override
	public String postalCode() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'postalCode'");
	}

	@Override
	public String preferredDataLocation() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'preferredDataLocation'");
	}

	@Override
	public String preferredLanguage() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'preferredLanguage'");
	}

	@Override
	public List<String> proxyAddresses() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'proxyAddresses'");
	}

	@Override
	public ZonedDateTime refreshTokensValidFromDateTime() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'refreshTokensValidFromDateTime'");
	}

	@Override
	public List<String> responsibilities() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'responsibilities'");
	}

	@Override
	public List<String> schools() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'schools'");
	}

	@Override
	public String securityIdentifier() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'securityIdentifier'");
	}

	@Override
	public ZonedDateTime signInSessionsValidFromDateTime() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'signInSessionsValidFromDateTime'");
	}

	@Override
	public List<String> skills() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'skills'");
	}

	@Override
	public String state() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'state'");
	}

	@Override
	public String streetAddress() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'streetAddress'");
	}

	@Override
	public String surname() {
		return object.getString("surname", "");
	}

	@Override
	public String usageLocation() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'usageLocation'");
	}

	@Override
	public String userType() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'userType'");
	}

	@Override
    public String toString() {
        return JsonUtils.stringify(object, true);
    }
}
