package com.AttracAction;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;

public class Compressionbase64 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	public String Compression(String base64){
		String base64pic = null;
		ByteArrayOutputStream baos = null;
		try {
			int first = base64.indexOf(",");
			String picbase = base64.substring(first + 1);
			byte[] source = Base64.decodeBase64(picbase);
			InputStream ins = new ByteArrayInputStream(source);
			BufferedImage bufferedImage = ImageIO.read(ins);
			double w = bufferedImage.getWidth();
			double h = bufferedImage.getHeight();
			int dw = 300; //指定壓縮大小 w爲300
			int dh = (int) (300 / (w / h));
			BufferedImage tag = new BufferedImage(dw, dh, BufferedImage.TYPE_INT_RGB);
			tag.getGraphics().drawImage(bufferedImage.getScaledInstance(dw, dh, Image.SCALE_SMOOTH), 0, 0, null);
			baos = new ByteArrayOutputStream();
			ImageIO.write(tag, "jpg", baos);
			base64pic = "data:image/jpeg;base64,";
			baos.flush();
			byte[] originalImgByte = baos.toByteArray();
			base64pic = base64pic + Base64.encodeBase64String(originalImgByte);
			baos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return base64pic;	
	}
	
	public byte[] CompressionUserimg(byte[] source){
		byte[] originalImgByte = null;
		ByteArrayOutputStream baos = null;
		try {
			InputStream ins = new ByteArrayInputStream(source);
			BufferedImage bufferedImage = ImageIO.read(ins);
			double w = bufferedImage.getWidth();
			double h = bufferedImage.getHeight();
			int dw = 100; //指定壓縮大小 w爲300
			int dh = (int) (100 / (w / h));
			BufferedImage tag = new BufferedImage(dw, dh, BufferedImage.TYPE_INT_RGB);
			tag.getGraphics().drawImage(bufferedImage.getScaledInstance(dw, dh, Image.SCALE_SMOOTH), 0, 0, null);
			baos = new ByteArrayOutputStream();
			ImageIO.write(tag, "jpg", baos);
			baos.flush();
			originalImgByte = baos.toByteArray();
			baos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return originalImgByte;	
	}
}
