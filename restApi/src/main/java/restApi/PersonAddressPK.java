package restApi;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the person_addresses database table.
 * 
 */
@Embeddable
public class PersonAddressPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="person_id")
	private int personId;

	@Column(name="address_id")
	private int addressId;

	@Column(insertable=false, updatable=false)
	private int person_person_id;

	@Column(insertable=false, updatable=false)
	private int addresses_address_id;

	public PersonAddressPK() {
	}
	public int getPersonId() {
		return this.personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public int getAddressId() {
		return this.addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public int getPerson_person_id() {
		return this.person_person_id;
	}
	public void setPerson_person_id(int person_person_id) {
		this.person_person_id = person_person_id;
	}
	public int getAddresses_address_id() {
		return this.addresses_address_id;
	}
	public void setAddresses_address_id(int addresses_address_id) {
		this.addresses_address_id = addresses_address_id;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PersonAddressPK)) {
			return false;
		}
		PersonAddressPK castOther = (PersonAddressPK)other;
		return 
			(this.personId == castOther.personId)
			&& (this.addressId == castOther.addressId)
			&& (this.person_person_id == castOther.person_person_id)
			&& (this.addresses_address_id == castOther.addresses_address_id);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.personId;
		hash = hash * prime + this.addressId;
		hash = hash * prime + this.person_person_id;
		hash = hash * prime + this.addresses_address_id;
		
		return hash;
	}
}