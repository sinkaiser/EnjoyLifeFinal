package com.friend.model;

import java.util.List;


public class FriendService {
//	private MemberDAO_interface memberDAO = new MemberDAO();	
	FriendDAO friendDAO = new FriendDAO();
	public FriendVO insertfriend(FriendVO fbean){
		FriendVO bean = new FriendVO();
		if(fbean!=null){
			friendDAO.insertfriend(fbean);
			return bean;
		}
		return null;
	}
	
	public FriendVO insertmember(FriendVO fbean){
		FriendVO bean = new FriendVO();
		if(fbean!=null){
			friendDAO.insertmember(fbean);
			return bean;
		}
		return null;
	}
	
	public List<FriendVO> select_by_friend(String memberId){
		List<FriendVO> result = null;
		if(memberId!=null){
			result = friendDAO.select_by_friend(memberId);
		}
		return result;
	}
	public int deleteFriend(String friendId,String memberId){
		if(friendId!=null && memberId!=null){
			if(friendDAO.deleteFriend(friendId, memberId)>=1){
				return 2;
			}
		}
		return 0;
	}
	
	public FriendVO updateFriend(FriendVO bean){
		if(bean!=null){
			if(friendDAO.updatefriend(bean)>=1){
				return bean;
			}
		}
		return null;
	}
	public FriendVO updateFriend2(FriendVO bean){
		if(bean!=null){
			if(friendDAO.updatefriend2(bean)>=1){
				return bean;
			}
		}
		return null;
	}
}
