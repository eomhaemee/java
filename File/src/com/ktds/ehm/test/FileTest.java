package com.ktds.ehm.test;

import java.io.File;

public class FileTest {

	public static void main(String[] args){
		
		String folderPath = "D:\\Languages";
		
		//forderPath경로를 읽어온다.
		File languagesFolder = new File(folderPath);
		
		//languagesfolder 의 경로가 폴더(디렉토리)인지 파일인지 구분한다.
		if(languagesFolder.isDirectory()){
			//getAbsolutePath()파일이 가지고 있는 경로 fullpath
			//getPath() 상대경로
			System.out.println(languagesFolder.getAbsolutePath() + "는 디렉토리입니다.");
		}else {
			System.out.println(languagesFolder.getAbsolutePath() + "는 파일입니다.");
		}
		
		// File.separator => 운용체제별 하위 폴더 구분자
		File javaFolder = new File(languagesFolder.getAbsolutePath() + File.separator +"Java");
		if(javaFolder.isDirectory()){
			System.out.println(javaFolder.getAbsolutePath() + "는 디렉토리입니다.");
		}else {
			System.out.println(javaFolder.getAbsolutePath() + "는 파일입니다.");
		}
		
		//javaFolder안에 있는 내용물들을 가져옴
		String[] contents = javaFolder.list();
		
		for(String content : contents){
			System.out.println(content);
		}
		
		
		
	}
}
