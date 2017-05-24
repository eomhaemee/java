package com.naver.book.publisher.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.naver.book.common.web.ListPageExplorer;
import com.naver.book.common.web.PageExplorer;
import com.naver.book.publisher.service.PublisherService;
import com.naver.book.publisher.vo.PublisherListVO;
import com.naver.book.publisher.vo.PublisherSearchVO;
import com.naver.book.publisher.vo.PublisherVO;;

@Controller
public class PublisherController {
	
	private PublisherService PublisherService;
	
	public void setPublisherService(PublisherService publisherService) {
		PublisherService = publisherService;
	}
	
	@RequestMapping(value="/pub/write",method=RequestMethod.GET)
	public String viewWritePage(){
		return "pub/write";
	}
	@RequestMapping(value="/pub/write", method=RequestMethod.POST)
	public String doWritePublisher(PublisherVO publisherVO){
		boolean isSuccess = PublisherService.addNewPublisher(publisherVO);
		return "redirect:/pub/list";
	}
	@RequestMapping("/pub/list")
	public ModelAndView viewListPage(PublisherSearchVO publisherSearchVO){
		PublisherListVO publisherListVO = PublisherService.getAllPublisher(publisherSearchVO);
		ModelAndView view = new ModelAndView();
		
		PageExplorer pager = new ListPageExplorer(publisherListVO.getPager());
		
		view.setViewName("pub/list");
		view.addObject("publisherListVO",publisherListVO);
		view.addObject("pager",pager);
		return view;
	}
}
