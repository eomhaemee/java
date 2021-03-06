package com.ktds.ehm.hr.biz;

import java.util.List;

import com.ktds.ehm.hr.dao.HRDao;
import com.ktds.ehm.hr.dao.HRDao2;
import com.ktds.ehm.hr.dao.HRDao2Impl;
import com.ktds.ehm.hr.dao.HRDaoImpl_back;
import com.ktds.ehm.hr.vo.CountriesVO;
import com.ktds.ehm.hr.vo.EmployeesVO;

public class HRBizImpl implements HRBiz {

	private HRDao hrDao;
	private HRDao2 hrDao2;
	

	public HRBizImpl() {

		this.hrDao = new HRDaoImpl_back();
		this.hrDao2 = new HRDao2Impl();
		
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
			System.out.printf("%d\t%s\t%s\t%d\t%s\t%s\t%s\t%d\t%d\n", employeesVO.getEmployeeId(),
					employeesVO.getFirstName(), employeesVO.getLastName(),
					employeesVO.getDepartments().getDepartmentId(), employeesVO.getDepartments().getDepartmentName(),
					employeesVO.getJobs().getJobId(), employeesVO.getJobs().getJobTitle(),
					employeesVO.getJobs().getMinSalary(), employeesVO.getJobs().getMaxSalary());
		}

	}

	@Override
	public void printAllCountries() {
		List<CountriesVO> countries = hrDao.getAllCountries();
		System.out.printf("%s\t%s\t%s\t%s\n", "CountryId", "CountryName", "RegionId", "ResionName");
		System.out.println("===============================================================");

		for (CountriesVO countriesVO : countries) {
			System.out.printf("%s\t%s\t%d\t%s\n", countriesVO.getCountryId(), countriesVO.getCountryName(),
					countriesVO.getRegionId(), countriesVO.getRegionsVO().getResionName());
		}

	}

	@Override
	public void printOneEmployee(int emplyeeId) {
		EmployeesVO employees = hrDao.fineOneEmployee(emplyeeId);
		System.out.printf("%d\t%s\t%s\t%s\n", employees.getEmployeeId(), employees.getFirstName(),
				employees.getLastName(), employees.getEmail());
	}

	public void printAllEmployees2() {
		List<EmployeesVO> employees = hrDao2.getAllEmployees();
		for (EmployeesVO employeesVO : employees) {
			System.out.printf("%d\t%s\t%s\t%d\n", employeesVO.getEmployeeId(), employeesVO.getFirstName(),
					employeesVO.getLastName(), employeesVO.getSalary());
		}
	}

	@Override
	public void printAllempInfo() {
		List<EmployeesVO> employees = hrDao.getAllempInfo();
		for (EmployeesVO employeesVO : employees) {
			System.out.printf("%d\t%s\t%s\t%s\n", employeesVO.getEmployeeId(), employeesVO.getLastName(),
					employeesVO.getJobs().getJobTitle(), employeesVO.getLocations().getCity());
		}

	}

	@Override
	public void printOneDeptAllEmpInfo(int departmentId) {
		List<EmployeesVO> employees = hrDao.findAllEmpInfo(departmentId);
		for (EmployeesVO employeesVO : employees) {
			System.out.printf("%d\t%s\t%s\t%s\n", 
					employeesVO.getEmployeeId(), employeesVO.getLastName(),
					employeesVO.getDepartmentId(),
					employeesVO.getDepartments().getDepartmentName());
		}

	}

	@Override
	public void printCityFindEmpInfo(String city) {
		List<EmployeesVO> employees = hrDao.findCityEmpInfo(city);
		for (EmployeesVO employeesVO : employees) {
			System.out.printf("%d\t%s\t%s\t%s\t%s\n", 
					employeesVO.getEmployeeId(), 
					employeesVO.getLastName(),
					employeesVO.getDepartments().getDepartmentName(),
					employeesVO.getJobs().getJobTitle(),
					employeesVO.getLocations().getCity()
					);
		}
		
	}

	@Override
	public void printAllEmpInDept() {
		
		
		
		
	}

	@Override
	public void printAllEmployees3() {
		List<EmployeesVO> employees = hrDao2.getAllEmployees2();
		for (EmployeesVO employeesVO : employees) {
			System.out.printf("%d\t%d\n",
					employeesVO.getEmployeeId(),
					employeesVO.getDepartments().getDepartmentId());
		}
		
	}

}
