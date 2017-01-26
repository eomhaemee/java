package com.ktds.ehm.guest;

import java.util.Scanner;

public class Guest {

	private int guestMoney;
	private int kimbapStock;
	private int ramenStock;

	
	
	public Guest(int guestMoney) {
		this.guestMoney = guestMoney;
	}

	public int getGuestMoney() {
		return guestMoney;
	}

	public void setGuestMoney(int guestMoney) {
		this.guestMoney = guestMoney;
	}

	public int getKimbapStock() {
		return kimbapStock;
	}

	public void setKimbapStock(int kimbapStock) {
		this.kimbapStock = kimbapStock;
	}

	public int getRamenStock() {
		return ramenStock;
	}

	public void setRamenStock(int ramenStock) {
		this.ramenStock = ramenStock;
	}

	public int selectMenu() {
		Scanner input = new Scanner(System.in);
		int selectedMenu = input.nextInt();
		return selectedMenu;

	}

	public void takeFood(int selectedMenu) {
		if ( selectedMenu == 1 ) {
			kimbapStock++;
		}
		else if ( selectedMenu == 2 ) {
			ramenStock++;
		}
	
	}
	
	public void remainMoney(int clcMoney) {
		this.guestMoney -= clcMoney;
	}

	
	@Override
	public String toString() {
		String message = "===========================================================";
		message += "\n	주문내역[고객용]";
		message += "\n----------------------------------------------------------";
		message += String.format("\n	1. 김밥(%d개)   |  2. 라면(%d개) |  잔돈: %d \n ", kimbapStock, ramenStock, guestMoney);
		message += "\n===========================================================";
		return message;
	}

}

