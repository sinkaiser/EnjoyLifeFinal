package com.friend.controller;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONValue;

import com.partner.model.PartnerService;
import com.partner.model.PartnerVO;
public class ActivityService {

	public String getActivityJson(String friend){
		PartnerService service = new PartnerService();
		List<PartnerVO> list = service.findById(friend);
		String jsonString=null;
		List<Map<String,String>> l1 = new LinkedList<Map<String,String>>();
		for(PartnerVO bean9:list){
			Map<String,String> m1 = new HashMap<String,String>();       
			m1.put("EventType",bean9.getEventType());
			m1.put("EventContent",bean9.getEventContent());
			m1.put("Addr",bean9.getAddr());	
			m1.put("ImgNo",bean9.getImgNo().toString());	
			l1.add(m1);
		}
		 jsonString = JSONValue.toJSONString(l1);                    
		 return jsonString;
	}	
}
