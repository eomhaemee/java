package com.ktds.ehm;

import com.ktds.ehm.guest.Guest;
import com.ktds.ehm.machine.Machine;

public class VendingMachine {
	public void start() {

		Guest guest = new Guest(1000);
		Machine machine = new Machine(20000);

		guest.buy(machine);
		System.out.println("=================");
		System.out.println(guest);
		System.out.println(machine);

	}

	public static void main(String[] args) {
		new VendingMachine().start();
	}
}
