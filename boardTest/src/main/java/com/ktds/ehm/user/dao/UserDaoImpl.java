package com.ktds.ehm.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.ktds.ehm.user.vo.UsersVO;

public class UserDaoImpl implements UserDao {
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	@Override
	public List<UsersVO> selectAllUsers() {
	

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			StringBuffer query = new StringBuffer();
			query.append("SELECT	USR_ID   ");
			query.append("        	, USR_NM   ");
			query.append("        	, USR_PWD ");
			query.append("        	, JOIN_DT ");
			query.append("FROM		USRS       ");
			
			stmt = conn.prepareStatement(query.toString());
			rs = stmt.executeQuery();
			
			
			List<UsersVO> usersList = new ArrayList<UsersVO>();
			UsersVO usersVO = null;
			while( rs.next() ){
				usersVO.setUserId(rs.getString("USR_ID"));
				usersVO.setUserName(rs.getString("USR_NM"));
				usersVO.setUserPassword(rs.getString("USR_PWD"));
				usersVO.setJoinDate(rs.getString("JOIN_DT"));
				usersList.add(usersVO);
			}
			return usersList;
			
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		}finally {
			try {
				if( rs  != null ) {
					rs.close();
				}
			} catch (SQLException e) {
			}
			try {
				if ( stmt != null ) {
					stmt.close();
				}
			} catch (SQLException e) {
			}
			try {
				if ( conn != null ){
					conn.close();
				}
			} catch (SQLException e) {
			}
		}
	}

	@Override
	public UsersVO selectOneUsers(UsersVO usersVO) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
	
		
		try {
			conn = dataSource.getConnection();
			StringBuffer query = new StringBuffer();
			query.append("SELECT	USR_ID   ");
			query.append("        	,USR_NM   ");
			query.append("        	,USR_PWD ");
			query.append("        	,JOIN_DT ");
			query.append("FROM	USRS       ");
			query.append(" WHERE USR_ID = ?   ");
			query.append(" AND 	USR_PWD = ?   ");
		
			
			stmt = conn.prepareStatement(query.toString());
			stmt.setString(1, usersVO.getUserId());
			stmt.setString(2, usersVO.getUserPassword());
			rs = stmt.executeQuery();
			
			UsersVO users = null;
			if( rs.next() ){
				users = new UsersVO();
				users.setUserId(rs.getString("USR_ID"));
				users.setUserName(rs.getString("USR_NM"));
				users.setUserPassword(rs.getString("USR_PWD"));
				users.setJoinDate(rs.getString("JOIN_DT"));
				
			}
			return users;
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		}finally {
			try {
				if ( rs != null ) {
					rs.close();
				}
			} catch (SQLException e) {
			}
			try {
				if ( stmt != null ){
					stmt.close();
				}
			} catch (SQLException e) {
			}
			try {
				if ( conn != null ){
					conn.close();
				}
			} catch (SQLException e) {
			}
			
		}
	}

	@Override
	public int insertUsers(UsersVO usersVO) {
		
		Connection conn = null;
		PreparedStatement stmt =  null;
		
		try {
			conn = dataSource.getConnection();
			StringBuffer query = new StringBuffer();
			 query.append( "INSERT INTO USRS (");
             query.append( "             	USR_ID   ");
		     query.append("        			,USR_NM   ");
			 query.append("        			,USR_PWD ");
			 query.append("        			,JOIN_DT ");
             query.append( "                   ) ");
             query.append( "VALUES             (");
             query.append( "                    ? ");
             query.append( "                    ,? ");
             query.append( "                    ,? ");
             query.append( "                	,SYSDATE ");
             query.append( "                   ) ");
			
             stmt = conn.prepareStatement(query.toString());
             
             stmt.setString(1, usersVO.getUserId());
             stmt.setString(2, usersVO.getUserName());
             stmt.setString(3, usersVO.getUserPassword());
             
             return stmt.executeUpdate();
            		 
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		}finally {
			try {
				if ( stmt != null ) {
					stmt.close();
				}
			} catch (SQLException e) {
		}
			try {
				if( conn != null ) {
					conn.close();
				}
			} catch (SQLException e) {
			}
		}

	}
}
