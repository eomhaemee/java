package com.ktds.ehm.web;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ktds.ehm.service.MainService;

public class MainController {
	public static void main(String[] args){
		
		/*applicationContext.xml파일을 가져와서 bean을 만드는 역할 자동화 하는 방법이 있데..*/
		AbstractApplicationContext ctx = 
					new ClassPathXmlApplicationContext("/applicationContext.xml");
		
		//객체를 new로 만들지 않고 가져다쓰자
		//MainService mainService = new MainServiceImpl(); 
		
		//가져올때 MainService.class type으로 가져오도록함 캐스팅
		MainService mainService = ctx.getBean("mainServiceImpl",MainService.class);
		mainService.printMessage();
	}
}
