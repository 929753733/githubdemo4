package com.inspur.threadtest;

public class RunnableDemo implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(i);
		}
	}
	
	
	public static void main(String[] args) {
		ThreadDemo threadDemo = new ThreadDemo();
		Thread thread = new Thread(threadDemo);
		thread.start();
	}

}
