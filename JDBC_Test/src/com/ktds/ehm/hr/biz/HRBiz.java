package com.ktds.ehm.hr.biz;

import java.util.List;

import com.ktds.ehm.hr.vo.EmployeesVO;

public interface HRBiz {

	public void printAllEmployees();

	public void printALlEmployeesWithDpartments();

	public void printAllEmployWithDeptWithJobs();

	public void printAllCountries();

	public void printOneEmployee(int emplyeeId);
	
	
	public void printAllEmployees2();
	
	//1번
	public void printAllempInfo();
	
	public void printAllEmpInDept();
	
	//2번
	public void printOneDeptAllEmpInfo(int departmentId);
	//3번
	public void printCityFindEmpInfo(String city);
	
	//public void printCityFindEmpInfo2();
	public void printAllEmployees3();

	
	

}
