package com.AttracHiber;


import java.io.FileOutputStream;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.AttracModel.PhotoBean;
import com.AttracModel.PhotoDao;
import com.util.HibernateUtil;

public class PhotoDaoHiber implements PhotoDao {

	private static final String SELECT_PK =		
			"select photono from PhotoBean group by photono order by photono desc";
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
	
	
	private static final String SELECT_BY_ID =
			"from PhotoBean where AttracNo=?";	
	@Override
	public List<PhotoBean> select(int id) {
		List<PhotoBean> result=null;
		Session session =HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;	
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery(SELECT_BY_ID);
			query.setParameter(0, id);
			result = query.list();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return result;
	}
	
	public String selectTop1ByAttrNo(int id){
		String result = "";
		Session session =HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;	
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("from PhotoBean where AttracNo=?");
			query.setParameter(0, id);
			query.setFirstResult(0);
			query.setMaxResults(1);
			PhotoBean bean = (PhotoBean)query.list().get(0);
			result = bean.getPhotodata();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return result;
	}
	
	private static final String SELECT_ALL =
			"from PhotoBean";
	@Override
	public List<PhotoBean> selectall() {
		List<PhotoBean> result= null;
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
	public List<PhotoBean> selectImgByAttracNo(String attracNo) {
		List<PhotoBean> result= null;
		Session session =HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;		
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("from PhotoBean where attracNo=?");
			query.setParameter(0, attracNo);
			result = query.list();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public PhotoBean selectByNo(int photono) {
		PhotoBean result=null;
		Session session =HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;	
		try {
			tx = session.beginTransaction();
			result=(PhotoBean)session.get(PhotoBean.class,photono);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public boolean insert(PhotoBean bean) {
		boolean result=false;
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
			PhotoBean photobean = (PhotoBean) session.get(PhotoBean.class, id);
			session.delete(photobean);
			result = true;
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return result;
	}
	public static void main(String[] args) {
		PhotoBean bean =new PhotoBean();
		PhotoDaoHiber dao=new PhotoDaoHiber();
		FileOutputStream fos = null;
		String link="http://www.travel.taipei/d_upload_ttn/sceneadmin/pic/11000963.jpg";
		try {
//			URL urllink = new URL(link);
//			URLConnection urlConn = urllink.openConnection();
//			InputStream ins = urlConn.getInputStream();
//			BufferedImage bufferedImage = ImageIO.read(ins);
//			ByteArrayOutputStream baos = new ByteArrayOutputStream();
//			ImageIO.write(bufferedImage, "jpg", baos);
//			baos.flush();
//			byte[] originalImgByte = baos.toByteArray();
//			String pic64 = Base64.encodeBase64String(originalImgByte);
//			bean.setPhotono(10);
//			bean.setAttracno(20);
//			bean.setPhotoname("ooxx");
//			bean.setPhotodata(pic64);
//			System.out.println("insert to sql begain:");
//			dao.insert(bean);
//			System.out.println("insert success!!");
//			System.out.println("select form sql begain:");
//			List<PhotoBean> beans = dao.selectall();
//			for(PhotoBean bean1:beans){
//				System.out.println(bean1.getPhotono());
//			}
//			System.out.println("select success!!");
//			dao.delete(1);
//			System.out.println("layout pic begain:");
//			for (PhotoBean temp : beans) {
//				fos = new FileOutputStream("C:/Users/Student/Desktop/sqlpic.jpg");
//				fos.write(Base64.decodeBase64(temp.getPhotodata()));
//				System.out.println(temp.getPhotono());
//				System.out.println(temp.getPhotoname());
//				System.out.println(temp.getAttracno());
//			}
//			System.out.println("layout success!!");
			System.out.println(dao.selectPK());
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
