package com.ktds.ehm.vo;

public class UserInfoVO {
	
	private int sellerMoney;

	private int buyerMoney;

	public UserInfoVO(int inputMoney) {
	
		//this.sellerMoney = 0;
		this.buyerMoney = inputMoney;
	}

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
	
}
