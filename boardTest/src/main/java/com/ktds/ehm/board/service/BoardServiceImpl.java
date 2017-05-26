package com.ktds.ehm.board.service;

import java.util.List;

import com.ktds.ehm.board.biz.BoardBiz;
import com.ktds.ehm.board.vo.BoardVO;

public class BoardServiceImpl implements BoardService {
	private BoardBiz boardBiz;
	
	public void setBoardBiz(BoardBiz boardBiz) {
		this.boardBiz = boardBiz;
	}
	
	@Override
	public List<BoardVO> getAllBoard() {
		// TODO Auto-generated method stub
		return boardBiz.getAllBoard();
	}

	@Override
	public BoardVO getOneBoard(int boardId) {
		// TODO Auto-generated method stub
		return boardBiz.getOneBoard(boardId);
	}

	@Override
	public boolean insertBoard(BoardVO boardVO) {
		// TODO Auto-generated method stub
		return boardBiz.insertBoard(boardVO);
	}

	@Override
	public boolean deleteBoard(int boardId) {
		// TODO Auto-generated method stub
		return boardBiz.deleteBoard(boardId);
	}

}
