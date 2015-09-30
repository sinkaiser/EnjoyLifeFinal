package com.blog.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.json.simple.JSONValue;

import com.blog.model.BlogVO;
import com.blog.model.Hibernate.BlogDAOHibernate;
import com.util.HibernateUtil;

/**
 * Servlet implementation class AdminGetBlogAllJson
 */
@WebServlet("/AdminGetBlogAllJson")
public class AdminGetBlogAllJson extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public AdminGetBlogAllJson() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		BlogDAOHibernate dao=new BlogDAOHibernate(session);
		session.beginTransaction();
		List<BlogVO>beans=dao.selectAll();
		response.setContentType("text/html;charset=UTF-8");
		if(beans==null){
			
			session.getTransaction().rollback();
			response.getWriter().write("error");
			return;
		}else{
			session.beginTransaction().commit();
			List<Map<String,String>> list=new LinkedList<Map<String,String>>();
			String jsonString=null;
			for(BlogVO vo:beans){
				Map<String,String> map=new HashMap<String,String>();
				map.put("attractionsNo", String.valueOf(vo.getAttractionsNo()));
				map.put("avgScore", String.valueOf(vo.getAvgScore()));
				
				map.put("flagDelete", vo.getFlagDelete());
				map.put("flagReport", vo.getFlagReport());
				map.put("memberId", String.valueOf(vo.getMemberId()));
				map.put("modifyDate", vo.getModifyDate().toString());
				map.put("pathPhoto", vo.getPathPhoto());
				map.put("postContext", vo.getPostContext());
				map.put("postDate", vo.getPostDate().toString());
				map.put("postNo", String.valueOf(vo.getPostNo()));
				map.put("postTitle", vo.getPostTitle());
				map.put("postType", vo.getPostType());
				map.put("qtyToScore", String.valueOf(vo.getQtyToScore()));
				map.put("viewTotal", String.valueOf(vo.getViewTotal()));
				list.add(map);
			}
			 jsonString = JSONValue.toJSONString(list);                    
			 response.getWriter().write(jsonString);
			 return;
		}
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
