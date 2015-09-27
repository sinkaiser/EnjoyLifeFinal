package com.comment.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;


public class CommentDAO implements CommentDAO_interface {

	@Override
	public CommentVO insert(CommentVO commentVO) {
		Session session = com.util.HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.save(commentVO);
			session.beginTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
		}
		return commentVO;
	}

	@Override
	public CommentVO update(CommentVO commentVO) {
		Session session = com.util.HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.update(commentVO);
			session.beginTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
		}
		return commentVO;
	}

	@Override
	public boolean delete(Integer commentNo) {
		Session session = com.util.HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			CommentVO commentVO = (CommentVO) session.get(CommentVO.class, commentNo);
			session.delete(commentVO);
			session.beginTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
		}
		return false;
	}

	@Override
	public List<CommentVO> selectByEventNo(Integer eventNo) {
		Session session = com.util.HibernateUtil.getSessionFactory().getCurrentSession();
		List<CommentVO> result = new ArrayList<CommentVO>();
		try {
			session.beginTransaction();
			Query query = session.createQuery("from CommentVO where eventNo = ? order by commentDate desc");
			query.setParameter(0, eventNo);
			List<Object> list = query.list();
			for(Object item :list){
				result.add((CommentVO)item);
			}
			
			session.beginTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
		}
		return result;
	}

	@Override
	public List<CommentVO> getAll() {
		Session session = com.util.HibernateUtil.getSessionFactory().getCurrentSession();
		List<CommentVO> result = null;
		try {
			session.beginTransaction();
			Query query = session.createQuery("from CommentVO where closed=0 order by commentDate desc");
			result = query.list();
			
			session.beginTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
		}
		return result;
	}
	
	@Override
	public List<CommentVO> getAllAdmin() {
		Session session = com.util.HibernateUtil.getSessionFactory().getCurrentSession();
		List<CommentVO> result = null;
		try {
			session.beginTransaction();
			Query query = session.createQuery("from CommentVO order by commentDate desc");
			result = query.list();
			
			session.beginTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
		}
		return result;
	}
	
}
