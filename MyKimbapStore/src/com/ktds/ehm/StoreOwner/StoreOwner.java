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

	public void sell(Guest guest) {

		String menu = "";
		int selectedMenu = 0;

		menu = "===========================================================";
		menu += "\n	김밥천국 메뉴판[메뉴 NO.입력하세요]";
		menu += "\n----------------------------------------------------------";
		menu += String.format("\n	1. 김밥(%d원)   |  2. 라면(%d원) |  999. 주문 종료 \n ", KIMBAP_PRICE, RAMEN_PRICE);
		menu += "\n===========================================================";
		System.out.println(menu);

		while (true) {
			selectedMenu = guest.selectMenu();
			// selectedMenuCount = guest.selectedMenuCount(selectedMenu);

			if (selectedMenu == KIMBAP) {
				if (guest.getGuestMoney() < KIMBAP_PRICE) {
					System.out.println("김밥을 주문할 잔액이 없군요..ㅜㅜ  잔액을 확인바랍니다.");
				} else {
					kimbapStock++;
					this.storeBalane += KIMBAP_PRICE;
					guest.remainMoney(KIMBAP_PRICE);
					guest.takeFood(selectedMenu);

					System.out.println("주문한 김밥수: " + kimbapStock);
				}

			} else if (selectedMenu == RAMEN) {
				if (guest.getGuestMoney() < RAMEN_PRICE) {
					System.out.println("라면을 주문할 잔액이 없군요..ㅡㅜ 잔액을 확인바랍니다.");
				} else {
					ramenStock++;
					this.storeBalane += RAMEN_PRICE;

					guest.remainMoney(RAMEN_PRICE);
					guest.takeFood(selectedMenu);
					System.out.println("주문한 라면수: " + ramenStock);
				}

			} else if (selectedMenu == 999) {
				System.out.println("주문을 완료합니다.");
				break;

			} else {
				System.out.println("메뉴를 다시 선택하세요[1.김밥 | 2.라면  | 999.주문종료]");
			}

			System.out.println(guest);
		}

		// guest.remainMoney(this.clcMoney);
		// System.out.println(this);

		// this.storeBalane += this.clcMoney;

	}

	@Override
	public String toString() {

		String message = "===========================================================";
		message += "\n	주문내역[매장용]";
		message += "\n----------------------------------------------------------";
		message += String.format("\n	1. 김밥(%d개)   |  2. 라면(%d개) |  계산 총금액: %d \n ", kimbapStock, ramenStock,
				storeBalane);
		message += "\n===========================================================";
		return message;

	}

}

