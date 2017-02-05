package com.ktds.ehm.bank.dao;

import java.util.List;

import com.ktds.ehm.bank.vo.BankVO;

public interface BankDao {
	
	public void addUser(BankVO bankVO);
	
	public BankVO getOneUser(int userId);
	
	public List<BankVO> getAllUser();
	
	public void updMoney(int userNo,BankVO bankVO );
}
