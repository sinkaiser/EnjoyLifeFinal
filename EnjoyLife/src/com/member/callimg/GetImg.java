package com.member.callimg;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.ImgListService;


/**
 * Servlet implementation class GetImg
 */
@WebServlet("/GetImg")
public class GetImg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetImg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path= request.getSession().getServletContext().getRealPath("/");
		String id=request.getParameter("imgid");
		
		ImgListService img=new ImgListService();
		if(id==""||id==null){
			
		}else{
		String url=img.select(path,Integer.parseInt(id));
		
		String[] a=url.split("\\.");
		
		response.setContentType("image;"+a[1]);
		
		System.out.println(path+url);
		FileInputStream fi=null;
		OutputStream os=null;
		try {
			fi=new FileInputStream(path+url);
			os=response.getOutputStream();
			int size=0;
			byte[] data=new byte[1024];
			while((size=fi.read(data))!=-1){
				os.write(data);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			os.close();
			fi.close();
		}
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		
	}

}
