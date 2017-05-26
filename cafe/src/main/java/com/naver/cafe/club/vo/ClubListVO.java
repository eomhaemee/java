package com.naver.cafe.club.vo;

import java.util.List;

import com.naver.cafe.common.web.pager.Pager;
import com.naver.cafe.common.web.pager.PagerFactory;
import com.naver.cafe.menu.vo.MenuVO;

public class ClubListVO {

	private List<ClubVO> clubList;
	private List<MenuVO> menuList;
	private Pager pager;
	//private MenuVO curruntMenu; 현재 메뉴를 계층형으로 보여주자.=>  type list로 변경
	private List<MenuVO> curruntMenu;
	
	public List<MenuVO> getCurruntMenu() {
		return curruntMenu;
	}
	public void setCurruntMenu(List<MenuVO> curruntMenu) {
		this.curruntMenu = curruntMenu;
	}
	public List<ClubVO> getClubList() {
		return clubList;
	}
	public void setClubList(List<ClubVO> clubList) {
		this.clubList = clubList;
	}
	public List<MenuVO> getMenuList() {
		return menuList;
	}
	public void setMenuList(List<MenuVO> menuList) {
		this.menuList = menuList;
	}
	public Pager getPager() {
		if( pager == null ){
			pager = PagerFactory.getPager(Pager.ORACLE);
		}
		return pager;
	}
	public void setPager(Pager pager) {
		this.pager = pager;
	}
	
	
}
