package com.util;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;


public class ImgListDaoHibernate implements ImgListDao {

	@Override
	public List<ImgListBean> getAll() {
		Session session = com.util.HibernateUtil.getSessionFactory().getCurrentSession();
		
		List<ImgListBean> result=null;
		
		try {
			session.beginTransaction();
			Query query=session.createQuery("from ImgListBean order by imgNo");
			result=query.list();	
			session.beginTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public String selectType(int id) {
		Session session = com.util.HibernateUtil.getSessionFactory().getCurrentSession();
		
		String result=null;
		
		try {
			session.beginTransaction();
			Query query=session.createQuery("select imgType from ImgListBean where id="+id);
			List<String>lists=query.list();
			for(String list:lists){
				result=list;
			}
			
			session.beginTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public ImgListBean select(int id) {
		Session session = com.util.HibernateUtil.getSessionFactory().getCurrentSession();
		
		ImgListBean result=null;

		try {
			session.beginTransaction();
			result=(ImgListBean)session.get(ImgListBean.class,id);
			session.beginTransaction().commit();
		
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int insert(ImgListBean imgListBean) {
		Session session = com.util.HibernateUtil.getSessionFactory().getCurrentSession();
		
		int result=0;
		
		try {
			session.beginTransaction();
			session.save(imgListBean);
			int a=(int)session.getIdentifier(imgListBean);
			result=a;
			session.beginTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int update(ImgListBean imgListBean) {
		Session session = com.util.HibernateUtil.getSessionFactory().getCurrentSession();
		
	int result=0;
		
		try {
			session.beginTransaction();
			session.update(imgListBean);
			int a=(int)session.getIdentifier(imgListBean);
			result=a;
			session.beginTransaction().commit();
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
			ImgListBean bean=(ImgListBean)session.get(ImgListBean.class, id);
			session.delete(bean);
			int a=(int)session.getIdentifier(bean);
			result=a;
			session.beginTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		
		return result;
	}

}
