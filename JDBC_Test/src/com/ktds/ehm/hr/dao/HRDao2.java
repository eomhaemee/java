package com.ktds.ehm.hr.dao;

import java.util.List;

import com.ktds.ehm.hr.vo.EmployeesVO;

public interface HRDao2 {

	public List<EmployeesVO> getAllEmployees();
	
	public EmployeesVO findOneEmployee(int employeeId);

	
}
