package com.ktds.ehm.department.biz;

import java.util.List;

import com.ktds.ehm.department.vo.DepartmentsVO;

public interface DepartmentsBiz {
	public void printAllDepartments();
	
	public void printAllDepartmentsWithEmp();
	
	public void printAllLocationWithdept();
}
