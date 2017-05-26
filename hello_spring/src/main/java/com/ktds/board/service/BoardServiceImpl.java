package com.ktds.board.service;

import com.ktds.board.biz.BoardBiz;
import com.ktds.board.vo.BoardListVO;
import com.ktds.board.vo.BoardSearchVO;
import com.ktds.board.vo.BoardVO;

public class BoardServiceImpl implements BoardService {
	private BoardBiz boardBiz;
	
	public void setBoardBiz(BoardBiz boardBiz) {
		this.boardBiz = boardBiz;
	}

	@Override
	public BoardListVO getAllArticles(BoardSearchVO boardSearchVO) {
/*		
		//TEST하기 위한 imsi코드
		if( number == 0 ) {
			return null;
		}
		else if(number == 10 ) {
			return new ArrayList<BoardVO>();
		}
		else if(number == 20 ) {
			Integer.parseInt("ABC");
			return  null;
		}
		else{
			return boardBiz.getAllArticles();
		}
*/
		return boardBiz.getAllArticles(boardSearchVO);
	}

	@Override
	public BoardVO getOneArticle(int boardId) {
		// TODO Auto-generated method stub
		return boardBiz.getOneArticle(boardId);
	}

	@Override
	public boolean insertArticle(BoardVO boardVO) {
		// TODO Auto-generated method stub
		return boardBiz.insertArticle(boardVO) ;
	}
	@Override
	public boolean deleteBoard(int boardId) {
		// TODO Auto-generated method stub
		return boardBiz.deleteBoard(boardId);
	}
}
