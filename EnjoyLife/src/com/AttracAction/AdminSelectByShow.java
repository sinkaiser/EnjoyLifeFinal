package com.AttracAction;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.json.simple.JSONValue;

import com.AttracHiber.AttracDaoHiber;
import com.AttracModel.AttracBean;
import com.blog.model.BlogVO;
import com.blog.model.Hibernate.BlogDAOHibernate;
import com.util.HibernateUtil;

/**
 * Servlet implementation class AdminSelectByShow
 */
@WebServlet("/AdminSelectByShow")
public class AdminSelectByShow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSelectByShow() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page=request.getParameter("page");
		String show=request.getParameter("show");
		
		System.out.println(page+show);
		
		response.setContentType("text/html;charset=UTF-8");
		
		AttracDaoHiber dao=new AttracDaoHiber();
		List<AttracBean> vos=dao.selectByShow(show, Integer.parseInt(page));
		
		
		List<Map<String,String>> list=new LinkedList<Map<String,String>>();
		String jsonString=null;
		
		for(AttracBean vo:vos){
			Map<String,String> map=new HashMap<String,String>();
			map.put("address", vo.getAddress());
			map.put("attracno", String.valueOf(vo.getRownumber()));
			map.put("county", vo.getCounty());
			map.put("dist", vo.getDist());
			map.put("info", vo.getInfo());
			map.put("mrt", vo.getMrt());
			map.put("stitle", vo.getStitle());
			map.put("time", vo.getTime());
			map.put("xbody", vo.getXbody());
			map.put("cat1no", String.valueOf(vo.getCat1no()));
			map.put("cat2no", String.valueOf(vo.getCat2no()));

			map.put("show", String.valueOf(vo.getShow()));
	
			
			list.add(map);
		}
		 jsonString = JSONValue.toJSONString(list);                    
		 response.getWriter().write(jsonString);
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
