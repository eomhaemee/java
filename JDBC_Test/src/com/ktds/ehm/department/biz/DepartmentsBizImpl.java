package com.ktds.ehm.department.biz;

import java.util.List;

import com.ktds.ehm.department.dao.DepartmentsDao;
import com.ktds.ehm.department.dao.DepartmentsDaoImpl;
import com.ktds.ehm.department.vo.DepartmentsVO;

public class DepartmentsBizImpl implements DepartmentsBiz {

	private DepartmentsDao departmentsDao;

	public DepartmentsBizImpl() {
		this.departmentsDao = new DepartmentsDaoImpl();
	}

	@Override
	public void printAllDepartments() {
		List<DepartmentsVO> departments = departmentsDao.printAllDepartments();

		for (DepartmentsVO departmentsVO : departments) {
			System.out.printf("%d\t%s\n", departmentsVO.getDepartment_id(), departmentsVO.getDepartment_name());

		}
	}

	@Override
	public void printAllDepartmentsWithEmp() {
		List<DepartmentsVO> departments = departmentsDao.printAllDepartmentsWithEmp();
		for (DepartmentsVO departmentsVO : departments) {
			System.out.printf("%d\t%s\t%d\t%s\n", departmentsVO.getDepartment_id(), departmentsVO.getDepartment_name(),
					departmentsVO.getEmployeesVO().getEmployeeId(), departmentsVO.getEmployeesVO().getFirstName());
		}

	}

	@Override
	public void printAllLocationWithdept() {
		List<DepartmentsVO> departments = departmentsDao.printAllLocationWithdept();
		for (DepartmentsVO departmentsVO : departments) {
			System.out.printf("%d\t%s\n",
					departmentsVO.getDepartment_id(),
					departmentsVO.getDepartment_name()
					);
		}
		
	}

}
