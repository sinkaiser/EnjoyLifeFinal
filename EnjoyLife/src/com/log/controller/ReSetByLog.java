package com.log.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.log.model.AdminLogBean;

/**
 * Servlet implementation class ReSetByLog
 */
@WebServlet("/ReSetByLog")
public class ReSetByLog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReSetByLog() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String time=request.getParameter("time");
		String time2=request.getParameter("time2");
		
		Date date;
		Date date2;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		try {
			date=sdf.parse(time);
			date2=sdf.parse(time);
		} catch (ParseException e) {
			date=null;
		}
		
		HttpSession session=request.getSession();
		Map<String,List<AdminLogBean>> map=(Map<String,List<AdminLogBean>>)session.getAttribute("AdminLog");
		
		
//		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
//		Date Logdate=new Date();
//		String d=sdf2.format(date);
		
		if(date.getTime()<new Date().getTime()){
			for(int p=1;p>7;p++)
			
			for(AdminLogBean bean:map.get("day"+p)){
//				if(date.getTime()<bean.getLogDate().getTime()&&
					
					
				
			}
			
		}

		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
