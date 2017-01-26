package com.ktds.ehm.explore;

import java.io.File;

public class FileSystemExplore2 {

	public void printFileSystem(String path){
		
		//1. File 객체 생성(Path정보를 가지는 파일을만듬)
		File directory = new File(path);
		
		
		//1-1.directory  안의 내용을 탐색한다.
		String[] contents = directory.list();
		for (String content : contents) {
			//해당 내용이 폴더인지 내용인지 알려면 File객체를 통해서 이므로 string 을 file 객체로 생성
			
		}
		
		//2.directory 객체의 내용이 폴더인지 파일인지 구분한다.
		if(directory.isDirectory()){
			//2-1. 폴더일 경우 폴더내부를 탐색한다.
			//printFileSystem(directory.getAbsolutePath() + File.separator );
			
			
			
		}else {
			//2-2. 파일일 경우 파일의 경로를 출력한다.
			System.out.println(directory.getAbsolutePath());
			
		}
		
		

		
		
	}
}
