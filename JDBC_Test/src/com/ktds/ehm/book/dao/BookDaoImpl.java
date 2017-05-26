package com.ktds.ehm.book.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ktds.ehm.book.vo.BookVO;
import com.ktds.ehm.dao.support.JDBCDaoSupport;
import com.ktds.ehm.dao.support.QueryHandler;
import com.ktds.ehm.dao.support.annotation.BindData;

public class BookDaoImpl extends JDBCDaoSupport implements BookDao {

	@Override
	public List<BookVO> getBooks() {
		
		return selectList(new QueryHandler() {
			
			@Override
			public String preparedQuery() {
				StringBuffer query = new StringBuffer();
				
				query.append("SELECT  BK_ID            ");
				query.append("        , BK_NM          ");
				query.append("        , BK_CNTNT_IDX   ");
				query.append("        , WRTR           ");
				query.append("        , PBLSHR         ");
				query.append("        , PRICE          ");
				query.append("        , PBLSHING_DATE  ");
				query.append("        , REVIEW         ");
				query.append("FROM    BOOK             ");
				
				return query.toString();
			}
			
			@Override
			public void mappingParameters(PreparedStatement stmt) throws SQLException {}
			
			@Override
			public Object getData(ResultSet rs) {
				BookVO bookVO = new BookVO();
				BindData.bindData(rs, bookVO);
				return bookVO;
			}
		});
	
	}

}
