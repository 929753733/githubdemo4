package com.inspur.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
	
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		final Semaphore semaphore = new Semaphore(5);
		
		for (int i = 0; i < 20; i++) {
			final int index = i;
			Runnable runnable = new Runnable() {
				@Override
				public void run() {
					try {
						// 获取许可
						semaphore.acquire();
						System.out.println("accessing" + index);
						// 模拟业务
						Thread.sleep((long) (Math.random() * 1000));
						// 释放
						semaphore.release();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			};
			executorService.execute(runnable);
		}
		
		try {
			Thread.sleep(10);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
