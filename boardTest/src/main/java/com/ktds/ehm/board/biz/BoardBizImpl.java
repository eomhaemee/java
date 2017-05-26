package com.ktds.ehm.board.biz;

import java.util.List;

import com.ktds.ehm.board.dao.BoardDao;
import com.ktds.ehm.board.vo.BoardVO;

public class BoardBizImpl implements BoardBiz {
	private BoardDao boardDao;
	
	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	@Override
	public List<BoardVO> getAllBoard() {
		System.out.println("biz..." + boardDao.getAllBoard().size());
		return boardDao.getAllBoard();
	}

	@Override
	public BoardVO getOneBoard(int boardId) {
		// TODO Auto-generated method stub
		return boardDao.getOneBoard(boardId);
	}

	@Override
	public boolean insertBoard(BoardVO boardVO) {
		// TODO Auto-generated method stub
		return boardDao.insertBoard(boardVO) > 0  ;
	}

	@Override
	public boolean deleteBoard(int boardId) {
		// TODO Auto-generated method stub
		return boardDao.deleteBoard(boardId) > 0 ;
	}

}
