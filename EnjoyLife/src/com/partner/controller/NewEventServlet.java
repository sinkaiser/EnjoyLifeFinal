package com.partner.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.AttracAction.Compressionbase64;
import com.member.model.MemberDAO;
import com.member.model.MemberDAO_interface;
import com.member.model.MemberVO;
import com.partner.model.PartnerService;
import com.partner.model.PartnerVO;

import com.util.ImgListBean;
import com.util.ImgListDao;
import com.util.ImgListDaoHibernate;

@WebServlet("/partner/NewEventServlet")
public class NewEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PartnerVO partnerVO = new PartnerVO();
//		Partner00DAOHibernate hiber = new Partner00DAOHibernate();
		// 定義存放錯誤訊息的 Collection物件
		Collection<String> errorMessage = new ArrayList<String>();
		request.setAttribute("ErrorMsg", errorMessage);

		String addr=null;
		String eventType=null;
		String eventContent=null;
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(factory);
		Compressionbase64 compress=new Compressionbase64();
		try {
			
			List items = sfu.parseRequest(request);
			Iterator iter = items.iterator();
			String name;
			String value;
			
			while (iter.hasNext()) {
				
			    FileItem item = (FileItem) iter.next();
//			    System.out.println(item);
			 
			    if (item.isFormField()) {
			    	name=item.getFieldName();
			    	value=item.getString("UTF-8");
			    	
			    	if(name.equals("type")) {
//			    		System.out.println(value);
			    		eventType=value;
			    	}
			    	if(name.equals("content")) {
//			    		System.out.println(value);
			    		eventContent=value;
			    	}
			    	if(name.equals("address")) {
//			    		System.out.println(value);
			    		addr=value;
			    	}
			    	
			    }else{
			    	
			    	
			    	 long sizeInBytes = item.getSize();	
			    	 byte[] data = item.get();
			    	 String fileName=item.getName();
			    	 ImgListBean bean = new ImgListBean();
			    	 byte[] compressdata=compress.CompressionEventImg(data);
			    	 if(fileName.trim().equals("")){
			    	
			    		 partnerVO.setImgNo(0);
			    	 }else{
			    		 System.out.println(1);
			    		 String[] aa=fileName.split("\\.");
				    	 System.out.println(aa[0]+"||"+aa[1]);
				    	 bean.setImgContent(compressdata);
				    	 bean.setImgName(aa[0]);
				    	 bean.setImgType(aa[1]);
				    	 ImgListDao dao = new ImgListDaoHibernate();
				    	 int imgNo = dao.insert(bean);
				    	 partnerVO.setImgNo(imgNo);
			    	 }
			    	 
			    	
			    	
			    	 
			    	
			    	
			    	 
			    	 
			    }
			     
			}
			
		} catch (FileUploadException e) {
			e.printStackTrace();
			 System.out.println(2);
		}
		
		
		
		
		
		// 設定輸入資料的編碼
		request.setCharacterEncoding("UTF-8");

		
		// 檢查使用者所輸入的資料
		if (eventContent == null || eventContent.trim().length() == 0) {
			errorMessage.add("必須輸入內文");
		}
		// 檢查使用者所輸入的資料
		if (addr == null || addr.trim().length() == 0) {
			errorMessage.add("地址欄必須輸入");
		}
		Timestamp eventDate = new Timestamp(System.currentTimeMillis());
		Timestamp modifyDate = new Timestamp(System.currentTimeMillis());

		 System.out.println(3);
		HttpSession session=(HttpSession)request.getSession();
//		session.setAttribute("memberId", "joe");
//		String memberId=(String) session.getAttribute("memberId");
		MemberVO bean=(MemberVO) session.getAttribute("member");
		String memberId = bean.getMemberId();
		String memberName = bean.getMemberName();
		
		int hidden = 0;
		int closed = 0;
		// 如果有錯誤，呼叫view元件，送回錯誤訊息
		if (!errorMessage.isEmpty()) {
			RequestDispatcher rd = request
					.getRequestDispatcher("InsertPartnerError.jsp");
			rd.forward(request, response);
			return;
		}
					
		 System.out.println(4);
		
		// MemberBean 扮演封裝輸入資料的角色
 		partnerVO.setEventType(eventType);
 		partnerVO.setEventContent(eventContent);
 		partnerVO.setAddr(addr);
 		partnerVO.setEventDate(eventDate);
 		partnerVO.setModifyDate(modifyDate);
 		partnerVO.setMemberId(memberId);
 		partnerVO.setHidden(hidden);
 		partnerVO.setClosed(closed);
 		partnerVO.setMemberName(memberName);
 		try {
 			PartnerService service = new PartnerService();
 			
 			
 			
 			MemberDAO_interface dao = new MemberDAO();
			service.addNewEvent(partnerVO);
			
			Map<String,Object> map = new HashMap<String,Object>();
			MemberVO a=dao.SelectById(partnerVO.getMemberId());
			int imgNo=a.getPicture();
			map.put("PartnerVO",partnerVO);
			map.put("imgNo",imgNo);
 			
 			
 			
 			
 			
 			
 			//mfio.addNewEvent(partnerVO);
 			request.setAttribute("AllPartners", map);
 			// 依照執行的結果挑選適當的view元件，送回相關訊息
 			// 產生 RequestDispatcher 物件 rd
// 			RequestDispatcher rd = request
// 					.getRequestDispatcher("listFP.jsp");
// 			// 請容器代為呼叫下一棒程式
// 			rd.forward(request, response);
 			response.sendRedirect("ShowAllPartnerServlet");
 			return;
 		} catch (IOException e) {
 			// 依照執行的結果挑選適當的view元件，送回相關訊息
 			// 產生 RequestDispatcher 物件 rd
 			errorMessage.add("IO錯誤:" + e.getMessage());
 			RequestDispatcher rd = request
 					.getRequestDispatcher(request.getContextPath()+"/partner/InsertPartnerError.jsp");
 			// 請容器代為呼叫下一棒程式
 			rd.forward(request, response);
 			return;
 		} 
		
		
	}
		

}
