package com.ktsd.ehm;

public class StandMain {

	public static void main(String[] args){
		
		Stand stand = new Stand();
		
		//stand.light = 10;
		stand.brightnessControlUp();
		stand.brightnessControlDown();
		
		stand.on();
		
		stand.brightnessControlUp();
		stand.brightnessControlDown();
		
		stand.off();
		
	}
}
