package com.naver.book.author.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.naver.book.author.service.AuthorService;
import com.naver.book.author.vo.AuthorListVO;
import com.naver.book.author.vo.AuthorSearchVO;
import com.naver.book.author.vo.AuthorVO;
import com.naver.book.common.web.ListPageExplorer;
import com.naver.book.common.web.PageExplorer;

@Controller
public class AuthorController {
	
	public AuthorService authorService;
	
	public void setAuthorService(AuthorService authorService) {
		this.authorService = authorService;
	}
	
	@RequestMapping(value="/auth/write",method=RequestMethod.GET)
	public String viewWritePage(){
		return "auth/write";
	}
	@RequestMapping(value="/auth/write", method=RequestMethod.POST)
	public String doWriteAuthor(AuthorVO authorVO){
		
		String introduce = authorVO.getIntro();
		introduce = introduce.replace("\n", "<br/>");
		introduce = introduce.replace("\r", "");
		authorVO.setIntro(introduce);
		
		boolean isSuccess = authorService.addNewAuthor(authorVO);
		return "redirect:/auth/list";
	}
	@RequestMapping("/auth/list")
	public ModelAndView viewListPage(AuthorSearchVO authorSearchVO){
		AuthorListVO authorListVO = authorService.getAllAuthor(authorSearchVO);
		ModelAndView view = new ModelAndView();
		
		PageExplorer pager = new ListPageExplorer(authorListVO.getPager());
		
		view.setViewName("auth/list");
		view.addObject("authorListVO",authorListVO);
		view.addObject("pager",pager);
		return view;
	}
	
	
}
