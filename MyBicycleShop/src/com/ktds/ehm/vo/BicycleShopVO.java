package com.ktds.ehm.vo;

public class BicycleShopVO {
	private String level;
	private int pricePerTenMin;
	private int bicycleStock;
	

	public BicycleShopVO(String level, int pricePerTenMin, int bicycleStock) {
		
		this.level = level;
		this.pricePerTenMin = pricePerTenMin;
		this.bicycleStock = bicycleStock;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public int getPricePerTenMin() {
		return pricePerTenMin;
	}
	public void setPricePerTenMin(int pricePerTenMin) {
		this.pricePerTenMin = pricePerTenMin;
	}
	public int getBicycleStock() {
		return bicycleStock;
	}
	public void setBicycleStock(int bicycleStock) {
		this.bicycleStock = bicycleStock;
	}
	
	
	
}
