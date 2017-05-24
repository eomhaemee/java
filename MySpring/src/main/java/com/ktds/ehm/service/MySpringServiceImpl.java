package com.ktds.ehm.service;

import com.ktds.ehm.biz.MySpringBiz;

public class MySpringServiceImpl implements MySpringService {
	private MySpringBiz mySpringBiz;
	
	public void setMySpringBiz(MySpringBiz mySpringBiz) {
		this.mySpringBiz = mySpringBiz;
	}
	@Override
	public void printServiceMessage() {
		System.out.println("나는 Service프린트..");
		mySpringBiz.printBizMessage();
	}

}
