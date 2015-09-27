package com.comment.model;

public class CommentVO implements java.io.Serializable {
	private Integer commentNo;
	private String commentContent;
	private java.sql.Timestamp commentDate;
	private Integer eventNo;
	private String memberId;
	private Integer closed;
	
	
	public Integer getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(Integer commentNo) {
		this.commentNo = commentNo;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public java.sql.Timestamp getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(java.sql.Timestamp commentDate) {
		this.commentDate = commentDate;
	}
	public Integer getEventNo() {
		return eventNo;
	}
	public void setEventNo(Integer eventNo) {
		this.eventNo = eventNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public Integer getClosed() {
		return closed;
	}
	public void setClosed(Integer closed) {
		this.closed = closed;
	}
	
}
