package com.attendpartner.model;

public class AttendPartnerVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private Integer eventNo;
	private String partner;
	private String partnerId;
	private Integer attend;
	
	public Integer getEventNo() {
		return eventNo;
	}
	public void setEventNo(Integer eventNo) {
		this.eventNo = eventNo;
	}
	public String getPartner() {
		return partner;
	}
	public void setPartner(String partner) {
		this.partner = partner;
	}
	public String getPartnerId() {
		return partnerId;
	}
	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}
	public Integer getAttend() {
		return attend;
	}
	public void setAttend(Integer attend) {
		this.attend = attend;
	}
	
}
