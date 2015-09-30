package com.AttracAction;


import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import javax.imageio.ImageIO;
import org.apache.commons.codec.binary.Base64;




public class ConvertToBase64 {

	public static void main(String[] args) {
		String link="http://www.travel.taipei/d_upload_ttn/sceneadmin/image/A0/B0/C0/D5/E228/F807/d03544a9-c70a-4f10-a0a9-35769b6155a7.gif";
		String link2="http://www.travel.taipei/d_upload_ttn/sceneadmin/image/A0/B0/C0/D0/E197/F470/887da79a-7790-423c-84e3-2c35e5784256.jpg";
		String link3="https://upload.wikimedia.org/wikipedia/commons/4/47/PNG_transparency_demonstration_1.png";
		ConvertToBase64 convert = new ConvertToBase64();
		String base64=convert.Convert(link);
		System.out.println(base64);
	}

	public String Convert(String link){
			URL urllink = null;		
            String base64pic=null;	
            ByteArrayOutputStream baos=null;
            try {
				urllink = new URL(link);	
				System.out.println("Get connect begain");
				InputStream ins =urllink.openConnection().getInputStream();
				System.out.println("Get connect finish");
				BufferedImage bufferedImage = ImageIO.read(ins);
				
				double w=bufferedImage.getWidth();
				double h=bufferedImage.getHeight();
				int dw=500;          //指定壓縮大小 w爲500
			    int dh=(int) (500/(w/h));
			    BufferedImage tag= new BufferedImage(dw,dh,BufferedImage.TYPE_INT_RGB); 
		        tag.getGraphics().drawImage(bufferedImage.getScaledInstance(dw, dh, Image.SCALE_SMOOTH), 0, 0,  null);
				
				baos = new ByteArrayOutputStream();
				if(link.toLowerCase().indexOf("jpg")!=-1||link.toLowerCase().indexOf("jpeg")!=-1){
					ImageIO.write(tag, "jpg", baos);
					base64pic = "data:image/jpeg;base64,";					
				}else if(link.toLowerCase().indexOf("png")!=-1){
					ImageIO.write(tag, "png", baos);
					base64pic = "data:image/png;base64,";					
				}else if(link.toLowerCase().indexOf("gif")!=-1){
					ImageIO.write(tag, "gif", baos);
					base64pic = "data:image/gif;base64,";
				}
	            baos.flush();
	            byte[] originalImgByte = baos.toByteArray();
	            System.out.println("Pic encode begain");
	            base64pic=base64pic+Base64.encodeBase64String(originalImgByte);
	            System.out.println("Pic encode finish");
	            baos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}		
            return base64pic;		
	}
}
