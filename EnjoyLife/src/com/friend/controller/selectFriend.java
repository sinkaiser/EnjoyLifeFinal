package com.friend.controller;
import java.io.IOException;
import java.io.PrintWriter;
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
import javax.servlet.http.HttpSession;

import com.friend.model.FriendService;
import com.friend.model.FriendVO;
import com.member.model.MemberDAO;
import com.member.model.MemberDAO_interface;
import com.member.model.MemberService;
import com.member.model.MemberVO;


@WebServlet("/friend/selectFriend.do") 
public class selectFriend extends HttpServlet {
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
		String memberId = bean.getMemberId();	
		FriendService service = new FriendService();
		MemberService service2 = new MemberService();
		// MemberBean 扮演封裝輸入資料的角色		
		List<FriendVO> bean2 = service.select_by_friend(memberId);
		MemberDAO_interface dao = new MemberDAO();
		List<Map<String,Object>> mp = new ArrayList<Map<String,Object>>();
		for(FriendVO friend:bean2){
			Map<String,Object> map = new HashMap<String, Object>();
			int result = service2.SelectByCount(friend.getFriendId());
			MemberVO bean9 = dao.SelectById(friend.getFriendId());
			int picture = bean9.getPicture();
			String friendname = bean9.getMemberName();
			map.put("FriendVO", friend);
			map.put("Picture", picture);
			map.put("FriendName", friendname);
			map.put("Count", result);
			mp.add(map);
		}
		request.setAttribute("selectFriend", mp);
		request.getRequestDispatcher("/friend/selectSuccess.jsp").forward(request, response);
		return;
//		for(FriendVO bean1:bean2)
//		{
//			System.out.println(bean1.getFriendId());
//		}	
//		response.sendRedirect(
//		response.encodeRedirectURL(request.getContextPath()+"/friend/friend.jsp"));
//		return;	
//					
		}
}
