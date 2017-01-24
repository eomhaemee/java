package com.ktds.ehm;

public class ArmyMain {

	public static void main(String[] args){
		
		Army army = new Army();
		
		Person makeArmy1= army.makeArmy("군인엄혜미");
		System.out.println(makeArmy1.getName());
		System.out.println(makeArmy1.getJob());
		
		Person makeArmy2= army.makeArmy("군인오승혁");
		System.out.println(makeArmy2.getName());
		System.out.println(makeArmy2.getJob());
	}
}
