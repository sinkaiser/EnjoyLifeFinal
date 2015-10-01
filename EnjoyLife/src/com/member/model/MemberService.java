package com.member.model;
import java.util.Arrays;
import java.util.List;

import org.json.simple.JSONArray;


public class MemberService {
	private MemberDAO_interface memberDAO = new MemberDAO();	
	public MemberVO login(String memberId,String password){
		MemberVO bean = memberDAO.SelectById(memberId);
		if(bean!=null){
			if(password!=null && password.length()!=0){
				byte[] pass = bean.getPassword();
				byte[] temp = password.getBytes();
				if(Arrays.equals(pass, temp)){
					return bean;
				}
			}
		}
		return null;	
	}
	
	public boolean changePassword(String username, String oldPassword, String newPassword) {
		MemberVO bean = this.login(username, oldPassword);
		if(bean!=null) {
			byte[] temp = newPassword.getBytes();
			bean.setPassword(temp);
			if(memberDAO.UPDATEPWD(bean)==1){
			return true;
	     	}
		}
		return false;
	}
	public MemberVO selectMemberId(String memberId){
		MemberVO result = null;
		if(memberId!=null){
			result = memberDAO.SelectById(memberId);
		}
		return result;		
	}
	
	public boolean checkMemberId(String memberId){
		if(memberDAO.SelectById(memberId)==null){
			return true;
		}
		return false;		
	}
	public MemberVO updateRegistration(MemberVO bean){
		if(bean!=null){
			if(memberDAO.update(bean)==1){
				return bean;
			}
		}
		return null;
	}
	
	public MemberVO updatepermission(MemberVO bean){
		if(bean!=null){
			if(memberDAO.updatepermission(bean)==1){
				return bean;
			}
		}
		return null;
	}
	
	public List<MemberVO> getAll(){
		List<MemberVO> result = null;
		result = memberDAO.getAll();
		
		return result;
	}
	public JSONArray SelectByIdLike(String memberId){
		JSONArray result = null;
		if(memberId!=null){
			result = memberDAO.SelectByIdLike(memberId);
		}
		return result;		
	}
	public int SelectByCount(String friendId){
		int result = 0;
		if(friendId!=null){
			result = memberDAO.SelectByCount(friendId);
		}
		return result;		
	}
	
}
