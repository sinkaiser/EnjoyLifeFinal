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
import com.AttracHiber.Cate1DaoHiber;
import com.AttracHiber.CountyDaoHiber;
import com.AttracModel.Cate1Bean;
import com.AttracModel.CountyBean;

/**
 * Servlet implementation class GetCate1Servlet
 */
@WebServlet("/GetCate1Servlet")
public class GetCate1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public GetCate1Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			Cate1DaoHiber catedao = new Cate1DaoHiber();
			CountyDaoHiber countydao = new CountyDaoHiber();
			List<Cate1Bean> cateresult = catedao.selectall();
			List<CountyBean> countyresult = countydao.selectall();
			List<Object> l1 = new ArrayList<Object>();
			for (Cate1Bean bean : cateresult) {
				Map<String, Object> m1 = new HashMap<String, Object>();
				m1.put("cate1no", bean.getCate1no());
				m1.put("cate1name", bean.getCate1name());
				l1.add(m1);
			}
			for (CountyBean bean : countyresult) {
				Map<String, Object> m1 = new HashMap<String, Object>();
				m1.put("countyno", bean.getCountyno());
				m1.put("countyname", bean.getCountyname());
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
