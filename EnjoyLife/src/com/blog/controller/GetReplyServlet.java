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
import com.member.model.MemberDAO;
import com.member.model.MemberVO;
import com.util.HibernateUtil;

@WebServlet("/GetReplyServlet")
public class GetReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetReplyServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String postNo = request.getParameter("ArticleNo");
		List result =new ArrayList();
		String returnValue ="";
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		BlogReplyDAO dao = new BlogReplyDAOHibernate(session);
		MemberDAO memDao = new MemberDAO();
		session.beginTransaction();
		List<BlogReplyVO> list = dao.selectByPostNo(postNo);
		if(list!=null){
			for(BlogReplyVO bean:list){
				Map<String,String> map = new HashMap<String,String>();
				map.put("replyMemberId", bean.getReplyMemberId());
				MemberVO memBean = memDao.SelectById(bean.getReplyMemberId());
				System.out.println(bean.getReplyMemberId());
				int picNo = memBean.getPicture();
				System.out.println(picNo);
				map.put("memPic", String.valueOf(picNo));
				map.put("replyContext", bean.getReplyContext());
				map.put("replyDate", bean.getReplyDate()+"");
				map.put("flagDelete", bean.getFlagDelete()+"");
				result.add(map);
			}
			session.getTransaction().commit();
			returnValue = "sucess";
		}else{
			session.getTransaction().rollback();
			returnValue = "failed";
		}
		response.setContentType("text/html;charset=UTF-8");
		String jsonString = JSONValue.toJSONString(result);
		response.getWriter().write(jsonString);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
