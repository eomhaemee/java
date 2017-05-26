package com.naver.cafe.reply.biz;

import java.util.List;

import com.naver.cafe.reply.dao.ReplyDao;
import com.naver.cafe.reply.vo.ReplyVO;

public class ReplyBizImpl implements ReplyBiz{
	private ReplyDao replyDao;
	
	public void setReplyDao(ReplyDao replyDao) {
		this.replyDao = replyDao;
	}

	@Override
	public List<ReplyVO> getAllReplies(String articleId) {
		return replyDao.selectAllReplies(articleId);
	}

	@Override
	public boolean writeReply(ReplyVO replyVO) {
		// TODO Auto-generated method stub
		return replyDao.insertReply(replyVO) > 0;
	}
}
