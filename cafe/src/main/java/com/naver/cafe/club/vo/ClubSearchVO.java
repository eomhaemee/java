package com.naver.cafe.club.vo;

public class ClubSearchVO {
	/**
	 * paging조건
	 */
	// pageNo type을 String을 변경 pageNo = null or 공백이면
	private String pageNo;
	private int endArticleNumber;
	private int startArticleNumber;
	/**
	 * 검색조건
	 */
	private String menuId;
	private String searchType;
	private String keyword;
	private String articleId;

	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getPageNo() {
		return pageNo;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	public int getEndArticleNumber() {
		return endArticleNumber;
	}

	public void setEndArticleNumber(int endArticleNumber) {
		this.endArticleNumber = endArticleNumber;
	}

	public int getStartArticleNumber() {
		return startArticleNumber;
	}

	public void setStartArticleNumber(int startArticleNumber) {
		this.startArticleNumber = startArticleNumber;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

}
