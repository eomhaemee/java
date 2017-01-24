package com.ktds.ehm.seller;

import com.ktds.ehm.buyer.Buyer;

public class Seller {
	/**
	 * 상품가격
	 */
	private final int PRICE = 2500;
	/**
	 * 판매자가 가진금액
	 */
	private int money;
	/**
	 * 판매자가 가진 상품의 개수
	 */
	private int productQuantity;

	public Seller(int productQuantity,int money){
		System.out.println("판매자를 생성합니다.");
		
		setMoney(money);
		setProductQuantity(productQuantity);
		
		System.out.println(this);
	}
	
	public void setMoney(int money){
		this.money =  money;
	}
	public void setProductQuantity(int productQuantity){
		this.productQuantity = productQuantity;
	}
	public int getMoney(){
		return this.money;
	}
	public int getProductQuantity(){
		return this.productQuantity;
	}
	
	/**
	 * 판매하기
	 */
	public void sell(Buyer buyer) {
		// 판매자가 가진 상품의 개수에서 하나를 뺸다.
		this.productQuantity--;

		//구매자는 돈을 지불한다.
		buyer.pay(PRICE);
		
		// 판매자가 가진 금액에서 상품의 가격만큼 더한다.
		this.money += 2500;
	}

	/**
	 * 재고파악하기
	 * 
	 * @return : boolean 재고가 있으면 flase, 있으면 true
	 */
	public boolean isSoldOut() {
		boolean isSoldOut = this.productQuantity == 0;
		return isSoldOut;
	}

	/**
	 * 판매자 현황 파악하기
	 */
	@Override
	public String toString() {
		String message = String.format("판매자의 상품 개수:%d, 판매자가 가진금액: %d", this.productQuantity, this.money);
		return message;
	}

}
