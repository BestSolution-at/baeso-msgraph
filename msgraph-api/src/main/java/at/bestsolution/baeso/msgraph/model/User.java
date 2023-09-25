package at.bestsolution.baeso.msgraph.model;

import java.time.ZonedDateTime;
import java.util.List;

import at.bestsolution.baeso.msgraph.base.ID;

public interface User {
	public enum AgeGroup {
		NULL("null"),
		MINOR("Minor"),
		NOT_ADULT("NotAdult"),
		ADULT("Adult");

		private final String value;

		AgeGroup(String value) {
			this.value = value;
		}

		public String value() {
			return this.value;
		}

		public static AgeGroup of(String value) {
			return switch (value) {
				case "null" -> NULL;
				case "Minor" -> MINOR;
				case "NotAdult" -> NOT_ADULT;
				case "Adult" -> ADULT;
				default -> throw new IllegalArgumentException(String.format("Unknown value '%s'", value));
			};
		}
	}

	public enum ConsentProvidedForMinor {
		NULL("null"),
		GRANTED("Granted"),
		DENIED("Denied"),
		NOT_REQUIRED("NotRequired");

		private final String value;

		ConsentProvidedForMinor(String value) {
			this.value = value;
		}

		public String value() {
			return this.value;
		}

		public static ConsentProvidedForMinor of(String value) {
			return switch (value) {
				case "null" -> NULL;
				case "Granted" -> GRANTED;
				case "Denied" -> DENIED;
				case "NotRequired" -> NOT_REQUIRED;
				default -> throw new IllegalArgumentException(String.format("Unknown value '%s'", value));
			};
		}
	}

	public enum LegalAgeGroupClassification {
		NULL("null"),
		MINOR_WITHOUT_PARENTAL_CONSENT("MinorWithoutParentalConsent"),
		MINOR_WITHPARENTAL_CONSENT("MinorWithParentalConsent"),
		ADULT("Adult"),
		NOT_ADULT("NotAdult"),
		MINOR_NO_PARENTAL_CONSENT_REQUIRED("MinorNoParentalConsentRequired");

		private final String value;

		LegalAgeGroupClassification(String value) {
			this.value = value;
		}

		public String value() {
			return this.value;
		}

		public static LegalAgeGroupClassification of(String value) {
			return switch (value) {
				case "null" -> NULL;
				case "MinorWithoutParentalConsent" -> MINOR_WITHOUT_PARENTAL_CONSENT;
				case "MinorWithParentalConsent" -> MINOR_WITHPARENTAL_CONSENT;
				case "Adult" -> ADULT;
				case "NotAdult" -> NOT_ADULT;
				case "MinorNoParentalConsentRequired" -> MINOR_NO_PARENTAL_CONSENT_REQUIRED;
				default -> throw new IllegalArgumentException(String.format("Unknown value '%s'", value));
			};
		}
	}

	public ID<User> id();

	/**
	 * A freeform text entry field for the user to describe themselves. Returned
	 * only on <code>$select</code>.
	 * 
	 * @return value
	 */
	String aboutMe();

	/**
	 * <p>
	 * <cod>true</code> if the account is enabled; otherwise, <code>false</code>.
	 * This property is required when a user is created.
	 * </p>
	 * <p>
	 * Returned only on <code>$select</code>. Supports <code>$filter</code>
	 * (<code>eq</code>, <code>ne</code>, <code>not</code>, and <code>in</code>).
	 * </p>
	 * 
	 * @return value
	 */
	boolean accountEnabled();

	/**
	 * <p>
	 * Sets the age group of the user. Allowed values: null, Minor, NotAdult and
	 * Adult. For more information, see <a href=
	 * "https://learn.microsoft.com/en-us/graph/api/resources/user?view=graph-rest-1.0#legal-age-group-property-definitions">legal
	 * age group property definitions</a>.
	 * </p>
	 * <p>
	 * Returned only on <code>$select</code>. Supports <code>$filter</code>
	 * (<code>eq</code>, <code>ne</code>, <code>not</code>, and <code>in</code>).
	 * </p>
	 * 
	 * @return value
	 */
	AgeGroup ageGroup();

	// assignedLicenses
	// assignedPlans
	/**
	 * <p>
	 * The birthday of the user. The Timestamp type represents date and time
	 * information using ISO 8601 format and is always in UTC time. For example,
	 * midnight UTC on Jan 1, 2014 is <code>2014-01-01T00:00:00Z</code>.
	 * </p>
	 * <p>
	 * Returned only on <code>$select</code>.
	 * </p>
	 * 
	 * @return value
	 */
	ZonedDateTime birthday();

	/**
	 * <p>
	 * The telephone numbers for the user. NOTE: Although this is a string
	 * collection, only one number can be set for this property. Read-only for users
	 * synced from on-premises directory.
	 * </p>
	 * <p>
	 * Returned by default. Supports <code>$filter</code> (<code>eq</code>,
	 * <code>not</code>, <code>ge</code>, <code>le</code>, <code>startsWith</code>).
	 * </p>
	 * 
	 * @return value
	 */
	List<String> businessPhones();

	/**
	 * <p>
	 * The city where the user is located. Maximum length is 128 characters.
	 * </p>
	 * <p>
	 * Returned only on <code>$select</code>. Supports <code>$filter</code>
	 * (<code>eq</code>, <code>ne</code>, <code>not</code>, <code>ge</code>,
	 * <code>le</code>, <code>in</code>, <code>startsWith</code>, and
	 * <code>eq</code> on <code>null</code> values).
	 * </p>
	 * 
	 * @return value
	 */
	String city();

	/**
	 * <p>
	 * The name of the company that the user is associated with. This property can
	 * be useful for describing the company that an external user comes from. The
	 * maximum length is 64 characters.
	 * </p>
	 * <p>
	 * Returned only on <code>$select</code>. Supports <code>$filter</code>
	 * (<code>eq</code>, <code>ne</code>, <code>not</code>, <code>ge</code>,
	 * <code>le</code>, <code>in</code>, <code>startsWith</code>, and
	 * <code>eq</code> on <code>null</code> values).
	 * </p>
	 * 
	 * @return value
	 */
	String companyName();

	/**
	 * <p>
	 * Sets whether consent has been obtained for minors. Allowed values: null,
	 * Granted, Denied and NotRequired. Refer to the legal age group property
	 * definitions for further information.
	 * </p>
	 * <p>
	 * Returned only on <code>$select</code>. Supports <code>$filter</code>
	 * (<code>eq</code>, <code>ne</code>, <code>not</code>, and <code>in</code>).
	 * </p>
	 * 
	 * @return value
	 */
	ConsentProvidedForMinor consentProvidedForMinor();

	/**
	 * <p>
	 * The country or region where the user is located; for example, <code>US</code>
	 * or <code>UK</code>. Maximum length is 128 characters.
	 * </p>
	 * <p>
	 * Returned only on <code>$select</code>. Supports <code>$filter</code>
	 * (<code>eq</code>, <code>ne</code>, <code>not</code>, <code>ge</code>,
	 * <code>le</code>, <code>in</code>, <code>startsWith</code>, and
	 * <code>eq</code> on <code>null</code>> values).
	 * </p>
	 * 
	 * @return value
	 */
	String country();

	/**
	 * <p>
	 * The date and time the user was created, in ISO 8601 format and in UTC time.
	 * The value cannot be modified and is automatically populated when the entity
	 * is created. Nullable. For on-premises users, the value represents when they
	 * were first created in Azure AD. Property is <code>null</code> for some users
	 * created
	 * before June 2018 and on-premises users that were synced to Azure AD before
	 * June 2018. Read-only.
	 * </p>
	 * <p>
	 * Returned only on <code>$select</code>. Supports <code>$filter</code>
	 * (<code>eq</code>, <code>ne</code>, <code>not</code>, <code>ge</code>,
	 * <code>le</code>, <code>in</code>).
	 * </p>
	 * 
	 * @return value
	 */
	ZonedDateTime createdDateTime();

	/**
	 * Indicates whether the user account was created through one of the following
	 * methods:
	 * <ul>
	 * <li>As a regular school or work account (<code>null</code>).</li>
	 * <li>As an external account (<code>Invitation</code>).</li>
	 * <li>As a local account for an Azure Active Directory B2C tenant
	 * (<code>LocalAccount</code>).</li>
	 * <li>Through self-service sign-up by an internal user using email verification
	 * (<code>EmailVerified</code>).</li>
	 * <li>Through self-service sign-up by an external user signing up through a
	 * link that is part of a user flow (<code>SelfServiceSignUp</code>).</li>
	 * </ul>
	 * <p>
	 * Read-only.
	 * </p>
	 * <p>
	 * Returned only on <code>$select</code>. Supports <code>$filter</code>
	 * (<code>eq</code>, <code>ne</code>, <code>not</code>, <code>in</code>).
	 * </p>
	 * 
	 * @return value
	 */
	String creationType();

	/**
	 * The date and time the user was deleted.
	 * <p>
	 * Returned only on <code>$select</code>. Supports <code>$filter</code>
	 * (<code>eq</code>, <code>ne</code>, <code>not</code>, <code>ge</code>,
	 * <code>le</code>, <code>in</code>).
	 * </p>
	 * 
	 * @return value
	 */
	ZonedDateTime deletedDateTime();

	/**
	 * The name for the department in which the user works. Maximum length is 64
	 * characters.
	 * <p>
	 * Returned only on <code>$select</code>. Supports <code>$filter</code>
	 * (<code>eq</code>, <code>ne</code>, <code>not</code>, <code>ge</code>,
	 * <code>le</code>, <code>in</code>, and <code>eq</code> on <code>null</code>
	 * values).
	 * </p>
	 * 
	 * @return value
	 */
	String department();

	/**
	 * The name displayed in the address book for the user. This is usually the
	 * combination of the user's first name, middle initial and last name. This
	 * property is required when a user is created and it cannot be cleared during
	 * updates. Maximum length is 256 characters.
	 * <p>
	 * Returned by default. Supports <code>$filter</code> (<code>eq</code>,
	 * <code>ne</code>, <code>not</code>, <code>ge</code>, <code>le</code>,
	 * <code>in</code>, <code>startsWith</code>, and <code>eq</code> on
	 * <code>null</code> values), <code>$orderby</code>, and <code>$search</code> .
	 * </p>
	 * 
	 * @return value
	 */
	String displayName();

	/**
	 * The date and time when the user was hired or will start work in case of a
	 * future hire.
	 * <p>
	 * Returned only on <code>$select</code>. Supports <code>$filter</code>
	 * (<code>eq</code>, <code>ne</code>, <code>not</code>, <code>ge</code>,
	 * <code>le</code>, <code>in</code>).
	 * </p>
	 * 
	 * @return value
	 */
	ZonedDateTime employeeHireDate();

	/**
	 * The date and time when the user left or will leave the organization.
	 * <p>
	 * To read this property, the calling app must be assigned the
	 * <em>User-LifeCycleInfo.Read.All</em> permission. To write this property, the
	 * calling
	 * app must be assigned the <em>User.Read.All</em> and
	 * <em>User-LifeCycleInfo.ReadWrite.All</em>
	 * permissions. To read this property in delegated scenarios, the admin needs
	 * one of the following Azure AD roles: <em>Lifecycle Workflows
	 * Administrator</em>,
	 * <em>Global Reader</em>, or <em>Global Administrator</em>. To write this
	 * property in delegated
	 * scenarios, the admin needs the <em>Global Administrator</em> role.
	 * </p>
	 * <p>
	 * Supports <code>$filter</code> (<code>eq</code>, <code>ne</code>,
	 * <code>not</code>, <code>ge</code>, <code>le</code>, <code>in</code>).
	 * </p>
	 * <p>
	 * For more information, see <a href=
	 * "https://learn.microsoft.com/en-us/graph/tutorial-lifecycle-workflows-set-employeeleavedatetime">Configure
	 * the employeeLeaveDateTime property for a user</a>.
	 * </p>
	 * 
	 * @return value
	 */
	ZonedDateTime employeeLeaveDateTime();

	/**
	 * The employee identifier assigned to the user by the organization. The maximum
	 * length is 16 characters.
	 * <p>
	 * Returned only on <code>$select</code>. Supports <code>$filter</code>
	 * (<code>eq</code>, <code>ne</code>, <code>not</code>, <code>ge</code>,
	 * <code>le</code>, <code>in</code>, <code>startsWith</code>, and
	 * <code>eq</code> on <code>null</code> values).
	 * </p>
	 * 
	 * @return
	 */
	String employeeId();

	/**
	 * Captures enterprise worker type. For example, <code>Employee</code>,
	 * <code>Contractor</code>, <code>Consultant</code>, or <code>Vendor</code>.
	 * <p>
	 * Returned only on <code>$select</code>. Supports <code>$filter</code>
	 * (<code>eq</code>, <code>ne</code>, <code>not</code>, <code>ge</code>,
	 * <code>le</code>, <code>in</code>, <code>startsWith</code>).
	 * </p>
	 * 
	 * @return value
	 */
	String employeeType();

	/**
	 * For an external user invited to the tenant using the <a href=
	 * "https://learn.microsoft.com/en-us/graph/api/invitation-post?view=graph-rest-1.0">invitation
	 * API</a>, this property represents the invited user's invitation status. For
	 * invited users, the state can be <code>PendingAcceptance</code> or
	 * <code>Accepted</code>, or <code>null</code> for
	 * all other users.
	 * <p>
	 * Returned only on <code>$select</code>. Supports <code>$filter</code>
	 * (<code>eq</code>, <code>ne</code>, <code>not</code>, <code>in</code>).
	 * </p>
	 * 
	 * @return value
	 */
	String externalUserState();

	/**
	 * Shows the timestamp for the latest change to the
	 * <strong>externalUserState</strong> property.
	 * <p>
	 * Returned only on <code>$select</code>. Supports <code>$filter</code>
	 * (<code>eq</code>, <code>ne</code>, <code>not</code>, <code>in</code>).
	 * </p>
	 * 
	 * @return value
	 */
	ZonedDateTime externalUserStateChangeDateTime();

	/**
	 * The fax number of the user.
	 * <p>
	 * Returned only on <code>$select</code>. Supports <code>$filter</code>
	 * (<code>eq</code>, <code>ne</code>, <code>not</code>, <code>ge</code>,
	 * <code>le</code>, <code>in</code>, <code>startsWith</code>, and
	 * <code>eq</code> on <code>null</code> values).
	 * </p>
	 * 
	 * @return value
	 */
	String faxNumber();

	/**
	 * The given name (first name) of the user. Maximum length is 64 characters.
	 * <p>
	 * Returned by default. Supports <code>$filter</code> (<code>eq</code>,
	 * <code>ne</code>, <code>not</code>, <code>ge</code>, <code>le</code>,
	 * <code>in</code>, <code>startsWith</code>, and <code>eq</code> on
	 * <code>null</code> values).
	 * </p>
	 * 
	 * @return value
	 */
	String givenName();

	/**
	 * The hire date of the user. The Timestamp type represents date and time
	 * information using ISO 8601 format and is always in UTC time. For example,
	 * midnight UTC on Jan 1, 2014 is <code>2014-01-01T00:00:00Z</code>.
	 * <p>
	 * Returned only on $select.
	 * </p>
	 * <p>
	 * <strong>Note</strong>: This property is specific to SharePoint Online. We
	 * recommend using the
	 * native <strong>employeeHireDate</strong> property to set and update hire date
	 * values using
	 * Microsoft Graph APIs.
	 * </p>
	 * 
	 * @return value
	 */
	String hireDate();

	/**
	 * The instant message voice over IP (VOIP) session initiation protocol (SIP)
	 * addresses for the user. Read-only.
	 * <p>
	 * Returned only on <code>$select</code>. Supports <code>$filter</code>
	 * (<code>eq</code>, <code>not</code>, <code>ge</code>, <code>le</code>,
	 * <code>startsWith</code>).
	 * </p>
	 * 
	 * @return value
	 */
	List<String> imAddresses();

	/**
	 * A list for the user to describe their interests.
	 * <p>
	 * Returned only on <code>$select</code>.
	 * </p>
	 * 
	 * @return value
	 */
	List<String> interests();

	/**
	 * The user's job title. Maximum length is 128 characters.
	 * <p>
	 * Returned by default. Supports <code>$filter</code> (<code>eq</code>,
	 * <code>ne</code>, <code>not</code>, <code>ge</code>, <code>le</code>,
	 * <code>in</code>, <code>startsWith</code>, and <code>eq</code> on
	 * <code>null</code> values).
	 * </p>
	 * 
	 * @return value
	 */
	String jobTitle();

	/**
	 * The time when this Azure AD user last changed their password or when their
	 * password was created, whichever date the latest action was performed. The
	 * date and time information uses ISO 8601 format and is always in UTC time. For
	 * example, midnight UTC on Jan 1, 2014 is <code>2014-01-01T00:00:00Z</code>.
	 * <p>
	 * Returned only on $select.
	 * </p>
	 * 
	 * @return value
	 */
	ZonedDateTime lastPasswordChangeDateTime();

	/**
	 * Used by enterprise applications to determine the legal age group of the user.
	 * This property is read-only and calculated based on ageGroup and
	 * consentProvidedForMinor properties. Allowed values: <code>null</code>,
	 * <code>MinorWithOutParentalConsent</code>,
	 * <code>MinorWithParentalConsent</code>,
	 * <code>MinorNoParentalConsentRequired</code>, <code>NotAdult</code> and
	 * <code>Adult</code>. Refer to the <a href=
	 * "https://learn.microsoft.com/en-us/graph/api/resources/user?view=graph-rest-1.0#legal-age-group-property-definitions">legal
	 * age group property definitions</a> for further information.
	 * 
	 * @return value
	 */
	LegalAgeGroupClassification legalAgeGroupClassification();

	/**
	 * The SMTP address for the user, for example,
	 * <code>jeff@contoso.onmicrosoft.com</code>.
	 * Changes to this property will also update the user's
	 * <strong>proxyAddresses</strong>
	 * collection to include the value as an SMTP address. This property can't
	 * contain accent characters.
	 * <p>
	 * <strong>NOTE</strong>: We don't recommend updating this property for Azure AD
	 * B2C user profiles. Use the <strong>otherMails</strong> property instead.
	 * </p>
	 * <p>
	 * Returned by default. Supports <code>$filter</code> (<code>eq</code>,
	 * <code>ne</code>, <code>not</code>, <code>ge</code>, <code>le</code>,
	 * <code>in</code>, <code>startsWith</code>, <code>endsWith</code>, and
	 * <code>eq</code> on <code>null</code> values).
	 * </p>
	 * 
	 * @return value
	 */
	String mail();

	/**
	 * The mail alias for the user. This property must be specified when a user is
	 * created. Maximum length is 64 characters.
	 * <p>
	 * Returned only on <code>$select</code>. Supports <code>$filter</code>
	 * (<code>eq</code>, <code>ne</code>, <code>not</code>, <code>ge</code>,
	 * <code>le</code>, <code>in</code>, <code>startsWith</code>, and
	 * <code>eq</code> on <code>null</code> values).
	 * </p>
	 * 
	 * @return value
	 */
	String mailNickname();

	/**
	 * The primary cellular telephone number for the user. Read-only for users
	 * synced from on-premises directory. Maximum length is 64 characters.
	 * <p>
	 * Returned by default. Supports <code>$filter</code> (<code>eq</code>,
	 * <code>ne</code>, <code>not</code>, <code>ge</code>, <code>le</code>,
	 * <code>in</code>, <code>startsWith</code>, and <code>eq</code> on
	 * <code>null</code> values) and <code>$search</code>.
	 * </p>
	 * 
	 * @return value
	 */
	String mobilePhone();

	/**
	 * The URL for the user's personal site.
	 * <p>
	 * Returned only on <code>$select</code>.
	 * </p>
	 * 
	 * @return value
	 */
	String mySite();

	/**
	 * The office location in the user's place of business.
	 * <p>
	 * Returned by default. Supports <code>$filter</code> (<code>eq</code>,
	 * <code>ne</code>, <code>not</code>, <code>ge</code>, <code>le</code>,
	 * <code>in</code>, <code>startsWith</code>, and <code>eq</code> on
	 * <code>null</code> values).
	 * </p>
	 * 
	 * @return value
	 */
	String officeLocation();

	/**
	 * Contains the on-premises Active Directory <code>distinguished name</code> or
	 * <code>DN</code>. The
	 * property is only populated for customers who are synchronizing their
	 * on-premises directory to Azure Active Directory via Azure AD Connect.
	 * Read-only.
	 * <p>
	 * Returned only on <code>$select</code>.
	 * </p>
	 * 
	 * @return value
	 */
	String onPremisesDistinguishedName();

	/**
	 * Contains the on-premises <code>domainFQDN</code>, also called dnsDomainName
	 * synchronized
	 * from the on-premises directory. The property is only populated for customers
	 * who are synchronizing their on-premises directory to Azure Active Directory
	 * via Azure AD Connect. Read-only.
	 * <p>
	 * Returned only on <code>$select</code>.
	 * </p>
	 * 
	 * @return value
	 */
	String onPremisesDomainName();

	/**
	 * This property is used to associate an on-premises Active Directory user
	 * account to their Azure AD user object. This property must be specified when
	 * creating a new user account in the Graph if you're using a federated domain
	 * for the user's <strong>userPrincipalName</strong> (UPN) property.
	 * <p>
	 * <strong>NOTE</strong>: The <strong>$</strong> and _ characters can't be used
	 * when specifying this property.
	 * </p>
	 * <p>
	 * Returned only on <code>$select</code>. Supports <code>$filter</code>
	 * (<code>eq</code>, <code>ne</code>, <code>not</code>, <code>ge</code>,
	 * <code>le</code>, <code>in</code>).
	 * </p>
	 * 
	 * @return value
	 */
	String onPremisesImmutableId();

	/**
	 * Indicates the last time at which the object was synced with the on-premises
	 * directory; for example: <code>2013-02-16T03:04:54Z</code>. The Timestamp type
	 * represents
	 * date and time information using ISO 8601 format and is always in UTC time.
	 * For example, midnight UTC on Jan 1, 2014 is
	 * <code>2014-01-01T00:00:00Z</code>. Read-only.
	 * <p>
	 * Returned only on <code>$select</code>. Supports <code>$filter</code>
	 * (<code>eq</code>, <code>ne</code>, <code>not</code>, <code>ge</code>,
	 * <code>le</code>, <code>in</code>).
	 * </p>
	 * 
	 * @return value
	 */
	ZonedDateTime onPremisesLastSyncDateTime();

	/**
	 * Contains the on-premises <code>samAccountName</code> synchronized from the
	 * on-premises
	 * directory. The property is only populated for customers who are synchronizing
	 * their on-premises directory to Azure Active Directory via Azure AD Connect.
	 * Read-only.
	 * <p>
	 * Returned only on <code>$select</code>. Supports <code>$filter</code>
	 * (<code>eq</code>, <code>ne</code>, <code>not</code>, <code>ge</code>,
	 * <code>le</code>, <code>in</code>, <code>startsWith</code>).
	 * </p>
	 * 
	 * @return value
	 */
	String onPremisesSamAccountName();

	/**
	 * Contains the on-premises security identifier (SID) for the user that was
	 * synchronized from on-premises to the cloud. Read-only.
	 * <p>
	 * Returned only on <code>$select</code>. Supports <code>$filter</code>
	 * (<code>eq</code> including on <code>null</code> values).
	 * </p>
	 * 
	 * @return value
	 */
	String onPremisesSecurityIdentifier();

	/**
	 * <code>true</code> if this user object is currently being synced from an
	 * on-premises Active
	 * Directory (AD); otherwise the user isn't being synced and can be managed in
	 * Azure Active Directory (Azure AD). Read-only.
	 * <p>
	 * Returned only on <code>$select</code>. Supports <code>$filter</code>
	 * (<code>eq</code>, <code>ne</code>, <code>not</code>, <code>in</code>, and
	 * <code>eq</code> on <code>null</code> values).
	 * </p>
	 * 
	 * @return value
	 */
	boolean onPremisesSyncEnabled();

	/**
	 * Contains the on-premises <code>userPrincipalName</code> synchronized from the
	 * on-premises
	 * directory. The property is only populated for customers who are synchronizing
	 * their on-premises directory to Azure Active Directory via Azure AD Connect.
	 * Read-only.
	 * <p>
	 * Returned only on <code>$select</code>. Supports <code>$filter</code>
	 * (<code>eq</code>, <code>ne</code>, <code>not</code, <code>ge</code>,
	 * <code>le</code>, <code>in</code>, <code>startsWith</code>).
	 * </p>
	 * 
	 * @return value
	 */
	String onPremisesUserPrincipalName();

	/**
	 * A list of additional email addresses for the user; for example:
	 * <code>["bob@contoso.com", "Robert@fabrikam.com"]</code>.
	 * <p>
	 * <strong>NOTE</strong>: This property can't contain accent characters.
	 * </p>
	 * <p>
	 * Returned only on <code>$select</code>. Supports <code>$filter</code>
	 * (<code>eq</code>, <code>not</code>, <code>ge</code>, <code>le</code>,
	 * <code>in</code>, <code>startsWith</code>, <codeYendsWith</code>,
	 * <code>/$count eq 0</code>, <code>/$count ne 0</code>).
	 * </p>
	 * 
	 * @return value
	 */
	List<String> otherMails();

	/**
	 * Specifies password policies for the user. This value is an enumeration with
	 * one possible value being <code>DisableStrongPassword</code>, which allows
	 * weaker passwords
	 * than the default policy to be specified.
	 * <code>DisablePasswordExpiration</code> can also
	 * be specified. The two may be specified together; for example:
	 * <code>DisablePasswordExpiration</code>, <code>DisableStrongPassword</code>.
	 * <p>
	 * Returned only on <code>$select</code>. For more information on the default
	 * password
	 * policies, see <a href=
	 * "https://learn.microsoft.com/en-us/azure/active-directory/authentication/concept-sspr-policy#password-policies-that-only-apply-to-cloud-user-accounts">Azure
	 * AD password policies</a>. Supports <code>$filter</code> (<code>ne</code>,
	 * <code>not</code>, and <code>eq</code> on <code>null</code> values).
	 * </p>
	 * 
	 * @return value
	 */
	String passwordPolicies();

	/**
	 * A list for the user to enumerate their past projects.
	 * <p>
	 * Returned only on <code>$select</code>.
	 * </p>
	 * 
	 * @return value
	 */
	List<String> pastProjects();

	/**
	 * The postal code for the user's postal address. The postal code is specific to
	 * the user's country/region. In the United States of America, this attribute
	 * contains the ZIP code. Maximum length is 40 characters.
	 * <p>
	 * Returned only on <code>$select</code>. Supports <code>$filter</code>
	 * (<code>eq</code>, <code>ne</code>, <code>not</code>, <code>ge</code>,
	 * <code>le</code>, <code>in</code>, <code>startsWith</code>, and
	 * <code>eq</code> on <code>null</code> values).
	 * </p>
	 * 
	 * @return value
	 */
	String postalCode();

	/**
	 * The preferred data location for the user. For more information, see <a href=
	 * "https://learn.microsoft.com/en-us/sharepoint/dev/solution-guidance/multigeo-introduction">OneDrive
	 * Online Multi-Geo</a>.
	 * 
	 * @return value
	 */
	String preferredDataLocation();

	/**
	 * The preferred language for the user. The preferred language format is based
	 * on RFC 4646. The name is a combination of an ISO 639 two-letter lowercase
	 * culture code associated with the language, and an ISO 3166 two-letter
	 * uppercase subculture code associated with the country or region. Example:
	 * "en-US", or "es-ES".
	 * <p>
	 * Returned by default. Supports <code>$filter</code> (<code>eq</code>,
	 * <code>ne</code>, <code>not</code>, <code>ge</code>, <code>le</code>,
	 * <code>in</code>, <code<startsWith</code>, and <code>eq</code> on
	 * <code>null</code> values)
	 * </p>
	 * 
	 * @return value
	 */
	String preferredLanguage();

	/**
	 * For example:
	 * <code>["SMTP: bob@contoso.com", "smtp: bob@sales.contoso.com"]</code>.
	 * Changes to the <strong>mail</strong> property will also update this
	 * collection to include the
	 * value as an SMTP address. For more information, see <a href=
	 * "https://learn.microsoft.com/en-us/graph/api/resources/user?view=graph-rest-1.0#mail-and-proxyaddresses-properties">mail
	 * and proxyAddresses properties</a>. The proxy address prefixed with SMTP
	 * (capitalized) is the primary proxy address while those prefixed with smtp are
	 * the secondary proxy addresses. For Azure AD B2C accounts, this property has a
	 * limit of 10 unique addresses. Read-only in Microsoft Graph; you can update
	 * this property only through the Microsoft 365 admin center. Not nullable.
	 * 
	 * @return value
	 */
	List<String> proxyAddresses();

	/**
	 * Any refresh tokens or sessions tokens (session cookies) issued before this
	 * time are invalid, and applications get an error when using an invalid refresh
	 * or sessions token to acquire a delegated access token (to access APIs such as
	 * Microsoft Graph). If this happens, the application needs to acquire a new
	 * refresh token by making a request to the authorize endpoint.
	 * <p>
	 * Returned only on <code>$select</code>. Read-only.
	 * </p>
	 * 
	 * @return value
	 */
	ZonedDateTime refreshTokensValidFromDateTime();

	/**
	 * A list for the user to enumerate their responsibilities.
	 * <p>
	 * Returned only on <code>$select</code>.
	 * </p>
	 * 
	 * @return value
	 */
	List<String> responsibilities();

	/**
	 * A list for the user to enumerate the schools they have attended.
	 * <p>
	 * Returned only on <code>$select</code>.
	 * </p>
	 * 
	 * @return value
	 */
	List<String> schools();

	/**
	 * Security identifier (SID) of the user, used in Windows scenarios.
	 * <p>
	 * Read-only. Returned by default.
	 * </p>
	 * <p>
	 * Supports <code>$select</code> and <code>$filter</code> (<code>eq</code>,
	 * <code>not</code>, <code>ge</code>, <code>le</code>, <code>startsWith</code>).
	 * </p>
	 * 
	 * @return value
	 */
	String securityIdentifier();

	/**
	 * Any refresh tokens or sessions tokens (session cookies) issued before this
	 * time are invalid, and applications get an error when using an invalid refresh
	 * or sessions token to acquire a delegated access token (to access APIs such as
	 * Microsoft Graph). If this happens, the application needs to acquire a new
	 * refresh token by making a request to the authorize endpoint. Read-only. Use
	 * <a href=
	 * "https://learn.microsoft.com/en-us/graph/api/user-revokesigninsessions?view=graph-rest-1.0">revokeSignInSessions</a>
	 * to reset.
	 * <p>
	 * Returned only on <code>$select</code>.
	 * </p>
	 * 
	 * @return value
	 */
	ZonedDateTime signInSessionsValidFromDateTime();

	/**
	 * A list for the user to enumerate their skills.
	 * <p>
	 * Returned only on $select.
	 * </p>
	 * 
	 * @return value
	 */
	List<String> skills();

	/**
	 * The state or province in the user's address. Maximum length is 128
	 * characters.
	 * <p>
	 * Returned only on <code>$select</code>. Supports <code>$filter</code>
	 * (<code>eq</code>, <code>ne</code>, <code>not</code>, <code>ge</code>,
	 * <code>le</code>, <code>in</code>, <code>startsWith</code>, and
	 * <code>eq</code> on <code>null</code> values).
	 * </p>
	 * 
	 * @return value
	 */
	String state();

	/**
	 * The street address of the user's place of business. Maximum length is 1024
	 * characters.
	 * <p>
	 * Returned only on <code>$select</code>. Supports <code>$filter</code>
	 * (<code>eq</code>, <code>ne</code>, <code>not</code>, <code>ge</code>,
	 * <code>le</code>, <code>in</code>, <code>startsWith</code>, and
	 * <code>eq</code> on <code>null</code> values).
	 * </p>
	 * 
	 * @return value
	 */
	String streetAddress();

	/**
	 * The user's surname (family name or last name). Maximum length is 64
	 * characters.
	 * <p>
	 * Returned by default. Supports <code>$filter</code>
	 * (<code>eq</code>, <code>ne</code>, <code>not</code>, <code>ge</code>,
	 * <code>le</code>, <code>in</code>, <code>startsWith</code>, and
	 * <code>eq</code> on <code>null</code> values).
	 * </p>
	 * 
	 * @return value
	 */
	String surname();

	/**
	 * A two letter country code (ISO standard 3166). Required for users that are
	 * assigned licenses due to legal requirement to check for availability of
	 * services in countries. Examples include: <code>US</code>, <code>JP</code>,
	 * and <code>GB</code>. Not nullable.
	 * <p>
	 * Returned only on <code>$select</code>. Supports <code>$filter</code>
	 * (<code>eq</code>, <code>ne</code>, <code>not</code>, <code>ge</code>,
	 * <code>le</code>, <code>in</code>, <code>startsWith</code>, and
	 * <code>eq</code> on <code>null</code> values).
	 * </p>
	 * 
	 * @return
	 */
	String usageLocation();

	/**
	 * The user principal name (UPN) of the user. The UPN is an Internet-style
	 * sign-in name for the user based on the Internet standard RFC 822. By
	 * convention, this should map to the user's email name. The general format is
	 * alias@domain, where domain must be present in the tenant's collection of
	 * verified domains. This property is required when a user is created. The
	 * verified domains for the tenant can be accessed from the
	 * <strong>verifiedDomains</strong> property of <a href=
	 * "https://learn.microsoft.com/en-us/graph/api/resources/organization?view=graph-rest-1.0">organization</a>.
	 * <p>
	 * <strong>NOTE</strong>: This property can't contain accent characters. Only
	 * the following
	 * characters are allowed <code>A - Z</code>, <code>a - z</code>,
	 * <code>0 - 9</code>, <code>' . - _ ! # ^ ~</code>. For the complete
	 * list of allowed characters, see <a href=
	 * "https://learn.microsoft.com/en-us/azure/active-directory/authentication/concept-sspr-policy#userprincipalname-policies-that-apply-to-all-user-accounts">username
	 * policies</a>.
	 * </p>
	 * <p>
	 * Returned by default. Supports <code>$filter</code> (<code>eq</code>,
	 * <code>ne</code>, <code>not</code>, <code>ge</code>, <code>le</code>,
	 * <code>in</code>, <code>startsWith</code>, <code>endsWith</code>) and
	 * <code>$orderby</code>.
	 * </p>
	 * 
	 * @return value
	 */
	String userPrincipalName();

	/**
	 * A string value that can be used to classify user types in your directory,
	 * such as <code>Member</code> and <code>Guest</code>.
	 * <p>
	 * Returned only on <code>$select</code>. Supports <code>$filter</code>
	 * (<code>eq</code>, <code>ne</code>, <code>not</code>, <code<in</code>, and
	 * <code>eq</code> on <code>null</code> values).
	 * </p>
	 * <p>
	 * <strong>NOTE</strong>: For more information about the permissions for member
	 * and
	 * guest users, see What are the default user permissions in Azure Active
	 * Directory?
	 * </p>
	 * 
	 * @return value
	 */
	String userType();

	// customSecurityAttributes
	// employeeOrgData
	// identities
	// boolean isResourceAccount();
	// licenseAssignmentStates
	// String mailboxSettings();
	// String onPremisesExtensionAttributes();
	// onPremisesProvisioningErrors
	// passwordProfile
	// String preferredName();
	// provisionedPlans
	// boolean showInAddressList();
	// signInActivity

}
