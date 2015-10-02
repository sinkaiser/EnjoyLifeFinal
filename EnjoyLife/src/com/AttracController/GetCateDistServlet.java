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
import com.AttracHiber.DistDaoHiber;
import com.AttracModel.Cate2Bean;
import com.AttracModel.DistBean;

/**
 * Servlet implementation class GetCateDistServlet
 */
@WebServlet("/GetCateDistServlet")
public class GetCateDistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public GetCateDistServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response){
		try {
			int cate1no = Integer.parseInt(request.getParameter("cate1no"));
			int countyno = Integer.parseInt(request.getParameter("countyno"));
			Cate2DaoHiber cate2dao = new Cate2DaoHiber();
			DistDaoHiber distdao = new DistDaoHiber();
			List<Cate2Bean> cate2bean = cate2dao.select(cate1no);
			List<DistBean> distbean = distdao.select(countyno);
			List<Object> l1 = new ArrayList<Object>();
			for (Cate2Bean bean : cate2bean) {
				Map<String, Object> m1 = new HashMap<String, Object>();
				m1.put("cate2no", bean.getCate2no());
				m1.put("cate2name", bean.getCate2name());
				l1.add(m1);
			}
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
