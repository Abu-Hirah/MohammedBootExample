package restApi;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the addresses database table.
 * 
 */
@Entity
@Table(name="addresses")
@NamedQuery(name="Address.findAll", query="SELECT a FROM Address a")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="address_id")
	private int addressId;

	private String city;

	private String country;

	@Column(name="line_1_number_building")
	private String line1NumberBuilding;

	@Column(name="line_2_number_street")
	private String line2NumberStreet;

	@Column(name="line_3_area_locality")
	private String line3AreaLocality;

	@Column(name="other_address_details")
	private String otherAddressDetails;

	@Column(name="state_province_country")
	private String stateProvinceCountry;

	@Column(name="zip_postcode")
	private int zipPostcode;

	//bi-directional many-to-one association to CaseTrail
	@OneToMany(mappedBy="address")
	private List<CaseTrail> caseTrails;

	//bi-directional many-to-one association to OrganizationAddress
	@OneToMany(mappedBy="address")
	private List<OrganizationAddress> organizationAddresses;

	//bi-directional many-to-one association to PersonAddress
	@OneToMany(mappedBy="address")
	private List<PersonAddress> personAddresses;

	public Address() {
	}

	public int getAddressId() {
		return this.addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLine1NumberBuilding() {
		return this.line1NumberBuilding;
	}

	public void setLine1NumberBuilding(String line1NumberBuilding) {
		this.line1NumberBuilding = line1NumberBuilding;
	}

	public String getLine2NumberStreet() {
		return this.line2NumberStreet;
	}

	public void setLine2NumberStreet(String line2NumberStreet) {
		this.line2NumberStreet = line2NumberStreet;
	}

	public String getLine3AreaLocality() {
		return this.line3AreaLocality;
	}

	public void setLine3AreaLocality(String line3AreaLocality) {
		this.line3AreaLocality = line3AreaLocality;
	}

	public String getOtherAddressDetails() {
		return this.otherAddressDetails;
	}

	public void setOtherAddressDetails(String otherAddressDetails) {
		this.otherAddressDetails = otherAddressDetails;
	}

	public String getStateProvinceCountry() {
		return this.stateProvinceCountry;
	}

	public void setStateProvinceCountry(String stateProvinceCountry) {
		this.stateProvinceCountry = stateProvinceCountry;
	}

	public int getZipPostcode() {
		return this.zipPostcode;
	}

	public void setZipPostcode(int zipPostcode) {
		this.zipPostcode = zipPostcode;
	}

	public List<CaseTrail> getCaseTrails() {
		return this.caseTrails;
	}

	public void setCaseTrails(List<CaseTrail> caseTrails) {
		this.caseTrails = caseTrails;
	}

	public CaseTrail addCaseTrail(CaseTrail caseTrail) {
		getCaseTrails().add(caseTrail);
		caseTrail.setAddress(this);

		return caseTrail;
	}

	public CaseTrail removeCaseTrail(CaseTrail caseTrail) {
		getCaseTrails().remove(caseTrail);
		caseTrail.setAddress(null);

		return caseTrail;
	}

	public List<OrganizationAddress> getOrganizationAddresses() {
		return this.organizationAddresses;
	}

	public void setOrganizationAddresses(List<OrganizationAddress> organizationAddresses) {
		this.organizationAddresses = organizationAddresses;
	}

	public OrganizationAddress addOrganizationAddress(OrganizationAddress organizationAddress) {
		getOrganizationAddresses().add(organizationAddress);
		organizationAddress.setAddress(this);

		return organizationAddress;
	}

	public OrganizationAddress removeOrganizationAddress(OrganizationAddress organizationAddress) {
		getOrganizationAddresses().remove(organizationAddress);
		organizationAddress.setAddress(null);

		return organizationAddress;
	}

	public List<PersonAddress> getPersonAddresses() {
		return this.personAddresses;
	}

	public void setPersonAddresses(List<PersonAddress> personAddresses) {
		this.personAddresses = personAddresses;
	}

	public PersonAddress addPersonAddress(PersonAddress personAddress) {
		getPersonAddresses().add(personAddress);
		personAddress.setAddress(this);

		return personAddress;
	}

	public PersonAddress removePersonAddress(PersonAddress personAddress) {
		getPersonAddresses().remove(personAddress);
		personAddress.setAddress(null);

		return personAddress;
	}

}