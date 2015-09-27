package com.comment.model;

import java.util.ArrayList;
import java.util.List;

public class CommentService {
	
	public CommentService() {
		
	}
	
	public CommentVO addComment(CommentVO commentVO) {
		CommentDAO_interface dao = new CommentDAO();
		CommentVO result = dao.insert(commentVO);
		return result;
	}
	
	public CommentVO updateComment(CommentVO commentVO) {
		CommentDAO_interface dao = new CommentDAO();
		CommentVO result = dao.update(commentVO);
		return result;
	}
	
	public boolean deleteComment(Integer commentNo) {
		CommentDAO_interface dao = new CommentDAO();
		boolean result = dao.delete(commentNo);
		return result;
	}
	
	public List<CommentVO> findByEventNo(Integer eventNo) {
		List<CommentVO> list = new ArrayList<CommentVO>();
		CommentDAO_interface dao = new CommentDAO();
		list = dao.selectByEventNo(eventNo);
		return list;
	}
	
	public List<CommentVO> findAllByAdmin(){
		List<CommentVO> list = new ArrayList<CommentVO>();
		CommentDAO_interface dao = new CommentDAO();
		list = dao.getAllAdmin();
		return list;
	}
	
	public List<CommentVO> findAll(){
		List<CommentVO> list = new ArrayList<CommentVO>();
		CommentDAO_interface dao = new CommentDAO();
		list = dao.getAll();
		return list;
	}
}
