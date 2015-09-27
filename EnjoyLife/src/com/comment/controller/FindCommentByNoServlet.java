package com.comment.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.comment.model.CommentService;
import com.comment.model.CommentVO;

@WebServlet("/comment/FindCommentByNoServlet")
public class FindCommentByNoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Collection<String> errorMessage = new ArrayList<String>();
		request.setAttribute("ErrorMsg", errorMessage);
		
		request.setCharacterEncoding("UTF-8");
		String eventNo = request.getParameter("eno");
		if (eventNo == null || (eventNo.trim()).length() == 0) {
			errorMessage.add("請輸入活動編號");
		}
		if (!errorMessage.isEmpty()) {
			RequestDispatcher failureView = request
					.getRequestDispatcher("/comment/InsertCommentError.jsp");
			failureView.forward(request, response);
			return;//程式中斷
		}
		
		int ieventNo = Integer.parseInt(eventNo);
		
		CommentService service = new CommentService();
		List<CommentVO> list = new ArrayList<CommentVO>();
		list = service.findByEventNo(ieventNo);
		request.setAttribute("AllComments", list);
		
		
		if(list == null || list.isEmpty()) {
			errorMessage.add("查無資料");
		}
		if (!errorMessage.isEmpty()) {
			RequestDispatcher failureView = request
					.getRequestDispatcher("/comment/InsertCommentError.jsp");
			failureView.forward(request, response);
			return;//程式中斷
		}
		
		
		
		
		System.out.println(1);
		for(CommentVO bean:list){
			System.out.println(bean.getEventNo());
		}
		
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("showAllComments.jsp");
		rd.forward(request, response);
	}

}
