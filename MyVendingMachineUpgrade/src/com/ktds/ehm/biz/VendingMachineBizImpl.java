package com.ktds.ehm.biz;

import static com.ktds.ehm.constants.BasketConst.*;

import java.util.Scanner;

import com.ktds.ehm.dao.VendingMachineDao;
import com.ktds.ehm.dao.VendingMachineDaoImpl;
import com.ktds.ehm.vo.DrinkInfoVO;

public class VendingMachineBizImpl implements VendingMachineBiz{

	private VendingMachineDao vmDao;
	int chooseMenuNo = 0;
	int inputMoney = 0;
	Scanner input = null;

	public VendingMachineBizImpl(int inputMoney) {
		vmDao = new VendingMachineDaoImpl(inputMoney);
		input = new Scanner(System.in);
		this.inputMoney = inputMoney;
	}

	@Override
	public void sell() {
		int price = 0;

		// 메뉴선택
		while (true) {

			// 고객의 돈이 떨어지면 stop
			if (!checkInsertMoney()) {
				break;
			}

			// 재고가 다 떨어지면 stop
			if (isAllSoldOut()) {
				break;
			}

			printMenu();

			selectDrinkNo();

			// 수량변경
			updItemCnt(chooseMenuNo);

			price = vmDao.getDrinkInfo(chooseMenuNo).getDrinkPrice();
			// 돈계산
			updMoney(price);

			printCurrentState();

		}
	}

	@Override
	public void selectDrinkNo() {

		while (true) {
			System.out.println("구매할 음료의  번호를 입력하세요:");
			chooseMenuNo = input.nextInt();
			if (isCheckMenu(chooseMenuNo)) {
				System.out.println("선택하신 음료: " + vmDao.getDrinkInfo(chooseMenuNo).getDrinkName());
				break;
			} else {
				System.out.println("메뉴를 확인하고 다시 입력하세요");
			}

		}
	}

	@Override
	public boolean checkInsertMoney() {
		int isGo = 0;
		boolean result = true;

		while (!checkPrice(vmDao.getUserMoney(BUYER))) {
			System.out.println("돈을 더 넣겠습니까? [ 1:진행,2:종료] ");
			
			isGo = input.nextInt();
			
			if(isGo !=1 && isGo !=2){
				System.out.println("입력한숫자 : "+ isGo+ " 확인후 다시 입력하세요");
				continue;
			}
			
			if (isGo == 1) {
				insertCoin();
			} else {
				System.out.println("구매를 종료합니다. 잔돈: " + vmDao.getUserMoney(BUYER));
				result = false;
				break;
			}
		}
		//System.out.println(result);
		return result;
	}

	@Override
	public void insertCoin() {
		int inputMoney = 0;
		System.out.println("돈을 입력하세요: ");
		try {
			inputMoney = input.nextInt();
		} catch (Exception e) {
			e.getMessage();
			
		}
		vmDao.setBuyerMoney(vmDao.getUserMoney(BUYER) + inputMoney);

	}

	@Override
	public boolean checkPrice(int inputMoney) {
		boolean result = false;
		if (inputMoney < minPrice()) {
			System.out.println(inputMoney + " 원으로 구매할수 있는 음료가 없어요");
			result = false;
		} else {
			result = true;
		}
		return result;
	}

	// 음료수 최소가격 가져오기
	@Override
	public int minPrice() {
		int minPrice = 100000000;

		for (int menuNo = 0; menuNo < vmDao.getAllDrinkInfo().size(); menuNo++) {

			if (minPrice > vmDao.getDrinkInfo(menuNo).getDrinkPrice()) {
				minPrice = vmDao.getDrinkInfo(menuNo).getDrinkPrice();
			}
		}
		return minPrice;
	}

	@Override
	public void printMenu() {
		System.out.println("=========[자판기메뉴]==========");
		// 남아 있는 음료수만 보여주기
		for (int menuNo = 0; menuNo < vmDao.getAllDrinkInfo().size(); menuNo++) {

			if (isCheckMenu(menuNo)) {
				System.out.println(menuNo + ". " + "[" + vmDao.getDrinkInfo(menuNo).getDrinkName() + " : "
						+ vmDao.getDrinkInfo(menuNo).getDrinkPrice() + " 원]");
			}
		}
		System.out.println("=============================");
	}

	public boolean isCheckMenu(int chooseMenuNo) {
		boolean result = false;
		if (!isSoldOut(chooseMenuNo)
				&& (vmDao.getUserMoney(BUYER) >= vmDao.getDrinkInfo(chooseMenuNo).getDrinkPrice())) {
			result = true;
		}
		return result;
	}

	@Override
	public boolean isSoldOut(int chooseMenuNo) {

		int remainDrinkcnt = vmDao.getDrinkInfo(chooseMenuNo).getDrinkSellerStock();

		if (remainDrinkcnt == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isAllSoldOut() {
		boolean result = false;
		for (int menuNo = 0; menuNo < vmDao.getAllDrinkInfo().size(); menuNo++) {
			// 마지막 item까지 soldOut이면
			if (menuNo == vmDao.getAllDrinkInfo().size() - 1 && isSoldOut(menuNo)) {
				System.out.println("모든 음료의 재고가 떨어졌습니다.");
				result = true;
			}
		}
		return result;
	}

	@Override
	public void updItemCnt(int chooseMenuNo) {
		DrinkInfoVO drinkInfoVO = null;

		drinkInfoVO = vmDao.getDrinkInfo(chooseMenuNo);

		// 선택된 음료 자판기 갯수 감소
		drinkInfoVO.setDrinkSellerStock(drinkInfoVO.getDrinkSellerStock() - 1);

		// 선택된 음료 사용자 갯수 증가
		drinkInfoVO.setDrinkBuyerStock(drinkInfoVO.getDrinkBuyerStock() + 1);

	}

	@Override
	public void updMoney(int money) {

		// 돈계산시작
		int buyerMoney = 0;
		int sellerMoney = 0;

		buyerMoney = vmDao.getUserMoney(BUYER) - money;
		sellerMoney = vmDao.getUserMoney(SELLER) + money;

		vmDao.setBuyerMoney(buyerMoney);
		vmDao.setSellerMoney(sellerMoney);
	}

	@Override
	public void printCurrentState() {
		System.out.println("********[음료 구매현황]*********");
		System.out.println(" [고객 돈] " + vmDao.getUserMoney(BUYER) + " [자판기 돈] " + vmDao.getUserMoney(SELLER));
		for (int menuNo = 0; menuNo < vmDao.getAllDrinkInfo().size(); menuNo++) {
			System.out.println(menuNo + ". " + vmDao.getDrinkInfo(menuNo).getDrinkName() + ": " + "[ "
					+ vmDao.getDrinkInfo(menuNo).getDrinkBuyerStock() + "  ]  " + "[ "
					+ vmDao.getDrinkInfo(menuNo).getDrinkSellerStock() + "/" + DRINK_STOCK[menuNo] + "  ] ");

		}
		System.out.println("****************************");
	}

}
