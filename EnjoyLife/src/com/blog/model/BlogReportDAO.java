package com.blog.model;

import java.util.List;

public interface BlogReportDAO {
	public abstract boolean insert(BlogReportVO bean);
	public abstract List<BlogReportVO> selectByBlog(String postNo);
}
