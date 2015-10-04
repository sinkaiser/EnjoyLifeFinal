package com.friend.controller;
import java.io.IOException;




import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




import com.friend.model.FriendService;
import com.friend.model.FriendVO;
import com.member.model.MemberVO;


@WebServlet("/friend/updateFriend.do") 
public class updateFriend extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		MemberVO bean = (MemberVO)session.getAttribute("member");
		String memberId = bean.getMemberId();

		FriendService fservice = new FriendService();
		String friendId = request.getParameter("id");
		System.out.println(friendId);
		
		// MemberBean 扮演封裝輸入資料的角色	
		FriendVO fbean = new FriendVO();
		fbean.setFriendId(friendId);
		fbean.setMemberId(memberId);
		fservice.updateFriend(fbean);
		FriendVO fbean2 = new FriendVO();
		fbean2.setFriendId(memberId);
		fbean2.setMemberId(friendId);
		fservice.updateFriend2(fbean2);
		response.sendRedirect(
		response.encodeRedirectURL(request.getContextPath()+"/friend/selectFriend.do"));
		return;	
					
		}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
}
