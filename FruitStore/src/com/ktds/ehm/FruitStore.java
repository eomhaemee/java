package com.ktds.ehm;

import com.ktds.ehm.buyer.Buyer;
import com.ktds.ehm.seller.Seller;

public class FruitStore {
	public void start(){
		
		Buyer buyer = new Buyer(0,1000);
		Seller seller = new Seller(50,2000);
		
		buyer.buy(seller);
		
		//seller.isSoldOut();
		
		System.out.println("=================");
		System.out.println(buyer);
		System.out.println(seller);
		/*
		buyer.buy();
		seller.sell();
		
		System.out.println(buyer);
		System.out.println(seller);
		*/
		
	}
	
	public static void main(String[] args){
		new FruitStore().start();
	}
}
