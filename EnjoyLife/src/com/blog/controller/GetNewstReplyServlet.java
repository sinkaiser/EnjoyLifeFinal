package com.blog.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

@WebServlet("/GetNewstReplyServlet")
public class GetNewstReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetNewstReplyServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		session.beginTransaction();
		BlogReplyDAO dao = new BlogReplyDAOHibernate(session);
		List<BlogReplyVO> list = dao.SelectTop10();
		List resultList = new ArrayList<>();
		if(list!=null){
			for(BlogReplyVO bean:list){
				Map<String,String> map = new HashMap<String,String>();
				map.put("memid", bean.getReplyMemberId());
				map.put("postno", bean.getPostNo());
				map.put("context", bean.getReplyContext());
				resultList.add(map);
			}	
			session.getTransaction().commit();
		}else{
			session.getTransaction().rollback();
		}
		
		response.setContentType("text/html;charset=UTF-8");
		String jsonString = JSONValue.toJSONString(resultList);
		response.getWriter().write(jsonString);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
	}

}
