package com.ktds.ehm;

import com.ktds.ehm.StoreOwner.StoreOwner;
import com.ktds.ehm.guest.Guest;

public class GimbopSore {
	public void start() {
	
		StoreOwner storeOwner = new StoreOwner();
		Guest guest = new Guest();
		
		storeOwner.sell(guest,10000);
	}
	
	public static void main(String[] args) {
		new GimbopSore().start();
		
	}
}
