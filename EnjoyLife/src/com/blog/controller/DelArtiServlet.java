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
import com.blog.model.Hibernate.BlogDAOHibernate;
import com.util.HibernateUtil;

@WebServlet("/DelArtiServlet")
public class DelArtiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DelArtiServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String articleNo = request.getParameter("ArticleNo");		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		BlogDAO dao  = new BlogDAOHibernate(session);
		session.beginTransaction();
		boolean result = dao.deletePost(new java.util.Date(), "T", articleNo);
		if(!result){
			session.getTransaction().rollback();
		}else{
			session.getTransaction().commit();
		}
		response.setContentType("text/html;charset=UTF-8");
		String jsonString = JSONValue.toJSONString(result);
		response.getWriter().write(jsonString);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
