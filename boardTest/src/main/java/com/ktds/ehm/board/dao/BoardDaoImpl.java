package com.ktds.ehm.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.ktds.ehm.board.vo.BoardVO;

public class BoardDaoImpl implements BoardDao {
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		System.out.println(this.dataSource);
	}

	@Override
	public List<BoardVO> getAllBoard() {
		Connection conn= null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			StringBuffer query = new StringBuffer();
			
			query.append(" SELECT		BOARD_ID    ");
			query.append(" 			, SUBJECT       ");
			query.append(" 			, CONTENT       ");
			query.append(" 			, WRITER        ");
			query.append(" 			, LIKE_COUNT    ");
			query.append(" 			, WRITE_DATE    ");
			query.append(" 			, IP            ");
			query.append(" 			, PST           ");
			query.append(" FROM		BOARD           ");
			query.append(" ORDER BY BOARD_ID DESC           ");
			
			
			stmt = conn.prepareStatement(query.toString());
			rs = stmt.executeQuery();
			List<BoardVO> boards = new ArrayList<BoardVO>();
			BoardVO board = null;
			while(rs.next()){
				board = new BoardVO();
				board.setBoardId(rs.getInt("BOARD_ID"));
				board.setSubject(rs.getString("SUBJECT"));
				board.setContent(rs.getString("CONTENT"));
				board.setWriter(rs.getString("WRITER"));
				board.setLikeCount(rs.getInt("LIKE_COUNT"));
				board.setWriteDate(rs.getString("WRITE_DATE"));
				board.setIp(rs.getString("IP"));
				board.setPost(rs.getString("PST"));
				boards.add(board);
			}
			return boards;
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		}finally {
			try {
				if( rs != null ) {
					rs.close();
				}
			} catch (SQLException e) {}
			try {
				if ( stmt !=  null ) {
					stmt.close();
				}
			} catch (SQLException e) {}
			try {
				if ( conn != null ) {
					conn.close();
				}
			} catch (SQLException e) {}
		}
	}

	@Override
	public BoardVO getOneBoard(int boardId) {
		Connection conn =  null;
		PreparedStatement stmt= null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			StringBuffer query = new StringBuffer();
			
			query.append(" SELECT		BOARD_ID    ");
			query.append(" 			, SUBJECT       ");
			query.append(" 			, CONTENT       ");
			query.append(" 			, WRITER        ");
			query.append(" 			, LIKE_COUNT    ");
			query.append(" 			, WRITE_DATE    ");
			query.append(" 			, IP            ");
			query.append(" 			, PST           ");
			query.append(" FROM		BOARD           ");
			query.append(" WHERE	BOARD_ID = ?    ");
			
			stmt = conn.prepareStatement(query.toString());
			stmt.setInt(1, boardId);
			rs = stmt.executeQuery();

			BoardVO board = null;
			if(rs.next()){
				board = new BoardVO();
				board.setBoardId(rs.getInt("BOARD_ID"));
				board.setSubject(rs.getString("SUBJECT"));
				board.setContent(rs.getString("CONTENT"));
				board.setWriter(rs.getString("WRITER"));
				board.setLikeCount(rs.getInt("LIKE_COUNT"));
				board.setWriteDate(rs.getString("WRITE_DATE"));
				board.setIp(rs.getString("IP"));
				board.setPost(rs.getString("PST"));
			}
			return board;
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		finally {
			if(rs != null ){
				try {
					rs.close();
				} catch (SQLException e) {}
			}
			if( stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {}
			}
			if( conn != null ){
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}

	@Override
	public int insertBoard(BoardVO boardVO) {
		Connection conn =  null;
		PreparedStatement stmt= null;
		
		
		try {
			conn = dataSource.getConnection();
			StringBuffer query = new StringBuffer();
			
			query.append(" INSERT INTO  BOARD (BOARD_ID       ");
			query.append(" 			, SUBJECT          ");
			query.append(" 			, CONTENT          ");
			query.append(" 			, WRITER           ");
			query.append(" 			, LIKE_COUNT       ");
			query.append(" 			, WRITE_DATE       ");
			query.append(" 			, IP               ");
			query.append(" 			, PST               ");
			query.append(" 			)            ");
			query.append(" 	VALUES	( BOARD_ID_SEQ.NEXTVAL  ");
			query.append(" 			,?                 ");
			query.append(" 			,?                 ");
			query.append(" 			,?                 ");
			query.append(" 			,0                 ");
			query.append(" 			, TO_CHAR(SYSDATE,'YYYYMMDD')  ");
			query.append(" 			,?                 ");
			query.append(" 			,?                 ");
			query.append(" 			)                  ");
			
			
			stmt = conn.prepareStatement(query.toString());
			stmt.setString(1, boardVO.getSubject());
			stmt.setString(2, boardVO.getContent());
			stmt.setString(3, boardVO.getWriter());
			stmt.setString(4, boardVO.getIp());
			stmt.setString(5, boardVO.getPost());
			
			return stmt.executeUpdate();

			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		finally {
			
			if( stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {}
			}
			if( conn != null ){
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}

	@Override
	public int deleteBoard(int boardId) {
		Connection conn =  null;
		PreparedStatement stmt= null;
		
		
		try {
			conn = dataSource.getConnection();
			StringBuffer query = new StringBuffer();
			
			query.append("DELETE 		");
			query.append("FROM 	BOARD	");
			query.append("WHERE	BOARD_ID = ? ");
			
			stmt = conn.prepareStatement(query.toString());
			stmt.setInt(1, boardId);
			return stmt.executeUpdate();

			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		finally {
			
			if( stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {}
			}
			if( conn != null ){
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}

}
