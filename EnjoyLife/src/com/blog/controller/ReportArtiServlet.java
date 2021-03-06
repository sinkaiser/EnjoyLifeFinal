package com.blog.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.json.simple.JSONValue;

import com.blog.model.BlogDAO;
import com.blog.model.BlogReportDAO;
import com.blog.model.BlogReportVO;
import com.blog.model.Hibernate.BlogDAOHibernate;
import com.blog.model.Hibernate.BlogReportDAOHibernate;
import com.util.HibernateUtil;

@WebServlet("/ReportArtiServlet")
public class ReportArtiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ReportArtiServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
		String atrtic = request.getParameter("ArticleNo");
		String reason = request.getParameter("report");
		String member = request.getParameter("memId");
		String returnValue ="T";
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		BlogDAO blogDao = new BlogDAOHibernate(session);
		BlogReportDAO ReportDao = new BlogReportDAOHibernate(session);
		boolean flagChange = blogDao.reportChange("T", atrtic);
		if(!flagChange){
			session.getTransaction().rollback();
			returnValue ="F";
		}
		BlogReportVO bean = new BlogReportVO();
		bean.setMemberId(member);
		bean.setPostNo(atrtic);
		bean.setReason(reason);
		boolean insertResult = ReportDao.insert(bean);
		if(!insertResult){
			session.getTransaction().rollback();
			returnValue ="F";
		}
		session.getTransaction().commit();
		response.setContentType("text/html;charset=UTF-8");
		String jsonString = JSONValue.toJSONString(returnValue);
		response.getWriter().write(jsonString);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
