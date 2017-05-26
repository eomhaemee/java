package com.ktds.ehm.user.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ktds.ehm.user.service.UserService;
import com.ktds.ehm.user.vo.UsersVO;

@Controller
public class UserController {
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value="/user/signUp",method=RequestMethod.GET)
	public String viewSignUpPage(){
		return "user/signUp";
	}
	@RequestMapping(value="/user/signUp",method=RequestMethod.POST)
	public String doSignUpAction(UsersVO usersVO){
		logger.info("UserId" + usersVO.getUserId());
		
		boolean isSuccess = userService.insertUsers(usersVO);
		logger.info("회원가입" + isSuccess);
		
		String returnUrl;
		if ( isSuccess ) {
			returnUrl = "redirect:/board/list";
		}
		else{
			returnUrl = "redirect:/user/signUp";
		}
		return returnUrl;
	}
	@RequestMapping(value="/user/signIn",method=RequestMethod.GET)
	public String viewSignInPage(){
		return "user/signIn";
	}
	@RequestMapping(value="/user/signIn",method=RequestMethod.POST)
	public String doSignInActtion(UsersVO usersVO,HttpServletRequest request){
		UsersVO userVO = userService.selectOneUsers(usersVO);
		
		String returnUrl;
		if ( userVO == null ){
			returnUrl = "redirect:/user/signIn";
		}
		else{
			HttpSession session = request.getSession();
			session.setAttribute("_USER_", userVO);
			
			returnUrl = "redirect:/board/list";
		}
		
		return returnUrl;
	}
}
