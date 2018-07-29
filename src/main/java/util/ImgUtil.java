package util;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

public class ImgUtil {

	//å›¾ç‰‡è½¬æ�¢æˆ�base64å­—ç¬¦
    public static String imgUrl2String(String imgUrl) {
    	String line=null;
    	InputStream in=null;
    	try {
    		in= new FileInputStream(imgUrl);
    		byte[] b=new byte[in.available()];
    		in.read(b);
    		line=Base64.getEncoder().encodeToString(b);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
        return line;
    }
    //å›¾ç‰‡è½¬æ�¢æˆ�base64å­—ç¬¦
    public static String img2String(InputStream in) {
    	String line=null;
    	try {
    		byte[] b=new byte[in.available()];
    		in.read(b);
    		line=Base64.getEncoder().encodeToString(b);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
    	return line;
    }
    
    //base64è½¬æ�¢æˆ�äºŒè¿›åˆ¶æµ�
    public static byte[] string2Img(String img) {
    	byte[] bs=null;
    	try {
    		bs = Base64.getDecoder().decode(img);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
		}
		return bs;
    }
}
