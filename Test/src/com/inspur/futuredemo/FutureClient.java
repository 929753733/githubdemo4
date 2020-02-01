package com.inspur.futuredemo;

public class FutureClient {
	
	public Data request(final String queryStr) {
		System.out.println("FutureClient--1.=======");
		final FutureData futureData = new FutureData();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("FutureClient--2.=======");
				RealData realData = new RealData(queryStr);
				System.out.println("FutureClient--3.=======");
				futureData.setRealData(realData);
			}
		}).start();
		
		System.out.println("FutureClient--4.=======");
		return futureData;
		
	}

}
