package com.friend.controller;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.friend.model.FriendService;
import com.member.model.MemberVO;


@WebServlet("/friend/deleteFriend.do") 
public class deleteFriend extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		MemberVO bean = (MemberVO)session.getAttribute("member");
		String memberId = bean.getMemberId();
		String friendId = request.getParameter("id");
		Map<String, String> errorMessage = new HashMap<>();
		FriendService fservice = new FriendService();
		request.setAttribute("ErrorMsg", errorMessage);		
		
		if (!errorMessage.isEmpty()) {		
			RequestDispatcher rd = request
					.getRequestDispatcher("/friend/deleteFriend.jsp");
			rd.forward(request, response);			
			return;
		}
		// MemberBean 扮演封裝輸入資料的角色									
		fservice.deleteFriend(friendId,memberId);
		fservice.deleteFriend(memberId,friendId);
		response.sendRedirect(
		response.encodeRedirectURL(request.getContextPath()+"/friend/friend.jsp"));
		return;	
					
		}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
}
