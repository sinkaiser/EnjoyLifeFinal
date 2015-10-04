package com.util;

public class ImgListBean implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private int imgNo;
	private byte[] imgContent;
	private String imgType;
	private String imgName;
	
	public int getImgNo() {
		return imgNo;
	}
	public void setImgNo(int imgNo) {
		this.imgNo = imgNo;
	}
	public byte[] getImgContent() {
		return imgContent;
	}
	public void setImgContent(byte[] imgContent) {
		this.imgContent = imgContent;
	}
	public String getImgType() {
		return imgType;
	}
	public void setImgType(String imgType) {
		this.imgType = imgType;
	}
	public String getImgName() {
		return imgName;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
}
