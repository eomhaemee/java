package com.ktds.ehm.service;

import com.ktds.ehm.biz.MainBiz;

public class MainServiceImpl implements MainService{
	
	private MainBiz mainBiz;
	
	//Spring이 로드 될때 수행됨
	public void setMainBiz(MainBiz mainBiz) {
		System.out.println("setMainBiz() : " + mainBiz);
		this.mainBiz = mainBiz;
	}
	/* 이렇게 이제 안함..
	public MainServiceImpl(MainBiz mainBiz) {
		this.mainBiz = new MainBizImpl();
	}*/
	public MainServiceImpl(){
		System.out.println("스프링에서 객체를 생성함");
	}
	@Override
	public void printMessage() {
		System.out.println("스프링으로 만든 객체입니다...");
		mainBiz.printBizMessage();
		
	}

}
