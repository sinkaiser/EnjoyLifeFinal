package com.partner.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.partner.model.PartnerDAOHibernate;
import com.partner.model.PartnerDAO_interface;
import com.partner.model.PartnerService;
import com.partner.model.PartnerVO;

@WebServlet("/ListPartnerServlet")
public class ListPartnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int index = Integer.parseInt(request.getParameter("Index"));
		//String eventType = request.getParameter("type");
		request.setCharacterEncoding("UTF-8");

		PartnerService service = new PartnerService();
		List<PartnerVO> list = new ArrayList<PartnerVO>();
		list = service.findByIndex(index);
		for(PartnerVO bean:list){
			System.out.println(bean.getAddr());
		}
		request.getSession().setAttribute("PartnerList", list);
		request.getSession().setAttribute("listIndex", index);
		response.setContentType("text/html;charset=UTF-8");
//		request.getRequestDispatcher("/blog/blogList.jsp").forward(request, response);
		response.sendRedirect(request.getContextPath()+"/partner/PartnerList.jsp");
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
