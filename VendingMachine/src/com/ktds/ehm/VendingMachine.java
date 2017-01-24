package com.ktds.ehm;

import java.util.Scanner;

import com.ktds.ehm.guest.Guest;

public class VendingMachine {
	public void start(){
		
		System.out.println("1.콜라,2.사이다,2.환타 숫자를 선택하세요");
		Scanner input = new Scanner(System.in);
		
		int itemNo = input.nextInt();
		
		Guest guest = new Guest();
		guest.buy(100,itemNo);
		System.out.println(guest);
		
		
	}
	
	public static void main(String[] args){
		new VendingMachine().start();
	}
}
