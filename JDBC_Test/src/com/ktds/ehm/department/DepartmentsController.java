package com.ktds.ehm.department;

import com.ktds.ehm.department.biz.DepartmentsBiz;
import com.ktds.ehm.department.biz.DepartmentsBizImpl;

public class DepartmentsController {

	public void start(){
		DepartmentsBiz departmentsBiz = new DepartmentsBizImpl();
		departmentsBiz.printAllDepartments();
	}
	public static void main(String[] args) {
		new DepartmentsController().start();
	}
}
