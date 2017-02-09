package com.ktds.ehm.department.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.ehm.department.vo.DepartmentsVO;
import com.ktds.ehm.department.vo.LocationsVO;

public class DepartmentsDaoImpl implements DepartmentsDao {

	@Override
	public List<DepartmentsVO> printAllDepartments() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {
			System.out.println("오라클 드라이버 로딩 실패! 시스템을 종료합니다.");
			return null;
		}

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String oracleUrl = "jdbc:oracle:thin:@localhost:1521:XE";

		try {
			conn = DriverManager.getConnection(oracleUrl, "HR", "hr");
			String query = "SELECT  " + "DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID,  " + "   LOCATION_ID "
					+ "FROM HR.DEPARTMENTS ";

			stmt = conn.prepareStatement(query);
			rs = stmt.executeQuery();

			DepartmentsVO departmentsVO = null;
			List<DepartmentsVO> departments = new ArrayList<DepartmentsVO>();

			while (rs.next()) {
				departmentsVO = new DepartmentsVO();
				departmentsVO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
				departmentsVO.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
				departments.add(departmentsVO);
			}

			return departments;

		} catch (SQLException e) {
			System.out.println("인스턴스초기화 실패");
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
	public List<DepartmentsVO> printAllDepartmentsWithEmp() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("오라클 로딩 실패");
			return null;
		}

		Connection conn = null;
		PreparedStatement stms = null;
		ResultSet rs = null;

		String OracleUrl = "jdbc:oracle:thin:@localhost:1521:XE";

		try {
			conn = DriverManager.getConnection(OracleUrl, "HR", "hr");
			String sql = " SELECT  " + " D.DEPARTMENT_ID, D.DEPARTMENT_NAME, D.MANAGER_ID,  " + " D.LOCATION_ID ,"
					+ " E.EMPLOYEE_ID , E.FIRST_NAME , E.DEPARTMENT_ID D_DEPARTMENT_ID"
					+ " FROM DEPARTMENTS  D, EMPLOYEES E " + " WHERE D.DEPARTMENT_ID  = E.DEPARTMENT_ID";

			stms = conn.prepareStatement(sql);

			rs = stms.executeQuery();

			List<DepartmentsVO> depatments = new ArrayList<DepartmentsVO>();
			DepartmentsVO departmentsVO = null;
			while (rs.next()) {
				departmentsVO = new DepartmentsVO();
				departmentsVO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
				departmentsVO.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
				departmentsVO.setManager_id(rs.getInt("MANAGER_ID"));
				departmentsVO.setLocation_id(rs.getInt("LOCATION_ID"));

				departmentsVO.getEmployeesVO().setEmployeeId(rs.getInt("EMPLOYEE_ID"));
				departmentsVO.getEmployeesVO().setFirstName(rs.getString("FIRST_NAME"));
				departmentsVO.getEmployeesVO().setDepartmentId(rs.getInt("D_DEPARTMENT_ID"));

				depatments.add(departmentsVO);
			}

			return depatments;
		} catch (SQLException e) {
			System.out.println("인스턴스초기화 실패2");
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
				if (stms != null) {
					stms.close();
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
		// return null;
	}

	@Override
	public List<DepartmentsVO> printAllLocationWithdept() {

		try {
			Class.forName("oracle.jdbc.dirver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("오라클 드라이버 로딩 실패!");
			return null;
		}

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String url = "jdbc:oracle:thin:@localhost:1521:XE";

		try {
			conn = DriverManager.getConnection(url, "HR", "hr");

			String sql = " SELECT  " + " LOCATION_ID, STREET_ADDRESS, POSTAL_CODE,  "
					+ " CITY, STATE_PROVINCE, COUNTRY_ID, " + " D.DEPARTMENT_NAME" + " FROM LOCATIONS L, DEPARTMENTS D";

			stmt = conn.prepareStatement(sql);
			stmt.executeQuery();

			DepartmentsVO departmentsVO;
			List<DepartmentsVO> departments = new ArrayList<DepartmentsVO>();

			while (rs.next()) {
				departmentsVO = new DepartmentsVO();
				departmentsVO.setDepartment_id(rs.getInt("DEPARTMENT_NAME"));
				departmentsVO.getLocationsVO().setLocaiontId(rs.getInt("LOCATION_ID"));
				departments.add(departmentsVO);

			}

			return departments;

		} catch (SQLException e) {
			System.out.println("인스턴스 생성실패");
			return null;
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {}

			try {
				if( stmt != null ){
					stmt.close();
				}
			} catch (SQLException e) {}
			try {
				if ( conn != null ){
					conn.close();
				}
			} catch (SQLException e) {}
		}

	}

}
