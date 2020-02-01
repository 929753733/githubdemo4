package com.inspur.threadtest;

public class ThreadDemo extends Thread {
	
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(i);
		}
	}
	
	public static void main(String[] args) {
		ThreadDemo threadDemo = new ThreadDemo();
		ThreadDemo2 threadDemo2 = new ThreadDemo2();
		threadDemo.start();
		threadDemo2.start();
	}
	
}

class ThreadDemo2 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("================"+i);
		}
	}
}


