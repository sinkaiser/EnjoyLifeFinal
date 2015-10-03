package com.activity.controller;

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
import com.partner.model.PartnerDAOHibernate;
import com.partner.model.PartnerDAO_interface;
import com.partner.model.PartnerVO;
import com.util.HibernateUtil;


@WebServlet("/GetIndexInfoServlet")
public class GetIndexInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public GetIndexInfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		BlogDAO blogdao = new BlogDAOHibernate(session);
		
		session.beginTransaction();
		List<BlogVO> bloglist = blogdao.selectByViews();
		if(bloglist!=null){			
			session.getTransaction().commit();
		}else{
			session.getTransaction().rollback();
		}
		
		PartnerDAO_interface parterdao = new PartnerDAOHibernate();
		List<PartnerVO> parterlist = parterdao.selectTop5ByDate();
	
		request.getSession().setAttribute("bloglist",bloglist );
		request.getSession().setAttribute("parterlist",parterlist );
		response.setContentType("text/html;charset=UTF-8");
//		request.getRequestDispatcher(request.getContextPath()+"/kaijie_TEST.jsp").forward(request, response);
//		response.sendRedirect(request.getContextPath()+"/kaijie_TEST.jsp");
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
