package com.message.controller;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.member.model.MemberService;
import com.member.model.MemberVO;
import com.message.model.MessageService;
import com.message.model.MessageVO;


@WebServlet("/message/writeMessage.do") 
public class writeMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		MemberVO bean = (MemberVO)session.getAttribute("member");
		String messageFrom = bean.getMemberId();
		Map<String, String> errorMessage = new HashMap<>();
		MemberService service = new MemberService();
		MessageService mservice = new MessageService();
		request.setAttribute("ErrorMsg", errorMessage);		
		String messageTo = request.getParameter("messageTo");
		String messageTitle = request.getParameter("messageTitle");
		String message = request.getParameter("message");

		if (messageTo == null || messageTo.trim().length() == 0) {
			errorMessage.put("messageTo","帳號欄必須輸入");
		}else if(service.checkMemberId(messageTo)){
			errorMessage.put("messageTo","此帳號不存在");
		}else if(messageFrom.equals(messageTo)){
			errorMessage.put("messageTo","無法傳遞訊息給自己");
		}

		if (!errorMessage.isEmpty()) {		
			RequestDispatcher rd = request
					.getRequestDispatcher("/message/writeMessage.jsp");
			rd.forward(request, response);			
			return;
		}
		// MemberBean 扮演封裝輸入資料的角色
		MessageVO mbean = new MessageVO();
		mbean.setMessageFrom(messageFrom);
		mbean.setMessageTo(messageTo);
		mbean.setMessageTitle(messageTitle);
		mbean.setMessage(message);
		
		int result = mservice.insertmessage(mbean);	
		if(result==1){
		session.setAttribute("writeMessage", mbean);
		response.sendRedirect(
		response.encodeRedirectURL(request.getContextPath()+"/message/message.jsp"));
		return;	
		}else{
			request.setAttribute("WrongMessage", "寄送失敗");
			RequestDispatcher rd = request
					.getRequestDispatcher("/message/writeMessage.jsp");
			rd.forward(request, response);			
			return;
		}
					
		}
}
