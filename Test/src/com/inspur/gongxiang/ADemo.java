package com.inspur.gongxiang;

import java.util.HashMap;

public class ADemo {
	
	public static HashMap<String, Object> hashMap = new HashMap<String, Object>();
	
	
	public static void main(String[] args) {
		BDemo bDemo = new BDemo();
		bDemo.setHashMap(hashMap);
		bDemo.putHashMap();
		System.out.println(hashMap);
		
	}
}
