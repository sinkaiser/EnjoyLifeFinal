package com.activity.model;


import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ActivityBean implements java.io.Serializable{

	private int activityNo;
	private String activityDepiction;
	private String activityName;
	private String activityContent;
	private String activityDate;
	private String activityLocation;
	private String activityContact;
	private String photoPath;
	
	public ActivityBean() {
		
	}
	public boolean equals(Object obj) {
		if(obj!=null && (obj instanceof ActivityBean)) {
			ActivityBean temp = (ActivityBean) obj;
			if(this.activityNo == temp.activityNo) {
				return true;
			}
		}
		return false;
	}
	public ActivityBean (String[] array) {
		if(array!=null && array.length==7) {
			activityNo = ActivityBean.converInt(array[0]);
			activityDepiction = array[1];
			activityName = array[2];
			activityContent = array[3];
			activityDate = array[4];
			activityLocation = array[5];
			activityContact = array[6];
			photoPath = array[7];
		} else {
			throw new IllegalArgumentException("Input Array length incorrect : "+array.length);
		}
	}
	
//	private static SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
//	public static java.util.Date convertDate (String data) {
//		
//		java.util.Date result = null;
//		try {
//			result = sFormat.parse(data);
//		} catch (ParseException e) {
//			e.printStackTrace();
//			result = new java.util.Date(0);
//		}
//		return result;
//	}
	public static int converInt (String data) {
		int result = 0;
			try {
				result = Integer.parseInt(data);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				result = -1000;
			}	
		return result;
	}
	
	public int getActivityno() {
		return activityNo;
	}

	public void setActivityno(int activityno) {
		this.activityNo = activityno;
	}


	public String getActivityname() {
		return activityName;
	}

	public void setActivityname(String activityname) {
		this.activityName = activityname;
	}

	public String getActivitydate() {
		return activityDate;
	}

	public void setActivitydate(String activitydate) {
		this.activityDate = activitydate;
	}

	public String getActivitycontent() {
		return activityContent;
	}

	public void setActivitycontent(String activitycontent) {
		this.activityContent = activitycontent;
	}

	public String getPhotopath() {
		return photoPath;
	}

	public void setPhotopath(String photopath) {
		this.photoPath = photopath;
	}
	public String getActivityDepiction() {
		return activityDepiction;
	}
	public void setActivityDepiction(String activityDepiction) {
		this.activityDepiction = activityDepiction;
	}
	public String getActivityLocation() {
		return activityLocation;
	}
	public void setActivityLocation(String activityLocation) {
		this.activityLocation = activityLocation;
	}
	public String getActivityContact() {
		return activityContact;
	}
	public void setActivityContact(String activityContact) {
		this.activityContact = activityContact;
	}
	
	
	
}
