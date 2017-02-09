package com.ktds.ehm.hr.vo;

import com.ktds.ehm.dao.support.annotation.Types;

public class DepartmentsVO {
	@Types(alias = "D_DEPARTMENT_ID")
	private int departmentId;
	@Types
	private String departmentName;
	@Types
	private int managerId;
	@Types
	private int locationId;
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	
	
	
	
}
