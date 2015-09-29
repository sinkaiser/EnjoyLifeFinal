package com.little.model;

import java.sql.Date;



public class LittleBean implements java.io.Serializable {

	private Integer elfNo;
	private Integer targetNo;
	private String nevin;
	private Integer typeNo;
	private java.util.Date beginTime;
	private java.util.Date endTime;
	
	public Integer getElfNo() {
		return elfNo;
	}
	public void setElfNo(Integer elfNo) {
		this.elfNo = elfNo;
	}
	public Integer getTargetNo() {
		return targetNo;
	}
	public void setTargetNo(Integer targetNo) {
		this.targetNo = targetNo;
	}
	public String getNevin() {
		return nevin;
	}
	public void setNevin(String nevin) {
		this.nevin = nevin;
	}
	public Integer getTypeNo() {
		return typeNo;
	}
	public void setTypeNo(Integer typeNo) {
		this.typeNo = typeNo;
	}
	public java.util.Date getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(java.util.Date beginTime) {
		this.beginTime = beginTime;
	}
	public java.util.Date getEndTime() {
		return endTime;
	}
	public void setEndTime(java.util.Date endTime) {
		this.endTime = endTime;
	}
}
