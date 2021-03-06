package com.ktds.ehm.hr.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ktds.ehm.dao.support.JDBCDaoSupport;
import com.ktds.ehm.dao.support.QueryHandler;
import com.ktds.ehm.dao.support.annotation.BindData;
import com.ktds.ehm.hr.vo.CountriesVO;
import com.ktds.ehm.hr.vo.DepartmentsVO;
import com.ktds.ehm.hr.vo.EmployeesVO;
import com.ktds.ehm.hr.vo.JobsVO;
import com.ktds.ehm.hr.vo.LocationsVO;

import oracle.net.aso.d;

public class HRDaoImpl extends JDBCDaoSupport implements HRDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeesVO> getAllEmployees() {

		return selectList(new QueryHandler() {

			@Override
			public String preparedQuery() {
				// 4. 쿼리를 만든다
				String query = " SELECT  " + "   EMPLOYEE_ID, FIRST_NAME, LAST_NAME,  "
						+ "   EMAIL, PHONE_NUMBER, HIRE_DATE,  " + "   JOB_ID, SALARY, COMMISSION_PCT,  "
						+ "   MANAGER_ID, DEPARTMENT_ID " + "   FROM HR.EMPLOYEES ";
				return query;
			}

			@Override
			public void mappingParameters(PreparedStatement stmt) {
				// TODO Auto-generated method stub

			}

			@Override
			public Object getData(ResultSet rs) {
				EmployeesVO employeesVO = new EmployeesVO();
				BindData.bindData(rs, employeesVO);
				return employeesVO;
			}
		});

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeesVO> getAllEmployeesWithDepartments() {

		return selectList(new QueryHandler() {

			@Override
			public String preparedQuery() {
				String query = " SELECT  " + "   E.EMPLOYEE_ID, E.FIRST_NAME, E.LAST_NAME,  "
						+ "   E.EMAIL, E.PHONE_NUMBER, E.HIRE_DATE,  " + "   E.JOB_ID, E.SALARY, E.COMMISSION_PCT,  "
						+ "   E.MANAGER_ID, E.DEPARTMENT_ID, "
						+ "   D.DEPARTMENT_ID  D_DEPARTMENT_ID, D.DEPARTMENT_NAME , D.MANAGER_ID D_MANAGER_ID, D.LOCATION_ID "
						+ "   FROM EMPLOYEES E, DEPARTMENTS D " + "   WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID ";

				return query;
			}

			@Override
			public void mappingParameters(PreparedStatement stmt) throws SQLException {
				// TODO Auto-generated method stub

			}

			@Override
			public Object getData(ResultSet rs) {
				EmployeesVO employeesVO = new EmployeesVO();
				DepartmentsVO departmentsVO = new DepartmentsVO();

				BindData.bindData(rs, employeesVO);
				return employeesVO;
			}
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeesVO> getAllEmployWithDeptWithJobs() {

		return selectList(new QueryHandler() {

			@Override
			public String preparedQuery() {
				String query = " SELECT  " + "   E.EMPLOYEE_ID, E.FIRST_NAME, E.LAST_NAME,  "
						+ "   E.EMAIL, E.PHONE_NUMBER, E.HIRE_DATE,  " + "   E.JOB_ID, E.SALARY, E.COMMISSION_PCT,  "
						+ "   E.MANAGER_ID, E.DEPARTMENT_ID, "
						+ "   D.DEPARTMENT_ID  D_DEPARTMENT_ID, D.DEPARTMENT_NAME , D.MANAGER_ID D_MANAGER_ID, D.LOCATION_ID, "
						+ "   J.JOB_ID J_JOB_ID, J.JOB_TITLE, J.MIN_SALARY, J.MAX_SALARY"
						+ "   FROM EMPLOYEES E, DEPARTMENTS D, JOBS J " + "   WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID "
						+ "   AND   E.JOB_ID = J.JOB_ID";
				return query;
			}

			@Override
			public void mappingParameters(PreparedStatement stmt) throws SQLException {
				// TODO Auto-generated method stub

			}

			@Override
			public Object getData(ResultSet rs) {
				EmployeesVO employeesVO = new EmployeesVO();
				DepartmentsVO departmentsVO = new DepartmentsVO();
				JobsVO jobsVO = new JobsVO();

				BindData.bindData(rs, employeesVO);

				return employeesVO;
			}
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CountriesVO> getAllCountries() {

		return selectList(new QueryHandler() {

			@Override
			public String preparedQuery() {
				String sql = " SELECT  " + "  C.COUNTRY_ID, C.COUNTRY_NAME, C.REGION_ID, "
						+ "  R.REGION_ID R_REGION_ID, R.REGION_NAME " + "  FROM COUNTRIES C,REGIONS R "
						+ "  WHERE C.REGION_ID = R.REGION_ID" + "  AND  ROWNUM < 5 ";
				return sql;
			}

			@Override
			public void mappingParameters(PreparedStatement stmt) throws SQLException {
				// TODO Auto-generated method stub

			}

			@Override
			public Object getData(ResultSet rs) {
				CountriesVO countriesVO = new CountriesVO();

				BindData.bindData(rs, countriesVO);
				return countriesVO;
			}
		});
	}

	@Override
	public EmployeesVO fineOneEmployee(int emplyeeId) {

		return (EmployeesVO) selectOne(new QueryHandler() {

			@Override
			public String preparedQuery() {
				// 가변일 경우 SringBuffer 사용
				StringBuffer query = new StringBuffer();

				query.append("SELECT	EMPLOYEE_ID ");
				query.append("			,FIRST_NAME ");
				query.append("			,LAST_NAME  ");
				query.append("			,EMAIL      ");
				query.append("FROM		EMPLOYEES   ");
				query.append("WHERE 	EMPLOYEE_ID  = ?");
				return query.toString();
			}

			@Override
			public void mappingParameters(PreparedStatement stmt) throws SQLException {
				stmt.setInt(1, emplyeeId);

			}

			@Override
			public Object getData(ResultSet rs) {
				EmployeesVO employeesVO = new EmployeesVO();
				BindData.bindData(rs, employeesVO);
				return employeesVO;
			}
		});

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeesVO> getAllempInfo() {
		return selectList(new QueryHandler() {

			@Override
			public String preparedQuery() {
				StringBuffer query = new StringBuffer();

				query.append("SELECT   E.EMPLOYEE_ID                      ");
				query.append("        ,E.LAST_NAME                        ");
				query.append("        ,J.JOB_TITLE                          ");
				query.append("        ,L.CITY                             ");
				query.append("FROM    EMPLOYEES E                         ");
				query.append("        ,JOBS J                             ");
				query.append("        ,DEPARTMENTS D                      ");
				query.append("        ,LOCATIONS L                        ");
				query.append("WHERE   E.JOB_ID = J.JOB_ID                 ");
				query.append("AND     E.DEPARTMENT_ID = D.DEPARTMENT_ID   ");
				query.append("AND     L.LOCATION_ID = D.LOCATION_ID       ");

				return query.toString();
			}

			@Override
			public void mappingParameters(PreparedStatement stmt) throws SQLException {
				// TODO Auto-generated method stub

			}

			@Override
			public Object getData(ResultSet rs) {
				EmployeesVO employeesVO = new EmployeesVO();
				BindData.bindData(rs, employeesVO);
				BindData.bindData(rs, employeesVO.getJobs());
				BindData.bindData(rs, employeesVO.getLocations());

				return employeesVO;
			}
		});

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeesVO> findAllEmpInfo(int departmentId) {
		return selectList(new QueryHandler() {

			@Override
			public String preparedQuery() {
				StringBuffer query = new StringBuffer();
				query.append("SELECT   E.EMPLOYEE_ID                                       ");
				query.append("        ,E.LAST_NAME                                         ");
				query.append("        ,NVL(E.DEPARTMENT_ID,00000)  DEPARTMENT_ID          ");
				query.append("        ,NVL(D.DEPARTMENT_NAME,'부서없음')  DEPARTMENT_NAME  ");
				query.append(" FROM    EMPLOYEES E                                         ");
				query.append("        ,DEPARTMENTS D                                       ");
				query.append("WHERE   E.DEPARTMENT_ID = D.DEPARTMENT_ID(+)                 ");
				query.append("AND     E.DEPARTMENT_ID = ?                                  ");

				return query.toString();
			}

			@Override
			public void mappingParameters(PreparedStatement stmt) throws SQLException {
				stmt.setInt(1, departmentId);

			}

			@Override
			public Object getData(ResultSet rs) {
				EmployeesVO employeesVO = new EmployeesVO();
				BindData.bindData(rs, employeesVO);
				BindData.bindData(rs, employeesVO.getDepartments());
				return employeesVO;
			}
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeesVO> findCityEmpInfo(String city) {
		return selectList(new QueryHandler() {

			@Override
			public String preparedQuery() {
				StringBuffer query = new StringBuffer();
				query.append("SELECT   E.EMPLOYEE_ID                      ");
				query.append("        ,E.LAST_NAME                        ");
				query.append("        ,D.DEPARTMENT_NAME                  ");
				query.append("        ,J.JOB_TITLE                        ");
				query.append("        ,L.CITY                             ");
				query.append("FROM    EMPLOYEES E                         ");
				query.append("        ,JOBS J                             ");
				query.append("        ,DEPARTMENTS D                      ");
				query.append("        ,LOCATIONS L                        ");
				query.append("WHERE   E.JOB_ID = J.JOB_ID                 ");
				query.append("AND     E.DEPARTMENT_ID = D.DEPARTMENT_ID   ");
				query.append("AND     L.LOCATION_ID = D.LOCATION_ID       ");
				query.append("AND     L.CITY  = ?             			 ");
				// 'Seattle'

				return query.toString();
			}

			@Override
			public void mappingParameters(PreparedStatement stmt) throws SQLException {
				stmt.setString(1, city);

			}

			@Override
			public Object getData(ResultSet rs) {
				EmployeesVO employeesVO = new EmployeesVO();
				JobsVO jobsVO = new JobsVO();
				DepartmentsVO departmentsVO = new DepartmentsVO();
				LocationsVO locationsVO = new LocationsVO();

				BindData.bindData(rs, employeesVO);
				BindData.bindData(rs, employeesVO.getJobs());
				BindData.bindData(rs, employeesVO.getDepartments());
				BindData.bindData(rs, employeesVO.getLocations());
				return employeesVO;
			}
		});

	}

}
