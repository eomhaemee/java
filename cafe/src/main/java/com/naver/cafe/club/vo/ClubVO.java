package com.naver.cafe.club.vo;

import java.util.List;

import com.naver.cafe.member.vo.MemberVO;
import com.naver.cafe.menu.vo.MenuVO;
import com.naver.cafe.reply.vo.ReplyVO;

public class ClubVO {
	private String articleId;
	private String subject;
	private String content;
	private String memberId;
	private String createdDate;
	private String modifiedDate;
	private int readCount;
	private String menuId;

	private MemberVO memberVO;
	private MenuVO menuVO;
	private List<ReplyVO> replyVO;
	private int repliesCount;
	
	private String csrf_token;
	
	

	public String getCsrf_token() {
		return csrf_token;
	}

	public void setCsrf_token(String csrf_token) {
		this.csrf_token = csrf_token;
	}

	public int getRepliesCount() {
		return repliesCount;
	}

	public void setRepliesCount(int repliesCount) {
		this.repliesCount = repliesCount;
	}

	public List<ReplyVO> getReplyVO() {
		return replyVO;
	}

	public void setReplyVO(List<ReplyVO> replyVO) {
		this.replyVO = replyVO;
	}

	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public MemberVO getMemberVO() {
		return memberVO;
	}

	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}

	public MenuVO getMenuVO() {
		return menuVO;
	}

	public void setMenuVO(MenuVO menuVO) {
		this.menuVO = menuVO;
	}

}
