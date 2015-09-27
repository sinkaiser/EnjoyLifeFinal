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
import javax.servlet.http.HttpSession;

import com.member.model.MemberService;
import com.member.model.MemberVO;


@WebServlet("/display/changePassword.do")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;       
    public ChangePassword() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd =  request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
		return;	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		MemberService service = new MemberService();
		HttpSession session = request.getSession();
		Map<String, String> errorMessage = new HashMap<>();

		MemberVO bean = (MemberVO)session.getAttribute("member");	
		String username = request.getParameter("memberId");
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		String passwordCheck = request.getParameter("passwordCheck");
		String password = new String(bean.getPassword());
		if (oldPassword == null || oldPassword.trim().length() == 0) {
			errorMessage.put("password","密碼必須輸入");
		}else if (!oldPassword.equals(password)){
			errorMessage.put("password","帳號密碼不符");
		}
		if (newPassword == null || newPassword.trim().length() == 0) {
			errorMessage.put("newPassword","密碼必須輸入");
		}else if (!newPassword.equals(passwordCheck)){
			errorMessage.put("passwordCheck","兩次密碼不相同，請確認密碼");
		}
		if(!errorMessage.isEmpty()){
			request.setAttribute("ErrorMsg", errorMessage);
			RequestDispatcher rd = request.getRequestDispatcher("/display/changePassword.jsp");
			rd.forward(request,response);
			
		} else if(service.changePassword(username, oldPassword, newPassword)){
			RequestDispatcher rd = request.getRequestDispatcher("/display/finished.jsp");
			bean.setPassword(newPassword.getBytes());
			session.removeAttribute("member");
			session.setAttribute("member", bean);
			rd.forward(request,response);
		}
	}
}
