package com.friend.model;

import java.io.Serializable;

public class FriendVO implements Serializable {	
	private static final long serialVersionUID = 1L;
	private String memberId;   			
	private String friendId;   			
	private int MessageNo;       	
	private int Unfriend ;
	public FriendVO() {
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getFriendId() {
		return friendId;
	}
	public void setFriendId(String friendId) {
		this.friendId = friendId;
	}
	public int getMessageNo() {
		return MessageNo;
	}
	public void setMessageNo(int messageNo) {
		MessageNo = messageNo;
	}
	public int getUnfriend() {
		return Unfriend;
	}
	public void setUnfriend(int unfriend) {
		Unfriend = unfriend;
	}
}
