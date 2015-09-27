package com.activity.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.activity.model.ActivityBean;
import com.activity.model.ActivityDAO;

public class ActivityDAOJdbc implements ActivityDAO {
//	private static final String URL = "jdbc:sqlserver://localhost:1433;database=activity";
//	private static final String USERNAME = "sa";
//	private static final String PASSWORD = "sa123456";
	
//	private DataSource dataSource;
//	public ActivityDAOJdbc() {
//		try {
//			Context ctx = new InitialContext();
//			this.dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/activity");
//		} catch (NamingException e) {
//			e.printStackTrace();
//		}
//	}
	
	
//	private static final String SELECT_BY_ID = 
//			"select * from activity where activityNo=?";
	@Override
	public ActivityBean select(int activityNo) {
		Session session = com.util.HibernateUtil.getSessionFactory().getCurrentSession();
		ActivityBean result = null; 
		try{
//			Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//			Connection conn = dataSource.getConnection();
//			PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID);) {
//			
//			stmt.setInt(1, activityNo);
//			rset = stmt.executeQuery();
				session.beginTransaction();
				result=(ActivityBean)session.get(ActivityBean.class,activityNo);
				session.beginTransaction().commit();
			
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}

		return result;
	}
	
	@Override
	public List<ActivityBean> select() {
		Session session = com.util.HibernateUtil.getSessionFactory().getCurrentSession();
		List<ActivityBean> result = null; 
		try {
			session.beginTransaction();
			Query query=session.createQuery("from activity order by activityNo");
			result=query.list();	
			session.beginTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	private static final String INSERT = 
			"insert into activity (activityDepiction, activityName, activityContent, activityDate,"
			+ "activityLocation, activityContact, photoPath) values (?,?,?,?,?,?,?)";
	@Override
	public ActivityBean insert(ActivityBean bean) {
		Session session = com.util.HibernateUtil.getSessionFactory().getCurrentSession();
		ActivityBean result=null;
		try {
			session.beginTransaction();
			session.save(bean);
			session.beginTransaction().commit();
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	@Override
	public ActivityBean update(ActivityBean bean) {
		Session session = com.util.HibernateUtil.getSessionFactory().getCurrentSession();
		ActivityBean result = null;
		try {
			session.beginTransaction();
			session.update(bean);
			session.beginTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
		}
		return result;
	}
	
	@Override
	public boolean delete(int activityno) {
		Session session = com.util.HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			ActivityBean bean = (ActivityBean) session.get(ActivityBean.class, activityno);
			session.delete(bean);
			session.beginTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
		}
		return false;
	}

}
