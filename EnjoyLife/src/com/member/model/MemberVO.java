package com.member.model; 

import java.io.Serializable;

import java.text.ParseException;
import java.text.SimpleDateFormat;


public class MemberVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String memberId;   			
	private byte[] password;   			
	private String memberName;       	
	private String email;
	private String sex;
	private java.util.Date birthday;
	private java.sql.Timestamp registerDate;
	private String address;    			
	private int	picture;
	private int permission;	
	public MemberVO() {
	}
//	public MemberVO(String memberId, byte[] password, String memberName,String email,String sex, Date birthday,Timestamp registerDate, String address,
//			 String friend) {
//		super();
//		this.memberId = memberId;
//		this.password=password;
//		this.memberName = memberName;
//		this.email= email;
//		this.sex=sex;
//		this.birthday = birthday;
//		this.registerDate = registerDate;
//		this.address = address;
////		this.picture = picture;
//		this.friend = friend;
//	}

	public java.sql.Timestamp getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(java.sql.Timestamp registerDate) {
		this.registerDate = registerDate;
	}
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public static java.util.Date convertDate(String temp){
		java.util.Date result = new java.util.Date();
		try {
			result=sdf.parse(temp);
		} catch (ParseException e) {
			result = null ; 
			e.printStackTrace();
		}
		return result;
	}
	public String toString() {
		return "["+memberId+","+password+","+memberName+","+email+","+sex+","+birthday+","+address+","+permission+"]";
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public byte[] getPassword() {
		return password;
	}
	public void setPassword(byte[] password) {
		this.password = password;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public java.util.Date getBirthday() {
		return birthday;
	}
	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPicture() {
		return picture;
	}
	public void setPicture(int picture) {
		this.picture = picture;
	}
	public int getPermission() {
		return permission;
	}
	public void setPermission(int permission) {
		this.permission = permission;
	}

}