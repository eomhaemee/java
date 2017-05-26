package com.naver.cafe.club.biz;

import com.naver.cafe.club.vo.ClubListVO;
import com.naver.cafe.club.vo.ClubSearchVO;
import com.naver.cafe.club.vo.ClubVO;

public interface ClubBiz {
	public ClubListVO getAllClub(ClubSearchVO clubSearchVO);
	
	public boolean addNewClub(ClubVO newClub);
	
	public ClubVO getOneClub(ClubSearchVO clubSearchVO);
	
	public boolean addReadCount(ClubSearchVO clubSearchVO);
}
