package com.ktds.ehm.hr.biz;

import java.util.List;

import com.ktds.ehm.hr.dao.HRDao;
import com.ktds.ehm.hr.dao.HRDaoImpl;
import com.ktds.ehm.hr.vo.EmployeesVO;

public class HRBizImpl implements HRBiz {

	private HRDao hrDao;

	public HRBizImpl() {

		this.hrDao = new HRDaoImpl();
	}

	@Override
	public void printAllEmployees() {

		List<EmployeesVO> employees = hrDao.getAllEmployees();

		for (EmployeesVO employeesVO : employees) {
			System.out.printf("%d\t%s\t%s\n", employeesVO.getEmployeeId(), employeesVO.getFirstName(),
					employeesVO.getLastName());
		}
	}

	@Override
	public void printALlEmployeesWithDpartments() {
		List<EmployeesVO> employees = hrDao.getAllEmployeesWithDepartments();

		for (EmployeesVO employeesVO : employees) {
			System.out.printf("%d\t%s\t%s\t%d\t%s\n", employeesVO.getEmployeeId(), employeesVO.getFirstName(),
					employeesVO.getLastName(), employeesVO.getDepartments().getDepartmentId(),
					employeesVO.getDepartments().getDepartmentName());
		}

	}

	@Override
	public void printAllEmployWithDeptWithJobs() {
		List<EmployeesVO> employees = hrDao.getAllEmployWithDeptWithJobs();

		for (EmployeesVO employeesVO : employees) {
			System.out.printf("%d\t%s\t%s\t%d\t%s\t%s\t%s\t%d\t%d\n",
					employeesVO.getEmployeeId(), 
					employeesVO.getFirstName(),
					employeesVO.getLastName(), 
					employeesVO.getDepartments().getDepartmentId(),
					employeesVO.getDepartments().getDepartmentName(),
					employeesVO.getJobs().getJobId(),
					employeesVO.getJobs().getJobTitle(),
					employeesVO.getJobs().getMinSalary(),
					employeesVO.getJobs().getMaxSalary());
		}
		
	}

}
