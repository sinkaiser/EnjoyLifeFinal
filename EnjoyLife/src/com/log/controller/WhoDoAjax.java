package com.log.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.json.simple.JSONValue;

import com.log.model.AdminLogBean;

/**
 * Servlet implementation class WhoDoAjax
 */
@WebServlet("/WhoDoAjax")
public class WhoDoAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WhoDoAjax() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String beginTime=request.getParameter("beginTime");
		String endTime=request.getParameter("endTime");
		
		
		System.out.println(beginTime);
		System.out.println(endTime);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date1=null;
		Date date2=null;
		try {
			date1=sdf.parse(beginTime);
			date2=sdf.parse(endTime);
		} catch (ParseException e) {
			e.printStackTrace();
			
			 response.setContentType("text/html;charset=UTF-8");
			 PrintWriter out=response.getWriter();      
			 out.write("error");
			
		}
		
		
		
		Session session = com.util.HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query=session.createQuery("from AdminLogBean where executeAction !=? and logDate > ? and logDate < ? order by logNo desc ");
		query.setParameter(0, "登入");
		query.setParameter(1, date1);
		query.setParameter(2, date2);
		List<AdminLogBean> beans=query.list();
		session.beginTransaction().commit();
		
		List<Map<String,String>> l1 = new LinkedList<Map<String,String>>();
		for(AdminLogBean bean:beans){
			Map<String,String> m1 = new HashMap<String,String>();    
		
			
			m1.put("executeAction",bean.getExecuteAction());
			m1.put("executor",bean.getExecutor());
			m1.put("executorIp",bean.getExecutorIp());
			m1.put("logDate",String.valueOf(bean.getLogDate()));
			m1.put("targetDescription",bean.getTargetDescription());

			l1.add(m1);
		}
		 String jsonString = JSONValue.toJSONString(l1);    
		 response.setContentType("text/html;charset=UTF-8");
		 PrintWriter out=response.getWriter();      
		 out.write(jsonString);
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
