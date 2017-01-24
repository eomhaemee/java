package com.ktsd.ehm;

public class Person {
	private String name;
	private String job;
	
	/**
	 * Default생성자
	 * 없으면 컴파일될때 자동으로 생성
	 * 주로 멤버변수 초기화 작업을 여기서함
	 */
	public Person(){
		System.out.println("난 기본 생성자");
		name= "익명";
		job = "난건물주";
	}
	//같은 이름 오버로딩
	public Person(String name,String job){
		System.out.println("난 arg 2개 있는 생성자");
		setName(name);
		setJob(job);
	}
	
	public void setName(String name){
		this.name = name;
	}
	public void setJob(String job){
		this.job= job;
	}
	public void introduce(){
		String message = String.format("이름:%s 직업:%s", name,job);
		System.out.println(message);
		System.out.println("=======================");
	}
}
