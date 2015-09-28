package com.AttracHiber;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;

import com.AttracModel.AttracBean;
import com.AttracModel.AttracDao;

import com.util.HibernateUtil;


public class AttracDaoHiber implements AttracDao {
	public static void main(String[] args) {
		AttracDao hiberdao = new AttracDaoHiber();
		AttracBean bean=new AttracBean();
		bean.setStitle("士林官邸");
		
		System.out.println(hiberdao.selectAttracNo(bean));

	}

	private static final String SELECT_BY_ID =
			"from AttracBean where rownumber=?";	
	@Override
	public AttracBean select(int id) {
		AttracBean result=null;
		Session session =HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
			try {
				tx=session.beginTransaction();
				Query query = session.createQuery(SELECT_BY_ID);
				query.setParameter(0, id);
				List<AttracBean> list = query.list();
				result=list.get(0);
				tx.commit();
			} catch (Exception e) {
				tx.rollback();
				e.printStackTrace();
			}
		return result;
	}

	private static final String SELECT_ALL =
			"from AttracBean";
	@Override
	public List<AttracBean> selectall() {
		List<AttracBean> result = null;
		Session session =HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery(SELECT_ALL);
			result = query.list();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return result;
	}


	@Override
	public boolean insert(AttracBean bean) {
		boolean result = false;
		Session session =HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(bean);
			result=true;
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return result;
	}

	

	@Override
	public boolean update(AttracBean bean) {		
		boolean result = false;
		Session session =HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(bean);
			result = true;
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean delete(int id) {
		boolean result = false;
		Session session =HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			AttracBean attracbean = (AttracBean) session.get(AttracBean.class, id);
			session.delete(attracbean);
			result = true;
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return result;
	}
	private static final String SELECT_PK =
			"select rownumber from AttracBean group by rownumber order by rownumber desc";
	@Override
	public Integer selectPK() {
		int result=0;
		Session session =HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery(SELECT_PK);
			List<Integer> list = query.list();
			result=list.get(0);			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return result;
	}

	private static final String SELECT_AttracNo =
			"select rownumber from AttracBean where stitle=?";
	@Override
	public Integer selectAttracNo(AttracBean bean) {
		int result=0;
		Session session =HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery(SELECT_AttracNo);
			query.setParameter(0, bean.getStitle());
			List<Integer> list = query.list();
			result=list.get(0);			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return result;
	}

	public List<Object[]> selectByName(String name){
		List<Object[]> result = null;
		Session session =HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			System.out.println("AAAAAAA");
			session.beginTransaction();
			Query query = session.createQuery("select rownumber, stitle from AttracBean where stitle like '%"+name+"%'");	
//			Query query =session.createSQLQuery("select attracno,stitle from Attrac t where stitle like '%"+name+"%'").setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
			result = query.list();
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}		
		return result;
	}
}
