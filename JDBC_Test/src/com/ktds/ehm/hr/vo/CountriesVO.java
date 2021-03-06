package com.ktds.ehm.hr.vo;

import com.ktds.ehm.dao.support.annotation.Types;

public class CountriesVO {	
	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String hireDate;
	private String jobId;
	private double salary;
	private double commissionPct;
	private int managerId;
	private int departmentId;
	@Types
	private String countryId;
	@Types
	private String CountryName;
	@Types
	private int RegionId;

	private RegionsVO regionsVO;

	public RegionsVO getRegionsVO() {
		if (regionsVO == null) {
			regionsVO = new RegionsVO();
		}
		return regionsVO;
	}

	public void setRegionsVO(RegionsVO regionsVO) {
		this.regionsVO = regionsVO;
	}

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return CountryName;
	}

	public void setCountryName(String countryName) {
		CountryName = countryName;
	}

	public int getRegionId() {
		return RegionId;
	}

	public void setRegionId(int regionId) {
		RegionId = regionId;
	}

}
