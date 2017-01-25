package com.ktds.ehm.machine;

import java.util.Scanner;

import com.ktds.ehm.guest.Guest;

public class Machine {
	/**
	 * 판매총금액
	 */
	private int totMoney;
	/**
	 * 선택된 Item정보
	 */
	private int selectedItem;
	private String selectedItemName;
	private int selectedItemPrice;
	/**
	 * 상품list {상품명,가격,잔고}
	 */
	private String[][] products = { { "콜라", "100", "2" }, { "사이다", "200", "3" }, { "환타", "300", "4" } };

	public Machine(int money) {
		setTotMoney(money);
	}
	
	public int getTotMoney() {
		return totMoney;
	}

	public void setTotMoney(int totMoney) {
		this.totMoney = totMoney;
	}

	public int getSelectedItem() {
		return selectedItem;
	}

	public void setSelectedItem(int selectedItem) {
		this.selectedItem = selectedItem;
	}

	public String[][] getProducts() {
		return products;
	}

	public void setProducts(String[][] products) {
		this.products = products;
	}

	public int getSelectedItemPrice() {
		return selectedItemPrice;
	}

	public void setSelectedItemPrice(int selectedItemPrice) {
		this.selectedItemPrice = selectedItemPrice;
	}

	public String getSelectedItemName() {
		return selectedItemName;
	}

	public void setSelectedItemName(String selectedItemName) {
		this.selectedItemName = selectedItemName;
	}

	public void selectAndPrintItem(Guest guest) {
		System.out.println("0.콜라 1.사이다,2.환타를 구매할 숫자를 선택하세요");
		Scanner input = new Scanner(System.in);

		setSelectedItem(input.nextInt());
		setSelectedItemName(products[selectedItem][0]);
		setSelectedItemPrice(Integer.parseInt(products[selectedItem][1]));

		System.out.printf("선택한음료는[%s] 금액 [%d원] 입니다.\n", selectedItemName, selectedItemPrice);

		sell(selectedItem, selectedItemPrice, guest);
	}

	public void sell(int selectedItem, int selectedItemPrice, Guest guest) {

		int cnt = Integer.parseInt(this.products[selectedItem][2]) - 1;
		this.products[selectedItem][2] = String.valueOf(cnt);

		this.totMoney += selectedItemPrice;
		guest.pay(selectedItemPrice);

	}

	@Override
	public String toString() {
		return "[" + selectedItemName + "] 재고수량: " + this.products[selectedItem][2] + ",  판매누적금 >> " + this.totMoney;
	}

}
