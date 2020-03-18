package com.inspur.SychronizedAndLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SychronizedAndLock {
	
	private int value = 0;
	Lock lock = new ReentrantLock();
	
	synchronized void addValueSync() {
		this.value++;
		System.out.println(Thread.currentThread().getName() + ":" + value);
	}
	
	void addValueLock() {
		try {
			lock.lock();
			this.value++;
			System.out.println(Thread.currentThread().getName() + ":" + value);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	
	public static void main(String[] args) {
		SychronizedAndLock sychronizedAndLock = new SychronizedAndLock();
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					sychronizedAndLock.addValueSync();
				}
			}
		}, "线程1");
		
		Thread thread2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					sychronizedAndLock.addValueLock();
				}
			}
		}, "线程2");
		
		thread1.start();
		thread2.start();
	}
	
	

}
