package restApi;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the people_roles database table.
 * 
 */
@Embeddable
public class PeopleRolePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="person_id")
	private int personId;

	@Column(name="role_code")
	private int roleCode;

	@Column(insertable=false, updatable=false)
	private int person_person_id;

	public PeopleRolePK() {
	}
	public int getPersonId() {
		return this.personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public int getRoleCode() {
		return this.roleCode;
	}
	public void setRoleCode(int roleCode) {
		this.roleCode = roleCode;
	}
	public int getPerson_person_id() {
		return this.person_person_id;
	}
	public void setPerson_person_id(int person_person_id) {
		this.person_person_id = person_person_id;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PeopleRolePK)) {
			return false;
		}
		PeopleRolePK castOther = (PeopleRolePK)other;
		return 
			(this.personId == castOther.personId)
			&& (this.roleCode == castOther.roleCode)
			&& (this.person_person_id == castOther.person_person_id);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.personId;
		hash = hash * prime + this.roleCode;
		hash = hash * prime + this.person_person_id;
		
		return hash;
	}
}