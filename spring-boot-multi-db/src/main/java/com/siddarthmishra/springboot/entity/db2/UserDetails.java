package com.siddarthmishra.springboot.entity.db2;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "USER_DTLS")
public class UserDetails implements Serializable {

	private static final long serialVersionUID = 7098314767802174905L;

	@Column(name = "CREATION_DATE", insertable = true, updatable = false)
	private LocalDateTime creationDate;

	@Column(name = "EMAIL_ID", insertable = true, updatable = false)
	private String emailId;

	@Column(name = "FIRST_NAME", insertable = true, updatable = false)
	private String firstName;

	@Column(name = "LAST_NAME", insertable = true, updatable = false)
	private String lastName;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ")
	@SequenceGenerator(sequenceName = "user_id_seq", allocationSize = 1, name = "USER_SEQ")
	@Column(name = "USER_ID")
	private Integer userId;

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public String getEmailId() {
		return emailId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}
