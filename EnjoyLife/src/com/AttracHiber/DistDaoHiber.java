package com.AttracHiber;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.AttracModel.DistBean;
import com.AttracModel.DistDao;
import com.util.HibernateUtil;

public class DistDaoHiber implements DistDao {
	
	private static final String SELECT_BY_ID =
			"from DistBean where countyno=?";	
	@Override
	public List<DistBean> select(int id) {
		List<DistBean> result = null;
		Session session =HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try{	
			tx=session.beginTransaction();
			Query query = session.createQuery(SELECT_BY_ID);
			query.setParameter(0, id);
			result = query.list();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return result;
	}
	private static final String SELECT_ALL =
			"from DistBean";
	@Override
	public List<DistBean> selectall() {
		List<DistBean> result = null;
		Session session =HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try{			
			tx=session.beginTransaction();
			Query query = session.createQuery(SELECT_ALL);
			result = query.list();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return result;
	}

	public static void main(String[] args) {
		DistDaoHiber distdao=new DistDaoHiber();
		List<DistBean> beans= new ArrayList<DistBean>();
		beans=distdao.select(20);
//		beans=distdao.selectall();
		for(DistBean bean:beans){
			System.out.println(bean);
		}
	}
	
}
