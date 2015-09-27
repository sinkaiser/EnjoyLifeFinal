package com.partner.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.partner.model.PartnerService;
import com.partner.model.PartnerVO;

@WebServlet("/partner/DeleteEventServlet")
public class DeleteEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PartnerVO partnerVO = new PartnerVO();
		// 定義存放錯誤訊息的 Collection物件
		Collection<String> errorMessage = new ArrayList<String>();
		request.setAttribute("ErrorMsg", errorMessage);

		// 設定輸入資料的編碼
		request.setCharacterEncoding("UTF-8");
		
		
		String eventNo = request.getParameter("eno");
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
		
		// MemberBean 扮演封裝輸入資料的角色
		
		partnerVO.setEventNo(i);
		
		try {
			PartnerService mfio = new PartnerService();
			mfio.deleteEvent(i);
			request.setAttribute("partnerBean", partnerVO);
			// 依照執行的結果挑選適當的view元件，送回相關訊息
			// 產生 RequestDispatcher 物件 rd
			RequestDispatcher rd = request
					.getRequestDispatcher("UpdatePartnerSuccess.jsp");
			// 請容器代為呼叫下一棒程式
			rd.forward(request, response);
			return;
		} catch (IOException e) {
			// 依照執行的結果挑選適當的view元件，送回相關訊息
			// 產生 RequestDispatcher 物件 rd
			errorMessage.add("IO錯誤:" + e.getMessage());
			RequestDispatcher rd = request
					.getRequestDispatcher("/partner/InsertPartnerError.jsp");
			// 請容器代為呼叫下一棒程式
			rd.forward(request, response);
			return;
		}
	}
		
		
}
