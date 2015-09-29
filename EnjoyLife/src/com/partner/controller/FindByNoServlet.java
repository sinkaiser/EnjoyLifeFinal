package com.partner.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.partner.model.PartnerService;
import com.partner.model.PartnerVO;

@WebServlet("/partner/FindByNoServlet")
public class FindByNoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Collection<String> errorMessage = new ArrayList<String>();
		request.setAttribute("ErrorMsg", errorMessage);
		
		request.setCharacterEncoding("UTF-8");
		String eventNo = request.getParameter("eno");
		if (eventNo == null || (eventNo.trim()).length() == 0) {
			errorMessage.add("請輸入活動編號");
		}
		if (!errorMessage.isEmpty()) {
			RequestDispatcher failureView = request
					.getRequestDispatcher("/partner/InsertPartnerError.jsp");
			failureView.forward(request, response);
			return;//程式中斷
		}
		
		int ieventNo = Integer.parseInt(eventNo);
		
		PartnerService service = new PartnerService();
		List<PartnerVO> list = new ArrayList<PartnerVO>();
		list = service.findByNo(ieventNo);
		request.setAttribute("AllPartners", list);
		
		
		if(list == null || list.isEmpty()) {
			errorMessage.add("查無資料");
		}
		if (!errorMessage.isEmpty()) {
			RequestDispatcher failureView = request
					.getRequestDispatcher("/partner/InsertPartnerError.jsp");
			failureView.forward(request, response);
			return;//程式中斷
		}
		
		
		
		
//		System.out.println(1);
//		for(PartnerVO bean:list){
//			System.out.println(bean.getEventTitle());
//		}
		
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("showAllPartners.jsp");
		rd.forward(request, response);
	}

}
