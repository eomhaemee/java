package com.ktds.ehm.services;

import com.ktds.ehm.biz.MySpringBiz;

public class MySpringServicesImpl implements MySpringServices {

	private MySpringBiz mySpringBiz;
	@Override
	public void printMessage() {
		System.out.println("Project Servieces 이지요");
		
	}
	
	public void setMySpringBiz(MySpringBiz mySpringBiz) {
		this.mySpringBiz = mySpringBiz;
	}
	
}
