package com.attendpartner.model;

import java.util.List;

public interface AttendPartnerDAO_interface {
	public AttendPartnerVO insert(AttendPartnerVO attendPartnerVO);
	public AttendPartnerVO update(AttendPartnerVO attendPartnerVO);
	public AttendPartnerVO attend(AttendPartnerVO attendPartnerVO);
	public List<AttendPartnerVO> selectByEventNoPartner(Integer eventNo,String partner);
	public List<AttendPartnerVO> selectByEventNo(Integer eventNo);
	public List<AttendPartnerVO> selectByEventNoAttend(Integer eventNo);
	public List<AttendPartnerVO> getAll();
}
