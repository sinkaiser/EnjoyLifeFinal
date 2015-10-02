package com.AttracAction;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;

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
		ByteArrayOutputStream baos=null;
		String base64pic=null;
		for(int i=1;i<photos.length;i++){
			try {
				String pic = photos[i].substring(0, photos[i].lastIndexOf("]"));
				int first = pic.indexOf(",");
				String picbase = pic.substring(first + 1);
				byte[] source = Base64.decodeBase64(picbase);
				InputStream ins = new ByteArrayInputStream(source);
				BufferedImage bufferedImage = ImageIO.read(ins);
				double w = bufferedImage.getWidth();
				double h = bufferedImage.getHeight();
				int dw = 300; //指定壓縮大小 w爲500
				int dh = (int) (300 / (w / h));
				BufferedImage tag = new BufferedImage(dw, dh, BufferedImage.TYPE_INT_RGB);
				tag.getGraphics().drawImage(bufferedImage.getScaledInstance(dw, dh, Image.SCALE_SMOOTH), 0, 0, null);
				baos = new ByteArrayOutputStream();
				ImageIO.write(tag, "jpg", baos);
				base64pic = "data:image/jpeg;base64,";
				baos.flush();
				byte[] originalImgByte = baos.toByteArray();
				base64pic = base64pic + Base64.encodeBase64String(originalImgByte);
				baos.close();
				pic64.add(base64pic);
			} catch (Exception e) {
				e.printStackTrace();
			}
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
		bean.setShow(0);
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
//		System.out.println(bean);
//		System.out.println("100002");		
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
