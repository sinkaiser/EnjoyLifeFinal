package com.AttracModel;

import java.util.List;

public class CountyBean implements java.io.Serializable{
	private int countyno;
	private String countyname;
	private List<CountyBean> beans;
	@Override
	public String toString() {
		
		return countyno+","+countyname;
	}
	public int getCountyno() {
		return countyno;
	}
	public void setCountyno(int countyno) {
		this.countyno = countyno;
	}
	public String getCountyname() {
		return countyname;
	}
	public void setCountyname(String countyname) {
		this.countyname = countyname;
	}
	public List<CountyBean> getBeans() {
		return beans;
	}
	public void setBeans(List<CountyBean> beans) {
		this.beans = beans;
	}
}
