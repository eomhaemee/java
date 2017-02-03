package com.ktds.ehm.dao;

import static com.ktds.ehm.constants.BasketConst.*;

import java.util.ArrayList;
import java.util.List;

import com.ktds.ehm.vo.BasketVO;

public class VendingMachineDaoImpl implements VendingMachineDao {

	private List<BasketVO> basketList;

	public VendingMachineDaoImpl() {
		basketList = new ArrayList<BasketVO>();
	}

	@Override
	public List<BasketVO> queryAllList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BasketVO findOneList(int index) {
		return basketList.get(index);
		
	}

/*	public void findBuyerDrinkCount(int index, BasketVO basketVO) {
		int buyerItemCnt[] = basketList.get(index).getBuyerItemCnt();
		int buyerCnt = buyerItemCnt[index];
	}
*/
	@Override
	public BasketVO setList(int index, BasketVO basketVO) {
		return basketList.set(index, basketVO);
	
	}

	
	
	
	
}
