package com.ktds.ehm;

public class Army {
	
	public final String JOB = "직업군인";
	
	public Person makeArmy(String name){
		//외부에서 전달받은 이름을 이용해Person 객체를 생성
		
		Person person = new Person(name,JOB);
		//생성된 객체반환
		return person;
		
	}
}
