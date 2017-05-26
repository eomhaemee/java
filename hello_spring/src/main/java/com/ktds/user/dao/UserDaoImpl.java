package com.ktds.user.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ktds.user.vo.UsersVO;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

	@Override
	public List<UsersVO> selectAllUsers() {
		return getSqlSession().selectList("UserDao.selectAllUsers");

	}

	@Override
	public UsersVO selectOneUsers(UsersVO usersVO) {
		return getSqlSession().selectOne("UserDao.selectOneUsers", usersVO);

	}

	@Override
	public int insertUsers(UsersVO usersVO) {
		return getSqlSession().insert("UserDao.insertUsers", usersVO);

	}

	@Override
	public String getSaltById(String id) {
		return getSqlSession().selectOne("UserDao.getSaltById",id);
	}

	@Override
	public int selectLockStatus(String userId) {
		return getSqlSession().selectOne("UserDao.selectLockStatus", userId);
	}

	@Override
	public int updateClearLoginFailCount(String userId) {
		return getSqlSession().update("UserDao.updateClearLoginFailCount",userId);
	}

	@Override
	public int updateClearLockCount(String userId) {
		return getSqlSession().update("UserDao.updateClearLockCount",userId);
	}

	@Override
	public int plusLoginFaileCount(String userId) {
		return getSqlSession().update("UserDao.plusLoginFaileCount",userId);
	}

	@Override
	public int updateLockStatus(String userId) {
		return getSqlSession().update("UserDao.updateLockStatus", userId);
	}
}
