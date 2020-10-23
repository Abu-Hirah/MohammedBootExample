package restApi;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the person_addresses database table.
 * 
 */
@Entity
@Table(name="person_addresses")
@NamedQuery(name="PersonAddress.findAll", query="SELECT p FROM PersonAddress p")
public class PersonAddress implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PersonAddressPK id;

	@Column(name="address_type_code")
	private String addressTypeCode;

	@Temporal(TemporalType.DATE)
	@Column(name="date_address_from")
	private Date dateAddressFrom;

	@Temporal(TemporalType.DATE)
	@Column(name="date_address_to")
	private Date dateAddressTo;

	//bi-directional many-to-one association to Address
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Addresses_address_id")
	private Address address;

	//bi-directional many-to-one association to Person
	@ManyToOne(fetch=FetchType.LAZY)
	private Person person;

	public PersonAddress() {
	}

	public PersonAddressPK getId() {
		return this.id;
	}

	public void setId(PersonAddressPK id) {
		this.id = id;
	}

	public String getAddressTypeCode() {
		return this.addressTypeCode;
	}

	public void setAddressTypeCode(String addressTypeCode) {
		this.addressTypeCode = addressTypeCode;
	}

	public Date getDateAddressFrom() {
		return this.dateAddressFrom;
	}

	public void setDateAddressFrom(Date dateAddressFrom) {
		this.dateAddressFrom = dateAddressFrom;
	}

	public Date getDateAddressTo() {
		return this.dateAddressTo;
	}

	public void setDateAddressTo(Date dateAddressTo) {
		this.dateAddressTo = dateAddressTo;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}