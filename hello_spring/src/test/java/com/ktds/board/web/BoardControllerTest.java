package com.ktds.board.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.io.File;
import java.io.FileInputStream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMultipartHttpServletRequestBuilder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.ktds.user.vo.UsersVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/applicationContext.xml","classpath:/userContext.xml","classpath:/boardContext.xml","classpath:/rootContext.xml"})
@WebAppConfiguration

/*
 * JUnit을 통해서 테스트하더라도 DB에 접근하지 않을 수 있다.
 * TransactionManager, TransactionAdvise, aop:config 3가지 필요
 */
@Transactional
@TransactionConfiguration(transactionManager="transactionManager")

public class BoardControllerTest {
/*	@Autowired
	private BoardController boardController;
	@Test
	public void viewBoardListPage(){
		boardController.viewDetailPage(10);
	}
	*/
	
	@Autowired
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp(){
		mockMvc = webAppContextSetup(ctx).build();
	}
/*	@After
	public void tearDown(){
		
	}*/
	@Test
	public void viewBoardListPage() throws Exception{
		
		UsersVO userVO = new UsersVO();
		userVO.setUserId("test");
		userVO.setUserPassword("test");
		
		/*  import를 static 바꾸고 호출 방식을 바꿔보자(아래..)
		 *  mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
		 * 	mockMvc.perform(MockMvcRequestBuilders.get("/board").sessionAttr("_USER_", userVO))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.model().attributeExists("allArticles"))
				.andExpect(MockMvcResultMatchers.view().name("board/list"));	*/
		
		/*mockMvc = webAppContextSetup(ctx).build();*/
		mockMvc.perform(get("/board").sessionAttr("_USER_", userVO))
				.andExpect(status().isOk())//isOk() : 200 =>is(200)
				.andExpect(model().attributeExists("allArticles"))
				.andExpect(view().name("board/list"));	
	}

	@Test
	public void doWriteActionTest() throws Exception {
		
		/*1.BoardVO 검증 : 각각의 parameter를 개별로 확인*/
		//file을 write하는 경우는 이렇게 
		MockMultipartHttpServletRequestBuilder builder = fileUpload("/board/write");
		//일반적인 post는 이렇게 호출
		//MockHttpServletRequestBuilder builder = post("/board/write");
		/*MockMultipartHttpServletRequestBuilder builder = fileUpload("/board/write");*/
		
		builder.param("subject", "제목을 길게 10글자 이상 썼음");
		builder.param("content", "내용을 길게 10글자 이상 썼음");
		builder.param("writer", "작성자입니다.");
		
		UsersVO userVO = new UsersVO();
		userVO.setUserId("test");
		userVO.setUserPassword("test");
		userVO.setUserName("관리자");
		
		builder.sessionAttr("_USER_", userVO);
		
		mockMvc.perform(builder)
			.andExpect(model().hasNoErrors())
			.andExpect(status().is(302)) // redirect는 302 코드로 오면 ok,,(isMovedPermanently 301 isMovedTemporarily :302)
			.andExpect(redirectedUrl("/board"));

		/*2. 파일이 올라가는지 test*/
		File f = new File("D:\\uploadFiles\\board\\Desert.jpg");
		
		FileInputStream fis = new FileInputStream(f);
		//arg1 : 파일 전달받는 이름 file BoardVO MultipartFile 의 이름 / arg2: 파일의 이름 / arg3: 
		MockMultipartFile file =
				new MockMultipartFile("file",f.getName(),"multipart/form-data",fis);
		
		builder.file(file);
		
		
		
	}
	@Test
	public void doWriteActionErrorTest() throws Exception {
		MockMultipartHttpServletRequestBuilder builder = fileUpload("/board/write");
		//3.errors.hasErrors()
			builder.param("subject", "짧게 썼음");
			
			UsersVO userVO = new UsersVO();
			userVO.setUserId("test");
			userVO.setUserPassword("test");
			userVO.setUserName("관리자");
			
			builder.sessionAttr("_USER_", userVO);
			mockMvc.perform(builder)
				.andExpect(model().hasErrors())
				.andExpect(view().name("board/write"));
	}
	
	

}
