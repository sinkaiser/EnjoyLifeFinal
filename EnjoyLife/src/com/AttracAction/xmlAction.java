package com.AttracAction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.AttracModel.AttracBean;
import com.opensymphony.xwork2.ActionSupport;

public class xmlAction extends ActionSupport{
	private AttracBean bean=new AttracBean();
	private String src;
	public String getSrc() {
		System.out.println("src05");
		return src;
	}

	public AttracBean getBean() {
		System.out.println("bean02");
		return bean;
	}

	public void setBean(AttracBean bean) {
		System.out.println("bean01");
		this.bean = bean;
	}

	public void setSrc(String src) {		
		System.out.println("src01");
		this.src = src;
	}

	public String execute() {   
			System.out.println("00002");
			Readfile rf=new Readfile();
			bean.setSrc(this.src);
			List<AttracBean> beans=rf.xml(bean.getSrc());
			System.out.println("00003");
			bean.setBeans(beans);
			HttpServletRequest request = ServletActionContext.getRequest(); // 取得HttpServletRequest
			HttpSession session = request.getSession(); // 取得HttpSession
			session.setAttribute("AttracBean", beans);     // *工作1: 在session內做已經登入過的標識
			System.out.println("00004");
	       return "success";	        
	}

}
