package com.ktds.ehm.board.service;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ktds.ehm.board.vo.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/boardContext.xml","classpath:/rootContext.xml"})
public class BoardServiceImplTest {

	@Autowired
	private BoardServiceImpl boardServiceImpl;
	
	@Test
	public void getAllBoards(){
		List<BoardVO> boards = boardServiceImpl.getAllBoard();
		assertTrue(boards.size()>0);
	}
}
