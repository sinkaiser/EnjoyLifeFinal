package com.AttracAction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.AttracModel.AttracBean;
import com.AttracModel.AttracService;
import com.AttracModel.PhotoBean;
import com.AttracModel.PhotoService;





public class insertAction {
	private AttracBean Bean=new AttracBean();

	public AttracBean getBean() {
		return Bean;
	}

	public void setBean(AttracBean bean) {
		Bean = bean;
	}

	public String execute() { 		
		HttpServletRequest request = ServletActionContext.getRequest(); // 取得HttpServletRequest
		HttpSession session = request.getSession(); // 取得HttpSession
		List<AttracBean>beans=(List<AttracBean>)session.getAttribute("AttracBean");    // *工作1: 在session內做已經登入過的標識
		Bean.setBeans(beans);
		AttracService service = new AttracService();
		PhotoService pservice = new PhotoService();
		String link2="http://www.travel.taipei/d_upload_ttn/sceneadmin/image/A0/B0/C0/D0/E197/F470/887da79a-7790-423c-84e3-2c35e5784256.jpg";
		ConvertToBase64 convert=new ConvertToBase64();
		String pic64=null;
		PhotoBean pbean=new PhotoBean();			
		for(AttracBean bean:Bean.getBeans()){
			service.insert(bean);
			int j=1;
			for(String pic:bean.getFile()){
				if(!pic.equals(link2)){
					pic64=convert.Convert(pic);
					pbean.setPhotoname(bean.getStitle()+j);
					pbean.setPhotodata(pic64);
					pbean.setAttracno(bean.getRownumber());
					pservice.insert(pbean);
					j++;
				}
			}
		}		
		
		System.out.println("100002");
			
	    return "success";	        
	}

}
