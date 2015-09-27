package com.AttracModel;

import java.util.List;

public class PhotoBean {
	private int photono,attracno;
	private String photoname,photodata;
	private List<String> beans;
	@Override
	public String toString() {
		
		return photono+","+photoname+","+attracno;
	}
	
	public List<String> getBeans() {
		return beans;
	}
	public void setBeans(List<String> beans) {
		this.beans = beans;
	}
	public int getPhotono() {
		return photono;
	}
	public void setPhotono(int photono) {
		this.photono = photono;
	}
	public int getAttracno() {
		return attracno;
	}
	public void setAttracno(int attracno) {
		this.attracno = attracno;
	}
	public String getPhotoname() {
		return photoname;
	}
	public void setPhotoname(String photoname) {
		this.photoname = photoname;
	}
	public String getPhotodata() {
		return photodata;
	}
	public void setPhotodata(String photodata) {
		this.photodata = photodata;
	}
	
}
