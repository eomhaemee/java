package com.naver.book.book.service;

import java.util.Map;

import com.naver.book.book.vo.BookVO;

public interface BookService {
	public Map<String, Object> getAllAuthorAndPublisher();
	public BookVO getAllAuthorAndPublisherUseBookVO();
	
}
