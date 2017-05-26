package com.ktds.ehm.board.biz;

import java.util.List;

import com.ktds.ehm.board.vo.BoardVO;

public interface BoardBiz {
	public List<BoardVO> getAllBoard();
	public BoardVO getOneBoard(int boardId);
	public boolean insertBoard(BoardVO boardVO);
	public boolean deleteBoard(int boardId);
}
