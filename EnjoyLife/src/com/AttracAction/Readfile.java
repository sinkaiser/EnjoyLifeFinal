package com.AttracAction;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.AttracModel.AttracBean;

public class Readfile {
	public static void main(String[] args) {
		Readfile Rf=new Readfile();
		AttracBean xb=new AttracBean();
		xb.setSrc("36847f3f-deff-4183-a5bb-800737591de5");
		Rf.xml(xb.getSrc());	
	}
	
	public List<AttracBean> xml(String src){
				
				URL urllink = null;
		        try {
		            urllink = new URL(src); 
		        } catch (MalformedURLException e) {
		            System.out.println("Malformed URL error!");
		        }
				SAXReader reader = new SAXReader();
				Document document = null;
				try {
					//以URL物件建立URLConnection物件
					URLConnection urlConn = urllink.openConnection();
					//以URLConnection物件取得輸入資料流
					InputStream ins = urlConn.getInputStream();					
					//建立URL資料流
					BufferedReader file = new BufferedReader(new InputStreamReader(ins,"UTF-8"));					
					document = reader.read(file);
				} catch (DocumentException e) {
					e.printStackTrace();
				} catch (IOException ioe) {
		            System.out.println("IO error!");
		        }																						
				//common format node
				Element element = document.getRootElement();
				//section nodes
				List<Element> childElements = element.elements();
				List<AttracBean> Beans = new ArrayList<AttracBean>();
				List<String> files =null;
				AttracBean bean =null;
				ConvertNo convert=new ConvertNo();
//				ConvertToBase64 convert64 =new ConvertToBase64();
				int i=1;
				//get section node
				for (Element child : childElements) {
//					String pic64="";					
					bean = new AttracBean();
					files = new ArrayList<String>();
					int num=i;
					String cat1=child.elementText("CAT1")==null?null:child.elementText("CAT1");
					String cat2=child.elementText("CAT2")==null?null:child.elementText("CAT2");
					String time=child.elementText("MEMO_TIME")==null?null:child.elementText("MEMO_TIME");
					String title=child.elementText("stitle")==null?null:child.elementText("stitle");
					String body=child.elementText("xbody")==null?null:child.elementText("xbody");					
					String add=child.elementText("address")==null?null:child.elementText("address").replace(" ", "");
					String county=null;
					String dist=null;
					if (add!=null) {
						add = add.replaceAll("台", "臺");
						county = add.substring(0, add.indexOf('市') + 1);
						if (add.indexOf('區') != -1) {
							dist = add.substring(add.indexOf('市') + 1, add.indexOf('區') + 1);
						} 
					}
					String info=child.elementText("info")==null?null:child.elementText("info");
					String mrt=child.elementText("MRT") == null?null: child.elementText("MRT");
					if (child.elementText("file") != null) {
							String links=child.elementText("file");
							links=links.replaceAll(".jpghttp", ".jpg;http")
									.replaceAll(".pnghttp", ".png;http")
									.replaceAll(".JPGhttp", ".JPG;http")
									.replaceAll(".gifhttp", ".gif;http")
									.replaceAll(".jpeghttp", ".jpeg;http");
							String[] linkes=links.split(";");
							for(String link:linkes){									
								if(link.toLowerCase().indexOf("jpg")!=-1||link.toLowerCase().indexOf("png")!=-1||link.toLowerCase().indexOf("gif")!=-1){
									files.add(link);
								}
							}
							bean.setFile(files);
					}else{
						bean.setFile(files);																
					}
					bean.setRownumber(num);					
					bean.setCat1(cat1);
					bean.setCat1no(convert.ConvertInt(cat1, cat1));
					bean.setCat2(cat2);
					bean.setCat2no(convert.ConvertInt(cat1, cat2));
					bean.setTime(time);
					bean.setStitle(title);
					bean.setXbody(body);
					bean.setAddress(add);
					bean.setCounty(county);
					bean.setDist(dist);
					if(!"".equalsIgnoreCase(county)){
						bean.setCountyno(convert.ConvertInt(county, county));
						bean.setDistno(convert.ConvertInt(county, dist));
					}
					bean.setInfo(info);
					bean.setMrt(mrt);																
					i++;
					Beans.add(bean);
					
				}
				return Beans;

	}
}
