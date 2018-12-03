package util;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**Cookie������ */
public class CookieUtils {
	private static String default_path="/dangdang/";
	private static int default_age=7*24*3600; //��������7��
	/**���Cookie����:����ʹ��utf8 */
	public static void addCookie(String name,String value,
			            HttpServletResponse response,int MaxAge){
		try {
			//����
			value=URLEncoder.encode(value, "utf8");
			//����Cookie����
			Cookie c=new Cookie(name,value);
			//����Cookie����ʱ��
			c.setMaxAge(MaxAge);
			//����Cookie·��
			c.setPath(default_path);
			//ͨ��response��Cookieд�������
			response.addCookie(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**���Cookie���� */
	public static void addCookie(String name,String value,HttpServletResponse response){ 
		addCookie(name,value,response,default_age);
	}
	
	/**����ָ����Cookie */
	public static Cookie findCookie(String name,HttpServletRequest request){
		Cookie[] cookies = request.getCookies();
		if(cookies==null)return null;
		for(Cookie c:cookies){
			if(c.getName().equals(name)){
				return c;
			}
		}
		return null;
	}
	
	/**ɾ��ָ����Cookie */
	public static void deleteCookie(String name,HttpServletRequest request,HttpServletResponse response){
		//��ȥ���ҵ�ָ����Cookie
		Cookie cookie = findCookie(name,request);
		//ɾ��
		if(cookie!=null){
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
	}
}
