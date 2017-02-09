package com.ktds.ehm.hr.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.ehm.dao.support.JDBCDaoSupport;
import com.ktds.ehm.hr.vo.CountriesVO;
import com.ktds.ehm.hr.vo.DepartmentsVO;
import com.ktds.ehm.hr.vo.EmployeesVO;
import com.ktds.ehm.hr.vo.JobsVO;

public class HRDaoImpl_back extends JDBCDaoSupport implements HRDao {

	@Override
	public List<EmployeesVO> getAllEmployees() {

		// 1. oracle driver 로딩
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("오라클 드라이버 로딩 실패! 시스템을 종료합니다.");
			return null;

		}

		// 2. JDBC Instance생성
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		// 3. Oracle Instance에 연결
		String oracleUrl = "jdbc:oracle:thin:@localhost:1521:XE";

		try {
			conn = DriverManager.getConnection(oracleUrl, "HR", "hr");

			// 4. 쿼리를 만든다
			String query = " SELECT  " + "   EMPLOYEE_ID, FIRST_NAME, LAST_NAME,  "
					+ "   EMAIL, PHONE_NUMBER, HIRE_DATE,  " + "   JOB_ID, SALARY, COMMISSION_PCT,  "
					+ "   MANAGER_ID, DEPARTMENT_ID " + "   FROM HR.EMPLOYEES ";
			// 5. 쿼리를 실행한다.
			stmt = conn.prepareStatement(query);
			// 6. 쿼리의 실행결과를 얻어온다.
			rs = stmt.executeQuery();

			// 6-1. 쿼리의 실행결과를 List 객체에 할당한다.
			EmployeesVO employeesVO = null;
			List<EmployeesVO> employees = new ArrayList<EmployeesVO>();

			while (rs.next()) {
				// 6-2.
				employeesVO = new EmployeesVO();
				employeesVO.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
				employeesVO.setFirstName(rs.getString("FIRST_NAME"));
				employeesVO.setLastName(rs.getString("LAST_NAME"));
				employeesVO.setEmail(rs.getString("EMAIL"));
				employeesVO.setPhoneNumber(rs.getString("PHONE_NUMBER"));
				employeesVO.setHireDate(rs.getString("HIRE_DATE"));
				employeesVO.setJobId(rs.getString("JOB_ID"));
				employeesVO.setSalary(rs.getInt("SALARY"));
				//employeesVO.setCommisionPct(rs.getInt("COMMISSION_PCT"));
				employeesVO.setManagerId(rs.getInt("MANAGER_ID"));
				employeesVO.setDepartmentId(rs.getInt("DEPARTMENT_ID"));

				// 6-3 employees 에 employeesVO를 add
				employees.add(employeesVO);
			}

			// 7. return 한다.
			return employees;
		} catch (SQLException e) {
			System.out.println("Oracle 인스턴스에 연결하지 못했습니다. 시스템 종료!");
			return null;
		} finally {

			try {
				// nullpointException이 발생할수 있으므로 if로 null인지 확인
				// 요 if들이 없으면 다음 단계에서 nullpointException 발생가능
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
			}
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
			}
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
			}
		}
	}

	@Override
	public List<EmployeesVO> getAllEmployeesWithDepartments() {

		// 1. oracle driver 로딩
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("오라클 드라이버 로딩 실패2! 시스템을 종료합니다.");
			return null;

		}

		// 2. JDBC Instance생성
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		// 3. Oracle Instance에 연결
		String oracleUrl = "jdbc:oracle:thin:@localhost:1521:XE";

		try {
			conn = DriverManager.getConnection(oracleUrl, "HR", "hr");

			// 4. 쿼리를 만든다
			String query = " SELECT  " + "   E.EMPLOYEE_ID, E.FIRST_NAME, E.LAST_NAME,  "
					+ "   E.EMAIL, E.PHONE_NUMBER, E.HIRE_DATE,  " + "   E.JOB_ID, E.SALARY, E.COMMISSION_PCT,  "
					+ "   E.MANAGER_ID, E.DEPARTMENT_ID, "
					+ "   D.DEPARTMENT_ID  D_DEPARTMENT_ID, D.DEPARTMENT_NAME , D.MANAGER_ID D_MANAGER_ID, D.LOCATION_ID "
					+ "   FROM EMPLOYEES E, DEPARTMENTS D " + "   WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID ";
			// 5. 쿼리를 실행한다.
			stmt = conn.prepareStatement(query);
			// 6. 쿼리의 실행결과를 얻어온다.
			rs = stmt.executeQuery();

			// 6-1. 쿼리의 실행결과를 List 객체에 할당한다.
			EmployeesVO employeesVO = null;
			List<EmployeesVO> employees = new ArrayList<EmployeesVO>();

			DepartmentsVO departmentsVO;
		
			while (rs.next()) {
				/*
				// 6-2.
				employeesVO = new EmployeesVO();
				BindData.bindData(rs, employeesVO);
				
				departmentsVO = new DepartmentsVO();
				BindData.bindData(rs, departmentsVO);
				
				employees.add(employeesVO);
				
				*/
				employeesVO = new EmployeesVO();
				departmentsVO = new DepartmentsVO();
				employeesVO.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
				employeesVO.setFirstName(rs.getString("FIRST_NAME"));
				employeesVO.setLastName(rs.getString("LAST_NAME"));
				employeesVO.setEmail(rs.getString("EMAIL"));
				employeesVO.setPhoneNumber(rs.getString("PHONE_NUMBER"));
				employeesVO.setHireDate(rs.getString("HIRE_DATE"));
				employeesVO.setJobId(rs.getString("JOB_ID"));
				employeesVO.setSalary(rs.getInt("SALARY"));
				employeesVO.setCommissionPct(rs.getInt("COMMISSION_PCT"));
				employeesVO.setManagerId(rs.getInt("MANAGER_ID"));
				employeesVO.setDepartmentId(rs.getInt("DEPARTMENT_ID"));

				departmentsVO = employeesVO.getDepartments();
				departmentsVO.setDepartmentId(rs.getInt("D_DEPARTMENT_ID"));
				departmentsVO.setDepartmentName("DEPARTMENT_NAME");
				// employeesVO.getDepartments().setDepartment_id(rs.getInt("D_DEPARTMENT_ID"));
				// employeesVO.getDepartments().setDepartment_name("DEPARTMENT_NAME");
				// 6-3 employees 에 employeesVO를 add
				employees.add(employeesVO);

					
				
			}

			// 7. return 한다.
			return employees;
		} catch (SQLException e) {
			System.out.println("Oracle 인스턴스에 연결하지 못했습니다. 시스템 종료!");
			return null;
		} finally {

			try {
				// nullpointException이 발생할수 있으므로 if로 null인지 확인
				// 요 if들이 없으면 다음 단계에서 nullpointException 발생가능
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
			}
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
			}
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
			}
		}
	}

	@Override
	public List<EmployeesVO> getAllEmployWithDeptWithJobs() {

		// 1. oracle driver 로딩
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("오라클 드라이버 로딩 실패3! 시스템을 종료합니다.");
			return null;

		}

		// 2. JDBC Instance생성
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		// 3. Oracle Instance에 연결
		String oracleUrl = "jdbc:oracle:thin:@localhost:1521:XE";

		try {
			conn = DriverManager.getConnection(oracleUrl, "HR", "hr");
			// 4. 쿼리를 만든다
			String query = " SELECT  " + "   E.EMPLOYEE_ID, E.FIRST_NAME, E.LAST_NAME,  "
					+ "   E.EMAIL, E.PHONE_NUMBER, E.HIRE_DATE,  " + "   E.JOB_ID, E.SALARY, E.COMMISSION_PCT,  "
					+ "   E.MANAGER_ID, E.DEPARTMENT_ID, "
					+ "   D.DEPARTMENT_ID  D_DEPARTMENT_ID, D.DEPARTMENT_NAME , D.MANAGER_ID D_MANAGER_ID, D.LOCATION_ID, "
					+ "   J.JOB_ID J_JOB_ID, J.JOB_TITLE, J.MIN_SALARY, J.MAX_SALARY"
					+ "   FROM EMPLOYEES E, DEPARTMENTS D, JOBS J " + "   WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID "
					+ "   AND   E.JOB_ID = J.JOB_ID";
			// 5. 쿼리를 실행한다.
			stmt = conn.prepareStatement(query);
			// 6. 쿼리의 실행결과를 얻어온다.
			rs = stmt.executeQuery();

			// 6-1. 쿼리의 실행결과를 List 객체에 할당한다.
			EmployeesVO employeesVO = null;
			List<EmployeesVO> employees = new ArrayList<EmployeesVO>();

			DepartmentsVO departmentsVO;
			JobsVO jobsVO;

			while (rs.next()) {
				// 6-2.
				employeesVO = new EmployeesVO();
				employeesVO.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
				employeesVO.setFirstName(rs.getString("FIRST_NAME"));
				employeesVO.setLastName(rs.getString("LAST_NAME"));
				employeesVO.setEmail(rs.getString("EMAIL"));
				employeesVO.setPhoneNumber(rs.getString("PHONE_NUMBER"));
				employeesVO.setHireDate(rs.getString("HIRE_DATE"));
				employeesVO.setJobId(rs.getString("JOB_ID"));
				employeesVO.setSalary(rs.getInt("SALARY"));
				//employeesVO.setCommisionPct(rs.getInt("COMMISSION_PCT"));
				employeesVO.setManagerId(rs.getInt("MANAGER_ID"));
				employeesVO.setDepartmentId(rs.getInt("DEPARTMENT_ID"));

				departmentsVO = employeesVO.getDepartments();
				departmentsVO.setDepartmentId(rs.getInt("D_DEPARTMENT_ID"));
				departmentsVO.setDepartmentName("DEPARTMENT_NAME");
				// employeesVO.getDepartments().setDepartment_id(rs.getInt("D_DEPARTMENT_ID"));
				// employeesVO.getDepartments().setDepartment_name("DEPARTMENT_NAME");

				jobsVO = employeesVO.getJobs();
				jobsVO.setJobId(rs.getString("J_JOB_ID"));
				jobsVO.setJobTitle(rs.getString("JOB_TITLE"));
				jobsVO.setMinSalary(rs.getInt("MIN_SALARY"));
				jobsVO.setMaxSalary(rs.getInt("MAX_SALARY"));

				// 6-3 employees 에 employeesVO를 add
				employees.add(employeesVO);
			}

			// 7. return 한다.
			return employees;
		} catch (SQLException e) {
			System.out.println("Oracle 인스턴스에 연결하지 못했습니다. 시스템 종료!");
			return null;
		} finally {

			try {
				// nullpointException이 발생할수 있으므로 if로 null인지 확인
				// 요 if들이 없으면 다음 단계에서 nullpointException 발생가능
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
			}
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
			}
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
			}
		}
	}

	@Override
	public List<CountriesVO> getAllCountries() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버로딩실패my");
			return null;
		}

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String url = "jdbc:oracle:thin:@localhost:1521:XE";

		try {
			conn = DriverManager.getConnection(url, "HR", "hr");

			String sql = " SELECT  " + "  C.COUNTRY_ID, C.COUNTRY_NAME, C.REGION_ID, "
					+ "  R.REGION_ID R_REGION_ID, R.REGION_NAME " + "  FROM COUNTRIES C,REGIONS R "
					+ "  WHERE C.REGION_ID = R.REGION_ID" + "  AND  ROWNUM < 5 ";

			stmt = conn.prepareStatement(sql);

			rs = stmt.executeQuery();

			List<CountriesVO> countries = new ArrayList<CountriesVO>();
			CountriesVO countriesVO;
			while (rs.next()) {
				countriesVO = new CountriesVO();

				countriesVO.setCountryId(rs.getString("COUNTRY_ID"));
				countriesVO.setCountryName(rs.getString("COUNTRY_NAME"));
				countriesVO.setRegionId(rs.getInt("REGION_ID"));
				countriesVO.getRegionsVO().setRegionId(rs.getInt("R_REGION_ID"));
				countriesVO.getRegionsVO().setResionName(rs.getString("REGION_NAME"));

				countries.add(countriesVO);
			}
			return countries;

		} catch (SQLException e) {
			System.out.println("인스턴스 생성실패");

			return null;
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
			}
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
			}
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
			}
		}
	}

	@Override
	public EmployeesVO fineOneEmployee(int emplyeeId) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("드라이버 로딩 실패");
			return null;
		}

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String url = "jdbc:oracle:thin:@localhost:1521:XE";

		try {
			conn = DriverManager.getConnection(url, "HR", "hr");

			// 가변일 경우 SringBuffer 사용
			StringBuffer query = new StringBuffer();

			query.append("SELECT	EMPLOYEE_ID ");
			query.append("			,FIRST_NAME ");
			query.append("			,LAST_NAME  ");
			query.append("			,EMAIL      ");
			query.append("FROM		EMPLOYEES   ");
			query.append("WHERE 	EMPLOYEE_ID  = ?");

			stmt = conn.prepareStatement(query.toString());

			stmt.setInt(1, emplyeeId);

			rs = stmt.executeQuery();
			EmployeesVO employeesVO = null;
			if (rs.next()) {
				/*
				employeesVO = new EmployeesVO();	
				BindData.bindData(rs, employeesVO);
				*/
				
				employeesVO = new EmployeesVO();
				employeesVO.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
				employeesVO.setFirstName(rs.getString("FIRST_NAME"));
				employeesVO.setLastName(rs.getString("LAST_NAME"));
				employeesVO.setEmail(rs.getString("EMAIL"));
				
			}

			return employeesVO;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
			}
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
			}
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
			}
		}

	}

}
