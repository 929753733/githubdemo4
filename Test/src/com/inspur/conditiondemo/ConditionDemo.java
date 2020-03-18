package com.inspur.conditiondemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionDemo {
	
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	
	public void method1() {
		try {
			lock.lock();
			System.out.println("method1开始执行。。。");
			condition.await();
			System.out.println("method1结束执行。。。");
		} catch (Exception e) {
		} finally {
			lock.unlock();
		}
	}
	
	public void method2() {
		try {
			lock.lock();
			System.out.println("method2开始执行。。。");
			System.out.println("method2结束执行。。。");
			condition.signal();
		} catch (Exception e) {
		} finally {
			lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		ConditionDemo conditionDemo = new ConditionDemo();
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				conditionDemo.method1();
			}
		}, "t1");
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				conditionDemo.method2();
			}
		}, "t2");
		
		
		t1.start();
		t2.start();
	}
	

}
