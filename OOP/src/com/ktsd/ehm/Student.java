package com.ktsd.ehm;

public class Student {
	//멤버변수는 private로 사용
	private String name = "엄혜미";
	private int grade = 3;
	private int classNumber = 15;
	private String schoolName = "답십리초";
	private String[] books = {"C를 배운적이 없다구요","JAVA를 배운적이 없다구요","C++를 배운적이 없다구요"};
	private String[] subjects = {"국어","영어","수학"};
	
	//instance field에 대해서 setter생성
	public void setName(String name){
		//instance field의 변수에 접근시 this
		//파라미터로 전달된 데이터 길이가 3이면 변경하기
		if(name.length() == 3){
			this.name = name;
		}
	
	}
	public void setgrade(int grade){
		this.grade = grade;
	}
	public void setClassNumber(int classNumber){
		this.classNumber = classNumber;
	}
	public void setSchoolName(String schoolName){
		this.schoolName = schoolName;
	}
	public void setBooks(String[] books){
		this.books = books;
	}
	public void setSubjects(String[] subjects){
		this.subjects = subjects;
	}
	
	void introduce(){
		System.out.printf("제 이름은 [%s] 입니다.\n",name);
	}
	
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
