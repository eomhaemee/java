package com.ktds.ehm.dao;

import java.util.List;

import com.ktds.ehm.vo.BasketVO;

public interface VendingMachineDao {

	// Item 조회하기
	public List<BasketVO> queryAllList();

	// 특정 Item 조회하기
	public BasketVO findOneList(int index);

	// vo set 하기
	public BasketVO setList(int index, BasketVO basketVO);

}
