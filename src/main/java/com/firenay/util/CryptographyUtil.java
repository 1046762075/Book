package com.firenay.util;


import org.apache.shiro.crypto.hash.Md5Hash;

public class CryptographyUtil {
	
	public static void main(String[] args) throws Exception {
	 System.out.println(md5("1","chenhao"));
	}
	
	
	public static String md5(String str,String salt){
		return new Md5Hash(str,salt).toString();
	}
	
}
