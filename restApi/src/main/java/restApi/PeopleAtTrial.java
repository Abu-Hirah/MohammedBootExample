package restApi;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the people_at_trial database table.
 * 
 */
@Entity
@Table(name="people_at_trial")
@NamedQuery(name="PeopleAtTrial.findAll", query="SELECT p FROM PeopleAtTrial p")
public class PeopleAtTrial implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PeopleAtTrialPK id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="appearance_end_datetime")
	private Date appearanceEndDatetime;

	@Column(name="appearance_nr")
	private int appearanceNr;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="appearance_start_datetime")
	private Date appearanceStartDatetime;

	@Column(name="other_details")
	private String otherDetails;

	//bi-directional many-to-one association to CaseTrail
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Case_Trails_case_trail_id")
	private CaseTrail caseTrail;

	//bi-directional many-to-one association to PeopleRole
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="People_Roles_person_id", referencedColumnName="person_id"),
		@JoinColumn(name="People_Roles_Person_person_id", referencedColumnName="Person_person_id"),
		@JoinColumn(name="People_Roles_role_code", referencedColumnName="role_code")
		})
	private PeopleRole peopleRole;

	public PeopleAtTrial() {
	}

	public PeopleAtTrialPK getId() {
		return this.id;
	}

	public void setId(PeopleAtTrialPK id) {
		this.id = id;
	}

	public Date getAppearanceEndDatetime() {
		return this.appearanceEndDatetime;
	}

	public void setAppearanceEndDatetime(Date appearanceEndDatetime) {
		this.appearanceEndDatetime = appearanceEndDatetime;
	}

	public int getAppearanceNr() {
		return this.appearanceNr;
	}

	public void setAppearanceNr(int appearanceNr) {
		this.appearanceNr = appearanceNr;
	}

	public Date getAppearanceStartDatetime() {
		return this.appearanceStartDatetime;
	}

	public void setAppearanceStartDatetime(Date appearanceStartDatetime) {
		this.appearanceStartDatetime = appearanceStartDatetime;
	}

	public String getOtherDetails() {
		return this.otherDetails;
	}

	public void setOtherDetails(String otherDetails) {
		this.otherDetails = otherDetails;
	}

	public CaseTrail getCaseTrail() {
		return this.caseTrail;
	}

	public void setCaseTrail(CaseTrail caseTrail) {
		this.caseTrail = caseTrail;
	}

	public PeopleRole getPeopleRole() {
		return this.peopleRole;
	}

	public void setPeopleRole(PeopleRole peopleRole) {
		this.peopleRole = peopleRole;
	}

}