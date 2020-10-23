package restApi;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the case_trails database table.
 * 
 */
@Entity
@Table(name="case_trails")
@NamedQuery(name="CaseTrail.findAll", query="SELECT c FROM CaseTrail c")
public class CaseTrail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="case_trail_id")
	private int caseTrailId;

	private int case_reference_number;

	@Column(name="expected_duration")
	private String expectedDuration;

	@Column(name="other_trial_details")
	private String otherTrialDetails;

	@Column(name="trail_address_id")
	private int trailAddressId;

	@Column(name="trail_outcome_code")
	private int trailOutcomeCode;

	@Temporal(TemporalType.DATE)
	@Column(name="trial_end_date")
	private Date trialEndDate;

	@Temporal(TemporalType.DATE)
	@Column(name="trial_start_date")
	private Date trialStartDate;

	@Column(name="trisl_location_name")
	private String trislLocationName;

	//bi-directional many-to-one association to Address
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Addresses_address_id")
	private Address address;

	//bi-directional many-to-one association to PeopleAtTrial
	@OneToMany(mappedBy="caseTrail")
	private List<PeopleAtTrial> peopleAtTrials;

	public CaseTrail() {
	}

	public int getCaseTrailId() {
		return this.caseTrailId;
	}

	public void setCaseTrailId(int caseTrailId) {
		this.caseTrailId = caseTrailId;
	}

	public int getCase_reference_number() {
		return this.case_reference_number;
	}

	public void setCase_reference_number(int case_reference_number) {
		this.case_reference_number = case_reference_number;
	}

	public String getExpectedDuration() {
		return this.expectedDuration;
	}

	public void setExpectedDuration(String expectedDuration) {
		this.expectedDuration = expectedDuration;
	}

	public String getOtherTrialDetails() {
		return this.otherTrialDetails;
	}

	public void setOtherTrialDetails(String otherTrialDetails) {
		this.otherTrialDetails = otherTrialDetails;
	}

	public int getTrailAddressId() {
		return this.trailAddressId;
	}

	public void setTrailAddressId(int trailAddressId) {
		this.trailAddressId = trailAddressId;
	}

	public int getTrailOutcomeCode() {
		return this.trailOutcomeCode;
	}

	public void setTrailOutcomeCode(int trailOutcomeCode) {
		this.trailOutcomeCode = trailOutcomeCode;
	}

	public Date getTrialEndDate() {
		return this.trialEndDate;
	}

	public void setTrialEndDate(Date trialEndDate) {
		this.trialEndDate = trialEndDate;
	}

	public Date getTrialStartDate() {
		return this.trialStartDate;
	}

	public void setTrialStartDate(Date trialStartDate) {
		this.trialStartDate = trialStartDate;
	}

	public String getTrislLocationName() {
		return this.trislLocationName;
	}

	public void setTrislLocationName(String trislLocationName) {
		this.trislLocationName = trislLocationName;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<PeopleAtTrial> getPeopleAtTrials() {
		return this.peopleAtTrials;
	}

	public void setPeopleAtTrials(List<PeopleAtTrial> peopleAtTrials) {
		this.peopleAtTrials = peopleAtTrials;
	}

	public PeopleAtTrial addPeopleAtTrial(PeopleAtTrial peopleAtTrial) {
		getPeopleAtTrials().add(peopleAtTrial);
		peopleAtTrial.setCaseTrail(this);

		return peopleAtTrial;
	}

	public PeopleAtTrial removePeopleAtTrial(PeopleAtTrial peopleAtTrial) {
		getPeopleAtTrials().remove(peopleAtTrial);
		peopleAtTrial.setCaseTrail(null);

		return peopleAtTrial;
	}

}