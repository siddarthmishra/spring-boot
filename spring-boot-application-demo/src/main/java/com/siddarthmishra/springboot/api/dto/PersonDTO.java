package com.siddarthmishra.springboot.api.dto;

public class PersonDTO {

	private AddressDTO address;
	private String email;
	private String firstName;
	private String lastName;

	public AddressDTO getAddress() {
		return address;
	}

	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setAddress(AddressDTO address) {
		this.address = address;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "PersonDTO [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", address="
				+ address + "]";
	}
}
