package com.ktds.ehm;

public class Recursion {

	public void call(int index) {
		System.out.println("Recursion.Call() 호출중..: " + index);

		if (index >= 0) {
			call(--index);
		}

	}
}
