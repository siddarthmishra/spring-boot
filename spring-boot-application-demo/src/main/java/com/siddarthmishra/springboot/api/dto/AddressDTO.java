package com.siddarthmishra.springboot.api.dto;

public class AddressDTO {
	private String city;
	private String country;
	private String line1;
	private String line2;
	private String pincode;
	private String state;

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}

	public String getLine1() {
		return line1;
	}

	public String getLine2() {
		return line2;
	}

	public String getPincode() {
		return pincode;
	}

	public String getState() {
		return state;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "AddressDTO [line1=" + line1 + ", line2=" + line2 + ", city=" + city + ", state=" + state + ", country="
				+ country + ", pincode=" + pincode + "]";
	}

}
