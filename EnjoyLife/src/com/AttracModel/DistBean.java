package com.AttracModel;

import java.util.List;

public class DistBean implements java.io.Serializable{
	private int distno,countyno;
	private String distname;
	private List<DistBean> beans;
	@Override
	public String toString() {
		return distno+","+distname+","+countyno;
	}
	public int getDistno() {
		return distno;
	}
	public void setDistno(int distno) {
		this.distno = distno;
	}
	public int getCountyno() {
		return countyno;
	}
	public void setCountyno(int countyno) {
		this.countyno = countyno;
	}
	public String getDistname() {
		return distname;
	}
	public void setDistname(String distname) {
		this.distname = distname;
	}

}
