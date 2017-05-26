package com.naver.book.book.vo;

import java.util.List;

import com.naver.book.author.vo.AuthorVO;
import com.naver.book.publisher.vo.PublisherVO;

public class BookVO {
	private String bookId;
	private String bookName;
	private String bookSubName;
	private String realseDate;
	private String isbn;
	private int price;
	private String introduce;
	private String index;
	
	private AuthorVO authorVO;
	private PublisherVO pulisherVO;
	
	private List<AuthorVO> authorList;
	private List<PublisherVO> publisherList;
	
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookSubName() {
		return bookSubName;
	}
	public void setBookSubName(String bookSubName) {
		this.bookSubName = bookSubName;
	}
	public String getRealseDate() {
		return realseDate;
	}
	public void setRealseDate(String realseDate) {
		this.realseDate = realseDate;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public AuthorVO getAuthorVO() {
		return authorVO;
	}
	public void setAuthorVO(AuthorVO authorVO) {
		this.authorVO = authorVO;
	}
	public PublisherVO getPulisherVO() {
		return pulisherVO;
	}
	public void setPulisherVO(PublisherVO pulisherVO) {
		this.pulisherVO = pulisherVO;
	}
	public List<AuthorVO> getAuthorList() {
		return authorList;
	}
	public void setAuthorList(List<AuthorVO> authorList) {
		this.authorList = authorList;
	}
	public List<PublisherVO> getPublisherList() {
		return publisherList;
	}
	public void setPublisherList(List<PublisherVO> publisherList) {
		this.publisherList = publisherList;
	}

	/*bookVO.setAuthorList(authorListVO.getAuthorList());*/
	
}
