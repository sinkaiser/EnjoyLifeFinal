package com.little.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.common.ParseXXX;
import com.little.model.LittleBean;
import com.log.controller.AdminLogService;
import com.member.model.MemberVO;

/**
 * Servlet implementation class Little
 */
@WebServlet("/Little")
public class Little extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Little() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String temp1=request.getParameter("targetNo");
		String temp2=request.getParameter("typeNo");
		String temp3=request.getParameter("beginTime");
		String temp4=request.getParameter("endTime");
		String temp5=request.getParameter("nevin");
		String temp6=request.getParameter("do");
		String temp7=request.getParameter("elfNo");
		HttpSession session=request.getSession();
		
		MemberVO vo=(MemberVO)session.getAttribute("member");
		Map<String,String>errorM=new HashMap<String,String>();
		System.out.println(temp1);
		ParseXXX parse=new ParseXXX();
		Integer targetNo=parse.parseInt(temp1);
		if(targetNo==-1000){
			errorM.put("targetNo", "targetNo格式錯誤");
			System.out.println("targetNo格式錯誤");
		}
		
		Integer typeNo=parse.parseInt(temp2);
		if(typeNo==-1000){
			errorM.put("typeNo", "typeNo格式錯誤");
			System.out.println("typeNo格式錯誤");
		}
		System.out.println(temp3);
		java.util.Date beginTime=parse.parseDate(temp3);
		System.out.println(beginTime);
		if(beginTime.equals(new java.util.Date(0))){
			errorM.put("beginTime", "beginTime格式錯誤");
			System.out.println("beginTime格式錯誤");
		}
		java.util.Date endTime=parse.parseDate(temp4);
		if(endTime.equals(new java.util.Date(0))){
			errorM.put("endTime", "endTime格式錯誤");
			System.out.println("endTime格式錯誤");
		}
		
		
		String nevin=temp5;
		if(nevin==null || nevin.trim().length()==0){
			errorM.put("nevin", "nevin空白");
			System.out.println("nevin空白");}
		
		
		if(errorM.isEmpty()){
			LittleDao dao=new LittleDaoHibernate();
			LittleBean bean=new LittleBean();
			
			bean.setBeginTime(beginTime);
			bean.setEndTime(endTime);
			bean.setNevin(nevin);
			bean.setTypeNo(typeNo);
			bean.setTargetNo(targetNo);
			
			if(temp6.equals("update")){
				Integer elfNo=parse.parseInt(temp7);
				if(elfNo!=-1000){
					bean.setElfNo(elfNo);
					Integer aa=dao.update(bean);
					
					String executorIp=request.getRemoteAddr();
					if(executorIp.equals("0:0:0:0:0:0:0:1")){
						executorIp="127.0.0.1";
					}
					String user;
					
					if(vo!=null){
						user=vo.getMemberName();
					}else{
						user="admin";
					}
					
					AdminLogService service=new AdminLogService();
					service.add("小幫手", user, executorIp, nevin, "更新");
					
					response.setContentType("text/html;charset=UTF-8");
					PrintWriter out=response.getWriter();
					out.write("0A"+aa.toString()); 
					return;
				}
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.write("1A"); 
				return;
			}
				
			Integer b=dao.insert(bean);
			
			String executorIp=request.getRemoteAddr();
			if(executorIp.equals("0:0:0:0:0:0:0:1")){
				executorIp="127.0.0.1";
			}
			String user;
			
			if(vo!=null){
				user=vo.getMemberName();
			}else{
				user="admin";
			}
			System.out.println(nevin);
			
			String[] aa=nevin.split("\\?");
			
			AdminLogService service=new AdminLogService();
			service.add("小幫手", user, executorIp, aa[0], "新增");
			
			
			System.out.println(b);
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.write("0A"+b.toString()); 
			return;
		}else{
			response.setContentType("text/html;charset=UTF-8");
//			String buff= errorM.get("targetNo")+errorM.get("targetNo")+errorM.get("beginTime")+errorM.get("endTime")+errorM.get("nevin");
//			System.out.println(buff);
			PrintWriter out=response.getWriter();
			out.write("1Aerror"); 
			return;
		}
	}
}
