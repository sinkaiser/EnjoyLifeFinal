package com.AttracController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.AttracHiber.PhotoDaoHiber;
import com.AttracModel.PhotoDao;

/**
 * Servlet implementation class GetAttrPhotoServlet
 */
@WebServlet("/GetAttrPhotoServlet")
public class GetAttrPhotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public GetAttrPhotoServlet() {
        super();   
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int attracno = Integer.parseInt(request.getParameter("attrno"));
		
		PhotoDao dao = new PhotoDaoHiber();
		String base64String = dao.selectTop1ByAttrNo(attracno);
		response.getWriter().write(base64String);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
