package com.ktds.ehm.biz;

import java.util.Scanner;

import com.ktds.ehm.dao.VendingMachineDao;
import com.ktds.ehm.dao.VendingMachineDaoImpl;
import com.ktds.ehm.vo.BasketVO;
import static com.ktds.ehm.constants.BasketConst.*;

public class VendingMachineBizImpl implements VendingMachineBiz {

	private VendingMachineDao vendingMachineDao;
	int chooseNo = 0;
	int inputMoney = 0;
	Scanner input = null;

	public VendingMachineBizImpl(int inputMoney) {

		vendingMachineDao = new VendingMachineDaoImpl();
		this.inputMoney = inputMoney;

		/*
		 * BasketVO basketVO = new BasketVO();
		 * 
		 * //입력한금액 최소금액보다 큰지 체크(ehm) if( inputMoney < 900) {
		 * System.out.println("살수 있는게 없어요.."); //고객에게 돈을 다시 돌려줌
		 * basketVO.setBuyerMoney(inputMoney); }
		 */

	}

	@Override
	public void sell() {

		// 메뉴보여주기시작
		System.out.println("=========[자판기메뉴]==========");
		// 남아 있는 음료수만 보여주기
		for (int menuNo = 0; menuNo < DRINK_ITEM.length; menuNo++) {

			if (!isSoldOut(menuNo)) {
				System.out.println(menuNo+ ". " + "[" + DRINK_ITEM[menuNo] + "]");
			}
		}
		System.out.println("=============================");

		BasketVO basketVO = vendingMachineDao.findOneList(chooseNo);
		// 메뉴선택
		while (true) {

			chooseNo = input.nextInt();
			// 선택한 제품의 재고가 없거나 고객의 돈이 떨어지면 stop
			if (isSoldOut(chooseNo) || basketVO.getSellerItemCnt()[chooseNo] == 0) {
				break;
			}
			updMoney(DRINK_PRICE[chooseNo]);
			updItemCnt(chooseNo);
		}
	}

	@Override
	public boolean isSoldOut(int chooseNo) {
		BasketVO basketVO = vendingMachineDao.findOneList(chooseNo);

		int remainDrinkcnt = basketVO.getSellerItemCnt()[chooseNo];
		if (remainDrinkcnt == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void updItemCnt(int chooseNo) {

		BasketVO basketVO = vendingMachineDao.findOneList(chooseNo);

		// buyer의 선택한 음료수 count 증가
		int buyerItemCnt[] = basketVO.getBuyerItemCnt();
		buyerItemCnt[chooseNo]++;
		basketVO.setBuyerItemCnt(buyerItemCnt);

		// seller의 선택한 음료수 count 감소
		int sellerItemCnt[] = basketVO.getSellerItemCnt();
		sellerItemCnt[chooseNo]--;
		basketVO.setSellerItemCnt(sellerItemCnt);
	}

	@Override
	public void updMoney(int money) {
		BasketVO basketVO = vendingMachineDao.findOneList(chooseNo);

		int buyerMoney = basketVO.getBuyerMoney() - money;
		int sellerMoney = basketVO.getSellerMoney() + money;

		basketVO.setBuyerMoney(buyerMoney);
		basketVO.setSellerMoney(sellerMoney);
	}

}
