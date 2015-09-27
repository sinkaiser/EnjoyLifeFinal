package com.blog.model.Hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.blog.model.BlogSortDAO;
import com.blog.model.BlogSortVO;
import com.util.HibernateUtil;

public class BlogSortDAOHibernate implements BlogSortDAO {
	private Session session =null;
	

	public BlogSortDAOHibernate(Session session){
		this.session = session;
	}
	
	@Override
	public List<BlogSortVO> selectAll()  {
		String sSQL= "FROM BlogSortVO";
		List<BlogSortVO> result = null;
		try {
			Query query = session.createQuery(sSQL);
			result = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String selectByType(String postType) {
		String sSQL= "FROM BlogSortVO WHERE postType=?";
		String result = "";
		try {
			Query query = session.createQuery(sSQL);
			query.setParameter(0, postType);
			BlogSortVO bean = (BlogSortVO)query.iterate();
			result = bean.getPostTypeName();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean insert(String postType, String postTypeName) {

		boolean result = false;
		
		BlogSortVO bean = new BlogSortVO();
		bean.setPostType(postType);
		bean.setPostTypeName(postTypeName);
		
		try {
			session.saveOrUpdate(bean);
			result = true;
		} catch (HibernateException e) {
			
			e.printStackTrace();
		}			
		return result;
	}

	private String SQL_UPDATE = "";

	@Override
	public boolean update(String postType, String postTypeName) {
		return false;
	}

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		BlogSortDAO dao = new BlogSortDAOHibernate(session);

//		 dao.insert("TL", "旅遊");
//		 dao.insert("DF", "美食");
//		 dao.insert("ML", "心情");
//		 dao.insert("FT", "搞笑");
//		 dao.insert("WP", "耍廢");
		 session.beginTransaction();
//		 List<BlogSortVO> list = dao.selectAll();
		 boolean count = dao.insert("OT", "其他");
		 session.getTransaction().commit();
//		 for(BlogSortVO bean : list){
//			 System.out.println(bean.getPostType()+"____"+bean.getPostTypeName());	 
//		 }
		 System.out.println(count);
	}

}
