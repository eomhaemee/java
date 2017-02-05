package com.ktds.ehm.dao;

import java.util.ArrayList;
import java.util.List;

import com.ktds.ehm.vo.DrinkInfoVO;
import com.ktds.ehm.vo.UserInfoVO;

import static com.ktds.ehm.constants.BasketConst.*;

public class VendingMachineDaoImpl implements VendingMachineDao {

	private List<DrinkInfoVO> drinkInfoList;
	private UserInfoVO userInfoVO;
	private DrinkInfoVO drinkInfoVO;

	public VendingMachineDaoImpl(int inputMoney) {

		this.drinkInfoList = new ArrayList<DrinkInfoVO>();
		this.userInfoVO = new UserInfoVO(inputMoney);

		// 자판기초기 세팅
		for (int menuNo = 0; menuNo < DRINK_SIZE; menuNo++) {
			drinkInfoVO = new DrinkInfoVO(DRINK_NAME[menuNo], DRINK_PRICE[menuNo], 0, DRINK_STOCK[menuNo]);
			drinkInfoList.add(menuNo, drinkInfoVO);
		}

	}

	@Override
	public List<DrinkInfoVO> getAllDrinkInfo() {

		return drinkInfoList;
	}

	@Override
	public DrinkInfoVO getDrinkInfo(int chooseMenuNo) {

		return drinkInfoList.get(chooseMenuNo);
	}

	@Override
	public void setDrinkInfo(int chooseMenuNo, DrinkInfoVO drinkInfoVO) {
		drinkInfoList.set(chooseMenuNo, drinkInfoVO);
	}

	@Override
	public int getUserMoney(int buyerOrSeller) {

		if (buyerOrSeller == BUYER) {
			return userInfoVO.getBuyerMoney();
		} else {
			return userInfoVO.getSellerMoney();
		}

	}

	@Override
	public void setBuyerMoney(int buyerMoney) {
		userInfoVO.setBuyerMoney(buyerMoney);

	}

	@Override
	public void setSellerMoney(int sellerMoney) {
		userInfoVO.setSellerMoney(sellerMoney);

	}

}
