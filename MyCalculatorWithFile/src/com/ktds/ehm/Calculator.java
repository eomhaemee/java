package com.ktds.ehm;

import com.ktds.ehm.helper.FileWriteHelper;

public class Calculator {

	FileWriteHelper fileWriteHelper;

	public Calculator() {
		fileWriteHelper = new FileWriteHelper();
	}

	public void start() {
		int result = 10 + 70;
		String message = String.format("%d + %d = %d", 10, 70, result);

		
		//fileWriteHelper.log(message);
		//log를 static으로 생성하면 class명으로 접근가능
		FileWriteHelper.log(message);
		
	}

	public static void main(String[] args) {

		new Calculator().start();
	}
}
