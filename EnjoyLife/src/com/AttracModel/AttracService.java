package com.AttracModel;

import java.util.ArrayList;
import java.util.List;

import com.AttracHiber.AttracDaoHiber;

public class AttracService {
	private AttracDao AttracDao = new AttracDaoHiber();
	
	public Integer selectAttracNo(AttracBean bean){
		int AttracNo=0;
		if(bean!=null){
			AttracNo=AttracDao.selectAttracNo(bean);			
		}		
		return AttracNo;		
	}

	public List<AttracBean> select(int num) {
		List<AttracBean> result = null;
		if(num!=0) {
			AttracBean temp = AttracDao.select(num);
			if(temp!=null) {
				result = new ArrayList<AttracBean>();
				result.add(temp);
			}
		} else {
			result = AttracDao.selectall(); 			
		}
		return result;
	}
	
	public boolean insert(AttracBean bean) {
		boolean result = false;
		if(bean!=null) {
			int pkno=AttracDao.selectPK();
			bean.setRownumber(pkno+1);
			result = AttracDao.insert(bean);
			System.out.println("insert:"+bean.getStitle());

		}
		return result;
	}
	public boolean update(AttracBean bean) {
		boolean result = false;
		if(bean!=null) {			
			result = AttracDao.update(bean);
		}
		return result;
	}
	public boolean delete(AttracBean bean) {
		boolean result = false;
		if(bean!=null) {
			result = AttracDao.delete(bean.getRownumber());
		}
		return result;
	}
	
	
	
	public static void main(String[] args) {
		AttracService service = new AttracService();
		AttracBean bean=new AttracBean();
		bean.setStitle("士林官邸");

		System.out.println("AttracNo="+service.selectAttracNo(bean));

	}

}
