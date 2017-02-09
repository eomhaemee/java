package com.ktds.ehm.hr;

import com.ktds.ehm.hr.biz.HRBiz;
import com.ktds.ehm.hr.biz.HRBizImpl;

public class HRController {
	
	public void start(){
		HRBiz hrBiz = new HRBizImpl();
		//hrBiz.printAllEmployees();
		//hrBiz.printALlEmployeesWithDpartments();
		//hrBiz.printAllEmployWithDeptWithJobs();
		//hrBiz.printAllCountries();
		//hrBiz.printOneEmployee(200);
		hrBiz.printAllEmployees2();
	}
	
	public static void main(String[] args) {
		new HRController().start();
	}
	
}
