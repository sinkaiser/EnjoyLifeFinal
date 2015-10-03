package com.little.controller;

import java.util.List;

import com.little.model.LittleBean;

public interface LittleDao {
	
	public List<LittleBean> getAll();
	public LittleBean select(int id);
	public int insert(LittleBean littleBean);
	public int update(LittleBean littleBean);
	public int delete(Integer id);
	public int deleteByTime();
}
