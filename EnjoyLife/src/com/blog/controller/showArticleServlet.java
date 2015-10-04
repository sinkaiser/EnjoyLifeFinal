package com.blog.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.json.simple.JSONValue;

import com.blog.model.BlogDAO;
import com.blog.model.BlogVO;
import com.blog.model.Hibernate.BlogDAOHibernate;
import com.member.model.MemberDAO;
import com.member.model.MemberDAO_interface;
import com.member.model.MemberVO;
import com.util.HibernateUtil;


@WebServlet("/showArticleServlet")
public class showArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public showArticleServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String postNo = request.getParameter("PostNo");
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		BlogDAO dao = new BlogDAOHibernate(session);
		
		session.beginTransaction();
		BlogVO bean =dao.selectByPost(postNo);
		if(bean==null){
			session.getTransaction().rollback();
			return;
		}
		 Map<String,String> m1 = new HashMap<String,String>();      
		 
		 m1.put("memberId",bean.getMemberId());   
		 MemberDAO_interface memDao = new MemberDAO();
		 MemberVO membean = memDao.SelectById(bean.getMemberId());
		 m1.put("memberName",membean.getMemberName()); 
		 m1.put("postNo",bean.getPostNo());   
		 m1.put("postType",bean.getPostType());   
		 m1.put("postTitle",bean.getPostTitle());   
		 m1.put("avgScore",bean.getAvgScore()+"");   
		 m1.put("viewTotal",bean.getViewTotal()+"");   
		 m1.put("postDate",bean.getPostDate()+"");   
		 m1.put("pathPhoto",bean.getPathPhoto());   
		 m1.put("postContent",bean.getPostContext());   
		 m1.put("AttractionsNo",bean.getAttractionsNo()+"");   

		if(!dao.updateViewAmount(postNo)){
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		response.setContentType("text/html;charset=UTF-8");
		String jsonString = JSONValue.toJSONString(m1);
		response.getWriter().write(jsonString);	 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
