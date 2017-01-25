package com.ktds.ehm;

public class Main {

	public void start() {

		BicycleRentalShop bicycleRentalShop = new BicycleRentalShop(5, 200000);
		Guest guest = new Guest(0, 10100);

		bicycleRentalShop.rentStart(guest);

		System.out.println(bicycleRentalShop);
		System.out.println(guest);
	}

	public static void main(String[] args) {
		new Main().start();
	}
}
