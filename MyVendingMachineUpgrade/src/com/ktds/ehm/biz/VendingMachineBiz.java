package com.ktds.ehm.biz;

public interface VendingMachineBiz {
	/**
	 * 음료수 판매 main process
	 */
	public void sell();
	/**
	 * 메뉴번호 선택하기
	 */
	public void selectDrinkNo();
	/**
	 * 고객의 원할떄까지 돈을 입력함
	 * @return
	 */
	public boolean checkInsertMoney();
	/**
	 * 고객이 돈을 1회 입력함
	 */
	public void insertCoin();
	/**
	 * 입력된 돈의 음료수 최소값보다 큰지 확인
	 * @param inputMoney
	 * @return
	 */
	public boolean checkPrice(int inputMoney);
	/**
	 * 모든 음료수의 최소가격을 찾음
	 * @return 최소가격
	 */
	public int minPrice();
	/**
	 * 메뉴를 보여줌
	 */
	public void printMenu();
	/**
	 * 선택된 메뉴의 재고가 있는지,고객의 돈으로 살수 있는지 확인
	 * @param chooseMenuNo
	 * @return
	 */
	public boolean isCheckMenu(int chooseMenuNo);
	/**
	 * 선택된 메뉴의 재고를 확인
	 * @param chooseMenuNo
	 * @return
	 */
	public boolean isSoldOut(int chooseMenuNo);
	/**
	 * 전체 메뉴의 재고를 확인
	 * @param chooseMenuNo
	 */
	public boolean isAllSoldOut();
	/**
	 * 선택된 음료수 수량을 update
	 * @param chooseMenuNo
	 */
	public void updItemCnt(int chooseMenuNo);
	/**
	 * 선택된 음료수의 가격으로 고객과 자판기의 돈을 update
	 * @param money
	 */
	public void updMoney(int money);
	/**
	 * 최종 현황을 보여줌
	 */
	public void printCurrentState();



}
