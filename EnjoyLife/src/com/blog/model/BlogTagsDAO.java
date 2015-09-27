package com.blog.model;

import java.util.ArrayList;

public interface BlogTagsDAO {
	
	public abstract String[] selectByPost(String postNo);
	
	public abstract boolean insertTag(ArrayList<BlogTagsVO> list);
	
}
