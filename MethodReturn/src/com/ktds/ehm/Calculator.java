package com.ktds.ehm;

public class Calculator {

	public void printComputeResult(){
		int result = 1+1;
		System.out.println(result);
	}
	
	public void printComputeResult(int numberOne,int numberTwo){
		
		int result = numberOne + numberTwo;
		System.out.println(result);
	}
	//print도 하고 return도 있으니 이름 잘써주기
	/**
	 * 숫자 두개를 전달 받아 곱한뒤 출력하고 반환한다.
	 * @param numberOne : int 첫번째 숫자
	 * @param numberTwo : int 두번째 숫자
	 * @return : int numberOne + numberTwo
	 */
	public int getAndPrintMultiplicationResult(int numberOne,int numberTwo){
		
		int result = numberOne * numberTwo;
		System.out.println(result);
		return result;
	}
}
