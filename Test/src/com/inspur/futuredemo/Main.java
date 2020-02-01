package com.inspur.futuredemo;


public class Main {
	public static void main(String[] args) {
		System.out.println("1========");
		FutureClient fc = new FutureClient();
		System.out.println("2========");
		Data data = fc.request("请求参数");
		System.out.println("3========");
		System.out.println("请求发送成功！");
		System.out.println("4========");
		System.out.println("做其他的事情。。。");
		
		System.out.println("5========");
		String result = data.getRequest();
		System.out.println("6========");
		System.out.println(result);
	}

}
