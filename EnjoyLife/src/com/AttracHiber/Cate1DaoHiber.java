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

import com.AttracModel.AttracBean;
import com.AttracModel.Cate1Bean;
import com.AttracModel.Cate1Dao;
import com.util.HibernateUtil;

public class Cate1DaoHiber implements Cate1Dao {

	private static final String SELECT_ALL =
			"from Cate1Bean";
	@Override
	public List<Cate1Bean> selectall() {
		List<Cate1Bean> result = null;
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
			"from Cate1Bean where cate1no=?";
	@Override
	public Cate1Bean select(int id) {
		Cate1Bean result=null;
		Session session =HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx=session.beginTransaction();
			Query query = session.createQuery(SELECT_BY_ID);
			query.setParameter(0, id);
			List<Cate1Bean> list = query.list();
			result=list.get(0);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} 
		return result;
	}


	public static void main(String[] args) {
		List<Cate1Bean> result = new ArrayList<Cate1Bean>();
		Cate1DaoHiber dao=new Cate1DaoHiber();
		result=dao.selectall();
		for(Cate1Bean bean:result){
			System.out.println(bean);
		}
	}
}
