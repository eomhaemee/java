package com.ktds.ehm.seller;

import com.ktds.ehm.buyer.Buyer;

public class Seller {
	
	/**
	 * 상품가격
	 */
	private final int PRICE = 500;
	private int money;
	private int itemCnt;
	
	public Seller(int itemCnt,int money){
		setItemCnt(itemCnt);
		setMoney(money);
		System.out.println(this);
	}
	public int getMoney(){
		return this.money;
	}
	public int getItemCnt(){
		return this.itemCnt;
	}
	public void setMoney(int money){
		this.money = money;
	}
	public void setItemCnt(int itemCnt){
		this.itemCnt = itemCnt;
	}
	
	public void sell(Buyer buyer){
		
		buyer.pay(PRICE);
		
		this.money += PRICE;
		
		this.itemCnt--;
		
	}
	public boolean isSoldOut(){
		boolean isSoldOut = this.itemCnt == 0;
		return isSoldOut;
	}
	public String toString(){
		String message = String.format("판매자의 남은과일 %d\n잔금: %d\n", this.itemCnt,this.money);
		return message;
	}
}
