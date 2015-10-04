package com.log.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.log.model.AdminLogBean;

/**
 * Servlet implementation class Testa
 */
@WebServlet("/Testa")
public class Testa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Testa() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		String executorIp=request.getRemoteAddr();
//		System.out.println(executorIp);
		AdminLogService service=new AdminLogService();
//		service.add("網誌", "管理員", executorIp, "xx", "insert");
//		service.delete();
		AdminLogDaoHibernate dao=new AdminLogDaoHibernate();
		List<AdminLogBean> list=dao.selectAllLogin();
		Map<String,List<AdminLogBean>> map=dao.getAllByday();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
