package com.util;

import java.util.List;


public interface ImgListDao {
	
	public List<ImgListBean> getAll();
	public ImgListBean select(int id);
	public int insert(ImgListBean imgListBean);
	public String selectType(int id);
	public int update(ImgListBean imgListBean);
	public int delete(Integer id);
	
}
