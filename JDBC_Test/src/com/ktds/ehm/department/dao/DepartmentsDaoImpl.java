package com.ktds.ehm.department.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.ehm.department.vo.DepartmentsVO;


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
			String query = "SELECT  " + "DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID,  " 
					+ "   LOCATION_ID "
					+ "FROM HR.DEPARTMENTS ";

			stmt = conn.prepareStatement(query);
			rs = stmt.executeQuery();
		
			DepartmentsVO departmentsVO = null;
			List<DepartmentsVO> departments =  new ArrayList<DepartmentsVO>(); 
			
			while ( rs.next()) {
				departmentsVO = new DepartmentsVO();
				departmentsVO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
				departmentsVO.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
				departments.add(departmentsVO);
			}
			
			return departments;
			
		} catch (SQLException e) {
			System.out.println("인스턴스초기화 실패");
			return null;
		}finally {
			try {
				if( rs != null){
					rs.close();
				}
			} catch (SQLException e) {}
			try {
				if( stmt != null ) {
					stmt.close();
				}
			} catch (SQLException e) {}
			try {
				if( conn != null ) {
					conn.close();
				}
			} catch (SQLException e) {}
			
			
		}

	}

}
