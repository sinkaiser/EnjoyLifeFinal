package com.AttracController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.AttracModel.AttracBean;
import com.AttracModel.AttracService;
import com.log.controller.AdminLogService;

/**
 * Servlet implementation class AjaxChangeFlag
 */
@WebServlet("/AjaxChangeFlag")
public class AjaxChangeFlag extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxChangeFlag() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String AttracNo=request.getParameter("AttracNo");
		AttracService servic=new AttracService();
		AttracBean bean =new AttracBean(); 
		List<AttracBean>beans=servic.select(Integer.parseInt(AttracNo));
		bean=beans.get(0);
		System.out.println(bean.getShow());
		bean.setShow(1);
		
		boolean a=servic.update(bean);
		
		
		String executorIp=request.getRemoteAddr();
		if(executorIp.equals("0:0:0:0:0:0:0:1")){
			executorIp="127.0.0.1";
		}
		String user="admin";
		
		
		AdminLogService service=new AdminLogService();
		service.add("景點", user, executorIp, "編號"+AttracNo, "確認");
		
		
		
		
		
		
		
		response.setContentType ("text/html; charset=UTF-8" ) ;
		
		PrintWriter out = response.getWriter();
		if(a){
		out.write("ok");
		return;
		}else{
		out.write("error");
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
