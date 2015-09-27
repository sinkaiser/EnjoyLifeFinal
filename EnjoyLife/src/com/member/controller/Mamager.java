package com.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.model.MemberService;
import com.member.model.MemberVO;

/**
 * Servlet implementation class Mamager
 */
@WebServlet("/Manager")
public class Mamager extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Mamager() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService service = new MemberService();
		List<MemberVO> beans = service.getAll();
		request.getSession().setAttribute("all", beans);
		response.sendRedirect(
				response.encodeRedirectURL(request.getContextPath()+"/display/manager.jsp"));
				return;	
	}
}
