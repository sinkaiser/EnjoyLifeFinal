package com.AttracModel;

import java.util.List;

public class Cate2Bean {
	private int cate1no,cate2no;
	private String cate2name;
	private List<Cate2Bean> beans;
	public int getCate1no() {
		return cate1no;
	}
	public void setCate1no(int cate1no) {
		this.cate1no = cate1no;
	}
	public int getCate2no() {
		return cate2no;
	}
	public void setCate2no(int cate2no) {
		this.cate2no = cate2no;
	}
	public String getCate2name() {
		return cate2name;
	}
	public void setCate2name(String cate2name) {
		this.cate2name = cate2name;
	}
	public List<Cate2Bean> getBeans() {
		return beans;
	}
	public void setBeans(List<Cate2Bean> beans) {
		this.beans = beans;
	}
	@Override
	public String toString() {
		return cate2no+","+cate2name+","+cate1no;
	}
	
}
