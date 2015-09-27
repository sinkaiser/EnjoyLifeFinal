package com.message.model;

import java.util.List;

import com.message.model.MessageVO;


public class MessageService {
//	private MemberDAO_interface memberDAO = new MemberDAO();	
	MessageDAO messageDAO = new MessageDAO();
	public int insertmessage(MessageVO mbean){
		int result = 0;
		if(mbean!=null){
			result = messageDAO.insertmessage(mbean);
			return result;
		}
		return result;
	}
	public List<MessageVO> select_by_messageto(String messageTo){
		List<MessageVO> result = null;
		if(messageTo!=null){
			result = messageDAO.select_by_messageTo(messageTo);
		}
		return result;
	}

	public List<MessageVO> select_by_messagefrom(String messageFrom){
		List<MessageVO> result = null;
		if(messageFrom!=null){
			result = messageDAO.select_by_messageFrom(messageFrom);
		}
		return result;
	}
	
	public List<MessageVO> select_by_messageNo(int messageNo){
		List<MessageVO> result = null;
		if(messageNo!=0){
			result = messageDAO.select_by_messageNO(messageNo);
		}
		return result;
	}
	
	public int updateMessage1(MessageVO messageVO){
		if(messageVO!=null ){
			if(messageDAO.updatemessage1(messageVO)==1){
				return 1;
			}
		}
		return 0;
	}
	public int updateMessage2(MessageVO messageVO){
		if(messageVO!=null ){
			if(messageDAO.updatemessage2(messageVO)==1){
				return 1;
			}
		}
		return 0;
	}
	public int deleteMessage(String messageFrom,String messageTo){
		if(messageFrom!=null && messageTo!=null){
			if(messageDAO.deleteMessage(messageFrom, messageTo)>=1){
				return 2;
			}
		}
		return 0;
	}
	
}
