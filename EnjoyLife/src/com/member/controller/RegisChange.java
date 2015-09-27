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

@WebServlet("/display/regisChange.do")
public class RegisChange extends HttpServlet {
	private static final long serialVersionUID = 1L;    
    public RegisChange() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Map<String, String> errorMessage = new HashMap<>();
		request.setAttribute("ErrorMsg", errorMessage);
		MemberVO bean = (MemberVO) session.getAttribute("member");
//		MemberVO bean = new MemberVO();	
		String memberId = request.getParameter("memberId");
		bean.setMemberId(memberId);
		String memberName = request.getParameter("memberName");
		if (memberName == null || memberName.trim().length() == 0) {
			errorMessage.put("memberName","姓名欄必須輸入");
		}else{
			bean.setMemberName(memberName);
		}
		String email = request.getParameter("email");
		if (email == null || email.trim().length() == 0) {
			errorMessage.put("email","email必須輸入");
		}else{
			bean.setEmail(email);
		}
		String sex = request.getParameter("sex");
		if (sex != null ) {
			bean.setSex(sex);
		}
		String birthday = request.getParameter("birthday");
		java.sql.Date date = null;	
		if (birthday != null && birthday.trim().length() > 0) {
			try {
				date = java.sql.Date.valueOf(birthday);
				bean.setBirthday(date);
			} catch (IllegalArgumentException e) {
				errorMessage.put("birthday","生日欄格式錯誤");
			}
		}
		String address = request.getParameter("address");
		if (address != null ) {
			bean.setAddress(address);
		}
		if (!errorMessage.isEmpty()) {
			RequestDispatcher rd = request
					.getRequestDispatcher("/display/regisChange.jsp");
			rd.forward(request, response);
			return;
		}
	
		MemberService service = new MemberService();
		service.updateRegistration(bean);
		RequestDispatcher rd = request.getRequestDispatcher("/display/finished.jsp");
		session.removeAttribute("member");
		session.setAttribute("member", bean);
		rd.forward(request,response);		
	}
}
