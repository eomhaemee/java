package com.ktds.ehm.biz;

import java.util.Scanner;

import com.ktds.ehm.dao.BicycleShopDao;
import com.ktds.ehm.dao.BicycleShopDaoImpl;
import com.ktds.ehm.vo.BicycleShopVO;

public class BicycleShopBizImpl implements BicycleShopBiz {
	private BicycleShopDao bsDao;
	private BicycleShopVO bicycleShopVO;
	private int chooseMenuNo;
	private Scanner input;

	public BicycleShopBizImpl() {
		this.bsDao = new BicycleShopDaoImpl();
		input = new Scanner(System.in);
	}

	@Override
	public void rent() {
		printMenu();

	}

	@Override
	public void selectBikeNo() {
		while (true) {
			System.out.println("대여할 번호를 입력하세요:");
			chooseMenuNo = input.nextInt();
			
			if(isSoldOut){
				System.out.println("선택한 급수의 자전거 재고가 없습니다. ");
			}
			System.out.println("");
			
			
			if (isCheckMenu(chooseMenuNo)) {
				System.out.println("선택하신 음료: " + vmDao.getDrinkInfo(chooseMenuNo).getDrinkName());
				break;
			} else {
				System.out.println("메뉴를 확인하고 다시 입력하세요");
			}

		}

	}
	@Override
	public boolean isSoldOut(int chooseMenuNo) {

		int remainBikeCnt = bsDao.getOneBikeInfo(chooseMenuNo).getBicycleStock();

		if (remainBikeCnt == 0) {
			return true;
		} else {
			return false;
		}
	}
	@Override
	public void insertCoin() {
		// TODO Auto-generated method stub

	}

	@Override
	public void printMenu() {
		System.out.println("======[자전거 대여메뉴]=======");

		for (int menuNo = 0; menuNo < bsDao.getAllBikeInfo().size(); menuNo++) {

			bicycleShopVO = bsDao.getOneBikeInfo(menuNo);

			System.out.println(menuNo + ". " + "[ 레벨: " + bicycleShopVO.getLevel() + " 재고수: "
					+ bicycleShopVO.getBicycleStock() + " 가격(원/분): " + bicycleShopVO.getPricePerTenMin());

		}
		System.out.println("=============================");

	}

	@Override
	public void updItemCnt(int chooseMenuNo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updMoney(int money) {
		// TODO Auto-generated method stub

	}

	@Override
	public void clcPay(int rentalTime) {
		// TODO Auto-generated method stub

	}

	@Override
	public void printCurrentState() {
		// TODO Auto-generated method stub

	}

}
