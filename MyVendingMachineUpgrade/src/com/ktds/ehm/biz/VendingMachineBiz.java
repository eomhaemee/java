package com.ktds.ehm.biz;

import com.ktds.ehm.vo.BasketVO;

public interface VendingMachineBiz {
	public void sell();
	
	public void updItemCnt(int index);
	
	public void updMoney(int money);
	
	public boolean isSoldOut(int index);

	/*

	public void printMenu(int index);

	public boolean isSoldOut(int index);

	//public void updDrinkCount(int chooseNo);
	public void updDrinkCount(int chooseNo,BasketVO basketVO);
	
	public void updMoney(int money);
*/
}
