package com.AttracModel;

import java.util.List;

public class Cate1Bean {
	private int cate1no;
	private String cate1name;
	private List<Cate1Bean> beans;
	@Override
	public String toString() {
		return cate1no+","+cate1name;
	}
	public int getCate1no() {
		return cate1no;
	}
	public void setCate1no(int cate1no) {
		this.cate1no = cate1no;
	}
	public String getCate1name() {
		return cate1name;
	}
	public void setCate1name(String cate1name) {
		this.cate1name = cate1name;
	}
	public List<Cate1Bean> getBeans() {
		return beans;
	}
	public void setBeans(List<Cate1Bean> beans) {
		this.beans = beans;
	}
}
