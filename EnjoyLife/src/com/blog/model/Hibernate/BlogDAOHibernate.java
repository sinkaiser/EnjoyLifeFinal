package com.blog.model.Hibernate;


import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.blog.model.BlogDAO;
import com.blog.model.BlogVO;

public class BlogDAOHibernate implements BlogDAO {

	private Session session =null;
	public BlogDAOHibernate(Session session){
		this.session = session;
	}

	@Override
	public BlogVO selectByPost(String postNo) {
		String sql = "FROM BlogVO WHERE postNO=?";
		BlogVO result = null;
		System.out.println(postNo);
		try {
			Query query = session.createQuery(sql);
			query.setParameter(0, postNo);
			List<BlogVO> list = query.list();
			for(BlogVO bean: list){
				result = bean;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}		
		return result;
	}
	
	@Override
	public List<BlogVO> selectByIndex(int index, String postType){
		String sqlWithType = "FROM BlogVO WHERE postType=? AND flagDelete='F' AND flagReport='F' ORDER BY postDate DESC";				
		String sql = "FROM BlogVO WHERE flagDelete='F' AND flagReport='F' ORDER BY postDate DESC";				
		List<BlogVO> list = null;
		Query query =null;
		try {
			if(postType.equals("ALL")){
				query = session.createQuery(sql);
			}else{
				query = session.createQuery(sqlWithType);
				query.setParameter(0, postType);
			}
			query.setFirstResult(index);
			query.setMaxResults(9);
			list = (List<BlogVO>)query.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	
		return list;
	}
	
	@Override
	public List<BlogVO> selectByMember(String memberId) {
		String sql = "FROM BlogVO WHERE memberId=? AND flagDelete='F' AND flagReport='F'";
		List<BlogVO> list = null;
		
		try {
			Query query = session.createQuery(sql);
			query.setParameter(0, memberId);
			list = (List<BlogVO>)query.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}	
		return list;
	}

	@Override
	public boolean insertPost(BlogVO bean) {
		boolean result = false;
		
		try {
			session.save(bean);
			result = true;
		} catch (HibernateException e) {

			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public boolean deletePost(Date date, String flag, String postNo) {
		String sql = "UPDATE BlogVO SET modifyDate =?, flagDelete=? WHERE postNo=?";
		boolean result = false;

		try {
			Query query = session.createQuery(sql);
			query.setParameter(0, date);
			query.setParameter(1, flag);
			query.setParameter(2, postNo);
			int i = query.executeUpdate();
			result = true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean updatePost() {

		return false;
	}


	@Override
	public boolean updateViewAmount(String postNo){
		String sql= "UPDATE BlogVO SET viewTotal = viewTotal+1 WHERE postNo=?";
		boolean result = false;
		
		try {
			Query query = session.createQuery(sql);
			query.setParameter(0, postNo);
			int i = query.executeUpdate();
			result = true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	private String SQL_UPDATE_AvgScore="UPDATE blog SET avgScore=? ,qtyToScore=? WHERE postNo=?";
	@Override
	public boolean updateAvgScore(int score,String postNo){
		String sql = "UPDATE BlogVO SET avgScore=? ,qtyToScore=? WHERE postNo=?";
		boolean result = false;
		
		BlogVO bean = this.selectByPost(postNo);
		Double newScore = bean.getAvgScore()*bean.getQtyToScore() + score;
		int newQtyToScore = bean.getQtyToScore() +1;
		try {
			Query query = session.createQuery(sql);
			query.setParameter(0, postNo);
			query.setParameter(0, newScore/newQtyToScore);
			query.setParameter(0, newQtyToScore);
			int i = query.executeUpdate();
			result = true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public List<BlogVO> selectAll() {
		List<BlogVO> result=null;
		String sql="from BlogVO";
		try {
			Query query = session.createQuery(sql);
			result=query.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@Override
	public List<BlogVO> selectByFlagReport(int page) {
		List<BlogVO> result=null;
		String sql="from BlogVO where flagReport='T' and flagDelete='F'";
//		String sql="from BlogVO";
		try {
			Query query = session.createQuery(sql);
			
			query.setFirstResult(page*10);
			query.setMaxResults(10);
			result=query.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@Override
	public List<BlogVO> selectByFlagDelete(int page) {
		List<BlogVO> result=null;
		String sql="from BlogVO where flagDelete='T'";
		
		try {
			Query query = session.createQuery(sql);
			
			query.setFirstResult(page*10);
			query.setMaxResults(10);
			result=query.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	@Override
	public boolean delete(String postNo) {
		String sql = "delete from BlogVO where postNo=?";
		boolean result = false;

		try {
			Query query = session.createQuery(sql);
			query.setParameter(0, postNo);
			
			int i = query.executeUpdate();
			result = true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public boolean reportChange(String flag, String postNo) {
		String sql = "UPDATE BlogVO SET flagReport=? WHERE postNo=?";
		boolean result = false;

		try {
			Query query = session.createQuery(sql);
			query.setParameter(0, flag);
			query.setParameter(1, postNo);
			int i = query.executeUpdate();
			result = true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return result;
	}
	
//	public String pathToBase64(String path){
//		String sBase64 =null;
//		try {
//			File pic = new File(path);
//			BufferedImage image = ImageIO.read(pic);
//			int width = image.getWidth();// 图片宽度
//			int height = image.getHeight();// 图片高度	
//			int[] imageArray = new int[width * (height/3)];// 从图片中读取RGB
//			imageArray = image.getRGB(0, 0, width, height/3, imageArray, 0, width);
//			BufferedImage imageResult = new BufferedImage(width, height/3,BufferedImage.TYPE_INT_RGB);
//			imageResult.setRGB(0, 0, width, height/3, imageArray, 0, width);
//			ByteArrayOutputStream bos = new ByteArrayOutputStream();
//			ImageIO.write(imageResult,"png",bos);
//
//			sBase64 = Base64.encodeBase64String(Base64.encodeBase64(bos.toByteArray()));
//			System.out.println(sBase64);
//		} 
//		catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		return sBase64;
//	}
	
	public static void main(String[] args) {
//		BlogDAOHibernate dao = new BlogDAOHibernate();
//		BlogVO bean = new BlogVO();
//		dao.insertPost(bean);
//		String serialNo = dao.getSerial();
//		System.out.println(serialNo);
//		System.out.println(dao.udpateSerial(serialNo));
//		ArrayList<BlogVO> array= dao.selectByIndex(0, "TL");
//		for(BlogVO bean:array){
//			System.out.println(dao.beanToJSON(bean));			
//		}
		
	}

}
