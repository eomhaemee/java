package com.ktds.ehm.hr.dao;

import java.util.List;

import com.ktds.ehm.hr.vo.DepartmentsVO;
import com.ktds.ehm.hr.vo.EmployeesVO;

public interface HRDao {

	public List<EmployeesVO> getAllEmployees();
	
	public List<EmployeesVO> getAllEmployeesWithDepartments();
	
	public List<EmployeesVO> getAllEmployWithDeptWithJobs();
}
