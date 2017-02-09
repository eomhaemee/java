package com.ktds.ehm.department.dao;

import java.util.List;

import com.ktds.ehm.department.vo.DepartmentsVO;
import com.ktds.ehm.department.vo.LocationsVO;

public interface DepartmentsDao {
	public List<DepartmentsVO> printAllDepartments();
	
	public List<DepartmentsVO> printAllDepartmentsWithEmp();
	
	public List<DepartmentsVO> printAllLocationWithdept();

}
