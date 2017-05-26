package com.naver.cafe.user.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.naver.cafe.user.vo.UsersVO;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

	@Override
	public List<UsersVO> selectAllUsers() {
		return getSqlSession().selectList(NS + ".selectAllUsers");

	}

	@Override
	public UsersVO selectOneUsers(UsersVO usersVO) {
		return getSqlSession().selectOne(NS +".selectOneUsers", usersVO);

	}

	@Override
	public int insertUsers(UsersVO usersVO) {
		return getSqlSession().insert(NS +".insertUsers", usersVO);

	}

	@Override
	public String getSaltById(String id) {
		return getSqlSession().selectOne(NS +".getSaltById",id);
	}

	@Override
	public int selectLockStatus(String userId) {
		return getSqlSession().selectOne(NS +".selectLockStatus", userId);
	}

	@Override
	public int updateClearLoginFailCount(String userId) {
		return getSqlSession().update(NS +".updateClearLoginFailCount",userId);
	}

	@Override
	public int updateClearLockCount(String userId) {
		return getSqlSession().update(NS +".updateClearLockCount",userId);
	}

	@Override
	public int plusLoginFaileCount(String userId) {
		return getSqlSession().update(NS +".plusLoginFaileCount",userId);
	}

	@Override
	public int updateLockStatus(String userId) {
		return getSqlSession().update(NS +".updateLockStatus", userId);
	}
}
