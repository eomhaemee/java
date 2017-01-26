package com.ktds.ehm;

import java.util.Scanner;

/**
 * 
 * @author Admin
 *
 */
public class TranReservation {

	private int[][] seat = new int[2][10];

	// 메뉴 보여주기
	public void selectMenu() {
		System.out.println("기차 좌석 메뉴");
		System.out.println("1.예약 2.예약취소 3.프로그램 종료 ");
		Scanner input = new Scanner(System.in);
		int selectedMenu = input.nextInt();

		while (true) {
			// 예약하기
			if (selectedMenu == 1) {
				reservation();
				// 취소하기
			} else if (selectedMenu == 2) {
				cancel();
				// 종료
			} else if (selectedMenu == 3) {
				break;
				// 잘못눌렀군 다시 입력
			} else {
				System.out.println("1 2 3 중에 입력하렴..");
			}
		}

	}

	// 좌석현황보여주기
	public void showSetStatus() {
		for (int i = 0; i < seat.length; i++) {
			for (int j = i; i < seat[i].length; j++) {
				if (seat[i][j] == 1) {
					System.out.print(" 1 ");
				} else {
					System.out.print(" 0 ");
				}
			}
			System.out.println();
		}
	}

	// 사용자가 좌석입력하기
	public void enterSeat() {
		System.out.println("좌석을 선택하세요 [행,열] 순서로 두번입력");
		Scanner input = new Scanner(System.in);
		int selectedSetRow = input.nextInt();
		int selectedSetColumn = input.nextInt();
		showSelectedSeat(selectedSetRow, selectedSetColumn);
	}

	// 선택한 좌석 보여주기
	public void showSelectedSeat(int selectedSetRow, int selectedSetColumn) {

		System.out.println("위의 자리로 예매하겠습니다?(1:예매하기/2:좌석 다시 선택하기)");
		Scanner input = new Scanner(System.in);
		int confirmSeat = input.nextInt();
		// 좌석 상태변경
		if (confirmSeat == 1) {
			// changeSeatStatus(selectedSetRow, selectedSetColumn );
			// 좌석 다시 선택
		} else if (confirmSeat == 2) {
			enterSeat();
		} else {
			System.out.println("1:예매하기/2:좌석 다시 선택하기|<= 숫자 두개만 입력가능해 잘좀 입력하렴");
		}

	}

	// 좌석상태변경하기
	public void changeSeatStatus(int selectedSetRow, int selectedSetColumn, int selectedMenu) {
		// 예약이면 1
		if (selectedMenu == 1) {
			seat[selectedSetRow][selectedSetColumn] = 1;
		} else {
			// 취소이면 0
			seat[selectedSetRow][selectedSetColumn] = 0;
		}
	}

	// 예약되기
	public void reservation() {
		showSetStatus();
		enterSeat();
		// changeSeatStatus();

	}

	// 취소되기
	public void cancel() {
		showSetStatus();
		enterSeat();
		// changeSeatStatus();

	}

}
