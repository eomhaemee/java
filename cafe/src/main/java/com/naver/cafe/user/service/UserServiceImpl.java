package com.naver.cafe.user.service;

import java.util.List;

import com.naver.cafe.common.util.SHA256Util;
import com.naver.cafe.member.biz.MemberBiz;
import com.naver.cafe.member.vo.MemberVO;
import com.naver.cafe.user.biz.UserBiz;
import com.naver.cafe.user.vo.UsersVO;

public class UserServiceImpl implements UserService {
	private UserBiz userBiz;
	private MemberBiz memberBiz;
	
	public void setMemberBiz(MemberBiz memberBiz) {
		this.memberBiz = memberBiz;
	}
	
	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}
	
	@Override
	public List<UsersVO> selectAllUsers() {
		// TODO Auto-generated method stub
		return userBiz.selectAllUsers();
	}

	@Override
	public UsersVO selectOneUsers(UsersVO usersVO) {
		
		return userBiz.selectOneUsers(usersVO);
	}

	@Override
	public boolean insertUsers(UsersVO usersVO) {
		
		//pw암호화 알고리즘 적용
		String salt = SHA256Util.generateSalt();
		usersVO.setSalt(salt);
		
		String inputPassword = usersVO.getUserPassword();
		String password = SHA256Util.getEncrypt(inputPassword, salt);
		usersVO.setUserPassword(password);
		
		//member에도 넣어줘서 sql건드리지 않게 수정하자..
		MemberVO memberVO = new MemberVO();
		memberVO.setMemberId(usersVO.getUserId());
		memberVO.setMemberPassword(inputPassword);
		memberVO.setNickName(usersVO.getUserName());
		
	System.out.println("usersVO.getUserId()" + usersVO.getUserId() + "password" + inputPassword);	
	
		memberBiz.registMember(memberVO);
		
		return userBiz.insertUsers(usersVO);
	}

	@Override
	public void printMessage() {
		System.out.println("service...");
		
	}

}
