package com.little.controller;

import java.util.List;

import com.little.model.TypeListBean;

public interface TypeListDao {
	public List<TypeListBean> getAll();
	public TypeListBean select(int id);
	public int insert(TypeListBean typeListBean);
	public int update(TypeListBean typeListBean);
	public int delete(Integer id);
}
