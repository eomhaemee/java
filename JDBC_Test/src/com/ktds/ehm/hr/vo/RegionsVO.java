package com.ktds.ehm.hr.vo;

import com.ktds.ehm.dao.support.annotation.Types;

public class RegionsVO {
	@Types
	private int regionId;
	@Types
	private String resionName;
	
	public int getRegionId() {
		return regionId;
	}
	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}
	public String getResionName() {
		return resionName;
	}
	public void setResionName(String resionName) {
		this.resionName = resionName;
	} 
	
}
