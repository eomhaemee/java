package com.ktds.ehm;

public class Guest {

	private int rentCnt;
	private int myMoney;

	public Guest(int rentCnt, int myMoney) {

		this.rentCnt = rentCnt;
		this.myMoney = myMoney;
	}

	public int getRentCnt() {
		return rentCnt;
	}

	public void setRentCnt(int rentCnt) {
		this.rentCnt = rentCnt;
	}

	public int getMyMoney() {
		return myMoney;
	}

	public void setMyMoney(int myMoney) {
		this.myMoney = myMoney;
	}

	public void borrow(BicycleRentalShop bicycleRentalShop, int cost) {
		this.rentCnt++;
		this.myMoney -= cost;
	}

	@Override
	public String toString() {
		String message = ("===================\n대여자 현황\n-------------------\n");
		message += String.format("자전거 보유수: %d 대\n보유금액 : %d \n", this.rentCnt, this.myMoney);
		message += ("===================\n");
		
		return message;
	}

}
