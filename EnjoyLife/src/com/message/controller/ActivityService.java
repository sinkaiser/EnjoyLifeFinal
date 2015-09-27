package com.message.controller;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONValue;

import com.message.model.MessageService;
import com.message.model.MessageVO;
public class ActivityService {

	public String getActivityJson(int messageNo){
		MessageService service = new MessageService();
		List<MessageVO> beans = service.select_by_messageNo(messageNo);
		String jsonString=null;
		List<Map<String,String>> l1 = new LinkedList<Map<String,String>>();
		for(MessageVO bean9:beans){
			Map<String,String> m1 = new HashMap<String,String>();       
			m1.put("MessageFrom",bean9.getMessageFrom());
			m1.put("MessageTo",bean9.getMessageTo());
			m1.put("MessageTitle",bean9.getMessageTitle());
			m1.put("Message",bean9.getMessage());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			m1.put("TalkDate",sdf.format(bean9.getTalkDate()));
			m1.put("ShowMessage",Integer.toString(bean9.getShowMessage()));
			m1.put("UnMessage",Integer.toString(bean9.getUnMessage()));
			l1.add(m1);
		}
		 jsonString = JSONValue.toJSONString(l1);                    
		 return jsonString;
	}	
}
