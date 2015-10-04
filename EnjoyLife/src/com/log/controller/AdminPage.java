package com.log.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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
		if(executorIp.equals("0:0:0:0:0:0:0:1")){
			executorIp="127.0.0.1";
		}
		
		
		AdminLogService service=new AdminLogService();
		
		AdminLogDaoHibernate dao=new AdminLogDaoHibernate();
		HttpSession session=request.getSession();
		
		if(session.getAttribute("admin")!="ok"){
			session.setAttribute("admin","ok");
			service.add("管理頁面", "管理員", executorIp, "成功", "登入");
		}
		
		List<AdminLogBean> loginList=dao.selectAllLogin();
		Map<String,List<AdminLogBean>> AdminLog=dao.getAllByday();
		
		Long time=new java.util.Date().getTime();
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String a=sdf.format(new Date(time-1000*60*60*24));
		String b=sdf.format(new Date(time-1000*60*60*24*2));
		String c=sdf.format(new Date(time-1000*60*60*24*3));
		String d=sdf.format(new Date(time-1000*60*60*24*4));
		String e=sdf.format(new Date(time-1000*60*60*24*5));
		String f=sdf.format(new Date(time-1000*60*60*24*6));
		
		Map<String,String> map1=new HashMap<String,String>();
		map1.put("one", a);
		map1.put("two", b);
		map1.put("three", c);
		map1.put("four", d);
		map1.put("five", e);
		map1.put("six", f);
	
		
		
		session.setAttribute("loginList", loginList);
		session.setAttribute("AdminLog", AdminLog);
		session.setAttribute("date", map1);
		

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
