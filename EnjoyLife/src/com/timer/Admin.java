package com.timer;

import java.util.Date;
import java.util.TimerTask;

import com.little.controller.LittleDaoHibernate;
import com.log.controller.AdminLogDaoHibernate;
import com.log.controller.AdminLogService;

public class Admin extends TimerTask {
	

	
	@Override
	public void run() {
		 System.out.println("admin 執行時間：" + new Date());
		 AdminLogService service=new AdminLogService();
		 
		 BugForSale bug=new BugForSale();
		 Integer nember=bug.Parsing();
		 
		 LittleDaoHibernate dao=new LittleDaoHibernate();
		 int result=dao.deleteByTime();
		 
		 service.add("小幫手", "排程器", "本機", result+"筆", "刪除");
		 
		 AdminLogDaoHibernate dao1=new AdminLogDaoHibernate();
		 int result1=dao1.deleteByTime();
		 service.add("紀錄檔", "排程器", "本機", result1+"筆", "刪除");
		 
		 System.out.println("admin 執行結束：" + new Date());
		 
	}

	
	
	
	
}
