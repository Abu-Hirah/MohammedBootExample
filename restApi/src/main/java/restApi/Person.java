package restApi;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the person database table.
 * 
 */
@Entity
@NamedQuery(name="Person.findAll", query="SELECT p FROM Person p")
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="person_id")
	private int personId;

	@Temporal(TemporalType.DATE)
	@Column(name="date_of_birth")
	private Date dateOfBirth;

	@Column(name="first_name")
	private String firstName;

	private String gender;

	@Column(name="last_name")
	private String lastName;

	@Column(name="middle_name")
	private String middleName;

	@Column(name="organizational_id")
	private int organizationalId;

	@Column(name="other_person_details")
	private String otherPersonDetails;

	//bi-directional many-to-one association to PeopleRole
	@OneToMany(mappedBy="person")
	private List<PeopleRole> peopleRoles;

	//bi-directional many-to-one association to Organization
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Organizations_organization_id")
	private Organization organization;

	//bi-directional many-to-one association to PersonAddress
	@OneToMany(mappedBy="person")
	private List<PersonAddress> personAddresses;

	public Person() {
	}

	public int getPersonId() {
		return this.personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public int getOrganizationalId() {
		return this.organizationalId;
	}

	public void setOrganizationalId(int organizationalId) {
		this.organizationalId = organizationalId;
	}

	public String getOtherPersonDetails() {
		return this.otherPersonDetails;
	}

	public void setOtherPersonDetails(String otherPersonDetails) {
		this.otherPersonDetails = otherPersonDetails;
	}

	public List<PeopleRole> getPeopleRoles() {
		return this.peopleRoles;
	}

	public void setPeopleRoles(List<PeopleRole> peopleRoles) {
		this.peopleRoles = peopleRoles;
	}

	public PeopleRole addPeopleRole(PeopleRole peopleRole) {
		getPeopleRoles().add(peopleRole);
		peopleRole.setPerson(this);

		return peopleRole;
	}

	public PeopleRole removePeopleRole(PeopleRole peopleRole) {
		getPeopleRoles().remove(peopleRole);
		peopleRole.setPerson(null);

		return peopleRole;
	}

	public Organization getOrganization() {
		return this.organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public List<PersonAddress> getPersonAddresses() {
		return this.personAddresses;
	}

	public void setPersonAddresses(List<PersonAddress> personAddresses) {
		this.personAddresses = personAddresses;
	}

	public PersonAddress addPersonAddress(PersonAddress personAddress) {
		getPersonAddresses().add(personAddress);
		personAddress.setPerson(this);

		return personAddress;
	}

	public PersonAddress removePersonAddress(PersonAddress personAddress) {
		getPersonAddresses().remove(personAddress);
		personAddress.setPerson(null);

		return personAddress;
	}

}