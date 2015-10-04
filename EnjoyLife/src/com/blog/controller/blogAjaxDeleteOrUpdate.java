package com.blog.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.blog.model.BlogVO;
import com.blog.model.Hibernate.BlogDAOHibernate;
import com.log.controller.AdminLogService;
import com.util.HibernateUtil;

/**
 * Servlet implementation class blogAjaxDeleteOrUpdate
 */
@WebServlet("/blogAjaxDeleteOrUpdate")
public class blogAjaxDeleteOrUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public blogAjaxDeleteOrUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String postNo=request.getParameter("postNo");
		String type=request.getParameter("type");
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		response.setContentType("text/html;charset=UTF-8");
		BlogDAOHibernate dao=new BlogDAOHibernate(session);
		if(type!=null){
			if(type.equals("delete")){
			try {
				session.beginTransaction();
				dao.deletePost(new java.util.Date(), "T", postNo);
				
				session.beginTransaction().commit();
			} catch (HibernateException e) {
				response.getWriter().write("error");
				session.getTransaction().rollback();
				return;
			}
			
			String executorIp=request.getRemoteAddr();
			if(executorIp.equals("0:0:0:0:0:0:0:1")){
				executorIp="127.0.0.1";
			}
			
			
			String user="admin";
			
			AdminLogService service=new AdminLogService();
			service.add("網誌", user, executorIp, "編號:"+postNo, "移入");
			response.getWriter().write("ok");
			return;
			
			
			}else if(type.equals("update")){
				try {
					session.beginTransaction();
					dao.deletePost(new java.util.Date(), "F", postNo);
					
					
					
					session.beginTransaction().commit();
				} catch (HibernateException e) {
					response.getWriter().write("error");
					session.getTransaction().rollback();
					return;
				}
				String executorIp=request.getRemoteAddr();
				if(executorIp.equals("0:0:0:0:0:0:0:1")){
					executorIp="127.0.0.1";
				}
				
				
				String user="admin";
				
				AdminLogService service=new AdminLogService();
				service.add("網誌", user, executorIp, "編號:"+postNo, "移出");
				
			response.getWriter().write("ok");
			return;
			}
			else if(type.equals("ok")){
				try {
					session.beginTransaction();
						dao.reportChange("F", postNo);
						
						
					session.beginTransaction().commit();
				} catch (HibernateException e) {
					response.getWriter().write("error");
					session.getTransaction().rollback();
					return;
				}
				String executorIp=request.getRemoteAddr();
				if(executorIp.equals("0:0:0:0:0:0:0:1")){
					executorIp="127.0.0.1";
				}
				
				
				String user="admin";
				
				AdminLogService service=new AdminLogService();
				service.add("網誌", user, executorIp, "編號:"+postNo, "解除");
			response.getWriter().write("ok");
			return;
			}
			else if(type.equals("back")){
				try {
					session.beginTransaction();
					dao.deletePost(new java.util.Date(), "F", postNo);
					
					
					
					session.beginTransaction().commit();
				} catch (HibernateException e) {
					response.getWriter().write("error");
					session.getTransaction().rollback();
					return;
				}
				String executorIp=request.getRemoteAddr();
				if(executorIp.equals("0:0:0:0:0:0:0:1")){
					executorIp="127.0.0.1";
				}
				
				
				String user="admin";
				
				AdminLogService service=new AdminLogService();
				service.add("網誌", user, executorIp, "編號:"+postNo, "移出");
				response.getWriter().write("ok");
				return;
			}
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
