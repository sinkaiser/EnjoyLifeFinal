package com.blog.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.blog.model.Hibernate.BlogDAOHibernate;
import com.util.HibernateUtil;

/**
 * Servlet implementation class AdminDeleteByPostNo
 */
@WebServlet("/AdminDeleteByPostNo")
public class AdminDeleteByPostNo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDeleteByPostNo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String postNo=request.getParameter("postNo");
		response.setContentType("text/html;charset=UTF-8");
		
		if(postNo!=null && postNo.length()!=0){
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			BlogDAOHibernate dao=new BlogDAOHibernate(session);
			
			try {
				session.beginTransaction();
				dao.delete(postNo);
				session.beginTransaction().commit();
			} catch (HibernateException e) {
				session.beginTransaction().rollback();
				
				response.getWriter().write("error");
				return;
			}
			
			response.getWriter().write("ok");
			return;
		}
		
		
		response.getWriter().write("what");
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
