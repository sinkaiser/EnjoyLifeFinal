package com.AttracHiber;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.AttracModel.Cate1Bean;
import com.AttracModel.Cate2Bean;
import com.AttracModel.Cate2Dao;
import com.util.HibernateUtil;

public class Cate2DaoHiber implements Cate2Dao {
	private static final String SELECT_ALL =
			"from Cate2Bean";
	@Override
	public List<Cate2Bean> selectall() {
		List<Cate2Bean> result = null;
		Session session =HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {			
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
	
	private static final String SELECT_BY_ID =
			"from Cate2Bean where cate1no=?";	
	@Override
	public List<Cate2Bean> select(int id) {
		List<Cate2Bean> result = null;
		Session session =HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {	
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

	public static void main(String[] args) {
		Cate2DaoHiber dao=new Cate2DaoHiber();
		List<Cate2Bean> beans= new ArrayList<Cate2Bean>();
		beans=dao.select(101);
//		beans=distdao.selectall();
		for(Cate2Bean bean:beans){
			System.out.println(bean);
		}

	}

}
