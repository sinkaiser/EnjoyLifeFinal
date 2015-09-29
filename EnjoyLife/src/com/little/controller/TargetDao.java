package com.little.controller;

import java.util.List;

import com.little.model.TargetBean;

public interface TargetDao {
	
	public List<TargetBean> getAll();
	public TargetBean select(int id);
	public int insert(TargetBean targetBean);
	public int update(TargetBean targetBean);
	public int delete(Integer id);
}
