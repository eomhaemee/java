package com.ktds.ehm.hr.vo;

import com.ktds.ehm.dao.support.annotation.Types;

public class LocationsVO {
	@Types
	private int locaiontId;
	@Types
	private String streetAddress;
	@Types
	private String postalCode;
	@Types
	private String city;
	@Types
	private String stateProvince;
	@Types
	private String countyId;
	
	
	public int getLocaiontId() {
		return locaiontId;
	}
	public void setLocaiontId(int locaiontId) {
		this.locaiontId = locaiontId;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStateProvince() {
		return stateProvince;
	}
	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}
	public String getCountyId() {
		return countyId;
	}
	public void setCountyId(String countyId) {
		this.countyId = countyId;
	}
	
	
	
}
