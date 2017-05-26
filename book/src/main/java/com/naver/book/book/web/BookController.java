package com.naver.book.book.web;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.naver.book.author.vo.AuthorListVO;
import com.naver.book.book.service.BookService;
import com.naver.book.book.vo.BookVO;
import com.naver.book.publisher.vo.PublisherListVO;

@Controller
public class BookController {
	private BookService bookService;
	
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	
//	@RequestMapping(value="/book/write",method=RequestMethod.GET)
//	public String viewWriteBookPage(){
//		return "book/write";
//	}
	
	@RequestMapping(value="/book/write",method=RequestMethod.GET)
	public ModelAndView viewListPage(){
		Map<String,Object> authorAndPublisher = bookService.getAllAuthorAndPublisher();
		
		PublisherListVO publisherListVO = (PublisherListVO) authorAndPublisher.get("publisher");
		AuthorListVO authorListVO = (AuthorListVO) authorAndPublisher.get("author");
		
		BookVO bookVO = bookService.getAllAuthorAndPublisherUseBookVO();
		
		ModelAndView view = new ModelAndView();
		view.setViewName("book/write");
		view.addObject("author",authorListVO);
		view.addObject("publisher",publisherListVO);
		view.addObject("bookVO",bookVO);
		return view;
	}
	
}
