package com.partner.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.partner.model.PartnerService;

@WebServlet("/DataToJsonServlet")
public class DataToJsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PartnerService service = new PartnerService();
		String jsondata= service.getPartnerJson();
		response.setContentType("text/html; charset=utf-8");
		response.getWriter().write(jsondata);
		return;
	}

}
