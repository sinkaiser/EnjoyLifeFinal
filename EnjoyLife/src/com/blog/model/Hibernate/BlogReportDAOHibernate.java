package com.blog.model.Hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.blog.model.BlogReportDAO;
import com.blog.model.BlogReportVO;

public class BlogReportDAOHibernate implements BlogReportDAO {
	private Session session =null;
	
	public BlogReportDAOHibernate(Session session){
		this.session = session;
	}
	
	@Override
	public boolean insert(BlogReportVO bean) {
		boolean result = false;
		try {
			session.save(bean);	
			result = true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<BlogReportVO> selectByBlog(String postNo) {
		String SQL_SELECT_BY_POSTNO="FROM BlogReportVO WHERE postNo=?"; 	
		List<BlogReportVO> list = null;
		try {
			Query query = session.createQuery(SQL_SELECT_BY_POSTNO);
			query.setParameter(0, postNo);
			list = (List<BlogReportVO>)query.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void main(String[] args) {


	}

}
