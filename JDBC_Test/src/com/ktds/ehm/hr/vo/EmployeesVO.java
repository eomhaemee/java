package com.ktds.ehm.hr.vo;

import com.ktds.ehm.dao.support.annotation.Types;

public class EmployeesVO {
	@Types
	private	 int employeeId;
	@Types
	private	 String firstName;
	@Types
	private String lastName;
	@Types
	private String email;
	@Types
	private String phoneNumber;
	@Types
	private String hireDate;
	@Types
	private String jobId;
	@Types
	private int salary;
	@Types
	private double commissionPct;
	@Types
	private int managerId;
	@Types
	private int departmentId;
	
	private JobsVO jobs;
	private DepartmentsVO departments;
	private	 LocationsVO locations;
	
	
	public LocationsVO getLocations() {
		if(locations == null){
			locations  = new LocationsVO();
		}
		return locations;
	}
	
	public void setLocations(LocationsVO locations) {
		this.locations = locations;
	}
	
	//getter에만 null체크 추가
	public JobsVO getJobs() {
		if( jobs == null ) {
			jobs = new JobsVO();
		}
		return jobs;
	}
	public void setJobs(JobsVO jobs) {
		this.jobs = jobs;
	}
	
	public DepartmentsVO getDepartments() {
		if( departments  == null){
			departments = new DepartmentsVO();
		}
		return departments;
	}
	public void setDepartments(DepartmentsVO departments) {
		this.departments = departments;
	}
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getHireDate() {
		return hireDate;
	}
	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}

	
	
	public double getCommissionPct() {
		return commissionPct;
	}
	public void setCommissionPct(double commissionPct) {
		this.commissionPct = commissionPct;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	
	
}
