package com.friend.controller;
import java.io.IOException;
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

import com.friend.model.FriendService;
import com.friend.model.FriendVO;
import com.member.model.MemberService;
import com.member.model.MemberVO;


@WebServlet("/friend/deleteFriendButt.do") 
public class deleteFriendButt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		MemberVO bean = (MemberVO)session.getAttribute("member");
		String memberId = bean.getMemberId();
		Map<String, String> errorMessage = new HashMap<>();
		MemberService service = new MemberService();
		FriendService fservice = new FriendService();
		request.setAttribute("ErrorMsg", errorMessage);		
		String friendId = request.getParameter("friendId");
		List<FriendVO> bean2 = fservice.select_by_friend(memberId);	
		int count = 0;
		for(FriendVO bean1:bean2){			
			if(bean1.getFriendId().equals(friendId)){
				count++;
			};			
		}
		if (friendId == null || friendId.trim().length() == 0) {
			errorMessage.put("friendId","好友帳號欄必須輸入");
		}else if(service.checkMemberId(friendId)){
			errorMessage.put("friendId","好友帳號不存在");
		}
		else if(count<1){
			errorMessage.put("friendId","還沒成為朋友");
		}
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
}
