package com.ktds.ehm;

import com.ktds.ehm.StoreOwner.StoreOwner;
import com.ktds.ehm.guest.Guest;

public class KimbopSore {
	public void start() {
	
		StoreOwner storeOwner = new StoreOwner();
		Guest guest = new Guest(5000);
		
		storeOwner.sell(guest);
		System.out.println(storeOwner);
		System.out.println(guest);
	}
	
	public static void main(String[] args) {
		new KimbopSore().start();
		
	}
}
