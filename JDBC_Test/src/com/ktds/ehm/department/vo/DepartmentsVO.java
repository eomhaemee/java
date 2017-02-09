package com.ktds.ehm.department.vo;

public class DepartmentsVO {
	private int department_id;
	private String department_name;
	private int manager_id;
	private int location_id;
	
	private EmployeesVO employeesVO;
	
	private LocationsVO locationsVO;
	
	
	
	public LocationsVO getLocationsVO() {
		if ( locationsVO == null )  {
			locationsVO = new LocationsVO();
		}
		return locationsVO;
	}
	public void setLocationsVO(LocationsVO locationsVO) {
		this.locationsVO = locationsVO;
	}
	public EmployeesVO getEmployeesVO() {
		if ( employeesVO == null ) {
			employeesVO = new EmployeesVO();
		}
		return employeesVO;
	}
	public void setEmployeesVO(EmployeesVO employeesVO) {
		this.employeesVO = employeesVO;
	}
	
	public int getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	public int getManager_id() {
		return manager_id;
	}
	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}
	public int getLocation_id() {
		return location_id;
	}
	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}
	
}
