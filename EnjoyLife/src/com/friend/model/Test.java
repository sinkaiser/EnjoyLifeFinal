package com.friend.model;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.model.MemberService;
import com.member.model.MemberVO;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int buf=0;
		FriendDAO dao = new FriendDAO();
		FriendVO bean = new FriendVO();
		FriendService service = new FriendService();
		//加入好友
//		bean.setMemberId("micky");
//		bean.setFriendId("peter");
//		bean.setUnfriend(0);
//		buf = dao.insertfriend(bean);
//		response.setContentType("text/html;charset=UTF-8");
//		response.getWriter().append(String.valueOf(buf));
		
		//查詢帳號
//		MemberVO memberVO=new MemberVO();
//		String memberId = "kitty";
//		boolean a=new MemberService().checkMemberId(memberId);
//		if(!a){
//			System.out.println("123");
//		}else {System.out.println("456");}
//
//		
//		response.setContentType("text/html;charset=UTF-8");
//		response.getWriter().append(String.valueOf(buf));
		
		//查詢好友名單
		List<FriendVO> bean2 = service.select_by_friend("peter");
		for(FriendVO bean1:bean2)
		{
			System.out.println(bean1.getFriendId());
		}		
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().append(String.valueOf(buf));
		
		
	}

}
