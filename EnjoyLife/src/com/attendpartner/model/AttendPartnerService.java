package com.attendpartner.model;

import java.util.ArrayList;
import java.util.List;

public class AttendPartnerService {
	
	public AttendPartnerVO addattend(AttendPartnerVO attendPartnerVO){
		AttendPartnerDAO_interface dao = new AttendPartnerDAOHibernate();
		AttendPartnerVO result = dao.insert(attendPartnerVO);
		return result;
	}
	
	public List<AttendPartnerVO> findByNo(Integer eventNo){
		List<AttendPartnerVO> list = new ArrayList<AttendPartnerVO>();
		AttendPartnerDAO_interface dao = new AttendPartnerDAOHibernate();
		list = dao.selectByEventNo(eventNo);
		return list;
	}

	public List<AttendPartnerVO> findAll() {
		List<AttendPartnerVO> list = new ArrayList<AttendPartnerVO>();
		AttendPartnerDAO_interface dao = new AttendPartnerDAOHibernate();
		list = dao.getAll();
		return list;
	}
}
