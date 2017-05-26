package com.ktds.board.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ktds.board.vo.BoardSearchVO;
import com.ktds.board.vo.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/rootContext.xml","classpath:/boardContext.xml"})
/*@TransactionConfiguration
@Transactional*/
public class BoardDaoImplTest {
/*	public List<BoardVO> getAllArticles();
	public BoardVO getOneArticle(int boardId);
	public int insertArticle(BoardVO boardVO);
	public int deleteBoard(int boardId);*/
	@Autowired
	private BoardDao boardDaoImpl;
	BoardSearchVO boardSearchVO = new BoardSearchVO();
	
	@Test
	public void getAllArticles(){
		List<BoardVO> boardList = boardDaoImpl.getAllArticles(boardSearchVO);
		assertTrue(boardList.size() > 0 );
	}
	
	@Test
	public void getOndArticle(){
		BoardVO board = boardDaoImpl.getOneArticle(111);
		
		assertNull(board);
	}
	@Test
	public void deleteArticle(){
		
		int isSuccess = boardDaoImpl.deleteBoard(155);
		assertTrue(isSuccess > 0 );
	}
	@Test
	public void insertArticle(){
		
		BoardVO boardVO = new BoardVO();
		
		boardVO.setContent("content");
		boardVO.setIp("10.0.0.0");
		boardVO.setLikeCount(0);
		boardVO.setPost("postName");
		boardVO.setSubject("subject");
		boardVO.setWriteDate("2017.04.13");
		boardVO.setWriter("writer");
		
		int isSuccess = boardDaoImpl.insertArticle(boardVO);
		
		assertEquals("content", boardVO.getContent());
		
		
	}
}
