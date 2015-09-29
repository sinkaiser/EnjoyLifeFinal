package com.little.controller;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.little.model.LittleBean;


public class LittleDaoHibernate implements LittleDao{
	

	@Override
	public List<LittleBean> getAll() {
		Session session = com.util.HibernateUtil.getSessionFactory().getCurrentSession();
		
		List<LittleBean> result=null;
		
		try {
			session.beginTransaction();
			Query query=session.createQuery("from LittleBean order by elfNo");
			result=query.list();	
			session.beginTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public LittleBean select(int id) {
		Session session = com.util.HibernateUtil.getSessionFactory().getCurrentSession();
		
		LittleBean result=null;

		try {
			session.beginTransaction();
			result=(LittleBean)session.get(LittleBean.class,id);
			session.beginTransaction().commit();
		
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int insert(LittleBean littleBean) {
		Session session = com.util.HibernateUtil.getSessionFactory().getCurrentSession();
		
		int result=0;
		
		try {
			session.beginTransaction();
			session.save(littleBean);
			session.beginTransaction().commit();
			result++;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int update(LittleBean littleBean) {
		Session session = com.util.HibernateUtil.getSessionFactory().getCurrentSession();
		
	int result=0;
		
		try {
			session.beginTransaction();
			session.update(littleBean);
			session.beginTransaction().commit();
			result++;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int delete(Integer id) {
		Session session = com.util.HibernateUtil.getSessionFactory().getCurrentSession();
		
		int result=0;
		
		try {
			session.beginTransaction();
			LittleBean bean=(LittleBean)session.get(LittleBean.class, id);
			session.delete(bean);
			session.beginTransaction().commit();
			result++;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		
		return result;
	}

}
