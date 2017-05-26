package com.ktds.spring.ehm;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	/* /라는 URL이 들어오면 아래 주소를 보여줌*/ 
	/* http://localhost:8080/hello_spring/     */	
	/*viewResolver 에 의해 /WEB-INF/view/hello.jsp 가 앞뒤로 붙어서 jsp를 보여줌*/
	@RequestMapping("/") 
	public String viewHelloPage(){
		return "hello";
	}
	/* http://localhost:8080/hello_spring/bye     */	
	@RequestMapping("/bye") 
	public String viewbyePage(){
		return "bye";
	}
	@RequestMapping("/myinfo")
	public ModelAndView viewMyPage(){
		ModelAndView view = new ModelAndView();
		//보여줄 페이지 지정
		view.setViewName("myinfo"); 
		//페이지에 전달할 데이터 세팅
		view.addObject("name","Eom hae mee"); 
		view.addObject("job", "Developer");
		view.addObject("lang", "JAVA");
		view.addObject("dept", "IT부서");
		
		return view;
	}
}
