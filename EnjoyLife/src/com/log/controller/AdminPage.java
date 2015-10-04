package com.log.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.log.model.AdminLogBean;

/**
 * Servlet implementation class AdminPage
 */
@WebServlet("/AdminPageServlet")
public class AdminPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String executorIp=request.getRemoteAddr();
		System.out.println(executorIp);
		AdminLogService service=new AdminLogService();
		AdminLogDaoHibernate dao=new AdminLogDaoHibernate();
		service.add("管理頁面", "管理員", executorIp, "登入紀錄", "登入");
		
		List<AdminLogBean> loginList=dao.selectAllLogin();
		Map<String,List<AdminLogBean>> AdminLog=dao.getAllByday();
		
		HttpSession session=request.getSession();
		session.setAttribute("loginList", loginList);
		session.setAttribute("AdminLog", AdminLog);
		String path=request.getContextPath();
		response.sendRedirect(path+"/admin/page.jsp");
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
