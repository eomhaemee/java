package com.ktds.ehm.make;

import java.io.File;

public class MakeDirectories {
	public void start(){
		String directoryPath = "D:\\game\\mobile\\poketmon\\go";
		
		//folder만들기
		File game = new File(directoryPath);
		//game.mkdir();
		
		//하위폴더까지 생성해서 전체를 만들떄 사용
		//파일,폴더 생성시는 존재하는지 여부 체크
		if(!game.exists()){
			game.mkdirs();
		}
		
	}
	
	public static void main(String[] args){
		new MakeDirectories().start();
	}
}
