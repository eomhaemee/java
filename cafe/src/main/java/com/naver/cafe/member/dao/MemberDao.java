package com.naver.cafe.member.dao;

import com.naver.cafe.member.vo.MemberVO;

public interface MemberDao {
	public static final String NS = "MemberDao";

	public int insertMember(MemberVO memberVO);
}
