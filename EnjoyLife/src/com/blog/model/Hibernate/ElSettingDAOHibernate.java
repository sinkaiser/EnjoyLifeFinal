package com.blog.model.Hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.blog.model.ElSettingDAO;
import com.blog.model.ElSettingVO;

public class ElSettingDAOHibernate implements ElSettingDAO {
	private Session session =null;
	
	public ElSettingDAOHibernate(Session session){
		this.session = session;
	}
	@Override
	public String getSerial() {
		String sql = "FROM ElSettingVO";
		String result = "";
		
		try {
			Query query = session.createQuery(sql);
			ElSettingVO bean = (ElSettingVO)query.list().get(0); 
			result = bean.getBlogPrefix()+bean.getBlogSerials();
		} catch (HibernateException e) {
			e.printStackTrace();
		}	
		return result;
	}

	@Override
	public boolean udpateSerial(String serialNo) {
		boolean result = false;
		String sql = "UPDATE ElSettingVO SET blogSerials=? WHERE blogPrefix='blog'";
		String nextSerial = String.format( "%010d", Integer.parseInt(serialNo.substring(4))+1);

		try {
			Query query = session.createQuery(sql);
			query.setParameter(0, nextSerial);
			query.executeUpdate();
			result = true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static void main(String[] args) {
		

	}

}
