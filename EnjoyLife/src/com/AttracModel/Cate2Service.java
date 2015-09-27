package com.AttracModel;

import java.util.List;

import com.AttracHiber.Cate2DaoHiber;



public class Cate2Service {
	private Cate2Dao cate2Dao=new Cate2DaoHiber();
	
	public List<Cate2Bean> getCate2(){
		List<Cate2Bean> result = null;	
//		if(bean!=null && bean.getCate1no()!=0){
//			result = cate2Dao.select(bean.getCate1no());								
//		}else{
			result = cate2Dao.selectall();
//		}
		return result;		
	}
}
