package com.ktds.ehm.book.vo;

import com.ktds.ehm.dao.support.annotation.Types;

public class BookVO {
	@Types
	private int bkId;
	@Types
	private String bkNm;
	@Types
	private String bkCntntIdx;
	@Types
	private String wrtr;
	@Types
	private String pblshr;
	@Types
	private int price;
	@Types
	private String pblshingDate;
	@Types
	private String review;
	
	
	public int getBkId() {
		return bkId;
	}
	public void setBkId(int bkId) {
		this.bkId = bkId;
	}
	public String getBkNm() {
		return bkNm;
	}
	public void setBkNm(String bkNm) {
		this.bkNm = bkNm;
	}
	public String getBkCntntIdx() {
		return bkCntntIdx;
	}
	public void setBkCntntIdx(String bkCntntIdx) {
		this.bkCntntIdx = bkCntntIdx;
	}
	public String getWrtr() {
		return wrtr;
	}
	public void setWrtr(String wrtr) {
		this.wrtr = wrtr;
	}
	public String getPblshr() {
		return pblshr;
	}
	public void setPblshr(String pblshr) {
		this.pblshr = pblshr;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPblshingDate() {
		return pblshingDate;
	}
	public void setPblshingDate(String pblshingDate) {
		this.pblshingDate = pblshingDate;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	

}
