package com.ktsd.ehm;

public class Stand {

	private String button = "스위치";
	private String lamp = "전구";
	private String elec = "전기";
	
	private int light = 0;

	public void on() {
		// printf = String.format 의 기능을 함 뉴라인 기능이 없어서 \n해줌
		System.out.printf("%s가 들어옵니다.\n", elec);
		System.out.println("스탠드를 켭니다.");
		light = 5;

		String message = String.format("%s를 눌러서 %s를 켭니다.", button, lamp);
		System.out.println(message);

		message = String.format("밝기는 %d입니다.", light);
		System.out.println(message);
	}

	public void off() {
		light = 0;
	}

	public void brightnessControlUp() {
		if (light > 0) {
			light++;
			System.out.printf("밝기를 올립니다..밝기는 %d입니다.\n", light);
		}else{
			System.out.println("전원이 꺼져있습니다.");
		}
			
	}

	public void brightnessControlDown() {
		if (light > 0) {
			light--;
			System.out.printf("밝기를 내립니다..밝기는 %d입니다.\n", light);
		}else{
			System.out.println("전원이 꺼져있습니다.");
		}
	}

}
