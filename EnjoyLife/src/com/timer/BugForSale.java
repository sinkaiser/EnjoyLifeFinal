package com.timer;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.little.controller.LittleDaoHibernate;
import com.little.model.LittleBean;


public class BugForSale {

	public Integer Parsing() {
		int result=0;
		String xx="http://twcoupon.com/";
		
		Document xmlDoc;
		try {
			URL url = new URL("http://twcoupon.com/qpon.aspx"); 
			xmlDoc = Jsoup.parse(url, 100000);
		} catch (MalformedURLException e) {
			result=-404;
			e.printStackTrace();
			return result;
		} catch (IOException e) {
			result=-500;
			e.printStackTrace();
			return result;
		} 
		
		
		String href;
		String p;
		Elements uls = xmlDoc.select("ul");
		
		LittleDaoHibernate dao=new LittleDaoHibernate();
		
		for(Element ul:uls){
			
			
			LittleBean bean=new LittleBean();
			Date date =new Date();
			long time=date.getTime();
			bean.setBeginTime(date);
			bean.setEndTime(new Date(time+1000*60*60*24));
			bean.setTargetNo(4);
			bean.setTypeNo(2);
			
			p=ul.select("p").text();
			href=ul.select(".link > a").attr("href");
//			System.out.println("<a href="+xx+href+">"+p+"</a>");
			bean.setNevin("<a href="+xx+href+">"+p+"</a>");
			dao.insert(bean);
			
			result++;
		}
		
		
		
		return result;
	}

}
