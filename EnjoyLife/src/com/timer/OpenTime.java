package com.timer;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class OpenTime {

	
	public void systemdo(){
			Timer timer = new Timer();

			Sys sys=new Sys();
			System.out.println("1天後開始");
			
		    timer.schedule(sys, 1000*60*60*24 , 1000*60*60*24);
		    
		    

		    };
	public void admindo(){
		Timer timer = new Timer();
		Admin adm=new Admin();
		
		timer.schedule(adm, 3000);
	  	
	    };
	

}
