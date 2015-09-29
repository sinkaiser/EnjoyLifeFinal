package com.little.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONValue;

import com.little.model.LittleBean;
import com.little.model.TargetBean;
import com.little.model.TypeListBean;

public class LittleService {
	public String getLittleJson(){
		String jsonString=null;
		
		LittleDao dao=new LittleDaoHibernate();
		List<LittleBean> beans=dao.getAll();
		
		List<Map<String,String>> l1 = new LinkedList<Map<String,String>>();
		for(LittleBean bean:beans){
			Map<String,String> m1 = new HashMap<String,String>();       
			m1.put("elfNo",bean.getElfNo().toString());
			m1.put("nevin",bean.getNevin());
			m1.put("typeNo",bean.getTypeNo().toString());
			m1.put("targetNo",bean.getTargetNo().toString());
			m1.put("beginTime",bean.getBeginTime().toString());
			m1.put("endTime",bean.getEndTime().toString());
			l1.add(m1);
		}
		 jsonString = JSONValue.toJSONString(l1);                    
		 return jsonString;
	}
	public String getTargetJson(){
		String jsonString=null;
		
		TargetDao dao=new TargetDaoHibernate();
		List<TargetBean> beans=dao.getAll();
		
		List<Map<String,String>> l1 = new LinkedList<Map<String,String>>();
		for(TargetBean bean:beans){
			Map<String,String> m1 = new HashMap<String,String>();       
			m1.put("targetRole",bean.getTargetRole());
			m1.put("targetNo",bean.getTargetNo().toString());
			l1.add(m1);
			}
			
		jsonString = JSONValue.toJSONString(l1);                    
		return jsonString; 
	}
			
			
			
	public String getTypeJson(){
		String jsonString=null;
		
		TypeListDao dao=new TypeListDaoHibernate();
		List<TypeListBean> beans=dao.getAll();
		
		List<Map<String,String>> l1 = new LinkedList<Map<String,String>>();
		for(TypeListBean bean:beans){
			Map<String,String> m1 = new HashMap<String,String>();       
			m1.put("typeNo",bean.getTypeNo().toString());
			m1.put("type",bean.getType());
			l1.add(m1);
			}
			
		jsonString = JSONValue.toJSONString(l1);                    
		return jsonString; 
	}
}
