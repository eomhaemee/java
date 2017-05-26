package com.naver.cafe.member.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.naver.cafe.member.vo.MemberVO;

public class MemberDaoImpl extends SqlSessionDaoSupport implements MemberDao {

	@Override
	public int insertMember(MemberVO memberVO) {
		return getSqlSession().insert(NS + ".insertMember",memberVO);
	}

}
