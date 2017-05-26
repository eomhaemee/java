package com.ktds.user.biz;

import java.util.List;
import java.util.UUID;

import com.ktds.commons.util.SHA256Util;
import com.ktds.user.dao.UserDao;
import com.ktds.user.vo.UsersVO;

public class UserBizImpl implements UserBiz {
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
		String id = usersVO.getUserId();// 아이디
		String password = usersVO.getUserPassword(); // 비번
		
		// 잠궈라
		if( userDao.selectLockStatus(id) > 0 ){
			throw new RuntimeException("잠긴 계정");
		}
		// 잠김 기간이 지나면 초기화
		userDao.updateClearLoginFailCount(id);
		
		String salt = userDao.getSaltById(id);
		
		//System.out.println("salt" + salt + "password" + password);
		
		password = SHA256Util.getEncrypt(password, salt);
		
		UsersVO user = new UsersVO();
		
		user.setUserId(id);
		user.setUserPassword(password);
		
		UsersVO userVO = userDao.selectOneUsers(user);
		
		if(userVO != null) {

			
			userDao.updateClearLockCount(userVO.getUserId());
		}
		else{			
			userDao.plusLoginFaileCount(id);
			//FAILE COUNT가 3보다 크다면 잠궈라
			userDao.updateLockStatus(id);
		}
		
		return userVO;
	}

	@Override
	public boolean insertUsers(UsersVO usersVO) {
		// TODO Auto-generated method stub
		return userDao.insertUsers(usersVO) >  0 ;
	}

	@Override
	public String getSaltById(String id) {
		// TODO Auto-generated method stub
		return userDao.getSaltById(id);
	}


}
