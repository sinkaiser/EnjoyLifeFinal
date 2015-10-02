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

import com.AttracModel.CountyBean;
import com.AttracModel.CountyDao;
import com.util.HibernateUtil;

public class CountyDaoHiber implements CountyDao{

	public static void main(String[] args) {
		List<CountyBean> beans =new ArrayList<CountyBean>();
		CountyDaoHiber dao =new CountyDaoHiber();
		beans=dao.selectall();
		for(CountyBean bean:beans){
			System.out.println(bean);
		}
	}
	
	private static final String SELECT_ALL =
			"from CountyBean";
	@Override
	public List<CountyBean> selectall() {
		List<CountyBean> result = null;
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

	

}
