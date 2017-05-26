package com.naver.cafe.user.biz;

import java.util.List;

import com.naver.cafe.user.vo.UsersVO;

public interface UserBiz {
	public List<UsersVO> selectAllUsers();
	public UsersVO selectOneUsers(UsersVO usersVO);
	public boolean insertUsers(UsersVO usersVO);
	
	public String getSaltById(String id);
	
}
