package com.ktds.board.vo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import com.ktds.user.vo.UsersVO;

public class BoardVO {
	
	
	private int boardId;
	
	@NotEmpty(message="제목를 입력하세요")
	@Length(min=10, message="제목은 최소 10 글자 이상을 작성하세요")
	private String subject;
	
	@NotEmpty(message="내용을 입력하세요")
	@Length(min=10,message="내용은 최소 10글자 이상을 작성하세요")
	private String content;
	
	private String writer;
	private int likeCount;
	private String writeDate;
	private String ip;
	private String post;
	private String realFileName;
	private String displayFileName;
	
	private UsersVO userVO;
	
	private MultipartFile file;
	
	private String csrf_token;
	
	
	public String getCsrf_token() {
		return csrf_token;
	}
	public void setCsrf_token(String csrf_token) {
		this.csrf_token = csrf_token;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
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
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public UsersVO getUserVO() {
		return userVO;
	}
	public void setUserVO(UsersVO userVO) {
		this.userVO = userVO;
	}
	public String getRealFileName() {
		return realFileName;
	}
	public void setRealFileName(String realFileName) {
		this.realFileName = realFileName;
	}
	public String getDisplayFileName() {
		return displayFileName;
	}
	public void setDisplayFileName(String displayFileName) {
		this.displayFileName = displayFileName;
	}
	
	
}
