package com.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImgListService {
	
	public String select(String path,int id){
	 ImgListDao dao=new ImgListDaoHibernate();
	 ImgListBean bean=new ImgListBean();
	 
	 String type=dao.selectType(id);
	 if(type==null){
		 return "errorimg";
	 }
   	 path=path+"image";
//   	 System.out.println(path);
   	 File f = new File(path);
   	 File file = new File(path+"\\"+id+"."+type);
   	 	 
   	 	
		 if (!f.exists()) {
			f.mkdirs();
		 }
			
		 if(!file.exists()){
			try {
				
				bean=dao.select(id);
				byte[] data=bean.getImgContent();
				FileOutputStream fos=new FileOutputStream(file);
				try {
					fos.write(data);
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
//				System.out.println("創立");
				return "image\\"+id+"."+type;
				
			} catch (FileNotFoundException e) {
					e.printStackTrace();
			}	
		}else{
//			System.out.println("存在");
			
		}
		 return "image\\"+id+"."+type;
	}

}
