package com.ktds.ehm.user.dao;

import java.util.List;

import com.ktds.ehm.user.vo.UsersVO;

public interface UserDao {
	public List<UsersVO> selectAllUsers();
	public UsersVO selectOneUsers(UsersVO usersVO);
	public int insertUsers(UsersVO usersVO);
}
