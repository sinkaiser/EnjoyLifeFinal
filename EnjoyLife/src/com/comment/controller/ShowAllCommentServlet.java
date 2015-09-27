package com.comment.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.comment.model.CommentService;
import com.comment.model.CommentVO;

@WebServlet("/comment/ShowAllCommentServlet")
public class ShowAllCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CommentService service= new CommentService();
		List<CommentVO> list = service.findAll();
		request.setAttribute("AllComments", list);
		RequestDispatcher rd = request.getRequestDispatcher("showAllComments.jsp");
		rd.forward(request, response);
     	return ; 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
