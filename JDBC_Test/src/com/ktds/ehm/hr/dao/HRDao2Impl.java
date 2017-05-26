package com.ktds.ehm.hr.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.ehm.dao.support.JDBCDaoSupport;
import com.ktds.ehm.dao.support.QueryHandler;
import com.ktds.ehm.dao.support.annotation.BindData;
import com.ktds.ehm.hr.vo.EmployeesVO;

import oracle.net.aso.e;

public class HRDao2Impl extends JDBCDaoSupport implements HRDao2 {

	@Override
	public List<EmployeesVO> getAllEmployees() {

		return selectList(new QueryHandler() {

			@Override
			public String preparedQuery() {
				StringBuffer query = new StringBuffer();

				query.append("	SELECT	EMPLOYEE_ID      ");
				query.append("	        ,FIRST_NAME      ");
				query.append("	        ,LAST_NAME       ");
				query.append("	        ,EMAIL           ");
				query.append("	        ,PHONE_NUMBER    ");
				query.append("	        ,HIRE_DATE       ");
				query.append("	        ,JOB_ID          ");
				query.append("	        ,SALARY          ");
				query.append("	        ,COMMISSION_PCT  ");
				query.append("	        ,MANAGER_ID      ");
				query.append("	        ,DEPARTMENT_ID   ");
				query.append(" FROM		EMPLOYEES        ");
				return query.toString();
			}

			@Override
			public void mappingParameters(PreparedStatement stmt) throws SQLException {
			

			}

			@Override
			public Object getData(ResultSet rs) {
				EmployeesVO employeesVO = new EmployeesVO();
				BindData.bindData(rs, employeesVO);
				return employeesVO;
			}
		});

	}

	@Override
	public EmployeesVO findOneEmployee(int employeeId) {
		

		return (EmployeesVO) selectOne(new QueryHandler() {
			
			@Override
			public String preparedQuery() {
				StringBuffer query = new StringBuffer();
				
				query.append("	SELECT	EMPLOYEE_ID      ");
				query.append("	        ,FIRST_NAME      ");
				query.append("	        ,LAST_NAME       ");
				query.append("	        ,EMAIL           ");
				query.append("	        ,PHONE_NUMBER    ");
				query.append("	        ,HIRE_DATE       ");
				query.append("	        ,JOB_ID          ");
				query.append("	        ,SALARY          ");
				query.append("	        ,COMMISSION_PCT  ");
				query.append("	        ,MANAGER_ID      ");
				query.append("	        ,DEPARTMENT_ID   ");
				query.append(" FROM		EMPLOYEES        ");
				query.append(" WHERE	EMPLOYEE_ID = ?  ");
				
				return query.toString();
			}
			
			@Override
			public void mappingParameters(PreparedStatement stmt) throws SQLException {
				stmt.setInt(1, employeeId);
				
			}
			
			@Override
			public Object getData(ResultSet rs) {
				EmployeesVO employeesVO = new EmployeesVO();
				BindData.bindData(rs, employeesVO);
				return employeesVO;
			}
		});
		
		
		
	}

	@Override
	public List<EmployeesVO> getAllEmployees2() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("클래스 로딩 실패");
			return null;
		}
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String url = "jdbc:oracl:thin:@localhost:1521:XE";
		try {
			conn = DriverManager.getConnection(url, "HR", "hr");
			
			String query = " SELECT  " + "   E.EMPLOYEE_ID, E.FIRST_NAME, E.LAST_NAME,  "
					+ "   E.EMAIL, E.PHONE_NUMBER, E.HIRE_DATE,  " + "   E.JOB_ID, E.SALARY, E.COMMISSION_PCT,  "
					+ "   E.MANAGER_ID, E.DEPARTMENT_ID, "
					+ "   D.DEPARTMENT_ID  D_DEPARTMENT_ID, D.DEPARTMENT_NAME , D.MANAGER_ID D_MANAGER_ID, D.LOCATION_ID, "
					+ "   J.JOB_ID J_JOB_ID, J.JOB_TITLE, J.MIN_SALARY, J.MAX_SALARY"
					+ "   FROM EMPLOYEES E, DEPARTMENTS D, JOBS J " 
					+ "   WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID "
					+ "   AND   E.JOB_ID = J.JOB_ID";
			
			stmt = conn.prepareStatement(query);
			rs = stmt.executeQuery();
			
			EmployeesVO employeesVO = null;
			List<EmployeesVO> employees = new ArrayList<EmployeesVO>();
			
			while(rs.next()){
				employeesVO = new EmployeesVO();
				
				employeesVO.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
				employeesVO.getDepartments().setDepartmentId(rs.getInt("DEPARTMENT_ID"));
				
				employees.add(employeesVO);
				
			}
			
			return employees;
			
		} catch (SQLException e) {
			System.out.println("인스턴스 생성실패");
			return null;
		}finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {}
			try {
				if(rs != null){
					stmt.close();
				}
			} catch (SQLException e) {}
			try {
				if(conn!= null ){
					conn.close();
				}
			} catch (SQLException e) {}
		}

	}


}
