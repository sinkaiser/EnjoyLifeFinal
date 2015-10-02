package com.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ParseXXX {

	public Integer parseInt(String xxx){
		Integer result=0;
		try {
			result=Integer.parseInt(xxx);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return -1000;
		}
		return result; 
	}
	
	public java.util.Date parseDate(String xxx){
		java.util.Date result=null;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
		try {
			result = sdf.parse(xxx);
		} catch (ParseException e) {
			e.printStackTrace();
			return new java.util.Date(0);
		}
		
		return result;
	}
	
}
