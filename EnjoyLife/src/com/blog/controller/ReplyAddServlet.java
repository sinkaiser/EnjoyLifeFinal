package com.blog.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.json.simple.JSONValue;

import com.blog.model.BlogReplyDAO;
import com.blog.model.BlogReplyVO;
import com.blog.model.Hibernate.BlogReplyDAOHibernate;
import com.util.HibernateUtil;

@WebServlet("/ReplyAddServlet")
public class ReplyAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReplyAddServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String postno = request.getParameter("ArticleNo");
		String reply  = request.getParameter("replyContex");
		
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		BlogReplyDAO dao = new BlogReplyDAOHibernate(session);
		
		session.beginTransaction();
		BlogReplyVO bean = new BlogReplyVO();
		int replyno = dao.getReplyNo(postno)+1;
		bean.setPostNo(postno);
		bean.setReplyMemberId("yoman");
		bean.setReplyNo(replyno);
		bean.setReplyContext(reply);
		bean.setReplyDate(new java.util.Date());
		bean.setFlagDelete("F");
		boolean result =dao.insertReply(bean);
		if(result){
			session.getTransaction().commit();
		}else{
			session.getTransaction().rollback();
		}

		response.setContentType("text/html;charset=UTF-8");
		String jsonString = JSONValue.toJSONString(result);
		
		response.getWriter().write(jsonString);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
