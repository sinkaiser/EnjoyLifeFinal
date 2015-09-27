package com.blog.model;

public class BlogVO {
	private String memberId	=""	;
	private String postNo	="";
	private String postType	="";
	private String postTitle="";
	private String pathPhoto="";
	private String postContext 	="";
	private int AttractionsNo 	=0;
	private double avgScore		=0;
	private int qtyToScore	=0	;
	private int viewTotal	=0	;
	private java.util.Date postDate	;
	private java.util.Date modifyDate;
	private String flagDelete ="F";
	private String flagReport ="F";
	private String base64Img = null;
	
	public BlogVO() {

	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getPostNo() {
		return postNo;
	}

	public void setPostNo(String postNo) {
		this.postNo = postNo;
	}

	public String getPostType() {
		return postType;
	}

	public void setPostType(String postType) {
		this.postType = postType;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPathPhoto() {
		return pathPhoto;
	}

	public void setPathPhoto(String pathPhoto) {
		this.pathPhoto = pathPhoto;
	}

	public String getPostContext() {
		return postContext;
	}

	public void setPostContext(String postContent) {
		this.postContext = postContent;
	}

	public int getAttractionsNo() {
		return AttractionsNo;
	}

	public void setAttractionsNo(int attractionsNo) {
		AttractionsNo = attractionsNo;
	}

	public double getAvgScore() {
		return avgScore;
	}

	public void setAvgScore(double avgScore) {
		this.avgScore = avgScore;
	}

	public int getQtyToScore() {
		return qtyToScore;
	}

	public void setQtyToScore(int qtyToScore) {
		this.qtyToScore = qtyToScore;
	}

	public int getViewTotal() {
		return viewTotal;
	}

	public void setViewTotal(int viewTotal) {
		this.viewTotal = viewTotal;
	}

	public java.util.Date getPostDate() {
		return postDate;
	}

	public void setPostDate(java.util.Date postDate) {
		this.postDate = postDate;
	}

	public java.util.Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(java.util.Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getFlagDelete() {
		return flagDelete;
	}

	public void setFlagDelete(String flagDelete) {
		this.flagDelete = flagDelete;
	}

	public String getFlagReport() {
		return flagReport;
	}

	public void setFlagReport(String flagReport) {
		this.flagReport = flagReport;
	}	
	public String getBase64Img() {
		return base64Img;
	}

	public void setBase64Img(String base64Img) {
		this.base64Img = base64Img;
	}	
}
