package com.AttracModel;


import java.util.List;


public class AttracBean implements java.io.Serializable{	
	private int rownumber,cat1no,cat2no,distno,countyno,show;
	private List<AttracBean> Beans;
	private String time,stitle,xbody,address,info,mrt,src,cat1,cat2,dist,county;
	private List<String>file;

	
	public int getShow() {
		return show;
	}
	public void setShow(int show) {
		this.show = show;
	}
	public int getCat1no() {
		return cat1no;
	}
	public void setCat1no(int cat1no) {
		this.cat1no = cat1no;
	}
	public int getCat2no() {
		return cat2no;
	}
	public void setCat2no(int cat2no) {
		this.cat2no = cat2no;
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
	public String getCat1() {
		return cat1;
	}
	public void setCat1(String cat1) {
		this.cat1 = cat1;
	}
	public String getCat2() {
		return cat2;
	}
	public void setCat2(String cat2) {
		this.cat2 = cat2;
	}
	public String getDist() {
		return dist;
	}
	public void setDist(String dist) {
		this.dist = dist;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	
	public int getRownumber() {
		return rownumber;
	}
	public void setRownumber(int rownumber) {
		this.rownumber = rownumber;
	}	
	public String getSrc() {
		return src;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public void setSrc(String src) {
		String fullsrc="http://data.taipei/opendata/datalist/apiAccess?scope=resourceAquire&rid="+src+"&format=xml";
		this.src = fullsrc;
	}
	public List<AttracBean> getBeans() {
		return Beans;
	}
	public void setBeans(List<AttracBean> beans) {
		Beans = beans;
	}
	
	
	public String getStitle() {
		return stitle;
	}
	public void setStitle(String stitle) {
		this.stitle = stitle;
	}
	public String getXbody() {
		return xbody;
	}
	public void setXbody(String xbody) {
		this.xbody = xbody;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getMrt() {
		return mrt;
	}
	public void setMrt(String mrt) {
		this.mrt = mrt;
	}
	public List<String> getFile() {
		return file;
	}
	public void setFile(List<String> file) {
		this.file = file;
	}



	@Override
	public String toString() {
		
		return rownumber+","+stitle+","+time+","+
		xbody+","+cat1+","+cat1no+","+cat2+","+cat2no+","+mrt+","+info+","+
				county+","+countyno+","+dist+","+distno+","+address;
		
	}
	
	
	
}
