package com.ktds.ehm.bank.dao;

import java.util.ArrayList;
import java.util.List;

import com.ktds.ehm.bank.vo.BankVO;

public class BankDaoImpl implements BankDao {

	private List<BankVO> userList;
	private BankVO bankVO;

	public BankDaoImpl() {

		this.userList = new ArrayList<BankVO>();
		this.bankVO = new BankVO();
	}
	
	
	@Override
	public void addUser(BankVO bankVO) {
		userList.add(bankVO);

	}

	@Override
	public BankVO getOneUser(int userId) {

		return userList.get(userId);
	}

	@Override
	public List<BankVO> getAllUser() {

		return userList;
	}

	@Override
	public void updMoney(int userNo, BankVO bankVO) {
		userList.set(userNo, bankVO);

	}

}
