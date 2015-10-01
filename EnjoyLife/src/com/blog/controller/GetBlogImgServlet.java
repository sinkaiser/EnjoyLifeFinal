package com.blog.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;

@WebServlet("/GetBlogImgServlet")
public class GetBlogImgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public GetBlogImgServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path= request.getParameter("pathImg");
		String isThumbnail= request.getParameter("isThumbnail");

		File pic = new File(path);
		BufferedImage image = ImageIO.read(pic);
		int width = image.getWidth();// 图片宽度
		int height = image.getHeight();// 图片高度	
		if(isThumbnail.equals("T")){
			height = height/3;
		}
		int[] imageArray = new int[width * (height)];// 从图片中读取RGB
		imageArray = image.getRGB(0, 0, width, height, imageArray, 0, width);
		BufferedImage imageResult = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
		imageResult.setRGB(0, 0, width, height, imageArray, 0, width);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ImageIO.write(imageResult,"jpeg",bos);
		response.setContentType("image/*"); //設置返回的文件類型
		OutputStream toClient=response.getOutputStream(); //得到向客戶端輸出二進制數據的對象
		toClient.write(bos.toByteArray()); //輸出數據
		toClient.close();		
	}

}
