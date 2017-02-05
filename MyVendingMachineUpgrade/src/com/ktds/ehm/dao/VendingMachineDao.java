package com.ktds.ehm.dao;

import java.util.List;

import com.ktds.ehm.vo.DrinkInfoVO;

public interface VendingMachineDao {
	
	/**
	 * 자판기 음료수 정보 전체 가져오기
	 * @return
	 */
	public List<DrinkInfoVO> getAllDrinkInfo();
	
	/**
	 * 선택한 자판기 정보 가져오기
	 * @param chooseMenuNo
	 * @return
	 */
	public DrinkInfoVO getDrinkInfo(int chooseMenuNo);
	
	/**
	 * 선택한 자판기 정보 update
	 * @param chooseMenuNo
	 * @param drinkInfoVO
	 */
	public void setDrinkInfo(int chooseMenuNo ,DrinkInfoVO drinkInfoVO);
	
	/**
	 * 고객, or 자판기의 돈 가져오기
	 * @param buyerOrSeller
	 * @return
	 */
	public int getUserMoney(int buyerOrSeller);
	
	/**
	 * 고객 자판기의 돈 update
	 * @param buyerMoney
	 * @param sellerMoney
	 */
	public void setBuyerMoney(int buyerMoney);

	public void setSellerMoney(int sellerMoney);

}
