package com.blog.model;

import java.util.ArrayList;
import java.util.List;

public interface BlogReplyDAO {
		
	public abstract List<BlogReplyVO> selectByPostNo(String postNo);
	
	public abstract int getReplyNo(String postNo);
		
	public abstract boolean insertReply(BlogReplyVO bean);

	public abstract boolean updateReply(String replyContext,
			java.util.Date replyDate,String postNo,int replyNo);
	
	public abstract boolean deleteReply(String flagDelete,String postNo,int replyNo);
	
}
