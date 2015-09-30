package com.little.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetLittleJson
 */
@WebServlet("/GetLittleJson")
public class GetLittleJson extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public GetLittleJson() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LittleService lService=new LittleService();
		response.setContentType("text/html;charset=UTF-8");
		
		String No=request.getParameter("No");
		String id=request.getParameter("id");
		
		
		if(id.equals("1")){
			
			if(No==null){
				String json=lService.getLittleJson();
				response.getWriter().write(json);
			}else{
				String json=lService.getOneLittleJson(Integer.parseInt(No));
				response.getWriter().write(json);
			}
		}
		if(id.equals("2")){
			String json=lService.getTypeJson();
			response.getWriter().write(json);
		}
		if(id.equals("3")){
			String json=lService.getTargetJson();
			response.getWriter().write(json);
		}
	}
}
