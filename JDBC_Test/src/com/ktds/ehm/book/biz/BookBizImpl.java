package com.ktds.ehm.book.biz;

import java.util.List;

import com.ktds.ehm.book.dao.BookDao;
import com.ktds.ehm.book.dao.BookDaoImpl;
import com.ktds.ehm.book.vo.BookVO;

public class BookBizImpl implements BookBiz {

	private BookDao bkDao;
	
	
	public BookBizImpl() {
		bkDao = new BookDaoImpl();
	}

	@Override
	public void printAllBook() {
		 List<BookVO> books = bkDao.getBooks();
		 for (BookVO bookVO : books) {
			//System.out.printf("%d\t%s\t%s\t%s\t%s\t%d\t%t\t%s",
			System.out.printf("%d\t%s\t%s\t%s\t%s\t%d\t%s\t%s\t\n",
					bookVO.getBkId(),
					bookVO.getBkNm(),
					bookVO.getBkCntntIdx(),
					bookVO.getWrtr(),
					bookVO.getPblshr(),
					bookVO.getPrice(),
					bookVO.getPblshingDate(),
					bookVO.getReview()
					);
		}
		
	}

	
	
}
