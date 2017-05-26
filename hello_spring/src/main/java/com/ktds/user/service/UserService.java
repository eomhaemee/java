package com.ktds.user.service;

import java.util.List;

import com.ktds.user.vo.UsersVO;

public interface UserService {
	public List<UsersVO> selectAllUsers();
	public UsersVO selectOneUsers(UsersVO usersVO);
	public boolean insertUsers(UsersVO usersVO);
	public void printMessage();
}
