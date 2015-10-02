package com.blog.model;

import java.io.Serializable;

public class BlogReportVO implements Serializable{

	private static final long serialVersionUID = 1540343756536075813L;
	private String postNo;
	private String memberId;
	private String reason;
	public String getPostNo() {
		return postNo;
	}
	public void setPostNo(String postNo) {
		this.postNo = postNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
