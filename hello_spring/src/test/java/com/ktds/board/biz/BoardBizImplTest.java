package com.ktds.board.biz;

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
@ContextConfiguration({"classpath:/boardContext.xml","classpath:/rootContext.xml"})
public class BoardBizImplTest {

	@Autowired
	private BoardBiz boardBizImpl;
	BoardSearchVO boardSearchVO = new BoardSearchVO();
/*	
	@Test
	public void getAllArticles(){
		List<BoardVO> boardList = boardBizImpl.getAllArticles(boardSearchVO);
		assertTrue(boardList.size() > 0 );
	}*/
	
}
