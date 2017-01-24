package com.ktds.ehm.buyer;

import com.ktds.ehm.seller.Seller;

/**
 * Seller에게 상품을 구매하고 금액을 Seller에게 지불한다.
 * @author Admin
 *
 */
public class Buyer {
	/**
	 * 상품갯수
	 */
	private int productQuantity;
	
	/**
	 * 구매자가 가진 금액
	 */
	private int money;
	
	/**
	 * 생성자
	 * @param productQuantity
	 */
	public Buyer(int productQuantity,int money){
		System.out.println("구매자를 생성합니다.");
		//초기값 세팅
		setProductQuantity(productQuantity);
		setMoney(money);
		
		//현황 출력하기
		//this : 이부분을 호출한 주체 (buyer객체)
		//toString이 오버라이딩 되어 있으므로 println으로 아래 부분이 호출
		//this 하면 자동으로 toString 호출
		
		System.out.println(this);
	}
	
	public void setProductQuantity(int productQuantity){
		this.productQuantity = productQuantity;
	}
	public void setMoney(int money){
		this.money = money;
	}
	public int getProductQuantity(){
		return this.productQuantity;
	}
	public int getMoney(){
		return this.money;
	}
	/**
	 * 구매하기
	 * 구매자가 가진 상품갯수에 1 더해준다.
	 */
	public void buy(Seller seller){
		seller.sell(this);
		
		this.productQuantity++;
	}
	/**
	 * 지불하기
	 * 구매자가 가진 돈에서 지불할 돈을 뺀다
	 * @param 지불할 금액
	 */
	public void pay(int money){
		this.money -= money;
	}
	
	/**
	 * 구매자 현황 파악하기
	 */
	@Override
	public String toString(){
		
		String message = 
				String.format("구매한 상품 갯수:%d\n 구매자가 가진 금액: %d\n", this.productQuantity,this.money);
		return message;
	}

}
