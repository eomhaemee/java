package com.ktds.user.dao;

import java.util.List;

import com.ktds.user.vo.UsersVO;

public interface UserDao {
	public List<UsersVO> selectAllUsers();
	public UsersVO selectOneUsers(UsersVO usersVO);
	public int insertUsers(UsersVO usersVO);
	
	public String getSaltById(String id);
	public int selectLockStatus(String userId);
	public int updateClearLoginFailCount(String userId);
	public int updateClearLockCount(String userId);
	public int plusLoginFaileCount(String userId);
	public int updateLockStatus(String userId);
	
}
