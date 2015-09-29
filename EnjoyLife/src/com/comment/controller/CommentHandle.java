package com.comment.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.comment.model.CommentService;
import com.comment.model.CommentVO;

@WebServlet("/comment/CommentHandle")
public class CommentHandle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentHandle() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		String url=request.getContextPath();
		String handle=request.getParameter("handle");
		String commentNo=request.getParameter("commentNo");
		
		
		if(handle.equals("delete")){
			boolean flag=new CommentService().deleteComment(Integer.parseInt(commentNo));
				if(flag){
					request.setAttribute("reslut", commentNo+"刪除成功");
				
					RequestDispatcher rd=request.getRequestDispatcher(url+"showAllComments.jsp");
					rd.forward(request, response);
					return;
				}else{
					request.setAttribute("reslut", commentNo+"刪除失敗");
					RequestDispatcher rd=request.getRequestDispatcher(url+"showAllComments.jsp");
					rd.forward(request, response);
					return;
				}
				
		}
		else if(handle.equals("update")){
			CommentVO Vo=new CommentVO();
			Vo.setClosed(1);
			Vo.setClosed(Integer.parseInt(commentNo));
			CommentService service=new CommentService();
			
			
			
			service.updateComment(Vo);
			
			request.setAttribute("reslut", commentNo+"update 應該成功");
			
			RequestDispatcher rd=request.getRequestDispatcher(url+"showAllComments.jsp");
			rd.forward(request, response);
			return;
			
		}
		else{
			
			request.setAttribute("reslut", "沒發生任何事情");
			
			RequestDispatcher rd=request.getRequestDispatcher(url+"showAllComments.jsp");
			rd.forward(request, response);
			return;
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
