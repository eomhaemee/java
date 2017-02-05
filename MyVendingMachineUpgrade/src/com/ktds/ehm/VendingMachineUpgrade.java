package com.ktds.ehm;

import java.util.Scanner;

import com.ktds.ehm.biz.VendingMachineBiz;
import com.ktds.ehm.biz.VendingMachineBizImpl;

public class VendingMachineUpgrade {
	Scanner input = null;

	public void start() {
		input = new Scanner(System.in);
		System.out.println("돈을 입력하세요: ");
		int inputMoney = input.nextInt();
		System.out.println("입력하신 금액 : " + inputMoney + " 원");

		VendingMachineBiz vendingMachineBiz = new VendingMachineBizImpl(inputMoney);
		vendingMachineBiz.sell();
	

	}

	public static void main(String[] args) {
		new VendingMachineUpgrade().start();

	}
}
