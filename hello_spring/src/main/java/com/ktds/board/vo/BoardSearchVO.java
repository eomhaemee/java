package com.ktds.board.vo;

public class BoardSearchVO {
	/*pager는 List로 보내자 여기 있으면 mybtis가 읽어내지 못한데*/
	/*private Pager pager;*/
	
	private int endArticleNumber;
	private int startArticleNumber;
	
	/*pageNo, keyword가 jsp에서 넘어오므로BoardSearchVO 로 받을수 있게 선언해주자 */
	private int pageNo;
	private String keyword;
	private String writer;
	private String content;
	
	
	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		if (keyword == null){
			System.out.println("키워드가 null");
		}
		this.keyword = keyword;
	}
	
	
}

