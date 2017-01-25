package com.ktds.ehm.StoreOwner;

import com.ktds.ehm.guest.Guest;

public class StoreOwner {

	private final int KIMBAP = 1;
	private final int RAMEN = 2;

	private final int KIMBAP_PRICE = 2000;
	private final int RAMEN_PRICE = 3000;

	private int kimbapStock;
	private int ramenStock;

	private int storeBalane;

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

	public int getKIMBAP() {
		return KIMBAP;
	}

	public int getRAMEN() {
		return RAMEN;
	}

	public int getKIMBAP_PRICE() {
		return KIMBAP_PRICE;
	}

	public int getRAMEN_PRICE() {
		return RAMEN_PRICE;
	}

	public int getStoreBalane() {
		return storeBalane;
	}

	public void setStoreBalane(int storeBalane) {
		this.storeBalane = storeBalane;
	}

	public void sell(Guest guest,int guestMoney) {

		String menu = "";
		int selectedMenu = 0;

		System.out.println("--------------------------------------------------");
		menu = String.format("김밥천국 메뉴판(메뉴를 숫자로 입력하세요..)\n 1. 김밥(%d원)   |  2. 라면(%d원) |  999. 주문 종료 \n ", KIMBAP_PRICE,
				RAMEN_PRICE);
		System.out.println(menu);
		System.out.println("--------------------------------------------------");

		
		while(true){
			selectedMenu = guest.selectMenu();

			if (selectedMenu == KIMBAP) {
				
				System.out.println("김밥하나요...");
				kimbapStock++;
				guestMoney -= KIMBAP_PRICE;

			} else if (selectedMenu == RAMEN) {
				System.out.println("라면하나요...");
				ramenStock++;
				guestMoney -= RAMEN_PRICE;

			} else if (selectedMenu == 999) {
				System.out.println("주문을 완료합니다.");
				 break;

			} else {
				System.out.println("메뉴를 다시 선택하세요[1.김밥 2.라면 999.주문끝");
			}
		}
		
		
		
		
		
		
		//guest.remainMoney(guestMoney);
		

	}

}
