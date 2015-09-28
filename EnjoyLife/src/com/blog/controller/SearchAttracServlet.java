package com.blog.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.JSONValue;

import com.AttracHiber.AttracDaoHiber;
import com.AttracModel.AttracBean;


@WebServlet("/SearchAttracServlet")
public class SearchAttracServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SearchAttracServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");

		List returnList = new ArrayList();
		AttracDaoHiber dao = new AttracDaoHiber();
		List<Object[]> list= dao.selectByName(name.trim());	
    
		for(Object[] object : list){     
			Map<String,String> map = new HashMap<String,String>();
		   map.put("attrno",String.valueOf(object[0]));     
		   map.put("attrname",(String)object[1]);     
		    returnList.add(map);
		} 
        
		response.setContentType("text/html;charset=UTF-8");
		String jsonString = JSONValue.toJSONString(returnList);
		response.getWriter().write(jsonString);
		
	}

}
