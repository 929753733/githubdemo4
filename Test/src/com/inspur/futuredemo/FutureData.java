package com.inspur.futuredemo;

public class FutureData implements Data {
	
	private RealData realData;
	
	private boolean isReady = false;
	
	public synchronized void setRealData(RealData realData) {
		System.out.println("开始执行FutureData的setRealData方法。。。");
		if(isReady) {
			System.out.println("isReady");
			return;
		}
		
		this.realData = realData;
		isReady = true;
		System.out.println("准备进入notify");
		notify();
	}

	@Override
	public synchronized String getRequest() {
		System.out.println("这是FutureData的getRequest方法。。。");
		while(!isReady) {
			try {
				System.out.println("这是FutureData的wait方法。。。");
				wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("FutureData---1.===============");
		return this.realData.getRequest();
	}

}
