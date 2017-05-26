package com.ktds.board.biz;

import com.ktds.board.vo.BoardListVO;
import com.ktds.board.vo.BoardSearchVO;
import com.ktds.board.vo.BoardVO;

public interface BoardBiz {
	//List<BoardVO> ==>  BoardListVO 로 바꾸자
	public BoardListVO getAllArticles(BoardSearchVO boardSearchVO);
	public BoardVO getOneArticle(int boardId);
	public boolean insertArticle(BoardVO boardVO);
	public boolean deleteBoard(int boardId);
}
