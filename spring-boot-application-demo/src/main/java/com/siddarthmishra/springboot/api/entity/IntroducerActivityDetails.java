package com.siddarthmishra.springboot.api.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "INTRODUCER_ACTIVITY_DTLS")
public class IntroducerActivityDetails implements Serializable {

	private static final long serialVersionUID = 8276900201661235524L;

	@Column(name = "CREATED_BY", insertable = true, updatable = false)
	private String createdBy;

	@Column(name = "CREATION_DATE", insertable = true, updatable = false)
	private LocalDateTime creationDate;

	@OneToOne
	@JoinColumn(name = "INTRODUCER_ID", insertable = false, updatable = false, nullable = false)
	private IntroducerDetails introducerDetails;

	@Column(name = "LAST_UPDATED_BY")
	private String lastUpdatedBy;

	@Column(name = "LAST_UPDATE_DATE")
	private LocalDateTime lastUpdatedDate;

	@Column(name = "REPAIR_TASK_CREATED_DATE")
	private LocalDateTime repairTaskCreatedDate;

	@Column(name = "REPAIR_TASK_SUBMITTED_DATE")
	private LocalDateTime repairTaskSubmittedDate;

	@Column(name = "REPAIR_TASK_SUBMITTED_USER")
	private String repairTaskSubmittedUser;

	@NotNull
	@Size(min = 3)
	@Column(name = "INTRODUCER_ID")
	private String spid;

	@Column(name = "STATUS")
	private String status;

	@Id
	@NotNull
	@Size(min = 3)
	@Column(name = "SUBMISSION_ID")
	private String submissionId;

	@Column(name = "VALIDITY_DATE")
	private LocalDate validityDate;

	@Column(name = "WORKACTIVED_CREATED_DATE")
	private LocalDateTime workActivityCreatedDate;

	@Column(name = "WORKACTIVE_SUBMITTED_DATE")
	private LocalDateTime workActivitySubmittedDate;

	@Column(name = "WORKACTIVITY_SUBMITTED_USER")
	private String workActivitySubmittedUser;

	public String getCreatedBy() {
		return createdBy;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public IntroducerDetails getIntroducerDetails() {
		return introducerDetails;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public LocalDateTime getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public LocalDateTime getRepairTaskCreatedDate() {
		return repairTaskCreatedDate;
	}

	public LocalDateTime getRepairTaskSubmittedDate() {
		return repairTaskSubmittedDate;
	}

	public String getRepairTaskSubmittedUser() {
		return repairTaskSubmittedUser;
	}

	public String getSpid() {
		return spid;
	}

	public String getStatus() {
		return status;
	}

	public String getSubmissionId() {
		return submissionId;
	}

	public LocalDate getValidityDate() {
		return validityDate;
	}

	public LocalDateTime getWorkActivityCreatedDate() {
		return workActivityCreatedDate;
	}

	public LocalDateTime getWorkActivitySubmittedDate() {
		return workActivitySubmittedDate;
	}

	public String getWorkActivitySubmittedUser() {
		return workActivitySubmittedUser;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public void setIntroducerDetails(IntroducerDetails introducerDetails) {
		this.introducerDetails = introducerDetails;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public void setLastUpdatedDate(LocalDateTime lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public void setRepairTaskCreatedDate(LocalDateTime repairTaskCreatedDate) {
		this.repairTaskCreatedDate = repairTaskCreatedDate;
	}

	public void setRepairTaskSubmittedDate(LocalDateTime repairTaskSubmittedDate) {
		this.repairTaskSubmittedDate = repairTaskSubmittedDate;
	}

	public void setRepairTaskSubmittedUser(String repairTaskSubmittedUser) {
		this.repairTaskSubmittedUser = repairTaskSubmittedUser;
	}

	public void setSpid(String spid) {
		this.spid = spid;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setSubmissionId(String submissionId) {
		this.submissionId = submissionId;
	}

	public void setValidityDate(LocalDate validityDate) {
		this.validityDate = validityDate;
	}

	public void setWorkActivityCreatedDate(LocalDateTime workActivityCreatedDate) {
		this.workActivityCreatedDate = workActivityCreatedDate;
	}

	public void setWorkActivitySubmittedDate(LocalDateTime workActivitySubmittedDate) {
		this.workActivitySubmittedDate = workActivitySubmittedDate;
	}

	public void setWorkActivitySubmittedUser(String workActivitySubmittedUser) {
		this.workActivitySubmittedUser = workActivitySubmittedUser;
	}
}
