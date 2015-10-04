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
import javax.websocket.Session;

import com.attendpartner.model.AttendPartnerDAO;
import com.attendpartner.model.AttendPartnerDAO_interface;
import com.attendpartner.model.AttendPartnerVO;
import com.member.model.MemberDAO;
import com.member.model.MemberDAO_interface;
import com.member.model.MemberVO;
import com.partner.model.PartnerService;
import com.partner.model.PartnerVO;

@WebServlet("/partner/CloseEventServlet")
public class CloseEventServlet extends HttpServlet {
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
		
		String eventNo = request.getParameter("eno3");
		if (eventNo == null || eventNo.trim().length() == 0) {
			errorMessage.add("必須輸入編號");
		}
		
		String partner = request.getParameter("partner");
		
		
		// 如果有錯誤，呼叫view元件，送回錯誤訊息
		if (!errorMessage.isEmpty()) {
			RequestDispatcher rd = request
					.getRequestDispatcher("InsertPartnerError.jsp");
			rd.forward(request, response);
			return;
		}
					
		Integer ieventNo = Integer.parseInt(eventNo);
		
 		
 		PartnerVO partnerVO = new PartnerVO();
 		partnerVO.setEventNo(ieventNo);
 		
 		response.setContentType("text/html; charset=UTF-8");
 		
 		
 		AttendPartnerVO attendPartnerVO = new AttendPartnerVO();
 		attendPartnerVO.setEventNo(ieventNo);
 		attendPartnerVO.setPartner(partner);
 		
 		AttendPartnerDAO_interface dao = new AttendPartnerDAO();
 		//AttendPartnerService apservice = new AttendPartnerService();
 		dao.attend(attendPartnerVO);
 		
 		
 		
 		PartnerService service = new PartnerService();
 		PartnerVO result = service.closeEvent(partnerVO);
 		
 		if(result==null){
			response.getWriter().write("已替您自動回覆");
			return;

	    }else{
			response.getWriter().write("網路傳輸速度緩慢");
			return;
		}
 		
 		
// 		try {
// 			PartnerService service = new PartnerService();
// 			List<PartnerVO> vo = (List<PartnerVO>) service.findByNo(Integer.parseInt(eventNo));
// 			
// 			
// 			MemberDAO_interface dao = new MemberDAO();
//			service.closeEvent(partnerVO);
//			System.out.println(partnerVO.getMemberId());
//			Map<String,Object> map = new HashMap<String,Object>();
//			MemberVO a=dao.SelectById(vo.get(0).getMemberId());
//			int imgNo=a.getPicture();
//			map.put("PartnerVO",partnerVO);
//			map.put("imgNo",imgNo);
// 			
// 			
// 			
// 			
// 			
// 			//mfio.hiddenEvent(partnerVO);
// 			request.setAttribute("partnerBean", map);
// 			// 依照執行的結果挑選適當的view元件，送回相關訊息
// 			// 產生 RequestDispatcher 物件 rd
//// 			RequestDispatcher rd = request
//// 					.getRequestDispatcher("ShowAllPartnerServlet");
//// 			// 請容器代為呼叫下一棒程式
//// 			rd.forward(request, response);
// 			response.sendRedirect(request.getContextPath()+"/partner/ShowAllPartnerServlet");
// 			return;
// 		} catch (IOException e) {
// 			// 依照執行的結果挑選適當的view元件，送回相關訊息
// 			// 產生 RequestDispatcher 物件 rd
// 			errorMessage.add("IO錯誤:" + e.getMessage());
// 			RequestDispatcher rd = request
// 					.getRequestDispatcher("/partner/InsertPartnerError.jsp");
// 			// 請容器代為呼叫下一棒程式
// 			rd.forward(request, response);
// 			return;
// 		} 
	}
		

}
