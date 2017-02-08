package com.ktds.ehm.dao;

import java.util.List;

import com.ktds.ehm.vo.BicycleShopVO;

public interface BicycleShopDao {
	/**
	 * 자전거 추가
	 */
	public void bicycleAdd();
	/**
	 * 전체 자전거 가져오기
	 * @return
	 */
	public List<BicycleShopVO> getAllBikeInfo();
	/**
	 * 
	 * @return
	 */
	public BicycleShopVO getOneBikeInfo(int chooseMenuNo);
	
	/**
	 * retal shop 정보 update
	 * @param chooseMenuNo
	 * @param bicycleShopVO
	 */
	public void setDrinkInfo(int chooseMenuNo ,BicycleShopVO bicycleShopVO);

	/**
	 * 고객, or 자판기의 돈 가져오기
	 * @param buyerOrSeller
	 * @return
	 */
	public int getUserMoney(int buyerOrSeller);
	
	/**
	 * 고객돈 update
	 * @param buyerMoney
	 * @param sellerMoney
	 */
	public void setBuyerMoney(int buyerMoney);
	/**
	 * 대여점 돈 update
	 * @param sellerMoney
	 */
	public void setSellerMoney(int sellerMoney);
	
	
}
