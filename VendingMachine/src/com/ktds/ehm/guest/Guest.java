package com.ktds.ehm.guest;

import com.ktds.ehm.machine.Machine;

public class Guest {
	private int money;
	private String itemName;

	public Guest(int money) {
		this.money = money;
	}
	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void buy(Machine machine) {
		machine.selectAndPrintItem(this);
	}

	public void pay(int selectedItemPrice) {
		this.money -= money;
		
	}
	@Override
	public String toString() {
		return "구매자의 잔금 >> " + money;

	}


}
