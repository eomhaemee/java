package com.ktds.ehm.write;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWrite2 {

	public void start() {
		String filePath = "D:\\makeFile.txt";

		try {
			//파일에 데이터를작성할 수 있도록 지원해주는 클래스
			//true 면 append되고 false면 지우고 작성
			//FileWriter filewriter = new FileWriter(filePath, true);
			
			//메모리에 있는 내용을 손실시키지 않고 파일을 쓰도록 지원해주는 클래스
			//메모리의 데이터를 FileWriter에게 전댈해주는 역할
			//BufferedWriter bufferedWriter = new BufferedWriter(filewriter);
			
			//작성하려는 데이터를 메모리에 적절히 적제시킬수 있도록 지원해주는 클래스
			//데이터를 bufferedWriter 에게 전달해주는 역할
			PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(filePath, true)));
			
			//파일에 데이터를 작성한다.
			printWriter.println("파일에 작성합니다..");
			
			//역순으로 close()
			//메모리관리떄문에 해줘야함
			printWriter.close();


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new FileWrite2().start();
	}
}
