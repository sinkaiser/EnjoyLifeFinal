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


@WebServlet("/friend/addFriend.do") 
public class addFriend extends HttpServlet {
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
		}else if(friendId.equals(memberId)){
			errorMessage.put("friendId","無法加入自己為好友");
		}
		else if(service.checkMemberId(friendId)){
			errorMessage.put("friendId","好友帳號不存在");
		}
		else if(count>=1){
			errorMessage.put("friendId","已經成為好友");
		}
		if (!errorMessage.isEmpty()) {		
			RequestDispatcher rd = request
					.getRequestDispatcher("/friend/addFriend.jsp");
			rd.forward(request, response);
			
			return;
		}
		// MemberBean 扮演封裝輸入資料的角色
		FriendVO fbean = new FriendVO();

//		PrintWriter out = response.getWriter();
//		out.append("好友新增成功");
		fbean.setMemberId(memberId);
		fbean.setFriendId(friendId);									
		fservice.insertfriend(fbean);
		fservice.insertmember(fbean);
		session.setAttribute("addSuccess", "申請成功");
		response.sendRedirect(
		response.encodeRedirectURL(request.getContextPath()+"/friend/friend.jsp"));
		return;	
					
		}
}
