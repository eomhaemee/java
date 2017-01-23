package com.ktds.ehm;

import com.ktds.ehm.hospital.Doctor;

public class Main {

	public static void main(String[] args){
		System.out.println("패키지 Test확인");
		
		//com.ktds.ehm.hospital.Doctor doctor = new com.ktds.ehm.hospital.Doctor();
		
		Doctor doctor = new Doctor();
		
		doctor.hello();
	}
}
