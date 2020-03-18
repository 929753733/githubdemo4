package com.inspur.threadtest;

public class ThreadLocalDemo {

	public static void main(String[] args) {
		
		for (int i = 0; i < 5; i++) {
			Thread thread = new Thread(new Runnable() {
				
				@Override
				public void run() {
					ThreadLocal<String> threadLocal = new ThreadLocal<String>();
					threadLocal.set(Thread.currentThread().getName());
					System.out.println(threadLocal.get());
				}
			}, "thread" + i);
			thread.start();
		}
		
		System.out.println();

	}

}
