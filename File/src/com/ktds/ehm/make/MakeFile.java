package com.ktds.ehm.make;

import java.io.File;
import java.io.IOException;

public class MakeFile {

	public void start() {
		String filePath = "D:\\makeFile.txt";
		
		File textFile = new File(filePath);
		
		try {
			//파일을 실제 저장소에 생성한다.
			//파일,폴더 생성시는 존재하는지 여부 체크
			if(!textFile.exists()){
				textFile.createNewFile();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new MakeFile().start();
	}
}
