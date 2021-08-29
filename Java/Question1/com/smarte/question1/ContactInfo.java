package com.smarte.question1;

public class ContactInfo {

	private String phoneNo;
	private String city;
	private String state;
	private String country;
	private String cityCode;

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	@Override
	public String toString() {
		return "ContactInfo [phoneNo=" + phoneNo + ", city=" + city + ", state=" + state + ", country=" + country
				+ ", cityCode=" + cityCode + "]";
	}

}
