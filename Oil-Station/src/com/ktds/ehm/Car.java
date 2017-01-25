package com.ktds.ehm;

public class Car {

	private String modelName;
	private int oilTankVolumn;
	private int oilStock;
	private int money;
	
	public Car(String modelName, int oilTankVolumn,  int money) {
		super();
		this.modelName = modelName;
		this.oilTankVolumn = oilTankVolumn;
		this.money = money;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public int getOilTankVolumn() {
		return oilTankVolumn;
	}

	public void setOilTankVolumn(int oilTankVolumn) {
		this.oilTankVolumn = oilTankVolumn;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getOilStock() {
		return oilStock;
	}

	public void setOilStock(int oilStock) {
		this.oilStock = oilStock;
	}

	public void fillOil(OilBank oilBank){
		this.oilStock = oilTankVolumn;
		this.money -= (oilBank.getPricePerLiter() * (oilTankVolumn - this.oilStock));
		
	}

}
