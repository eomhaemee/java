package com.ktds.ehm.biz;

public interface BicycleShopBiz {
	/**
	 * 대여하기 main process
	 */
	public void rent();
	/**
	 * 자전거 선택하기
	 */
	public void selectBikeNo();
	/**
	 * 고객이 돈을 1회 입력함
	 */
	public void insertCoin();
	/**
	 * 메뉴를 보여줌
	 */
	public void printMenu();
	/**
	 * 재고를 확인함
	 * @param chooseMenuNo
	 * @return
	 */
	public boolean isSoldOut(int chooseMenuNo);
	/**
	 * 선택된 자전거 수량을 update
	 * @param chooseMenuNo
	 */
	public void updItemCnt(int chooseMenuNo);
	/**
	 * 선택된 자전거의 가격으로 고객과 Seller의 돈을 update
	 * @param money
	 */
	public void updMoney(int money);
	/**
	 * 비용정보 계산하기
	 * @param money
	 */
	public void clcPay(int rentalTime);
	/**
	 * 최종 현황을 보여줌
	 */
	public void printCurrentState();
}
