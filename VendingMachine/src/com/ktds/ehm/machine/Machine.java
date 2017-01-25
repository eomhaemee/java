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
	
	public void sell(Guest guest){

		while(true){
			//메뉴를 보여줌
			System.out.println("0.콜라 1.사이다,2.환타, 4.종료 구매할 숫자를 선택하세요");
			//아이템선텍
			setSelectedItem(guest.selectMenu());
			
			if (this.selectedItem == 4) {
				System.out.println("구매를 종료합니다.");
				break;
			}else if (this.products[selectedItem][2] == "0"){
				System.out.println("수량이 없습니다.");
			}else if (guest.getMoney()==0) {
				System.out.println("잔돈이없습니다.");
			} else {
				setSelectedItemName(products[selectedItem][0]);
				setSelectedItemPrice(Integer.parseInt(products[selectedItem][1]));

				System.out.printf("선택한음료는[%s] 금액 [%d원] 입니다.\n", selectedItemName, selectedItemPrice);
				
				int cnt = Integer.parseInt(this.products[selectedItem][2]) - 1;
				this.products[selectedItem][2] = String.valueOf(cnt);

				this.totMoney += selectedItemPrice;
				
				/*
				System.out.println("---------------------------------");
				menu = String.format("1. 콜라(%d원) : %d개  |  2. 사이다(%d원) : %d개  |  3. 환타(%d원) : %d개  |  4. 구매 종료", COKE_PRICE, cokeStock,
						CYDER_PRICE, cyderStock, FANTA_PRICE, fantaStock);
				System.out.println(menu);
				System.out.println("---------------------------------");System.out.println("---------------------------------");
				menu = String.format("1. 콜라(%d원) : %d개  |  2. 사이다(%d원) : %d개  |  3. 환타(%d원) : %d개  |  4. 구매 종료", COKE_PRICE, cokeStock,
						CYDER_PRICE, cyderStock, FANTA_PRICE, fantaStock);
				System.out.println(menu);
				System.out.println("---------------------------------");
				*/
				
				guest.pay(selectedItemPrice);
			}
			
			
			
		}
		
	}
	
	@Override
	public String toString() {
		return "[" + selectedItemName + "] 재고수량: " + this.products[selectedItem][2] + ",  판매누적금 >> " + this.totMoney;
	}

}
