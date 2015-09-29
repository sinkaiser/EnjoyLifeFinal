package com.attendpartner.model;

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
			Query query = session.createQuery("UPDATE AttendPartnerVO set hidden = 1 where eventNo = ?");
			query.setParameter(0, attendPartnerVO.getEventNo());
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
		// TODO Auto-generated method stub
		return null;
	}

}
