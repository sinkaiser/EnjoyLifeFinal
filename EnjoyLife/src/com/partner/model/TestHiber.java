package com.partner.model;

public class TestHiber {

	public static void main(String[] args) {

		
		PartnerVO partnerVO = new PartnerVO();
		
		
		
		partnerVO.setEventType("1");
 		partnerVO.setEventTitle("1");
 		partnerVO.setEventContent("1");
 		partnerVO.setAddr("1");
 		partnerVO.setEventDate(new java.sql.Timestamp(0));
 		partnerVO.setModifyDate(new java.sql.Timestamp(0));
 		partnerVO.setImgNo(2);
 		partnerVO.setMemberId("1");
 		partnerVO.setHidden(1);
 		partnerVO.setClosed(1);
		
		PartnerService service = new PartnerService();
		service.addNewEvent(partnerVO);
	}

}
