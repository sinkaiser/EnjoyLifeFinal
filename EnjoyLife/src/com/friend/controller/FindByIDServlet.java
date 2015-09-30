package com.friend.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.member.model.MemberDAO;
import com.member.model.MemberDAO_interface;
import com.member.model.MemberVO;
import com.partner.model.PartnerService;
import com.partner.model.PartnerVO;

@WebServlet("/FindByFriendPar")
public class FindByIDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.setCharacterEncoding("UTF-8");

		String friend = request.getParameter("id");;		
		PartnerService service = new PartnerService();
		System.out.println(friend);
		List<PartnerVO> list = service.findById(friend);
		for(PartnerVO a:list){
			System.out.println(a.getEventNo());
			System.out.println(a.getEventType());
			System.out.println(a.getEventContent());
		}
		request.setAttribute("FindByFriendPar", list);			
		RequestDispatcher rd = request.getRequestDispatcher(request.getContextPath()+"/index.jsp");
		rd.forward(request, response);
	}

}
