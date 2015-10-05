package com.AttracController;

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

import org.json.simple.JSONValue;

import com.AttracHiber.PhotoDaoHiber;
import com.AttracModel.PhotoBean;

/**
 * Servlet implementation class GetPhotoByAttracNo
 */
@WebServlet("/GetPhotoByAttracNo")
public class GetPhotoByAttracNo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPhotoByAttracNo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String attracNo=request.getParameter("attracNo");
		PhotoDaoHiber dao=new PhotoDaoHiber();
		List<PhotoBean> beans=dao.selectImgByAttracNo(attracNo);
		List<Map<String,String>> l1 = new LinkedList<Map<String,String>>();
		for(PhotoBean bean:beans){
			Map<String,String> m1 = new HashMap<String,String>();       
			m1.put("attracno",String.valueOf(bean.getAttracno()));
			m1.put("data",bean.getPhotodata());
			m1.put("name",bean.getPhotoname());
			m1.put("photonono",String.valueOf(bean.getPhotono()));
			l1.add(m1);
		}
		
		 String jsonString = JSONValue.toJSONString(l1);                    
		 
		 response.setContentType("text/html; charset=UTF-8");
		 response.getWriter().write(jsonString);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
