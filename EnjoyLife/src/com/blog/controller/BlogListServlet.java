package com.blog.controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.blog.model.BlogDAO;
import com.blog.model.BlogVO;
import com.blog.model.Hibernate.BlogDAOHibernate;
import com.util.HibernateUtil;

@WebServlet("/BlogListServlet")
public class BlogListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BlogListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		BlogDAO dao = new BlogDAOHibernate(session);
		
		int index = Integer.parseInt(request.getParameter("Index"));
		String postType = request.getParameter("pType");
		if(postType==""){
			postType="ALL";
		}
		request.setCharacterEncoding("UTF-8");
		session.beginTransaction();
		List<BlogVO> list = dao.selectByIndex(index, postType);
		if(list!=null){
			request.getSession().setAttribute("blogList", list);
			request.getSession().setAttribute("listIndex", index);
			request.getSession().setAttribute("selType", postType);
			session.getTransaction().commit();
			response.setContentType("text/html;charset=UTF-8");
//		request.getRequestDispatcher(request.getContextPath()+"/blog/blogList.jsp").forward(request, response);
			response.sendRedirect(request.getContextPath()+"/blog/blogList.jsp");
		}else{
			session.getTransaction().rollback();;
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
