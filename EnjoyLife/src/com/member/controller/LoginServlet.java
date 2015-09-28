package com.member.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.member.model.MemberService;
import com.member.model.MemberVO;

@WebServlet("/secure/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService service;
	@Override
	public void init() throws ServletException {
		service = new MemberService();
	}
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
//接收資料
		String username = request.getParameter("memberId");
		String password = request.getParameter("password");
		
//驗證資料
		Map<String, String> errors = new HashMap<String, String>();
		request.setAttribute("error", errors);
		if(username==null || username.length()==0) {
			errors.put("username", "請輸入帳號");
		}
		if(password==null || password.length()==0) {
			errors.put("password", "請輸入密碼");
		}
		request.getSession().setAttribute("error", errors);
		if(errors!=null && !errors.isEmpty()) {
//			request.getRequestDispatcher(
//					"/secure/login.jsp").forward(request, response);
			response.sendRedirect(request.getContextPath()+"/index.jsp");
			return;
		}
		
//呼叫model
		MemberVO bean = service.login(username, password);
		
//根據model執行結果，導向view
		if(bean==null) {
			errors.put("LoginError", "該帳號不存在或密碼錯誤");
			request.getSession().setAttribute("error", errors);
//			request.getRequestDispatcher(
//					"/secure/login.jsp").forward(request, response);
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("member", bean);
			
			String dest = (String) session.getAttribute("dest");
			if(dest!=null && dest.length()!=0){
				session.removeAttribute("dest");
				response.sendRedirect(dest);
			}else{
			String path = request.getContextPath();
			response.sendRedirect(path+"/index.jsp");}
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
