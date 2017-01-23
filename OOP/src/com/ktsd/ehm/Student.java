package com.ktsd.ehm;

public class Student {

	String name = "엄혜미";
	int grade = 3;
	int classNumber = 15;
	String schoolName = "답십리초";
	String[] books = {"C를 배운적이 없다구요","JAVA를 배운적이 없다구요","C++를 배운적이 없다구요"};
	String[] subjects = {"국어","영어","수학"};
	
	void study(){
		for (int i = 0; i < subjects.length; i++) {
			System.out.printf("지금 [%s] 과목을 공부중..\n",subjects[i]);
		}
	}
	void takeExam(){
		for(int i = 0 ; i< books.length;i++){
			System.out.printf("[%s] 과목을 시험봄니다...\n",books[i]);
		}
	}
	void readBooks(){
		for(int i = 0 ; i< books.length;i++){
			System.out.printf("지금[ %s ]책을 읽는중..\n",books[i]);
		}
		
	}
			
}
