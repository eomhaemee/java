package com.naver.book.book.service;

import java.util.HashMap;
import java.util.Map;

import com.naver.book.author.biz.AuthorBiz;
import com.naver.book.author.vo.AuthorListVO;
import com.naver.book.author.vo.AuthorSearchVO;
import com.naver.book.book.vo.BookVO;
import com.naver.book.publisher.biz.PublisherBiz;
import com.naver.book.publisher.vo.PublisherListVO;
import com.naver.book.publisher.vo.PublisherSearchVO;

public class BookServiceImpl implements BookService {
	private AuthorBiz authorBiz;
	private PublisherBiz publisherBiz;
	
	
	public void setAuthorBiz(AuthorBiz authorBiz) {
		this.authorBiz = authorBiz;
	}
	
	public void setPublisherBiz(PublisherBiz publisherBiz) {
		this.publisherBiz = publisherBiz;
	}

	@Override
	public Map<String, Object> getAllAuthorAndPublisher() {

		PublisherSearchVO publisherSearchVO = new PublisherSearchVO();
		publisherSearchVO.setUsePageing(false);
		
		AuthorSearchVO authorSearchVO = new AuthorSearchVO();		
		authorSearchVO.setUsePageing(false);
		
		PublisherListVO publisherList =  publisherBiz.getAllPublisher(publisherSearchVO);
		AuthorListVO authorList = authorBiz.getAllAuthor(authorSearchVO);
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		map.put("author" , authorList);
		map.put("publisher" , publisherList);
		
		return  map;		
	}

	@Override
	public BookVO getAllAuthorAndPublisherUseBookVO() {
		PublisherSearchVO publisherSearchVO = new PublisherSearchVO();
		publisherSearchVO.setUsePageing(false);
		
		AuthorSearchVO authorSearchVO = new AuthorSearchVO();		
		authorSearchVO.setUsePageing(false);
		
		PublisherListVO publisherList =  publisherBiz.getAllPublisher(publisherSearchVO);
		AuthorListVO authorList = authorBiz.getAllAuthor(authorSearchVO);
		
		BookVO bookVO = new BookVO();
		
//		bookVO.setAuthorList(authorListVO.getAuthorList());
//		bookVO.setPublisherList(authorListVO);
		return bookVO;
	}

	
	
	
	
}
