package com.inspur.cyclicbarrier;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierDemo {
	
	static class Runner implements Runnable {
		
		private CyclicBarrier barrier;
		
		private String name;
		
		public Runner(CyclicBarrier barrier, String name) {
			this.barrier = barrier;
			this.name = name;
		}

		@Override
		public void run() {
			try {
				Thread.sleep(1000 * (new Random()).nextInt(5));
				System.out.println(name + "准备ok。");
				barrier.await();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(name + "Go!!!");
		}
	}
	
	public static void main(String[] args) {
		CyclicBarrier barrier = new CyclicBarrier(3);
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		executor.submit(new Thread(new Runner(barrier, "zhangsan")));
		executor.submit(new Thread(new Runner(barrier, "lisi")));
		executor.submit(new Thread(new Runner(barrier, "wangwu")));
		
		executor.shutdown();
		
		
	}

}
