package com.ktds.ehm.dao;

import static com.ktds.ehm.constants.BicycleShopConst.BICYCLE_STOCK;
import static com.ktds.ehm.constants.BicycleShopConst.BICYCLE_TYPE;
import static com.ktds.ehm.constants.BicycleShopConst.LEVEL;
import static com.ktds.ehm.constants.BicycleShopConst.PRICE_PER_MIN;

import java.util.ArrayList;
import java.util.List;

import com.ktds.ehm.vo.BicycleShopVO;
import com.ktds.ehm.vo.UserInfoVO;

public class BicycleChopDaoImpl implements BicycleShopDao {
	private List<BicycleShopVO> bicycleShopList;
	private BicycleShopVO bicycleShopVO;
	private UserInfoVO userInfoVO;

	public BicycleChopDaoImpl(int inputMoney) {

		this.bicycleShopList = new ArrayList<BicycleShopVO>();
		this.userInfoVO = new UserInfoVO(inputMoney);
		// 자전거shop 초기 세팅
		for (int typeCount = 0; typeCount < BICYCLE_TYPE; typeCount++) {
			bicycleShopVO = new BicycleShopVO(LEVEL[typeCount], PRICE_PER_MIN[typeCount], BICYCLE_STOCK[typeCount]);
			bicycleShopList.add(bicycleShopVO);
		}

	}

	@Override
	public void bicycleAdd() {
		bicycleShopList.add(bicycleShopVO);

	}

	@Override
	public int rentTime() {
		// TODO Auto-generated method stub
		return 0;
	}

}