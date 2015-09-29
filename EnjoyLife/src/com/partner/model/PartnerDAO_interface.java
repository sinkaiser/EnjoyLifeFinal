package com.partner.model;

import java.util.*;

public interface PartnerDAO_interface {
          public PartnerVO insert(PartnerVO partnerVO);
          public PartnerVO update(PartnerVO partnerVO);
          public boolean delete(Integer eventNo);
          public PartnerVO hidden(PartnerVO partnerVO);
          public List<PartnerVO> selectByEventNo(Integer eventNo);
          public List<PartnerVO> selectById(String memberId);
          public List<PartnerVO> selectByIdOver(String memberId);
          public List<PartnerVO> selectByEventType(String eventType);
          public List<PartnerVO> selectByEventTitleAndEventContent(String eventContent);
          public List<PartnerVO> getAll();
          public List<PartnerVO> getAllAdmin();
          public List<PartnerVO> selectByIndex(int index);
}
