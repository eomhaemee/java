package com.ktds.ehm.bank;

import com.ktds.ehm.bank.biz.BankBiz;
import com.ktds.ehm.bank.biz.BankBizImpl;

public class BankMain {

	public void start() {

		BankBiz bankBiz = new BankBizImpl();
		bankBiz.bankOpen();

	}

	public static void main(String[] args) {
		new BankMain().start();
	}
}
