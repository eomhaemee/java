package com.ktds.ehm.biz;

import com.ktds.ehm.dao.MySpringDao;

public class MySpringBizImpl implements MySpringBiz {
	private MySpringDao mySpringDao;
	
	public void setMySpringDao(MySpringDao mySpringDao) {
		this.mySpringDao = mySpringDao;
	}
	
	@Override
	public void printBizMessage() {
		System.out.println("나는 Biz프린트...");
		mySpringDao.printDaoMessage();
	}
	
}
