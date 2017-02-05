package com.ktds.ehm.bank.biz;

import java.util.List;

import com.ktds.ehm.bank.vo.BankVO;

public interface BankBiz {
	// 고객등록
	// 기존고객인지확인
	// 고객조회
	// 고객정보 조회(예치금정보,이름)
	public void bankOpen();
	
	public void addUser();
	
	public boolean isExistUser(String userId);
	
	public void printOneUser(int userNo);
	
	public void getAllUser();
	
	public void updMoney(String chooseMenu,int userNo);
}
