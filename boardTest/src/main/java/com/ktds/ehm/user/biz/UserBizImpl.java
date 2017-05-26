package com.ktds.ehm.user.biz;

import java.util.List;

import com.ktds.ehm.user.dao.UserDao;
import com.ktds.ehm.user.vo.UsersVO;

public class UserBizImpl implements UserBiz{
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public List<UsersVO> selectAllUsers() {
		// TODO Auto-generated method stub
		return userDao.selectAllUsers();
	}

	@Override
	public UsersVO selectOneUsers(UsersVO usersVO) {
		// TODO Auto-generated method stub
		return userDao.selectOneUsers(usersVO);
	}

	@Override
	public boolean insertUsers(UsersVO usersVO) {
		// TODO Auto-generated method stub
		return userDao.insertUsers(usersVO) > 0 ;
	}

}
