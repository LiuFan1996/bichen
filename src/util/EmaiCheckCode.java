package util;

import java.util.Random;

/** ��̬��ȡ4λ������֤��*/
public class EmaiCheckCode {

	public static String getEmaiCheckCode(){
		String result="";
		Random ran=new Random();
		for(int i=0;i<4;i++){
			int rNum=ran.nextInt(10);
			result=result+rNum;
		}
		return result;
	}
}
