package com.naver.cafe.club.service;

import java.util.HashMap;
import java.util.Map;

import com.naver.cafe.club.biz.ClubBiz;
import com.naver.cafe.club.vo.ClubListVO;
import com.naver.cafe.club.vo.ClubSearchVO;
import com.naver.cafe.club.vo.ClubVO;
import com.naver.cafe.menu.biz.MenuBiz;
import com.naver.cafe.menu.vo.MenuSearchVO;
import com.naver.cafe.reply.biz.ReplyBiz;
import com.naver.cafe.reply.vo.ReplyVO;

public class ClubServiceImpl implements ClubService {
	
	private MenuBiz menuBiz;
	private ClubBiz clubBiz;
	private ReplyBiz replyBiz;
	
	
	public void setMenuBiz(MenuBiz menuBiz) {
		this.menuBiz = menuBiz;
	}

	public void setClubBiz(ClubBiz clubBiz) {
		this.clubBiz = clubBiz;
	}

	public void setReplyBiz(ReplyBiz replyBiz) {
		this.replyBiz = replyBiz;
	}
	
	@Override
	public ClubListVO getAllClub(ClubSearchVO clubSearchVO) {
		//ClubListVO clubListVO = new ClubListVO();
		ClubListVO clubListVO = clubBiz.getAllClub(clubSearchVO);
		
		MenuSearchVO menuSearchVO  = new MenuSearchVO(); 
		//TODO 나중에 session으로 제어 하자
		menuSearchVO.setAuth("USR");
		
		clubListVO.setMenuList(menuBiz.getAllMenu(menuSearchVO));
		
		//클릭해서 보고있는 현재 메뉴 정보가져오기
		//MenuList 한 이후에 아래 실행해야 겠군.. 
		menuSearchVO.setMenuId(clubSearchVO.getMenuId());
		clubListVO.setCurruntMenu(menuBiz.getAllMenu(menuSearchVO));
		
		return clubListVO;
	}

	@Override
	public boolean addNewClub(ClubVO newClub) {
		return clubBiz.addNewClub(newClub);
	}

	@Override
	public Map<String,Object> getOneClub(ClubSearchVO clubSearchVO) {
		
		//reply넣기
		ClubVO clubVO  = clubBiz.getOneClub(clubSearchVO);
		clubVO.setReplyVO(replyBiz.getAllReplies(clubSearchVO.getArticleId()));
		
		Map<String,Object> club = new HashMap<String,Object>();
		
		club.put("club", clubBiz.getOneClub(clubSearchVO));
		
		//메뉴 넣기
		MenuSearchVO menuSearchVO  = new MenuSearchVO(); 
		menuSearchVO.setAuth("USR");
		club.put("menu", menuBiz.getAllMenu(menuSearchVO));
		//현재 page넣기
		menuSearchVO.setMenuId(clubSearchVO.getMenuId());
		club.put("currentMenu", menuBiz.getAllMenu(menuSearchVO));
		//reply넣기
		//club.put("reply", replyBiz.getAllReplies(clubSearchVO.getArticleId()));
		return club;
	}

	@Override
	public boolean addReadCount(ClubSearchVO clubSearchVO) {
		// TODO Auto-generated method stub
		return clubBiz.addReadCount(clubSearchVO);
	}

	@Override
	public boolean writeReply(ReplyVO replyVO) {
		// TODO Auto-generated method stub
		return replyBiz.writeReply(replyVO);
	}


	
}
