package com.ktds.ehm.user.service;

import java.util.List;

import com.ktds.ehm.user.biz.UserBiz;
import com.ktds.ehm.user.vo.UsersVO;

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
		// TODO Auto-generated method stub
		return userBiz.selectOneUsers(usersVO);
	}

	@Override
	public boolean insertUsers(UsersVO usersVO) {
		// TODO Auto-generated method stub
		return userBiz.insertUsers(usersVO);
	}


}
