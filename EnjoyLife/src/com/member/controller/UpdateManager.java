package com.member.controller;


import java.io.IOException;




import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import javax.servlet.http.HttpSession;
import javax.xml.ws.Dispatch;

import com.member.model.MemberService;
import com.member.model.MemberVO;
import com.oracle.jrockit.jfr.RequestDelegate;


@WebServlet("/display/manager.do") 
public class UpdateManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String memberId = request.getParameter("memberId");
		String permission = request.getParameter("black");
		if(permission==null){
			request.setAttribute("result", memberId+"資料修改失敗");
			RequestDispatcher dr=request.getRequestDispatcher("/display/manager.jsp");
			dr.forward(request, response);
			return;	
		}
		
		
		
		
		HttpSession session = request.getSession();
		int permission2 = Integer.parseInt(permission);
		MemberService service = new MemberService();
		MemberVO bean = service.selectMemberId(memberId);
		bean.setPermission(permission2);
		MemberVO result = service.updatepermission(bean);
		System.out.println("xxx");
		
			// MemberBean 扮演封裝輸入資料的角色	
			session.removeAttribute("all");
			List<MemberVO> bean2 = service.getAll();
			request.setAttribute("result", memberId+"資料修改成功");
			session.setAttribute("all", bean2);
			RequestDispatcher dr=request.getRequestDispatcher("/display/manager.jsp");
			dr.forward(request, response);
			return;	
	
		
							
		}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
}
