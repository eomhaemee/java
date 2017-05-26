package com.ktds.ehm.biz;

import com.ktds.ehm.dao.MySpringDao;

public class MySpringBizImpl implements MySpringBiz {

	private MySpringDao mySpringDao;
	
	public void setMySpringDao(MySpringDao mySpringDao) {
		this.mySpringDao = mySpringDao;
	}
	@Override
	public void printMessage() {
		System.out.println("Project Biz이지요..");
		
	}

}
