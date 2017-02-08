package com.ktds.ehm.dao;

import static com.ktds.ehm.constants.BicycleShopConst.*;

import java.util.ArrayList;
import java.util.List;

import com.ktds.ehm.vo.BicycleShopVO;
import com.ktds.ehm.vo.UserInfoVO;

public class BicycleShopDaoImpl implements BicycleShopDao {

	private List<BicycleShopVO> bicycleShopList;
	private BicycleShopVO bicycleShopVO;
	private UserInfoVO userInfoVO;

	public BicycleShopDaoImpl() {

		this.bicycleShopList = new ArrayList<BicycleShopVO>();
		this.userInfoVO = new UserInfoVO(USER_INIT_MONEY);
		// 자전거shop 초기 세팅
		for (int typeCount = 0; typeCount < BICYCLE_TYPE; typeCount++) {
			bicycleShopVO = new BicycleShopVO(LEVEL[typeCount], PRICE_PER_MIN[typeCount], BICYCLE_STOCK[typeCount]);
			bicycleShopList.add(bicycleShopVO);
		}

	}

	@Override
	public void bicycleAdd() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<BicycleShopVO> getAllBikeInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BicycleShopVO getOneBikeInfo(int no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDrinkInfo(int chooseMenuNo, BicycleShopVO bicycleShopVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getUserMoney(int buyerOrSeller) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setBuyerMoney(int buyerMoney) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSellerMoney(int sellerMoney) {
		// TODO Auto-generated method stub
		
	}

	
	
}
