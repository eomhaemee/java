package com.ktds.ehm.user.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ktds.ehm.user.vo.UsersVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/userContext.xml","classpath:/rootContext.xml"})
public class UserDaoImplTest {
	/*private Logger logger = LoggerFactory.getLogger(UserDaoImplTest.class);*/
	@Autowired
	private UserDaoImpl userDaoImpl;
	@Test
	public void insertUser(){
		UsersVO usersVO = new UsersVO();
		usersVO.setUserId("testttttt");
		usersVO.setUserName("testname");
		usersVO.setUserPassword("testpassword");
		
		int result = userDaoImpl.insertUsers(usersVO);
		/*logger.info("name"+usersVO.getUserName());*/
		assertEquals("testname", usersVO.getUserName());
	}
}
