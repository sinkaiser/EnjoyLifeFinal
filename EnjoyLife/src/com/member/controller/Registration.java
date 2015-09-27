package com.member.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.member.model.MemberDAO;
import com.member.model.MemberDAO_interface;
import com.member.model.MemberVO;
import com.util.ImgListBean;
import com.util.ImgListDao;
import com.util.ImgListDaoHibernate;

@WebServlet("/display/registration.do") 
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Map<String, String> errorMessage = new HashMap<>();
		request.setAttribute("ErrorMsg", errorMessage);
//		request.setCharacterEncoding("UTF-8");
		ImgListBean ibean=new ImgListBean();
		ImgListDao idao=new ImgListDaoHibernate();
		int picture=1;
		MemberVO bean = new MemberVO();
		String memberId=null;
		String password=null;
		String memberName=null;
		String email=null;
		String sex=null;
		String birthday=null;
		String address=null;


		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(factory);
try {
			
			List items = sfu.parseRequest(request);
			Iterator iter = items.iterator();
			String name;
			String value;
			
			while (iter.hasNext()) {
				
			    FileItem item = (FileItem) iter.next();			 
			    if (item.isFormField()) {
			    	name=item.getFieldName();
			    	value=item.getString("UTF-8");
			    	if(name.equals("memberId")) {
			    		memberId=value;
			    	}
			    	if(name.equals("password")) {
			    		password=value;
			    	}
			    	if(name.equals("memberName")) {
			    		memberName=value;
			    	}
			    	if(name.equals("email")) {
			    		email=value;
			    	}
			    	if(name.equals("sex")) {
			    		sex=value;
			    	}
			    	if(name.equals("birthday")) {
			    		birthday=value;
			    	}
			    	if(name.equals("address")) {
			    		address=value;
			    	}
		    			    	
			    }else{			    	
			    	 long sizeInBytes = item.getSize();	
			    	 byte[] data = item.get();
			    	 if(data!=null){
			    		
			    	 String fileName = item.getName();
			    	 String[] b=fileName.split("\\.");
			    	 if (fileName != null && !"".equals(fileName)) {
			    	 ibean.setImgName(b[0]);
			    	 ibean.setImgType(b[1]);			    	 
			    	 ibean.setImgContent(data);
			    	 picture=idao.insert(ibean);	
			    	 	}
			    	 }
			    }			     
			}			
		} catch (FileUploadException e) {
			e.printStackTrace();
		}		
//		String memberId = request.getParameter("memberId");
		if (memberId == null || memberId.trim().length() == 0) {
			errorMessage.put("memberId","帳號欄必須輸入");
		}
//		String password = request.getParameter("password");
		if (password == null || password.trim().length() == 0) {			
			errorMessage.put("password","密碼欄必須輸入");
		}
//		String memberName = request.getParameter("memberName");
		if (memberName == null || memberName.trim().length() == 0) {
			errorMessage.put("memberName","姓名欄必須輸入");
		}
//		String email = request.getParameter("email");
		if (email == null || email.trim().length() == 0) {
			errorMessage.put("email","email必須輸入");
		}
//		String sex = request.getParameter("sex");
//		String birthday = request.getParameter("birthday");
		java.sql.Date date = null;	
		if (birthday != null && birthday.trim().length() > 0) {
			try {
				date = java.sql.Date.valueOf(birthday);
			} catch (IllegalArgumentException e) {
				errorMessage.put("birthday","生日欄格式錯誤");
			}
		}
//		String address = request.getParameter("address");		
		Timestamp registerDate = new Timestamp(System.currentTimeMillis());
//		String picture = request.getParameter("picture");
//		String friend = request.getParameter("friend");		
		if (!errorMessage.isEmpty()) {
			RequestDispatcher rd = request
					.getRequestDispatcher("/display/register.jsp");
			rd.forward(request, response);
			return;
		}
		// MemberBean 扮演封裝輸入資料的角色
//		MemberVO bean = new MemberVO(memberId, password.getBytes(), memberName, email, sex, date, registerDate, address, friend);
		bean.setMemberId(memberId);
		bean.setPassword(password.getBytes());
		bean.setMemberName(memberName);
		bean.setEmail(email);
		bean.setSex(sex);
		bean.setBirthday(date);
		bean.setRegisterDate(registerDate);
		bean.setAddress(address);	
		MemberDAO_interface memberDAO = new MemberDAO();
			if(memberDAO.SelectById(memberId)!=null){
				errorMessage.put("memberId","帳號ID重複");
				RequestDispatcher rd = request
						.getRequestDispatcher("/display/register.jsp");
				rd.forward(request, response);
				return;
			}else{				
							
				bean.setPicture(picture);				
				memberDAO.insert(bean);
				session.setAttribute("member", bean);
				response.sendRedirect(
				response.encodeRedirectURL(request.getContextPath()+"/display/registerSuccess.jsp"));
				return;	
			}			
		}
}
