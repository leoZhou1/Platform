package com.website.platform.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

import com.aliyun.oss.OSSClient;

public class ImageUtils {
private final static Pattern pattern = Pattern.compile("jpeg|jpg|gif|png");
	
	public static void main(String[] args) throws IOException {
		//图片URL转成img
//		String urlString = "http://static-medialab.oss-cn-hangzhou.aliyuncs.com/ddae07c8-59f9-4f62-8960-804ba7e16899.jpeg";
//		URL url = new URL(urlString);
//		URLConnection con = url.openConnection();
//		con.setConnectTimeout(5*1000);
//		InputStream is = con.getInputStream();
//		
//		Matcher m = pattern.matcher(urlString);
//		String postfix = "jpg";
//		if(m.find()){
//			postfix = m.group(0);
//		}
//		
//		Image srcImg = ImageIO.read(is);
//		
//		int srcImgWidth = srcImg.getWidth(null);
//		int maxWidth = 700;
//		if(srcImgWidth>700){
//			int srcImgHeight = srcImg.getHeight(null);
//			
//			int maxHeight = srcImgHeight*maxWidth/srcImgWidth;
//			//对img压缩成targetImg，按比例压缩
//			BufferedImage image = new BufferedImage(maxWidth, maxHeight,BufferedImage.TYPE_INT_RGB ); 
//			image.getGraphics().drawImage(srcImg, 0, 0, maxWidth, maxHeight, null); // 绘制缩小后的图
//			
//			//targetImg转成InputStream
//			
//			
//			ByteArrayOutputStream baOut = new ByteArrayOutputStream();
//			
//			ImageOutputStream imgOut = ImageIO.createImageOutputStream(baOut);
//			
//			ImageIO.write(image, postfix, imgOut);
//			
//			InputStream targetIs = new ByteArrayInputStream(baOut.toByteArray());
//			
//			is = targetIs;
//		}
//		
//		//调用阿里接口
//		String pic = UUID.randomUUID().toString();
//		System.out.println(DOMAIN+"/"+pic + "." + postfix);
//		ossClient.putObject(BUCKET, pic + "." + postfix, is );
	}
	
	public static String resizeUpload(String imgUrl,OSSClient ossClient,String bucket){
		String picPath = "";
		try {
			//图片URL转成img
			URL url = new URL(imgUrl);
			URLConnection con = url.openConnection();
			con.setConnectTimeout(5*1000);
			InputStream is = con.getInputStream();
			
			Matcher m = pattern.matcher(imgUrl);
			String postfix = "jpg";
			if(m.find()){
				postfix = m.group(0);
			}
			
			Image srcImg = ImageIO.read(is);
			
			int srcImgWidth = srcImg.getWidth(null);
			int maxWidth = 700;
			
			if(srcImgWidth>700){
				int srcImgHeight = srcImg.getHeight(null);
				
				int maxHeight = srcImgHeight*maxWidth/srcImgWidth;
				//对img压缩成targetImg，按比例压缩
				BufferedImage image = new BufferedImage(maxWidth, maxHeight,BufferedImage.TYPE_INT_RGB ); 
				image.getGraphics().drawImage(srcImg, 0, 0, maxWidth, maxHeight, null); // 绘制缩小后的图
				
				//targetImg转成InputStream
				
				ByteArrayOutputStream baOut = new ByteArrayOutputStream();
				
				ImageOutputStream imgOut = ImageIO.createImageOutputStream(baOut);
				
				ImageIO.write(image, postfix, imgOut);
				
				InputStream targetIs = new ByteArrayInputStream(baOut.toByteArray());
				
				is = targetIs;
			}
			
			//调用阿里接口
			String pic = UUID.randomUUID().toString();
			ossClient.putObject(bucket, pic + "." + postfix, is );
			picPath = pic + "." + postfix;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return picPath;
	}
	
	/**
	 * 强制压缩/放大图片到固定的大小
	 * @param w int 新宽度
	 * @param h int 新高度
	 */
	public void resize(int w, int h) throws IOException {
		// SCALE_SMOOTH 的缩略算法 生成缩略图片的平滑度的 优先级比速度高 生成的图片质量比较好 但速度慢
//		BufferedImage image = new BufferedImage(w, h,BufferedImage.TYPE_INT_RGB ); 
//		image.getGraphics().drawImage(img, 0, 0, w, h, null); // 绘制缩小后的图
//		File destFile = new File("C:\\Users\\zhouli\\Desktop\\456.jpg");
//		FileOutputStream out = new FileOutputStream(destFile); // 输出到文件流
//		// 可以正常实现bmp、png、gif转jpg
//		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
//		encoder.encode(image); // JPEG编码
//		out.close();
		
	}
}
