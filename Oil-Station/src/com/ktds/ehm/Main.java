package com.ktds.ehm;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Main {

	public void start() {
		OilBank oilBank = new OilBank();

		oilBank.setOilStock(5000);
		oilBank.setPricePerLiter(1480);
		oilBank.setBudget(0);

		Car car = new Car("무쏘", 50, 10000000);
		
		System.out.println(oilBank);
		oilBank.filling( car);

		System.out.println("===주유소==========");
		System.out.println(oilBank.getOilStock());
		System.out.println(oilBank.getBudget());
		
		System.out.println("===자동차==========");
		System.out.println(car.getModelName());
		System.out.println(car.getOilTankVolumn());
		System.out.println(car.getMoney());
	}

	public static void main(String[] args) {
		new Main().start();
	}
}
