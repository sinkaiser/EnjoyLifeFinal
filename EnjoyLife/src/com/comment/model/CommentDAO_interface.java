package com.comment.model;

import java.util.List;

public interface CommentDAO_interface {
	public CommentVO insert(CommentVO commentVO);
	public CommentVO update(CommentVO commentVO);
	public boolean delete(Integer commentNo);
	public List<CommentVO> selectByEventNo(Integer eventNo);
	public List<CommentVO> getAll();
	public List<CommentVO> getAllAdmin();
}
