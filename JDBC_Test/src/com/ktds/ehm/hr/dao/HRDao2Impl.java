package com.ktds.ehm.hr.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ktds.ehm.dao.support.JDBCDaoSupport;
import com.ktds.ehm.dao.support.QueryHandler;
import com.ktds.ehm.dao.support.annotation.BindData;
import com.ktds.ehm.hr.vo.EmployeesVO;

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


}
