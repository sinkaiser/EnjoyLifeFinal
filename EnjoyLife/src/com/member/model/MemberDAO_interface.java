package com.member.model;

import java.util.*;

import org.json.simple.JSONArray;

public interface MemberDAO_interface {
          public MemberVO insert(MemberVO memberVO);
          public int update(MemberVO memberVO);
          public int delete(String memberId);
          public MemberVO SelectById(String memberId);
          public List<MemberVO> getAll();
          public int UPDATEPWD(MemberVO memberVO);
          public int updatepermission(MemberVO memberVO);
		  public JSONArray SelectByIdLike(String memberId);
		  public int SelectByCount(String memberId);
}
