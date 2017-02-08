package com.ktds.ehm.hr.vo;

public class EmployeesVO {

	private	 int employeeId;
	private	 String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String hireDate;
	private String jobId;
	private int salary;
	private double commisionPct;
	private int managerId;
	private int departmentId;
	
	private DepartmentsVO departments;
	private JobsVO jobs;
	
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
	public double getCommisionPct() {
		return commisionPct;
	}
	public void setCommisionPct(double commisionPct) {
		this.commisionPct = commisionPct;
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
