package com.th.util;


import org.apache.shiro.crypto.hash.Md5Hash;

public class CryptographyUtil {
	
	public static void main(String[] args){
		System.out.println(md5("admin","th"));
	}
	
	public static String md5(String str,String salt){
		return new Md5Hash(str, salt).toString();
	}
}
