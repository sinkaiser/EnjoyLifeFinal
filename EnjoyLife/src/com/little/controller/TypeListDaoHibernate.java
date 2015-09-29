package com.little.controller;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.little.model.TypeListBean;

public class TypeListDaoHibernate implements TypeListDao {

	@Override
	public List<TypeListBean> getAll() {
		Session session = com.util.HibernateUtil.getSessionFactory().getCurrentSession();
		
		List<TypeListBean> result=null;
		try {
			session.beginTransaction();
			Query query=session.createQuery("from TypeListBean order by typeNo");
			result=query.list();	
			session.beginTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public TypeListBean select(int id) {
		Session session = com.util.HibernateUtil.getSessionFactory().getCurrentSession();
		
		TypeListBean result=null;

		try {
			session.beginTransaction();
			result=(TypeListBean)session.get(TypeListBean.class,id);
			session.beginTransaction().commit();
		
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int insert(TypeListBean typeListBean) {
		Session session = com.util.HibernateUtil.getSessionFactory().getCurrentSession();
		
		int result=0;
		try {
			session.beginTransaction();
			session.save(typeListBean);
			session.beginTransaction().commit();
			result++;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int update(TypeListBean typeListBean) {
		Session session = com.util.HibernateUtil.getSessionFactory().getCurrentSession();
		int result=0;
		try {
			session.beginTransaction();
			session.update(typeListBean);
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
			TypeListBean bean=(TypeListBean)session.get(TypeListBean.class, id);
			session.delete(bean);
			session.beginTransaction().commit();
			result++;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
