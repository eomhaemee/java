package com.naver.cafe.user.web;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.naver.cafe.common.Session;
import com.naver.cafe.common.util.SendMessage;
import com.naver.cafe.user.service.UserService;
import com.naver.cafe.user.vo.UsersVO;

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
	
	@RequestMapping(value="/user/signUp", method=RequestMethod.POST)
	public void doSignUpAction(@Valid @ModelAttribute("signUpForm") UsersVO usersVO,Errors errors,HttpServletResponse response){
		
		//logger.info(usersVO.getUserId() +" : "+ usersVO.getUserPassword());
		
		String returnUrl;
		if( errors.hasErrors()){
			SendMessage.send(response, "FAIL_COL");
			//returnUrl = "user/signUp";
		}else{

			try {
				//패스워드 정책
				boolean isValidPassword = verify(usersVO.getUserPassword());
				
				if (isValidPassword) {
					boolean isInsertSuccess = userService.insertUsers(usersVO);	
					
					logger.info("isValidPassword : " + isValidPassword + 
								"isInsertSuccess : " + isInsertSuccess + 
							usersVO.getUserId() +" : "+ usersVO.getUserPassword());
					
					if ( isInsertSuccess ) {
						//returnUrl = "redirect:/board";
						SendMessage.send(response, "OK");
					}else{
						//returnUrl = "redirect:/user/signUp";
						SendMessage.send(response, "FAIL");
					}
				} else {
					//returnUrl = "redirect:/user/signUp";
					SendMessage.send(response, "PWFAIL");
				}
			} catch (RuntimeException e) {
				SendMessage.send(response, usersVO.getUserId() + "은(는) 이미 등록된 아이디 입니다.");
				throw new RuntimeException(e.getMessage(),e);
			}

		}
		//return returnUrl;	
	}

	public boolean verify(String password) {
		String passwordPolicy = "((?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[^a-zA-Z0-9가-힣]).{8,})";
		Pattern pattern = Pattern.compile(passwordPolicy);
		Matcher matcher = pattern.matcher(password);
		return matcher.matches();
	}
	
	@RequestMapping(value="/user/signIn",method=RequestMethod.GET)
	public String viewSignInPage(){
		return "user/signIn";
	}
	@RequestMapping(value="/user/signIn", method=RequestMethod.POST)
	public String doSignInAction(UsersVO usersVO,HttpServletRequest request){
		UsersVO userVO = userService.selectOneUsers(usersVO);
		
		logger.info(usersVO.getUserId());
		
		if ( userVO == null ){
			return "redirect:/user/signIn";
		}
		else{
			HttpSession session = request.getSession();
			session.setAttribute(Session.MEMBER, userVO);
			
			logger.info("Session.MEMBER : " 
					+ ((UsersVO) session.getAttribute(Session.MEMBER)).getUserId());
			
			//session.setAttribute("_USER_", userVO);
			
			String token = UUID.randomUUID().toString();
			session.setAttribute(Session.CSRF_TOKEN, token);
			return "redirect:/club/MN-2017041813-000008";
		}
		
	}
	@RequestMapping("user/logout")
	public String doLogoutAction(HttpSession session){
		session.invalidate();
		return "redirect:/user/signIn";
	}

}
