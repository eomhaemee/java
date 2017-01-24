package com.ktsd.ehm;


public class PersonMain {

	public static void main(String[] args){
		
		Person person1 = new Person();
		person1.setName("엄혜미");
		person1.setJob("가수");
		person1.introduce();
		
		Person person2 = new Person();
		person2.setName("오승혁");
		person2.setJob("건물주");
		person2.introduce();
		
		Person person3 = new Person();
		person3.introduce();
		
		Person person4 = new Person("혜미","땅부자");
		person4.introduce();
	}
}
