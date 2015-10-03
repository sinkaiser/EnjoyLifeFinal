package com.timer;

import java.util.Date;
import java.util.TimerTask;

import com.little.controller.LittleDaoHibernate;

public class Admin extends TimerTask {
	

	
	@Override
	public void run() {
		 System.out.println("admin 執行時間：" + new Date());
		 
		 BugForSale bug=new BugForSale();
		 Integer nember=bug.Parsing();
		 
		 
		 LittleDaoHibernate dao=new LittleDaoHibernate();
		 dao.deleteByTime();
		 
		 System.out.println("admin 執行結束：" + new Date());
		 
	}

	
	
	
	
}
