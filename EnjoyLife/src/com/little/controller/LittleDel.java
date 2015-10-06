package com.little.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.little.model.LittleBean;
import com.log.controller.AdminLogService;

/**
 * Servlet implementation class LittleDel
 */
@WebServlet("/LittleDel")
public class LittleDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LittleDel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String elfNo=request.getParameter("elfNo");
		
		if(elfNo!=null){
			LittleService service=new LittleService();
			LittleDaoHibernate dao=new LittleDaoHibernate();
			LittleBean bean=dao.select(Integer.parseInt(elfNo));
			
			String result=service.getDelLittleJson(Integer.parseInt(elfNo));
			if(result.equals("0")){
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.write("1A"); 
				
			}else{
				
				String executorIp=request.getRemoteAddr();
				if(executorIp.equals("0:0:0:0:0:0:0:1")){
					executorIp="127.0.0.1";}
	            String user="admin";
					
	            
				AdminLogService dao1=new AdminLogService();
				dao1.add("小幫手", user, executorIp,bean.getNevin(), "刪除");
				
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.write("0A"+result); 
			}
			
		}else{

			
			
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.write("1A"); 
		}
		
	}

}
