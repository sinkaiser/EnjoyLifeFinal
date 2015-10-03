package com.timer;

import java.util.Date;
import java.util.TimerTask;

public class Sys extends TimerTask {

	@Override
	public void run() {
		 System.out.println("Sys 執行時間：" + new Date());
		 
		 System.out.println("Sys 執行結束等候1天：" + new Date());
	}

	
	
	
	
}
