package com.ktds.ehm;

public class BicycleRentalShop {

	private int bicycleCnt;
	private int budget;
	private final int COST = 5000;

	public BicycleRentalShop(int bicycleCnt, int budget) {
		this.bicycleCnt = bicycleCnt;
		this.budget = budget;
	}

	public int getBicycleCnt() {
		return bicycleCnt;
	}

	public void setBicycleCnt(int bicycleCnt) {
		this.bicycleCnt = bicycleCnt;
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public int getCOST() {
		// TODO Auto-generated method stub
		return COST;
	}

	public void rentStart(Guest guest) {

		while (true) {

			if (this.getBicycleCnt() == 0) {
				System.out.println("대여할 자전거가 없습니다.담에 오세여");
				break;
			} else if (guest.getMyMoney() < 5000) {
				System.out.println("5000원도 없으면  안빌려줌 잘가시오");
				break;
			} else {
				rentToGuest(guest);

				System.out.println(this);
				System.out.println(guest);
			}

		}

	}

	public void rentToGuest(Guest guest) {
		this.bicycleCnt--;
		this.budget += COST;

		guest.borrow(this, COST);

	}

	@Override
	public String toString() {
		String message = ("===================\n자전거 대여점 현황\n-------------------\n");
		message += String.format("자전거 보유수: %d 대\n대여료 총합 : %d \n", this.bicycleCnt, this.budget);
		message += ("===================\n");
		return message;
	}

}
