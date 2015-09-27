package com.blog.controller;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.blog.model.BlogSortDAO;
import com.blog.model.BlogSortVO;
import com.blog.model.Hibernate.BlogSortDAOHibernate;
import com.util.HibernateUtil;

public class BlogSortService {
	public List<BlogSortVO> getAll(){
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		BlogSortDAO dao = new BlogSortDAOHibernate(session);
		List<BlogSortVO> list = null;
		try {
			session.beginTransaction();
			list = dao.selectAll();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return list;
	}
}
