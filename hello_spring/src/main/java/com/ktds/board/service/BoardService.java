package com.ktds.board.service;

import com.ktds.board.vo.BoardListVO;
import com.ktds.board.vo.BoardSearchVO;
import com.ktds.board.vo.BoardVO;

public interface BoardService {
	public BoardListVO getAllArticles(BoardSearchVO boardSearchVO);
	public BoardVO getOneArticle(int boardId);
	public boolean insertArticle(BoardVO boardVO);
	public boolean deleteBoard(int boardId);
	
}
