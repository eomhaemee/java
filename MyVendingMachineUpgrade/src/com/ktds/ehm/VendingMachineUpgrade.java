package com.ktds.ehm;

import java.util.Scanner;

import com.ktds.ehm.biz.VendingMachineBiz;
import com.ktds.ehm.biz.VendingMachineBizImpl;

public class VendingMachineUpgrade {

	public void start() {

		Scanner input = new Scanner(System.in);

		System.out.println("돈을 입력하세요");
		int inputMoney = input.nextInt();

		VendingMachineBiz vendingMachineBiz = new VendingMachineBizImpl(inputMoney);

		vendingMachineBiz.sell();

	}

	public static void main(String[] args) {
		new VendingMachineUpgrade().start();

	}
}
