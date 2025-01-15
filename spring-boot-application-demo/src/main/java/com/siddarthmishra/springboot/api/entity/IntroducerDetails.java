package com.siddarthmishra.springboot.api.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "INTRODUCER_DTLS")
public class IntroducerDetails implements Serializable {

	private static final long serialVersionUID = -1109595395082180489L;

	@Column(name = "CREATED_BY", insertable = true, updatable = false)
	private String createdBy;

	@Column(name = "CREATION_DATE", insertable = true, updatable = false)
	private LocalDateTime creationDate;

	@Column(name = "EFFECTIVE_DATE")
	private LocalDate effectiveDate;

	@Column(name = "EXPIRY_DATE")
	private LocalDate expiryDate;

	@Column(name = "PARTY_ID")
	private String partyId;

	@Id
	@NotNull
	@Size(min = 3)
	@Column(name = "SPID")
	private String spid;

	public String getCreatedBy() {
		return createdBy;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public LocalDate getEffectiveDate() {
		return effectiveDate;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public String getPartyId() {
		return partyId;
	}

	public String getSpid() {
		return spid;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public void setEffectiveDate(LocalDate effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}

	public void setSpid(String spid) {
		this.spid = spid;
	}
}
