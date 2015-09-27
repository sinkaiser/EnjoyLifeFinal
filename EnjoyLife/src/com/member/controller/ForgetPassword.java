package com.member.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.model.MemberService;
import com.member.model.MemberVO;

@WebServlet("/display/forgetPassword.do")
public class ForgetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public ForgetPassword() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String memberId = request.getParameter("memberId");
	    String email = request.getParameter("email");
	    request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		MemberService service = new MemberService();
		Map<String, String> errorMessage = new HashMap<>();			       
	    MemberVO bean = service.selectMemberId(memberId);
	    if(bean!=null && bean.getEmail().equals(email)){
	    	SendEmail.sendemail(bean.getMemberId(),new String(bean.getPassword()), bean.getEmail());
	    } else {
	    	errorMessage.put("wrong", "使用者帳號信箱錯誤");
	    }
	    	    
	    if(!errorMessage.isEmpty()){
			request.setAttribute("ErrorMsg", errorMessage);
			RequestDispatcher rd = request.getRequestDispatcher("/display/forgetpassword.jsp");
			rd.forward(request,response);
			
		}
	    
	    RequestDispatcher rd = request.getRequestDispatcher("/index4Member.jsp");	
		rd.forward(request,response);
	    
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd =  request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
		return;	
	}
}
