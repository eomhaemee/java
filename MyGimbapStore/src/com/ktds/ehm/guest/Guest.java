package com.ktds.ehm.guest;

import java.util.Scanner;

public class Guest {

	private int guestMoney;
	private int kimbapStock ;
	private int ramenStock;


	
	
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
	
	public int selectMenu(){
		Scanner input = new Scanner(System.in);
		int selectedMenu = input.nextInt();
		return selectedMenu;
		
	}
	
}
