package com.ktds.ehm;

public class TrainReservationMain {
	public void start() {

		TrainReservation trainReservation = new TrainReservation();
		trainReservation.selectMenu();
		//trainReservation.showSeatStatus();

	}

	public static void main(String[] args) {
		new TrainReservationMain().start();
	}
}
