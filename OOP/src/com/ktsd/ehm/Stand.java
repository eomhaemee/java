package com.ktsd.ehm;

public class Stand {
	
	String button = "스위치";
	String lamp = "전구";
	String elec = "전기";
	//String light = "불빛";
	int light = 0;
	
	void on(){
		//printf = String.format 의 기능을 함 뉴라인 기능이 없어서 \n해줌 
		System.out.printf("%s가 들어옵니다.\n",elec);
		System.out.println("스탠드를 켭니다.");
		light = 5;
		
		String message = String.format("%s를 눌러서 %s를 켭니다.", button,lamp);
		System.out.println(message);
		
		message = String.format("밝기는 %d입니다.", light);
		System.out.println(message);
	}
	void off(){
		System.out.printf("%s가 꺼집니다..\n",elec);
		System.out.println("스탠드를 끕니다.");
		light = 5;
		
		String message = String.format("%s를 눌러서 %s를 끕니다.", button,lamp);
		System.out.println(message);
		
		message = String.format("밝기는 %d입니다.", light);
		System.out.println(message);
	}
	void brightnessControlUp(){
		light++;
		System.out.printf("밝기를 올립니다..밝기는 %d입니다.\n",light);
	}
	void brightnessControlDown(){
		light--;
		System.out.printf("밝기를 내립니다..밝기는 %d입니다.\n",light);
	}
	
	
}
