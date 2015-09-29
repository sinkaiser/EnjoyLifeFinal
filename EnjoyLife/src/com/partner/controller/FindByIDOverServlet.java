package com.partner.controller;

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

@WebServlet("/partner/FindByIDOverServlet")
public class FindByIDOverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Collection<String> errorMessage = new ArrayList<String>();
		request.setAttribute("ErrorMsg", errorMessage);
		
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session=(HttpSession)request.getSession();
		MemberVO bean=(MemberVO) session.getAttribute("member");
		String memberId = bean.getMemberId();
		
		if (memberId == null || (memberId.trim()).length() == 0) {
			errorMessage.add("請輸入會員ID");
		}
		if (!errorMessage.isEmpty()) {
			RequestDispatcher failureView = request
					.getRequestDispatcher("/partner/InsertPartnerError.jsp");
			failureView.forward(request, response);
			return;//程式中斷
		}
		
		PartnerService service = new PartnerService();
		
		MemberDAO_interface dao = new MemberDAO();
		List<Map<String,Object>> mp = new ArrayList<Map<String,Object>>();
		List<PartnerVO> list = service.findByIdOver(memberId);
		for(PartnerVO vo:list){
			Map<String,Object> map = new HashMap<String,Object>();
			MemberVO a=dao.SelectById(vo.getMemberId());
			int imgNo=a.getPicture();
			map.put("PartnerVO",vo);
			map.put("imgNo",imgNo);
			mp.add(map);
		}
		
		
		
		//List<PartnerVO> list = new ArrayList<PartnerVO>();
		//list = service.findById(memberId);
		request.setAttribute("AllPartners", mp);
		
		
		if(list == null || list.isEmpty()) {
			errorMessage.add("查無資料");
		}
		if (!errorMessage.isEmpty()) {
			RequestDispatcher failureView = request
					.getRequestDispatcher("/partner/InsertPartnerError.jsp");
			failureView.forward(request, response);
			return;//程式中斷
		}
		
		
		
		
		
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("listFP22.jsp");
		rd.forward(request, response);
	}

}
