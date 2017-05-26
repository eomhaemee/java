package com.ktds.board.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ktds.board.vo.BoardSearchVO;
import com.ktds.board.vo.BoardVO;

public class BoardDaoImpl extends SqlSessionDaoSupport implements BoardDao {
	/*
	 * 이제 dataSource선언 안해도 되지... private DataSource dataSource;
	 * 
	 * public void setDataSource(DataSource dataSource) { this.dataSource =
	 * dataSource; }
	 */

	@Override
	public List<BoardVO> getAllArticles(BoardSearchVO boardSearchVO) {
		/* namespace명.id */
		return getSqlSession().selectList("BoardDao.getAllArticles",boardSearchVO);
	}

	@Override
	public BoardVO getOneArticle(int boardId) {

		return getSqlSession().selectOne("BoardDao.getOneArticle", boardId);
	}

	@Override
	public int insertArticle(BoardVO boardVO) {

		return getSqlSession().insert("BoardDao.insertArticle", boardVO);

	}

	@Override
	public int deleteBoard(int boardId) {

		return getSqlSession().delete("BoardDao.deleteBoard", boardId);

	}

	@Override
	public int getAllArticlesCount(BoardSearchVO boardSearchVO) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("BoardDao.getAllArticlesCount",boardSearchVO);
	}

}
