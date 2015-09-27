package com.partner.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.partner.model.PartnerService;
import com.partner.model.PartnerVO;

@WebServlet("/partner/ShowAllByAdminPartnerServlet")
public class ShowAllByAdminPartnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PartnerService service= new PartnerService();
		List<PartnerVO> list = service.findAllByAdmin();
		request.setAttribute("AllPartners", list);
		RequestDispatcher rd = request.getRequestDispatcher("showAllPartners.jsp");
		rd.forward(request, response);
     	return ; 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
