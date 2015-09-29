package com.blog.controller;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.hibernate.Session;

import com.blog.model.BlogDAO;
import com.blog.model.BlogVO;
import com.blog.model.ElSettingDAO;
import com.blog.model.Hibernate.BlogDAOHibernate;
import com.blog.model.Hibernate.ElSettingDAOHibernate;
import com.member.model.MemberVO;
import com.util.HibernateUtil;

@WebServlet("/BlogPostServlet")
public class BlogPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BlogPostServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String errorMessage = "";
		String memberId = "";
		String postNo   = "";
		
		MemberVO memBean =(MemberVO) request.getSession().getAttribute("member");
		memberId = memBean.getMemberId();
		request.setCharacterEncoding("UTF-8");
		String bTitle = request.getParameter("bTitle");
		if(bTitle.trim()=="" || bTitle==null){
			errorMessage = errorMessage+"<標題不可空白>";
		}
		
		String bContext = request.getParameter("bContext");
		if(bTitle.trim()=="" || bTitle==null){
			errorMessage = errorMessage+"<內容不可空白>";
		}
		String bPlace = request.getParameter("bPlace");
		if(bTitle==null){
			bTitle = "";
		}
		String bType = request.getParameter("bType");
			
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		ElSettingDAO eldao = new ElSettingDAOHibernate(session);
		BlogDAO blogDao = new BlogDAOHibernate(session);
		session.beginTransaction();
		postNo= eldao.getSerial();
		if(postNo==""){
			session.getTransaction().rollback();
			return;
		}

		BlogPostServlet test = new BlogPostServlet();
		String blogImgPaht = test.mergeImgs(request,response,memberId, postNo);
		if(blogImgPaht.equals("failed")){
			errorMessage = errorMessage+"<請選擇圖片上傳>";
		}
		System.out.println(blogImgPaht);

		request.setAttribute("ErrorMsg", errorMessage);
		
		if(!errorMessage.isEmpty()){
//			System.out.println(request.getRequestURI());
//			response.setContentType("text/html; charset=UTF-8");
//			response.sendRedirect(request.getContextPath()+"/blog/newpost.jsp");
			session.getTransaction().rollback();
			request.getRequestDispatcher("/blog/postBlog.jsp").forward(request, response);
			
			return;
		}
		
		BlogVO bean = new BlogVO();
		bean.setMemberId(memberId);
		bean.setPostNo(postNo);
		bean.setPostType(bType);
		bean.setPostTitle(bTitle);
		java.util.Date date = new java.util.Date();
		bean.setPostDate(date);
		bean.setModifyDate(date);
		bean.setPathPhoto(blogImgPaht);
		bean.setPostContext(bContext);
		bean.setAttractionsNo(bPlace);
		
		boolean result = blogDao.insertPost(bean);
		if(result){
			if(eldao.udpateSerial(postNo)){
				session.getTransaction().commit();
				response.setContentType("text/html;charset=UTF-8");
				response.sendRedirect(request.getContextPath()+"/BlogListServlet?Index=0&&pType=ALL");
			}else{
				session.getTransaction().rollback();
				return;
			}
			
		}else{
			session.getTransaction().rollback();
		}
	}
		
	public String mergeImgs(HttpServletRequest request, HttpServletResponse response,String memAccount, String postNo){//纵向处理图片

		String img1Base64 = request.getParameter("img1Base64");
		String img2Base64 = request.getParameter("img2Base64");
		String img3Base64 = request.getParameter("img3Base64");
		String img4Base64 = request.getParameter("img4Base64");
		
		if(img1Base64=="" || img1Base64==null || img2Base64=="" || img2Base64==null
				|| img3Base64=="" || img3Base64==null || img4Base64=="" || img4Base64==null){
			return "failed";
		}			
		
		String diglog1 = request.getParameter("dialog1");
		String diglog2 = request.getParameter("dialog2");
		String diglog3 = request.getParameter("dialog3");
		String diglog4 = request.getParameter("dialog4");
		
		//String[] = {diglog_Top, diglog_Left, diglog_Width, diglog_Height, text_Top, text_Left}
		String[] diglogInfo1 = request.getParameter("dialogInfo1").split(",");
		String[] diglogInfo2 = request.getParameter("dialogInfo2").split(",");
		String[] diglogInfo3 = request.getParameter("dialogInfo3").split(",");
		String[] diglogInfo4 = request.getParameter("dialogInfo4").split(",");
		
		String text1 = request.getParameter("txtInput1")==""?"":request.getParameter("txtInput1");
		String text2 = request.getParameter("txtInput2")==""?"":request.getParameter("txtInput2");
		String text3 = request.getParameter("txtInput3")==""?"":request.getParameter("txtInput3");
		String text4 = request.getParameter("txtInput4")==""?"":request.getParameter("txtInput4");
		
		int fontSize1 = Integer.parseInt(request.getParameter("fontsize1").substring(0, 2));
		int fontSize2 = Integer.parseInt(request.getParameter("fontsize2").substring(0, 2));
		int fontSize3 = Integer.parseInt(request.getParameter("fontsize3").substring(0, 2));
		int fontSize4 = Integer.parseInt(request.getParameter("fontsize4").substring(0, 2));
	
		
		String path = request.getSession().getServletContext().getRealPath("/");
		
		int[] imgArray1 = imgToArray(img1Base64, diglog1, diglogInfo1, text1, fontSize1, path);
		int[] imgArray2 = imgToArray(img2Base64, diglog2, diglogInfo2, text2, fontSize2, path);
		int[] imgArray3 = imgToArray(img3Base64, diglog3, diglogInfo3, text3, fontSize3, path);
		int[] imgArray4 = imgToArray(img4Base64, diglog4, diglogInfo4, text4, fontSize4, path);
			
		// 生成新图片 
		BufferedImage imageResult = new BufferedImage(width, height * 4,BufferedImage.TYPE_INT_RGB);
		imageResult.setRGB(0, 0, width, height, imgArray1, 0, width);// 设置1部分的RGB
		imageResult.setRGB(0, height, width, height, imgArray2, 0, width);// 设置2部分的RGB
		imageResult.setRGB(0, height*2, width, height, imgArray3, 0, width);// 设置3部分的RGB
		imageResult.setRGB(0, height*3, width, height, imgArray4, 0, width);// 设置4部分的RGB
		
		String blogPath = "D:\\"+memAccount+ "\\"+ postNo +".png";
		File outFile = new File(blogPath);
		if(!outFile.exists()){
			outFile.mkdirs();
		}
		try {
			ImageIO.write(imageResult, "png", outFile);// 写图片
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return blogPath;
	}
	private int width = 0 ;
	private int height = 0 ;
	
	public int[] imgToArray(String imgBase64, String diglog,String[] diglogInfo,String dlText,int fontSize, String path){
		
		java.awt.Color color = new java.awt.Color(0,0,0);
		Font font = new java.awt.Font("標楷體",java.awt.Font.PLAIN,fontSize+2);
		int[] imageArray=null;
		try {
			String sImg = imgBase64.substring("data:image/png;base64,".length());
			byte[] imageByte4 = Base64.decodeBase64(sImg);
			ByteArrayInputStream bis = new ByteArrayInputStream(imageByte4);	
			BufferedImage image = ImageIO.read(bis);
			width = image.getWidth();// 图片宽度
			height = image.getHeight();// 图片高度
			//畫上對話框跟輸入的文字
			File fDiglog = new File(path+"images/dig/"+diglog+".png");
			BufferedImage dl = ImageIO.read(fDiglog);
			Graphics2D g2d = image.createGraphics();
			int dl_w = (int)Math.round(Double.parseDouble(diglogInfo[2].substring(0,diglogInfo[2].indexOf("px"))));
			int dl_h = (int)Math.round(Double.parseDouble(diglogInfo[3].substring(0,diglogInfo[3].indexOf("px"))));
			g2d.setComposite(java.awt.AlphaComposite.getInstance(java.awt.AlphaComposite.SRC_ATOP, 0.8f)); // 透明度設置開始,1.0是不透明,0是全透
			int dl_x =(int)Math.round(Double.parseDouble(diglogInfo[1]));
			int dl_y =(int)Math.round(Double.parseDouble(diglogInfo[0]));

			g2d.drawImage(dl,dl_x,dl_y,dl_w,dl_h,null);        //繪製縮小後的圖
			g2d.setColor(color);
			g2d.setFont(font);
			int text_x = (int)Math.round(Double.parseDouble(diglogInfo[1]))+(int)Math.round(Double.parseDouble(diglogInfo[5]));
			int text_y = (int)Math.round(Double.parseDouble(diglogInfo[0]))+(int)Math.round(Double.parseDouble(diglogInfo[4]));
			g2d.drawString(dlText,text_x,text_y+15);
			g2d.setComposite(java.awt.AlphaComposite.getInstance(java.awt.AlphaComposite.SRC_OVER)); // 透明度設置結束
			imageArray = new int[width * height];
			imageArray = image.getRGB(0, 0, width, height, imageArray, 0, width);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return imageArray;
	}
}
