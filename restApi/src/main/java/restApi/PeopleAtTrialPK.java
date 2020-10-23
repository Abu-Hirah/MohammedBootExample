package restApi;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the people_at_trial database table.
 * 
 */
@Embeddable
public class PeopleAtTrialPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="trial_id")
	private int trialId;

	@Column(name="person_id")
	private int personId;

	@Column(name="role_code")
	private int roleCode;

	@Column(insertable=false, updatable=false)
	private int case_Trails_case_trail_id;

	@Column(insertable=false, updatable=false)
	private int people_Roles_person_id;

	@Column(insertable=false, updatable=false)
	private int people_Roles_role_code;

	@Column(insertable=false, updatable=false)
	private int people_Roles_Person_person_id;

	public PeopleAtTrialPK() {
	}
	public int getTrialId() {
		return this.trialId;
	}
	public void setTrialId(int trialId) {
		this.trialId = trialId;
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
	public int getCase_Trails_case_trail_id() {
		return this.case_Trails_case_trail_id;
	}
	public void setCase_Trails_case_trail_id(int case_Trails_case_trail_id) {
		this.case_Trails_case_trail_id = case_Trails_case_trail_id;
	}
	public int getPeople_Roles_person_id() {
		return this.people_Roles_person_id;
	}
	public void setPeople_Roles_person_id(int people_Roles_person_id) {
		this.people_Roles_person_id = people_Roles_person_id;
	}
	public int getPeople_Roles_role_code() {
		return this.people_Roles_role_code;
	}
	public void setPeople_Roles_role_code(int people_Roles_role_code) {
		this.people_Roles_role_code = people_Roles_role_code;
	}
	public int getPeople_Roles_Person_person_id() {
		return this.people_Roles_Person_person_id;
	}
	public void setPeople_Roles_Person_person_id(int people_Roles_Person_person_id) {
		this.people_Roles_Person_person_id = people_Roles_Person_person_id;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PeopleAtTrialPK)) {
			return false;
		}
		PeopleAtTrialPK castOther = (PeopleAtTrialPK)other;
		return 
			(this.trialId == castOther.trialId)
			&& (this.personId == castOther.personId)
			&& (this.roleCode == castOther.roleCode)
			&& (this.case_Trails_case_trail_id == castOther.case_Trails_case_trail_id)
			&& (this.people_Roles_person_id == castOther.people_Roles_person_id)
			&& (this.people_Roles_role_code == castOther.people_Roles_role_code)
			&& (this.people_Roles_Person_person_id == castOther.people_Roles_Person_person_id);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.trialId;
		hash = hash * prime + this.personId;
		hash = hash * prime + this.roleCode;
		hash = hash * prime + this.case_Trails_case_trail_id;
		hash = hash * prime + this.people_Roles_person_id;
		hash = hash * prime + this.people_Roles_role_code;
		hash = hash * prime + this.people_Roles_Person_person_id;
		
		return hash;
	}
}