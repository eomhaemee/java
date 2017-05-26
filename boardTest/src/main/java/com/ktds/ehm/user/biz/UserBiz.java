package com.ktds.ehm.user.biz;

import java.util.List;

import com.ktds.ehm.user.vo.UsersVO;

public interface UserBiz {
	public List<UsersVO> selectAllUsers();
	public UsersVO selectOneUsers(UsersVO usersVO);
	public boolean insertUsers(UsersVO usersVO);
}
