package com.ktds.ehm.board.service;

import java.util.List;

import com.ktds.ehm.board.vo.BoardVO;

public interface BoardService {
	public List<BoardVO> getAllBoard();
	public BoardVO getOneBoard(int boardId);
	public boolean insertBoard(BoardVO boardVO);
	public boolean deleteBoard(int boardId);
}
