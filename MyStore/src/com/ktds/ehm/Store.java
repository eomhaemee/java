package com.ktds.ehm;

import com.ktds.ehm.buyer.Buyer;
import com.ktds.ehm.seller.Seller;

public class Store {

	public void start() {

		// Buyer buyer = new Buyer(0, 5000);
		// Seller seller = new Seller(500, 5000);

		BuyerInterface buyer = new Buyer(0, 5000);
		SellerInterface seller = new Seller(500, 5000);

		buyer.buy(seller);

		System.out.println(buyer);
		System.out.println(seller);

	}

	public static void main(String[] args) {

		new Store().start();

	}
}
