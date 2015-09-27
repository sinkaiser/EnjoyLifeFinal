package com.AttracAction;

import java.util.ArrayList;
import java.util.List;


import com.AttracModel.AttracBean;
import com.AttracModel.AttracService;
import com.AttracModel.PhotoBean;
import com.AttracModel.PhotoService;

public class updateAction {
	private String picmode;
	private AttracBean bean;
	private List<String> pic64=new ArrayList<String>();
	private String picstring;
	
	
	
	public String execute() {
		AttracService service = new AttracService();
		PhotoService pservice = new PhotoService();
		ConvertNo convert=new ConvertNo();
		PhotoBean pbean=new PhotoBean();
		String[] photos =picstring.split("\\[");
		for(int i=1;i<photos.length;i++){
			String pic=photos[i].substring(0, photos[i].lastIndexOf("]"));
			pic64.add(pic);
		}
		String add= bean.getAddress();
		String county=null;
		String dist=null;
		if (add!=null) {
			add = add.replaceAll("台", "臺");
			county = add.substring(0, add.indexOf('市') + 1);
			if (add.indexOf('區') != -1) {
				dist = add.substring(add.indexOf('市') + 1, add.indexOf('區') + 1);
			} 
		}
		bean.setCat1(convert.ConvertStr(bean.getCat1no()+"",bean.getCat1no()+""));
		bean.setCat2(convert.ConvertStr(bean.getCat1no()+"",bean.getCat2no()+""));
		bean.setCounty(county);
		bean.setDist(dist);
		bean.setCountyno(convert.ConvertInt(county, county));;
		bean.setDistno(convert.ConvertInt(county, dist));
		service.insert(bean);
		bean.setRownumber(service.selectAttracNo(bean));
		int j=1;
		for(String pic:pic64){
				pbean.setPhotoname(bean.getStitle()+j);
				pbean.setPhotodata(pic);
				pbean.setAttracno(bean.getRownumber());
				pservice.insert(pbean);
				j++;
		}
		System.out.println(bean);
		System.out.println("100002");		
		return "success";	        
	}
	
	public String getPicmode() {
		return picmode;
	}
	
	public void setPicmode(String picmode) {
		this.picmode = picmode;
	}
	public AttracBean getBean() {
		return bean;
	}
	public void setBean(AttracBean bean) {
		this.bean = bean;
	}
	public String getPicstring() {
		return picstring;
	}
	public void setPicstring(String picstring) {
		this.picstring = picstring;
	}
	public List<String> getPic64() {
		return pic64;
	}
	public void setPic64(List<String> pic64) {
		this.pic64 = pic64;
	}
	

}
