package com.message.model;

import java.io.Serializable;

public class MessageVO implements Serializable {	
	private static final long serialVersionUID = 1L;
	private int messageNo;
	public int getMessageNo() {
		return messageNo;
	}
	public void setMessageNo(int messageNo) {
		this.messageNo = messageNo;
	}
	private String messageFrom;  	
	private String messageTo;  
	private String messageTitle;   			
	private String message;
	private java.sql.Timestamp talkDate;
	private int showMessage;

	public int getShowMessage() {
		return showMessage;
	}
	public void setShowMessage(int showMessage) {
		this.showMessage = showMessage;
	}
	private int unMessage;
	public int getUnMessage() {
		return unMessage;
	}
	public void setUnMessage(int unMessage) {
		this.unMessage = unMessage;
	}
	public String getMessageFrom() {
		return messageFrom;
	}
	public void setMessageFrom(String messageFrom) {
		this.messageFrom = messageFrom;
	}
	public String getMessageTo() {
		return messageTo;
	}
	public void setMessageTo(String messageTo) {
		this.messageTo = messageTo;
	}
	public String getMessageTitle() {
		return messageTitle;
	}
	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public java.sql.Timestamp getTalkDate() {
		return talkDate;
	}
	public void setTalkDate(java.sql.Timestamp talkDate) {
		this.talkDate = talkDate;
	}
	public MessageVO() {
	}
	
}
