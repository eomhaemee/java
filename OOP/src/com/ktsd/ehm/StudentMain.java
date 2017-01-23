package com.ktsd.ehm;

public class StudentMain {

	public static void main(String[] args){
		Student ehm = new Student();
		
		ehm.setName("혜미");
		String[] books = {"새책1","새책2","새책3"};
		String[] subjects = {"새과목1","새과목2","새과목3"};
		
		ehm.introduce();
		ehm.setBooks(books);
		ehm.setSubjects(subjects);
		ehm.readBooks();
		ehm.study();
		
	}
}
