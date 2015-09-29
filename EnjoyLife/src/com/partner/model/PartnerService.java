package com.partner.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONValue;

public class PartnerService {
	
	public PartnerService(){
		
	}
	
	public String getPartnerJson(){
		String jsonString = null;
		
		PartnerDAO_interface dao = new PartnerDAOHibernate();
		List<PartnerVO> list = dao.getAllAdmin();
		
		List<Map<String,String>> list1 = new LinkedList<Map<String,String>>();
		for(PartnerVO bean:list){
			Map<String,String> m1 = new HashMap<String,String>();
			m1.put("eventNo", bean.getEventNo().toString());
			m1.put("eventType", bean.getEventType().toString());
			m1.put("eventContent", bean.getEventContent().toString());
			m1.put("addr", bean.getAddr().toString());
			m1.put("eventDate", bean.getEventDate().toString());
			m1.put("modifyDate", bean.getModifyDate().toString());
			//m1.put("imgNo", bean.getImgNo().toString());
			m1.put("memberId", bean.getMemberId().toString());
			m1.put("hidden", bean.getHidden().toString());
			m1.put("closed", bean.getClosed().toString());
			list1.add(m1);
		}
		jsonString = JSONValue.toJSONString(list1);
		
		return jsonString;
		
	}
	
	public String getOnePartnerJson(Integer eventNo){
		String jsonString = null;
		
		PartnerDAO_interface dao = new PartnerDAOHibernate();
		List<PartnerVO> list=dao.selectByEventNo(eventNo);
		
		
		System.out.println(list.get(0).getEventNo());
		List<Map<String,String>> list1 = new LinkedList<Map<String,String>>();
		
		for(PartnerVO bean:list){
			
			Map<String,String> m1 = new HashMap<String,String>();
			
			System.out.println(bean.getEventNo().toString()+"aaaaaaaaa");
			
			m1.put("eventNo", bean.getEventNo().toString());
			m1.put("eventType", bean.getEventType().toString());
			m1.put("eventContent", bean.getEventContent().toString());
			m1.put("addr", bean.getAddr().toString());
			m1.put("eventDate", bean.getEventDate().toString());
			m1.put("modifyDate", bean.getModifyDate().toString());
			m1.put("imgNo", bean.getImgNo().toString());
			m1.put("memberId", bean.getMemberId().toString());
			m1.put("hidden", bean.getHidden().toString());
			m1.put("closed", bean.getClosed().toString());
			list1.add(m1);
		}
		jsonString = JSONValue.toJSONString(list1);
		
		return jsonString;
		
	}
	
	public PartnerVO addNewEvent(PartnerVO partnerVO){
		PartnerDAO_interface dao = new PartnerDAOHibernate();
		PartnerVO result = dao.insert(partnerVO);
		return result;
	}
	
	public PartnerVO updateEvent(PartnerVO partnerVO){
		PartnerDAO_interface dao = new PartnerDAOHibernate();
		PartnerVO result = dao.update(partnerVO);
		return result;
	}
	
	public PartnerVO hiddenEvent(PartnerVO partnerVO){
		PartnerDAO_interface dao = new PartnerDAOHibernate();
		PartnerVO result = dao.hidden(partnerVO);
		return result;
	}
	
	public boolean deleteEvent(Integer eventNo){
		PartnerDAO_interface dao = new PartnerDAOHibernate();
		boolean result = dao.delete(eventNo);
		return result;
	}
	
	public List<PartnerVO> findAllByAdmin(){
		List<PartnerVO> list = new ArrayList<PartnerVO>();
		PartnerDAO_interface dao = new PartnerDAOHibernate();
		list = dao.getAllAdmin();
		return list;
	}
	
	public List<PartnerVO> findAll(){
		List<PartnerVO> list = new ArrayList<PartnerVO>();
		PartnerDAO_interface dao = new PartnerDAOHibernate();
		list = dao.getAll();
		return list;
	}
	
	public List<PartnerVO> findEventBySearch(String eventTitle, String eventContent){
		List<PartnerVO> list = new ArrayList<PartnerVO>();
		PartnerDAO_interface dao = new PartnerDAOHibernate();
		list = dao.selectByEventTitleAndEventContent(eventContent);
		return list;
	}
	
	public List<PartnerVO> findByType(String eventType){
		List<PartnerVO> list = new ArrayList<PartnerVO>();
		PartnerDAO_interface dao = new PartnerDAOHibernate();
		list = dao.selectByEventType(eventType);
		return list;
	}
	
	public List<PartnerVO> findById(String memberId){
		List<PartnerVO> list = new ArrayList<PartnerVO>();
		PartnerDAO_interface dao = new PartnerDAOHibernate();
		list = dao.selectById(memberId);
		return list;
	}
	
	public List<PartnerVO> findByIdOver(String memberId){
		List<PartnerVO> list = new ArrayList<PartnerVO>();
		PartnerDAO_interface dao = new PartnerDAOHibernate();
		list = dao.selectByIdOver(memberId);
		return list;
	}
	
	public List<PartnerVO> findByNo(Integer eventNo){
		List<PartnerVO> list = new ArrayList<PartnerVO>();
		PartnerDAO_interface dao = new PartnerDAOHibernate();
		list = dao.selectByEventNo(eventNo);
		return list;
	}
	
	public List<PartnerVO> findByIndex(int index){
		List<PartnerVO> list = new ArrayList<PartnerVO>();
		PartnerDAO_interface dao = new PartnerDAOHibernate();
		list = dao.selectByIndex(index);
		return list;
	}
}
