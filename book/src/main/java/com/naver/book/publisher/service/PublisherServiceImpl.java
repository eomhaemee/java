package com.naver.book.publisher.service;

import com.naver.book.publisher.biz.PublisherBiz;
import com.naver.book.publisher.vo.PublisherListVO;
import com.naver.book.publisher.vo.PublisherSearchVO;
import com.naver.book.publisher.vo.PublisherVO;

public class PublisherServiceImpl implements PublisherService {
	private PublisherBiz publisherBiz;
	
	public void setPublisherBiz(PublisherBiz publisherBiz) {
		this.publisherBiz = publisherBiz;
	}

	@Override
	public boolean addNewPublisher(PublisherVO publisherVO) {
		// TODO Auto-generated method stub
		return publisherBiz.addNewPublisher(publisherVO);
	}

	@Override
	public PublisherListVO getAllPublisher(PublisherSearchVO publisherSearchVO) {
		// TODO Auto-generated method stub
		return publisherBiz.getAllPublisher(publisherSearchVO);
	}
}
