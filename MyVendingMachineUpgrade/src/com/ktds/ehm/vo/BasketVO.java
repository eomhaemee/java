package com.ktds.ehm.vo;

import java.util.List;

public class BasketVO {

	private int sellerMoney;

	private int buyerMoney;

	//	
	private int[] sellerItemCnt;
	private int[] buyerItemCnt;

	
	public int getSellerMoney() {
		return sellerMoney;
	}

	public void setSellerMoney(int sellerMoney) {
		this.sellerMoney = sellerMoney;
	}

	public int getBuyerMoney() {
		return buyerMoney;
	}

	public void setBuyerMoney(int buyerMoney) {
		this.buyerMoney = buyerMoney;
	}

	public int[] getSellerItemCnt() {
		return sellerItemCnt;
	}

	public void setSellerItemCnt(int[] sellerItemCnt) {
		this.sellerItemCnt = sellerItemCnt;
	}

	public int[] getBuyerItemCnt() {
		return buyerItemCnt;
	}

	public void setBuyerItemCnt(int[] buyerItemCnt) {
		this.buyerItemCnt = buyerItemCnt;
	}


	
}
