package com.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import com.member.model.MemberDAO;
import com.member.model.MemberDAO_interface;
import com.member.model.MemberService;
import com.member.model.MemberVO;


@WebServlet("/searchMemberAjax")
public class SearchMemberAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;       
    public SearchMemberAjax() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		PrintWriter out = response.getWriter();		
		String keyword = request.getParameter("term");
//		System.out.println(keyword);
		MemberService service = new MemberService();
		JSONArray list = service.SelectByIdLike(keyword);	
			 out.print(list);			
		}
}
