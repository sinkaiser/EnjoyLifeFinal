package com.AttracModel;

import java.util.List;

import com.AttracHiber.PhotoDaoHiber;

public class PhotoService {
	private PhotoDao photoDao = new PhotoDaoHiber();
	
	public List<PhotoBean> select(int num) {
		List<PhotoBean> result = null;
		if(num!=0) {
			List<PhotoBean> temp = photoDao.select(num);			
		} else {
			result = photoDao.selectall(); 			
		}
		return result;
	}
	
	public boolean insert(PhotoBean bean) {
		boolean result = false;
		if(bean!=null) {
			int pkno=photoDao.selectPK();
			bean.setPhotono(pkno+1);
			result = photoDao.insert(bean);
			System.out.println("insert:"+bean.getPhotoname());

		}
		return result;
	}
	
	public static void main(String[] args) {
		
	}

}
