package com.partner.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.member.model.MemberDAO;
import com.member.model.MemberDAO_interface;
import com.member.model.MemberVO;
import com.partner.model.PartnerService;
import com.partner.model.PartnerVO;

@WebServlet("/partner/UpdateEventServlet")
public class UpdateEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// 定義存放錯誤訊息的 Collection物件
		Collection<String> errorMessage = new ArrayList<String>();
		request.setAttribute("ErrorMsg", errorMessage);

		// 設定輸入資料的編碼
		request.setCharacterEncoding("UTF-8");
		// 讀取使用者所輸入，由瀏覽器送來的 type 欄位內的資料
		String eventType = request.getParameter("type2");

		// 讀取使用者所輸入，由瀏覽器送來的 title 欄位內的資料
		String eventTitle = request.getParameter("title2");
		// 檢查使用者所輸入的資料
		if (eventTitle == null || eventTitle.trim().length() == 0) {
			errorMessage.add("必須輸入標題");
		}
		// 讀取使用者所輸入，由瀏覽器送來的 content 欄位內的資料
		String eventContent = request.getParameter("content2");
		// 檢查使用者所輸入的資料
		if (eventContent == null || eventContent.trim().length() == 0) {
			errorMessage.add("必須輸入內文");
		}
		// 讀取使用者所輸入，由瀏覽器送來的 address 欄位內的資料
		String addr = request.getParameter("address2");
		// 檢查使用者所輸入的資料
		if (addr == null || addr.trim().length() == 0) {
			errorMessage.add("地址欄必須輸入");
		}
		

		//Timestamp eventDate = new Timestamp(System.currentTimeMillis());
		Timestamp modifyDate = new Timestamp(System.currentTimeMillis());
		
		HttpSession session=(HttpSession)request.getSession();
//		session.setAttribute("memberId", "joe");
//		String memberId=(String) session.getAttribute("memberId");
		MemberVO bean=(MemberVO) session.getAttribute("member");
		String memberId = bean.getMemberId();
		
		int hidden = 0;
		int closed = 0;
		
		String eventNo = request.getParameter("eno2");
		if (eventNo == null || eventNo.trim().length() == 0) {
			errorMessage.add("必須輸入事件編號");
		}
		
		
		// 如果有錯誤，呼叫view元件，送回錯誤訊息
		if (!errorMessage.isEmpty()) {
			RequestDispatcher rd = request
					.getRequestDispatcher("InsertPartnerError.jsp");
			rd.forward(request, response);
			return;
		}

		int i = Integer.parseInt(eventNo);
		
		// MemberBean 扮演封裝輸入資料的角色
		PartnerVO partnerVO = new PartnerVO();
		partnerVO.setEventNo(i);
		partnerVO.setEventType(eventType);
		partnerVO.setEventTitle(eventTitle);
		partnerVO.setEventContent(eventContent);
		partnerVO.setAddr(addr);
		partnerVO.setModifyDate(modifyDate);
		partnerVO.setMemberId(memberId);
		partnerVO.setHidden(hidden);
		partnerVO.setClosed(closed);
		
		try {
			PartnerService service = new PartnerService();
			
			
			MemberDAO_interface dao = new MemberDAO();
			service.updateEvent(partnerVO);
			
			Map<String,Object> map = new HashMap<String,Object>();
			MemberVO a=dao.SelectById(partnerVO.getMemberId());
			int imgNo=a.getPicture();
			map.put("PartnerVO",partnerVO);
			map.put("imgNo",imgNo);
				
			
			
			
			
			
			
			
			
			
			//mfio.updateEvent(partnerVO);
			request.setAttribute("partnerBean", map);
			// 依照執行的結果挑選適當的view元件，送回相關訊息
			// 產生 RequestDispatcher 物件 rd
//			RequestDispatcher rd = request
//					.getRequestDispatcher("UpdatePartnerSuccess.jsp");
			// 請容器代為呼叫下一棒程式
//			rd.forward(request, response);
			response.sendRedirect(request.getContextPath()+"/partner/ShowAllPartnerServlet");
			return;
		} catch (IOException e) {
			// 依照執行的結果挑選適當的view元件，送回相關訊息
			// 產生 RequestDispatcher 物件 rd
			errorMessage.add("IO錯誤:" + e.getMessage());
			RequestDispatcher rd = request
					.getRequestDispatcher("InsertPartnerError.jsp");
			// 請容器代為呼叫下一棒程式
			rd.forward(request, response);
			return;
		}
	}
		
		
	

}
