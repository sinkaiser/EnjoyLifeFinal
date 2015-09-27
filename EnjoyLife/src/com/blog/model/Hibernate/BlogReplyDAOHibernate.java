package com.blog.model.Hibernate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.blog.model.BlogReplyDAO;
import com.blog.model.BlogReplyVO;
import com.util.HibernateUtil;

public class BlogReplyDAOHibernate implements BlogReplyDAO {
	private Session session =null;
	
	public BlogReplyDAOHibernate(Session session){
		this.session = session;
	}
	
	@Override
	public List<BlogReplyVO> selectByPostNo(String postNo) {
		String SQL_SELECT_BY_POSTNO="FROM BlogReplyVO WHERE postNo=? AND flagDelete ='F' ORDER BY replyNo"; 	
		List<BlogReplyVO> list = null;
		try {
			Query query = session.createQuery(SQL_SELECT_BY_POSTNO);
			query.setParameter(0, postNo);
			list = (List<BlogReplyVO>)query.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public int getReplyNo(String postNo){
		Query query = session.createSQLQuery("SELECT TOP(1) replyNo FROM blogReply WHERE postNO=? ORDER BY replyNo DESC");
		int result = 0;
		
		try {
			query.setParameter(0, postNo);
			List list = query.list();
			for(Object replyNo:list){
				result = (int)replyNo;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return result;
	}	
	
	@Override
	public boolean insertReply(BlogReplyVO bean) {
	
		boolean result = false;

		try {
			session.save(bean);	
			result = true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	private String SQL_UPDATE="UPDATE blogReply SET replyContext =?, replyDate=? WHERE postNo=? AND replyNo=? ";
	@Override
	public boolean updateReply(String replyContext, java.util.Date replyDate, String postNo, int replyNo) {
		boolean result =false;
		return result;
	}
	
	private String SQL_DELETE="UPDATE blogReply SET flagDelete =? WHERE postNo=? AND replyNo=?";
	@Override
	public boolean deleteReply(String flagDelete, String postNo, int replyNo) {
		boolean result = false ; 

		return result ;
	}

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		BlogReplyDAOHibernate dao = new BlogReplyDAOHibernate(session);
		
		session.beginTransaction();
		List<BlogReplyVO> list = dao.selectByPostNo("blog0000000012");
		for(BlogReplyVO bean: list){
			System.out.println(bean.getReplyNo()+","+bean.getReplyContext());
			}
		if(list!=null){
			session.getTransaction().commit();
		}else{
			session.getTransaction().rollback();
		}
	}

}
