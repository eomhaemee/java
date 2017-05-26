package com.ktds.board.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ktds.board.vo.BoardListVO;
import com.ktds.board.vo.BoardSearchVO;
import com.ktds.board.vo.BoardVO;
/*,"classpath:/rooContext.xml"}*/
/*src\test <= classpath  @ContextConfiguration  에 설정된 context파일의 bean들을 가져와 객체화함 */
@RunWith(SpringJUnit4ClassRunner.class) // 설정파일을 가져오는것 해당 설정파일은 아래줄에 명시함
@ContextConfiguration({"classpath:/boardContext.xml","classpath:/rootContext.xml"})
public class BoardServiceImplTest {
	//test코드는 리턴 type이 void여야함
	//bean컨테이너에서 사용하려는 변수명과 같은 객체bean을 찾아주입시켜줌
	@Autowired
	private BoardService boardServiceImpl;
	BoardSearchVO boardSearchVO = new BoardSearchVO();
	@Test
	public void getAllArticles(){
		
		BoardListVO boardList = boardServiceImpl.getAllArticles(boardSearchVO);
		//assertTrue () 조건이 참이면 true;
		assertTrue(boardList.getBoardList().size() > 0 );
	}
	@Test
	public void getAllArticlesNull(){
		
		BoardListVO boardList = boardServiceImpl.getAllArticles(boardSearchVO);
		assertNull(boardList);
	}
	@Test
	public void getAllArticlesSizeZero(){
		BoardListVO boardList = boardServiceImpl.getAllArticles(boardSearchVO);
		assertTrue(boardList.getBoardList().size() > 0 );
	}
	//이 test case는  NumberFormatException 이 발생함을 test하는거야 
	//expected 를 써준다 아래코드실행시 NumberFormatException 발생하면
	//요 TEST case는 TRUE 대신 위에것들은 False겠지
	@Test(expected=NumberFormatException.class)
	public void getAllArticlesThrowNumberFormatException(){
		BoardListVO boardList = boardServiceImpl.getAllArticles(boardSearchVO);
	}
	
}
