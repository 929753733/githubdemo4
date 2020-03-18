package com.inspur.gongxiang;

import java.util.HashMap;

public class BDemo {
	
	private HashMap<String, Object> hashMap = new HashMap<String, Object>();
	
	public void setHashMap(HashMap<String, Object> hashMap) {
		this.hashMap = hashMap;
	}
	
	public void putHashMap() {
		hashMap.put("a", "aaaaa");
	}

}
