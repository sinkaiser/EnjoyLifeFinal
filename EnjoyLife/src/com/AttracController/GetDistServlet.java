package com.AttracController;

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

import org.json.simple.JSONValue;

import com.AttracHiber.DistDaoHiber;
import com.AttracModel.DistBean;

/**
 * Servlet implementation class GetDistServlet
 */
@WebServlet("/GetDistServlet")
public class GetDistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public GetDistServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response){
		try {
			int countyno = Integer.parseInt(request.getParameter("countyno"));
			DistDaoHiber distdao = new DistDaoHiber();
			List<DistBean> distbean = distdao.select(countyno);
			List<Object> l1 = new ArrayList<Object>();
			for (DistBean bean : distbean) {
				Map<String, Object> m1 = new HashMap<String, Object>();
				m1.put("distno", bean.getDistno());
				m1.put("distname", bean.getDistname());
				l1.add(m1);
			}
			response.setContentType("text/html;charset=UTF-8");
			String jsonString = JSONValue.toJSONString(l1);
			response.getWriter().write(jsonString);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
