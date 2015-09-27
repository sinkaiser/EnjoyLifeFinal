package com.AttracModel;

import java.util.List;

import com.AttracHiber.Cate1DaoHiber;


public class Cate1Service {
	
	private Cate1Dao cate1Dao=new Cate1DaoHiber();
	
	public List<Cate1Bean> getAll(){
		List<Cate1Bean> result = null;	
		result = cate1Dao.selectall(); 							
		return result;		
	}
}
