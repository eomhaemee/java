package com.ktds.ehm.buyer;

import com.ktds.ehm.seller.Seller;

public class Buyer {

	private int money;
	private int itemCnt;
	
	/**
	 * 샏성자
	 */
	public Buyer(int itemCnt,int money){
		setItemCnt(itemCnt);
		setMoney(money);
		System.out.println(this);
	}
	/**
	 * getter,setter
	 */
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
	/**
	 * 구매하면 item의 수를 증가시킨다.
	 */
	public void buy(Seller seller){
		seller.sell(this);
		this.itemCnt++;
	}
	/**
	 * 지불한다. 내돈을 감소시킨다.
	 * @param 지불금액
	 */
	public void pay(int money){
		this.money-=money;
	}
	@Override
	public String toString(){
		String message = String.format("구매자가 구매한 과일의수:%d\n 잔돈:%d\n",this.itemCnt,this.money);
	  //String message = String.format("구매한 상품 갯수:%d\n 구매자가 가진 금액: %d\n", this.itemCnt,this.money);
		return message;
	}
	
}
