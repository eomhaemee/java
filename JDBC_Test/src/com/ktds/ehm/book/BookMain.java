package com.ktds.ehm.book;

import com.ktds.ehm.book.biz.BookBiz;
import com.ktds.ehm.book.biz.BookBizImpl;

public class BookMain {
	public void start(){
		BookBiz bkbiz = new BookBizImpl();
		bkbiz.printAllBook();
	}
	public static void main(String[] args) {
		new BookMain().start();
	}
}
