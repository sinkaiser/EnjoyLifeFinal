package com.message.controller;
import java.io.IOException;
import java.util.List;




import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.member.model.MemberVO;
import com.message.model.MessageService;
import com.message.model.MessageVO;


@WebServlet("/message/selectMessageAll.do") 
public class selectMessageAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		MemberVO bean = (MemberVO)session.getAttribute("member");
		String messageTo = bean.getMemberId();		
		MessageService mservice = new MessageService();
		// MemberBean 扮演封裝輸入資料的角色		
		List<MessageVO> bean2 = mservice.select_by_messageto(messageTo);
		request.setAttribute("messageTo", bean2);
		request.getRequestDispatcher("/message/selectMessageAll.jsp").forward(request, response);
		return;				
		}
}
