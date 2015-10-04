package com.log.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.log.model.AdminLogBean;


public class AdminLogDaoHibernate implements AdminLogDao{
	
	
	@Override
	public List<AdminLogBean> selectAllLogin() {
		List<AdminLogBean> result=null;
		Session session = com.util.HibernateUtil.getSessionFactory().getCurrentSession();
		

		try {
			session.beginTransaction();
			Query query=session.createQuery("from AdminLogBean where executeAction=?  order by logNo ");
			query.setParameter(0, "登入");
			result=query.list();	
			session.beginTransaction().commit();
		
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public Map<String,List<AdminLogBean>> getAllByday() {
		Session session = com.util.HibernateUtil.getSessionFactory().getCurrentSession();
		
		Date date=new Date();
		long time=date.getTime();
		long date1=time-1000*60*60*24;
		long date2=time-1000*60*60*24*2;
		long date3=time-1000*60*60*24*3;
		long date4=time-1000*60*60*24*4;
		long date5=time-1000*60*60*24*5;
		long date6=time-1000*60*60*24*6;
		long date7=time-1000*60*60*24*6;
		Map<String,List<AdminLogBean>> map=new HashMap<String,List<AdminLogBean>>();
		
		List<AdminLogBean> result=null;
		try {
			session.beginTransaction();
			Query query=session.createQuery("from AdminLogBean where executeAction !=? order by logNo ");
			query.setParameter(0, "登入");
			result=query.list();	
			List<AdminLogBean> day1=new LinkedList<AdminLogBean>();
			List<AdminLogBean> day2=new LinkedList<AdminLogBean>();
			List<AdminLogBean> day3=new LinkedList<AdminLogBean>();
			List<AdminLogBean> day4=new LinkedList<AdminLogBean>();
			List<AdminLogBean> day5=new LinkedList<AdminLogBean>();
			List<AdminLogBean> day6=new LinkedList<AdminLogBean>();
			List<AdminLogBean> day7=new LinkedList<AdminLogBean>();
			
			for(AdminLogBean bean:result){
				if(bean.getLogDate().getTime()>date1){
					day1.add(bean);
				}else if(bean.getLogDate().getTime()>date2){
					day2.add(bean);
				}else if(bean.getLogDate().getTime()>date3){
					day3.add(bean);
				}else if(bean.getLogDate().getTime()>date4){
					day4.add(bean);
				}else if(bean.getLogDate().getTime()>date5){
					day5.add(bean);
				}else if(bean.getLogDate().getTime()>date6){
					day6.add(bean);
				}else if(bean.getLogDate().getTime()>date7){
				day7.add(bean);
				}
			}
			map.put("day1", day1);
			map.put("day2", day2);
			map.put("day3", day3);
			map.put("day4", day4);
			map.put("day5", day5);
			map.put("day6", day6);
			map.put("day7", day7);
			
			session.beginTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		return map;
	}

	@Override
	public AdminLogBean select(int id) {
		Session session = com.util.HibernateUtil.getSessionFactory().getCurrentSession();
		
		AdminLogBean result=null;

		try {
			session.beginTransaction();
			result=(AdminLogBean)session.get(AdminLogBean.class,id);
			session.beginTransaction().commit();
		
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int insert(AdminLogBean adminLogBean) {
		Session session = com.util.HibernateUtil.getSessionFactory().getCurrentSession();
		
		int result=0;
		
		try {
			session.beginTransaction();
			session.save(adminLogBean);
			session.beginTransaction().commit();
			result++;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int update(AdminLogBean adminLogBean) {
		Session session = com.util.HibernateUtil.getSessionFactory().getCurrentSession();
		
	int result=0;
		
		try {
			session.beginTransaction();
			session.update(adminLogBean);
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
			AdminLogBean bean=(AdminLogBean)session.get(AdminLogBean.class, id);
			session.delete(bean);
			session.beginTransaction().commit();
			result++;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		
		return result;
	}
	
	@Override
	public int deleteByTime() {
		Session session = com.util.HibernateUtil.getSessionFactory().getCurrentSession();
		
		int result=0;
		
		try {
			session.beginTransaction();
			long time=new Date().getTime();
			Date day7ago=new Date(time-1000*60*60*24*7);
			
			Query query=session.createQuery("Delete from AdminLogBean where logDate<?");
			query.setParameter(0, day7ago);
			result=query.executeUpdate();
			
			session.beginTransaction().commit();
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		
		return result;
	}

}
