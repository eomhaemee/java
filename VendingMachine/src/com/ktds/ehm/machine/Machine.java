package com.ktds.ehm.machine;

import java.util.Arrays;

public class Machine {
	private int money;
	private String[] itemList;
	
	public Machine(int money, String[] itemList) {		
		this.money = money;
		this.itemList = itemList;
		System.out.println(this);
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String[] getItemList() {
		return itemList;
	}
	public void setItemList(String[] itemList) {
		this.itemList = itemList;
	}
	@Override
	public String toString() {
		return "Machine [money=" + money + ", itemList=" + Arrays.toString(itemList) + "]";
	}
	public void sell(){
		
	}
	
	
}
