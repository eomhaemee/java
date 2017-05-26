package com.ktds.ehm.board.dao;

import java.util.List;

import com.ktds.ehm.board.vo.BoardVO;

public interface BoardDao {
	public List<BoardVO> getAllBoard();
	public BoardVO getOneBoard(int boardId);
	public int insertBoard(BoardVO boardVO);
	public int deleteBoard(int boardId);
}
