package com.ktds.ehm;

//buyer와 store는 다른 package에 있으므로 import해야함
import com.ktds.ehm.buyer.Buyer;
import com.ktds.ehm.seller.Seller;

public class Store {

	public void start(){
		
		Buyer buyer = new Buyer(0, 5000);
		Seller seller = new Seller(500, 5000);
		
		buyer.buy(seller);
		
		System.out.println(buyer);
		System.out.println(seller);
		/*
		Buyer buyer1 = new Buyer(0, 500);
		//buyer1 buyer2 는 같은 주소를 가리킴
		Buyer buyer2 = buyer1;
		//Buyer buyer2 = new Buyer(0, 400);
		
		buyer1.buy();
		
		System.out.println(buyer1);
		System.out.println(buyer2);
		
		
		System.out.println("장터에 오신것을 환영합니다.");
		Buyer buyer = new Buyer(0, 100000);
		Seller seller = new Seller(100, 10000);
		
		System.out.println("바이어씨 상품좀 살게요");
		seller.sell();
		buyer.buy();
		
		System.out.println("셀러: 2500 입니다.");
		buyer.pay(2500);
		
		System.out.println(buyer);
		System.out.println(seller);
		*/
		
	}

	
	public static void main(String[] args){
		
		//객체 만들어 start()호출
		new Store().start();
	
		
		
		
		/*Buyer ehm = new Buyer(0, 100000);
		
		ehm.buy();
		ehm.pay(2000);
		
		//String status = String.valueOf(ehm);
		System.out.println(ehm);
		
		System.out.println("==============");
		
		Seller osh = new Seller(100, 10000);
		
		osh.sell();
		boolean isSoldOut = osh.isSoldOut();
		System.out.println(isSoldOut);
		System.out.println(osh);*/
		
		
		
	}
}
