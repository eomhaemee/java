package com.naver.cafe.club.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.naver.cafe.club.vo.ClubSearchVO;
import com.naver.cafe.club.vo.ClubVO;

public class ClubDaoImpl extends SqlSessionDaoSupport implements ClubDao {

	@Override
	public int selectAllClubCount(ClubSearchVO clubSearchVO) {
		return getSqlSession().selectOne(NS + ".selectAllClubCount", clubSearchVO);
	}

	@Override
	public List<ClubVO> selectAllClub(ClubSearchVO clubSearchVO) {
		return getSqlSession().selectList(NS + ".selectAllClub", clubSearchVO);
	}

	@Override
	public int insertNewClub(ClubVO newClub) {
		// TODO Auto-generated method stub
		return getSqlSession().insert(NS+".insertNewClub",newClub);
	}

	@Override
	public ClubVO selectOneClub(ClubSearchVO clubSearchVO) {
		return getSqlSession().selectOne(NS + ".selectOneClub", clubSearchVO);
	}

	@Override
	public int updateReadCount(ClubSearchVO clubSearchVO) {
		// TODO Auto-generated method stub
		return getSqlSession().update(NS + ".updateReadCount",clubSearchVO);
	}

}
