package com.ktds.ehm.user.service;

import java.util.List;

import com.ktds.ehm.user.vo.UsersVO;

public interface UserService {
	public List<UsersVO> selectAllUsers();
	public UsersVO selectOneUsers(UsersVO usersVO);
	public boolean insertUsers(UsersVO usersVO);

}
