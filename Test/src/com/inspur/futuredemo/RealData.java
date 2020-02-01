package com.inspur.futuredemo;

public class RealData implements Data {
	
	private String result;
	
	public RealData(String queryStr) {
		System.out.println("这是RealData的构造方法。。。");
		System.out.println("根据" + queryStr + "进行查询，这是一个很耗时的操作。。。");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("操作完毕，获取结果！");
		result = "查询结果";
	}

	@Override
	public String getRequest() {
		System.out.println("这是RealData的getRequest方法。。。");
		return result;
	}
	

}
