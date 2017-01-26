package com.ktds.ehm.make;

import java.io.File;

public class MakeDirectory {
	public void start(){
		String directoryPath = "D:\\game";
		
		//folder만들기
		File game = new File(directoryPath);
		
		//파일,폴더 생성시는 존재하는지 여부 체크
		if(!game.exists()){
			game.mkdir();
		}
		
		//game.mkdirs();
	}
	
	public static void main(String[] args){
		new MakeDirectory().start();
	}
}
