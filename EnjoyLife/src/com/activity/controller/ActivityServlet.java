package com.activity.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.activity.model.ActivityBean;
import com.activity.model.ActivityService;

@WebServlet(
		urlPatterns={"/controller/activityServlet"}		
)
public class ActivityServlet extends HttpServlet{
	private ActivityService service;
	
	@Override
	public void init() throws ServletException {
		service = new ActivityService();
	}
	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tempNo = request.getParameter("activityNo");
//		String activityshortname = request.getParameter("activityshortName");
//		String photosmallpath = request.getParameter("photosmallPath");
//		String activityname = request.getParameter("activityName");
//		String activityenddate = request.getParameter("activityendDate");
//		String activitycontent = request.getParameter("activityContent");
//		String photolargepath = request.getParameter("photolargePath");
		
		
		int activityno = 0;
		if(tempNo!=null && tempNo.length()!=0) {
			activityno = ActivityBean.converInt(tempNo);
		}
		
		// 爬蟲code
		ActivityBean bean = new ActivityBean();
//
//		bean.setActivityshortname("samk");
//		bean.setPhotosmallpath("ght");
//		bean.setActivityname("dfthr");
//		bean.setActivityenddate("grk");
//		bean.setActivitycontent("liu");
//		bean.setPhotolargepath("bvv");
		
		
//		bean.setActivityshortname(activityshortname);
//		bean.setPhotosmallpath(photosmallpath);
//		bean.setActivityname(activityname);
//		bean.setActivityenddate(activityenddate);
//		bean.setActivitycontent(activitycontent);
//		bean.setPhotolargepath(photolargepath);

//		service.insert(bean);
		List<ActivityBean> result = service.select();
		request.setAttribute("select", result);
		request.getRequestDispatcher(
				"/activityPage/activitySimple1.jsp").forward(request, response);
		System.out.println(result);
	}


	
}
