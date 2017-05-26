package com.ktds.board.biz;

import java.util.ArrayList;

import com.ktds.board.dao.BoardDao;
import com.ktds.board.vo.BoardListVO;
import com.ktds.board.vo.BoardSearchVO;
import com.ktds.board.vo.BoardVO;

public class BoardBizImpl implements BoardBiz {
	private BoardDao boardDao;
	
	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	@Override
	//public List<BoardVO> getAllArticles(BoardSearchVO boardSearchVO) {
	public BoardListVO getAllArticles(BoardSearchVO boardSearchVO) {
		// 
		int totalCount = boardDao.getAllArticlesCount(boardSearchVO);
		
		BoardListVO boardListVO = new BoardListVO();
		//pager는 boardListVO에 있으므로 totalcount, 현재 pageNo를 boardListVO에게 넘겨줌
		boardListVO.getPager().setPageNumber(boardSearchVO.getPageNo());
		boardListVO.getPager().setTotalArticleCount(totalCount);
		
		//DB는 SearchVO를 
		boardSearchVO.setEndArticleNumber(boardListVO.getPager().getEndArticleNumber());
		boardSearchVO.setStartArticleNumber(boardListVO.getPager().getStartArticleNumber());
		
		
		if ( totalCount  == 0 ){
			//return new ArrayList<BoardVO>();
			return boardListVO;
		}
		else{
			//return boardDao.getAllArticles(boardSearchVO);
			boardListVO.setBoardList(boardDao.getAllArticles(boardSearchVO));
		}
		return boardListVO;
	}

	@Override
	public BoardVO getOneArticle(int boardId) {
		// TODO Auto-generated method stub
		return boardDao.getOneArticle(boardId);
	}

	@Override
	public boolean insertArticle(BoardVO boardVO) {
		// TODO Auto-generated method stub
		return boardDao.insertArticle(boardVO) > 0 ;
	}
	@Override
	public boolean deleteBoard(int boardId) {
		// TODO Auto-generated method stub
		return boardDao.deleteBoard(boardId) > 0 ;
	}


}
