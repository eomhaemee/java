package com.naver.cafe.member.biz;

import com.naver.cafe.member.dao.MemberDao;
import com.naver.cafe.member.vo.MemberVO;

public class MemberBizImpl implements MemberBiz {
	private MemberDao memberDao;
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	@Override
	public boolean registMember(MemberVO memberVO) {
		return memberDao.insertMember(memberVO) >  0;
	}

}
