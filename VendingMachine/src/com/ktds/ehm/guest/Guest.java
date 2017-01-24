package com.ktds.ehm.guest;

import com.ktds.ehm.machine.Machine;


public class Guest {
	private int money;
	private int itemNo;
	
	/*public Guest(int money, int item){
		this.money = money;
		this.item = item;
		System.out.println(this);
	}*/


	public int getMoney() {
		return money;
	}


	public void setMoney(int money) {
		this.money = money;
	}

	public int getItemNo() {
		return itemNo;
	}

	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	
	public void buy(int money,int itemNo){
		this.money -= money;
	}
	
	@Override
	public String toString() {
		return "Guest [money=" + money + ", itemNo=" + itemNo + "]";
	}


}
