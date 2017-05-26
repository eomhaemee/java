package com.ktds.ehm.web;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

/*	AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");*/
	
	/*MySpringServices mySpringServices=ctx.getBean("mySpringServicesImpl",MySpringServices.class);*/
	
/*	MainService mainService = ctx.getBean("mainServiceImpl",MainService.class);
	mainService.printMessage();*/
	
	@RequestMapping("/test")
	public String testPage(){
		return "mytest";
	}
	
	@RequestMapping("/test2")
	public String test2Page(){
		return "mytest2";
	}
	
	@RequestMapping("/test3")
	public String test3Page(){
		return "mytest3";
	}
	

}
