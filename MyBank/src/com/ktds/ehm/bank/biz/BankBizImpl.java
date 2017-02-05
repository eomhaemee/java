package com.ktds.ehm.bank.biz;

import static com.ktds.ehm.bank.Consts.BankConst.FIRST_DEPOSIT;

import java.util.List;
import java.util.Scanner;

import com.ktds.ehm.bank.dao.BankDao;
import com.ktds.ehm.bank.dao.BankDaoImpl;
import com.ktds.ehm.bank.vo.BankVO;

public class BankBizImpl implements BankBiz {

	private BankDao bankDao;
	Scanner input;
	private BankVO bankVO;

	public BankBizImpl() {
		bankDao = new BankDaoImpl();
		input = new Scanner(System.in);
	}

	@Override
	public void bankOpen() {

		String chooseMenu = null;
		String userId = null;

		while (true) {
			printMenu();
			System.out.println("메뉴를 선택하세요");
			chooseMenu = input.next();

			if (chooseMenu.equals("1")) {
				addUser();
			} else if (chooseMenu.equals("2")) {
				if (isExistUser("ALL")) {
					getAllUser();
				} else {
					System.out.println("조회할 고객이 없습니다.");
				}
			} else if (chooseMenu.equals("3") || chooseMenu.equals("4")) {
				System.out.println("입출금할 고객을 선택하세요(rowindex)");
				int userNo = input.nextInt();
				printOneUser(userNo);

				updMoney(chooseMenu, userNo);
				// printOneUser(userNo);

			} else if (chooseMenu.equals("exit")) {
				System.out.println("작업을 마칩니다 by~");
				break;
			} else {
				System.out.println("메뉴를 다시 확인하시고 입력하세요");
			}
		}

	}

	public void printMenu() {
		System.out.println("====[은행메뉴]=====");
		System.out.println("1. 고객등록  ");
		System.out.println("2. 고객조회");
		System.out.println("3. 입금");
		System.out.println("4. 출금");
		System.out.println("exit. 종료");
		System.out.println("================");
	}

	@Override
	public boolean isExistUser(String userId) {
		boolean result = false;
		List<BankVO> userList = bankDao.getAllUser();

		if (userId.equals("ALL")) {
			if (!userList.isEmpty()) {
				result = true;
			}
		} else {
			// 동일한 ID가 있는지 확인
			for (BankVO bankVO : userList) {
				if (bankVO.getUserId().equals(userId)) {
					result = true;
					System.out.println("Id: " + userId + " 는 이미 등록된 고객입니다.");
					break;
				}
			}
		}

		return result;
	}

	@Override
	public void addUser() {

		int userMoney = 0;

		System.out.println("고객이름을 입력하세요: ");
		String name = input.next();

		System.out.println("ID를 입력하세요: ");
		String userId = input.next();

		bankVO = new BankVO();
		int bankTotalDiposit = 0;
		if (!isExistUser(userId)) {
			System.out.println("신규고객은 " + FIRST_DEPOSIT + "원이 자동 입금 됩니다.");
			userMoney = FIRST_DEPOSIT;
			bankVO.setName(name);
			bankVO.setUserId(userId);
			bankVO.setDeposit(userMoney);
			bankTotalDiposit = bankVO.getBankTotalDiposit() + userMoney;
			bankVO.setBankTotalDiposit(userMoney);
			bankDao.addUser(bankVO);
		}

	}

	@Override
	public void printOneUser(int userNo) {
		BankVO bankVO = bankDao.getOneUser(userNo);
		System.out.println("고객 이름 : " + bankVO.getName() + "고객 예치금 : " + bankVO.getDeposit());

	}

	@Override
	public void getAllUser() {
		List<BankVO> userList = bankDao.getAllUser();

		for (BankVO bankVO : userList) {
			System.out.println("고객ID : " + bankVO.getUserId() + " / 고객 이름 : " + bankVO.getName() + " / 고객 예치금 : "
					+ bankVO.getDeposit());
		}

	}

	@Override
	public void updMoney(String chooseMenu, int userNo) {

		BankVO bankVO = bankDao.getOneUser(userNo);
		bankVO.setName(bankVO.getName());
		bankVO.setUserId(bankVO.getUserId());

		//System.out.println("확인:" + bankVO.getDeposit());
		int money = 0;
		int bankTotalDiposit = 0;
		if (chooseMenu.equals("3")) {
			System.out.println("예치할 금액을 입력하세요 : ");
			money = input.nextInt();
			money += bankVO.getDeposit();
			bankTotalDiposit += bankVO.getBankTotalDiposit();
		} else {
			System.out.println("인출할 금액을 입력하세요 : ");
			money = input.nextInt();
			if (money > bankVO.getDeposit()) {
				System.out.println("인출할 잔액이 부족합니다. [ 잔액 : " + bankVO.getDeposit() + " 입력된금액 :" + money + "]");
				return;
			} else {
				money = bankVO.getDeposit() - money;
				bankTotalDiposit = bankVO.getBankTotalDiposit() - money;
			}

		}
		bankVO.setDeposit(money);
		bankVO.setBankTotalDiposit(bankTotalDiposit);
		bankDao.updMoney(userNo, bankVO);
	}
	/*
	 * else if (chooseMenu.equals("2")) { System.out.println("조회할 고객ID를 입력하세요");
	 * userId = input.next(); if (isExistUser(userId)) { printOneUser(0); } else
	 * { System.out.println("조회할 고객이 없습니다."); }
	 */
	/*
	 * System.out.println("입출금할 고객ID를 입력하세요"); userId = input.next();
	 * 
	 * //getClass().System.out.println(getUserIndex(userId));
	 * 
	 * if (isExistUser(userId)) { System.out.println("고객순번 입력"); int userNo =
	 * input.nextInt(); updMoney(chooseMenu, userNo, bankVO); } else {
	 * System.out.println("조회할 고객이 없습니다."); }
	 */
	/*
	 * 
	 * 
	 * 
	 * public int getUserIndex(String userId) { List<BankVO> userList =
	 * bankDao.getAllUser(); bankVO = new BankVO(); int a =
	 * userList.indexOf(bankVO);
	 * 
	 * System.out.println("isEmpty: "+ userList.isEmpty());
	 * System.out.println("getUserId: "+ bankVO.getUserId());
	 * 
	 * // bankDao.getOneUser(userId);
	 * System.out.println("2: "+bankVO.getName());
	 * System.out.println("TEST : "+bankVO.getUserId().equals("ehmid")); int
	 * index = userList.indexOf(bankVO.getUserId().equals(userId)); return 1; }
	 */
}
