package com.log.controller;

import java.util.List;
import java.util.Map;

import com.log.model.AdminLogBean;

public interface AdminLogDao {
	
	public Map<String,List<AdminLogBean>> getAllByday();
	public List<AdminLogBean> selectAllLogin();
	public AdminLogBean select(int id);
	public int insert(AdminLogBean adminLogBean);
	public int update(AdminLogBean adminLogBean);
	public int delete(Integer id);
	public int deleteByTime();
}
