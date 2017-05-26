package com.ktds.ehm.hr;

import com.ktds.ehm.hr.biz.HRBiz;
import com.ktds.ehm.hr.biz.HRBizImpl;

public class HRController {
	
	public void start(){
		HRBiz hrBiz = new HRBizImpl();
		hrBiz.printAllEmployees();
		//hrBiz.printALlEmployeesWithDpartments();
		//hrBiz.printAllEmployWithDeptWithJobs();
		//hrBiz.printAllCountries();
		//hrBiz.printOneEmployee(200);
		//hrBiz.printAllEmployees2();
		//hrBiz.printAllempInfo();
		//hrBiz.printOneDeptAllEmpInfo(10);
		//hrBiz.printCityFindEmpInfo("Seattle");
		//hrBiz.printCityFindEmpInfo2();
		//hrBiz.printAllEmployees3();
	}
	
	public static void main(String[] args) {
		new HRController().start();
	}
	
}
