package com.ktds.ehm;

public class OilBank {

	private int oilStock;
	private int pricePerLiter;
	private int budget;

	public int getOilStock() {
		return oilStock;
	}

	public void setOilStock(int oilStock) {
		this.oilStock = oilStock;
	}

	public int getPricePerLiter() {
		return pricePerLiter;
	}

	public void setPricePerLiter(int pricePerLiter) {
		this.pricePerLiter = pricePerLiter;
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public void filling( Car car) {
		this.oilStock -= car.getOilTankVolumn();
		
		System.out.println(this);
		
		car.fillOil(this);
		this.budget += (pricePerLiter * car.getOilTankVolumn());
	}

}
