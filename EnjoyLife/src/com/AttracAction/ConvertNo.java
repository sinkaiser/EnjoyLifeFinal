package com.AttracAction;

import java.io.File;
import java.net.URI;
import java.util.Scanner;

import org.json.JSONObject;



public class ConvertNo {

	public static void main(String[] args) {
		ConvertNo conv =new ConvertNo();
		System.out.println(conv.ConvertInt("新北市", "新北市"));
		System.out.println(conv.ConvertInt("景點", "景點"));
		System.out.println(conv.ConvertStr("101", "101"));
		System.out.println(conv.ConvertStr("102", "102"));
	}

	public Integer ConvertInt(String para1,String para2) {
		StringBuilder buffer = null;
		Scanner scanner = null;
        try {
			URI uri = ConvertNo.class.getResource("convertno.json").toURI();
			File openfile = new File(uri);
			buffer = new StringBuilder();
			scanner = new Scanner(openfile, "utf-8");		
			while (scanner.hasNextLine()) {
				buffer.append(scanner.nextLine());
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			scanner.close();
		}
		String temp=buffer.toString();
		temp=temp.substring(temp.indexOf("{"));
        JSONObject obj = new JSONObject(temp);
        int num=0;
        
        String str=obj.get(para1).toString();
        JSONObject obj2 = new JSONObject(str);
        if(para1.equalsIgnoreCase(para2)){
        		num=obj2.getInt(para1);
        	 //num=Integer.parseInt(obj2.get(para1).toString()); 
        }else{
        	if(para2!=null){
        		num=obj2.getInt(para2);
        		//num =Integer.parseInt(obj2.get(para2).toString());
        	}else{
        		num=obj2.getInt(para1)/10;
        		//num =Integer.parseInt(obj2.get(para1).toString())/10; 
        	}      	
        }
		return num;	
	}

	public String ConvertStr(String para1,String para2) {
		StringBuilder buffer = null;
		Scanner scanner = null;
        try {
			URI uri = ConvertNo.class.getResource("convertno.json").toURI();
			File openfile = new File(uri);
			buffer = new StringBuilder();
			scanner = new Scanner(openfile, "utf-8");		
			while (scanner.hasNextLine()) {
				buffer.append(scanner.nextLine());
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			scanner.close();
		}
		String temp=buffer.toString();
		temp=temp.substring(temp.indexOf("{"));
        JSONObject obj = new JSONObject(temp);
        String name=null;
        String str=obj.get(para1).toString();
        JSONObject obj2 = new JSONObject(str);
        if(para1.equalsIgnoreCase(para2)){
        	name=obj2.getString(para1); 
        }else{
        	if(para2!=null){
        		name=obj2.getString(para2);       		
        	}else{
        		//num =Integer.parseInt(obj2.get(para1).toString())/10; 
        	}      	
        }
		return name;	
	}
}
