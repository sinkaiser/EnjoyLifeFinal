package com.blog.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONValue;

import com.blog.model.BlogDAO;
import com.blog.model.BlogVO;
import com.blog.model.Hibernate.BlogDAOHibernate;


@WebServlet("/showArticleServlet")
public class showArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public showArticleServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String postNo = request.getParameter("PostNo");
		BlogDAO dao = new BlogDAOHibernate();
		BlogVO bean =dao.selectByPost(postNo);
		
		 Map<String,String> m1 = new HashMap<String,String>();       
		 m1.put("memberId",bean.getMemberId());   
		 m1.put("postNo",bean.getPostNo());   
		 m1.put("postType",bean.getPostType());   
		 m1.put("postTitle",bean.getPostTitle());   
		 m1.put("avgScore",bean.getAvgScore()+"");   
		 m1.put("viewTotal",bean.getViewTotal()+"");   
		 m1.put("postDate",bean.getPostDate()+"");   
		 m1.put("pathPhoto",bean.getPathPhoto());   
		 m1.put("postContent",bean.getPostContext());   
		 m1.put("AttractionsNo",bean.getAttractionsNo()+"");   
		 
		 dao.updateViewAmount(postNo);
		 
		 response.setContentType("text/html;charset=UTF-8");
		 String jsonString = JSONValue.toJSONString(m1);
		 response.getWriter().write(jsonString);	 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
