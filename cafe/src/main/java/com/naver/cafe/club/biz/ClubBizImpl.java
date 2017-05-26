package com.naver.cafe.club.biz;

import com.naver.cafe.club.dao.ClubDao;
import com.naver.cafe.club.vo.ClubListVO;
import com.naver.cafe.club.vo.ClubSearchVO;
import com.naver.cafe.club.vo.ClubVO;

public class ClubBizImpl implements ClubBiz {

	private ClubDao clubDao;
	
	public void setClubDao(ClubDao clubDao) {
		this.clubDao = clubDao;
	}

	@Override
	public ClubListVO getAllClub(ClubSearchVO clubSearchVO) {
		
		int totalCount = clubDao.selectAllClubCount(clubSearchVO);
		ClubListVO clubListVO = new ClubListVO();
		
		clubListVO.getPager().setPageNumber(clubSearchVO.getPageNo());
		clubListVO.getPager().setTotalArticleCount(totalCount);

		clubSearchVO.setEndArticleNumber(clubListVO.getPager().getEndArticleNumber());
		clubSearchVO.setStartArticleNumber(clubListVO.getPager().getStartArticleNumber());
		
		if ( totalCount > 0 ){
			clubListVO.setClubList(clubDao.selectAllClub(clubSearchVO));
		}
		
		return clubListVO;
	}

	@Override
	public boolean addNewClub(ClubVO newClub) {
		return clubDao.insertNewClub(newClub) >0 ;
	}

	@Override
	public ClubVO getOneClub(ClubSearchVO clubSearchVO) {
		return clubDao.selectOneClub(clubSearchVO);
	}

	@Override
	public boolean addReadCount(ClubSearchVO clubSearchVO) {
		return clubDao.updateReadCount(clubSearchVO) > 0 ;
	}

	
}
