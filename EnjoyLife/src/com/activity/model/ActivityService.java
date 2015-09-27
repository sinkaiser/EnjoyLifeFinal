package com.activity.model;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.zip.GZIPInputStream;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.activity.model.dao.ActivityDAOJdbc;


public class ActivityService {
	private ActivityDAO activityDAO = new ActivityDAOJdbc();
	private static String[] pageUrl = {
			"http://taiwanhot.com.tw/event?q=",
			"http://taiwanhot.com.tw/event/index/index/p/2?",
			"http://taiwanhot.com.tw/event/index/index/p/3?"
			};
	private static String httpUrl = "http://www.taiwanhot.com.tw";
	private static String localPath = "C:/Spring/workspace/Enjoylife.ver1/WebContent/images/";
    public static int num = 0;
//	public ActivityBean select(int activityid) {
//		return activityDAO.select(activityid);
//	}
    public ActivityBean select(int activityNo) {
    	return activityDAO.select(activityNo);
    }
	public List<ActivityBean> select() {
			
		List<ActivityBean> result = activityDAO.select();
					
		return result;
	}
	public ActivityBean insert(ActivityBean bean) {
		ActivityBean result = null;
		if(bean!=null) {
			
			result = activityDAO.insert(bean);
		}
		return result;
	}
	public ActivityBean update(ActivityBean bean) {
		ActivityBean result = null;
		if(bean!=null) {
			result = activityDAO.update(bean);
		}
		
		return result;
	}
	public boolean delete(ActivityBean bean) {
		boolean result = false;
		if(bean!=null) {
			result = activityDAO.delete(bean.getActivityno());
		}
		return result;
	}
	
	public static void main(String[] args) {
		
		ActivityService service = new ActivityService();
		List<ActivityBean> beans = service.select();
		System.out.println(beans);
		ActivityBean bean = new ActivityBean();
		for(int i=0;i<pageUrl.length;i++) {
		Document doc = null;
		String newurl = pageUrl[i];
		try {
			doc = Jsoup.connect(newurl).get();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
			
        Elements elements2 = doc.select("div.txt-box > h3 >a");
//        System.out.println(elements2);
//        ActivityBean bean1 = new ActivityBean();
        for (Element element2 : elements2) {
        	String contentpUrl = element2.attr("href");
        	String result = null;
        	Document doc1 = null;
        	if (!contentpUrl.startsWith("http://")) {  
        		result = httpUrl + contentpUrl;
            } else {
            	 result = contentpUrl;
            }
        	 System.out.println("contentpUrl1=" + result);
        	 try {
           		 doc1 = Jsoup.connect(result).get();
        		 } catch (IOException e) {
        			e.printStackTrace();
        		 }
        	//activityName
           	 Elements elementscon = doc1.select(".event_title");
//           System.out.println(elementscon);
           	 String lTitle = elementscon.text();
           	 System.out.println("lTitle=  " + lTitle);
           	 bean.setActivityname(lTitle);
//           	bean1.setActivityname("ghjrggfd");
           	 //activityContent
           	 Elements contents = doc1.select(".intro > h3:contains(活動介紹)+c1 > p");
//           System.out.println(contents);
           	 
           	 String content = contents.text();
           	 System.out.println("content=  " + content);
           	 if(content.length()==0) {
           		 continue;
           	 } else {
           	 bean.setActivitycontent(content);
           	 }
//           	bean1.setActivitycontent("lonhf");
             //activityDepictions
           	 if(content.length()<50) {
           		System.out.println("content=  " + content);
           		bean.setActivityDepiction(content);
           	 } else {
           	 	System.out.println("content=  " + content.substring(0,50) + "...");
           	 	bean.setActivityDepiction(content.substring(0,50)+"...");
           	 }
           	 
           		 
           	 
//             bean1.setActivityDepiction("htyegds");
           	 //activityDate
           	 Elements dates = doc1.select(".info-wrapper > table > tbody > tr > th:contains(時間)+td");
//           System.out.println(dates);
           	 String date = dates.text();
           	 System.out.println("date=  " + date);
           	 bean.setActivitydate(date);
//           	bean1.setActivitydate("urvf");
           	 //activityLocation
           	 Elements locations = doc1.select(".info-wrapper > table > tbody > tr > th:contains(地點)+td");
//          	 System.out.println(locations);
          	 String location = locations.text();
          	 System.out.println("location=  " + location);
          	 bean.setActivityLocation(location);
//          	bean1.setActivityLocation("dxxzcv");
           	 //activityContact
          	 Elements contacts = doc1.select(".info-wrapper > table > tbody > tr > th:contains(電話)+td");
//         	 System.out.println(condacts);
         	 String contact = contacts.text();
         	 System.out.println("contact=  " + contact);
         	 bean.setActivityContact(contact);
//         	bean1.setActivityContact("oyity");
           	 //photolargePath
         	 Elements imgs = doc1.select(".poster-box-left > img,.poster-box > img");
//         	 System.out.println("limgs=  " + imgs);
         	 String img = imgs.attr("src").replaceAll(" ", "%20");
         	 System.out.println("img=  " + img);
             String imgName = localPath + img.substring(img.lastIndexOf("_")+1);
             String imgUrl = "images/" + img.substring(img.lastIndexOf("_")+1);
             new Thread(new ActivityService().new DownLoadThread(img,imgName)).start();
             System.out.println("imgName=  " + imgName);
             bean.setPhotopath(imgUrl);
//             bean1.setPhotolargepath("ler345");
            service.insert(bean); 
        	}
         
		}
	

	}
	
	public class DownLoadThread implements Runnable {  
        private String imgUrl;
        private String photoPath;
  
        public DownLoadThread(String url,String photopath) {  
            this.imgUrl = url;
            this.photoPath = photopath;
            
        }  
  
        @Override  
        public void run() {  
//            FileOutputStream outputStream = null;  
            HttpURLConnection conn = null;  
                try {
					URL url = new URL(imgUrl);  
					conn = (HttpURLConnection) url.openConnection();  
					conn.setRequestMethod("GET");  
					conn.setReadTimeout(5 * 1000);  
					InputStream inputStream = conn.getInputStream();  
					// imgUrl.replaceAll("\\", "_").replaceAll("http:", "");
//                String fileName1 = imgUrl.substring(imgUrl.lastIndexOf("_")+1);
					
					System.out.println("photoPath=" + photoPath);
					String code = conn.getHeaderField("Content-Encoding");
					if((code!=null) && code.equals("gzip")) {
						GZIPInputStream gis = new GZIPInputStream(inputStream);
						byte[] bs = new byte[1024*8];
						int len;
						OutputStream outputStream = new FileOutputStream(photoPath);
						while ((len = gis.read(bs))!=-1) {
							outputStream.write(bs, 0, len);
						}
						outputStream.close();
						gis.close();
						inputStream.close();
					} else {
//                newFileName = newFileName.replaceAll("\\+", "\\%20");
//                System.out.println(newFileName);
//                String fileName = "C:/activity/img/"+fileName1;  
						OutputStream outputStream = new FileOutputStream(photoPath);  
						byte[] bs = new byte[1024];  
						int len;  
						while ((len = inputStream.read(bs))!= -1) {  
								outputStream.write(bs, 0, len);  
						}  
						outputStream.close();  
						inputStream.close();	
					}
				} catch (MalformedURLException e) {
					e.printStackTrace();
				} catch (ProtocolException e) {
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
        	} 
        }    
}


