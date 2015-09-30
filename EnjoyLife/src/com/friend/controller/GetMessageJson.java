package com.friend.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class aaaaaa
 */
@WebServlet("/GetParnerJson")
public class GetMessageJson extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public GetMessageJson() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ActivityService ActivityService = new ActivityService ();
		String friend = request.getParameter("no");	

		
		if(friend!=null){
		
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().write(ActivityService.getActivityJson(friend));
		}else{
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().write("格式錯誤");
		}
	}

}
