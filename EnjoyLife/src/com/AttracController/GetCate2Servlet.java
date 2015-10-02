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

import com.AttracHiber.Cate2DaoHiber;
import com.AttracModel.Cate2Bean;

/**
 * Servlet implementation class GetCate2Servlet
 */
@WebServlet("/GetCate2Servlet")
public class GetCate2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public GetCate2Servlet() {
        super();    
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response){
		try {
			int cate1no = Integer.parseInt(request.getParameter("cate1no"));
			Cate2DaoHiber cate2dao = new Cate2DaoHiber();
			List<Cate2Bean> cate2bean = cate2dao.select(cate1no);
			List<Object> l1 = new ArrayList<Object>();
			for (Cate2Bean bean : cate2bean) {
				Map<String, Object> m1 = new HashMap<String, Object>();
				m1.put("cate2no", bean.getCate2no());
				m1.put("cate2name", bean.getCate2name());
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
