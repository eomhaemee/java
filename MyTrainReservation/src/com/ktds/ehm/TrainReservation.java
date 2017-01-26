package com.ktds.ehm;

import java.util.Scanner;

public class TrainReservation {

	private int[][] seat = new int[2][10];
	private int selectedSeatRow;
	private int selectedSeatColumn;
	private int selectedMenu;

	public int[][] getSeat() {
		return seat;
	}

	public void setSeat(int[][] seat) {
		this.seat = seat;
	}

	public int getSelectedSeatRow() {
		return selectedSeatRow;
	}

	public void setSelectedSeatRow(int selectedSeatRow) {
		this.selectedSeatRow = selectedSeatRow;
	}

	public int getSelectedSeatColumn() {
		return selectedSeatColumn;
	}

	public void setSelectedSeatColumn(int selectedSeatColumn) {
		this.selectedSeatColumn = selectedSeatColumn;
	}

	public int getSelectedMenu() {
		return selectedMenu;
	}

	public void setSelectedMenu(int selectedMenu) {
		this.selectedMenu = selectedMenu;
	}

	// 메뉴 보여주기
	public void selectMenu() {
		while (true) {
			System.out.println("==========[기차 좌석 메뉴]==========");
			System.out.println("1.예약 | 2.예약취소 | 3.프로그램 종료 ");
			System.out.println("================================");

			Scanner input = new Scanner(System.in);
			setSelectedMenu(input.nextInt());

			// 예약하기
			if (this.selectedMenu == 1) {
				chageSeat();
				// 취소하기
			} else if (this.selectedMenu == 2) {
				chageSeat();
				// 종료
			} else if (this.selectedMenu == 3) {
				break;
				// 잘못눌렀군 다시 입력
			} else {
				System.out.println("1 ,2 ,3 중에 입력하렴..");

			}
		}

	}

	// 좌석변경시작
	public void chageSeat() {
		// 좌석현황보여주기
		showSeatStatus();
		//showSeatStatus1();
		
		// 좌석입력하기
		enterSeat();
		
		// 선택된좌석 보여주기
		showSelectedSeat();
		//showSelectedSeat1();
		
		// 예매,예매취소 시키기
		reservationOrCancel();
		
		// 좌석현황보여주기
		showSeatStatus();
		//showSeatStatus1();
	}

	// 좌석현황보여주기
	public void showSeatStatus() {
		System.out.println("=======[좌석현황]=======");
		for (int i = 0; i < seat.length; i++) {
			for (int j = 0; j < seat[i].length; j++) {
				if (seat[i][j] == 1) {
					System.out.print(" ■ ");
				} else {
					System.out.print(" □ ");
				}
			}
			System.out.println();
		}
		System.out.println("======================");
	}

	// 영화관 자리 예매용 seat
	public void showSeatStatus1() {
		System.out.println("=======[좌석현황]=======");
		String seatMark1 = "";
		String seatMark2 = "";
		for (int i = 0; i < seat.length; i++) {

			for (int j = 0; j < seat[i].length; j++) {
				seatMark1 = "";
				// 복도자리
				if (j == 2 || j == 7) {
					seatMark1 = "  ";
				}
				if (seat[i][j] == 1) {
					seatMark2 = "■";
				} else {
					seatMark2 = "□";
				}
				System.out.print(seatMark1 + seatMark2);
			}
			System.out.println();
		}
		System.out.println("======================");
	}

	// 사용자가 좌석입력하기
	public void enterSeat() {

		while (true) {
			System.out.println("좌석을 선택하세요 [행(0~1),열(0~10)] 순서로 두번입력");
			Scanner input = new Scanner(System.in);

			setSelectedSeatRow(input.nextInt());
			setSelectedSeatColumn(input.nextInt());

			// [예약]인경우 이미 예약된 자리인지 확인
			if (getSelectedMenu() == 1) {
				if (isReservedCheck()) {
					System.out.println("예약된 자리입니다. 다른 자리를 선택하세요.");
				} else {
					break;
				}
			} else {
				if (isReservedCheck()) {
					System.out.println("예약되지 않은 자리 입니다. 취소할 좌석을 다시 확인하세요");
				} else {
					break;
				}
			}

		}
	}

	// 선택한 좌석 예약 or 취소가능한지 확인
	public boolean isReservedCheck() {
		boolean isCheck;
		int i = getSelectedSeatRow();
		int j = getSelectedSeatColumn();
		// 예약시확인
		if (getSelectedMenu() == 1) {
			if (seat[i][j] == 1) {
				isCheck = true;
			} else {
				isCheck = false;
			}
			// 취소시확인
		} else {
			if (seat[i][j] == 0) {
				isCheck = true;
			} else {
				isCheck = false;
			}
		}

		return isCheck;
	}

	// 선택한 좌석 보여주기
	public void showSelectedSeat() {

		System.out.println("=====[선택하신자리]=====");
		for (int i = 0; i < seat.length; i++) {
			for (int j = 0; j < seat[i].length; j++) {

				if (i == this.selectedSeatRow && j == this.selectedSeatColumn) {
					System.out.print(" * ");
				} else {
					if (seat[i][j] == 1) {
						System.out.print(" ■ ");
					} else {
						System.out.print(" □ ");
					}
				}

			}
			System.out.println();
		}
		System.out.println("======================");
	}

	// 영화관용 선택한 좌석 보여주기
	public void showSelectedSeat1() {
		String seatMark1 = "";
		String seatMark2 = "";

		System.out.println("=====[선택하신자리]=====");
		for (int i = 0; i < seat.length; i++) {
			for (int j = 0; j < seat[i].length; j++) {
				seatMark1 = "";
				// 복도자리
				if (j == 2 || j == 7) {
					seatMark1 = "  ";
				} else {
					if (i == this.selectedSeatRow && j == this.selectedSeatColumn) {
						System.out.print("*");
					} else {
						if (seat[i][j] == 1) {
							System.out.print("■");
						} else {
							System.out.print("□");
						}
					}
				}
				System.out.print(seatMark1 + seatMark2);

			}
			System.out.println();
		}
		System.out.println("======================");
	}

	public void reservationOrCancel() {

		if (getSelectedMenu() == 1) {
			System.out.println("선택하신 좌석으로 예약 하시겠습니까?(1:네 / 2:좌석 다시 선택하기)");
		} else {
			System.out.println("선택하신 좌석을 예약취소 하시겠습니까?(1:네 / 2:좌석 다시 선택하기)");
		}

		Scanner input = new Scanner(System.in);
		int confirmSeat = input.nextInt();
		// 좌석 상태변경
		if (confirmSeat == 1) {
			changeSeatStatus();
			// 좌석 다시 선택
		} else if (confirmSeat == 2) {
			chageSeat();
		} else {
			System.out.println("1:진행하기/2:좌석 다시 선택하기|<= 숫자 두개만 입력가능해 잘좀 입력하렴");
		}

	}

	// 좌석상태변경하기
	public void changeSeatStatus() {

		int i = getSelectedSeatRow();
		int j = getSelectedSeatColumn();
		// 예약이면 1
		if (getSelectedMenu() == 1) {
			seat[i][j] = 1;

		} else {
			// 취소이면 0
			seat[i][j] = 0;
		}

	}

}
