package com.blog.model;

import java.io.Serializable;

public class BlogReplyVO implements Serializable{
	private String postNo;
	private int replyNo;
	private String replyContext;
	private String replyMemberId;
	private java.util.Date replyDate;
	private String flagDelete;

	public BlogReplyVO() {
	}

	public String getPostNo() {
		return postNo;
	}

	public void setPostNo(String postNo) {
		this.postNo = postNo;
	}

	public String getReplyMemberId() {
		return replyMemberId;
	}

	public void setReplyMemberId(String replyMemberId) {
		this.replyMemberId = replyMemberId;
	}

	public int getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}

	public String getReplyContext() {
		return replyContext;
	}

	public void setReplyContext(String replyContext) {
		this.replyContext = replyContext;
	}

	public java.util.Date getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(java.util.Date replyDate) {
		this.replyDate = replyDate;
	}

	public String getFlagDelete() {
		return flagDelete;
	}

	public void setFlagDelete(String flagDelete) {
		this.flagDelete = flagDelete;
	}
	
}
