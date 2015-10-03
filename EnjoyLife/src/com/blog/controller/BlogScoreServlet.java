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

@WebServlet("/BlogScoreServlet")
public class BlogScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BlogScoreServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ArticleNo = request.getParameter("ArticleNo");
		String score = request.getParameter("score");
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		session.beginTransaction();
		BlogDAO dao = new BlogDAOHibernate(session);
		boolean result = dao.updateAvgScore(Integer.parseInt(score), ArticleNo);
		if(!result){
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		response.setContentType("text/html;charset=UTF-8");
		String jsonString = JSONValue.toJSONString(result);
		response.getWriter().write(jsonString);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
