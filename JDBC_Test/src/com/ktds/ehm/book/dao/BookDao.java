package com.ktds.ehm.book.dao;

import java.util.List;

import com.ktds.ehm.book.vo.BookVO;

public interface BookDao {
	public List<BookVO> getBooks();
}
