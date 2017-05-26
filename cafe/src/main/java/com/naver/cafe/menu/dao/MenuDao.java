package com.naver.cafe.menu.dao;

import java.util.List;

import com.naver.cafe.menu.vo.MenuSearchVO;
import com.naver.cafe.menu.vo.MenuVO;

public interface MenuDao {
	public static final String NS = "MenuDao";
	public List<MenuVO> selectAllMenu(MenuSearchVO menuSearchVO);
	
}
