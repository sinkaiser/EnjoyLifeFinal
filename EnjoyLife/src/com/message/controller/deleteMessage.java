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

import com.member.model.MemberVO;
import com.message.model.MessageService;


@WebServlet("/message/deleteMessage.do") 
public class deleteMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		MemberVO bean = (MemberVO)session.getAttribute("member");
		String memberFrom = bean.getMemberId();
		String memberTo = request.getParameter("mid");
		Map<String, String> errorMessage = new HashMap<>();
		MessageService mservice = new MessageService();
		request.setAttribute("ErrorMsg", errorMessage);		
		
		if (!errorMessage.isEmpty()) {		
			RequestDispatcher rd = request
					.getRequestDispatcher("/message/deleteMessage.jsp");
			rd.forward(request, response);			
			return;
		}
		// MemberBean 扮演封裝輸入資料的角色									
		mservice.deleteMessage(memberFrom,memberTo);
		response.sendRedirect(
		response.encodeRedirectURL(request.getContextPath()+"/message/message.jsp"));
		return;	
					
		}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
}
