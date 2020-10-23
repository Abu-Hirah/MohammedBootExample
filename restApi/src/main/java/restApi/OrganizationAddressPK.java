package restApi;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the organization_addresses database table.
 * 
 */
@Embeddable
public class OrganizationAddressPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="organizational_id")
	private int organizationalId;

	@Column(name="address_id")
	private int addressId;

	@Temporal(TemporalType.DATE)
	@Column(name="date_address_from")
	private java.util.Date dateAddressFrom;

	@Column(insertable=false, updatable=false)
	private int organizations_organization_id;

	@Column(insertable=false, updatable=false)
	private int addresses_address_id;

	public OrganizationAddressPK() {
	}
	public int getOrganizationalId() {
		return this.organizationalId;
	}
	public void setOrganizationalId(int organizationalId) {
		this.organizationalId = organizationalId;
	}
	public int getAddressId() {
		return this.addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public java.util.Date getDateAddressFrom() {
		return this.dateAddressFrom;
	}
	public void setDateAddressFrom(java.util.Date dateAddressFrom) {
		this.dateAddressFrom = dateAddressFrom;
	}
	public int getOrganizations_organization_id() {
		return this.organizations_organization_id;
	}
	public void setOrganizations_organization_id(int organizations_organization_id) {
		this.organizations_organization_id = organizations_organization_id;
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
		if (!(other instanceof OrganizationAddressPK)) {
			return false;
		}
		OrganizationAddressPK castOther = (OrganizationAddressPK)other;
		return 
			(this.organizationalId == castOther.organizationalId)
			&& (this.addressId == castOther.addressId)
			&& this.dateAddressFrom.equals(castOther.dateAddressFrom)
			&& (this.organizations_organization_id == castOther.organizations_organization_id)
			&& (this.addresses_address_id == castOther.addresses_address_id);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.organizationalId;
		hash = hash * prime + this.addressId;
		hash = hash * prime + this.dateAddressFrom.hashCode();
		hash = hash * prime + this.organizations_organization_id;
		hash = hash * prime + this.addresses_address_id;
		
		return hash;
	}
}