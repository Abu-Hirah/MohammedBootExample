package restApi;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the organizations database table.
 * 
 */
@Entity
@Table(name="organizations")
@NamedQuery(name="Organization.findAll", query="SELECT o FROM Organization o")
public class Organization implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="organization_id")
	private int organizationId;

	private String organization_name;

	private String organization_type_code;

	@Column(name="other_organization_details")
	private String otherOrganizationDetails;

	//bi-directional many-to-one association to OrganizationAddress
	@OneToMany(mappedBy="organization")
	private List<OrganizationAddress> organizationAddresses;

	//bi-directional many-to-one association to Person
	@OneToMany(mappedBy="organization")
	private List<Person> persons;

	public Organization() {
	}

	public int getOrganizationId() {
		return this.organizationId;
	}

	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
	}

	public String getOrganization_name() {
		return this.organization_name;
	}

	public void setOrganization_name(String organization_name) {
		this.organization_name = organization_name;
	}

	public String getOrganization_type_code() {
		return this.organization_type_code;
	}

	public void setOrganization_type_code(String organization_type_code) {
		this.organization_type_code = organization_type_code;
	}

	public String getOtherOrganizationDetails() {
		return this.otherOrganizationDetails;
	}

	public void setOtherOrganizationDetails(String otherOrganizationDetails) {
		this.otherOrganizationDetails = otherOrganizationDetails;
	}

	public List<OrganizationAddress> getOrganizationAddresses() {
		return this.organizationAddresses;
	}

	public void setOrganizationAddresses(List<OrganizationAddress> organizationAddresses) {
		this.organizationAddresses = organizationAddresses;
	}

	public OrganizationAddress addOrganizationAddress(OrganizationAddress organizationAddress) {
		getOrganizationAddresses().add(organizationAddress);
		organizationAddress.setOrganization(this);

		return organizationAddress;
	}

	public OrganizationAddress removeOrganizationAddress(OrganizationAddress organizationAddress) {
		getOrganizationAddresses().remove(organizationAddress);
		organizationAddress.setOrganization(null);

		return organizationAddress;
	}

	public List<Person> getPersons() {
		return this.persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public Person addPerson(Person person) {
		getPersons().add(person);
		person.setOrganization(this);

		return person;
	}

	public Person removePerson(Person person) {
		getPersons().remove(person);
		person.setOrganization(null);

		return person;
	}

}