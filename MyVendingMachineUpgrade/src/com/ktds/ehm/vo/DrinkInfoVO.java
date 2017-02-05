package com.ktds.ehm.vo;

public class DrinkInfoVO {

	private String drinkName;
	private int drinkPrice;
	private int drinkBuyerStock;
	private int drinkSellerStock;
	public DrinkInfoVO(String drinkName, int drinkPrice, int drinkBuyerStock, int drinkSellerStock) {
		
		this.drinkName = drinkName;
		this.drinkPrice = drinkPrice;
		this.drinkBuyerStock = drinkBuyerStock;
		this.drinkSellerStock = drinkSellerStock;
	}
	public String getDrinkName() {
		return drinkName;
	}
	public void setDrinkName(String drinkName) {
		this.drinkName = drinkName;
	}
	public int getDrinkPrice() {
		return drinkPrice;
	}
	public void setDrinkPrice(int drinkPrice) {
		this.drinkPrice = drinkPrice;
	}
	public int getDrinkBuyerStock() {
		return drinkBuyerStock;
	}
	public void setDrinkBuyerStock(int drinkBuyerStock) {
		this.drinkBuyerStock = drinkBuyerStock;
	}
	public int getDrinkSellerStock() {
		return drinkSellerStock;
	}
	public void setDrinkSellerStock(int drinkSellerStock) {
		this.drinkSellerStock = drinkSellerStock;
	}

	
}