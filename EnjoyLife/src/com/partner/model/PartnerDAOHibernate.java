package com.partner.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.blog.model.Hibernate.BlogDAOHibernate;
import com.partner.model.PartnerVO;

public class PartnerDAOHibernate implements PartnerDAO_interface {
	
	public static void main(String[] args) {
		PartnerDAOHibernate dao = new PartnerDAOHibernate();
		PartnerVO bean = new PartnerVO();
		dao.getAll();

	}
	@Override
	public PartnerVO insert(PartnerVO partnerVO) {
		System.out.println("aa");
		Session session = com.util.HibernateUtil.getSessionFactory().getCurrentSession();
		System.out.println("bb");
		try {
			session.beginTransaction();
			
			session.save(partnerVO);
			session.beginTransaction().commit();
			System.out.println("cc");
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			System.out.println("dd");
		}
		return partnerVO;
	}

	@Override
	public PartnerVO update(PartnerVO partnerVO) {
		Session session = com.util.HibernateUtil.getSessionFactory().getCurrentSession();
		PartnerVO result =null;
		try {
			session.beginTransaction();
//			session.update(partnerVO);
			Query query = session.createQuery("UPDATE PartnerVO set eventType=?, eventContent=?, addr=?, modifyDate=? where eventNo = ?");
			query.setParameter(0, partnerVO.getEventType());
			query.setParameter(1, partnerVO.getEventContent());
			query.setParameter(2, partnerVO.getAddr());
			query.setParameter(3, partnerVO.getModifyDate());
			query.setParameter(4, partnerVO.getEventNo());
			query.executeUpdate();
			session.beginTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean delete(Integer eventNo) {
		Session session = com.util.HibernateUtil.getSessionFactory().getCurrentSession();
		
		try {
			session.beginTransaction();
			PartnerVO partnerVO = (PartnerVO) session.get(PartnerVO.class, eventNo);
			session.delete(partnerVO);
			session.beginTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public PartnerVO hidden(PartnerVO partnerVO) {
		Session session = com.util.HibernateUtil.getSessionFactory().getCurrentSession();
		PartnerVO result =null;
		try {
			session.beginTransaction();
			Query query = session.createQuery("UPDATE PartnerVO set hidden = 1 where eventNo = ?");
			query.setParameter(0, partnerVO.getEventNo());
			query.executeUpdate();
			
			session.beginTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public PartnerVO close(PartnerVO partnerVO) {
		Session session = com.util.HibernateUtil.getSessionFactory().getCurrentSession();
		PartnerVO result =null;
		try {
			session.beginTransaction();
			Query query = session.createQuery("UPDATE PartnerVO set closed = 1 where eventNo = ?");
			query.setParameter(0, partnerVO.getEventNo());
			query.executeUpdate();
			
			session.beginTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public List<PartnerVO> selectByEventNo(Integer eventNo) {
		Session session = com.util.HibernateUtil.getSessionFactory().getCurrentSession();
		List<PartnerVO> result = new ArrayList<PartnerVO>();
		try {
			session.beginTransaction();
			Query query = session.createQuery("from PartnerVO where hidden=0 and eventNo = ? order by eventDate desc");
			query.setParameter(0, eventNo);
			List<Object> list = query.list();
			for(Object item :list){
				result.add((PartnerVO)item);
			}
			
			session.beginTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public List<PartnerVO> selectById(String memberId) {
		Session session = com.util.HibernateUtil.getSessionFactory().getCurrentSession();
		List<PartnerVO> result = new ArrayList<PartnerVO>();
		try {
			session.beginTransaction();
			Query query = session.createQuery("from PartnerVO where hidden=0 and memberId = ? order by eventDate desc");
			query.setParameter(0, memberId);
			List<Object> list = query.list();
			for(Object item :list){
				result.add((PartnerVO)item);
			}
			
			session.beginTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public List<PartnerVO> selectByIdOver(String memberId) {
		Session session = com.util.HibernateUtil.getSessionFactory().getCurrentSession();
		List<PartnerVO> result = new ArrayList<PartnerVO>();
		try {
			session.beginTransaction();
			Query query = session.createQuery("from PartnerVO where hidden=1 and closed=0 and memberId = ? order by eventDate desc");
			query.setParameter(0, memberId);
			List<Object> list = query.list();
			for(Object item :list){
				result.add((PartnerVO)item);
			}
			
			session.beginTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<PartnerVO> selectByEventType(String eventType) {
		Session session = com.util.HibernateUtil.getSessionFactory().getCurrentSession();
		List<PartnerVO> result = new ArrayList<PartnerVO>();
		try {
			session.beginTransaction();
			Query query = session.createQuery("from PartnerVO where hidden=0 and eventType = ? order by eventDate desc");
			query.setParameter(0, eventType);
			List<Object> list = query.list();
			for(Object item :list){
				result.add((PartnerVO)item);
			}
			
			session.beginTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<PartnerVO> selectByEventTitleAndEventContent(String eventContent) {
		Session session = com.util.HibernateUtil.getSessionFactory().getCurrentSession();
		List<PartnerVO> result = new ArrayList<PartnerVO>();
		try {
			session.beginTransaction();
			Query query = session.createQuery("from PartnerVO where hidden=0 and (eventContent like ?) order by eventDate desc");
			query.setParameter(0, "%"+eventContent+"%");
			List<Object> list = query.list();
			for(Object item :list){
				result.add((PartnerVO)item);
			}
			
			session.beginTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<PartnerVO> getAll() {
		Session session = com.util.HibernateUtil.getSessionFactory().getCurrentSession();
		List<PartnerVO> result = null;
		Transaction tx = null; 
		try {
			tx=session.beginTransaction();
			Query query = session.createQuery("from PartnerVO where hidden=0 order by eventDate desc");
			result = query.list();
			
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public List<PartnerVO> getAllAdmin() {
		Session session = com.util.HibernateUtil.getSessionFactory().getCurrentSession();
		List<PartnerVO> result = null;
		try {
			session.beginTransaction();
			Query query = session.createQuery("from PartnerVO order by eventDate desc");
			result = query.list();
			
			session.beginTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public List<PartnerVO> selectByIndex(int index) {
		Session session = com.util.HibernateUtil.getSessionFactory().getCurrentSession();
		List<PartnerVO> result = new ArrayList<PartnerVO>();
		
		try {
			session.beginTransaction();
			Query query = session.createQuery("from PartnerVO where hidden=0 and closed=0 order by eventDate desc OFFSET ? ROWS FETCH NEXT ? ROWS ONLY");
			//query.setParameter(0, eventType);
			query.setParameter(0, index);
			query.setParameter(1, 10);
			List<Object> list = query.list();
			for(Object item :list){
				result.add((PartnerVO)item);
			}
			session.beginTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return result;
	}

}
