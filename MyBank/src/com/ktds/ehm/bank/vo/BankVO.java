package com.ktds.ehm.bank.vo;
import static com.ktds.ehm.bank.Consts.BankConst.*;
public class BankVO {
	String name;
	String userId;
	int deposit;
	int bankTotalDiposit;
	
	public BankVO() {

		this.bankTotalDiposit = BANK_DEPOSIT;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	public int getBankTotalDiposit() {
		return bankTotalDiposit;
	}

	public void setBankTotalDiposit(int bankTotalDiposit) {
		this.bankTotalDiposit = bankTotalDiposit;
	}
	
	
}
