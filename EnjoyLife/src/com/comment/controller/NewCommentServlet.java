package com.comment.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.comment.model.CommentService;
import com.comment.model.CommentVO;
import com.member.model.MemberVO;

@WebServlet("/comment/NewCommentServlet")
public class NewCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 定義存放錯誤訊息的 Collection物件
		Collection<String> errorMessage = new ArrayList<String>();
		request.setAttribute("ErrorMsg", errorMessage);
		
		// 設定輸入資料的編碼
		request.setCharacterEncoding("UTF-8");
		// 讀取使用者所輸入，由瀏覽器送來的 content 欄位內的資料
		String eventNo = request.getParameter("eno");
		// 檢查使用者所輸入的資料
		if (eventNo == null || eventNo.trim().length() == 0) {
			errorMessage.add("必須輸入檢舉事件編號");
		}
				
		// 讀取使用者所輸入，由瀏覽器送來的 content 欄位內的資料
		String commentContent = request.getParameter("content");
		// 檢查使用者所輸入的資料
		if (commentContent == null || commentContent.trim().length() == 0) {
			errorMessage.add("必須輸入內文");
		}
		
		Timestamp commentDate = new Timestamp(System.currentTimeMillis());
		
		HttpSession session=(HttpSession)request.getSession();
//		session.setAttribute("memberId", "kitty");
		MemberVO bean=(MemberVO) session.getAttribute("member");
		String memberId = bean.getMemberId();
		
		int closed = 0;
		
		// 如果有錯誤，呼叫view元件，送回錯誤訊息
		if (!errorMessage.isEmpty()) {
			RequestDispatcher rd = request
					.getRequestDispatcher("InsertCommentError.jsp");
			rd.forward(request, response);
			return;
		}
		
		
		Integer ieventNo = Integer.parseInt(eventNo);
		System.out.println(eventNo);
		System.out.println(commentContent);
		System.out.println(memberId);
		System.out.println(commentDate);
				
		// MemberBean 扮演封裝輸入資料的角色
		CommentVO commentVO = new CommentVO();
		commentVO.setCommentDate(commentDate);
		commentVO.setCommentContent(commentContent);
		commentVO.setEventNo(ieventNo);
		commentVO.setMemberId(memberId);
		commentVO.setClosed(closed);
		
		response.setContentType("text/html; charset=UTF-8");
		CommentService mfio = new CommentService();
		CommentVO result = mfio.addComment(commentVO);
		if(result!=null){
			response.getWriter().write("檢舉已送出");
			return;

		   }else{
			response.getWriter().write("檢舉未送出");
			return;
			}
		
		
//		try {
//			CommentService mfio = new CommentService();
// 			mfio.addComment(commentVO);
// 			request.setAttribute("partnerBean", commentVO);
// 			// 依照執行的結果挑選適當的view元件，送回相關訊息
// 			// 產生 RequestDispatcher 物件 rd
// 			RequestDispatcher rd = request
// 					.getRequestDispatcher("InsertCommentSuccess.jsp");
// 			// 請容器代為呼叫下一棒程式
// 			rd.forward(request, response);
// 			return;
// 		} catch (IOException e) {
// 			// 依照執行的結果挑選適當的view元件，送回相關訊息
// 			// 產生 RequestDispatcher 物件 rd
// 			errorMessage.add("IO錯誤:" + e.getMessage());
// 			RequestDispatcher rd = request
// 					.getRequestDispatcher("/partner/InsertCommentError.jsp");
// 			// 請容器代為呼叫下一棒程式
// 			rd.forward(request, response);
// 			return;
// 		} 
	}

}
