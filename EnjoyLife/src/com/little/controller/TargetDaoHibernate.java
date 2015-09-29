package com.little.controller;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.little.model.TargetBean;

public class TargetDaoHibernate implements TargetDao {
	
	@Override
	public List<TargetBean> getAll() {
		Session session = com.util.HibernateUtil.getSessionFactory().getCurrentSession();
		
		List<TargetBean> result=null;
		
		try {
			session.beginTransaction();
			Query query=session.createQuery("from TargetBean order by targetNo");
			result=query.list();	
			session.beginTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public TargetBean select(int id) {
		Session session = com.util.HibernateUtil.getSessionFactory().getCurrentSession();
		
		TargetBean result=null;

		try {
			session.beginTransaction();
			result=(TargetBean)session.get(TargetBean.class,id);
			session.beginTransaction().commit();
		
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int insert(TargetBean targetBean) {
		Session session = com.util.HibernateUtil.getSessionFactory().getCurrentSession();
		
		int result=0;
		try {
			session.beginTransaction();
			session.save(targetBean);
			session.beginTransaction().commit();
			result++;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int update(TargetBean targetBean) {
		Session session = com.util.HibernateUtil.getSessionFactory().getCurrentSession();
		
		int result=0;
		try {
			session.beginTransaction();
			session.update(targetBean);
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
			TargetBean bean=(TargetBean)session.get(TargetBean.class, id);
			session.delete(bean);
			session.beginTransaction().commit();
			result++;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
