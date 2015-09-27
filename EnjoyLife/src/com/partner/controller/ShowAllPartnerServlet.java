package com.partner.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.model.MemberDAO;
import com.member.model.MemberDAO_interface;
import com.member.model.MemberVO;
import com.partner.model.PartnerService;
import com.partner.model.PartnerVO;

@WebServlet("/partner/ShowAllPartnerServlet")
public class ShowAllPartnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PartnerService service= new PartnerService();
		
		
		MemberDAO_interface dao = new MemberDAO();
		List<Map<String,Object>> mp = new ArrayList<Map<String,Object>>();
		List<PartnerVO> list = service.findAll();
		for(PartnerVO vo:list){
			Map<String,Object> map = new HashMap<String,Object>();
			MemberVO a=dao.SelectById(vo.getMemberId());
			int imgNo=a.getPicture();
			map.put("PartnerVO",vo);
			map.put("imgNo",imgNo);
			mp.add(map);
		}
		
		
		request.setAttribute("AllPartners", mp);
		RequestDispatcher rd = request.getRequestDispatcher("listFP.jsp");//改回showAllPartners.jsp
		rd.forward(request, response);
     	return ; 
		
//		PartnerService service= new PartnerService();
//		List<PartnerVO> list = service.findAll();
//		request.setAttribute("AllPartners", list);
//		RequestDispatcher rd = request.getRequestDispatcher("listFP.jsp");//改回showAllPartners.jsp
//		rd.forward(request, response);
//     	return ; 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
