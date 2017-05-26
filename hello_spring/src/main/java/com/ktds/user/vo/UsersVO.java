package com.ktds.user.vo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;


public class UsersVO {
	@NotEmpty(message="ID를 입력하세요.")
	private String userId;
	private String userName;
	@NotEmpty(message="비밀번호를 입력하세요")
	@Length(min=8,message="비밀번호는 8자리 이상입니다.")
	private String userPassword;
	
	private String joinDate;
	
	private int loginFailCount;
	private String isLock;
	private String latestTryLoginDate;
	private int lockCount;
	private String salt;
	
	public int getLoginFailCount() {
		return loginFailCount;
	}
	public void setLoginFailCount(int loginFailCount) {
		this.loginFailCount = loginFailCount;
	}
	public String getIsLock() {
		return isLock;
	}
	public void setIsLock(String isLock) {
		this.isLock = isLock;
	}
	public String getLatestTryLoginDate() {
		return latestTryLoginDate;
	}
	public void setLatestTryLoginDate(String latestTryLoginDate) {
		this.latestTryLoginDate = latestTryLoginDate;
	}
	public int getLockCount() {
		return lockCount;
	}
	public void setLockCount(int lockCount) {
		this.lockCount = lockCount;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	
	
	
	
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	
}
