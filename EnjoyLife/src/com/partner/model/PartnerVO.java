package com.partner.model;

public class PartnerVO implements java.io.Serializable{
	private Integer eventNo;
	private String eventType;
	private String eventContent;
	private String addr;
	private java.sql.Timestamp eventDate;
	private java.sql.Timestamp modifyDate;
	private Integer imgNo;
	private String memberId;
	private Integer hidden;
	private Integer closed;
	private String memberName;
	

//	public PartnerVO() {
//		
//	}
//	
//	public PartnerVO(String eventType, String eventTitle, String eventContent, String addr, java.sql.Timestamp eventDate, java.sql.Timestamp modifyDate, String memberId, int hidden) {
//		super();
//		this.eventType = eventType;
//		this.eventTitle = eventTitle;
//		this.eventContent = eventContent;
//		this.addr = addr;
//		this.eventDate = eventDate;
//		this.modifyDate = modifyDate;
//		this.memberId = memberId;
//	}
	
	
	public Integer getEventNo() {
		return eventNo;
	}
	public void setEventNo(Integer eventNo) {
		this.eventNo = eventNo;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public String getEventContent() {
		return eventContent;
	}
	public void setEventContent(String eventContent) {
		this.eventContent = eventContent;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public java.sql.Timestamp getEventDate() {
		return eventDate;
	}
	public void setEventDate(java.sql.Timestamp eventDate) {
		this.eventDate = eventDate;
	}
	public java.sql.Timestamp getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(java.sql.Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}
	public Integer getImgNo() {
		return imgNo;
	}
	public void setImgNo(Integer imgNo) {
		this.imgNo = imgNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public Integer getHidden() {
		return hidden;
	}
	public void setHidden(Integer hidden) {
		this.hidden = hidden;
	}
	public Integer getClosed() {
		return closed;
	}
	public void setClosed(Integer closed) {
		this.closed = closed;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
}
