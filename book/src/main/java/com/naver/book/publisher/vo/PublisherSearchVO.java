package com.naver.book.publisher.vo;

public class PublisherSearchVO {
	
	private int pageNo;
	private int endArticleNumber;
	private int startArticleNumber;
	private boolean isUsePageing;
	
	
	public PublisherSearchVO() {
		this.isUsePageing = true;
	}
	
	
	public boolean getIsUsePageing() {
		return isUsePageing;
	}


	public void setUsePageing(boolean isUsePageing) {
		this.isUsePageing = isUsePageing;
	}


	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getEndArticleNumber() {
		return endArticleNumber;
	}
	public void setEndArticleNumber(int endArticleNumber) {
		this.endArticleNumber = endArticleNumber;
	}
	public int getStartArticleNumber() {
		return startArticleNumber;
	}
	public void setStartArticleNumber(int startArticleNumber) {
		this.startArticleNumber = startArticleNumber;
	}
	
	
	
}
