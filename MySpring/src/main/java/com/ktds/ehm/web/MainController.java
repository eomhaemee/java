package com.ktds.ehm.web;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ktds.ehm.service.MySpringService;

public class MainController {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");

		MySpringService myService = ctx.getBean("mySpringServiceImpl", MySpringService.class);
		myService.printServiceMessage();

	}
}
