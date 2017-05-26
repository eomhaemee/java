package com.ktds.user.service;

import java.util.List;

import com.ktds.commons.util.SHA256Util;
import com.ktds.user.biz.UserBiz;
import com.ktds.user.vo.UsersVO;

public class UserServiceImpl implements UserService {
	private UserBiz userBiz;
	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}
	
	@Override
	public List<UsersVO> selectAllUsers() {
		// TODO Auto-generated method stub
		return userBiz.selectAllUsers();
	}

	@Override
	public UsersVO selectOneUsers(UsersVO usersVO) {
		
		return userBiz.selectOneUsers(usersVO);
	}

	@Override
	public boolean insertUsers(UsersVO usersVO) {
		
		//pw암호화 알고리즘 적용
		String salt = SHA256Util.generateSalt();
		usersVO.setSalt(salt);
		
		String password = usersVO.getUserPassword();
		password = SHA256Util.getEncrypt(password, salt);
		usersVO.setUserPassword(password);

		return userBiz.insertUsers(usersVO);
	}

	@Override
	public void printMessage() {
		System.out.println("service...");
		
	}

}
