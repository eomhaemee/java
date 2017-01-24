package com.ktds.ehm;

public class CalculatorMain {

	public static void main(String[] args){
		
		Calculator calculator = new Calculator();
		
		calculator.printComputeResult();
		calculator.printComputeResult(10, 50);
		
		int result = calculator.getAndPrintMultiplicationResult(10, 20);
		String message = String.format("%d * %d = %d \n", 10,20,result);
		System.out.printf(message);
		
	
	}
}
