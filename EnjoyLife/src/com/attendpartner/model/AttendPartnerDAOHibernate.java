package com.attendpartner.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.partner.model.PartnerVO;

public class AttendPartnerDAOHibernate implements AttendPartnerDAO_interface {

	@Override
	public AttendPartnerVO insert(AttendPartnerVO attendPartnerVO) {
		Session session = com.util.HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			
			session.save(attendPartnerVO);
			session.beginTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return attendPartnerVO;
	}

	@Override
	public AttendPartnerVO update(AttendPartnerVO attendPartnerVO) {
		Session session = com.util.HibernateUtil.getSessionFactory().getCurrentSession();
		AttendPartnerVO result =null;
		try {
			session.beginTransaction();
			Query query = session.createQuery("UPDATE AttendPartnerVO set eventNo=?, attend=?, partner=? where eventNo = ?");
			query.setParameter(0, attendPartnerVO.getEventNo());
			query.setParameter(1, attendPartnerVO.getAttend());
			query.setParameter(2, attendPartnerVO.getPartner());
			query.executeUpdate();
			session.beginTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public AttendPartnerVO attend(AttendPartnerVO attendPartnerVO) {
		Session session = com.util.HibernateUtil.getSessionFactory().getCurrentSession();
		AttendPartnerVO result =null;
		try {
			session.beginTransaction();
			Query query = session.createQuery("UPDATE AttendPartnerVO SET hidden = 1 WHERE eventNo = ? AND partner = ?");
			query.setParameter(0, attendPartnerVO.getEventNo());
			query.setParameter(1, attendPartnerVO.getPartner());
			query.executeUpdate();
			
			session.beginTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<AttendPartnerVO> selectByEventNoPartnrt(Integer eventNo, String partner) {
		Session session = com.util.HibernateUtil.getSessionFactory().getCurrentSession();
		List<AttendPartnerVO> result = new ArrayList<AttendPartnerVO>();
		try {
			session.beginTransaction();
			Query query = session.createQuery("from AttendPartnerVO where eventNo=? AND partner=?");
			query.setParameter(0, eventNo);
			query.setParameter(1, partner);
			List<Object> list = query.list();
			for(Object item :list){
				result.add((AttendPartnerVO)item);
			}
			
			session.beginTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public List<AttendPartnerVO> selectByEventNo(Integer eventNo) {
		Session session = com.util.HibernateUtil.getSessionFactory().getCurrentSession();
		List<AttendPartnerVO> result = new ArrayList<AttendPartnerVO>();
		try {
			session.beginTransaction();
			Query query = session.createQuery("from AttendPartnerVO where eventNo=?");
			query.setParameter(0, eventNo);
			List<Object> list = query.list();
			for(Object item :list){
				result.add((AttendPartnerVO)item);
			}
			
			session.beginTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return result;
	}

}
