package com.naver.book.author.biz;

import com.naver.book.author.vo.AuthorListVO;
import com.naver.book.author.vo.AuthorSearchVO;
import com.naver.book.author.vo.AuthorVO;

public interface AuthorBiz {
	public boolean addNewAuthor(AuthorVO authorVO);
	public AuthorListVO getAllAuthor(AuthorSearchVO authorSearchVO);
}
