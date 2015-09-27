package com.blog.model;

import java.util.List;

import org.hibernate.Session;

public interface BlogSortDAO {
		
	public abstract List<BlogSortVO> selectAll();
	
	public abstract String selectByType(String postType);
	
	public abstract boolean insert(String postType,String postTypeName);
	
	public abstract boolean update(String postType,String postTypeName);

}
