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


@WebServlet("/searchMember.do")
public class SearchMember extends HttpServlet {
	private static final long serialVersionUID = 1L;       
    public SearchMember() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		MemberService service = new MemberService();
		HttpSession session = request.getSession();
		Map<String, String> errorMessage = new HashMap<>();
		String memberId = request.getParameter("Search");
		
		if (memberId == null || memberId.trim().length() == 0) {
			errorMessage.put("search","帳號必須輸入");
		}else if(service.checkMemberId(memberId)!=false){
			errorMessage.put("search","帳號不存在");
		}		
		MemberVO bean = service.selectMemberId(memberId);
		if(!errorMessage.isEmpty()){
			request.setAttribute("ErrorMsg", errorMessage);
			RequestDispatcher rd = request.getRequestDispatcher("/display/searchButton.jsp");
			rd.forward(request,response);
			return;
		} 
			request.setAttribute("search", bean);
			RequestDispatcher rd = request.getRequestDispatcher("/display/selectMember.jsp");
			rd.forward(request,response);
			return;
	}
}
